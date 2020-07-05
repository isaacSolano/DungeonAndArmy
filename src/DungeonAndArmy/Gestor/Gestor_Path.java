package DungeonAndArmy.Gestor;

import DungeonAndArmy.Helper.Path_Creator;
import DungeonAndArmy.Prototype.Prototype.Path;
import DungeonAndArmy.Prototype.iPrototype.aPath;

import java.util.ArrayList;

public class Gestor_Path {
    private Path_Creator pathCreator;
    private aPath pathPrototype;
    private ArrayList<aPath> arrPaths;

    public Gestor_Path(){
        pathCreator = new Path_Creator();
        pathPrototype = new Path(new ArrayList<>(), "prototype");
        arrPaths = new ArrayList<>();
    }

    public aPath createNewPath(ArrayList<String> arrBlocksId, String type){
        arrPaths.add( pathPrototype.clone() );

        return updateClone(arrBlocksId, type);
    }

    public aPath updateClone(ArrayList<String> arrBlocksId, String type){
        aPath pathClone = arrPaths.get( arrPaths.size()-1 );

        pathClone.setArrBlocksId( arrBlocksId );
        pathClone.setType( type );

        return pathClone;
    }
}
