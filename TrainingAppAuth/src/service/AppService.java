package service;

import java.util.List;
import java.util.Optional;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import main.Message;
import model.Device;
import repository.DeviceRepository;

@Service("appService")
public class AppService implements FrameService {

    @Autowired
    DeviceRepository deviceRepository;

    // Get all device
    @Override
    public List<Device> getAllDevices() {
        return deviceRepository.findAll();
    }

    // Find device by MAC Address
    @Override
    public Device findByMacAddress(String macAddress) {
        return deviceRepository.findByMacAddress(macAddress);
    }

    // Function convert to lower string
    public static String convertStringToLower(String input) {
        String resultString = "";
        for (int i = 0; i < input.length(); i++) {
            char checkChar = input.charAt(i);
            if (checkChar >= 'A' && checkChar <= 'Z') {
                resultString += (char) (checkChar + 32);// StringBuilder
            } else
                resultString += checkChar;
        }
        return resultString;
    }

    // Create new device
    @Override
    public Message createDevice(Device device) {
        String name = device.getName();
        String address = device.getAddress();
        String macAddress = device.getMacAddress();
        String status = device.getStatus();
        String type = device.getType();
        String version = device.getVersion();

        // Check empty field
        if ((name == null) || (name.equals("")) || (address == null) || (address.equals("")) || (macAddress == null) || (macAddress.equals(""))
                || (status == null) | (status.equals("")) || (type == null) || (type.equals("")) || (version == null) || (version.equals(""))) {
            return new Message("[ERROR] Empty field");
        }

        // Check name length
        if (name.length() > 128) {
            return new Message("[ERROR] Max length of name is 128");
        }

        // Validate MAC address
        Pattern checkMacAddress = Pattern.compile("^([a-fA-F0-9]{2})([:-][a-fA-F0-9]{2}){5}$");
        Matcher checkMAC = checkMacAddress.matcher(macAddress);
        if (!checkMAC.find()) {
            return new Message("[ERROR] Wrong MAC address format!");
        }

        // Validate IP address
        Pattern checkIPAddress = Pattern.compile("^((2[0-5][0-5].|1\\d\\d.|[1-9]\\d.|\\d.)){3}(2[0-5][0-5]|1\\d\\d|[1-9]\\d|\\d)$");
        Matcher checkIP = checkIPAddress.matcher(address);
        if (!checkIP.find()) {
            return new Message("[ERROR] Wrong IP address format!");
        }

        // Convert string to lower
        macAddress = convertStringToLower(macAddress);

        Device temp = new Device();
        temp = deviceRepository.findByMacAddress(macAddress);

        // Check MAC address
        if (temp != null) {
            return new Message("[ERROR] MAC address must be unique!");
        }

        // Check Status
        if (!(status.equals("Up") || status.equals("Down") || status.equals("Warning"))) {
            return new Message("[ERROR] Status must be Up, Down or Warning!");
        }

        // Check length type
        if (type.length() > 64) {
            return new Message("[ERROR] Max length of type is 64");
        }

        // Check length version
        if (version.length() > 64) {
            return new Message("[ERROR] Max length of version is 64");
        }

        // Create success
        Device deviceTemp = new Device(name, address, macAddress, status, type, version);
        deviceRepository.insert(deviceTemp);

        return new Message("[INFO] Create device success");
    }

    // Update a device
    @Override
    public Message updatDevice(Device device) {
        String id = device.getId();
        String name = device.getName();
        String address = device.getAddress();
        String type = device.getType();
        String version = device.getVersion();

        // Check empty field
        if ((name == null) || (name.equals("")) || (address == null) || (address.equals("")) || (type == null) || (type.equals("")) || (version == null)
                || (version.equals(""))) {
            return new Message("[ERROR] Empty field");
        }
        // id not exist
        if (!deviceRepository.exists(id)) {
            return new Message("[ERROR] Device not found!");
        }

        // Get device by id
        Optional<Device> tempDevice = deviceRepository.findById(id);

        tempDevice.ifPresent(temp -> temp.setName(name + " Updated"));
        tempDevice.ifPresent(temp -> temp.setAddress(address));
        tempDevice.ifPresent(temp -> temp.setType(type));
        tempDevice.ifPresent(temp -> temp.setVersion(version));

        // Update and save device
        tempDevice.ifPresent(temp -> deviceRepository.save(temp));

        return new Message("[INFO] Update device success!");

    }

    // Delete device
    @Override
    public Message deleteDevices(List<String> listId) {
        // check null list
        if (listId == null || listId.isEmpty()) {
            return new Message("[ERROR] Empty list!");
        }

        for (String id : listId) {
            // check null id
            if (id == null || id.isEmpty()) {
                return new Message("[ERROR] Can not delete device!");
            }
            // id not exist
            if (!deviceRepository.exists(id)) {
                return new Message("[ERROR] Device not found!");
            }
            // delete success
            deviceRepository.deleteById(id);
        }

        return new Message("[INFO] Delete device success");
    }

}
