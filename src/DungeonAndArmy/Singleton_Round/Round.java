package DungeonAndArmy.Singleton_Round;

import DungeonAndArmy.Player.Player;

public class Round {
    private static Player player;
    private static Round currentRound = null;

    //Constructor
    private Round(Player player) {
        setPlayer(player);
    }

    public static Round setRound(Player player) {
        if(currentRound == null)
            currentRound = new Round(player);

        return currentRound;
    }

    public static void removeRound(){
        currentRound = null;
    }

    //Gets & Sets
    public  Player getPlayer() {
        return player;
    }


    public static void setPlayer(Player player) {
        Round.player = player;
    }

    public static Round getCurrentRound() {
        return currentRound;
    }

    public static void setCurrentRound(Round currentRound) {
        Round.currentRound = currentRound;
    }
}
