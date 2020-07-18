package DungeonAndArmy.AbstractFactoryPattern.ConcreteFactory.Infantry;

import DungeonAndArmy.AbstractFactoryPattern.AbstractFactory.Army;
import DungeonAndArmy.AbstractFactoryPattern.AbstractProduct.Soldier;
import DungeonAndArmy.AbstractFactoryPattern.ConcreteProduct.Infantry.Arthur;

public class ArthurFactory implements Army {
    @Override
    public Soldier createSoldier() {
        Arthur arthur = new Arthur();
        //Hacer el set de la vida, defensa y ataque
        return arthur;
    }
}
