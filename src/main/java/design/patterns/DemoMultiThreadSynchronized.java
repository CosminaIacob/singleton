package design.patterns;

public class DemoMultiThreadSynchronized {

    public static void main(String[] args) {
        System.out.println("""
                If you see the same value, the singleton was reused (yay!)
                If you see different values, then 2 singletons were created (booo!)
                RESULT:
                 """);
        Thread threadFoo = new Thread(new ThreadFoo());
        Thread threadBar = new Thread(new ThreadBar());
        threadFoo.start();
        threadBar.start();
    }

    static class ThreadFoo implements Runnable {

        @Override
        public void run() {
            SingletonSynchronized singleton = SingletonSynchronized.getInstance("FOO");
            System.out.println(singleton.value);
        }
    }

    static class ThreadBar implements Runnable {

        @Override
        public void run() {
            SingletonSynchronized singleton = SingletonSynchronized.getInstance("BAR");
            System.out.println(singleton.value);
        }
    }
}
