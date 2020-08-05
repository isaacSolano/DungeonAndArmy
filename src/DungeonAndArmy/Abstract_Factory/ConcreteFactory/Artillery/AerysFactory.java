package DungeonAndArmy.Abstract_Factory.ConcreteFactory.Artillery;

import DungeonAndArmy.Abstract_Factory.AbstractFactory.Army;
import DungeonAndArmy.Abstract_Factory.AbstractProduct.Soldier;
import DungeonAndArmy.Abstract_Factory.ConcreteProduct.Artillery.Aerys;

public class AerysFactory implements Army {

    @Override
    public Soldier createSoldier() {
        Aerys aerys = new Aerys();
        aerys.setMove(4);
        aerys.setLife(4);
        aerys.setDefense(10);
        aerys.setAttack(3);
        return aerys;
    }
}
