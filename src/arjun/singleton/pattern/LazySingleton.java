package arjun.singleton.pattern;

public class LazySingleton {

    private static LazySingleton instance;

    private LazySingleton(){
        // Private constructor to prevent instantiation
            System.out.println("LazySingleton instance created");
    }

    // Method is static because we want to access it without creating an instance
    public static LazySingleton getLazyObject(){
        if(instance==null){
            // Lazy initialization
            instance = new LazySingleton();
        }
        return instance;
    }

}
