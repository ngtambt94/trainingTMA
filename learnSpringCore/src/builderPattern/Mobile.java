package builderPattern;

public class Mobile {

    private String branch;
    private String name;
    private String screenSize;
    private String cpu;
    private String ram;
    public String pin;

    private boolean isWifiEnabled;
    private boolean isBluetoothEnabled;

    public String getBranch() {
        return branch;
    }
    
    public String getName() {
        return name;
    }

    public String getScreenSize() {
        return screenSize;
    }

    public String getCpu() {
        return cpu;
    }

    public String getRam() {
        return ram;
    }

    public boolean isWifiEnabled() {
        return isWifiEnabled;
    }

    public boolean isBluetoothEnabled() {
        return isBluetoothEnabled;
    }

    protected Mobile(MobileBuilder builder) {
        this.branch = builder.branch;
        this.name = builder.name;
        this.screenSize = builder.screenSize;
        this.cpu = builder.cpu;
        this.ram = builder.ram;
        this.isBluetoothEnabled = builder.isBluetoothEnabled;
        this.isWifiEnabled = builder.isWifiEnabled;
        this.pin = builder.pin;
    }

    @Override
    public String toString() {
        return "Mobile [branch=" + branch + ", name=" + name + ", screenSize=" + screenSize + ", cpu=" + cpu + ", ram=" + ram + ", isWifiEnabled=" + isWifiEnabled + ", isBluetoothEnabled="
                + isBluetoothEnabled + ", Pin: " + pin + "]";
    }

}
