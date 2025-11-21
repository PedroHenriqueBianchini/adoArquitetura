package fabrica;

import personagens.Arqueiro;
import personagens.Guerreiro;
import personagens.Mago;
import personagens.PersonagemBase;

public class Factory {
    public static PersonagemBase createCharacter(CharacterType type, String name) {
        return switch (type) {
            case GUERREIRO -> new Guerreiro(name);
            case MAGO -> new Mago(name);
            case ARQUEIRO -> new Arqueiro(name);
        };
    }
}
