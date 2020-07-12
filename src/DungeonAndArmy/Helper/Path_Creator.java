package DungeonAndArmy.Helper;

import javafx.scene.control.Button;
import javafx.scene.layout.GridPane;

import java.util.ArrayList;

public class Path_Creator {
    public Path_Creator(){ }

    public ArrayList<String> createPath(String type, Button btnActionPosition, GridPane Board, int pathRotation){
        ArrayList<String> arrCreatedId = new ArrayList<>();

        switch (type){
            case "L":
                arrCreatedId = createL(btnActionPosition, Board, pathRotation);
                break;

            case "Cruz":
                arrCreatedId = createCruz(btnActionPosition, Board, pathRotation);
                break;

            case "Z":
                arrCreatedId = createZ(btnActionPosition, Board, pathRotation);
                break;

            case "P":
                arrCreatedId = createP(btnActionPosition, Board, pathRotation);
                break;

            case "U":
                arrCreatedId = createU(btnActionPosition, Board, pathRotation);
                break;

            case "T":
                arrCreatedId = createT(btnActionPosition, Board, pathRotation);
                break;

            default:
                break;
        }

        return arrCreatedId;
    }

    public ArrayList<String> createL(Button btnActionPosition, GridPane Board, int pathRotation){
        ArrayList<String> arrCreatedId = new ArrayList<>();

        Integer[] actionPosition = new Integer[2];
        actionPosition[0] = Integer.valueOf(btnActionPosition.getId().split("_")[0]);
        actionPosition[1] = Integer.valueOf(btnActionPosition.getId().split("_")[1]);

        switch (pathRotation){
            case 90:
                if(actionPosition[0] - 2 >= 1 && actionPosition[1] + 2 <= 20 ){
                    for(int i = 0; i < 2; i++){
                        String id = actionPosition[0] - i + "_" + actionPosition[1];

                        Button btnPathX = (Button) Board.getScene().lookup("#" + id);
                        btnPathX.getStyleClass().remove("natural-color");
                        btnPathX.getStyleClass().add("selected");

                        arrCreatedId.add(id);
                    }

                    for(int i = 0; i < 3; i++){
                        String id = actionPosition[0] - 2 + "_" + Integer.valueOf(actionPosition[1] + i);

                        Button btnPathX = (Button) Board.getScene().lookup("#" + id);
                        btnPathX.getStyleClass().remove("natural-color");
                        btnPathX.getStyleClass().add("selected");

                        arrCreatedId.add(id);
                    }
                }else{
                    arrCreatedId = null;
                }
                break;

            case 180:
                if(actionPosition[0] + 2 < 21 && actionPosition[1] + 2 < 21) {
                    for (int i = 0; i < 3; i++) {
                        String id = actionPosition[0] + "_" + Integer.valueOf(actionPosition[1] + i);

                        Button btnPathX = (Button) Board.getScene().lookup("#" + id);
                        btnPathX.getStyleClass().remove("natural-color");
                        btnPathX.getStyleClass().add("selected");

                        arrCreatedId.add(id);
                    }

                    for (int i = 1; i < 3; i++) {
                        String id = actionPosition[0] + i  + "_" + Integer.valueOf(actionPosition[1] + 2);

                        Button btnPathY = (Button) Board.getScene().lookup("#" + id);
                        btnPathY.getStyleClass().remove("natural-color");
                        btnPathY.getStyleClass().add("selected");

                        arrCreatedId.add(id);
                    }
                }else{
                    arrCreatedId = null;
                }
                break;

            case 270:
                if(actionPosition[0] + 2 < 21 && actionPosition[1] - 2 > 0 ){
                    for(int i = 0; i < 2; i++){
                        String id = actionPosition[0] + i + "_" + actionPosition[1];

                        Button btnPathX = (Button) Board.getScene().lookup("#" + id);
                        btnPathX.getStyleClass().remove("natural-color");
                        btnPathX.getStyleClass().add("selected");

                        arrCreatedId.add(id);
                    }

                    for(int i = 0; i < 3; i++){
                        String id = actionPosition[0] + 2 + "_" + Integer.valueOf(actionPosition[1] - i);

                        Button btnPathX = (Button) Board.getScene().lookup("#" + id);
                        btnPathX.getStyleClass().remove("natural-color");
                        btnPathX.getStyleClass().add("selected");

                        arrCreatedId.add(id);
                    }
                }else{
                    arrCreatedId = null;
                }
                break;

            default:
                if(actionPosition[0] - 2 > 0 && actionPosition[1] - 2 > 0 ){
                    for(int i = 1; i < 2; i++){
                        String id = actionPosition[0] + "_" + Integer.valueOf(actionPosition[1] - i);

                        Button btnPathX = (Button) Board.getScene().lookup("#" + id);
                        btnPathX.getStyleClass().remove("natural-color");
                        btnPathX.getStyleClass().add("selected");

                        arrCreatedId.add(id);
                    }

                    for(int i = 0; i < 3; i++){
                        String id = actionPosition[0] - i + "_" + Integer.valueOf(actionPosition[1] - 2);

                        Button btnPathX = (Button) Board.getScene().lookup("#" + id);
                        btnPathX.getStyleClass().remove("natural-color");
                        btnPathX.getStyleClass().add("selected");

                        arrCreatedId.add(id);
                    }
                }else{
                    arrCreatedId = null;
                }
                break;
        }

        return arrCreatedId;
    }

