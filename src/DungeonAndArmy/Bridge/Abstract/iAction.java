package DungeonAndArmy.Bridge.Abstract;

import DungeonAndArmy.AbstractFactoryPattern.AbstractProduct.Soldier;
import javafx.scene.layout.GridPane;

import java.util.ArrayList;

public interface iAction {
    boolean paint(GridPane Board, ArrayList<String> arrCoords);
    boolean addMonster(GridPane Board, String id);
    void removeMonster(GridPane Board, String coord);
}