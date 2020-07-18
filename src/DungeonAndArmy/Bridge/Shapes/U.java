package DungeonAndArmy.Bridge.Shapes;

import DungeonAndArmy.Bridge.Abstract.iShape;

public class U extends iShape {
    public boolean createShape(Integer[] actionPosition, int pathRotation){
        boolean err = false;

        switch (pathRotation){
            case 90:
                if(actionPosition[0] + 2 < 21 && actionPosition[1] + 1 < 21){
                    for(int i=0; i<3; i++){
                        if(i!=1){
                            String id = Integer.valueOf(actionPosition[0] + i)  + "_" + Integer.valueOf(actionPosition[1]);
                            addCoords(id);
                        }
                    }

                    for(int i=0; i<3; i++){
                        String id = actionPosition[0] + i + "_" + Integer.valueOf(actionPosition[1] + 1);
                        addCoords(id);
                    }
                }else{
                    err = true;
                }
                break;

            case 180:
                if(actionPosition[0] + 1 < 21 && actionPosition[1] - 2 > 0){
                    for(int i=0; i<3; i++){
                        if(i!=1){
                            String id = actionPosition[0] + "_" + Integer.valueOf(actionPosition[1] - i);
                            addCoords(id);
                        }
                    }

                    for(int i=0; i<3; i++){
                        String id = actionPosition[0] + 1 + "_" + Integer.valueOf(actionPosition[1] - i);
                        addCoords(id);
                    }
                }else{
                    err = true;
                }
                break;

            case 270:
                if(actionPosition[0] - 2 > 0 && actionPosition[1] - 1 > 0){
                    for(int i=0; i<3; i++){
                        if(i!=1){
                            String id = Integer.valueOf(actionPosition[0] - i)  + "_" + Integer.valueOf(actionPosition[1]);
                            addCoords(id);
                        }
                    }

                    for(int i=0; i<3; i++){
                        String id = actionPosition[0] - i + "_" + Integer.valueOf(actionPosition[1] - 1);
                        addCoords(id);
                    }
                }else{
                    err = true;
                }
                break;

            default:
                if(actionPosition[0] - 1 > 0 && actionPosition[1] + 2 < 21){
                    for(int i=0; i<3; i++){
                        if(i!=1){
                            String id = actionPosition[0] + "_" + Integer.valueOf(actionPosition[1] + i);
                            addCoords(id);
                        }
                    }

                    for(int i=0; i<3; i++){
                        String id = actionPosition[0] - 1 + "_" + Integer.valueOf(actionPosition[1] + i);
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