    public ArrayList<String> createCruz(Button btnActionPosition, GridPane Board, int pathRotation){
        ArrayList<String> arrCreatedId = new ArrayList<>();

        Integer[] actionPosition = new Integer[2];
        actionPosition[0] = Integer.valueOf(btnActionPosition.getId().split("_")[0]);
        actionPosition[1] = Integer.valueOf(btnActionPosition.getId().split("_")[1]);

        switch (pathRotation){
            case 90:
                if(actionPosition[1] + 1 < 20 && (actionPosition[0] - 1 > 0 && actionPosition[0] + 1 < 21) ){
                    for(int i=0; i<3; i++){
                        String id = actionPosition[0] + "_" + Integer.valueOf(actionPosition[1] + i);

                        Button btnPathY = (Button) Board.getScene().lookup("#" + id);
                        btnPathY.getStyleClass().remove("natural-color");
                        btnPathY.getStyleClass().add("selected");

                        arrCreatedId.add(id);
                    }

                    for(int i=-1; i<2; i++) {
                        if (i != 0) {
                            String id = actionPosition[0] + i + "_" + Integer.valueOf(actionPosition[1] + 1);

                            Button btnPathx = (Button) Board.getScene().lookup("#" + id);
                            btnPathx.getStyleClass().remove("natural-color");
                            btnPathx.getStyleClass().add("selected");

                            arrCreatedId.add(id);
                        }
                    }
                }else{
                    arrCreatedId = null;
                }
                break;

            case 180:
                if(actionPosition[0] + 1 < 20 && (actionPosition[1] - 1 > 0 && actionPosition[1] + 1 < 21) ){
                    for(int i=0; i<3; i++){
                        String id = Integer.valueOf(actionPosition[0] + i) + "_" + actionPosition[1];

                        Button btnPathY = (Button) Board.getScene().lookup("#" + id);
                        btnPathY.getStyleClass().remove("natural-color");
                        btnPathY.getStyleClass().add("selected");

                        arrCreatedId.add(id);
                    }

                    for(int i=-1; i<2; i++) {
                        if (i != 0) {
                            String id =  actionPosition[0] + 1 + "_" + Integer.valueOf(actionPosition[1] + i);

                            Button btnPathx = (Button) Board.getScene().lookup("#" + id);
                            btnPathx.getStyleClass().remove("natural-color");
                            btnPathx.getStyleClass().add("selected");

                            arrCreatedId.add(id);
                        }
                    }
                }else{
                    arrCreatedId = null;
                }
                break;

            case 270:
                if(actionPosition[1] - 2 > 0 && (actionPosition[0] - 1 > 0 && actionPosition[0] + 1 < 21) ){
                    for(int i=0; i<3; i++){
                        String id = actionPosition[0] + "_" + Integer.valueOf(actionPosition[1] - i);

                        Button btnPathY = (Button) Board.getScene().lookup("#" + id);
                        btnPathY.getStyleClass().remove("natural-color");
                        btnPathY.getStyleClass().add("selected");

                        arrCreatedId.add(id);
                    }

                    for(int i=-1; i<2; i++){
                        if(i !=0 ){
                            String id = actionPosition[0] + i + "_" + Integer.valueOf(actionPosition[1] - 1);

                            Button btnPathX = (Button) Board.getScene().lookup("#" + id);
                            btnPathX.getStyleClass().remove("natural-color");
                            btnPathX.getStyleClass().add("selected");

                            arrCreatedId.add(id);
                        }
                    }
                }else{
                    arrCreatedId = null;
                }
                break;

            default:
                if(actionPosition[0] - 2 > 0 && (actionPosition[1] - 1 > 0 && actionPosition[1] + 1 < 20) ){
                    for(int i=0; i<3; i++){
                        String id = actionPosition[0] - i + "_" + actionPosition[1];

                        Button btnPathY = (Button) Board.getScene().lookup("#" + id);
                        btnPathY.getStyleClass().remove("natural-color");
                        btnPathY.getStyleClass().add("selected");

                        arrCreatedId.add(id);
                    }

                    for(int i=-1; i<2; i++){
                        if(i !=0 ){
                            String id = actionPosition[0] - 1 + "_" + Integer.valueOf(actionPosition[1] + i);

                            Button btnPathX = (Button) Board.getScene().lookup("#" + id);
                            btnPathX.getStyleClass().remove("natural-color");
                            btnPathX.getStyleClass().add("selected");

                            arrCreatedId.add(id);
                        }
                    }
                }else{
                    arrCreatedId = null;
                }
                break;
        }

        return arrCreatedId;
    }

