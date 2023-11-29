import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

/*
* Класс AllOrders предназначен для управления заказами и чеками:
*   1. Вы можете сформировать заказ и зарегистрировать новый чек (кнопка совершитьПокупкуButton)
*   2. А также нажать на кнопочку показатьЧекиButton и увидеть все чеки, которые были зарегистрированы ранее, в отдельных окошечках!
* (каждый чек имеет свой номер, но я слишком превзошла себя и просто добавляю 1 к переменной orderNumber на каждое окошко)
*   3. А ещё есть возможность вернуться к редактированию магазина (кнопка вернутьсяButton)
* (учитывайте, что при возвращении на страницу редактирования магазина, ИНФОРМАЦИЯ О РАНЕЕ ЗАРЕГИСТРИРОВАННЫХ ЧЕКАХ УДАЛЯЕТСЯ!
* Но информация о зарегистрированных ранее продуктах/клиентах/кассирах не удаляется)
*
* */

public class AllOrders extends JFrame {
    private ArrayList<Order> ordersList;  // для формирования списка всех чеков и дальнейшего вывода их в отдельных окнах

    // привычные кнопочки (тут только кнопки)
    private JButton показатьЧекиButton;
    private JButton совершитьПокупкуButton;
    private JButton вернутьсяButton;
    private JLabel желаетеСовершитьПокупкуLabel;
    private JLabel коллекцияЧековLabel;
    private JLabel желаетеВернутьсяКМодернизацииLabel;
    private JPanel panel1;
    private final Store store;


    public AllOrders(String storeNameField, Store store) {
        this.store = store;  // для получения данных из этого класса
        this.ordersList = new ArrayList<>();
        setFixedSizeAndOtherSensitiviti();  // параметры окошечка
        this.getContentPane().add(panel1);  // добавляем панель
        setTitle(storeNameField);  // название (ранее введённое при регистрации магазина) магазина переносится в название окошечка
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);  //  указывает, что при закрытии окна, оно будет закрыто (да ну), но не завершит работу всего приложения

        совершитьПокупкуButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // передаём объект уже имеющегося магазина и объект данного класса, чтобы сохранились данные в этом же классе
                OrderRegistrationWindow orderRegistrationWindow = new OrderRegistrationWindow(store, AllOrders.this);
                orderRegistrationWindow.setVisible(true);  // делаем окошко регистрации заказа видимым
            }
        });

        показатьЧекиButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                showAllOrders(); // тут мы показываем все чеки (реально все, и каждый в своём окне со своим номерком)
            }
        });

        вернутьсяButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                setVisible(false);  // если захотели вернуться назад, чтобы добавить кого-то/что-то, окошко управления магазином закрывается
                store.setVisible(true);  // появляется ранее закрытое окно регистрации магазина
            }
        });
    }


    // добавление заказа/чека в список, если такого заказа нет (можно было сделать и с уже имеющимся, но пришлось бы добавлять id, мне лень)
    public void addOrder(Order order) {
        boolean isOrderExist = false;
        for (Order existingOrder : ordersList) {
            if (existingOrder.getCustomer() == order.getCustomer() && existingOrder.getProductList().equals(order.getProductList())) {
                JOptionPane.showMessageDialog(this, "Заказ уже существует!", "Предупреждение", JOptionPane.WARNING_MESSAGE);
                isOrderExist = true;
                break;
            }
        }
        if (!isOrderExist) {
            ordersList.add(order);
            order.printOrderInfo();
        }
    }


    // показываем наши чеки (каждый в новом окошке)
    private void showAllOrders() {
        int orderNumber = 1;
        JFrame previousFrame = null;

        for (Order order : ordersList) {
            String orderInfo = order.printOrderInfo();

            JFrame orderFrame = new JFrame("Чек #" + orderNumber);
            orderFrame.setSize(500, 400);

            JTextArea orderTextArea = new JTextArea();
            orderTextArea.setText(orderInfo);

            JScrollPane scrollPane = new JScrollPane(orderTextArea);
            orderFrame.getContentPane().add(scrollPane);

            if (previousFrame != null) {
                // Установка каждого нового окна относительно предыдущего
                orderFrame.setLocationRelativeTo(previousFrame);
            }

            orderFrame.setVisible(true);
            orderFrame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);

            previousFrame = orderFrame;
            orderNumber++;
        }
    }


    private void setFixedSizeAndOtherSensitiviti() {
        Dimension size = new Dimension(1300, 800);
        setMinimumSize(size);
        setSize(size);
        setLocationRelativeTo(null);
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
