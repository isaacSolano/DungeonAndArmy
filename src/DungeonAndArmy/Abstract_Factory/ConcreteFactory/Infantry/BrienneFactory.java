package DungeonAndArmy.Abstract_Factory.ConcreteFactory.Infantry;

import DungeonAndArmy.Abstract_Factory.AbstractFactory.Army;
import DungeonAndArmy.Abstract_Factory.AbstractProduct.Soldier;
import DungeonAndArmy.Abstract_Factory.ConcreteProduct.Infantry.Brienne;

public class BrienneFactory implements Army {
    @Override
    public Soldier createSoldier() {
        Brienne brienne = new Brienne();
        brienne.setMove(4);
        brienne.setLife(4);
        brienne.setDefense(2);
        brienne.setAttack(1);

        return brienne;
    }
}
