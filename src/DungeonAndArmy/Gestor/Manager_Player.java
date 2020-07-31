package DungeonAndArmy.Gestor;

import DungeonAndArmy.Dice.Manager.DiceManager;
import DungeonAndArmy.Singleton.Round.Player;
import DungeonAndArmy.Singleton.Round.Round;

public class Manager_Player {
    private DiceManager diceManager = new DiceManager();

    Round currentRound;
    public Manager_Player() {
    }

    public String assingRound(Player player){
        currentRound = Round.setRound(player);
        diceManager.addToPlayer(player);

        return currentRound.getPlayer().toString();
    }

    public String changePlayer(Player playerA, Player playerB){
        String currentPlayer = currentRound.getPlayer().getId(),
                res = "";
        Round.removeRound();

        if (currentPlayer == "A"){
            res = assingRound(playerB);
        }else{
            res = assingRound(playerA);
        }

        return res;
    }

    public Player getCurrentPlayer(){
        return currentRound.getPlayer();
    }


}
