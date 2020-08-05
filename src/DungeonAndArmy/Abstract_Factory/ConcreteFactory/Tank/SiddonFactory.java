package DungeonAndArmy.Abstract_Factory.ConcreteFactory.Tank;

import DungeonAndArmy.Abstract_Factory.AbstractFactory.Army;
import DungeonAndArmy.Abstract_Factory.AbstractProduct.Soldier;
import DungeonAndArmy.Abstract_Factory.ConcreteProduct.Tank.Siddon;

public class SiddonFactory implements Army {
    @Override
    public Soldier createSoldier() {
        Siddon siddon = new Siddon();

        siddon.setMove(1);
        siddon.setLife(1);
        siddon.setDefense(8);
        siddon.setAttack(8);

        return siddon;
    }
}
