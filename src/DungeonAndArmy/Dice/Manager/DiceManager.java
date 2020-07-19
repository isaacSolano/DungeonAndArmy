package DungeonAndArmy.Dice.Manager;

import DungeonAndArmy.Dice.ConcreteDice.SummoningDie;
import DungeonAndArmy.Dice.iPrototype.Die;

import java.util.ArrayList;

public class DiceManager {
    private static final ArrayList<Die> p0Dice = new ArrayList<>();
    private static final ArrayList<Die> p1Dice = new ArrayList<>();

    public DiceManager() {
        try {
            addToPlayer(0, new SummoningDie(6, "azul"));
            addToPlayer(1, new SummoningDie(6, "rojo"));
        } catch (NonExistentPlayerException e) {
            e.printStackTrace();
        }
    }

    /**
     *
     * @param pId Identificador del jugador al que se le agregara el dado, puede ser 0 o 1.
     * @param pDie Dado que se va a agregar al arreglo.
     * @throws NonExistentPlayerException Excepcion si el ID del jugador es diferente de 0 o 1.
     */
    public void addToPlayer(int pId, Die pDie) throws NonExistentPlayerException {
        switch (pId) {
            default:
                throw new NonExistentPlayerException();
            case 0:
                p0Dice.add(pDie);
                break;
            case 1:
                p1Dice.add(pDie);
                break;
        }
    }

    /**
     * @param pId Numero del jugador, puede ser 0 o 1.
     * @return String de informacion de los dados que tiene el Jugador.
     * @exception NonExistentPlayerException Excepcion en caso de que el ID del jugador sea diferente de los permitidos, 0 y 1.
     */
    public String getDice(int pId) throws NonExistentPlayerException {
        String diceData = "#### Info dados del jugador " + pId + " ####";
        Die[] diceArray;
        switch (pId) {
            default:
                throw new NonExistentPlayerException();
            case 0:
                diceArray = (Die[]) p0Dice.toArray();
                break;
            case 1:
                diceArray = (Die[]) p1Dice.toArray();
                break;
        }

        for (Die data : diceArray) {
            diceData += data.getData() + "\n";
        }

        return diceData;
    }
}
