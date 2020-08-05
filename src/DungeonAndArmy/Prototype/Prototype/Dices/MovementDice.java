package DungeonAndArmy.Prototype.Prototype.Dices;

import DungeonAndArmy.Prototype.iPrototype.Dice;

public class MovementDice extends Dice {
    public MovementDice(int pFaceAmount, String pColor) {
        this.type = "Accion";
        this.faces = new String[pFaceAmount];
        for (int i = 0; i < faces.length; i++) {
            this.faces[i] = "" + i + "";
        }
        this.color = pColor;
    }

    @Override
    public Dice clone() {
        return new MovementDice(this.faces.length, this.getColor());
    }
}
