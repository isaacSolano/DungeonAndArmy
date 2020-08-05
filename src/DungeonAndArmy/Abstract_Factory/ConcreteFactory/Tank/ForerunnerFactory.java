package DungeonAndArmy.Abstract_Factory.ConcreteFactory.Tank;

import DungeonAndArmy.Abstract_Factory.AbstractFactory.Army;
import DungeonAndArmy.Abstract_Factory.AbstractProduct.Soldier;
import DungeonAndArmy.Abstract_Factory.ConcreteProduct.Tank.Forerunner;

public class ForerunnerFactory implements Army {
    @Override
    public Soldier createSoldier() {
        Forerunner forerunner = new Forerunner();

        forerunner.setMove(2);
        forerunner.setLife(2);
        forerunner.setDefense(10);
        forerunner.setAttack(5);

        return forerunner;
    }
}