    public ArrayList<String> createZ(Button btnActionPosition, GridPane Board, int pathRotation){
        ArrayList<String> arrCreatedId = new ArrayList<>();

        Integer[] actionPosition = new Integer[2];
        actionPosition[0] = Integer.valueOf(btnActionPosition.getId().split("_")[0]);
        actionPosition[1] = Integer.valueOf(btnActionPosition.getId().split("_")[1]);

        switch (pathRotation){
            case 90:
                if(actionPosition[0] - 2 > 0 && actionPosition[1] + 2 < 21) {
                    String idBottom = actionPosition[0] + "_" + actionPosition[1];
                    String idTop = actionPosition[0] - 2 + "_" + Integer.valueOf(actionPosition[1] + 2);

                    Button btnPathBottom = (Button) Board.getScene().lookup("#" + idBottom);
                    btnPathBottom.getStyleClass().remove("natural-color");
                    btnPathBottom.getStyleClass().add("selected");

                    Button btnPathTop = (Button) Board.getScene().lookup("#" + idTop);
                    btnPathTop.getStyleClass().remove("natural-color");
                    btnPathTop.getStyleClass().add("selected");

                    arrCreatedId.add(idBottom);
                    arrCreatedId.add(idTop);

                    for(int i = 0; i<3; i++){
                        String id = actionPosition[0] -1 + "_" + Integer.valueOf(actionPosition[1] + i);

                        Button btnPathX = (Button) Board.getScene().lookup("#" + id);
                        btnPathX.getStyleClass().remove("natural-color");
                        btnPathX.getStyleClass().add("selected");

                        arrCreatedId.add(id);
                    }
                }else{
                    arrCreatedId = null;
                }
                break;

            case 180:
                if(actionPosition[0] + 2 < 21 && actionPosition[1] + 2 < 21){
                    String idBottom = actionPosition[0] + 2 + "_" + Integer.valueOf(actionPosition[1] + 2);
                    Button btnPathBottom = (Button) Board.getScene().lookup("#" + idBottom);
                    btnPathBottom.getStyleClass().remove("natural-color");
                    btnPathBottom.getStyleClass().add("selected");

                    String idTop = actionPosition[0] + "_" + Integer.valueOf(actionPosition[1]);
                    Button btnPathTop = (Button) Board.getScene().lookup("#" + idTop);
                    btnPathTop.getStyleClass().remove("natural-color");
                    btnPathTop.getStyleClass().add("selected");

                    arrCreatedId.add(idBottom);
                    arrCreatedId.add(idTop);

                    for(int i=0; i<3; i++){
                        String id = actionPosition[0] + i + "_" + Integer.valueOf(actionPosition[1] + 1);
                        Button btnPathY = (Button) Board.getScene().lookup("#" + id);
                        btnPathY.getStyleClass().remove("natural-color");
                        btnPathY.getStyleClass().add("selected");

                        arrCreatedId.add(id);
                    }
                }else{
                    arrCreatedId = null;
                }
                break;

            case 270:
                if(actionPosition[0] + 2 < 21 && actionPosition[1] - 2 > 0) {
                    String idTop = actionPosition[0] + "_" + actionPosition[1];
                    String idBottom = actionPosition[0] + 2 + "_" + Integer.valueOf(actionPosition[1] - 2);

                    Button btnPathBottom = (Button) Board.getScene().lookup("#" + idBottom);
                    btnPathBottom.getStyleClass().remove("natural-color");
                    btnPathBottom.getStyleClass().add("selected");

                    Button btnPathTop = (Button) Board.getScene().lookup("#" + idTop);
                    btnPathTop.getStyleClass().remove("natural-color");
                    btnPathTop.getStyleClass().add("selected");

                    arrCreatedId.add(idBottom);
                    arrCreatedId.add(idTop);

                    for(int i = 0; i<3; i++){
                        String id = actionPosition[0] + 1 + "_" + Integer.valueOf(actionPosition[1] - i);

                        Button btnPathX = (Button) Board.getScene().lookup("#" + id);
                        btnPathX.getStyleClass().remove("natural-color");
                        btnPathX.getStyleClass().add("selected");

                        arrCreatedId.add(id);
                    }
                }else{
                    arrCreatedId = null;
                }
                break;

            default:
                if(actionPosition[0] - 2 > 0 && actionPosition[1] - 2 > 0){
                    String idBottom = actionPosition[0] + "_" + actionPosition[1];
                    Button btnPathBottom = (Button) Board.getScene().lookup("#" + idBottom);
                    btnPathBottom.getStyleClass().remove("natural-color");
                    btnPathBottom.getStyleClass().add("selected");

                    String idTop = actionPosition[0] - 2 + "_" + Integer.valueOf(actionPosition[1] - 2);
                    Button btnPathTop = (Button) Board.getScene().lookup("#" + idTop);
                    btnPathTop.getStyleClass().remove("natural-color");
                    btnPathTop.getStyleClass().add("selected");

                    arrCreatedId.add(idBottom);
                    arrCreatedId.add(idTop);

                    for(int i=0; i<3; i++){
                        String id = actionPosition[0] - i + "_" + Integer.valueOf(actionPosition[1] - 1);
                        Button btnPathY = (Button) Board.getScene().lookup("#" + id);
                        btnPathY.getStyleClass().remove("natural-color");
                        btnPathY.getStyleClass().add("selected");
                        arrCreatedId.add(id);
                    }
                }else{
                    arrCreatedId = null;
                }
                break;
            }

        return arrCreatedId;
    }

