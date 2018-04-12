package debugCode;

public class Test {
    
    public static int Subtraction(int a, int b) {
        return a  - b;
    }
    
    public static int Addition(int a, int b) {
        return a + b;
    }
    
    public static void main(String[] args) {
        
        int a = 10;
        int b = 6;
        
        int c = Subtraction(a, b);
        int d = Addition(a, b);
        int e = Subtraction(100, 10);
        
        System.out.println(c + "\n");
        System.out.println(d + "\n");
        System.out.println(e + "\n");
        
    }

}
