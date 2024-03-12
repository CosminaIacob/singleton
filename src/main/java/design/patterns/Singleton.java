package design.patterns;

public final class Singleton {

    private static Singleton instance;

    public String value;

    private Singleton(String value) {
        // slow initialization
        try {
            Thread.sleep(1000);
        } catch (InterruptedException exception) {
            exception.printStackTrace();
        }
        this.value = value;
    }

    public static Singleton getInstance(String value) {
        if (instance == null) {
            instance = new Singleton(value);
        }
        return instance;
    }
}
