package DungeonAndArmy.Abstract_Factory.ConcreteFactory.Infantry;

import DungeonAndArmy.Abstract_Factory.AbstractFactory.Army;
import DungeonAndArmy.Abstract_Factory.AbstractProduct.Soldier;
import DungeonAndArmy.Abstract_Factory.ConcreteProduct.Infantry.Arthur;

public class ArthurFactory implements Army {
    @Override
    public Soldier createSoldier() {
        Arthur arthur = new Arthur();
        //Hacer el set de la vida, defensa y ataque
        return arthur;
    }
}
