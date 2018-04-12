package abstractFactoryPattern;

public class PCFactory extends Computer implements ComputerAbstractFactory {
    
    public PCFactory(String ram, String hdd, String cpu) {
        super(ram, hdd, cpu);
    }

    @Override
    public Computer createComputer() {
        return new PC(ram, hdd, cpu);
    }

    @Override
    public void showInfo() {
        System.out.println("Creating PC");        
    }
}
