package DungeonAndArmy.Bridge.Shapes;

import DungeonAndArmy.Bridge.Abstract.iShape;

public class Z extends iShape {

    public boolean createShape(Integer[] actionPosition, int pathRotation){
        boolean err = false;

        switch (pathRotation){
            case 90:
                if(actionPosition[0] - 2 > 0 && actionPosition[1] + 2 < 21) {
                    String idBottom = actionPosition[0] + "_" + actionPosition[1];
                    String idTop = actionPosition[0] - 2 + "_" + Integer.valueOf(actionPosition[1] + 2);
                    addCoords(idBottom);
                    addCoords(idTop);

                    for(int i = 0; i<3; i++){
                        String id = actionPosition[0] -1 + "_" + Integer.valueOf(actionPosition[1] + i);
                        addCoords(id);
                    }
                }else{
                    err = true;
                }
                break;

            case 180:
                if(actionPosition[0] + 2 < 21 && actionPosition[1] + 2 < 21){
                    String idBottom = actionPosition[0] + 2 + "_" + Integer.valueOf(actionPosition[1] + 2);
                    String idTop = actionPosition[0] + "_" + Integer.valueOf(actionPosition[1]);
                    addCoords(idBottom);
                    addCoords(idTop);

                    for(int i=0; i<3; i++){
                        String id = actionPosition[0] + i + "_" + Integer.valueOf(actionPosition[1] + 1);
                        addCoords(id);
                    }
                }else{
                    err = true;
                }
                break;

            case 270:
                if(actionPosition[0] + 2 < 21 && actionPosition[1] - 2 > 0) {
                    String idTop = actionPosition[0] + "_" + actionPosition[1];
                    String idBottom = actionPosition[0] + 2 + "_" + Integer.valueOf(actionPosition[1] - 2);
                    addCoords(idBottom);
                    addCoords(idTop);

                    for(int i = 0; i<3; i++){
                        String id = actionPosition[0] + 1 + "_" + Integer.valueOf(actionPosition[1] - i);
                        addCoords(id);
                    }
                }else{
                    err = true;
                }
                break;

            default:
                if(actionPosition[0] - 2 > 0 && actionPosition[1] - 2 > 0){
                    String idBottom = actionPosition[0] + "_" + actionPosition[1];
                    String idTop = actionPosition[0] - 2 + "_" + Integer.valueOf(actionPosition[1] - 2);
                    addCoords(idBottom);
                    addCoords(idTop);

                    for(int i=0; i<3; i++){
                        String id = actionPosition[0] - i + "_" + Integer.valueOf(actionPosition[1] - 1);
                        addCoords(id);
                    }
                }else{
                    err = true;
                }
                break;
        }

        return err;
    }
}