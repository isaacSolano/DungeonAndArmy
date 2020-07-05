package DungeonAndArmy.Prototype.Prototype;

import DungeonAndArmy.Prototype.iPrototype.aPath;

import java.util.ArrayList;

public class Path extends aPath {
    @Override
    public aPath clone() {
        return new Path(this.getArrBlocksId(), this.getType());
    }

    public Path(ArrayList<String> arrBlocksId, String type){
        this.setArrBlocksId(arrBlocksId);
        this.setType(type);
    }
}
