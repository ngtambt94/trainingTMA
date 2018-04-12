package observerPattern;

public class Customer implements Observer {

    private String name;

    public Customer(String name) {
        super();
        this.name = name;
    }
    
    @Override
    public void Update(String contentSMS) {
        System.out.println("Xin chao: " + name + " " + contentSMS + " Viettel khuyen mai 20% gia thi the nap.");
    }
    
}
