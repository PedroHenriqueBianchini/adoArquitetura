package Model.prototype;


public class Enemy implements Cloneable {
    private String name;
    private int health;
    private int attackPower;


    public Enemy(String name, int health, int attackPower) {
        this.name = name;
        this.health = health;
        this.attackPower = attackPower;
    }


    // Clonagem superficial: bom para atributos primitivos e String (imutável)
    @Override
    public Enemy clone() {
        try {
            return (Enemy) super.clone();
        } catch (CloneNotSupportedException ex) {
            throw new RuntimeException(ex);
        }
    }


    // Permite ajustar propriedades depois do clone
    public void setHealth(int health) { this.health = health; }
    public void setAttackPower(int ap) { this.attackPower = ap; }


    public String getName() { return name; }
    public int getHealth() { return health; }
    public int getAttackPower() { return attackPower; }


    @Override
    public String toString() {
        return String.format("%s (HP:%d, AP:%d)", name, health, attackPower);
    }
}