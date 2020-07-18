package DungeonAndArmy.Bridge.Actions;

import DungeonAndArmy.Bridge.Abstract.iAction;
import javafx.scene.control.Button;
import javafx.scene.layout.GridPane;

import java.util.ArrayList;

public class Activate implements iAction {
    @Override
    public void paint(GridPane Board, ArrayList<String> arrCoords) {
        for(String coord : arrCoords ){
            Button btn = (Button) Board.getScene().lookup("#" + coord);

            btn.getStyleClass().remove("natural-color");
            btn.getStyleClass().add("selected");
        }
    }

    @Override
    public void addMonster() {

    }
}
