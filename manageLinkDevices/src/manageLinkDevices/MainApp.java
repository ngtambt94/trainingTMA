package manageLinkDevices;

import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.stream.Stream;

public class MainApp {

    public static void main(String[] args) throws IOException {
        String fileInput = "src/file/v1/data.txt";
        String fileCheck = "src/file/v1/check.txt";
        ArrayList<String> data = new ArrayList<String>();
        ArrayList<linkOfDevice> result = new ArrayList<linkOfDevice>();
        FileOutputStream out = new FileOutputStream("src/file/v1/result.txt");

        // File input
        try (Stream<String> stream = Files.lines(Paths.get(fileInput), StandardCharsets.UTF_8)) {
            stream.forEach(line -> {
                StringBuffer lineTemp = new StringBuffer(line);
                String lineReverse = lineTemp.reverse().toString();
                data.add(line);
                data.add(lineReverse);
            });
        } catch (Exception e) {
            e.printStackTrace();
        }

        // File check
        try (Stream<String> stream = Files.lines(Paths.get(fileCheck), StandardCharsets.UTF_8)) {
            stream.forEach(line -> {
                int found = 0;
                for (String temp : data) {
                    if (line.compareTo(temp) == 0) {
                        linkOfDevice dataTemp = new linkOfDevice(line, "Linked");
                        result.add(dataTemp);
                        found = 1;
                        break;
                    }
                }
                if (found == 0) {
                    linkOfDevice dataTemp = new linkOfDevice(line, "Unlinked");
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
