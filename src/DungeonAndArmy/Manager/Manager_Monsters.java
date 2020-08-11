package DungeonAndArmy.Manager;

import DungeonAndArmy.Abstract_Factory.AbstractFactory.Army;
import DungeonAndArmy.Abstract_Factory.AbstractProduct.Soldier;
import DungeonAndArmy.Abstract_Factory.ConcreteFactory.Artillery.*;
import DungeonAndArmy.Abstract_Factory.ConcreteFactory.Infantry.*;
import DungeonAndArmy.Abstract_Factory.ConcreteFactory.Tank.*;
import DungeonAndArmy.Bridge.Actions.*;
import DungeonAndArmy.Prototype.iPrototype.aPath;
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
     * @param Board The main board.
     * @param totalMovement Total spaces available to move the monster.
     * @return String The final result status of the operation.
     */
    public String moveMonster(Soldier soldier, String newPosition, ArrayList<aPath> arrCreatedPaths, GridPane Board, int totalMovement){
        String originCoords = soldier.getCoords();
        String result = "";
        boolean validateBoxes = validateBoxes(originCoords, newPosition, totalMovement),
                validateMovement = validateMonsterMovement(soldier.getMove());

        if(!validateBoxes)
            result = "No hay suficientes puntos de movimiento";
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
    public boolean validateBoxes(String originPosition, String newPosition, int totalMovement){
        int posXOrigin = Integer.parseInt( originPosition.split("_")[0] ),
            posYOrigin = Integer.parseInt( originPosition.split("_")[1] ),
            posXNew = Integer.parseInt( newPosition.split("_")[0] ),
            posYNew = Integer.parseInt( newPosition.split("_")[1] );

        boolean validated = false;

        if(posYOrigin == posYNew){
            if(posXOrigin > posXNew){
                if(posXOrigin - posXNew <= totalMovement){
                    currentMovement = posXOrigin - posXNew;
                    validated = true;
                }
            }else if(posXOrigin < posXNew){
                if(posXNew - posXOrigin <= totalMovement){
                    currentMovement = posXNew - posXOrigin;
                    validated = true;
                }
            }
        }else if(posXOrigin == posXNew){
            if(posYOrigin > posYNew){
                if(posYOrigin - posYNew <= totalMovement){
                    currentMovement = posYOrigin - posYNew;
                    validated = true;
                }
            }else if(posYOrigin < posYNew){
                if(posYNew - posYOrigin <= totalMovement){
                    currentMovement = posYNew - posYOrigin;
                    validated = true;
                }
            }
        }

        return validated;
    }
}
