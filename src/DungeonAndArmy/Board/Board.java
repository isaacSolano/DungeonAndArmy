package DungeonAndArmy.Board;

import DungeonAndArmy.Gestor.Gestor_Path;
import DungeonAndArmy.Gestor.Gestor_Player;

import DungeonAndArmy.Helper.AlertHelper;
import DungeonAndArmy.Helper.FileManager;
import DungeonAndArmy.Helper.Helper;
import DungeonAndArmy.Helper.Path_Creator;

import DungeonAndArmy.Prototype.iPrototype.aPath;
import DungeonAndArmy.Player.Player;

import javafx.animation.Animation;
import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.event.ActionEvent;
import javafx.scene.control.*;
import javafx.scene.layout.GridPane;
import javafx.util.Duration;

import java.util.ArrayList;
import java.util.Timer;

public class Board {
    public GridPane Board, PathBox;
    public Button L, Cruz, Z, P, U, T;
    public Label txtTimer;

    private AlertHelper alertHelper = new AlertHelper();
    private Helper helper = new Helper();
    private FileManager fileManager = new FileManager();
    private Path_Creator pathCreator = new Path_Creator();

    private Gestor_Player gestor_player = new Gestor_Player();
    private Gestor_Path gestor_path = new Gestor_Path();

    private Player playerA, playerB;
    private Button btnActionPosition;

    private int secondsPassed = 0;
    private Timer timer = new Timer();

    private int pathRotation = 0;

    public void start(){
        Timeline timeline = new Timeline(new KeyFrame(Duration.seconds(1), event -> {
            if(secondsPassed >= 10){
                secondsPassed = 0;
                gestor_player.changePlayer(playerA, playerB);
            }
            txtTimer.setText("Jugador: " + gestor_player.getCurrentPlayer().getId() + ", le quedan: " + (10 - secondsPassed) + " segundos de juego");
            secondsPassed++;
        }));
        timeline.setCycleCount(Animation.INDEFINITE);
        timeline.play();
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
        for(int x = 0; x < 20; x++){
            for(int y = 0; y < 20; y++){
                Button btnPosition = new Button("");
                btnPosition.getStyleClass().add("rows");
                btnPosition.getStyleClass().add("natural-color");

                int finalX = x+1;
                int finalY = y+1;
                btnPosition.setId(finalY + "_" + finalX);
                btnPosition.setOnAction(e -> getPosition(finalY, finalX, e) );
                Board.add(btnPosition, finalX, finalY);
            }
        }
    }

    public void createBases(){
        int basePositionA = helper.getRandom(20);
        Button Base1 = new Button("A");
        Base1.getStyleClass().add("base");
        Board.add(Base1, basePositionA, 0);
        playerA = new Player("A",basePositionA);

        int basePositionB = helper.getRandom(20);
        Button Base2 = new Button("B");
        Base2.getStyleClass().add("base");
        Board.add(Base2, basePositionB, 21);
        playerB = new Player("B",basePositionB);

        gestor_player.assingRound(playerA);
        start();
    }

    public void getPosition(int x, int y, ActionEvent e){
        Button btnPosition = (Button) e.getSource();
        btnPosition.getStyleClass().remove("natural-color");
        btnPosition.getStyleClass().add("selected");

        System.out.printf(btnPosition.getId());

        btnActionPosition = btnPosition;

        PathBox.setVisible(true);
    }

    public void invokeDice(ActionEvent e){
        System.out.println("Invoking dices");
    }

    public void invokePath(ActionEvent e){
        Button btnPath = (Button) e.getSource();
        Player currPlayer = gestor_player.getCurrentPlayer();
        int basePositionY = currPlayer.getId() == "A" ? 1 : 20;

//        if(btnActionPosition[0] != currPlayer.getBasePosition() || btnActionPosition[1] != basePositionY){
        if(false){
            Alert alert = alertHelper.createErr("No se puede crear el camino", "Debe estar conectado a su base");

            alert.showAndWait();
        }else {
            ArrayList<String> arrBlocksId = pathCreator.createPath(btnPath.getId(), btnActionPosition, Board, pathRotation);

            if (arrBlocksId == null) {
                Alert alert = alertHelper.createErr("No se puede crear el camino", "No hay suficientes espacios");

                alert.showAndWait();
            } else {
                aPath path = gestor_path.createNewPath(arrBlocksId, btnPath.getId());

                System.out.println(path.toString());
            }
        }
    //        gestor_player.getCurrentPlayer();
            PathBox.setVisible(false);
    }

    public void flipPath(){
        pathRotation = pathRotation == 360 ? 90 : pathRotation+90;

        L.setRotate(pathRotation);
        Cruz.setRotate(pathRotation);
        Z.setRotate(pathRotation);
        P.setRotate(pathRotation);
        U.setRotate(pathRotation);
        T.setRotate(pathRotation);
    }
}