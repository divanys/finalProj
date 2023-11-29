import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/*
 * Класс CustomerRegistrationWindow описывает форму регистрации клиента (покупателя).
 * Класс взаимодействует с классами Store (для добавления зарегистрированных покупателей и работы с ними),
 * Customer (для регистрации покупателя)
 * */

public class CustomerRegistrationWindow extends JFrame {
    private JTextField фамилияField1;
    private JTextField имяField2;
    private JTextField отчествоField3;
    private JTextField возрастField4;
    private JLabel фамилияLabel;
    private JLabel имяLabel;
    private JLabel отчествоLabel;
    private JLabel возврастLabel;
    private JLabel номерКартыLabel;
    private JTextField номерКартыField5;
    private JPanel panel1;
    private JButton зарегистрироватьButton;
    private JCheckBox наличиеСкидочнойКартыCheckBox;
    private JLabel скидочкаяКартаLabel;

    private void createUIComponents() {
        // TODO: place custom component creation code here
        фамилияField1 = new JTextField();
        имяField2 = new JTextField();
        отчествоField3 = new JTextField();
        возрастField4 = new JTextField();
        фамилияLabel = new JLabel();
        имяLabel = new JLabel();
        отчествоLabel = new JLabel();
        возврастLabel = new JLabel();
        номерКартыLabel = new JLabel();
        номерКартыField5 = new JTextField();
        зарегистрироватьButton = new JButton();
        panel1 = new JPanel();
        наличиеСкидочнойКартыCheckBox = new JCheckBox();
        скидочкаяКартаLabel = new JLabel();
    }


    // параметры окошка
    private void setFixedSizeAndOtherSensitiviti() {
        Dimension size = new Dimension(530, 500);
        setMinimumSize(size);
        setSize(size);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }


    // передаём объект Store store для сохранения данных в нём и дальнейшей работы с ними
    public CustomerRegistrationWindow(Store store) {
        setFixedSizeAndOtherSensitiviti();
        this.getContentPane().add(panel1);
        setTitle("Регистрация клиента");
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);

        // обработчик на кнопку, которая подтверждает регистрацию покупателя
        зарегистрироватьButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // получили данные из окна регистрации
                String фамилияField1Text = фамилияField1.getText();
                String имяField2Text = имяField2.getText();
                String отчествоField3Text = отчествоField3.getText();
                int возрастField4Text = Integer.parseInt(возрастField4.getText());
                String номерКартыField5Text = номерКартыField5.getText();
                boolean наличиеСкидочнойКартыCheckBoxText = наличиеСкидочнойКартыCheckBox.isSelected();
                Customer customer = new Customer(фамилияField1Text, имяField2Text, отчествоField3Text,
                        возрастField4Text, номерКартыField5Text, наличиеСкидочнойКартыCheckBoxText);  // создали покупателя
                store.addCustomer(customer);  // добавили покупателя в магазин

                dispose();  // закрыли окно регистрации
            }
        });

        setLocationRelativeTo(null);
    }
}
