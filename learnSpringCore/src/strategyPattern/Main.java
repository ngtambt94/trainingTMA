package strategyPattern;

public class Main {

    public static void main(String[] args) {
        Context add = new Context(new Addition());
        Context sub = new Context(new Subtraction());
        Context muilty = new Context(new Multiplication());
        int a = 20;
        int b = 10;
        
        System.out.println("=====Strategy Design Pattern=====");
        System.out.println("\nAddition: " + a + " + " + b + " = " + add.excuseCalculate(a, b));
        System.out.println("\nSubtraction: " + a + " - " + b + " = " + sub.excuseCalculate(a, b));
        System.out.println("\nMuiltiplication: " + a + " * " + b + " = " + muilty.excuseCalculate(a, b));
        
    }
    
}
