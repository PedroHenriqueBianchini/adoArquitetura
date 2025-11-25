package proxy;

import prototype.Enemy;
import prototype.EnemyPrototypeRegistry;

public class GeradorProxy implements GeradorEnemy {

    private final GeradorReal realSpawner = new GeradorReal();
    private int spawnCount = 0;
    private final int maxSpawns = 5;

    @Override
    public Enemy spawn(String prototypeName) {

        // Correção: usar get() em vez de clone()
        Enemy prototype = EnemyPrototypeRegistry.getInstance().getPrototype(prototypeName);

        if (prototype == null) {
            System.out.println("[PROXY] ERRO: Protótipo '" + prototypeName + "' não existe.");
            return null;
        }

        if (spawnCount >= maxSpawns) {
            System.out.println("[PROXY] Limite máximo de inimigos atingido!");
            return null;
        }

        System.out.println("[PROXY] Criando inimigo do tipo: " + prototypeName);

        spawnCount++;
        return realSpawner.spawn(prototypeName);
    }
}