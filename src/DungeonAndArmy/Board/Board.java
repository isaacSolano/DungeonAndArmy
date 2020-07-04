package DungeonAndArmy.Board;

import DungeonAndArmy.Gestor.Gestor_Player;
import DungeonAndArmy.Helper.FileManager;
import DungeonAndArmy.Helper.Helper;
import DungeonAndArmy.Player.Player;
import javafx.event.ActionEvent;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.GridPane;

import java.util.Timer;
import java.util.TimerTask;

public class Board {
    public GridPane Board;
    public Button L;
    public Button Cruz;
    public Button Z;
    public Button P;
    public Button U;
    public Button T;
    public GridPane CurrentPlayer;

    private Helper helper = new Helper();
    private FileManager fileManager = new FileManager();
    private Gestor_Player gestor_player = new Gestor_Player();

    private Player playerA;
    private Player playerB;

    private int secondsPassed = 0;
    private Timer timer = new Timer();


    public TimerTask timerTask = new TimerTask() {
        @Override
        public void run() {
            if(secondsPassed >= 5){
                secondsPassed = 0;

                System.out.println((gestor_player.changePlayer(playerA,playerB)));

            }
            secondsPassed++;
        }
    };

    public void start(){
        timer.scheduleAtFixedRate(timerTask,1000,1000);
    }

    public void initialize(){
        createBoard();
        createBases();

        L.setGraphic( fileManager.getImages().get(0) );
        Cruz.setGraphic( fileManager.getImages().get(1) );
        Z.setGraphic( fileManager.getImages().get(2) );
        P.setGraphic( fileManager.getImages().get(3) );
        U.setGraphic( fileManager.getImages().get(4) );
        T.setGraphic( fileManager.getImages().get(5) );
    }

    public void createBoard(){
        for(int y = 0; y < 20; y++){
            for(int x = 0; x < 20; x++){
                Button ButtonPosition = new Button("");
                ButtonPosition.getStyleClass().add("rows");
                ButtonPosition.getStyleClass().add("natural-color");

                int finalX = x+1;
                int finalY = y+1;
                ButtonPosition.setOnAction(e -> getPosition(finalX, finalY, e) );
                Board.add(ButtonPosition, finalX, finalY);
            }
        }
    }

    public void createBases(){
        int basePosition1 = helper.getRandom(20);
        Button Base1 = new Button("X");
        Base1.getStyleClass().add("base");
        Board.add(Base1, basePosition1, 0);
        playerA = new Player("A",basePosition1);

        int basePosition2 = helper.getRandom(20);
        Button Base2 = new Button("X");
        Base2.getStyleClass().add("base");
        Board.add(Base2, basePosition2, 21);
        playerB = new Player("B",basePosition2);

        gestor_player.assingRound(playerA);
        start();
    }

    public void getPosition(int x, int y, ActionEvent e){
        Button Clicked = (Button) e.getSource();
        Clicked.getStyleClass().add("selected");
        Clicked.getStyleClass().remove("natural-color");

        System.out.println("Position x: " + x + ", position y: " + y);
    }

    public void invocarDados(ActionEvent e){
        System.out.println("Invocando dados");
    }

    public void invocarCamino(ActionEvent e){
        Button btnCamino = (Button) e.getSource();
        String idCamino = btnCamino.getId();

        System.out.println(idCamino);
        System.out.println(gestor_player.getCurrentPlayer().toString());
    }


}
