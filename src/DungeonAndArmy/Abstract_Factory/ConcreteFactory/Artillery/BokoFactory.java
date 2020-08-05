package DungeonAndArmy.Abstract_Factory.ConcreteFactory.Artillery;

import DungeonAndArmy.Abstract_Factory.AbstractFactory.Army;
import DungeonAndArmy.Abstract_Factory.AbstractProduct.Soldier;
import DungeonAndArmy.Abstract_Factory.ConcreteProduct.Artillery.Boko;

public class BokoFactory implements Army {
    @Override
    public Soldier createSoldier() {
        Boko boko = new Boko();
        //Hacer el set de la vida, defensa y ataque
        return boko;
    }
}
