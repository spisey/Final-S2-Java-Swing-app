import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.util.ArrayList;
import java.util.List;

public class CustomerShowSwing extends JFrame {
    private JTable customerTable;
    private DefaultTableModel tableModel;

    public CustomerShowSwing() {
        setTitle("Customer Information");
        setSize(600, 400);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        // Initialize table model with columns
        tableModel = new DefaultTableModel();
        tableModel.addColumn("ID");
        tableModel.addColumn("Last Name");
        tableModel.addColumn("First Name");
        tableModel.addColumn("Phone");

        // Create table with initialized model
        customerTable = new JTable(tableModel);
        JScrollPane scrollPane = new JScrollPane(customerTable);
        getContentPane().add(scrollPane, BorderLayout.CENTER);

        // Example data (replace with your data fetching logic)
        List<Customer> customers = fetchData();

        // Populate table with customer data
        for (Customer customer : customers) {
            tableModel.addRow(new Object[]{
                    customer.getId(),
                    customer.getLastName(),
                    customer.getFirstName(),
                    customer.getPhone()
            });
        }
    }

    // Example method to fetch customer data (replace with your actual data fetching logic)
    private List<Customer> fetchData() {
        List<Customer> customers = new ArrayList<>();
        customers.add(new Customer(1, "Chenda", "Sovisal", "092888999"));
        customers.add(new Customer(2, "Kom", "Lina", "092000999"));
        customers.add(new Customer(3, "Chan", "Seyha", "092777666"));
        return customers;
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            CustomerShowSwing customerShowSwing = new CustomerShowSwing();
            customerShowSwing.setVisible(true);
        });
    }
}


