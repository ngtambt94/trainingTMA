package manageLinkDevices;

import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Stream;

public class Learn {

    private static void collectData(Map<String, List<String>> result, String data) {
        String[] splitedStrings = data.split("-");

        for (String str : splitedStrings) {
            List<String> value = result.get(str);

            if (value == null) {
                value = new ArrayList<>();
            }
            value.add(data);
            result.put(str, value);
        }
    }

    public static void main(String args[]) throws IOException {
        String fileInput = "src/file/v2/data.txt";
        String fileCheck = "src/file/v2/check.txt";
        String fileOut = "src/file/v2/result.txt";

        Map<String, List<String>> result = new HashMap<>();

        ArrayList<linkOfDevice> resultArr = new ArrayList<linkOfDevice>();
        FileOutputStream out = new FileOutputStream(fileOut);

        // File input
        try (Stream<String> stream = Files.lines(Paths.get(fileInput), StandardCharsets.UTF_8)) {
            stream.forEach(line -> {
                collectData(result, line);
            });
        } catch (Exception e) {
            e.printStackTrace();
        }

        // File check
        try (Stream<String> stream = Files.lines(Paths.get(fileCheck), StandardCharsets.UTF_8)) {
            stream.forEach(line -> {
                linkOfDevice dataTemp = new linkOfDevice(line, result.get(line) + "");
                resultArr.add(dataTemp);
            });
        } catch (Exception e) {
            e.printStackTrace();
        }

        // Write file
        try {
            // Check
            for (linkOfDevice temp : resultArr) {

                byte[] strToBytes = (temp.toString() + "\r\n").getBytes();
                out.write(strToBytes);
            }
            System.out.println("Write file success!");

        } finally {
            if (out != null) {
                out.close();
            }
        }

    }
}