package contacts;

public class Organization extends Contact {
    private String organizationName;
    private String address;

    public Organization(String number, String organizationName, String address) {
        super(number);
        this.organizationName = organizationName;
        this.address = address;
    }

    public String getOrganizationName() {
        return organizationName;
    }

    public void setOrganizationName(String organizationName) {
        this.organizationName = organizationName;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    @Override
    public String info() {
        return "Organization name: " + organizationName + "\n" +
                "Address: " + address + "\n" +
                super.info();
    }

    @Override
    public String toString() {
        return organizationName;
    }
}