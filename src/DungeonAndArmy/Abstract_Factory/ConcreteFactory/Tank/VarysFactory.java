package DungeonAndArmy.Abstract_Factory.ConcreteFactory.Tank;

import DungeonAndArmy.Abstract_Factory.AbstractFactory.Army;
import DungeonAndArmy.Abstract_Factory.AbstractProduct.Soldier;
import DungeonAndArmy.Abstract_Factory.ConcreteProduct.Tank.Varys;

public class VarysFactory implements Army {
    @Override
    public Soldier createSoldier() {
        Varys varys = new Varys();

        varys.setMove(1);
        varys.setLife(2);
        varys.setDefense(5);
        varys.setAttack(10);

        return varys;
    }
}
