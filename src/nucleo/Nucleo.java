package nucleo;

import personagens.PersonagemBase;
import fabrica.CharacterType;
import fabrica.Factory;
import prototype.Enemy;
import prototype.EnemyPrototypeRegistry;
import estrategia.*;

import java.util.ArrayList;
import java.util.List;

public class Nucleo {

    private static final Nucleo INSTANCE = new Nucleo();

    private final List<PersonagemBase> players = new ArrayList<>();
    private final List<Enemy> enemies = new ArrayList<>();

    private Nucleo() { }

    public static Nucleo getInstance() {
        return INSTANCE;
    }

    public PersonagemBase createPlayer(CharacterType type, String name) {
        PersonagemBase p = Factory.createCharacter(type, name);
        players.add(p);
        return p;
    }

    public Enemy spawnEnemy(String prototypeName) {
        Enemy e = EnemyPrototypeRegistry.getInstance().createFromPrototype(prototypeName);
        if (e != null) enemies.add(e);
        return e;
    }

    public void status() {
        System.out.println("=== Game Status ===");
        System.out.println("Players:");
        players.forEach(p -> System.out.println(" - " + p));
        System.out.println("Enemies:");
        enemies.forEach(e -> System.out.println(" - " + e));
        System.out.println("===================\n");
    }

    public static void main(String[] args) throws Exception {

        Nucleo gm = Nucleo.getInstance();

        // Cria personagens via Factory
        var w = gm.createPlayer(CharacterType.GUERREIRO, "Thoran");
        var m = gm.createPlayer(CharacterType.MAGO, "Eldra");
        var a = gm.createPlayer(CharacterType.ARQUEIRO, "Lyra");

        // Estratégias (Strategy)
        w.setAttackStrategy(new MeleeAttack());
        m.setAttackStrategy(new MagicAttack());
        a.setAttackStrategy(new RangedAttack());

        // Protótipos (Prototype)
        var registry = EnemyPrototypeRegistry.getInstance();
        registry.registerPrototype("Goblin", new Enemy("Goblin", 30, 5));
        registry.registerPrototype("Orc", new Enemy("Orc", 60, 12));

        // Clones
        gm.spawnEnemy("Goblin");
        gm.spawnEnemy("Goblin");
        gm.spawnEnemy("Orc");

        gm.status();

        // Ataques
        System.out.println(w.getName() + " ataca: " + w.attack());
        System.out.println(m.getName() + " ataca: " + m.attack());
        System.out.println(a.getName() + " ataca: " + a.attack());

        // Troca de estratégia
        w.setAttackStrategy(new RangedAttack());
        System.out.println(w.getName() + " mudou estratégia e agora: " + w.attack());

        gm.status();
    }
}
