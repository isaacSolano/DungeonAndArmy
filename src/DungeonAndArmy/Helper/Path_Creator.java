package DungeonAndArmy.Helper;

import javafx.scene.control.Button;
import javafx.scene.layout.GridPane;

import java.util.ArrayList;

public class Path_Creator {
    public Path_Creator(){ }

    public ArrayList<String> createPath(String type, Integer[] actionPosition, GridPane Board){
        ArrayList<String> arrCreatedId = new ArrayList<>();

        switch (type){
            case "L":
                arrCreatedId = createL(actionPosition, Board);
                break;

            case "Cruz":
                arrCreatedId = createCruz(actionPosition, Board);
                break;

            case "Z":
                arrCreatedId = createZ(actionPosition, Board);
                break;

            case "P":
                arrCreatedId = createP(actionPosition, Board);
                break;

            case "U":
                arrCreatedId = createU(actionPosition, Board);
                break;

            case "T":
                arrCreatedId = createT(actionPosition, Board);
                break;

            default:
                break;
        }

        return arrCreatedId;
    }

    public ArrayList<String> createL(Integer[] actionPosition, GridPane Board){
        ArrayList<String> arrCreatedId = new ArrayList<>();

        if(actionPosition[0] - 2 > 0 && actionPosition[1] - 2 > 0) {
            for (int i = 0; i < 3; i++) {
                Button btnPathX = new Button("X");
                btnPathX.getStyleClass().add("selected");

                String id = actionPosition[0] + i + "_" + actionPosition[1];
                Board.add(btnPathX, actionPosition[0] - i, actionPosition[1]);

                btnPathX.setId(id);
                arrCreatedId.add(id);
            }

            for (int i = 1; i < 3; i++) {
                Button btnPathY = new Button("Y");
                btnPathY.getStyleClass().add("selected");

                String id = actionPosition[0] - 2 + "_" + Integer.valueOf(actionPosition[1] - i);
                Board.add(btnPathY, actionPosition[0] - 2, actionPosition[1] - i);

                btnPathY.setId(id);
                arrCreatedId.add(id);
            }
        }else{
            arrCreatedId = null;
        }

        return arrCreatedId;
    }

    public ArrayList<String> createCruz(Integer[] actionPosition, GridPane Board){
        ArrayList<String> arrCreatedId = new ArrayList<>();

        if(actionPosition[0] - 1 <= 0 || actionPosition[0] + 1 > 20 || actionPosition[1] - 3 < 0){
            arrCreatedId = null;
        }else {
            for (int i = 0; i < 3; i++) {
                Button btnPathY = new Button("Y");
                btnPathY.getStyleClass().add("selected");

                String id = actionPosition[0] + "_" + Integer.valueOf(actionPosition[1] - i);
                Board.add(btnPathY, actionPosition[0], actionPosition[1] - i);

                btnPathY.setId(id);
                arrCreatedId.add(id);
            }

            for (int i = -1; i < 2; i++) {
                Button btnPathX = new Button("X");
                btnPathX.getStyleClass().add("selected");

                String id = actionPosition[0] + i + "_" + Integer.valueOf(actionPosition[1] - 1);
                Board.add(btnPathX, actionPosition[0] + i, actionPosition[1] - 1);

                btnPathX.setId(id);
                arrCreatedId.add(id);
            }
        }

        return arrCreatedId;
    }
    public ArrayList<String> createZ(Integer[] actionPosition, GridPane Board){
        ArrayList<String> arrCreatedId = new ArrayList<>();

        if(actionPosition[0] - 2 <= 0 || actionPosition[1] - 2 <= 0){
            arrCreatedId = null;
        }else {
            {
                Button btnPathX = new Button("X");
                btnPathX.getStyleClass().add("selected");

                String id = actionPosition[0] + "_" + actionPosition[1];
                Board.add(btnPathX, actionPosition[0], actionPosition[1]);

                btnPathX.setId(id);
                arrCreatedId.add(id);
            }

            for (int i = 0; i < 3; i++) {
                Button btnPathY = new Button("Y");
                btnPathY.getStyleClass().add("selected");

                String id = actionPosition[0] - 1 + "_" + Integer.valueOf(actionPosition[1] - i);
                Board.add(btnPathY, actionPosition[0] - 1, actionPosition[1] - i);

                btnPathY.setId(id);
                arrCreatedId.add(id);
            }

            {
                Button btnPathX = new Button("X");
                btnPathX.getStyleClass().add("selected");

                String id = actionPosition[0] - 2 + "_" + Integer.valueOf(actionPosition[1] - 2);
                Board.add(btnPathX, actionPosition[0] - 2, actionPosition[1] - 2);

                btnPathX.setId(id);
                arrCreatedId.add(id);
            }
        }

        return arrCreatedId;
    }

