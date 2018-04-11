package main;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import main.Message;

import model.Device;
import repository.DeviceRepository;
import service.AppService;

@Controller
public class AppController {

    @Autowired
    DeviceRepository deviceRepository;

    @Autowired
    AppService appService;

    @RequestMapping(value = { "", "/home**", "/index**", "/" }, method = RequestMethod.GET)
    public String welcome() {
        return "index";
    }

    @RequestMapping(value = { "/devices" }, method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseBody
    public List<Device> getDevices() {
        return deviceRepository.findAll();
    }

    @RequestMapping(value = { "/devices/{macAddress}" }, method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseBody
    public Device getDeviceByMacAddress(@PathVariable String macAddress) {
        return deviceRepository.findByMacAddress(macAddress);
    }

    @RequestMapping(value = { "/devices/", "/devices" }, method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseBody
    public Message createDevice(@RequestBody Device device) {
        return appService.createDevice(device);
    }

    // Update an existing device
    @RequestMapping(value = { "/devices" }, method = RequestMethod.PUT, produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseBody
    public Message updatDevice(@RequestBody Device device) {
        return appService.updatDevice(device);
    }

    // Delete devices
    @RequestMapping(value = { "/devices" }, method = RequestMethod.DELETE, produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseBody
    public Message deleteDevices(@RequestBody List<String> listId) {
        return appService.deleteDevices(listId);
    }

}
