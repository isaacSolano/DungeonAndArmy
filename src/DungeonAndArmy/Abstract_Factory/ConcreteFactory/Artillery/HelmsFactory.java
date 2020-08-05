package DungeonAndArmy.Abstract_Factory.ConcreteFactory.Artillery;

import DungeonAndArmy.Abstract_Factory.AbstractFactory.Army;
import DungeonAndArmy.Abstract_Factory.AbstractProduct.Soldier;
import DungeonAndArmy.Abstract_Factory.ConcreteProduct.Artillery.Helms;

public class HelmsFactory implements Army {
    @Override
    public Soldier createSoldier() {
        Helms helms = new Helms();
        //Hacer el set de la vida, defensa y ataque
        return helms;
    }
}
