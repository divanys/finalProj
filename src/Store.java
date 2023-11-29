import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

/*
* Класс Store описывает форму Store.
* Функционал:
*   1. Необходимо ввести название магазина и нажать кнопку яВвёлНазваниеButton, чтобы сохранить результат введённого названия
*   2. Зарегистрировать продукты, нажав на кнопку зарегистрироватьПродуктыButton
*   3. Зарегистрировать кассиров, нажав на кнопку зарегистрироватьСотрудниковButton
*   4. Зарегистрировать покупателей, нажав на кнопку зарегистрироватьКлиентаButton
*   5. Для удобства имеются кнопки зарегистрированныеПродуктыButton, зарегистрированныеСотрудникиButton
*    и зарегистрированныеКлиентыButton для просмотра уже зарегистрированных продуктов, сотрудников и клиентов соответственно
* (я потеряла смысл слова "зарегистрированный")
*   6. После регистрации, вам необходимо нажать кнопочку магазинГотовКРаботеButton, чтобы перейти в форму работы с данным магазином
* Форма регистрации закроется и откроется форма работы с магазином (о чём будет свидетельствовать название окна),
*  но не переживайте: если вам захочется вернуться и добавить какие-то данные, во 2 форме будет кнопочка для возврата; данные
* об уже ранее зарегистрированных видах всего сохранятся.
*
*/


class Store extends JFrame {
    private final ArrayList<Product> products = new ArrayList<>();
    private final ArrayList<Customer> customers = new ArrayList<>();
    private final ArrayList<Cashier> cashiers = new ArrayList<>();
    private String storeNameField;
    private JTextField введитеНазваниеМагазинаTextField;
    private JButton яВвёлНазваниеButton;
    private JButton зарегистрироватьПродуктыButton;
    private JButton магазинГотовКРаботеButton;
    private JLabel приветствуемВМагазинеLabel;
    private JLabel вамНужноЗарегестрироватьПродуктыLabel;
    private JLabel посмотретьLabel;
    private JButton зарегистрированныеПродуктыButton;
    private JLabel вамНужноЗарегистрироватьСотрудниковLabel;
    private JButton зарегистрироватьСотрудниковButton;
    private JLabel посмотретьLabel1;
    private JButton зарегистрированныеСотрудникиButton;
    private JButton зарегистрированныеКлиентыButton;
    private JLabel посмотретьLabel2;
    private JButton зарегистрироватьКлиентаButton;
    private JLabel вамНужноЗарегистрироватьКлиентовLabel;
    private JPanel reg_and_show;
    private JPanel panel1;


    public void addProduct(Product product) {  // добавляем продукт, если он не существует
        boolean isProductExist = false;
        for (Product existingProduct : products) {
            if (existingProduct.getTitle().equals(product.getTitle()) &&
                    existingProduct.getManufacturer().equals(product.getManufacturer()) &&
                    (existingProduct.getPrice() == (product.getPrice())) &&
                    (existingProduct.getNetWeight() == product.getNetWeight()) &&
                    existingProduct.getDateOfManufacture().equals(product.getDateOfManufacture()) &&
                    existingProduct.getValidUntil().equals(product.getValidUntil())) {
                JOptionPane.showMessageDialog(this, "Продукт уже существует!", "Предупреждение", JOptionPane.WARNING_MESSAGE);
                isProductExist = true;
                break;
            }
        }
        if (!isProductExist) {
            products.add(product);
        }
    }

    public void addCustomer(Customer customer) {   // добавляем покупателя, если он не существует
        boolean isCustomerExist = false;
        for (Customer existingCustomer : customers) {
            if (existingCustomer.getLastName().equals(customer.getLastName()) &&
                    existingCustomer.getFirstName().equals(customer.getFirstName()) &&
                    existingCustomer.getMiddleName().equals(customer.getMiddleName())) {
                JOptionPane.showMessageDialog(this, "Клиент уже существует!", "Предупреждение", JOptionPane.WARNING_MESSAGE);

                isCustomerExist = true;
                break;
            }
        }
        if (!isCustomerExist) {
            customers.add(customer);
        }
    }

    public void addCashier(Cashier cashier) {   // добавляем кассира, если он не существует
        boolean isCashierExist = false;
        for (Cashier existingCashier : cashiers) {
            if (existingCashier.getLastName().equals(cashier.getLastName()) &&
                    existingCashier.getFirstName().equals(cashier.getFirstName()) &&
                    existingCashier.getMiddleName().equals(cashier.getMiddleName())) {
                JOptionPane.showMessageDialog(this, "Кассир уже существует!", "Предупреждение", JOptionPane.WARNING_MESSAGE);

                isCashierExist = true;
                break;
            }
        }
        if (!isCashierExist) {
            cashiers.add(cashier);
        }
    }

