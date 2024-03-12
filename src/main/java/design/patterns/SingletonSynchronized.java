package design.patterns;

public class SingletonSynchronized {

    // the field must be declared volatile so that double check lock would work correctly.
    private static volatile SingletonSynchronized instance;

    public String value;

    private SingletonSynchronized(String value) {
        this.value = value;
    }

    public static SingletonSynchronized getInstance(String value) {

        // the approach taken here is called double-checked locking (DCL)
        // prevents race condition between multiple threads
        // that may attempt to get singleton instance at the same time,
        // creating separate instances as a result.
        //
        // there is a very important caveat when implementing DCL in Java,
        // which is solved by introducing the 'result' local variable.

        SingletonSynchronized result = instance;
        if (result != null) {
            return result;
        }
        synchronized (SingletonSynchronized.class) {
            if (instance == null) {
                instance = new SingletonSynchronized(value);
            }
            return instance;
        }
    }
}
