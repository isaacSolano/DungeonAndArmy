package DungeonAndArmy.Observer.Concrete;

import DungeonAndArmy.Observer.Interfaces.iObserver;
import DungeonAndArmy.Singleton.Round;

import java.io.Serializable;
import java.util.ArrayList;

public class Observer implements iObserver {
    @Override
    public void update(Serializable index) {
        ArrayList<String> arrMovementDices = Round.getCurrentRound().getPlayer().getMovementDice();
        arrMovementDices.remove( (int) index);
        Round.getCurrentRound().getPlayer().setMovementChest( arrMovementDices );
    }
}