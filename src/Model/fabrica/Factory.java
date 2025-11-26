package Model.fabrica;

import Model.personagens.Arqueiro;
import Model.personagens.Guerreiro;
import Model.personagens.Mago;
import Model.personagens.PersonagemBase;

public class Factory {
    public static PersonagemBase createCharacter(CharacterType type, String name) {
        return switch (type) {
            case GUERREIRO -> new Guerreiro(name);
            case MAGO -> new Mago(name);
            case ARQUEIRO -> new Arqueiro(name);
        };
    }
}
