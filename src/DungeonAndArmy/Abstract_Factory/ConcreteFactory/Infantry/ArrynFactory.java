package DungeonAndArmy.Abstract_Factory.ConcreteFactory.Infantry;

import DungeonAndArmy.Abstract_Factory.AbstractFactory.Army;
import DungeonAndArmy.Abstract_Factory.AbstractProduct.Soldier;
import DungeonAndArmy.Abstract_Factory.ConcreteProduct.Infantry.Arryn;

public class ArrynFactory implements Army {
    @Override
    public Soldier createSoldier() {
        Arryn arryn = new Arryn();
        arryn.setMove(1);
        arryn.setLife(1);
        arryn.setDefense(5);
        arryn.setAttack(3);

        return arryn;
    }
}
