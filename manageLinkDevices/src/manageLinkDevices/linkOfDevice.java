package manageLinkDevices;

public class linkOfDevice {
    
    private String link;
    private String status;
    
    public linkOfDevice() {}
    
    public linkOfDevice(String link, String status) {
        super();
        this.link = link;
        this.status = status;
    }

    public String getLink() {
        return link;
    }

    public void setLink(String link) {
        this.link = link;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    @Override
    public String toString() {
        return link + " : " + status;
    }    
    
}
