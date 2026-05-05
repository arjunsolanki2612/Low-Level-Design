package CreationalDesignPattern.singleton.pattern;

public class Running {
    public static void main(String[] args) {
        //Lazy initialization
        LazySingleton lazySingleton = LazySingleton.getLazyObject();
        LazySingleton lazySingleton1 = LazySingleton.getLazyObject();
        System.out.println(lazySingleton == lazySingleton1);

        //Eager initialization
        EagerSingleton eagerSingleton = EagerSingleton.getInstance();
        EagerSingleton eagerSingleton1 = EagerSingleton.getInstance();
        System.out.println(eagerSingleton == eagerSingleton1);

        //Thread safe initialization
        ThreadSafeSingleton threadSafeSingleton = ThreadSafeSingleton.getInstance();
        ThreadSafeSingleton threadSafeSingleton1 = ThreadSafeSingleton.getInstance();
        System.out.println(threadSafeSingleton == threadSafeSingleton1);

        //Double check
        DoubleCheckSingleton doubleCheckSingleton = DoubleCheckSingleton.getInstance();
        DoubleCheckSingleton doubleCheckSingleton1 = DoubleCheckSingleton.getInstance();
        System.out.println(doubleCheckSingleton == doubleCheckSingleton1);

        //Enum
        EnumSingleton enumSingleton = EnumSingleton.INSTANCE;
        EnumSingleton enumSingleton1 = EnumSingleton.INSTANCE;
        System.out.println(enumSingleton == enumSingleton1);
    }
}
