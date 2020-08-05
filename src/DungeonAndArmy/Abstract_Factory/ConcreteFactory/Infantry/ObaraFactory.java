package DungeonAndArmy.Abstract_Factory.ConcreteFactory.Infantry;

import DungeonAndArmy.Abstract_Factory.AbstractFactory.Army;
import DungeonAndArmy.Abstract_Factory.AbstractProduct.Soldier;
import DungeonAndArmy.Abstract_Factory.ConcreteProduct.Infantry.Obara;

public class ObaraFactory implements Army {
    @Override
    public Soldier createSoldier() {
        Obara obara = new Obara();

        obara.setMove(3);
        obara.setLife(3);
        obara.setDefense(3);
        obara.setAttack(2);

        return obara;
    }
}
