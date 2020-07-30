package DungeonAndArmy.Dice.Manager;

import DungeonAndArmy.Dice.ConcreteDice.ActionDie;
import DungeonAndArmy.Dice.ConcreteDice.MovementDie;
import DungeonAndArmy.Dice.ConcreteDice.SummoningDie;
import DungeonAndArmy.Dice.iPrototype.Die;
import DungeonAndArmy.Singleton.Round.Player;

import java.util.ArrayList;

public class DiceManager {
    private ActionDie actionDie = new ActionDie(6,"azul");
    private SummoningDie summoningDie = new SummoningDie(6,"rojo");
    private MovementDie movementDie = new MovementDie(6,"verde");

    public DiceManager() {

    }

    /**
     *
     * @param pId Identificador del jugador al que se le agregara el dado, puede ser 0 o 1.
     * @param pDie Dado que se va a agregar al arreglo.
     * @throws NonExistentPlayerException Excepcion si el ID del jugador es diferente de 0 o 1.
     */
    //para gestor player o main
    public void addToPlayer(Player player) throws NonExistentPlayerException {
        player.agregarDado(actionDie.clone());
        player.agregarDado(summoningDie.clone());
    }

}
