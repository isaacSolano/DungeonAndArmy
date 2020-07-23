package DungeonAndArmy.Gestor;

import DungeonAndArmy.AbstractFactoryPattern.AbstractProduct.Soldier;
import DungeonAndArmy.Bridge.Abstract.iShape;
import DungeonAndArmy.Bridge.Actions.Activate;
import DungeonAndArmy.Bridge.Actions.AddMonster;
import DungeonAndArmy.Bridge.Shapes.*;
import DungeonAndArmy.Prototype.Prototype.Path;
import DungeonAndArmy.Prototype.iPrototype.aPath;
import javafx.scene.layout.GridPane;

import java.util.ArrayList;

public class Manager_Path {
    private aPath pathPrototype;
    private ArrayList<aPath> arrPaths;

    public Manager_Path(){
        pathPrototype = new Path(null, "prototype");
        arrPaths = new ArrayList<>();
    }

    /**
     * @param shape The shape that will be included on the path.
     * @param type the type of shape.
     * @return aPath The created path which will be added to the player on round.
     */
    public aPath createNewPath(iShape shape, String type){
        arrPaths.add( pathPrototype.clone() );

        return updateClone(shape, type);
    }

    /**
     * @param shape The shape that will be included on the path.
     * @param type the type of shape.
     * @return aPath The created path which will be added to the player on round.
     */
    public aPath updateClone(iShape shape, String type){
        aPath pathClone = arrPaths.get( arrPaths.size()-1 );

        pathClone.setShape( shape );
        pathClone.setType( type );

        return pathClone;
    }

    /**
     * @param actionPosition Current position where the path is wondered to be created.
     * @param pathRotation rotation selected (could be 0, 90, 180, 270).
     * @param Board Father container of all the buttons.
     * @param pathsA Paths of the player A to verify the new shape connection.
     * @param pathsB Paths of the player B to verify the new shape connection.
     * @return iShape The shape that was created (could be null if the spaces/blocks weren't enough or the shape is not connecting with others).
     */
    public iShape createShape(Integer[] actionPosition, int pathRotation, String type, GridPane Board, ArrayList<aPath> pathsA, ArrayList<aPath> pathsB, Soldier soldier){
        iShape createdShape = null;

        System.out.println(soldier);

        if( verifyNearPaths(pathsA, pathsB, actionPosition) ){
            switch (type) {
                case "L":
                    createdShape = new L();
                    break;

                case "Cruz":
                    createdShape = new Cross();
                    break;

                case "Z":
                    createdShape = new Z();
                    break;

                case "P":
                    createdShape = new P();
                    break;

                case "U":
                    createdShape = new U();
                    break;

                case "T":
                    createdShape = new T();
                    break;
            }

            createdShape.setAction( new Activate() );

            if (createdShape.createShape(actionPosition, pathRotation)) {
                return null;
            } else if( createdShape.paint(Board) ){
                    createdShape = null;
                } else {
                    createdShape.setAction( new AddMonster( soldier ) );
                    createdShape.addMonster(Board, actionPosition[0] + "_" + actionPosition[1]);
                }

                return createdShape;
        }else{
            return null;
        }
    }


    /**
     * @param pathsA All the paths created by the PlayerA.
     * @param pathsB All the paths created by the PlayerB.
     * @param actionPosition Array which contains the coord of the action in X and Y.
     * @return boolean The status of the verification, was a path found to connect the new one with or not?.
     */
    public boolean verifyNearPaths(ArrayList<aPath> pathsA, ArrayList<aPath> pathsB, Integer[] actionPosition){
        boolean nearPath = false;
        ArrayList<String> arrPossibleCoords = new ArrayList<>();

        arrPossibleCoords.add( actionPosition[0] + "_" + Integer.valueOf(actionPosition[1]+1) );
        arrPossibleCoords.add( actionPosition[0] + "_" + Integer.valueOf(actionPosition[1]-1) );
        arrPossibleCoords.add( Integer.valueOf( actionPosition[0]+1 ) + "_" + actionPosition[1] );
        arrPossibleCoords.add( Integer.valueOf( actionPosition[0]-1 ) + "_" + actionPosition[1] );

        if(pathsA.size() == 0 || pathsB.size() == 0){
            nearPath = true;
        }else{
            for(aPath path : pathsA){
                for(String shapeCoords : path.getShape().getArrCoords() ){
                    for(String possibleCoords : arrPossibleCoords){
                        if(shapeCoords.equals(possibleCoords)){
                            nearPath = true;

                            break;
                        }
                    }
                }
            }

            if(!nearPath){
                for(aPath path : pathsB){
                    for(String shapeCoords : path.getShape().getArrCoords() ){
                        for(String possibleCoords : arrPossibleCoords){
                            if(shapeCoords.equals(possibleCoords)){
                                nearPath = true;

                                break;
                            }
                        }
                    }
                }
            }
        }

        return nearPath;
    }
}