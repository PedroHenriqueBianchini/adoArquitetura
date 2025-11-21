package estrategia;
import personagens.PersonagemBase;

public class RangedAttack implements AttackStrategy {
    @Override
    public String execute(PersonagemBase character) {
        return character.getName() + " dispara uma flecha certeira! (dano médio, alcance médio)";
    }
}