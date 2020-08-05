package DungeonAndArmy.Abstract_Factory.ConcreteFactory.Artillery;

import DungeonAndArmy.Abstract_Factory.AbstractFactory.Army;
import DungeonAndArmy.Abstract_Factory.AbstractProduct.Soldier;
import DungeonAndArmy.Abstract_Factory.ConcreteProduct.Artillery.Aerys;

public class AerysFactory implements Army {

    @Override
    public Soldier createSoldier() {
        Aerys aerys = new Aerys();
        //Hacer el set de la vida, defensa y ataque
        return aerys;
    }
}
