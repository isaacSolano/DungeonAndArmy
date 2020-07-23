package DungeonAndArmy.Bridge.Abstract;

import DungeonAndArmy.AbstractFactoryPattern.AbstractProduct.Soldier;
import javafx.scene.layout.GridPane;

import java.util.ArrayList;

public interface iAction {
    boolean paint(GridPane Board, ArrayList<String> arrCoords);
    void addMonster(GridPane Borad, String id);
}