package DungeonAndArmy.Gestor;

import DungeonAndArmy.Bridge.Abstract.iShape;
import DungeonAndArmy.Bridge.Shapes.*;
import DungeonAndArmy.Prototype.Prototype.Path;
import DungeonAndArmy.Prototype.iPrototype.aPath;
import javafx.scene.layout.GridPane;

import java.util.ArrayList;

public class Gestor_Path {
    private aPath pathPrototype;
    private ArrayList<aPath> arrPaths;

    public Gestor_Path(){
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
     * @return iShape The shape that was created (could be null if the spaces/blocks weren't enough).
     */
    public iShape createShape(Integer[] actionPosition, int pathRotation, String type, GridPane Board){
        iShape createdShape = null;

        switch (type){
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

        if ( createdShape.createShape(actionPosition, pathRotation) ){
            return null;
        }else{
            createdShape.paint(Board);

           return createdShape;
        }
    }
}