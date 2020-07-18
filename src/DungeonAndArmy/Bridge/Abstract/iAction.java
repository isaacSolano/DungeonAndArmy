package DungeonAndArmy.Bridge.Abstract;

import javafx.scene.layout.GridPane;

import java.util.ArrayList;

public interface iAction {
    void paint(GridPane Board, ArrayList<String> arrCoords);
    void addMonster();
}