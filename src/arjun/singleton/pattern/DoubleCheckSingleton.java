package arjun.singleton.pattern;

public class DoubleCheckSingleton {
    private static volatile DoubleCheckSingleton instance;
    private DoubleCheckSingleton(){
        // Private constructor to prevent instantiation
        System.out.println("DoubleCheckSingleton instance created");
    }

    public static DoubleCheckSingleton getInstance(){
        if(instance==null){
            synchronized (DoubleCheckSingleton.class){
                if(instance==null){
                    instance = new DoubleCheckSingleton();
                }
            }
        }

        return instance;
    }
}
