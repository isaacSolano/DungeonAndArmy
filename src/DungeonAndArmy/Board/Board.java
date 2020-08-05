package DungeonAndArmy.Board;

import DungeonAndArmy.Abstract_Factory.AbstractProduct.Soldier;
import DungeonAndArmy.Bridge.Abstract.iShape;
import DungeonAndArmy.Manager.Manager_Monsters;
import DungeonAndArmy.Manager.Manager_Path;
import DungeonAndArmy.Manager.Manager_Player;

import DungeonAndArmy.Helper.AlertHelper;
import DungeonAndArmy.Helper.FileManager;
import DungeonAndArmy.Helper.Helper;

import DungeonAndArmy.Prototype.iPrototype.aPath;
import DungeonAndArmy.Singleton.Player;

import javafx.animation.Animation;
import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.event.ActionEvent;
import javafx.scene.control.*;
import javafx.scene.layout.GridPane;
import javafx.util.Duration;

import java.util.ArrayList;
import java.util.Timer;

public class Board {
    public GridPane Board, PathBox, CategoryBox, InfantryBox, ArtilleryBox, TankBox, CofferBox;
    public Button L, Cruz, Z, P, U, T;
    public Button Aerys, Arryn, Arthur, Boko, Bora, Brienne, Bronn, Castlely, Forerunner, Glognar, Helms, Obara, Rhageon, Siddon, Varys;
    public Button Infantry, Artillery, Tanks;
    public Button movementDice, attackDice, summonDice, specialDice;
    public Label txtTimer;
    public Button movement1, movement2, movement3, movementOption;
    public GridPane CofferMovement;
    public Label movementLabel, attackLabel, specialLabel, summonLabel;
    public Label tankCount, artilleryCount, infantryCount;

    private AlertHelper alertHelper = new AlertHelper();
    private Helper helper = new Helper();
    private FileManager fileManager = new FileManager();

    private Manager_Player manager_player = new Manager_Player();
    private Manager_Path manager_path = new Manager_Path();
    private Manager_Monsters manager_monsters = new Manager_Monsters();

    private Player playerA, playerB;
    private Integer[] actionPosition = new Integer[2];

    private int secondsPassed = 0;
    private int pathRotation = 0;
    private int totalMovement = 0;

    private Timer timer = new Timer();

    private Soldier bAddMonster = null;
    private Soldier moveSoldier = null;

    private boolean bMoveMonsterInit = false;
    private boolean bMoveMonsterEnd = false;

    /****************************************************************************
     * Function which will initiate the timer needed to count the rounds.
     ****************************************************************************/
    public void start(){
        Timeline timeline = new Timeline(new KeyFrame(Duration.seconds(1), event -> {
            if(secondsPassed >= 15){
                secondsPassed = 0;
                manager_player.changePlayer(playerA, playerB);
                bAddMonster = null;
            }
            txtTimer.setText("Jugador: " + manager_player.getCurrentPlayer().getId() + ", le quedan: " + (15 - secondsPassed) + " segundos de juego");
            secondsPassed++;
        }));
        timeline.setCycleCount(Animation.INDEFINITE);
        timeline.play();
    }

    /****************************************************************************
     * Default function which will be runned once the view is loaded,
     * will be the reponsible of loading the required graphic components.
     ****************************************************************************/
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

