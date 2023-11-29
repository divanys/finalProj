import javax.swing.*;
import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {  // чух-чух (запуск)
            @Override
            public void run() {
                new Store().setVisible(true);
            }
        });
    }
}
