package DungeonAndArmy.Singleton;

import DungeonAndArmy.Abstract_Factory.AbstractProduct.Soldier;
import DungeonAndArmy.Manager.Manager_Dice;
import DungeonAndArmy.Prototype.iPrototype.aPath;
import java.util.ArrayList;
import DungeonAndArmy.Prototype.iPrototype.Dice;
import javafx.scene.image.ImageView;

public class Player {
    private ImageView baseIcon;
    private String id;
    private String basePosition;
    private int lifes;
    private ArrayList<aPath> arrPaths;
    private ArrayList<Soldier> arrMonsters;
    private ArrayList<String> movementChest, attackChest, specialChest, summoningChest;
    private Manager_Dice managerDice;

    public Player(String id, String basePosition, ImageView baseIcon) {
        this.baseIcon = baseIcon;
        this.id = id;
        this.basePosition = basePosition;
        this.lifes = 4;
        arrPaths = new ArrayList<>();
        arrMonsters = new ArrayList<>();
        managerDice = new Manager_Dice();
        movementChest = new ArrayList<>();
        attackChest = new ArrayList<>();
        summoningChest = new ArrayList<>();
        specialChest = new ArrayList<>();
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getBasePosition() {
        return basePosition;
    }

    public void setBasePosition(String basePosition) {
        this.basePosition = basePosition;
    }

    public ImageView getBaseIcon() {
        this.baseIcon.setFitWidth(45);
        this.baseIcon.setFitHeight(45);
        return this.baseIcon;
    }

    public void setBaseIcon(ImageView baseIcon) {
        this.baseIcon = baseIcon;
    }

    public int getLifes() {
        return lifes;
    }

    public void setLifes(int lifes) {
        this.lifes = lifes;
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
                        if (movementChest.size() < 3)
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

    public void setMovementChest(ArrayList<String> arrMovementChest){
        this.movementChest = arrMovementChest;
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

    public void discountSummoningDice(String type, int delAmm){
        ArrayList<String> arrFoundTypes = new ArrayList();

        for (String dado:summoningChest) {
            if(dado.equals(type)){
                arrFoundTypes.add(dado);
            }
        }

        for (int i =0; i < delAmm; i++){
            summoningChest.remove(arrFoundTypes.get(i));
        }
    }

    public void discountAttackDice(){
        attackChest.remove(0);
    }

    @Override
    public String toString() {
        return "El jugador: " + id + " inicia en la posicion " + basePosition;
    }
}
