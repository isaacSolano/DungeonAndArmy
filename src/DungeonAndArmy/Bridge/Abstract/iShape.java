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

    public void addMonster(GridPane Board, String id){
        action.addMonster(Board, id);
    }

    public abstract boolean createShape(Integer[] actionPosition, int pathRotation);
}