import javax.swing.SwingUtilities;

public class InvoiceApplication {
    public static void main(String[] args) {
        Address sender = new Address("Josh's Business",
                "100 Main Street",
                "Anytown, CA 98765");

        final Invoice invoiceModel = new Invoice("I N V O I C E", sender);

        SwingUtilities.invokeLater(() -> {
            InvoiceGUI frame = new InvoiceGUI(invoiceModel);
            frame.setVisible(true);
        });
    }
}