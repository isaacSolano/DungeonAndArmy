package DungeonAndArmy.AbstractFactoryPattern.ConcreteFactory.Tank;

import DungeonAndArmy.AbstractFactoryPattern.AbstractFactory.Army;
import DungeonAndArmy.AbstractFactoryPattern.AbstractProduct.Soldier;
import DungeonAndArmy.AbstractFactoryPattern.ConcreteProduct.Tank.Rhaegon;

public class RhaegonFactory implements Army {
    @Override
    public Soldier createSoldier() {
        Rhaegon rhaegon = new Rhaegon();
        //Hacer el set de la vida, defensa y ataque
        return rhaegon;
    }
}
