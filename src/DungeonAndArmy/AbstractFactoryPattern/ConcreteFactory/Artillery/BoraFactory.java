package DungeonAndArmy.AbstractFactoryPattern.ConcreteFactory.Artillery;

import DungeonAndArmy.AbstractFactoryPattern.AbstractFactory.Army;
import DungeonAndArmy.AbstractFactoryPattern.AbstractProduct.Soldier;
import DungeonAndArmy.AbstractFactoryPattern.ConcreteProduct.Artillery.Bora;

public class BoraFactory implements Army {
    @Override
    public Soldier createSoldier() {
        Bora bora = new Bora();
        //Hacer el set de la vida, defensa y ataque
        return bora;
    }
}
