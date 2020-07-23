package DungeonAndArmy.Singleton.Round;

import DungeonAndArmy.AbstractFactoryPattern.AbstractProduct.Soldier;
import DungeonAndArmy.Prototype.iPrototype.aPath;

import java.util.ArrayList;

public class Player {

    private String id;
    private int basePosition;
    private ArrayList<aPath> arrPaths;
    private ArrayList<Soldier> arrMonsters;

    //CONSTRUCTOR
    public Player(String id, int basePosition) {
        this.id = id;
        this.basePosition = basePosition;
        arrPaths = new ArrayList<>();
        arrMonsters = new ArrayList<>();
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

    @Override
    public String toString() {
        return "El jugador: " + id + " inicia en la posicion " + basePosition;
    }
}
