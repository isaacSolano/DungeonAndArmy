package DungeonAndArmy.Abstract_Factory.ConcreteFactory.Tank;

import DungeonAndArmy.Abstract_Factory.AbstractFactory.Army;
import DungeonAndArmy.Abstract_Factory.AbstractProduct.Soldier;
import DungeonAndArmy.Abstract_Factory.ConcreteProduct.Tank.Castlely;

public class CastlelyFactory implements Army {
    @Override
    public Soldier createSoldier() {
        Castlely castlely = new Castlely();

        castlely.setMove(2);
        castlely.setLife(2);
        castlely.setDefense(15);
        castlely.setAttack(5);

        return castlely;
    }
}
