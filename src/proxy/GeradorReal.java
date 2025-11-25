package proxy;

import prototype.Enemy;
import prototype.EnemyPrototypeRegistry;

public class GeradorReal implements GeradorEnemy {

    @Override
    public Enemy spawn(String prototypeName) {
        return EnemyPrototypeRegistry.getInstance().createFromPrototype(prototypeName);
    }
}
