import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class InvoiceGUI extends JFrame {
    private Invoice invoice;
    private JTextArea displayArea;
    private JTextField productField, priceField, quantityField;

    public InvoiceGUI(Invoice invoice) {
        this.invoice = invoice;
        setTitle("Lab07A_Invoice Entry System");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        createComponents();
        pack();
        setLocationRelativeTo(null);
    }

    private void createComponents() {
        JPanel inputPanel = new JPanel(new GridLayout(4, 2, 5, 5));

        productField = new JTextField(20);
        priceField = new JTextField(10);
        quantityField = new JTextField(5);

        inputPanel.add(new JLabel("Product Name:"));
        inputPanel.add(productField);
        inputPanel.add(new JLabel("Unit Price:"));
        inputPanel.add(priceField);
        inputPanel.add(new JLabel("Quantity:"));
        inputPanel.add(quantityField);

        JButton addButton = new JButton("Add Line Item");
        addButton.addActionListener(new AddItemListener());
        inputPanel.add(addButton);

        JButton generateButton = new JButton("Generate Invoice");
        generateButton.addActionListener(new GenerateInvoiceListener());
        inputPanel.add(generateButton);

        displayArea = new JTextArea(20, 60);
        displayArea.setEditable(false);
        displayArea.setFont(new Font(Font.MONOSPACED, Font.PLAIN, 12));
        JScrollPane scrollPane = new JScrollPane(displayArea);

        setLayout(new BorderLayout(10, 10));
        add(inputPanel, BorderLayout.NORTH);
        add(scrollPane, BorderLayout.CENTER);
    }

    private class AddItemListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            try {
                String desc = productField.getText();
                double price = Double.parseDouble(priceField.getText());
                int qty = Integer.parseInt(quantityField.getText());

                if (desc.trim().isEmpty() || price <= 0 || qty <= 0) {
                    JOptionPane.showMessageDialog(InvoiceGUI.this,
                            "Please ensure product name, price (>0), and quantity (>0) are valid.",
                            "Input Error", JOptionPane.ERROR_MESSAGE);
                    return;
                }

                Product p = new Product(desc, price);
                LineItem item = new LineItem(p, qty);
                invoice.add(item);

                displayArea.append("Added: " + item.format() + "\n");
                productField.setText("");
                priceField.setText("");
                quantityField.setText("");
            } catch (NumberFormatException ex) {
                JOptionPane.showMessageDialog(InvoiceGUI.this,
                        "Invalid input. Price and Quantity must be numeric.",
                        "Input Error", JOptionPane.ERROR_MESSAGE);
            }
        }
    }

    private class GenerateInvoiceListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            displayArea.setText(invoice.format());
        }
    }
}
