package compareObjects;

public class School implements Comparable<School> {

    private String name;
    private String address;
    
    public School() {
        super();
    }

    public School(String name, String address) {
        super();
        this.name = name;
        this.address = address;
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

    @Override
    public String toString() {
        return "School [name=" + name + ", address=" + address + "]";
    }

    @Override
    public int compareTo(School school) {
        int value = this.name.compareTo(school.name);
        if (value != 0) {
            return value;
        }
        
        value = this.address.compareTo(address);
        return value;
    }       
    
}
