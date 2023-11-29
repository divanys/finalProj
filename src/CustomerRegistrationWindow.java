import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

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

    private void setFixedSizeAndOtherSensitiviti() {
        Dimension size = new Dimension(300, 400);
        setMinimumSize(size);
        setSize(size);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }

    public CustomerRegistrationWindow(Store store) {
        setFixedSizeAndOtherSensitiviti();
        this.getContentPane().add(panel1);
        setTitle("Регистрация клиента");
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);

        зарегистрироватьButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String фамилияField1Text = фамилияField1.getText();
                String имяField2Text = имяField2.getText();
                String отчествоField3Text = отчествоField3.getText();
                int возрастField4Text = Integer.parseInt(возрастField4.getText());
                String номерКартыField5Text = номерКартыField5.getText();
                boolean наличиеСкидочнойКартыCheckBoxText = наличиеСкидочнойКартыCheckBox.isSelected();
                Customer customer = new Customer(фамилияField1Text, имяField2Text, отчествоField3Text, возрастField4Text, номерКартыField5Text, наличиеСкидочнойКартыCheckBoxText);
                store.addCustomer(customer);

                dispose();
            }
        });

        setLocationRelativeTo(null);
    }
}
