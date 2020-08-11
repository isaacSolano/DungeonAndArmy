package DungeonAndArmy.Manager;

import DungeonAndArmy.Prototype.Prototype.Dices.ActionDice;
import DungeonAndArmy.Prototype.Prototype.Dices.MovementDice;
import DungeonAndArmy.Prototype.Prototype.Dices.SummoningDice;
import DungeonAndArmy.Prototype.iPrototype.Dice;
import DungeonAndArmy.Singleton.Player;

public class Manager_Dice {
    private ActionDice actionDie;
    private SummoningDice summoningDie;
    private MovementDice movementDie;

    public Manager_Dice() {
        actionDie   = new ActionDice(6,"azul");
        summoningDie = new SummoningDice(6,"rojo");
        movementDie = new MovementDice(6,"verde");
    }

    /**
     * @param player Jugador al que se le va a agregar los dados.
     */
    //para gestor player o main
    public void addToPlayer(Player player){
        player.addDice(actionDie.clone());
        player.addDice(actionDie.clone());
        player.addDice(actionDie.clone());
        player.addDice(summoningDie.clone());


//        player.addDice(actionDie.clone());
//        player.addDice(summoningDie.clone());
//        player.addDice(summoningDie.clone());
    }

	public Dice getNumDie() {
        return movementDie.clone();
	}


}