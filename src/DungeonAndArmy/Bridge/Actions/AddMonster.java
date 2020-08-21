package DungeonAndArmy.Bridge.Actions;

import DungeonAndArmy.Abstract_Factory.AbstractProduct.Soldier;
import DungeonAndArmy.Bridge.Abstract.iAction;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.ImageView;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.VBox;
import org.controlsfx.control.PopOver;

import java.util.ArrayList;

public class AddMonster implements iAction {
    private Soldier soldier;

    private PopOver popOver;

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

            btn.setOnMouseEntered(e -> showInfo(soldier, btn));
            btn.setOnMouseExited(e -> hideInfo());
            added = true;
        }

        return added;
    }

    @Override
    public void removeMonster(GridPane Board, String coord) {

    }

    public void showInfo(Soldier soldier, Button btn){
        Label txtName = new Label("Nombre: " + soldier.getName() ),
            txtLife = new Label( "Vida: " + soldier.getLife() ),
            txtMovement = new Label("Movimiento: " + soldier.getMove() ),
            txtAttack = new Label("Ataque: " + soldier.getAttack() ),
            txtDefense = new Label("Defensa: " + soldier.getDefense());

        VBox vBox = new VBox(txtName, txtLife, txtMovement, txtAttack, txtDefense);
        popOver = new PopOver(vBox);

        popOver.show(btn);
    }

    public void hideInfo(){
        if(popOver != null){
            popOver.hide();
        }
    }
}
