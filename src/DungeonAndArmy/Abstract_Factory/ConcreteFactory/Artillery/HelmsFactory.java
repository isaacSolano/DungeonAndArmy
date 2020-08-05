package DungeonAndArmy.Abstract_Factory.ConcreteFactory.Artillery;

import DungeonAndArmy.Abstract_Factory.AbstractFactory.Army;
import DungeonAndArmy.Abstract_Factory.AbstractProduct.Soldier;
import DungeonAndArmy.Abstract_Factory.ConcreteProduct.Artillery.Helms;

public class HelmsFactory implements Army {
    @Override
    public Soldier createSoldier() {
        Helms helms = new Helms();
        helms.setMove(2);
        helms.setLife(2);
        helms.setDefense(3);
        helms.setAttack(6);

        return helms;
    }
}
