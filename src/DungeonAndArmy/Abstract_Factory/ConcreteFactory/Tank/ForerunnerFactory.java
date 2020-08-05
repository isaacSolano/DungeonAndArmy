package DungeonAndArmy.Abstract_Factory.ConcreteFactory.Tank;

import DungeonAndArmy.Abstract_Factory.AbstractFactory.Army;
import DungeonAndArmy.Abstract_Factory.AbstractProduct.Soldier;
import DungeonAndArmy.Abstract_Factory.ConcreteProduct.Tank.Forerunner;

public class ForerunnerFactory implements Army {
    @Override
    public Soldier createSoldier() {
        Forerunner forerunner = new Forerunner();
        //Hacer el set de la vida, defensa y ataque
        return forerunner;
    }
}
