package DungeonAndArmy.AbstractFactoryPattern.AbstractFactory;

import DungeonAndArmy.AbstractFactoryPattern.AbstractProduct.Soldier;

public interface Army {
    public Soldier createSoldier();
}