    public ArrayList<String> createP(Button btnActionPosition, GridPane Board, int pathRotation){
        ArrayList<String> arrCreatedId = new ArrayList<>();

        Integer[] actionPosition = new Integer[2];
        actionPosition[0] = Integer.valueOf(btnActionPosition.getId().split("_")[0]);
        actionPosition[1] = Integer.valueOf(btnActionPosition.getId().split("_")[1]);

        switch (pathRotation){
            case 90:
                if(actionPosition[0] + 1 < 21 && actionPosition[1] + 2 < 21){
                    for(int i=0; i<3; i++){
                        String id = actionPosition[0] + "_" + Integer.valueOf(actionPosition[1] + i);

                        Button btnPathX = (Button) Board.getScene().lookup("#" + id);
                        btnPathX.getStyleClass().remove("natural-color");
                        btnPathX.getStyleClass().add("selected");
                    }

                    for(int i=1; i<3; i++){
                        String id = Integer.valueOf(actionPosition[0] + 1) + "_" + Integer.valueOf(actionPosition[1] + i);

                        Button btnPathX = (Button) Board.getScene().lookup("#" + id);
                        btnPathX.getStyleClass().remove("natural-color");
                        btnPathX.getStyleClass().add("selected");
                    }
                }else{
                    arrCreatedId = null;
                }
                break;

            case 180:
                if(actionPosition[0] + 2 < 21 && actionPosition[1] - 1 > 0){
                    for(int i=0; i<3; i++){
                        String id = Integer.valueOf(actionPosition[0] + i) + "_" + actionPosition[1];

                        Button btnPathX = (Button) Board.getScene().lookup("#" + id);
                        btnPathX.getStyleClass().remove("natural-color");
                        btnPathX.getStyleClass().add("selected");
                    }

                    for(int i=1; i<3; i++){
                        String id = Integer.valueOf(actionPosition[0] + i) + "_" + Integer.valueOf(actionPosition[1] - 1);

                        Button btnPathX = (Button) Board.getScene().lookup("#" + id);
                        btnPathX.getStyleClass().remove("natural-color");
                        btnPathX.getStyleClass().add("selected");
                    }
                }else{
                    arrCreatedId = null;
                }
                break;

            case 270:
                if(actionPosition[0] - 1 > 0 && actionPosition[1] - 2 > 0){
                    for(int i=0; i<3; i++){
                        String id = actionPosition[0] + "_" + Integer.valueOf(actionPosition[1] - i);

                        Button btnPathX = (Button) Board.getScene().lookup("#" + id);
                        btnPathX.getStyleClass().remove("natural-color");
                        btnPathX.getStyleClass().add("selected");
                    }

                    for(int i=1; i<3; i++){
                        String id = Integer.valueOf(actionPosition[0] - 1) + "_" + Integer.valueOf(actionPosition[1] - i);

                        Button btnPathX = (Button) Board.getScene().lookup("#" + id);
                        btnPathX.getStyleClass().remove("natural-color");
                        btnPathX.getStyleClass().add("selected");
                    }
                }else{
                    arrCreatedId = null;
                }
                break;

            default:
                if(actionPosition[0] - 2 > 0 && actionPosition[1] + 1 < 21){
                    for(int i=0; i<3; i++){
                        String id = Integer.valueOf(actionPosition[0] - i) + "_" + actionPosition[1];

                        Button btnPathX = (Button) Board.getScene().lookup("#" + id);
                        btnPathX.getStyleClass().remove("natural-color");
                        btnPathX.getStyleClass().add("selected");

                        arrCreatedId.add(id);
                    }

                    for(int i=1; i<3; i++){
                        String id = Integer.valueOf(actionPosition[0] - i) + "_" + Integer.valueOf(actionPosition[1] + 1);

                        Button btnPathX = (Button) Board.getScene().lookup("#" + id);
                        btnPathX.getStyleClass().remove("natural-color");
                        btnPathX.getStyleClass().add("selected");

                        arrCreatedId.add(id);
                    }
                }else{
                    arrCreatedId = null;
                }
                break;
        }

        return arrCreatedId;
    }

