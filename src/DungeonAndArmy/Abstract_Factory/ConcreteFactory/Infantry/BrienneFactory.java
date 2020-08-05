package DungeonAndArmy.Abstract_Factory.ConcreteFactory.Infantry;

import DungeonAndArmy.Abstract_Factory.AbstractFactory.Army;
import DungeonAndArmy.Abstract_Factory.AbstractProduct.Soldier;
import DungeonAndArmy.Abstract_Factory.ConcreteProduct.Infantry.Brienne;

public class BrienneFactory implements Army {
    @Override
    public Soldier createSoldier() {
        Brienne brienne = new Brienne();
        //Hacer el set de la vida, defensa y ataque
        return brienne;
    }
}
