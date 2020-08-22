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
import DungeonAndArmy.Routes.Router;
import DungeonAndArmy.Singleton.Player;

import javafx.animation.Animation;
import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.event.ActionEvent;
import javafx.scene.control.*;
import javafx.scene.image.ImageView;
import javafx.scene.layout.GridPane;
import javafx.util.Duration;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Timer;

public class Board {
    public GridPane Board, PathBox, CategoryBox, InfantryBox, ArtilleryBox, TankBox, CofferBox;
    public GridPane CofferMovement;

    public Button L, Cruz, Z, P, U, T;
    public Button Aerys, Arryn, Arthur, Boko, Bora, Brienne, Bronn, Castlely, Forerunner, Glognar, Helms, Obara, Rhageon, Siddon, Varys;
    public Button Infantry, Artillery, Tanks;
    public Button MovementDice, AttackDice, SummonDice, SpecialDice;
    public Button btnMove_0, btnMove_1, btnMove_2;

    public Label txtTimer, txtImage, txtLifes;
    public Label movementLabel, attackLabel, specialLabel, summonLabel;
    public Label tankCount, artilleryCount, infantryCount;

    private Manager_Player manager_player = new Manager_Player();
    private Manager_Path manager_path = new Manager_Path();
    private Manager_Monsters manager_monsters = new Manager_Monsters();

    private AlertHelper alertHelper = new AlertHelper();
    private Helper helper = new Helper();
    private FileManager fileManager = new FileManager();

    private Player playerA, playerB;

    private Integer[] actionPosition = new Integer[2];

    ArrayList<Button> arrBtnMovement = new ArrayList<>();

    private String selectedMonster = "";

    private int secondsPassed = 0;
    private int pathRotation = 0;
    private int totalMovement = 0;
    private int idDice;
    private int roundTime = 60;

    private Timer timer = new Timer();

    private Soldier bAddMonster = null;
    private Soldier moveMonster = null;
    private Soldier attackMonsterInit = null;
    private Soldier attackMonsterEnd = null;

    private boolean bMoveMonsterInit = false;
    private boolean bMoveMonsterEnd = false;
    private boolean bAttackMonsterInit = false;
    private boolean bAttackMonsterEnd = false, bSpecialMoveInit = false, bSpecialMoveEnd = false;
    private String specialType = null;

    Router routes = new Router();