    public ArrayList<String> createU(Button btnActionPosition, GridPane Board, int pathRotation){
        ArrayList<String> arrCreatedId = new ArrayList<>();

        Integer[] actionPosition = new Integer[2];
        actionPosition[0] = Integer.valueOf(btnActionPosition.getId().split("_")[0]);
        actionPosition[1] = Integer.valueOf(btnActionPosition.getId().split("_")[1]);

        switch (pathRotation){
            case 90:
                if(actionPosition[0] + 2 < 21 && actionPosition[1] + 1 < 21){
                    for(int i=0; i<3; i++){
                        if(i!=1){
                            String id = Integer.valueOf(actionPosition[0] + i)  + "_" + Integer.valueOf(actionPosition[1]);

                            Button btnPathY = (Button) Board.getScene().lookup("#" + id);
                            btnPathY.getStyleClass().remove("natural-color");
                            btnPathY.getStyleClass().add("selected");

                            arrCreatedId.add(id);
                        }
                    }

                    for(int i=0; i<3; i++){
                        String id = actionPosition[0] + i + "_" + Integer.valueOf(actionPosition[1] + 1);

                        Button btnPathY = (Button) Board.getScene().lookup("#" + id);
                        btnPathY.getStyleClass().remove("natural-color");
                        btnPathY.getStyleClass().add("selected");

                        arrCreatedId.add(id);
                    }
                }else{
                    arrCreatedId = null;
                }
                break;

            case 180:
                if(actionPosition[0] + 1 < 21 && actionPosition[1] - 2 > 0){
                    for(int i=0; i<3; i++){
                        if(i!=1){
                            String id = actionPosition[0] + "_" + Integer.valueOf(actionPosition[1] - i);

                            Button btnPathY = (Button) Board.getScene().lookup("#" + id);
                            btnPathY.getStyleClass().remove("natural-color");
                            btnPathY.getStyleClass().add("selected");

                            arrCreatedId.add(id);
                        }
                    }

                    for(int i=0; i<3; i++){
                        String id = actionPosition[0] + 1 + "_" + Integer.valueOf(actionPosition[1] - i);

                        Button btnPathY = (Button) Board.getScene().lookup("#" + id);
                        btnPathY.getStyleClass().remove("natural-color");
                        btnPathY.getStyleClass().add("selected");

                        arrCreatedId.add(id);
                    }
                }else{
                    arrCreatedId = null;
                }
                break;

            case 270:
                if(actionPosition[0] - 2 > 0 && actionPosition[1] - 1 > 0){
                    for(int i=0; i<3; i++){
                        if(i!=1){
                            String id = Integer.valueOf(actionPosition[0] - i)  + "_" + Integer.valueOf(actionPosition[1]);

                            Button btnPathY = (Button) Board.getScene().lookup("#" + id);
                            btnPathY.getStyleClass().remove("natural-color");
                            btnPathY.getStyleClass().add("selected");

                            arrCreatedId.add(id);
                        }
                    }

                    for(int i=0; i<3; i++){
                        String id = actionPosition[0] - i + "_" + Integer.valueOf(actionPosition[1] - 1);

                        Button btnPathY = (Button) Board.getScene().lookup("#" + id);
                        btnPathY.getStyleClass().remove("natural-color");
                        btnPathY.getStyleClass().add("selected");

                        arrCreatedId.add(id);
                    }
                }else{
                    arrCreatedId = null;
                }
                break;

            default:
                if(actionPosition[0] - 1 > 0 && actionPosition[1] + 2 < 21){
                    for(int i=0; i<3; i++){
                        if(i!=1){
                            String id = actionPosition[0] + "_" + Integer.valueOf(actionPosition[1] + i);

                            Button btnPathY = (Button) Board.getScene().lookup("#" + id);
                            btnPathY.getStyleClass().remove("natural-color");
                            btnPathY.getStyleClass().add("selected");

                            arrCreatedId.add(id);
                        }
                    }

                    for(int i=0; i<3; i++){
                        String id = actionPosition[0] - 1 + "_" + Integer.valueOf(actionPosition[1] + i);

                        Button btnPathY = (Button) Board.getScene().lookup("#" + id);
                        btnPathY.getStyleClass().remove("natural-color");
                        btnPathY.getStyleClass().add("selected");

                        arrCreatedId.add(id);
                    }
                }else{
                    arrCreatedId = null;
                }
                break;
        }

        return arrCreatedId;
    }

