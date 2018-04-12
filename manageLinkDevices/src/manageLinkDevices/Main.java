package manageLinkDevices;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Main {

    
    public static void main(String[] args) {
        List<String> data = Arrays.asList("A-C", "A-D", "D-E", "B-E","F-B");
        List<String> check = Arrays.asList("A","B","C","D","E","F");
        
        Map<String, List<String>> result = new HashMap<>();
        
        for(String dt : data) {
            Main.collectDataForResult(result, dt);
        }
        
        for(String ch : check) {
            System.out.println(result.get(ch));
        }
    }

    private static void collectDataForResult(Map<String, List<String>> result, String dt) {
        String[] splitedStrings = dt.split("-");
        for(String str : splitedStrings) {
            List<String> value = result.get(str);
            if( value == null) {
                value = new ArrayList<>();  
            }
            value.add(dt);
            result.put(str, value);
        }
    }

    
}
