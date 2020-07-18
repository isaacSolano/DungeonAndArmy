package DungeonAndArmy.AbstractFactoryPattern.ConcreteFactory.Infantry;

import DungeonAndArmy.AbstractFactoryPattern.AbstractFactory.Army;
import DungeonAndArmy.AbstractFactoryPattern.AbstractProduct.Soldier;
import DungeonAndArmy.AbstractFactoryPattern.ConcreteProduct.Infantry.Arryn;

public class ArrynFactory implements Army {
    @Override
    public Soldier createSoldier() {
        Arryn arryn = new Arryn();
        //Hacer el set de la vida, defensa y ataque
        return arryn;
    }
}
