package factoryPattern;

public class ComputerFactory {

    /**
     * @param type
     * @param ram
     * @param hdd
     * @param cpu
     * @return
     */
    public static Computer getComputer(String type, String ram, String hdd, String cpu, String card) {
        if ("PC".equalsIgnoreCase(type)) {
            return new PC(ram, hdd, cpu);
        } else if ("Server".equalsIgnoreCase(type)) {
            return new Server(ram, hdd, cpu, card);
        }

        return null;
    }

}
