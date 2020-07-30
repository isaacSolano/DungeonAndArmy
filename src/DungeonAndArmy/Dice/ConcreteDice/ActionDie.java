package DungeonAndArmy.Dice.ConcreteDice;

import DungeonAndArmy.Dice.iPrototype.Die;

public class ActionDie extends Die {
    public ActionDie(int pFaceAmount, String pColor) {
        this.type = "Accion";
        this.faces = new String[pFaceAmount];
        faces[0] = "Movimiento";
        faces[1] = "Movimiento";
        faces[2] = "Atk";
        faces[3] = "Atk";
        faces[4] = "SP";
        faces[5] = "SP";

        this.color = pColor;
    }

    @Override
    public Die clone() {
        return new ActionDie(this.faces.length, this.getColor());
    }
}
