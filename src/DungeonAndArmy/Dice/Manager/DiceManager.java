package DungeonAndArmy.Dice.Manager;

import DungeonAndArmy.Dice.ConcreteDice.ActionDie;
import DungeonAndArmy.Dice.ConcreteDice.SummoningDie;
import DungeonAndArmy.Dice.iPrototype.Die;

import java.sql.PreparedStatement;
import java.util.ArrayList;

public class DiceManager {
    private static final ArrayList<Die> p0Dice = new ArrayList<>();
    private static final ArrayList<Die> p1Dice = new ArrayList<>();

    public DiceManager() {
        try {
            addToPlayer("A", new SummoningDie(6, "blue"));
            addToPlayer("B", new SummoningDie(6, "blue"));
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
    public void addToPlayer(String pId, Die pDie) throws NonExistentPlayerException {
        switch (pId) {
            default:
                throw new NonExistentPlayerException();
            case "A":
                p0Dice.add(pDie);
                break;
            case "B":
                p1Dice.add(pDie);
                break;
        }
    }

    /**
     * @param pId Numero del jugador, puede ser 0 o 1.
     * @return String de informacion de los dados que tiene el Jugador.
     * @exception NonExistentPlayerException Excepcion en caso de que el ID del jugador sea diferente de los permitidos, 0 y 1.
     */
    public String getDice(String pId) throws NonExistentPlayerException {
        String diceData = "#### Info dados del jugador " + pId + " ####";
        Die[] diceArray;
        switch (pId) {
            default:
                throw new NonExistentPlayerException();
            case "A":
                diceArray = (Die[]) p0Dice.toArray();
                break;
            case "B":
                diceArray = (Die[]) p1Dice.toArray();
                break;
        }

        for (Die data : diceArray) {
            diceData += data.getData() + "\n";
        }

        return diceData;
    }

    public void genDie(String type, String pId){
        try{
            switch (type.toLowerCase()) {
                case "summoning": case "summon":
                    addToPlayer(pId, new SummoningDie(6, "blue"));
                    break;
                case "action":
                    addToPlayer(pId, new ActionDie(6, "red"));
                default: System.out.println("No se esta creando el dado...");
        }
        } catch (NonExistentPlayerException e) {
            e.printStackTrace();
            System.out.println("El usuario en cuestion no existe.");
        }
    }

    public String getDiceCount(String player) {
        ArrayList<Die> paramDice;
        switch (player){
            case "A":
                paramDice = p0Dice;
                break;
            case "B":
                paramDice=p1Dice;
                break;
            default:
                throw new IllegalStateException("Unexpected value: " + player);
        }
        int count = 0;
        for (int i=0; i < paramDice.size();i++){
            if (paramDice.get(i).getType().equals("Summon"))
                count++;
        }
        return String.valueOf(count);
    }
}
