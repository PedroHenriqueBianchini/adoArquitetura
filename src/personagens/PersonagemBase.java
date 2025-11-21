package personagens;

import estrategia.AttackStrategy;

public class PersonagemBase {
    protected String name;
    protected int health;
    protected AttackStrategy attackStrategy;


    protected PersonagemBase(String name, int health) {
        this.name = name;
        this.health = health;
    }


    public String getName() { return name; }
    public int getHealth() { return health; }


    public void setAttackStrategy(AttackStrategy s) { this.attackStrategy = s; }


    public String attack() {
        if (attackStrategy == null) return name + " não tem estratégia definida.";
        return attackStrategy.execute(this);
    }


    @Override
    public String toString() {
        return String.format("%s (HP: %d)", name, health);
    }
}