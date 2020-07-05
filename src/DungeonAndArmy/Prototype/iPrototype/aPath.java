package DungeonAndArmy.Prototype.iPrototype;

import java.util.ArrayList;

public abstract class aPath {
    private ArrayList<String> arrBlocksId;
    private String type;

    public abstract aPath clone();

    public ArrayList<String> getArrBlocksId() {
        return arrBlocksId;
    }

    public void setArrBlocksId(ArrayList<String> arrBlocksId) {
        this.arrBlocksId = arrBlocksId;
    }

    public String getType() {
        return type;
    }

    public void setType(String tipo) {
        this.type = tipo;
    }

    public String toString(){
        String string = "Block's id: ";

        for(String blockId : arrBlocksId){
            string += blockId + ", ";
        }

        string += "for the path type: " + this.getType();

        return string;
    }
}
