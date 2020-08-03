package DungeonAndArmy.Gestor;

import DungeonAndArmy.AbstractFactoryPattern.AbstractFactory.Army;
import DungeonAndArmy.AbstractFactoryPattern.AbstractProduct.Soldier;
import DungeonAndArmy.AbstractFactoryPattern.ConcreteFactory.Artillery.*;
import DungeonAndArmy.AbstractFactoryPattern.ConcreteFactory.Infantry.*;
import DungeonAndArmy.AbstractFactoryPattern.ConcreteFactory.Tank.*;
import DungeonAndArmy.Bridge.Actions.*;
import DungeonAndArmy.Prototype.iPrototype.aPath;
import javafx.scene.layout.GridPane;

import java.util.ArrayList;

public class Manager_Monsters {

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
     * @return boolean The final flag which will indicate weather the monster have been moved or not.
     */
    public boolean moveMonster(Soldier soldier, String newPosition, ArrayList<aPath> arrCreatedPaths, GridPane Board){
        boolean moved = false;
        String originCoords = soldier.getCoords();

        for(aPath path : arrCreatedPaths){
            for(String coords : path.getShape().getArrCoords() ){
                if(coords.equals( soldier.getCoords() )){
                    path.getShape().setAction( new AddMonster(soldier) );
                    if( path.getShape().addMonster(Board, newPosition) ){
                        path.getShape().setAction( new RemoveMonster() );
                        path.getShape().removeMonster(Board, originCoords);

                        moved = true;
                    }
                }
            }
        }

        return moved;
    }
}
