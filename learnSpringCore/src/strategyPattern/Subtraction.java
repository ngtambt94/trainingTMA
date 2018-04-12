package strategyPattern;

public class Subtraction implements Calculation {
    
    public Subtraction() {}
    
    @Override
    public int doCalculate(int a, int b) {
        return (a - b);  
    }    
    
}
