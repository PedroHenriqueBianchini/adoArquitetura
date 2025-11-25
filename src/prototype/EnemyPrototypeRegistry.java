package prototype;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;


public class EnemyPrototypeRegistry {
    private static final EnemyPrototypeRegistry INSTANCE = new EnemyPrototypeRegistry();
    private final Map<String, Enemy> prototypes = new ConcurrentHashMap<>();


    private EnemyPrototypeRegistry() { }

    public Enemy getPrototype(String name) {
        return prototypes.get(name);
    }



    public static EnemyPrototypeRegistry getInstance() { return INSTANCE; }


    public void registerPrototype(String name, Enemy prototype) {
        prototypes.put(name, prototype);
    }


    public Enemy createFromPrototype(String name) {
        Enemy proto = prototypes.get(name);
        if (proto == null) return null;
        return proto.clone();
    }
}