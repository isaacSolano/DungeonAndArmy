package DungeonAndArmy.Abstract_Factory.ConcreteFactory.Artillery;

import DungeonAndArmy.Abstract_Factory.AbstractFactory.Army;
import DungeonAndArmy.Abstract_Factory.AbstractProduct.Soldier;
import DungeonAndArmy.Abstract_Factory.ConcreteProduct.Artillery.Bora;

public class BoraFactory implements Army {
    @Override
    public Soldier createSoldier() {
        Bora bora = new Bora();
        //Hacer el set de la vida, defensa y ataque
        return bora;
    }
}
