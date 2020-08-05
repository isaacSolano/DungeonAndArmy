package DungeonAndArmy.Abstract_Factory.ConcreteFactory.Artillery;

import DungeonAndArmy.Abstract_Factory.AbstractFactory.Army;
import DungeonAndArmy.Abstract_Factory.AbstractProduct.Soldier;
import DungeonAndArmy.Abstract_Factory.ConcreteProduct.Artillery.Bora;

public class BoraFactory implements Army {
    @Override
    public Soldier createSoldier() {
        Bora bora = new Bora();
        bora.setMove(4);
        bora.setLife(4);
        bora.setDefense(7);
        bora.setAttack(3);
        return bora;
    }
}
