package DungeonAndArmy.AbstractFactoryPattern.ConcreteFactory.Artillery;

import DungeonAndArmy.AbstractFactoryPattern.AbstractFactory.Army;
import DungeonAndArmy.AbstractFactoryPattern.AbstractProduct.Soldier;
import DungeonAndArmy.AbstractFactoryPattern.ConcreteProduct.Artillery.Aerys;

public class AerysFactory implements Army {

    @Override
    public Soldier createSoldier() {
        Aerys aerys = new Aerys();
        //Hacer el set de la vida, defensa y ataque
        return aerys;
    }
}
