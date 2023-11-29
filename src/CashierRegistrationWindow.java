import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class CashierRegistrationWindow extends JFrame {
    private JLabel фамилияLabel;
    private JLabel имяLabel;
    private JLabel отчествоLabel;
    private JLabel возврастLabel;
    private JTextField фамилияField1;
    private JTextField имяField2;
    private JTextField отчествоField3;
    private JTextField возрастField4;
    private JButton зарегистрироватьButton;
    private JPanel panel1;
    private JLabel номерКассыLabel;
    private JSpinner НомерКассыspinner1;

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
        зарегистрироватьButton = new JButton();
        panel1 = new JPanel();
        номерКассыLabel = new JLabel();
        НомерКассыspinner1 = new JSpinner();
    }


    private void setFixedSizeAndOtherSensitiviti() {
        Dimension size = new Dimension(300, 400);
        setMinimumSize(size);
        setSize(size);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }

    public CashierRegistrationWindow(Store store) {
        setFixedSizeAndOtherSensitiviti();
        this.getContentPane().add(panel1);
        setTitle("Регистрация кассира");
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);

        зарегистрироватьButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String фамилияField1Text = фамилияField1.getText();
                String имяField2Text = имяField2.getText();
                String отчествоField3Text = отчествоField3.getText();
                int возрастField4Text = Integer.parseInt(возрастField4.getText());
                int НомерКассыspinner1Text = (int) НомерКассыspinner1.getValue();

                Cashier cashier = new Cashier(фамилияField1Text, имяField2Text, отчествоField3Text, возрастField4Text, НомерКассыspinner1Text);
                store.addCashier(cashier);

                dispose();


            }
        });

        setLocationRelativeTo(null);
    }
}
