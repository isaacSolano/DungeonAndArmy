package DungeonAndArmy.Dice.ConcreteDice;

import DungeonAndArmy.Dice.iPrototype.Die;

public class MovementDie extends Die {
    public MovementDie(int pFaceAmount, String pColor) {
        this.type = "Accion";
        this.faces = new String[pFaceAmount];
        for (int i = 0; i < faces.length; i++) {
            this.faces[i] = "" + i + "";
        }
        this.color = pColor;
    }

    @Override
    public Die clone() {
        return new MovementDie(this.faces.length, this.getColor());
    }
}
