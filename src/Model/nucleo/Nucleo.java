package Model.nucleo;

import Model.fabrica.CharacterType;
import Model.fabrica.Factory;
import Model.personagens.PersonagemBase;
import Model.prototype.Enemy;
import Model.proxy.GeradorEnemy;
import Model.proxy.GeradorProxy;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Nucleo {

    private static final Nucleo INSTANCE = new Nucleo();
    private final GeradorEnemy geradorEnemy = new GeradorProxy();

    // AS LISTAS TEM QUE ESTAR ASSIM
    private final List<PersonagemBase> players = new ArrayList<>();
    private final List<Enemy> enemies = new ArrayList<>();

    private Nucleo() {}

    public static Nucleo getInstance() {
        return INSTANCE;
    }

    public PersonagemBase createPlayer(CharacterType type, String name) {
        PersonagemBase p = Factory.createCharacter(type, name);
        players.add(p);
        return p;
    }

    public Enemy spawnEnemy(String prototypeName) {
        Enemy e = geradorEnemy.spawn(prototypeName);
        if (e != null) enemies.add(e);
        return e;
    }
    public List<PersonagemBase> getPlayers() {
        return Collections.unmodifiableList(players);
    }

    public List<Enemy> getEnemies() {
        return Collections.unmodifiableList(enemies);
    }
}
