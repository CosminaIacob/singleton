package design.patterns;

import design.patterns.Singleton;

public class DemoSingleThread {

    public static void main(String[] args) {
        System.out.println("""
                If you see the same value, the singleton was reused (yay!)
                If you see different values, then 2 singletons were created (booo!)
                RESULT:
                """);
        Singleton singleton = Singleton.getInstance("FOO");
        Singleton anotherSingleton = Singleton.getInstance("BAR");
        System.out.println(singleton.value);
        System.out.println(anotherSingleton.value);
    }
}
