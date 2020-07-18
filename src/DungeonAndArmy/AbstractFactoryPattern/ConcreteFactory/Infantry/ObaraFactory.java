package DungeonAndArmy.AbstractFactoryPattern.ConcreteFactory.Infantry;

import DungeonAndArmy.AbstractFactoryPattern.AbstractFactory.Army;
import DungeonAndArmy.AbstractFactoryPattern.AbstractProduct.Soldier;
import DungeonAndArmy.AbstractFactoryPattern.ConcreteProduct.Infantry.Obara;

public class ObaraFactory implements Army {
    @Override
    public Soldier createSoldier() {
        Obara obara = new Obara();
        //Hacer el set de la vida, defensa y ataque
        return obara;
    }
}
