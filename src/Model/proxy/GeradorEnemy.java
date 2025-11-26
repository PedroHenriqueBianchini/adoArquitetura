package Model.proxy;
import Model.prototype.Enemy;

public interface GeradorEnemy {
    Enemy spawn(String prototypeName);
}
