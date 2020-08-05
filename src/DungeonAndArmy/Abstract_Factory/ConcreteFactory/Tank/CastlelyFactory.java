package DungeonAndArmy.Abstract_Factory.ConcreteFactory.Tank;

import DungeonAndArmy.Abstract_Factory.AbstractFactory.Army;
import DungeonAndArmy.Abstract_Factory.AbstractProduct.Soldier;
import DungeonAndArmy.Abstract_Factory.ConcreteProduct.Tank.Castlely;

public class CastlelyFactory implements Army {
    @Override
    public Soldier createSoldier() {
        Castlely castlely = new Castlely();
        //Hacer el set de la vida, defensa y ataque
        return castlely;
    }
}
