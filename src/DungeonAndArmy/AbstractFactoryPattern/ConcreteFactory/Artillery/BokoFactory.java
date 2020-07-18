package DungeonAndArmy.AbstractFactoryPattern.ConcreteFactory.Artillery;

import DungeonAndArmy.AbstractFactoryPattern.AbstractFactory.Army;
import DungeonAndArmy.AbstractFactoryPattern.AbstractProduct.Soldier;
import DungeonAndArmy.AbstractFactoryPattern.ConcreteProduct.Artillery.Boko;

public class BokoFactory implements Army {
    @Override
    public Soldier createSoldier() {
        Boko boko = new Boko();
        //Hacer el set de la vida, defensa y ataque
        return boko;
    }
}
