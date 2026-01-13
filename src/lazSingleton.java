public class lazSingleton {
    private static volatile lazSingleton instance;
    private lazSingleton() {}

    public static lazSingleton getInstance() {
        if (instance == null) {
            synchronized (lazSingleton.class) {
                if (instance == null) {
                    instance = new lazSingleton();
                }
            }
        }
        return instance;
    }

}
