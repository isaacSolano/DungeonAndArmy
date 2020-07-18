package DungeonAndArmy.AbstractFactoryPattern.ConcreteFactory.Artillery;

import DungeonAndArmy.AbstractFactoryPattern.AbstractFactory.Army;
import DungeonAndArmy.AbstractFactoryPattern.AbstractProduct.Soldier;
import DungeonAndArmy.AbstractFactoryPattern.ConcreteProduct.Artillery.Helms;

public class HelmsFactory implements Army {
    @Override
    public Soldier createSoldier() {
        Helms helms = new Helms();
        //Hacer el set de la vida, defensa y ataque
        return helms;
    }
}
