package DungeonAndArmy.AbstractFactoryPattern.ConcreteFactory.Tank;

import DungeonAndArmy.AbstractFactoryPattern.AbstractFactory.Army;
import DungeonAndArmy.AbstractFactoryPattern.AbstractProduct.Soldier;
import DungeonAndArmy.AbstractFactoryPattern.ConcreteProduct.Tank.Forerunner;

public class ForerunnerFactory implements Army {
    @Override
    public Soldier createSoldier() {
        Forerunner forerunner = new Forerunner();
        //Hacer el set de la vida, defensa y ataque
        return forerunner;
    }
}
