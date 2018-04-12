package manageLinkDevices;

import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.stream.Stream;

public class App {

    public static void main(String[] args) throws IOException {
        String fileInput = "src/file/v2/data.txt";
        String fileCheck = "src/file/v2/check.txt";
        ArrayList<String> data = new ArrayList<String>();
        ArrayList<linkOfDevice> result = new ArrayList<linkOfDevice>();
        FileOutputStream out = new FileOutputStream("src/file/v2/result.txt");

        // File input
        try (Stream<String> stream = Files.lines(Paths.get(fileInput), StandardCharsets.UTF_8)) {
            stream.forEach(line -> {
                data.add(line);
            });
        } catch (Exception e) {
            e.printStackTrace();
        }

        // File check
        try (Stream<String> stream = Files.lines(Paths.get(fileCheck), StandardCharsets.UTF_8)) {
            stream.forEach(line -> {
                int found = 0;
                String strResult = "";
                for (String temp : data) {
                    if (temp.indexOf(line) > -1) {
                        strResult += temp + ", ";
                        found = 1;
                    }

                }
                if (found == 1) {
                    linkOfDevice dataTemp = new linkOfDevice(line, strResult);
                    result.add(dataTemp);
                }
                else {
                    linkOfDevice dataTemp = new linkOfDevice(line, "Nothing");
                    result.add(dataTemp);
                }
            });
        } catch (Exception e) {
            e.printStackTrace();
        }

        // Write the result to output
        try {
            // Check
            for (linkOfDevice temp : result) {

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
