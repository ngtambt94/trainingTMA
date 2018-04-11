package service;

import java.util.List;

import model.Device;
import main.Message;

public interface FrameService {

    // Retrieves all of devices
    public List<Device> getAllDevices();

    // Retrieves an existing device by MAC
    public Device findByMacAddress(String macAddress);

    // Create new device
    public Message createDevice(Device device);

    // Update new device
    public Message updatDevice(Device device);

    // Delete devices
    public Message deleteDevices(List<String> listId);

}
