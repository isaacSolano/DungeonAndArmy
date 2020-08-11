package DungeonAndArmy.Observer.Concrete;

import DungeonAndArmy.Observer.Interfaces.iSubject;

import java.util.ArrayList;

public class Subject implements iSubject {
    private int idDice;
    private ArrayList<Observer> arrObservers = new ArrayList<>();

    public void setState(int idDice){
        this.idDice = idDice;
        notifyObservers();
    }

    @Override
    public void addObserver(Observer obs) {
        arrObservers.add(obs);
    }

    @Override
    public void removeObserver(Observer obs) {
        arrObservers.remove(obs);
    }

    @Override
    public void notifyObservers() {
        for(Observer obs : arrObservers){
            obs.update(this.idDice);
        }
    }
}