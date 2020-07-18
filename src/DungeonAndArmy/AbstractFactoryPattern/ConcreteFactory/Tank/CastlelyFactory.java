package DungeonAndArmy.AbstractFactoryPattern.ConcreteFactory.Tank;

import DungeonAndArmy.AbstractFactoryPattern.AbstractFactory.Army;
import DungeonAndArmy.AbstractFactoryPattern.AbstractProduct.Soldier;
import DungeonAndArmy.AbstractFactoryPattern.ConcreteProduct.Tank.Castlely;

public class CastlelyFactory implements Army {
    @Override
    public Soldier createSoldier() {
        Castlely castlely = new Castlely();
        //Hacer el set de la vida, defensa y ataque
        return castlely;
    }
}
