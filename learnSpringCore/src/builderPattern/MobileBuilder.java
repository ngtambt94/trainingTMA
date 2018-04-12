package builderPattern;

public class MobileBuilder {

    protected String branch;
    protected String name;
    protected String screenSize;
    protected String cpu;
    protected String ram;

    protected boolean isWifiEnabled;
    protected boolean isBluetoothEnabled;
    protected String pin = "1000 mAh";

    public MobileBuilder(String branch, String name, String screenSize, String cpu, String ram) {
        this.branch = branch;
        this.name = name;
        this.screenSize = screenSize;
        this.cpu = cpu;
        this.ram = ram;
    }

    public MobileBuilder setPin(String pin) {
        this.pin = pin;
        return this;
    }
    
    public MobileBuilder setWifiEnabled(boolean isWifiEnabled) {
        this.isWifiEnabled = isWifiEnabled;
        return this;
    }

    public MobileBuilder setBluetoothEnabled(boolean isBluetoothEnabled) {
        this.isBluetoothEnabled = isBluetoothEnabled;
        return this;
    }

    public Mobile build() {
        return new Mobile(this);
    }

}