    public ArrayList<String> createT(Button btnActionPosition, GridPane Board, int pathRotation){
        ArrayList<String> arrCreatedId = new ArrayList<>();

        Integer[] actionPosition = new Integer[2];
        actionPosition[0] = Integer.valueOf(btnActionPosition.getId().split("_")[0]);
        actionPosition[1] = Integer.valueOf(btnActionPosition.getId().split("_")[1]);

        switch (pathRotation){
            case 90:
                if(actionPosition[0] + 1 < 21 && actionPosition[0] - 1 > 0 && actionPosition[1] + 2 < 21) {
                    for (int i = -1; i < 2; i++) {
                        String id = Integer.valueOf(actionPosition[0] - i) + "_" + actionPosition[1];
                        Button btnPathX = (Button) Board.getScene().lookup("#" + id);

                        btnPathX.getStyleClass().remove("natural-color");
                        btnPathX.getStyleClass().add("selected");

                        arrCreatedId.add(id);
                    }

                    for (int i = 1; i < 3; i++) {
                        String id = actionPosition[0] + "_" + Integer.valueOf(actionPosition[1] + i);

                        Button btnPathY = (Button) Board.getScene().lookup("#" + id);
                        btnPathY.getStyleClass().remove("natural-color");
                        btnPathY.getStyleClass().add("selected");

                        arrCreatedId.add(id);
                    }
                }else{
                    arrCreatedId = null;
                }
                break;

            case 180:
                if(actionPosition[0] + 2 < 21 && actionPosition[1] - 1 > 0 && actionPosition[1] + 1 < 21) {
                    for (int i = -1; i < 2; i++) {
                        String id = actionPosition[0] + "_" + Integer.valueOf(actionPosition[1] + i);
                        Button btnPathX = (Button) Board.getScene().lookup("#" + id);

                        btnPathX.getStyleClass().remove("natural-color");
                        btnPathX.getStyleClass().add("selected");

                        arrCreatedId.add(id);
                    }

                    for (int i = 1; i < 3; i++) {
                        String id = Integer.valueOf(actionPosition[0] + i) + "_" + actionPosition[1];

                        Button btnPathY = (Button) Board.getScene().lookup("#" + id);
                        btnPathY.getStyleClass().remove("natural-color");
                        btnPathY.getStyleClass().add("selected");

                        arrCreatedId.add(id);
                    }
                }else{
                    arrCreatedId = null;
                }
                break;

            case 270:
                if(actionPosition[0] + 1 < 21 && actionPosition[0] - 1 > 0 && actionPosition[1] - 2 > 0) {
                    for (int i = -1; i < 2; i++) {
                        String id = Integer.valueOf(actionPosition[0] - i) + "_" + actionPosition[1];
                        Button btnPathX = (Button) Board.getScene().lookup("#" + id);

                        btnPathX.getStyleClass().remove("natural-color");
                        btnPathX.getStyleClass().add("selected");

                        arrCreatedId.add(id);
                    }

                    for (int i = 1; i < 3; i++) {
                        String id = actionPosition[0] + "_" + Integer.valueOf(actionPosition[1] - i);

                        Button btnPathY = (Button) Board.getScene().lookup("#" + id);
                        btnPathY.getStyleClass().remove("natural-color");
                        btnPathY.getStyleClass().add("selected");

                        arrCreatedId.add(id);
                    }
                }else{
                    arrCreatedId = null;
                }
                break;

            default:
                if(actionPosition[0] - 2 > 0 && actionPosition[1] - 1 > 0 && actionPosition[1] + 1 < 21) {
                    for (int i = -1; i < 2; i++) {
                        String id = actionPosition[0] + "_" + Integer.valueOf(actionPosition[1] + i);
                        Button btnPathX = (Button) Board.getScene().lookup("#" + id);

                        btnPathX.getStyleClass().remove("natural-color");
                        btnPathX.getStyleClass().add("selected");

                        arrCreatedId.add(id);
                    }

                    for (int i = 1; i < 3; i++) {
                        String id = Integer.valueOf(actionPosition[0] - i) + "_" + actionPosition[1];

                        Button btnPathY = (Button) Board.getScene().lookup("#" + id);
                        btnPathY.getStyleClass().remove("natural-color");
                        btnPathY.getStyleClass().add("selected");

                        arrCreatedId.add(id);
                    }
                }else{
                    arrCreatedId = null;
                }
                break;
        }

        return arrCreatedId;
    }
}