package DungeonAndArmy.Abstract_Factory.ConcreteFactory.Infantry;

import DungeonAndArmy.Abstract_Factory.AbstractFactory.Army;
import DungeonAndArmy.Abstract_Factory.AbstractProduct.Soldier;
import DungeonAndArmy.Abstract_Factory.ConcreteProduct.Infantry.Bronn;

public class BronnFactory implements Army {
    @Override
    public Soldier createSoldier() {
        Bronn bronn = new Bronn();
        bronn.setMove(2);
        bronn.setLife(2);
        bronn.setDefense(4);
        bronn.setAttack(3);

        return bronn;
    }
}
