package CreationalDesignPattern.prototype.pattern;

public class Weapon {
    private String weaponName;

    public String getWeaponName() {
        return weaponName;
    }

    public void setWeaponName(String weaponName) {
        this.weaponName = weaponName;
    }

    public Weapon(String weaponName){
        this.weaponName = weaponName;

    }

}
