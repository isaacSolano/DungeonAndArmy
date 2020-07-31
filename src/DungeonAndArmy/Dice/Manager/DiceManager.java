package DungeonAndArmy.Dice.Manager;

import DungeonAndArmy.Dice.ConcreteDice.ActionDie;
import DungeonAndArmy.Dice.ConcreteDice.MovementDie;
import DungeonAndArmy.Dice.ConcreteDice.SummoningDie;
import DungeonAndArmy.Dice.iPrototype.Die;
import DungeonAndArmy.Singleton.Round.Player;

public class DiceManager {
    private ActionDie actionDie;
    private SummoningDie summoningDie;
    private MovementDie movementDie;

    public DiceManager() {
        actionDie   = new ActionDie(6,"azul");
        summoningDie = new SummoningDie(6,"rojo");
        movementDie = new MovementDie(6,"verde");
    }

    /**
     * @param player Jugador al que se le va a agregar los dados.
     */
    //para gestor player o main
    public void addToPlayer(Player player){
        player.agregarDado(actionDie.clone());
        player.agregarDado(summoningDie.clone());
    }

	public Die getNumDie() {
        return movementDie.clone();
	}
}
