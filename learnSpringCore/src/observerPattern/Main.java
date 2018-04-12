package observerPattern;

public class Main {

    public static void main(String[] args) throws InterruptedException {
    
        Customer customer1 = new Customer("Tam Nguyen");
        Customer customer2 = new Customer("Quyen Tran");
        
        Event event1 = new Event("[KHUYEN MAI] Nhan dip 8-3");
        Event event2 = new Event("[KHUYEN MAI] Nhan dip 20-10");
        
        System.out.println("=====Observer Design Pattern=====");
        
        event1.registerObserver(customer1);
        event1.registerObserver(customer2);
        
        event2.registerObserver(customer1);
        event2.registerObserver(customer2);
        
        event1.refuseObserver(customer2);
        
        System.out.println("\n[Event 8-3]");
        event1.notifyObserver();
        System.out.println("\n[Event 20-10]");
        event2.notifyObserver();
     
        Thread.sleep(10000);
        event1.notifyObserver();
    }
    
}
