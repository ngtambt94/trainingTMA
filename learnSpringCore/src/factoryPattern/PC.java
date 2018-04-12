package factoryPattern;

public class PC extends Computer {

    /**
     * @param ram
     * @param hdd
     * @param cpu
     */
    public PC(String ram, String hdd, String cpu) {
        super(ram, hdd, cpu);
    }

    @Override
    public void showInfo() {
       System.out.println("This is the PC");
       toString();
    }


}
