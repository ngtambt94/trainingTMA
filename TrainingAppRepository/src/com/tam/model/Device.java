package com.tam.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "devices")
public class Device {

    @Id
    private String id;

    private String name;
    private String address;
    private String macAddress;
    private String status;
    private String type;
    private String version;

    public Device() {
    }

    public Device(String name, String address, String macAddress, String status, String type, String version) {
        super();
        this.name = name;
        this.address = address;
        this.macAddress = macAddress;
        this.status = status;
        this.type = type;
        this.version = version;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getMacAddress() {
        return macAddress;
    }

    public void setMacAddress(String macAddress) {
        this.macAddress = macAddress;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getVersion() {
        return version;
    }

    public void setVersion(String version) {
        this.version = version;
    }

    @Override
    public String toString() {
        return "Device [id=" + id + ", name=" + name + ", address=" + address + ", macAddress=" + macAddress + ", status=" + status + ", type=" + type + ", version=" + version
                + "]";
    }



    
}
