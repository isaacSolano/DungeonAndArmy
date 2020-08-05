package DungeonAndArmy.Abstract_Factory.ConcreteFactory.Infantry;

import DungeonAndArmy.Abstract_Factory.AbstractFactory.Army;
import DungeonAndArmy.Abstract_Factory.AbstractProduct.Soldier;
import DungeonAndArmy.Abstract_Factory.ConcreteProduct.Infantry.Arryn;

public class ArrynFactory implements Army {
    @Override
    public Soldier createSoldier() {
        Arryn arryn = new Arryn();
        //Hacer el set de la vida, defensa y ataque
        return arryn;
    }
}
