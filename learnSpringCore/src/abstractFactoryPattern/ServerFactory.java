package abstractFactoryPattern;

public class ServerFactory extends Computer implements ComputerAbstractFactory {
    
    public ServerFactory(String ram, String hdd, String cpu) {
        super(ram, hdd, cpu);
    }

    @Override
    public Computer createComputer() {
        return new Server(ram, hdd, cpu);
    }

    @Override
    public void showInfo() {
        System.out.println("Creating Server");
    }
        
}
