package DungeonAndArmy.Bridge.Actions;

import DungeonAndArmy.AbstractFactoryPattern.AbstractProduct.Soldier;
import DungeonAndArmy.Bridge.Abstract.iAction;
import javafx.scene.control.Button;
import javafx.scene.image.ImageView;
import javafx.scene.layout.GridPane;

import java.util.ArrayList;

public class AddMonster implements iAction {
    private Soldier soldier;

    public AddMonster(Soldier soldier){
        this.soldier = soldier;
    }

    @Override
    public boolean paint(GridPane Board, ArrayList<String> arrCoords) {
        return false;
    }

    @Override
    public boolean addMonster(GridPane Board, String id) {
        Button btn = (Button) Board.getScene().lookup("#" + id);
        boolean added = false;

        if(btn.getStyleClass().contains("selected")){
            soldier.setCoords(id);
            ImageView monsterImage = soldier.getImage();
            monsterImage.setFitWidth(20);
            monsterImage.setFitHeight(20);

            btn.setGraphic( monsterImage );
            added = true;
        }

        return added;
    }

    @Override
    public void removeMonster(GridPane Board, String coord) {

    }
}
