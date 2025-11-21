package estrategia;

import personagens.PersonagemBase;


public interface AttackStrategy {
    // retorna uma string descritiva da ação
    String execute(PersonagemBase character);
}