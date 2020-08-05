package DungeonAndArmy.Prototype.Prototype.Dices;

import DungeonAndArmy.Prototype.iPrototype.Dice;

public class ActionDice extends Dice {
    public ActionDice(int pFaceAmount, String pColor) {
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
    public Dice clone() {
        return new ActionDice(this.faces.length, this.getColor());
    }
}
