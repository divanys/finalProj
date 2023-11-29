import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

public class AllOrders extends JFrame {
    private List<Order> ordersList;
    private JButton показатьЧекиButton;
    private JButton совершитьПокупкуButton;
    private JButton вернутьсяButton;
    private JLabel желаетеСовершитьПокупкуLabel;
    private JLabel коллекцияЧековLabel;
    private JLabel желаетеВернутьсяКМодернизацииLabel;
    private JPanel panel1;

    public AllOrders(String storeNameField) {
        setFixedSizeAndOtherSensitiviti();
        this.getContentPane().add(panel1);
        setTitle(storeNameField);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);

        совершитьПокупкуButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                OrderRegistrationWindow orderRegistrationWindow = new OrderRegistrationWindow();
                orderRegistrationWindow.setVisible(true); // Добавление продукта в магазин
            }
        });

        показатьЧекиButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                OrderRegistrationWindow orderRegistrationWindow = new OrderRegistrationWindow();
                orderRegistrationWindow.setVisible(true); // Добавление продукта в магазин
            }
        });

    }
    public void addOrder(Order order) {
        boolean isOrderExist = false;
        for (Order existingOrder : ordersList) {
            if (existingOrder.getCustomer() == order.getCustomer() && existingOrder.getProductList().equals(order.getProductList())) {
                System.out.println("Заказ уже существует.");
                isOrderExist = true;
                break;
            }
        }
        if (!isOrderExist) {
            ordersList.add(order);
            order.printOrderInfo();
        }
    }

    private void showAllOrders() {
        String ordersInfo = "";
        for (Order order : ordersList ) {
            ordersInfo += order.printOrderInfo();
        }

        JOptionPane.showMessageDialog(this, ordersInfo, "Все чеки", JOptionPane.INFORMATION_MESSAGE);
    }
    private void setFixedSizeAndOtherSensitiviti() {
        Dimension size = new Dimension(1150, 800);
        setMinimumSize(size);
        setSize(size);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }
    private void createUIComponents() {
        // TODO: place custom component creation code here
        показатьЧекиButton = new JButton();
        совершитьПокупкуButton = new JButton();
        вернутьсяButton = new JButton();
        желаетеСовершитьПокупкуLabel = new JLabel();
        коллекцияЧековLabel = new JLabel();
        желаетеВернутьсяКМодернизацииLabel = new JLabel();
        panel1 = new JPanel();
    }
}
