package DungeonAndArmy.Manager;

import DungeonAndArmy.Abstract_Factory.AbstractFactory.Army;
import DungeonAndArmy.Abstract_Factory.AbstractProduct.Soldier;
import DungeonAndArmy.Abstract_Factory.ConcreteFactory.Artillery.*;
import DungeonAndArmy.Abstract_Factory.ConcreteFactory.Infantry.*;
import DungeonAndArmy.Abstract_Factory.ConcreteFactory.Tank.*;
import DungeonAndArmy.Bridge.Abstract.iShape;
import DungeonAndArmy.Bridge.Actions.*;
import DungeonAndArmy.Prototype.iPrototype.aPath;
import DungeonAndArmy.Singleton.Player;
import javafx.scene.layout.GridPane;

import java.util.ArrayList;

public class Manager_Monsters {
    private int currentMovement;

    /**
     * @param type The type of monster that is desired to create.
     * @param arrCreatedSoldiers Array with the created monsters of the current player.
     * @return Soldier The final created monster.
     */
    public Soldier createMonster(String type, ArrayList<Soldier> arrCreatedSoldiers){
        Army ftArmy;
        Soldier createdSoldier = null;

        switch (type){
            case "Aerys":
                ftArmy = new AerysFactory();
                createdSoldier = createFactory(ftArmy);
                break;

            case "Arryn":
                ftArmy = new ArrynFactory();
                createdSoldier = createFactory(ftArmy);
                break;

            case "Arthur":
                ftArmy = new ArthurFactory();
                createdSoldier = createFactory(ftArmy);
                break;

            case "Boko":
                ftArmy = new BokoFactory();
                createdSoldier = createFactory(ftArmy);
                break;

            case "Bora":
                ftArmy = new BoraFactory();
                createdSoldier = createFactory(ftArmy);
                break;

            case "Brienne":
                ftArmy = new BrienneFactory();
                createdSoldier = createFactory(ftArmy);
                break;

            case "Bronn":
                ftArmy = new BronnFactory();
                createdSoldier = createFactory(ftArmy);
                break;

            case "Castlely":
                ftArmy = new CastlelyFactory();
                createdSoldier = createFactory(ftArmy);
                break;

            case "Forerunner":
                ftArmy = new ForerunnerFactory();
                createdSoldier = createFactory(ftArmy);
                break;

            case "Glognar":
                ftArmy = new GlognarFactory();
                createdSoldier = createFactory(ftArmy);
                break;

            case "Helms":
                ftArmy = new HelmsFactory();
                createdSoldier = createFactory(ftArmy);
                break;

            case "Obara":
                ftArmy = new ObaraFactory();
                createdSoldier = createFactory(ftArmy);
                break;

            case "Rhageon":
                ftArmy = new RhaegonFactory();
                createdSoldier = createFactory(ftArmy);
                break;

            case "Siddon":
                ftArmy = new SiddonFactory();
                createdSoldier = createFactory(ftArmy);
                break;

            case "Varys":
                ftArmy = new VarysFactory();
                createdSoldier = createFactory(ftArmy);
                break;
        }

        if( checkExistance(createdSoldier, arrCreatedSoldiers) ){
            return null;
        }else{
            return createdSoldier;
        }
    }

    /**
     * @param ftArmy The general abstract Factory used to create the monster.
     * @return Soldier The final created monster.
     */
    public Soldier createFactory(Army ftArmy){
        return ftArmy.createSoldier();
    }

    /**
     * @param createdSoldier The monster that was created upon request.
     * @param arrCreatedSoldiers The Array of created monsters of the current player.
     * @return boolean Flag which will indicate if the created monster is already part of the current player's army.
     */
    public boolean checkExistance(Soldier createdSoldier, ArrayList<Soldier> arrCreatedSoldiers){
        boolean exists = false;

        for(Soldier soldier : arrCreatedSoldiers){
            if(soldier.getClass().equals( createdSoldier.getClass() )){
                exists = true;
            }
        }

        return exists;
    }

    /**
     * @param id The chosen position to move a monster.
     * @param arrCreatedMonsters The Array of created monsters of the current player.
     * @return Soldier The monster on the selected position (if any).
     */
    public Soldier getMonster(String id, ArrayList<Soldier> arrCreatedMonsters){
        Soldier monsterFound = null;

        for(Soldier soldier : arrCreatedMonsters){
            if(soldier.getCoords().equals(id)){
                monsterFound = soldier;
            }
        }

        return monsterFound;
    }

