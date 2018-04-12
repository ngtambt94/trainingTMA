package learnJavaCore;

public class MainApp {
    
    static String convertStringToLower(String string) {
        String temp = string;
        string = "";
        for(int i = 0; i < temp.length(); i++) {
            if (temp.charAt(i) >= 'A' && temp.charAt(i) <= 'Z') {
               int tempChar = temp.charAt(i) + 32;
               string += (char)tempChar;
            }
            else
                string += temp.charAt(i);
        }
        return string;
    }
    
    public static void main(String[] args) {
        
        System.out.println(convertStringToLower("ABc"));
        
    }

}
