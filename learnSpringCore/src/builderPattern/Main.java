package builderPattern;

public class Main {

    public static void main(String[] args) {
//        Mobile mobile = new MobileBuilder("Samsung", "S6 edge", "5.1 inches", "Exynos", "3 GB")
//                .setWifiEnabled(true)
//                .setBluetoothEnabled(false)
//                .build();
//        
//        System.out.println("=====Starting builder pattern=====\n");
//        System.out.println(mobile.toString());
        
        
        
        Mobile mobile2 = new MobileBuilder("Samsung", "S6 edge", "5.1 inches", "Exynos", "3 GB").build();
        System.out.println(mobile2.toString());
    }
    
}
