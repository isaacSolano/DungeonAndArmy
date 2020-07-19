package DungeonAndArmy.Dice.ConcreteDice;

import DungeonAndArmy.Dice.iPrototype.Die;

public class SummoningDie extends Die {
    public SummoningDie(int pFaceAmount, String pColor) {
        this.type = "Invocacion";
        this.faces = new String[pFaceAmount];
        for (int i = 1; i < faces.length; i++) {
            this.faces[i] = "" + i + "";
        }
        this.color = pColor;
    }

    @Override
    public Die clone() {
        return new SummoningDie(this.faces.length, this.getColor());
    }
}
