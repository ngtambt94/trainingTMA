package strategyPattern;

public class Context {

    private Calculation calculation;
    
    public Context(Calculation calculation) {
        this.calculation = calculation;
    }
    
    public int excuseCalculate(int a, int b) {
        return calculation.doCalculate(a, b);
    }
    
}
