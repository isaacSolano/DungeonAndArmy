package DungeonAndArmy.Dice.ConcreteDice;

import DungeonAndArmy.Dice.iPrototype.Die;

public class SummoningDie extends Die {
    public SummoningDie(int pFaceAmount, String pColor) {
        this.type = "Invocacion";
        this.faces = new String[pFaceAmount];
        faces[0]="Artillero";
        faces[1]="Artillero";
        faces[2]="Infanteria";
        faces[3]="Infanteria";
        faces[4]="Infanteria";
        faces[5]="Tanque";
        this.color = pColor;
    }

    @Override
    public Die clone() {
        return new SummoningDie(this.faces.length, this.getColor());
    }
}
