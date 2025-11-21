package estrategia;
import personagens.PersonagemBase;

public class MeleeAttack implements AttackStrategy {
    @Override
    public String execute(PersonagemBase character) {
        return character.getName() + " desfere um ataque corpo-a-corpo! (dano alto, alcance curto)";
    }
}