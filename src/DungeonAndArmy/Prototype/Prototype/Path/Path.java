package DungeonAndArmy.Prototype.Prototype.Path;

import DungeonAndArmy.Bridge.Abstract.iShape;
import DungeonAndArmy.Prototype.iPrototype.aPath;

public class Path extends aPath {
    @Override
    public aPath clone() {
        return new Path(this.getShape(), this.getType());
    }

    public Path(iShape shape, String type){
        this.setShape(shape);
        this.setType(type);
    }
}
