package CreationalDesignPattern.prototype.pattern;

public class Main {
    public static void main(String[] args) {
        Weapon weapon = new Weapon("AK-47");
        GameCharacter original = new GameCharacter("Lieutenant",weapon);

        System.out.println("Original");
        String s = original.toString();
        System.out.println(s);

        // Cloned object
        GameCharacter clonedObject = original.clone();
        clonedObject.setName("Major");
        clonedObject.getWeapon().setWeaponName("Sniper");

        System.out.println("Cloned");
        String s1 = clonedObject.toString();
        System.out.println(s1);
    }
}
