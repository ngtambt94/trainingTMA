package strategyPattern;

public class Addition implements Calculation {

    public Addition() {}
    
    @Override
    public int doCalculate(int a, int b) {
        return (a + b);
    }
    
}