        attackDice.setGraphic(fileManager.getAttack());
        movementDice.setGraphic(fileManager.getMovement());
        specialDice.setGraphic(fileManager.getSpecial());
        summonDice.setGraphic(fileManager.getSummoning());
    }

    /****************************************************************************
     * Function which will create the main board, provide the required
     * id's for the different buttons and classes for the appropriate look of each element.
     ****************************************************************************/
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

    /****************************************************************************
     * Function which will create the bases and the Players with it's
     * correspondent base position, using the Helper class will generate random location
     * for each of the bases.
     ****************************************************************************/
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

    /****************************************************************************
     * Function that will be triggered once a button(inside the board) is clicked,
     * will complete different verifications to provide the final functionality.
     * @param e The action of the click event
     ****************************************************************************/
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

    /****************************************************************************
     * Function that will be triggered after a button on the board is selected,
     * here the position of the button clicked will be checked and the monster on it will be obtained to be moved.
     * @param currCoords The current coords of the click event(from where the monster will be obtained).
     ****************************************************************************/
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

    /****************************************************************************
     * Function that will take the final desired position and will proceed with the change.
     * @param coords The final coords(To where te monster will be moved).
     ****************************************************************************/
    public void moveMonsterEnd(String coords){
        if( manager_monsters.moveMonster( moveSoldier, coords, manager_player.getCurrentPlayer().getArrPaths(), Board, totalMovement) ){
        }else{
            Alert alert = alertHelper.createErr("No se puede mover el monstruo", "Necesita colocarlo sobre un camino");
            alert.showAndWait();
        }

        bMoveMonsterEnd = false;
    }

    /****************************************************************************
     * Function that will pop-up the different paths from where you can choose to add the selected monster.
     * @param btnPosition The coords that will be used to initialize the selected path.
     ****************************************************************************/
    public void addMonster(Button btnPosition){
        btnPosition.getStyleClass().remove("natural-color");
        btnPosition.getStyleClass().add("selected");

        actionPosition[0] = Integer.valueOf(btnPosition.getId().split("_")[0]);
        actionPosition[1] = Integer.valueOf(btnPosition.getId().split("_")[1]);

        PathBox.setVisible(true);
    }

    /****************************************************************************
     * Function that will initiate the roll up dices function.
     * @param e The action of the click event.
     ****************************************************************************/
    public void invokeDice(ActionEvent e) {
        String description = "Cantidad ";
        CofferBox.setVisible(true);

        if (manager_player.getCurrentPlayer().countMovementDice() == 0){
            movementDice.setVisible(false);
            movementLabel.setVisible(false);
        }

        if (manager_player.getCurrentPlayer().countSpecialDice() == 0){
            specialDice.setVisible(false);
            specialLabel.setVisible(false);
        }

        if (manager_player.getCurrentPlayer().countAttackDice() == 0){
            attackDice.setVisible(false);
            attackLabel.setVisible(false);
        }

        if (manager_player.getCurrentPlayer().countSummoningDice() == 0){
            summonLabel.setVisible(false);
            summonDice.setVisible(false);
        }

        movementLabel.setText(description + manager_player.getCurrentPlayer().countMovementDice() );
        specialLabel.setText(description + manager_player.getCurrentPlayer().countSpecialDice() );
        attackLabel.setText(description + manager_player.getCurrentPlayer().countAttackDice() );
        summonLabel.setText(description + manager_player.getCurrentPlayer().countSummoningDice() );
        CofferMovement.setVisible(false);
    }

    /****************************************************************************
     * Function that will pop-up the different categories from where you can choose the
     * desired monster.
     * @param e The action of the click event.
     ****************************************************************************/
    public void showMonsterPanel(ActionEvent e) {
        String description = "Cantidad: ";
        if (manager_player.getCurrentPlayer().countSummoningDice() > 0) {
            CofferBox.setVisible(false);
            CategoryBox.setVisible(true);
            int[] monsters = manager_player.getCurrentPlayer().countMonsters();
            artilleryCount.setText(description + monsters[0]);
            infantryCount.setText(description + monsters[1]);
            tankCount.setText(description + monsters[2] );
        } else {
            Alert alert = alertHelper.createInfo("No hay dados", "No tiene dados almacenados para invocar.");
            alert.showAndWait();
        }
    }

    /****************************************************************************
     * Function that will pop-up an alert to the user indicating to select from the board
     * the desired monster to move.
     ****************************************************************************/
    public void showMoveAlert(ActionEvent e, Integer[] movement){
        for(Integer n : movement){
            totalMovement += n+1;
        }

        if (manager_player.getCurrentPlayer().getArrMonsters().size() != 0) {
            bMoveMonsterInit = true;
            Alert alert = alertHelper.createInfo("Mover monstruo", "Seleccione el monstruo que desea mover");
            alert.showAndWait();
        }else{
            Alert alert = alertHelper.createErr("No se puede completar la accion", "Debe primero invocar monstruos");
            alert.showAndWait();
        }
    }

    /****************************************************************************
     * Function that will be triggered once a monster is selected, the id of the source button
     * will tell which monster is desired to create.
     * @param e The action of the click event
     ****************************************************************************/
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

    /****************************************************************************
     * Function that will show the different monsters acordding to this category.
     * @param e The action of the click event
     ****************************************************************************/
    public void invokeInfantery(ActionEvent e){
        int n = manager_player.getCurrentPlayer().countMonsters()[1];

        if(n >= 2){
            InfantryBox.setVisible(true);
            CategoryBox.setVisible(false);
        }else{
            Alert alert = alertHelper.createErr("", "");
            alert.showAndWait();
        }

        CategoryBox.setVisible(false);
    }

    /****************************************************************************
     * Function that will show the different monsters acordding to this category.
     * @param e The action of the click event
     ****************************************************************************/
    public void invokeArtillery(ActionEvent e){
        int n = manager_player.getCurrentPlayer().countMonsters()[0];

        if(n >= 3){
            ArtilleryBox.setVisible(true);
            CategoryBox.setVisible(false);
        }else{
            Alert alert = alertHelper.createErr("", "");
            alert.showAndWait();
        }

        CategoryBox.setVisible(false);
    }

    /****************************************************************************
     * Function that will show the different monsters acordding to this category.
     * @param e The action of the click event
     ****************************************************************************/
    public void invokeTanks(ActionEvent e){
        int n = manager_player.getCurrentPlayer().countMonsters()[2];

        if(n >= 4){
            TankBox.setVisible(true);
            CategoryBox.setVisible(false);
        }else{
            Alert alert = alertHelper.createErr("", "");
            alert.showAndWait();
        }

        CategoryBox.setVisible(false);
    }

    /****************************************************************************
     * Function that will create the desired path after some validations.
     * @param e The action of the click event
     ****************************************************************************/
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

    /****************************************************************************
     * Function that will rotate the path images and save the rotation selected.
     ****************************************************************************/
    public void flipPath(){
        pathRotation = pathRotation == 360 ? 90 : pathRotation+90;

        L.setRotate(pathRotation);
        Cruz.setRotate(pathRotation);
        Z.setRotate(pathRotation);
        P.setRotate(pathRotation);
        U.setRotate(pathRotation);
        T.setRotate(pathRotation);
    }

    public void move(ActionEvent e) {
    }

    public void showMovementDice(ActionEvent e) {
        totalMovement = 0;
        movement1.setVisible(false);
        movement2.setVisible(false);
        movement3.setVisible(false);
        CofferMovement.setVisible(true);
        ArrayList<String> movementDice = manager_player.getCurrentPlayer().getMovementDice();
        int count = movementDice.size();
        if (count == 3) {
            movement1.setGraphic(fileManager.getArrImagesMovementDice().get(Integer.parseInt(movementDice.get(0))));
            movement2.setGraphic(fileManager.getArrImagesMovementDice().get(Integer.parseInt(movementDice.get(1))));
            movement3.setGraphic(fileManager.getArrImagesMovementDice().get(Integer.parseInt(movementDice.get(2))));

            movement1.setVisible(true);
            movement2.setVisible(true);
            movement3.setVisible(true);
            movementOption.setVisible(true);

            movementOption.setOnAction(ev -> showMoveAlert(ev, new Integer[]{Integer.parseInt(movementDice.get(0)), Integer.parseInt(movementDice.get(1)), Integer.parseInt(movementDice.get(2))}) );
        }else if (count > 1){
            movement1.setGraphic(fileManager.getArrImagesMovementDice().get(Integer.parseInt(movementDice.get(0))));
            movement2.setGraphic(fileManager.getArrImagesMovementDice().get(Integer.parseInt(movementDice.get(1))));

            movement1.setVisible(true);
            movement2.setVisible(true);
            movementOption.setVisible(true);

            movementOption.setOnAction(ev -> showMoveAlert(ev, new Integer[]{Integer.parseInt(movementDice.get(0)), Integer.parseInt(movementDice.get(1))}) );
        }else{
            movement1.setGraphic(fileManager.getArrImagesMovementDice().get(Integer.parseInt(movementDice.get(0))));

            movement1.setVisible(true);
            movementOption.setVisible(true);

            movementOption.setOnAction(ev -> showMoveAlert(ev, new Integer[]{Integer.parseInt(movementDice.get(0))}) );
        }

        CofferBox.setVisible(false);
    }

    public void attack(ActionEvent actionEvent) {
        if (manager_player.getCurrentPlayer().countAttackDice() > 0){
            // Procedimiento de ataque, selecciona un monstruo, apunta al monstruo adyacente que desea atacar,
            // calcular daño
        }
    }

    public void useSpecial(ActionEvent actionEvent) {
        if (manager_player.getCurrentPlayer().countSpecialDice() > 0){
            // Seleccionar monstruo, usar ataque especial.
        }
    }
}