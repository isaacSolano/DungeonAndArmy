package DungeonAndArmy.Board;

import DungeonAndArmy.AbstractFactoryPattern.AbstractProduct.Soldier;
import DungeonAndArmy.Bridge.Abstract.iShape;
import DungeonAndArmy.Gestor.Manager_Monsters;
import DungeonAndArmy.Gestor.Manager_Path;
import DungeonAndArmy.Gestor.Manager_Player;

import DungeonAndArmy.Helper.AlertHelper;
import DungeonAndArmy.Helper.FileManager;
import DungeonAndArmy.Helper.Helper;

import DungeonAndArmy.Prototype.iPrototype.aPath;
import DungeonAndArmy.Singleton.Round.Player;

import javafx.animation.Animation;
import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.event.ActionEvent;
import javafx.scene.control.*;
import javafx.scene.layout.GridPane;
import javafx.util.Duration;

import java.util.Timer;

public class Board {
    public GridPane Board, PathBox, MonsterBox, InfantryBox, ArtilleryBox, TankBox, Coffer;
    public Button L, Cruz, Z, P, U, T;
    public Button Aerys, Arryn, Arthur, Boko, Bora, Brienne, Bronn, Castlely, Forerunner, Glognar, Helms, Obara, Rhageon, Siddon, Varys;
    public Button Infantry, Artillery, Tanks;
    public Button movementOption, attackOption, summonOption, specialOption;
    public Label txtTimer;
    public Label movementLabel, attackLabel, specialLabel, summonLabel;

    private AlertHelper alertHelper = new AlertHelper();
    private Helper helper = new Helper();
    private FileManager fileManager = new FileManager();

    private Manager_Player manager_player = new Manager_Player();
    private Manager_Path manager_path = new Manager_Path();
    private Manager_Monsters manager_monsters = new Manager_Monsters();

    private Player playerA, playerB;
    private Integer[] actionPosition = new Integer[2];

    private int secondsPassed = 0;
    private Timer timer = new Timer();

    private int pathRotation = 0;
    private Soldier bAddMonster = null;
    private Soldier moveSoldier = null;
    private boolean bMoveMonsterInit = false;
    private boolean bMoveMonsterEnd = false;

    public void start(){
        Timeline timeline = new Timeline(new KeyFrame(Duration.seconds(1), event -> {
            if(secondsPassed >= 10){
                secondsPassed = 0;
                manager_player.changePlayer(playerA, playerB);
                bAddMonster = null;
            }
            txtTimer.setText("Jugador: " + manager_player.getCurrentPlayer().getId() + ", le quedan: " + (10 - secondsPassed) + " segundos de juego");
            secondsPassed++;
        }));
        timeline.setCycleCount(Animation.INDEFINITE);
        timeline.play();
    }

    public void initialize(){
        createBoard();
        createBases();

        L.setGraphic( fileManager.getPathImages().get(0) );
        Cruz.setGraphic( fileManager.getPathImages().get(1) );
        Z.setGraphic( fileManager.getPathImages().get(2) );
        P.setGraphic( fileManager.getPathImages().get(3) );
        U.setGraphic( fileManager.getPathImages().get(4) );
        T.setGraphic( fileManager.getPathImages().get(5) );


        Aerys.setGraphic( fileManager.getArrImagesMonsters().get(0) );
        Arryn.setGraphic( fileManager.getArrImagesMonsters().get(1) );
        Arthur.setGraphic( fileManager.getArrImagesMonsters().get(2) );
        Boko.setGraphic( fileManager.getArrImagesMonsters().get(3) );
        Bora.setGraphic( fileManager.getArrImagesMonsters().get(4) );
        Brienne.setGraphic( fileManager.getArrImagesMonsters().get(5) );
        Bronn.setGraphic( fileManager.getArrImagesMonsters().get(6) );
        Castlely.setGraphic( fileManager.getArrImagesMonsters().get(7) );
        Forerunner.setGraphic( fileManager.getArrImagesMonsters().get(8) );
        Glognar.setGraphic( fileManager.getArrImagesMonsters().get(9) );
        Helms.setGraphic( fileManager.getArrImagesMonsters().get(10) );
        Obara.setGraphic( fileManager.getArrImagesMonsters().get(11) );
        Rhageon.setGraphic( fileManager.getArrImagesMonsters().get(12) );
        Siddon.setGraphic( fileManager.getArrImagesMonsters().get(13) );
        Varys.setGraphic( fileManager.getArrImagesMonsters().get(14) );

        Artillery.setGraphic( fileManager.getArrImagesMonsters().get(15) );
        Infantry.setGraphic( fileManager.getArrImagesMonsters().get(16) );
        Tanks.setGraphic( fileManager.getArrImagesMonsters().get(17) );

        attackOption.setGraphic(fileManager.getArrImagesMovementDice().get(0));
        movementOption.setGraphic(fileManager.getArrImagesDiceOptions().get(0));
        specialOption.setGraphic(fileManager.getArrImagesMovementDice().get(2));
        summonOption.setGraphic(fileManager.getArrImagesMovementDice().get(3));
    }

