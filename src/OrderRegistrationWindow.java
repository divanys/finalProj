import javax.swing.*;
import java.awt.*;

public class OrderRegistrationWindow extends JFrame {
    private JList кассирlist1;
    private JList клиентыlist2;
    private JTable продуктыtable1;
    private JLabel продуктыLabel;
    private JLabel кассирLabel;
    private JLabel клиентLabel;
    private JPanel panel1;

    private void setFixedSizeAndOtherSensitiviti() {
        Dimension size = new Dimension(300, 400);
        setMinimumSize(size);
        setSize(size);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }

    private void createUIComponents() {
        // TODO: place custom component creation code here
        кассирlist1 = new JList();
        клиентыlist2 = new JList();
        продуктыtable1 = new JTable();
        продуктыLabel = new JLabel();
        кассирLabel = new JLabel();
        клиентLabel = new JLabel();
        panel1 = new JPanel();
    }
}
