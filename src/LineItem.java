public class LineItem {
    private int quantity;
    private Product product;

    public LineItem(Product product, int quantity) {
        this.product = product;
        this.quantity = quantity;
    }

    public double getTotal() {
        return quantity * product.getUnitPrice();
    }

    public String format() {
        return String.format("%-20s %5d $%8.2f $%10.2f",
                product.getDescription(), quantity, product.getUnitPrice(), getTotal());
    }
}