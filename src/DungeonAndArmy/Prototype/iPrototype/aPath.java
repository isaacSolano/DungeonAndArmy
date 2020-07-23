package DungeonAndArmy.Prototype.iPrototype;

import DungeonAndArmy.Bridge.Abstract.iShape;

public abstract class aPath {
    private iShape shape;
    private String type;

    public abstract aPath clone();

    public iShape getShape() {
        return shape;
    }

    public void setShape(iShape shape) {
        this.shape = shape;
    }

    public String getType() {
        return type;
    }

    public void setType(String tipo) {
        this.type = tipo;
    }

    public String toString(){
        return "Block's id: " + getShape().getArrCoords() + ", for the path type: " + this.getType();
    }
}
