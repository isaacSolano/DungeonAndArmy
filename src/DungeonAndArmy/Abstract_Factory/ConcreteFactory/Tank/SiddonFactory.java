package DungeonAndArmy.Abstract_Factory.ConcreteFactory.Tank;

import DungeonAndArmy.Abstract_Factory.AbstractFactory.Army;
import DungeonAndArmy.Abstract_Factory.AbstractProduct.Soldier;
import DungeonAndArmy.Abstract_Factory.ConcreteProduct.Tank.Siddon;

public class SiddonFactory implements Army {
    @Override
    public Soldier createSoldier() {
        Siddon siddon = new Siddon();
        //Hacer el set de la vida, defensa y ataque
        return siddon;
    }
}