    /****************************************************************************
     * Function which will initiate the timer needed to count the rounds.
     ****************************************************************************/
    public void start(){
        Timeline timeline = new Timeline(new KeyFrame(Duration.seconds(1), event -> {
            if(secondsPassed >= roundTime){
                secondsPassed = 0;
                manager_player.changePlayer(playerA, playerB);
                bAddMonster = null;

                CategoryBox.setVisible(false);
                InfantryBox.setVisible(false);
                ArtilleryBox.setVisible(false);
                TankBox.setVisible(false);
                CofferBox.setVisible(false);
                CofferMovement.setVisible(false);

                refreshDices();
            }

            refreshLifes();
            txtImage.setGraphic( manager_player.getCurrentPlayer().getBaseIcon() );
            txtTimer.setText( "\n" + (roundTime - secondsPassed) + " segundos de juego" );
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

        L.setGraphic( fileManager.getArrImagesPaths().get(0) );
        Cruz.setGraphic( fileManager.getArrImagesPaths().get(1) );
        Z.setGraphic( fileManager.getArrImagesPaths().get(2) );
        P.setGraphic( fileManager.getArrImagesPaths().get(3) );
        U.setGraphic( fileManager.getArrImagesPaths().get(4) );
        T.setGraphic( fileManager.getArrImagesPaths().get(5) );


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

        MovementDice.setGraphic( fileManager.getArrImagesActions().get(0) );
        AttackDice.setGraphic( fileManager.getArrImagesActions().get(1) );
        SummonDice.setGraphic( fileManager.getArrImagesActions().get(2) );
        SpecialDice.setGraphic( fileManager.getArrImagesActions().get(3) );

        arrBtnMovement.add(btnMove_0);
        arrBtnMovement.add(btnMove_1);
        arrBtnMovement.add(btnMove_2);
    }

    /****************************************************************************
     * Function which will refresh the images inside the dices buttons.
     ****************************************************************************/
    private void refreshDices() {
        for(Button btnMovement : arrBtnMovement){
            btnMovement.setGraphic(null);
        }
    }

    private void refreshLifes(){
        txtLifes.setText("Vidas restantes:" + manager_player.getCurrentPlayer().getLifes() );
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
        int basePositionB = helper.getRandom(20);

        Button btnBaseA = new Button("");
        Button btnBaseB = new Button("");

        btnBaseA.getStyleClass().add("rows");
        btnBaseB.getStyleClass().add("rows");

        btnBaseA.getStyleClass().add("natural-color");
        btnBaseB.getStyleClass().add("natural-color");

        btnBaseA.setId(0 + "_" + basePositionA);
        btnBaseB.setId(21 + "_" + basePositionB);

        btnBaseA.setOnAction(e -> getPosition(e));
        btnBaseB.setOnAction(e -> getPosition(e));

        ImageView imgIconA = fileManager.getArrImageBases("A");
        ImageView imgIconB = fileManager.getArrImageBases("B");

        imgIconA.setFitWidth(20);
        imgIconA.setFitHeight(20);

        imgIconB.setFitWidth(20);
        imgIconB.setFitHeight(20);

        btnBaseA.setGraphic( imgIconA );
        btnBaseB.setGraphic( imgIconB );

        Board.add(btnBaseA, basePositionA, 0);
        Board.add(btnBaseB, basePositionB, 21);

        playerA = new Player("A", 0 + "_" + basePositionA, fileManager.getArrImageBases("A"));
        playerB = new Player("B", 21 + "_" + basePositionB, fileManager.getArrImageBases("B"));

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

        if(bAttackMonsterEnd){
            selectTargetMonster(btnPosition.getId(), e);
        }

        if(bSpecialMoveInit){
            selectSpecialMoveMonster(btnPosition.getId());
        }

        if(bAttackMonsterInit){
            selectAttackMonster(btnPosition.getId());
        }

        if(bSpecialMoveEnd)
            selectTargetSpecialMonster(btnPosition.getId(), e);
    }

    private void selectTargetSpecialMonster(String coords, ActionEvent e) {
        Player targetPlayer;

        if(manager_player.getCurrentPlayer().equals(playerA)){
            targetPlayer = playerB;
        }else{
            targetPlayer = playerA;
        }

        if(coords.equals(targetPlayer.getBasePosition())){
            String result = manager_monsters.attackBaseSpecial(attackMonsterInit.getCoords(), targetPlayer, specialType);

            if(result.equals("")){
                Alert alert = alertHelper.createInfo("Ataque exitoso", "La base fue atacada con exito");
                alert.showAndWait();
                targetPlayer.getArrPaths().addAll(manager_player.getCurrentPlayer().getArrPaths());
                manager_monsters.removeMonster(attackMonsterInit, targetPlayer.getArrPaths(), manager_player.getCurrentPlayer().getArrMonsters(), Board);

                refreshLifes();

                manager_player.discountAttackDices(manager_player.getCurrentPlayer());
                attackLabel.setText("Cantidad " + manager_player.getCurrentPlayer().countAttackDice());
                CofferBox.setVisible(false);
            }else if(result.equals("*")) {
                Alert alert  = alertHelper.createInfo("Ganador", "La base contraria ya no tiene mas vidas");
                alert.showAndWait();

                try {
                    routes.navigateEnd(e);
                } catch (IOException ioException) {
                    ioException.printStackTrace();
                }
            }else{
                Alert alert = alertHelper.createErr(result);
                alert.showAndWait();
            }
        }else {
            attackMonsterEnd = manager_monsters.getMonster(coords, targetPlayer.getArrMonsters());

            if (attackMonsterEnd == null) {
                Alert alert = alertHelper.createErr("El contrincante no tiene un monstruo en la posición indicada");
                alert.showAndWait();

                bAttackMonsterEnd = false;
            } else {
                String result = manager_monsters.attackMonsterSpecial(attackMonsterInit, attackMonsterEnd, specialType);

                if (result.equals("")) {
                    Alert alert = alertHelper.createInfo("Ataque exitoso", "El monstruo fue atacado con exito");
                    alert.showAndWait();
                } else if (result.equals("*")) {
                    Alert alert = alertHelper.createInfo("Ataque exitoso", "El monstruo no ha sobrevivido el ataque");
                    alert.showAndWait();

                    targetPlayer.getArrPaths().addAll(manager_player.getCurrentPlayer().getArrPaths());
                    manager_monsters.removeMonster(attackMonsterEnd, targetPlayer.getArrPaths(), targetPlayer.getArrMonsters(), Board);
                } else {
                    Alert alert = alertHelper.createErr(result);
                    alert.showAndWait();
                }

                manager_player.discountAttackDices(manager_player.getCurrentPlayer());
                attackLabel.setText("Cantidad " + manager_player.getCurrentPlayer().countAttackDice());
                CofferBox.setVisible(false);
            }
        }

        bAttackMonsterEnd = false;
    }

    /**
     *
     * @param coords
     */
    private void selectSpecialMoveMonster(String coords) {
        attackMonsterInit = manager_monsters.getMonster(coords, manager_player.getCurrentPlayer().getArrMonsters() );

        Alert alert;
        if(attackMonsterInit == null){
            alert = alertHelper.createErr("No existe un monstruo de su ejército en la posición indicada");
            alert.showAndWait();

        }else{
            switch (attackMonsterInit.getClass().toString()){
                case "Aerys": case "Boko": case "Bora": case "Glognar": case "Helms":
                    specialType = "Artillery";
                    alert = alertHelper.createInfo("Objetivo", "Seleccione el monstruo del contrincante que desea atacar");
                    alert.showAndWait();
                    bSpecialMoveEnd = true;
                    break;
                case "Arryn": case "Arthur": case "Brienne": case "Bronn": case "Obara":
                    specialType = "Infantry";
                    alert = alertHelper.createInfo("Objetivo", "Seleccione el monstruo del contrincante que desea atacar");
                    alert.showAndWait();
                    bSpecialMoveEnd = true;
                    break;
                case "Castlely": case "Forerunner": case "Rhaegon": case "Siddon": case "Varys":
                    attackMonsterInit.setLife(attackMonsterInit.getLife()+1);
                    alert = alertHelper.createInfo("Rejuvenecimiento.","¡Tu monstruo ha ganado 1 punto de vida!");
                    alert.showAndWait();
                    break;
            }
        }
        bSpecialMoveInit = false;
    }

    /****************************************************************************
     * Function that will be triggered after the user select the monster to attack from.
     ****************************************************************************/
    public void selectAttackMonster(String coords){
        attackMonsterInit = manager_monsters.getMonster(coords, manager_player.getCurrentPlayer().getArrMonsters() );

        Alert alert;
        if(attackMonsterInit == null){
            alert = alertHelper.createErr("No existe un monstruo de su ejército en la posición indicada");
            alert.showAndWait();

        }else{
            alert = alertHelper.createInfo("Objetivo", "Seleccione el monstruo del contrincante que desea atacar");
            alert.showAndWait();

            bAttackMonsterEnd = true;
        }
        bAttackMonsterInit = false;
    }

    public void selectTargetMonster(String coords, ActionEvent e){
        Player targetPlayer;

        if(manager_player.getCurrentPlayer().equals(playerA)){
            targetPlayer = playerB;
        }else{
            targetPlayer = playerA;
        }

        if(coords.equals(targetPlayer.getBasePosition())){
            String result = manager_monsters.attackBase(attackMonsterInit.getCoords(), targetPlayer);

            if(result.equals("")){
                Alert alert = alertHelper.createInfo("Ataque exitoso", "La base fue atacada con exito");
                alert.showAndWait();
                targetPlayer.getArrPaths().addAll(manager_player.getCurrentPlayer().getArrPaths());
                manager_monsters.removeMonster(attackMonsterInit, targetPlayer.getArrPaths(), manager_player.getCurrentPlayer().getArrMonsters(), Board);

                refreshLifes();

                manager_player.discountAttackDices(manager_player.getCurrentPlayer());
                attackLabel.setText("Cantidad " + manager_player.getCurrentPlayer().countAttackDice());
                CofferBox.setVisible(false);
            }else if(result.equals("*")) {
                Alert alert  = alertHelper.createInfo("Ganador", "La base contraria ya no tiene mas vidas");
                alert.showAndWait();

                try {
                    routes.navigateEnd(e);
                } catch (IOException ioException) {
                    ioException.printStackTrace();
                }
            }else{
                Alert alert = alertHelper.createErr(result);
                alert.showAndWait();
            }
        }else {
            attackMonsterEnd = manager_monsters.getMonster(coords, targetPlayer.getArrMonsters());

            if (attackMonsterEnd == null) {
                Alert alert = alertHelper.createErr("El contrincante no tiene un monstruo en la posición indicada");
                alert.showAndWait();

                bAttackMonsterEnd = false;
            } else {
                String result = manager_monsters.attackMonster(attackMonsterInit, attackMonsterEnd);

                if (result.equals("")) {
                    Alert alert = alertHelper.createInfo("Ataque exitoso", "El monstruo fue atacado con exito");
                    alert.showAndWait();
                } else if (result.equals("*")) {
                    Alert alert = alertHelper.createInfo("Ataque exitoso", "El monstruo no ha sobrevivido el ataque");
                    alert.showAndWait();

                    targetPlayer.getArrPaths().addAll(manager_player.getCurrentPlayer().getArrPaths());
                    manager_monsters.removeMonster(attackMonsterEnd, targetPlayer.getArrPaths(), targetPlayer.getArrMonsters(), Board);
                } else {
                    Alert alert = alertHelper.createErr(result);
                    alert.showAndWait();
                }

                manager_player.discountAttackDices(manager_player.getCurrentPlayer());
                attackLabel.setText("Cantidad " + manager_player.getCurrentPlayer().countAttackDice());
                CofferBox.setVisible(false);
            }
        }

        bAttackMonsterEnd = false;
    }

    /****************************************************************************
     * Function that will be triggered after a button on the board is selected,
     * here the position of the button clicked will be checked and the monster on it will be obtained to be moved.
     * @param currCoords The current coords of the click event(from where the monster will be obtained).
     ****************************************************************************/
    public void moveMonsterInit(String currCoords){
        moveMonster = manager_monsters.getMonster( currCoords, manager_player.getCurrentPlayer().getArrMonsters() );

        if(moveMonster == null){
            Alert alert = alertHelper.createErr("No existe un monstruo en su armada, en la posición indicada");
            alert.showAndWait();
        }else {
            Alert alert = alertHelper.createInfo("Destino", "Seleccione dónde desea ubicar el monstruo");
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
        ArrayList<aPath> arrPaths;

        if(manager_player.getCurrentPlayer().equals(playerA)){
            arrPaths = playerB.getArrPaths();
        }else{
            arrPaths = playerA.getArrPaths();
        }

        arrPaths.addAll(manager_player.getCurrentPlayer().getArrPaths());

        String result = manager_monsters.moveMonster(moveMonster, coords, arrPaths, manager_player.getCurrentPlayer().getArrMonsters(), Board, totalMovement);

        if(!result.equals("")){
            Alert alert = alertHelper.createErr(result);
            alert.showAndWait();
        }else{
            manager_player.discountMovementDices(idDice);
            refreshDices();
        }

        CofferMovement.setVisible(false);
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
    public void nextRound(ActionEvent e){
        secondsPassed = roundTime;
    }

    public void invokeDice(ActionEvent e) {
        String description = "Cantidad ";

        CofferBox.setVisible(true);

        CategoryBox.setVisible(false);
        InfantryBox.setVisible(false);
        ArtilleryBox.setVisible(false);
        TankBox.setVisible(false);
        CofferMovement.setVisible(false);

        movementLabel.setText(description + manager_player.getCurrentPlayer().countMovementDice() );
        specialLabel.setText(description + manager_player.getCurrentPlayer().countSpecialDice() );
        attackLabel.setText(description + manager_player.getCurrentPlayer().countAttackDice() );
        summonLabel.setText(description + manager_player.getCurrentPlayer().countSummoningDice() );
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
            Alert alert = alertHelper.createErr("No tiene dados almacenados para invocar");
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
            Alert alert = alertHelper.createErr("El monstruo ya está listado en su ejército");
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
            selectedMonster = "Infanteria_2";
        }else{
            Alert alert = alertHelper.createErr("No cuenta con los dados suficientes para esta invocación");
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
            selectedMonster = "Artillero_3";
        }else{
            Alert alert = alertHelper.createErr("No cuenta con los dados suficientes para esta invocación");
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
            selectedMonster = "Tanque_4";
        }else{
            Alert alert = alertHelper.createErr("No cuenta con los dados suficientes para esta invocación");
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
            Alert alert = alertHelper.createErr("Seleccione un monstruo para continuar");
            alert.showAndWait();
        }else if(manager_player.getCurrentPlayer().getArrPaths().size() == 0 && (actionPosition[0] != basePositionY || actionPosition[1] != Integer.valueOf(currPlayer.getBasePosition().split("_")[1])) ){
            Alert alert = alertHelper.createErr("El camino debe estar conectado a su base");
            alert.showAndWait();
        }else {
            iShape shape = manager_path.createShape(actionPosition, pathRotation, btnPath.getId(), Board, playerA.getArrPaths(), playerB.getArrPaths(), bAddMonster);

            if (shape == null && manager_player.getCurrentPlayer().getArrPaths().size() != 0) {
                Alert alert = alertHelper.createErr("No hay suficientes espacios o no está conectado a otros caminos");
                alert.showAndWait();
            } else {
                aPath path = manager_path.createNewPath(shape, btnPath.getId());
                manager_player.getCurrentPlayer().addPath( path );
                manager_player.getCurrentPlayer().addMonster(bAddMonster);

                manager_player.discountSummonigDices( selectedMonster.split("_")[0], Integer.valueOf(selectedMonster.split("_")[1]) );
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

    /****************************************************************************
     * Function that will pop-up an alert to the user indicating to select from the board
     * the desired monster to move.
     ****************************************************************************/
    public void startMovement(ActionEvent e) {
        Button btnMovementDice = (Button) e.getSource();
        idDice = Integer.valueOf( btnMovementDice.getId().split("_")[1] );
        totalMovement = Integer.valueOf( manager_player.getCurrentPlayer().getMovementDice().get(idDice) ) + 1;

        if (manager_player.getCurrentPlayer().getArrMonsters().size() != 0) {
            bMoveMonsterInit = true;
            Alert alert = alertHelper.createInfo("Mover monstruo", "Seleccione el monstruo que desea mover");
            alert.showAndWait();
        }else{
            Alert alert = alertHelper.createErr("Debe primero invocar monstruos");
            alert.showAndWait();
        }
    }

    /****************************************************************************
     * Function that will show the different dices according to the values saved
     * on the user chest.
     ****************************************************************************/
    public void showMovementDice(ActionEvent e) {
        CofferMovement.setVisible(true);

        for(int i = 0; i < manager_player.getCurrentPlayer().getMovementDice().size(); i++ ){
            arrBtnMovement.get(i).setGraphic( fileManager.getArrImagesMovementDice( Integer.parseInt(manager_player.getCurrentPlayer().getMovementDice().get(i)) ));
            arrBtnMovement.get(i).setVisible(true);
        }

        totalMovement = 0;
        CofferBox.setVisible(false);
    }

    /****************************************************************************
     * Function that will pop-up an alert to the user indicating to select from the board
     * the desired monster to attack from.
     * @param actionEvent click event
     ****************************************************************************/
    public void attack(ActionEvent actionEvent) {
        if( manager_player.getCurrentPlayer().countAttackDice() <= 0 ){
            Alert alert = alertHelper.createErr("No tiene suficientes dados para atacar");
            alert.showAndWait();
        }else if (manager_player.getCurrentPlayer().getArrMonsters().size() > 0){
            Alert alert = alertHelper.createInfo("Seleccione el monstruo", "Seleccione el monstruo de su ejército desde el cuál desea atacar");
            alert.showAndWait();

            bAttackMonsterInit = true;
        }else{
            Alert alert = alertHelper.createErr("No cuenta con ejército para atacar");
            alert.showAndWait();
        }
    }

    /**
     * Function that prompts the user to choose a monster to perform the special movement.
     * @param actionEvent a click event on the button
     */
    public void useSpecial(ActionEvent actionEvent) {
        Alert alert;
        if (manager_player.getCurrentPlayer().countSpecialDice() <= 0){
            alert = alertHelper.createErr("No tiene suficientes dados para usar el movimiento especial.");
            alert.showAndWait();
        }else if (manager_player.getCurrentPlayer().getArrMonsters().size() > 0){
            alert = alertHelper.createInfo("Seleccione el monstruo","¿Cual monstruo usara el movimiento especial?");
            alert.showAndWait();
            bSpecialMoveInit = true;
        }else {
            alert = alertHelper.createErr("No tiene monstruos para ordenar.");
            alert.showAndWait();
        }
    }
}
