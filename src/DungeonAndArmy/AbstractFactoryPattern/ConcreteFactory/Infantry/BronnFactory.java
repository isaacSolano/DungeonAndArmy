package DungeonAndArmy.AbstractFactoryPattern.ConcreteFactory.Infantry;

import DungeonAndArmy.AbstractFactoryPattern.AbstractFactory.Army;
import DungeonAndArmy.AbstractFactoryPattern.AbstractProduct.Soldier;
import DungeonAndArmy.AbstractFactoryPattern.ConcreteProduct.Infantry.Bronn;

public class BronnFactory implements Army {
    @Override
    public Soldier createSoldier() {
        Bronn bronn = new Bronn();
        //Hacer el set de la vida, defensa y ataque
        return bronn;
    }
}
