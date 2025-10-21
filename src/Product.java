public class Product {
    private String description;
    private double unitPrice;

    public Product(String description, double unitPrice) {
        this.description = description;
        this.unitPrice = unitPrice;
    }

    public double getUnitPrice() {
        return unitPrice;
    }

    public String getDescription() {
        return description;
    }
}