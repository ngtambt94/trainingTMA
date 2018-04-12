package abstractFactoryPattern;

public abstract class Computer {

    protected String ram;
    protected String hdd;
    protected String cpu;
    
    public Computer(String ram, String hdd, String cpu) {
        super();
        this.ram = ram;
        this.hdd = hdd;
        this.cpu = cpu;
    }
    public String getRam() {
        return ram;
    }
    public void setRam(String ram) {
        this.ram = ram;
    }
    public String getHdd() {
        return hdd;
    }
    public void setHdd(String hdd) {
        this.hdd = hdd;
    }
    public String getCpu() {
        return cpu;
    }
    public void setCpu(String cpu) {
        this.cpu = cpu;
    }
    
    public abstract void showInfo();
    
    @Override
    public String toString() {
        return "[ CPU: " + getCpu() + ", RAM: " + getRam() + ", HDD: " + getHdd() + " ]";
    }
    
}
