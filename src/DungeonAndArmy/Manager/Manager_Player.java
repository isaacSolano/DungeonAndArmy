package DungeonAndArmy.Manager;

import DungeonAndArmy.Singleton.Player;
import DungeonAndArmy.Singleton.Round;

public class Manager_Player {
    private Manager_Dice managerDice = new Manager_Dice();

    Round currentRound;
    public Manager_Player() {
    }

    public String assingRound(Player player){
        currentRound = Round.setRound(player);
        managerDice.addToPlayer(player);

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
