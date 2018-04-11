package com.tam.app;

import java.util.List;
import java.util.regex.Pattern;
import java.util.regex.Matcher;

import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.data.mongodb.core.MongoOperations;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.data.mongodb.core.query.Update;

import com.mongodb.client.result.UpdateResult;
import com.tam.config.AppConfig;
import com.tam.model.Device;
import com.tam.app.Message;

@Controller
public class AppController {

    ApplicationContext ctx = new AnnotationConfigApplicationContext(AppConfig.class);

    MongoOperations mongoOperation = (MongoOperations) ctx.getBean("mongoTemplate");

    // home page
    @RequestMapping(value = { "/", "/welcome**", "/index**", "/home**" }, method = RequestMethod.GET)
    public String home() {
        return "index";
    }

    // Retrieve all of devices
    @RequestMapping(value = { "/devices" }, method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseBody
    public List<Device> getDevices() {

        List<Device> devices = mongoOperation.findAll(Device.class);

        return devices;
    }

    // Retrieve an existing device by MAC
    @RequestMapping(value = { "/devices/{mac}" }, method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseBody
    public Device getDevice(@PathVariable String mac) {

        Device device = new Device();

        Query searchDeviceQuery = new Query(Criteria.where("macAddress").is(mac));
        // find the saved device again.
        device = mongoOperation.findOne(searchDeviceQuery, Device.class);

        return device;
    }

    // Update an existing device
    @RequestMapping(value = { "/devices" }, method = RequestMethod.PUT, produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseBody
    public Message updatDevice(@RequestBody Device device) {

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

        Query searchDeviceQuery = new Query(Criteria.where("id").is(id));

        Update update = new Update();
        update.set("name", name + " I updated it");
        update.set("address", address);
        update.set("type", type);
        update.set("version", version);

        UpdateResult result = mongoOperation.updateMulti(searchDeviceQuery, update, Device.class);

        if (result.getModifiedCount() < 1) {
            return new Message("[ERROR] Can not update device! Please check again!");
        }
        return new Message("[INFO] Update device successful");

    }

    // Create a device
    @RequestMapping(value = { "/devices" }, method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseBody
    public Message createDevice(@RequestBody Device device) {
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
        Pattern checkIPAddress = Pattern.compile("^(\\d{1,3})\\.(\\d{1,3})\\.(\\d{1,3})\\.(\\d{1,3})$");
        Matcher checkIP = checkIPAddress.matcher(address);
        if (!checkIP.find()) {
            return new Message("[ERROR] Wrong IP address format!");
        }

        Device temp = new Device();
        Query searchMacAddress = new Query(Criteria.where("macAddress").is(macAddress));
        temp = mongoOperation.findOne(searchMacAddress, Device.class);

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

        Device insertDevice = new Device(name, address, macAddress, status, type, version);
        mongoOperation.save(insertDevice);
        return new Message("[INFO] Create device success");

    }

    // Delete devices
    @RequestMapping(value = { "/devices" }, method = RequestMethod.DELETE, produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseBody
    public Message deleteDevices(@RequestBody List<String> listId) {

        if (listId == null | listId.isEmpty()) {
            return new Message("[ERROR] Empty list!");
        }
        boolean notFound = false;

        for (String id : listId) {
            Query query = new Query(Criteria.where("id").is(id));
            Device device = mongoOperation.findOne(query, Device.class);
            if (device == null) {
                notFound = true;
                break;
            } else {
                mongoOperation.remove(device);
            }
        }

        if (notFound) {
            return new Message("[ERROR] Can not delete device!");
        }
        return new Message("[INFO] Delete device success");
    }
 
}
