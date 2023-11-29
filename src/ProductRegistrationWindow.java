import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ProductRegistrationWindow extends JFrame {

    private JPanel panel1;
    private JButton зарегистрироватьButton;
    private JLabel названиеКатегорииLabel;
    private JLabel названиеПродуктаLabel;
    private JLabel производительLabel;
    private JLabel ценаLabel;
    private JLabel массаНеттоLabel;
    private JLabel датаПроизводстваLabel;
    private JLabel годенДоLabel;
    private JTextField titleField;
    private JTextField manufacturerField;
    private JTextField priceField;
    private JTextField NetWeightField;
    private JTextField dateOfManufactureField;
    private JTextField validUntilField;
    private JTextField categoryNameField;

    private void createUIComponents() {
        // TODO: place custom component creation code here
        panel1 = new JPanel();
        названиеКатегорииLabel = new JLabel();
        categoryNameField = new JTextField();
        названиеПродуктаLabel = new JLabel();
        производительLabel = new JLabel();
        ценаLabel = new JLabel();
        массаНеттоLabel = new JLabel();
        датаПроизводстваLabel = new JLabel();
        годенДоLabel = new JLabel();
        titleField = new JTextField();
        manufacturerField = new JTextField();
        priceField = new JTextField();
        NetWeightField = new JTextField();
        dateOfManufactureField = new JTextField();
        validUntilField = new JTextField();
        зарегистрироватьButton = new JButton();
    }

    private void setFixedSizeAndOtherSensitiviti() {
        Dimension size = new Dimension(300, 400);
        setMinimumSize(size);
        setSize(size);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }

    public ProductRegistrationWindow(Store store) {
        setFixedSizeAndOtherSensitiviti();
        this.getContentPane().add(panel1);
        setTitle("Регистрация продукта");
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);

        зарегистрироватьButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String categoryName = categoryNameField.getText();
                String title = titleField.getText();
                String manufacturer = manufacturerField.getText();
                double price = Double.parseDouble(priceField.getText());
                double NetWeight = Double.parseDouble(NetWeightField.getText());
                String dateOfManufacture = dateOfManufactureField.getText();
                String validUntil = validUntilField.getText();

                Product product = new Product(categoryName, title, manufacturer, price, NetWeight, dateOfManufacture, validUntil);
                store.addProduct(product);

                dispose();
            }
        });

        setLocationRelativeTo(null);
    }

}
