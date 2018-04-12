package singletonPattern;

public class HelperSingleton {

    private static HelperSingleton input = new HelperSingleton();
    
    private HelperSingleton() {}
    
    public static HelperSingleton getInfo() {
        return input;
    }
    
    public void showInfo() {
        System.out.println("This is helper singleton");
    }
    
}