    /**
     * @param soldier The soldier that will be moved.
     * @param newPosition The new position id.
     * @param arrCreatedPaths The Array of created paths of the current player.
     * @param arrCreatedMonsters The Array of created monsters of the current player.
     * @param Board The main board.
     * @param totalMovement Total spaces available to move the monster.
     * @return String The final result status of the operation.
     */
    public String moveMonster(Soldier soldier, String newPosition, ArrayList<aPath> arrCreatedPaths, ArrayList<Soldier> arrCreatedMonsters, GridPane Board, int totalMovement){
        String originCoords = soldier.getCoords();
        String result = "", resultValidateBoxes = validateBoxes(originCoords, newPosition, totalMovement);
        boolean validateMovement = validateMonsterMovement(soldier.getMove());

        if( getMonster(newPosition, arrCreatedMonsters) != null ){
            result = "Ya existe un monstruo en esa posición, no puede agregar otro";
        }else if(!resultValidateBoxes.equals(""))
            result = resultValidateBoxes;
        else if(!validateMovement)
            result = "El monstruo no cuenta con el poder de movimiento necesario";
        else{
            for (aPath path : arrCreatedPaths) {
                for (String coords : path.getShape().getArrCoords()) {
                    if (coords.equals(soldier.getCoords())) {
                        path.getShape().setAction(new AddMonster(soldier));
                        if (path.getShape().addMonster(Board, newPosition)) {
                            path.getShape().setAction(new RemoveMonster());
                            path.getShape().removeMonster(Board, originCoords);
                        }else{
                            result = "No puede mover un monstruo donde no hay camino construido";
                        }
                    }
                }
            }
        }

        currentMovement = 0;
        return result;
    }

    /**
     * @param monsterMovement The available movement of the desired monster to move.
     * @return boolean The final flag which will indicate weather the monster can be moved or not.
     */
    public boolean validateMonsterMovement(int monsterMovement){
        return currentMovement <= monsterMovement || false;
    }

    /**
     * @param originPosition The current position id.
     * @param newPosition The new position id.
     * @param totalMovement Total spaces available to move the monster.
     * @return boolean The final flag which will indicate weather the monster can be moved or not.
     */
    public String validateBoxes(String originPosition, String newPosition, int totalMovement){
        int posXOrigin = Integer.parseInt( originPosition.split("_")[0] ),
            posYOrigin = Integer.parseInt( originPosition.split("_")[1] ),
            posXNew = Integer.parseInt( newPosition.split("_")[0] ),
            posYNew = Integer.parseInt( newPosition.split("_")[1] );

        String status = "";

        if(posYOrigin == posYNew){
            if(posXOrigin > posXNew){
                if(posXOrigin - posXNew <= totalMovement){
                    currentMovement = posXOrigin - posXNew;
                }
            }else if(posXOrigin < posXNew){
                if(posXNew - posXOrigin <= totalMovement){
                    currentMovement = posXNew - posXOrigin;
                }
            }
        }else if(posXOrigin == posXNew){
            if(posYOrigin > posYNew){
                if(posYOrigin - posYNew <= totalMovement){
                    currentMovement = posYOrigin - posYNew;
                }
            }else if(posYOrigin < posYNew){
                if(posYNew - posYOrigin <= totalMovement){
                    currentMovement = posYNew - posYOrigin;
                }
            }
        }else{
            status = "No se permiten movimientos en diagonal";
        }

        return status;
    }

    public String attackMonster(Soldier origin, Soldier target){
        String result = "";

        if( !checkRange(origin.getCoords(), target.getCoords()) ){
            result = "El objetivo está fuera de alcance";
        }else{
            int attackPoints = origin.getAttack(), defensePoints = target.getDefense(), lifePoints = target.getLife();

            if(defensePoints >= attackPoints){
                target.setDefense( defensePoints - attackPoints );
            }else if(defensePoints + lifePoints >= attackPoints){
                if(defensePoints - attackPoints > 0){
                    attackPoints = defensePoints - attackPoints;
                    target.setDefense(0);
                    target.setLife( lifePoints - attackPoints );
                }else{
                    target.setLife( lifePoints - attackPoints );
                }
            }else{
                result = "*";
            }
        }

        return result;
    }

    public void removeMonster(Soldier targetMonster, ArrayList<aPath> arrPaths, ArrayList<Soldier> arrMonsters, GridPane Board){
        for(aPath path : arrPaths){
            for(String coords : path.getShape().getArrCoords()) {
                if(coords.equals(targetMonster.getCoords())){
                    path.getShape().setAction(new RemoveMonster());
                    path.getShape().removeMonster(Board, targetMonster.getCoords());
                }
            }
        }

        arrMonsters.remove(targetMonster);
    }

