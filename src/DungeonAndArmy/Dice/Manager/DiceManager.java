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
     * @param player Jugador al que se le va a agregar los dados.
     */
    //para gestor player o main
    public void addToPlayer(Player player){
        player.agregarDado(actionDie.clone());
        player.agregarDado(summoningDie.clone());
    }

}
