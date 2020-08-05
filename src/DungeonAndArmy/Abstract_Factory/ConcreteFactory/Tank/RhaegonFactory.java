package DungeonAndArmy.Abstract_Factory.ConcreteFactory.Tank;

import DungeonAndArmy.Abstract_Factory.AbstractFactory.Army;
import DungeonAndArmy.Abstract_Factory.AbstractProduct.Soldier;
import DungeonAndArmy.Abstract_Factory.ConcreteProduct.Tank.Rhaegon;

public class RhaegonFactory implements Army {
    @Override
    public Soldier createSoldier() {
        Rhaegon rhaegon = new Rhaegon();
        //Hacer el set de la vida, defensa y ataque
        return rhaegon;
    }
}
