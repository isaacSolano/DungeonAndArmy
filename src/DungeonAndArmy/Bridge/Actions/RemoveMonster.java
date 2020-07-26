package DungeonAndArmy.Bridge.Actions;

import DungeonAndArmy.Bridge.Abstract.iAction;
import javafx.scene.control.Button;
import javafx.scene.layout.GridPane;

import java.util.ArrayList;

public class RemoveMonster implements iAction {
    @Override
    public boolean paint(GridPane Board, ArrayList<String> arrCoords) {
        return false;
    }

    @Override
    public boolean addMonster(GridPane Board, String id) {
        return false;
    }

    @Override
    public void removeMonster(GridPane Board, String coords) {
        Button btn = (Button) Board.getScene().lookup("#" + coords);

        if(btn.getStyleClass().contains("selected")){
            btn.setGraphic(null);
        }
    }
}