    public void createBoard(){
        for(int x = 0; x < 20; x++){
            for(int y = 0; y < 20; y++){
                Button btnPosition = new Button(" ");
                btnPosition.getStyleClass().add("rows");
                btnPosition.getStyleClass().add("natural-color");

                int finalX = x+1;
                int finalY = y+1;
                btnPosition.setId(finalY + "_" + finalX);
                btnPosition.setOnAction(e -> getPosition(e) );
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

        manager_player.assingRound(playerA);
        start();
    }

    public void getPosition(ActionEvent e){
        Button btnPosition = (Button) e.getSource();

        if(bMoveMonsterEnd){
            moveMonsterEnd(btnPosition.getId());
        }

        if (bMoveMonsterInit) {
            moveMonsterInit(btnPosition.getId());
        }

        if(bAddMonster != null) {
            addMonster(btnPosition);
        }
    }

    public void moveMonsterInit(String currCoords){
        moveSoldier = manager_monsters.getMonster( currCoords, manager_player.getCurrentPlayer().getArrMonsters() );

        if(moveSoldier == null){
            Alert alert = alertHelper.createErr("No se encontro el monstruo", "No existe un monstruo en su armada en la posicion indicada");
            alert.showAndWait();
        }else {
            Alert alert = alertHelper.createInfo("Destino", "Seleccione donde desea ubicar el monstruo");
            alert.showAndWait();

            bMoveMonsterEnd = true;
            bMoveMonsterInit = false;
        }
    }

    public void moveMonsterEnd(String coords){
        if( manager_monsters.moveMonster( moveSoldier, coords, manager_player.getCurrentPlayer().getArrPaths(), Board ) ){
            System.out.println("Done");
        }else{
            Alert alert = alertHelper.createErr("No se puede mover el monstruo", "Necesita colocarlo sobre un camino");
            alert.showAndWait();
        }

        bMoveMonsterEnd = false;
    }

    public void addMonster(Button btnPosition){
        btnPosition.getStyleClass().remove("natural-color");
        btnPosition.getStyleClass().add("selected");

        actionPosition[0] = Integer.valueOf(btnPosition.getId().split("_")[0]);
        actionPosition[1] = Integer.valueOf(btnPosition.getId().split("_")[1]);

        PathBox.setVisible(true);
    }

    public void invokeDice(ActionEvent e){
        Coffer.setVisible(true);
        movementLabel.setText(String.valueOf(manager_player.getCurrentPlayer().getCantM()));
        specialLabel.setText(String.valueOf(manager_player.getCurrentPlayer().getCantE()));
        attackLabel.setText(String.valueOf(manager_player.getCurrentPlayer().getCantA()));
        summonLabel.setText(String.valueOf(manager_player.getCurrentPlayer().getCantI()));
    }

    public void showMonsterPanel(ActionEvent e){
        MonsterBox.setVisible(true);
    }

    public void showMoveAlert(){
        if (manager_player.getCurrentPlayer().getArrMonsters().size() != 0) {
            bMoveMonsterInit = true;
            Alert alert = alertHelper.createInfo("Mover monstruo", "Seleccione el monstruo que desea mover");

            alert.showAndWait();
        }
    }

    public void invokeMonster(ActionEvent e){
        Button btnMonster = (Button) e.getSource();

        bAddMonster = manager_monsters.createMonster( btnMonster.getId(), manager_player.getCurrentPlayer().getArrMonsters() );

        if(bAddMonster == null){
            Alert alert = alertHelper.createErr("No se puede crear el monstruo", "Ya esta listado en su ejercito");

            alert.showAndWait();
        }

        InfantryBox.setVisible(false);
        ArtilleryBox.setVisible(false);
        TankBox.setVisible(false);
    }

    public void invokeInfantery(ActionEvent e){
        InfantryBox.setVisible(true);
        MonsterBox.setVisible(false);
    }

    public void invokeArtillery(ActionEvent e){
        ArtilleryBox.setVisible(true);
        MonsterBox.setVisible(false);
    }

    public void invokeTanks(ActionEvent e){
        TankBox.setVisible(true);
        MonsterBox.setVisible(false);
    }

    public void invokePath(ActionEvent e){
        Button btnPath = (Button) e.getSource();
        Player currPlayer = manager_player.getCurrentPlayer();
        int basePositionY = currPlayer.getId() == "A" ? 1 : 20;

        Button btnActionPosition = (Button) Board.getScene().lookup("#" + actionPosition[0] + "_" + actionPosition[1]);
        btnActionPosition.getStyleClass().remove("selected");
        btnActionPosition.getStyleClass().add("natural-color");

        if(bAddMonster == null){
            Alert alert = alertHelper.createErr("No hay un monstruo", "Seleccione un monstruo para continuar");
            alert.showAndWait();
        }else if(manager_player.getCurrentPlayer().getArrPaths().size() == 0 && (actionPosition[0] != basePositionY || actionPosition[1] != currPlayer.getBasePosition()) ){
            Alert alert = alertHelper.createErr("No se puede crear el camino", "Debe estar conectado a su base");
            alert.showAndWait();
        }else {
            iShape shape = manager_path.createShape(actionPosition, pathRotation, btnPath.getId(), Board, playerA.getArrPaths(), playerB.getArrPaths(), bAddMonster);

            if (shape == null && manager_player.getCurrentPlayer().getArrPaths().size() != 0) {
                Alert alert = alertHelper.createErr("No se puede crear el camino", "No hay suficientes espacios o no esta conectado a otros");
                alert.showAndWait();
            } else {
                aPath path = manager_path.createNewPath(shape, btnPath.getId());
                manager_player.getCurrentPlayer().addPath( path );
                manager_player.getCurrentPlayer().addMonster(bAddMonster);

                bAddMonster = null;
            }
        }

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