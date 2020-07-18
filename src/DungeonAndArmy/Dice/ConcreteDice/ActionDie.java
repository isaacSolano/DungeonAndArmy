package DungeonAndArmy.Dice.ConcreteDice;

import DungeonAndArmy.Dice.iPrototype.Die;

public class ActionDie extends Die {
    public ActionDie(int pFaceAmount, String pColor) {
        this.type = "Accion";
        this.faces = new String[pFaceAmount];
        for (int i = 1; i < faces.length; i++) {
            this.faces[i] = "" + i + "";
        }
        this.color = pColor;
    }

    @Override
    public Die clone() {
        return new ActionDie(this.faces.length, this.getColor());
    }
}
