package CreationalDesignPattern.prototype.pattern;

public class GameCharacter implements Prototype<GameCharacter> {

    private String name;
    private Weapon weapon;

    public GameCharacter(String name, Weapon weapon){
        this.name = name;
        this.weapon = weapon;
    }
    @Override
    public GameCharacter clone() {
       Weapon clonedWeapon = new Weapon(this.weapon.getWeaponName());

       return new GameCharacter(this.name,clonedWeapon);
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Weapon getWeapon() {
        return weapon;
    }

    public void setWeapon(Weapon weapon) {
        this.weapon = weapon;
    }

    @Override
    public String toString() {
        return "GameCharacter{" +
                "name='" + name + '\'' +
                ", weapon=" + weapon.getWeaponName() +
                '}';
    }
}
