package DungeonAndArmy.Abstract_Factory.ConcreteFactory.Artillery;

import DungeonAndArmy.Abstract_Factory.AbstractFactory.Army;
import DungeonAndArmy.Abstract_Factory.AbstractProduct.Soldier;
import DungeonAndArmy.Abstract_Factory.ConcreteProduct.Artillery.Glognar;

public class GlognarFactory implements Army {
    @Override
    public Soldier createSoldier() {
        Glognar glognar = new Glognar();
        glognar.setMove(3);
        glognar.setLife(3);
        glognar.setDefense(4);
        glognar.setAttack(4);
        return glognar;
    }
}
