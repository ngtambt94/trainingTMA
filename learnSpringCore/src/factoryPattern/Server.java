package factoryPattern;

public class Server extends Computer {
        
    private String netCard;
        /**
         * @param ram
         * @param hdd
         * @param cpu
         */
        public Server(String ram, String hdd, String cpu) {
            super(ram, hdd, cpu);
        }
        
        

        public Server(String ram, String hdd, String cpu, String netCard) {
            super(ram, hdd, cpu);
            this.netCard = netCard;
        }


        @Override
        public void showInfo() {
            System.out.println("This is the Server");
            toString();
        }



        @Override
        public String toString() {
            System.out.println(super.toString());
            return "Server [netCard=" + netCard + "]";
        }

        
        
}