    private void createUIComponents() {
        // TODO: place custom component creation code here
        введитеНазваниеМагазинаTextField = new JTextField();
        яВвёлНазваниеButton = new JButton();
        зарегистрироватьПродуктыButton = new JButton();
        магазинГотовКРаботеButton = new JButton();
        приветствуемВМагазинеLabel = new JLabel();
        вамНужноЗарегестрироватьПродуктыLabel = new JLabel();
        посмотретьLabel = new JLabel();
        зарегистрированныеПродуктыButton = new JButton();
        вамНужноЗарегистрироватьСотрудниковLabel = new JLabel();
        зарегистрироватьСотрудниковButton = new JButton();
        посмотретьLabel1 = new JLabel();
        зарегистрированныеСотрудникиButton = new JButton();
        зарегистрированныеКлиентыButton = new JButton();
        посмотретьLabel2 = new JLabel();
        зарегистрироватьКлиентаButton = new JButton();
        вамНужноЗарегистрироватьКлиентовLabel = new JLabel();
        reg_and_show = new JPanel();
        panel1 = new JPanel();
    }

    public Store() {
        this.getContentPane().add(panel1);
        setFixedSizeAndOtherSensitiviti();

        // обработка кнопки "яВвёлНазваниеButton" - если не нажать, магаз будет без названия просто
        яВвёлНазваниеButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String storeName = введитеНазваниеМагазинаTextField.getText();
                setStoreNameField(storeName);
            }
        });

        // обработка кнопок "зарегистрировать<тип>"
        зарегистрироватьПродуктыButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                ProductRegistrationWindow productRegistrationWindow = new ProductRegistrationWindow(Store.this);
                productRegistrationWindow.setVisible(true); // добавление продукта в магазин
            }
        });

        зарегистрироватьСотрудниковButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                CashierRegistrationWindow cashierRegistrationWindow = new CashierRegistrationWindow(Store.this);
                cashierRegistrationWindow.setVisible(true); // Добавление кассира в магазин
            }
        });

        зарегистрироватьКлиентаButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                CustomerRegistrationWindow customerRegistrationWindow  = new CustomerRegistrationWindow(Store.this);
                customerRegistrationWindow.setVisible(true); // Добавление клиента в магазин
            }
        });

        // кнопки для просмотра
        зарегистрированныеПродуктыButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                showRegisteredProducts();
            }
        });

        зарегистрированныеСотрудникиButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                showRegisteredCashiers();
            }
        });

        зарегистрированныеКлиентыButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                showRegisteredCustomers();
            }
        });

        // Обработка кнопки "магазинГотовКРаботеButton"
        магазинГотовКРаботеButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                AllOrders allOrders  = new AllOrders(getStoreNameField(), Store.this);
                allOrders.setVisible(true);  // показываем окно с параметрами магазина
                setVisible(false);  // при этом убирая видимость окна регистрации магазина
            }
        });
    }

    // методы для вывода
    private void showRegisteredProducts() {
        String productsInfo = "";
        for (Product product : products) {
            productsInfo += product.printInfo();
            productsInfo += "\n---------------------------\n";
        }

        JOptionPane.showMessageDialog(this, productsInfo, "Зарегистрированные продукты", JOptionPane.INFORMATION_MESSAGE);
    }

    private void showRegisteredCashiers() {
        String cashiersInfo = "";
        for (Cashier cashier : cashiers) {
            cashiersInfo += cashier.printInfo();
            cashiersInfo += "\n---------------------------\n";
        }

        JOptionPane.showMessageDialog(this, cashiersInfo, "Зарегистрированные сотрудники", JOptionPane.INFORMATION_MESSAGE);
    }

    private void showRegisteredCustomers() {
        String customersInfo = "";
        for (Customer customer : customers) {
            customersInfo += customer.printInfo();
            customersInfo += "\n---------------------------\n";
        }

        JOptionPane.showMessageDialog(this, customersInfo, "Зарегистрированные клиенты", JOptionPane.INFORMATION_MESSAGE);
    }


    private void setFixedSizeAndOtherSensitiviti() {
        Dimension size = new Dimension(1700, 800);
        setMinimumSize(size);
        setSize(size);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }

    public String getStoreNameField() {
        return storeNameField;
    }

    public void setStoreNameField(String storeNameField) {
        this.storeNameField = storeNameField;
    }

    public ArrayList<Cashier> getCashiers() {
        return cashiers;
    }

    public ArrayList<Customer> getCustomers() {
        return customers;
    }
    public ArrayList<Product> getProducts() {
        return products;
    }

}
