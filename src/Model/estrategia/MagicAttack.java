package Model.estrategia;


import Model.personagens.PersonagemBase;

public class MagicAttack implements AttackStrategy {
    @Override
    public String execute(PersonagemBase character) {
        return character.getName() + " conjura uma magia de energia arcana! (dano variável, alcance longo)";
    }
}