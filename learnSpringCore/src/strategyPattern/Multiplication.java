package strategyPattern;

public class Multiplication implements Calculation {

    public Multiplication() {}
    
    @Override
    public int doCalculate(int a, int b) {
        return (a * b);
    }
    
}
