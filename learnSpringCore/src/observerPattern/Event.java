package observerPattern;

import java.util.ArrayList;
import java.util.List;

public class Event implements Subject {

    private String eventName;
    
    private List<Observer> observers = new ArrayList<Observer>();
    
    public Event(String eventName) {
        this.eventName = eventName;
    }
    
    @Override
    public void registerObserver(Observer observer) {
        observers.add(observer);
    }
    
    @Override
    public void refuseObserver(Observer observer) {
        observers.remove(observer);
    }
    
    @Override
    public void notifyObserver() {
        for(Observer observer: observers)
            observer.Update(eventName);
    }
    
}
