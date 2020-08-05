package DungeonAndArmy.Prototype.Prototype.Dices;

import DungeonAndArmy.Prototype.iPrototype.Dice;

public class SummoningDice extends Dice {
    public SummoningDice(int pFaceAmount, String pColor) {
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
    public Dice clone() {
        return new SummoningDice(this.faces.length, this.getColor());
    }
}
