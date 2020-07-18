package DungeonAndArmy.AbstractFactoryPattern.ConcreteFactory.Tank;

import DungeonAndArmy.AbstractFactoryPattern.AbstractFactory.Army;
import DungeonAndArmy.AbstractFactoryPattern.AbstractProduct.Soldier;
import DungeonAndArmy.AbstractFactoryPattern.ConcreteProduct.Tank.Siddon;

public class SiddonFactory implements Army {
    @Override
    public Soldier createSoldier() {
        Siddon siddon = new Siddon();
        //Hacer el set de la vida, defensa y ataque
        return siddon;
    }
}
