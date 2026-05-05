package CreationalDesignPattern.singleton.pattern;

public enum EnumSingleton {
    INSTANCE;

    EnumSingleton() {
        System.out.println("EnumSingleton Created");
    }
}