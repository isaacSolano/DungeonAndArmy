package DungeonAndArmy.Bridge.Abstract;

import DungeonAndArmy.Bridge.Actions.Activate;
import javafx.scene.layout.GridPane;

import java.util.ArrayList;

public abstract class iShape {
    private iAction action = new Activate();
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

    public void paint(GridPane Board){
        action.paint(Board, getArrCoords() );
    }

    public abstract boolean createShape(Integer[] actionPosition, int pathRotation);
}