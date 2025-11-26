package Controller;

import Model.nucleo.Nucleo;
import Model.fabrica.CharacterType;
import Model.personagens.PersonagemBase;
import Model.estrategia.MeleeAttack;
import Model.estrategia.MagicAttack;
import Model.estrategia.RangedAttack;
import View.GameView;

public class GameController {

    private final Nucleo gm = Nucleo.getInstance();
    private final GameView view = new GameView();

    public void startGame() {

        // cria personagens
        PersonagemBase w = gm.createPlayer(CharacterType.GUERREIRO, "Thoran");
        PersonagemBase m = gm.createPlayer(CharacterType.MAGO, "Eldra");
        PersonagemBase a = gm.createPlayer(CharacterType.ARQUEIRO, "Lyra");

        // define estratégias
        w.setAttackStrategy(new MeleeAttack());
        m.setAttackStrategy(new MagicAttack());
        a.setAttackStrategy(new RangedAttack());

        // spawn de inimigos
        gm.spawnEnemy("Goblin");
        gm.spawnEnemy("Goblin");
        gm.spawnEnemy("Orc");

        // mostra status
        view.showStatus(gm);

        // ataques
        view.showAttack(w.getName() + " ataca: " + w.attack());
        view.showAttack(m.getName() + " ataca: " + m.attack());
        view.showAttack(a.getName() + " ataca: " + a.attack());

        // troca estratégia
        w.setAttackStrategy(new RangedAttack());
        view.showAttack(w.getName() + " mudou estratégia e agora: " + w.attack());

        view.showStatus(gm);
    }
}
