package abstractFactoryPattern;

public class Server extends Computer {

    /**
     * @param ram
     * @param hdd
     * @param cpu
     */
    public Server(String ram, String hdd, String cpu) {
        super(ram, hdd, cpu);
    }

    @Override
    public void showInfo() {
       System.out.println("\nCreating Server");
       toString();
    }
}
