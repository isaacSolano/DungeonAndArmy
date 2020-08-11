package DungeonAndArmy.Observer.Interfaces;

import DungeonAndArmy.Observer.Concrete.Observer;

public interface iSubject {
    void addObserver(Observer obs);
    void removeObserver(Observer obs);
    void notifyObservers();
}