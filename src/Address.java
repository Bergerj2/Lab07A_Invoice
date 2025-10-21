public class Address {
    private String name;
    private String street;
    private String cityStateZip;

    public Address(String name, String street, String cityStateZip) {
        this.name = name;
        this.street = street;
        this.cityStateZip = cityStateZip;
    }

    public String format() {
        return name + "\n" + street + "\n" + cityStateZip;
    }
}
