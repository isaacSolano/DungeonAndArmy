package DungeonAndArmy.Board;

import DungeonAndArmy.Helper.FileManager;
import DungeonAndArmy.Helper.Helper;
import javafx.event.ActionEvent;
import javafx.scene.control.Button;
import javafx.scene.layout.GridPane;

public class Board {
    public GridPane Board;
    public Button L;
    public Button Cruz;
    public Button Z;
    public Button P;
    public Button U;
    public Button T;

    private Helper helper = new Helper();
    private FileManager fileManager = new FileManager();

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
                Button btnPosition = new Button("");
                btnPosition.getStyleClass().add("rows");
                btnPosition.getStyleClass().add("natural-color");

                int finalX = x+1;
                int finalY = y+1;
                btnPosition.setOnAction(e -> getPosition(finalX, finalY, e) );
                Board.add(btnPosition, finalX, finalY);
            }
        }
    }

    public void createBases(){
        Button btnBase_1 = new Button("A");
        btnBase_1.getStyleClass().add("base");
        int base1 = helper.getRandom(20);
        Board.add(btnBase_1, base1, 0);

        Button btnBase_2 = new Button("B");
        btnBase_2.getStyleClass().add("base");
        int base2 = helper.getRandom(20);
        Board.add(btnBase_2, base2, 21);

        System.out.println(base2);
        System.out.println(base1);

    }

    public void getPosition(int x, int y, ActionEvent e){
        Button Clicked = (Button) e.getSource();
        Clicked.getStyleClass().add("selected");
        Clicked.getStyleClass().remove("natural-color");

        System.out.println("Position x: " + x + ", position y: " + y);
    }

    public void invokeDice(ActionEvent e){
        System.out.println("Invoking dices");
    }

    public void invokePath(ActionEvent e){
        Button btnPath = (Button) e.getSource();
        String idPath = btnPath.getId();

        System.out.println(idPath);
    }
}
