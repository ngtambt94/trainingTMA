package observerPattern;

public interface Subject {
    
    void registerObserver(Observer observer);
    
    void refuseObserver(Observer observer);
    
    void notifyObserver();

}
