package DungeonAndArmy.Gestor;

import DungeonAndArmy.Singleton.Round.Player;
import DungeonAndArmy.Singleton.Round.Round;

public class Gestor_Player {

    Round currentRound;
    public Gestor_Player() {
    }

    public String assingRound(Player player){
        currentRound = Round.setRound(player);

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
