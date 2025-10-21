import java.util.ArrayList;
import java.util.List;

public class Invoice {
    private String title;
    private Address sender;
    private List<LineItem> items;

    public Invoice(String title, Address sender) {
        this.title = title;
        this.sender = sender;
        this.items = new ArrayList<>();
    }

    public void add(LineItem item) {
        items.add(item);
    }

    public double getAmountDue() {
        double total = 0;
        for (LineItem item : items) {
            total += item.getTotal();
        }
        return total;
    }

    public String format() {
        StringBuilder builder = new StringBuilder();
        String wideLine = "==============================================================\n";
        String divider = "--------------------------------------------------------------\n";

        builder.append(String.format("          %s\n\n", title));

        builder.append(sender.format()).append("\n\n");

        builder.append(wideLine);

        builder.append(String.format("%-20s %5s %8s %10s\n", "Item", "Qty", "Price", "Total"));
        builder.append(divider);

        for (LineItem item : items) {
            builder.append(item.format()).append("\n");
        }

        builder.append(wideLine);
        builder.append(String.format("\nAMOUNT DUE: $%10.2f", getAmountDue()));

        return builder.toString();
    }
}