    private boolean checkRange(String originCoords, String targetCoords){
        boolean canAttack = false;

        ArrayList<String> possibleCoords = new ArrayList<>();
        possibleCoords.add( Integer.valueOf(originCoords.split("_")[0]) + 1 + "_" + originCoords.split("_")[1] );
        possibleCoords.add( Integer.valueOf(originCoords.split("_")[0]) - 1 + "_" + originCoords.split("_")[1] );
        possibleCoords.add( originCoords.split("_")[0] + "_" + (Integer.valueOf(originCoords.split("_")[1]) + 1) );
        possibleCoords.add( originCoords.split("_")[0] + "_" + (Integer.valueOf(originCoords.split("_")[1]) - 1) );

        for(String coord : possibleCoords){
            if(coord.equals(targetCoords)){
                canAttack = true;
            }
        }

        return canAttack;
    }

    public String attackBase(String monsterCoords, Player targetPlayer){
        String result = "";
        if( !checkRange( monsterCoords, targetPlayer.getBasePosition() ) ){
            result = "El objetivo está fuera de alcance";
        }else if(targetPlayer.getLifes() <= 1) {
            result = "*";
        }else{
            targetPlayer.setLifes( targetPlayer.getLifes() - 1 );
        }

        return result;
    }

	public String attackMonsterSpecial(Soldier origin, Soldier target, String specialType) {
        String result = "";
        boolean inRange = false;
        int attackPoints = 0;
        
        switch (specialType){
            case "Infantry":
                inRange = checkRange(origin.getCoords(), target.getCoords());
                attackPoints = origin.getAttack()+2;
                break;
            case "Artillery":
                inRange = checkRangeSpecial(origin.getCoords(), target.getCoords());
                attackPoints = origin.getAttack();
                break;
        }

        if( !inRange ){
            result = "El objetivo está fuera de alcance";
        }else{
            int defensePoints = target.getDefense(), lifePoints = target.getLife();

            if(defensePoints >= attackPoints){
                target.setDefense( defensePoints - attackPoints );
            }else if(defensePoints + lifePoints >= attackPoints){
                if(defensePoints - attackPoints > 0){
                    attackPoints = defensePoints - attackPoints;
                    target.setDefense(0);
                    target.setLife( lifePoints - attackPoints );
                }else{
                    target.setLife( lifePoints - attackPoints );
                }
            }else{
                result = "*";
            }
        }
        return result;
	}

    private boolean checkRangeSpecial(String originCoords, String targetCoords) {
        ArrayList<String> possibleCoords = new ArrayList<>();
        possibleCoords.add( Integer.valueOf(originCoords.split("_")[0]) + 1 + "_" + originCoords.split("_")[1] );
        possibleCoords.add( Integer.valueOf(originCoords.split("_")[0]) + 2 + "_" + originCoords.split("_")[1] );
        possibleCoords.add( Integer.valueOf(originCoords.split("_")[0]) - 1 + "_" + originCoords.split("_")[1] );
        possibleCoords.add( Integer.valueOf(originCoords.split("_")[0]) - 2 + "_" + originCoords.split("_")[1] );
        possibleCoords.add( originCoords.split("_")[0] + "_" + (Integer.valueOf(originCoords.split("_")[1]) + 1) );
        possibleCoords.add( originCoords.split("_")[0] + "_" + (Integer.valueOf(originCoords.split("_")[1]) + 2) );
        possibleCoords.add( originCoords.split("_")[0] + "_" + (Integer.valueOf(originCoords.split("_")[1]) - 1) );
        possibleCoords.add( originCoords.split("_")[0] + "_" + (Integer.valueOf(originCoords.split("_")[1]) - 2) );

        for(String coord : possibleCoords){
            if(coord.equals(targetCoords)){
                return true;
            }
        }
        return false;
    }

    public String attackBaseSpecial(String monsterCoords, Player targetPlayer, String specialType) {
        String result = "";
        boolean inRange = false;
        int livesToTake = 1;

        switch (specialType){
            case "Infantry":
                inRange = checkRange(monsterCoords, targetPlayer.getBasePosition());
                livesToTake = 2;
                break;
            case "Artillery":
                inRange = checkRangeSpecial(monsterCoords, targetPlayer.getBasePosition());
                break;
        }
        if( !inRange ){
            result = "El objetivo está fuera de alcance";
        }else if(targetPlayer.getLifes() <= livesToTake) {
            result = "*";
        }else{
            targetPlayer.setLifes( targetPlayer.getLifes() - livesToTake );
        }

        return result;
    }
}
