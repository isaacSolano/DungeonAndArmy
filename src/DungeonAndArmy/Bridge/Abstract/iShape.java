package DungeonAndArmy.Bridge.Abstract;

import javafx.scene.layout.GridPane;

import java.util.ArrayList;

public abstract class iShape {
    private iAction action;
    private ArrayList<String> arrCoords = new ArrayList<>();

    public iAction getAction() {
        return action;
    }

    public void setAction(iAction action) {
        this.action = action;
    }

    public ArrayList<String> getArrCoords() {
        return arrCoords;
    }

    public void setArrCoords(ArrayList<String> arrCoords) {
        this.arrCoords = arrCoords;
    }

    public void addCoords(String coord){
        arrCoords.add(coord);
    }

    public boolean paint(GridPane Board){
        return action.paint(Board, getArrCoords() );
    }

    public boolean addMonster(GridPane Board, String id){
        return action.addMonster(Board, id);
    }

    public void removeMonster(GridPane Board, String coords){
        action.removeMonster(Board, coords);
    }

    public abstract boolean createShape(Integer[] actionPosition, int pathRotation);
}