package singletonPattern;

public class Main {
    
    public static void main(String[] args) {
//        Singleton object = Singleton.getInstance();
//        object.showMessage();
        
        HelperSingleton obj2 = HelperSingleton.getInfo();
        obj2.showInfo();
    }
    
}