    public ArrayList<String> createP(Integer[] actionPosition, GridPane Board){
        ArrayList<String> arrCreatedId = new ArrayList<>();

        if(actionPosition[1] - 2 <= 0 || actionPosition[0] + 1 > 20){
            arrCreatedId = null;
        }else {
            for (int i = 0; i < 3; i++) {
                Button btnPathY = new Button("Y");
                btnPathY.getStyleClass().add("selected");

                String id = actionPosition[0] + "_" + Integer.valueOf(actionPosition[1] - i);
                Board.add(btnPathY, actionPosition[0], actionPosition[1] - i);

                btnPathY.setId(id);
                arrCreatedId.add(id);
            }

            for (int i = -2; i < 0; i++) {
                Button btnPathY = new Button("Y");
                btnPathY.getStyleClass().add("selected");

                String id = actionPosition[0] + 1 + "_" + Integer.valueOf(actionPosition[1] + i);
                Board.add(btnPathY, actionPosition[0] + 1, actionPosition[1] + i);

                btnPathY.setId(id);
                arrCreatedId.add(id);
            }
        }

        return arrCreatedId;
    }

    public ArrayList<String> createU(Integer[] actionPosition, GridPane Board){
        ArrayList<String> arrCreatedId = new ArrayList<>();

        if(actionPosition[1] - 1 <= 0 || actionPosition[0] + 2 > 20){
            arrCreatedId = null;
        }else {
            for (int i = 0; i < 2; i++) {
                Button btnPathY = new Button("Y");
                btnPathY.getStyleClass().add("selected");

                String id = actionPosition[0] + "_" + Integer.valueOf(actionPosition[1] - i);
                Board.add(btnPathY, actionPosition[0], actionPosition[1] - i);

                btnPathY.setId(id);
                arrCreatedId.add(id);
            }

            {
                Button btnPathY = new Button("X");
                btnPathY.getStyleClass().add("selected");

                String id = actionPosition[0] - 1 + "_" + Integer.valueOf(actionPosition[1] - 3);
                Board.add(btnPathY, actionPosition[0] + 1, actionPosition[1] - 1);

                btnPathY.setId(id);
                arrCreatedId.add(id);
            }

            for (int i = 0; i < 2; i++) {
                Button btnPathY = new Button("Y");
                btnPathY.getStyleClass().add("selected");

                String id = actionPosition[0] + 2 + "_" + Integer.valueOf(actionPosition[1] - i);
                Board.add(btnPathY, actionPosition[0] + 2, actionPosition[1] - i);

                btnPathY.setId(id);
                arrCreatedId.add(id);
            }
        }

        return arrCreatedId;
    }
    public ArrayList<String> createT(Integer[] actionPosition, GridPane Board){
        ArrayList<String> arrCreatedId = new ArrayList<>();

        if(actionPosition[0] + 2 > 20 || actionPosition[1] - 2 <= 0){
            arrCreatedId = null;
        }else{
            for (int i = 0; i < 3; i++) {
                Button btnPathY = new Button("Y");
                btnPathY.getStyleClass().add("selected");

                String id = actionPosition[0] + 1 + "_" + Integer.valueOf(actionPosition[1] - i);
                Board.add(btnPathY, actionPosition[0] + 1, actionPosition[1] - i);

                btnPathY.setId(id);
                arrCreatedId.add(id);
            }

            for (int i = 0; i < 3; i++) {
                Button btnPathX = new Button("X");
                btnPathX.getStyleClass().add("selected");

                String id = actionPosition[0] + i + "_" + Integer.valueOf(actionPosition[1] - 1);
                Board.add(btnPathX, actionPosition[0] + i, actionPosition[1]);

                btnPathX.setId(id);
                arrCreatedId.add(id);
            }
        }

        return arrCreatedId;
    }
}