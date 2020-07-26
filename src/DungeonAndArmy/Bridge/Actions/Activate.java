package DungeonAndArmy.Bridge.Actions;

import DungeonAndArmy.Bridge.Abstract.iAction;
import javafx.scene.control.Button;
import javafx.scene.layout.GridPane;

import java.util.ArrayList;

public class Activate implements iAction {
    @Override
    public boolean paint(GridPane Board, ArrayList<String> arrCoords) {
        boolean marked = false;


        for(String coord : arrCoords){
            Button btn = (Button) Board.getScene().lookup("#"+coord);
            if( btn.getStyleClass().contains("selected") ){
                marked = true;
                break;
            }

        }
        if(!marked){
            for(String coord : arrCoords ){
                Button btn = (Button) Board.getScene().lookup("#" + coord);

                btn.getStyleClass().remove("natural-color");
                btn.getStyleClass().add("selected");
            }
        }

        return marked;
    }

    @Override
    public boolean addMonster(GridPane Board, String id) {
        return false;
    }

    @Override
    public void removeMonster(GridPane Board, String coord) {

    }
}
