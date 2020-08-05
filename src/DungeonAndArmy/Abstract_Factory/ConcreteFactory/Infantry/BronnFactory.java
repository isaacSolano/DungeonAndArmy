package DungeonAndArmy.Abstract_Factory.ConcreteFactory.Infantry;

import DungeonAndArmy.Abstract_Factory.AbstractFactory.Army;
import DungeonAndArmy.Abstract_Factory.AbstractProduct.Soldier;
import DungeonAndArmy.Abstract_Factory.ConcreteProduct.Infantry.Bronn;

public class BronnFactory implements Army {
    @Override
    public Soldier createSoldier() {
        Bronn bronn = new Bronn();
        //Hacer el set de la vida, defensa y ataque
        return bronn;
    }
}
