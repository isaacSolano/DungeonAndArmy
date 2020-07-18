package DungeonAndArmy.Bridge.Shapes;

import DungeonAndArmy.Bridge.Abstract.iShape;

public class T extends iShape {

    public boolean createShape(Integer[] actionPosition, int pathRotation){
        boolean err = false;

        switch (pathRotation){
            case 90:
                if(actionPosition[0] + 1 < 21 && actionPosition[0] - 1 > 0 && actionPosition[1] + 2 < 21) {
                    for (int i = -1; i < 2; i++) {
                        String id = Integer.valueOf(actionPosition[0] - i) + "_" + actionPosition[1];
                        addCoords(id);
                    }

                    for (int i = 1; i < 3; i++) {
                        String id = actionPosition[0] + "_" + Integer.valueOf(actionPosition[1] + i);
                        addCoords(id);
                    }
                }else{
                    err = true;
                }
                break;

            case 180:
                if(actionPosition[0] + 2 < 21 && actionPosition[1] - 1 > 0 && actionPosition[1] + 1 < 21) {
                    for (int i = -1; i < 2; i++) {
                        String id = actionPosition[0] + "_" + Integer.valueOf(actionPosition[1] + i);
                        addCoords(id);
                    }

                    for (int i = 1; i < 3; i++) {
                        String id = Integer.valueOf(actionPosition[0] + i) + "_" + actionPosition[1];
                        addCoords(id);
                    }
                }else{
                    err = true;
                }
                break;

            case 270:
                if(actionPosition[0] + 1 < 21 && actionPosition[0] - 1 > 0 && actionPosition[1] - 2 > 0) {
                    for (int i = -1; i < 2; i++) {
                        String id = Integer.valueOf(actionPosition[0] - i) + "_" + actionPosition[1];
                        addCoords(id);
                    }

                    for (int i = 1; i < 3; i++) {
                        String id = actionPosition[0] + "_" + Integer.valueOf(actionPosition[1] - i);
                        addCoords(id);
                    }
                }else{
                    err = true;
                }
                break;

            default:
                if(actionPosition[0] - 2 > 0 && actionPosition[1] - 1 > 0 && actionPosition[1] + 1 < 21) {
                    for (int i = -1; i < 2; i++) {
                        String id = actionPosition[0] + "_" + Integer.valueOf(actionPosition[1] + i);
                        addCoords(id);
                    }

                    for (int i = 1; i < 3; i++) {
                        String id = Integer.valueOf(actionPosition[0] - i) + "_" + actionPosition[1];
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