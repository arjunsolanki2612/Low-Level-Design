package arjun.singleton.pattern;

public class EagerSingleton {
    private static EagerSingleton instance = new EagerSingleton();
    private EagerSingleton(){
        // Private constructor to prevent instantiation
        System.out.println("EagerSingleton instance created");
    }

    public static EagerSingleton getInstance(){
        // Method is static because we want to access it without creating an instance
        return instance;
    }
}
