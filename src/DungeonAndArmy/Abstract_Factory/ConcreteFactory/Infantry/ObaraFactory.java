package DungeonAndArmy.Abstract_Factory.ConcreteFactory.Infantry;

import DungeonAndArmy.Abstract_Factory.AbstractFactory.Army;
import DungeonAndArmy.Abstract_Factory.AbstractProduct.Soldier;
import DungeonAndArmy.Abstract_Factory.ConcreteProduct.Infantry.Obara;

public class ObaraFactory implements Army {
    @Override
    public Soldier createSoldier() {
        Obara obara = new Obara();
        //Hacer el set de la vida, defensa y ataque
        return obara;
    }
}
