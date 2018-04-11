package com.tam.app;

import java.util.List;

import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.beans.factory.annotation.Autowired;

import com.tam.model.Device;
import com.tam.repository.DeviceRepository;
import com.tam.app.Message;
import com.tam.service.AppService;

@Controller
public class AppController {
    
    @Autowired
    DeviceRepository deviceRepository;
    
    @Autowired
    AppService appService;
    
    // home page
    @RequestMapping(value = { "/", "/welcome**", "/index**", "/home**" }, method = RequestMethod.GET)
    public String welcome() {
        return "index";
    }

    
    // Retrieve all of devices
    @RequestMapping(value = { "/devices" }, method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseBody
    public List<Device> getDevices(){
        return appService.getAllDevices();
    }
    
    
    // Retrieve an existing device by MAC
    @RequestMapping(value = { "/devices/{macAddress}" }, method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseBody
    public Device getDevice(@PathVariable String macAddress) {
        return appService.findByMacAddress(macAddress);     
    }
    

    // Update an existing device
    @RequestMapping(value = { "/devices" }, method = RequestMethod.PUT, produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseBody
    public Message updatDevice(@RequestBody Device device) {
        return appService.updatDevice(device);  
    }
    

    // Create a device
    @RequestMapping(value = { "/devices" }, method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseBody
    public Message createDevice(@RequestBody Device device) {
        return appService.createDevice(device);
    }
    

    // Delete devices
    @RequestMapping(value = { "/devices" }, method = RequestMethod.DELETE, produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseBody
    public Message deleteDevices(@RequestBody List<String> listId) {
        return appService.deleteDevices(listId);      
    }
    
}
