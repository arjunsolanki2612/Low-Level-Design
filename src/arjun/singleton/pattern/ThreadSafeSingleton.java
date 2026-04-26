package arjun.singleton.pattern;

public class ThreadSafeSingleton {
    private static ThreadSafeSingleton instance;
    private ThreadSafeSingleton(){
        // Private constructor to prevent instantiation
        System.out.println("ThreadSafeSingleton instance created");
    }

    // Thread-safe initialization (synchronized)
    // For multiple threads safety. One thread can access the syncronized block at a time
    // preventing creation of multiple instances
    public static synchronized ThreadSafeSingleton getInstance(){
        if(instance==null){
            instance = new ThreadSafeSingleton();
        }
        return instance;
    }
}
