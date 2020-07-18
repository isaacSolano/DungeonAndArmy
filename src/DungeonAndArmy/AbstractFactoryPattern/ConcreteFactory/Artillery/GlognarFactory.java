package DungeonAndArmy.AbstractFactoryPattern.ConcreteFactory.Artillery;

import DungeonAndArmy.AbstractFactoryPattern.AbstractFactory.Army;
import DungeonAndArmy.AbstractFactoryPattern.AbstractProduct.Soldier;
import DungeonAndArmy.AbstractFactoryPattern.ConcreteProduct.Artillery.Glognar;

public class GlognarFactory implements Army {
    @Override
    public Soldier createSoldier() {
        Glognar glognar = new Glognar();
        //Hacer el set de la vida, defensa y ataque
        return glognar;
    }
}
