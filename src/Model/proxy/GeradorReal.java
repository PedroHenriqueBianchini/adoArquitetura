package Model.proxy;

import Model.prototype.Enemy;
import Model.prototype.EnemyPrototypeRegistry;

public class GeradorReal implements GeradorEnemy {

    @Override
    public Enemy spawn(String prototypeName) {
        return EnemyPrototypeRegistry.getInstance().createFromPrototype(prototypeName);
    }
}
