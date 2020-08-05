package DungeonAndArmy.Singleton;

import DungeonAndArmy.Abstract_Factory.AbstractProduct.Soldier;
import DungeonAndArmy.Manager.Manager_Dice;
import DungeonAndArmy.Prototype.iPrototype.aPath;
import java.util.ArrayList;
import DungeonAndArmy.Prototype.iPrototype.Dice;

public class Player {

    private String id;
    private int basePosition;
    private ArrayList<aPath> arrPaths;
    private ArrayList<Soldier> arrMonsters;
    private ArrayList<String> movementChest, attackChest, specialChest, summoningChest;
    private Manager_Dice managerDice;

    //CONSTRUCTOR
    public Player(String id, int basePosition) {
        this.id = id;
        this.basePosition = basePosition;
        arrPaths = new ArrayList<>();
        arrMonsters = new ArrayList<>();
        managerDice = new Manager_Dice();
        movementChest = new ArrayList<>();
        attackChest = new ArrayList<>();
        summoningChest = new ArrayList<>();
        specialChest = new ArrayList<>();
    }

    //GETS Y SETS
    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public int getBasePosition() {
        return basePosition;
    }

    public void setBasePosition(int basePosition) {
        this.basePosition = basePosition;
    }

    public ArrayList<aPath> getArrPaths() {
        return arrPaths;
    }

    public void setArrPaths(ArrayList<aPath> arrPaths) {
        this.arrPaths = arrPaths;
    }

    public void addPath(aPath path){
        this.arrPaths.add(path);
    }

    public ArrayList<Soldier> getArrMonsters() {
        return arrMonsters;
    }

    public void setArrMonsters(ArrayList<Soldier> arrMonsters) {
        this.arrMonsters = arrMonsters;
    }

    public void addMonster(Soldier soldier){
        this.arrMonsters.add(soldier);
    }

    /**
     *
     * @param pDice Dice that must be added to the chest.
     * @return String confirming the addition of the die.
     */
    public String addDice(Dice pDice){

        switch (pDice.getType()){
            case "Invocacion":
                if(summoningChest.size() <= 6)
                    summoningChest.add(pDice.getFace());
                break;
            case "Accion":
                switch (pDice.getFace()){

                    case "Movimiento":
                        if (movementChest.size() <= 3)
                            movementChest.add(managerDice.getNumDie().getFace());
                        break;
                    case "Atk":
                        if (attackChest.size() <= 3)
                            attackChest.add("Atk");
                        break;
                    case "SP":
                        if (specialChest.size() <= 2)
                            specialChest.add("SP");
                        break;
                }
        }
        return "Dado agregado";
    }

    /**
     *
     * @param pDado Dice to move the monster.
     * @return String con el valor que debe mover el dado.
     */
    public String movePiece(String pDado){

        for (String dado:movementChest) {
            if(dado.equals(pDado)){
                movementChest.remove(dado);
                return dado;
            }
        }
        return null;
    }

    /**
     *
     * @return Amount of dice stored in the movement chest.
     */
    public int countMovementDice(){
        return movementChest.size();
    }

    /**
     *
     * @return Amount of dice stored in the special chest.
     */
    public int countSpecialDice(){
        return specialChest.size();
    }

    /**
     *
     * @return Amount of dice stored in the summoning chest.
     */
    public int countSummoningDice(){
        return summoningChest.size();
    }

    /**
     *
     * @return Amount of dice stored in the attack chest.
     */
    public int countAttackDice(){
        return attackChest.size();
    }

    /**
     *
     * @return Amount of movement dice stored in the chest.
     */
    public ArrayList<String> getMovementDice(){
        return movementChest;
    }

    /**
     *
     * @return Array with 3 places, one for the artillery, one for infantry, and one for the tanks.
     */
    public int[] countMonsters(){
        int[] monsters = {0,0,0};
        for (String monster : summoningChest){
            switch (monster){
                case "Artillero":
                    monsters[0]++;
                    break;
                case "Infanteria":
                    monsters[1]++;
                    break;
                case "Tanque":
                    monsters[2]++;
                    break;
            }
        }
        return monsters;
    }
    
    @Override
    public String toString() {
        return "El jugador: " + id + " inicia en la posicion " + basePosition;
    }
}
