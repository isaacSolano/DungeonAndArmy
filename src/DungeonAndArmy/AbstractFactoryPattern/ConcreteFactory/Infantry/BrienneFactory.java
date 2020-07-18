package DungeonAndArmy.AbstractFactoryPattern.ConcreteFactory.Infantry;

import DungeonAndArmy.AbstractFactoryPattern.AbstractFactory.Army;
import DungeonAndArmy.AbstractFactoryPattern.AbstractProduct.Soldier;
import DungeonAndArmy.AbstractFactoryPattern.ConcreteProduct.Infantry.Brienne;

public class BrienneFactory implements Army {
    @Override
    public Soldier createSoldier() {
        Brienne brienne = new Brienne();
        //Hacer el set de la vida, defensa y ataque
        return brienne;
    }
}
