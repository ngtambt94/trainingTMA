package factory;

public class Main {

    public static void main(String[] args) {
        Computer pc = ComputerFactory.getComputer("PC", "8 GB", "1 TB", "Core i7",null);
        Computer server = ComputerFactory.getComputer("Server", "4 GB", "750 GB", "Core i3","card itel");
        
        System.out.println("Factory PC config: " + pc);
        System.out.println("\nFactory Server config: " + server);
    }
    
}
