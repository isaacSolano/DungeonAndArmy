package DungeonAndArmy.AbstractFactoryPattern.ConcreteFactory.Tank;

import DungeonAndArmy.AbstractFactoryPattern.AbstractFactory.Army;
import DungeonAndArmy.AbstractFactoryPattern.AbstractProduct.Soldier;
import DungeonAndArmy.AbstractFactoryPattern.ConcreteProduct.Tank.Varys;

public class VarysFactory implements Army {
    @Override
    public Soldier createSoldier() {
        Varys varys = new Varys();
        //Hacer el set de la vida, defensa y ataque
        return varys;
    }
}
