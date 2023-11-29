import javax.swing.*;
import java.awt.Dimension;
import java.util.List;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/*
* класс OrderRegistrationWindow нужен для регистрации заказа.
* мы берём данные уже добавленных в магазин списков: продуктов, кассиров и покупателей
* и предлагаем в форме регистрации заказа выбрать то или иное значение из списков
* можно выбрать несколько продуктов, зажав левый shift и тыкая на значения из списка продуктов
* */
public class OrderRegistrationWindow extends JFrame {
    private JList<Cashier> кассирlist1;
    private JList<Customer> клиентыlist2;
    private JLabel продуктыLabel;
    private JLabel кассирLabel;
    private JLabel клиентLabel;
    private JPanel panel1;
    private JButton зарегистрироватьЗаказButton;
    private JList<Product> продуктыList3;
    private Store store;
    private AllOrders allOrders;

    private void setFixedSizeAndOtherSensitiviti() {
        Dimension size = new Dimension(500, 500);
        setMinimumSize(size);
        setSize(size);
        setLocationRelativeTo(null);
    }

    private void createUIComponents() {
        // TODO: place custom component creation code here
        кассирlist1 = new JList<>();
        клиентыlist2 = new JList<>();
        продуктыList3 = new JList<>();
        продуктыLabel = new JLabel();
        кассирLabel = new JLabel();
        клиентLabel = new JLabel();
        panel1 = new JPanel();
        зарегистрироватьЗаказButton = new JButton();
    }

    public OrderRegistrationWindow(Store store, AllOrders allOrders) {
        this.store = store;
        this.allOrders = allOrders;
        setFixedSizeAndOtherSensitiviti();
        this.getContentPane().add(panel1);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);

        кассирlist1.setModel(new DefaultListModel<>());
        клиентыlist2.setModel(new DefaultListModel<>());
        продуктыList3.setModel(new DefaultListModel<>());

        // Заполняем списки данными из магазина
        updateCashierList();
        updateProductList();
        updateCustomerList();

        зарегистрироватьЗаказButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                registerOrder(allOrders);
            }
        });
    }

    private void registerOrder(AllOrders allOrders) {
        Customer selectedCustomer = клиентыlist2.getSelectedValue(); // Получаем выбранного клиента из списка
        Cashier selectedCashier = кассирlist1.getSelectedValue(); // Получаем выбранного кассира из списка
        List<Product> selectedProducts = продуктыList3.getSelectedValuesList(); // Получаем выбранные продукты из списка

        if (selectedCustomer != null && selectedCashier != null && !selectedProducts.isEmpty()) {
            boolean hasDiscountCard = selectedCustomer.isDiscountCard(); // Проверяем наличие скидочной карты у клиента

            int discountPercentage = hasDiscountCard ? 10 : 0; // Применяем скидку 10% если есть карта, иначе 0

            Order order = new Order(selectedCustomer, selectedCashier, selectedProducts, discountPercentage);

            // Теперь есть заказ, учитывающий скидку в зависимости от наличия карты у клиента
            String orderInfo = order.printOrderInfo();
            allOrders.addOrder(order);
            JOptionPane.showMessageDialog(this, orderInfo, "Чек", JOptionPane.INFORMATION_MESSAGE);
        } else {
            // Создаем информационное окно с просьбой выбрать все данные для заказа
            JOptionPane.showMessageDialog(this, "Выберите клиента, кассира и продукты для оформления заказа.", "Предупреждение", JOptionPane.WARNING_MESSAGE);
        }
    }


    // Метод для обновления списка кассиров
    private void updateCashierList() {
        DefaultListModel<Cashier> cashierListModel = (DefaultListModel<Cashier>) кассирlist1.getModel();
        cashierListModel.clear();
        for (Cashier cashier : store.getCashiers()) {
            cashierListModel.addElement(cashier);
        }
    }

    // Метод для обновления списка клиентов
    private void updateCustomerList() {
        DefaultListModel<Customer> customerListModel = (DefaultListModel<Customer>) клиентыlist2.getModel();
        customerListModel.clear();
        for (Customer customer : store.getCustomers()) {
            customerListModel.addElement(customer);
        }
    }

    // Метод для обновления списка продуктов
    private void updateProductList() {
        DefaultListModel<Product> productDefaultListModel = (DefaultListModel<Product>) продуктыList3.getModel();
        productDefaultListModel.clear();
        for (Product product : store.getProducts()) {
            productDefaultListModel.addElement(product);
        }
    }
}
