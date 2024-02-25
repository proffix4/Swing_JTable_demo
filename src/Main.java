import javax.swing.*;
import java.awt.*;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {
        JFrame frame = new JFrame("Form1"); // Создаем новый объект класса JFrame
        frame.setTitle("Работа с JTable"); // Устанавливаем заголовок окна
        frame.setResizable(false); // Запрещаем изменение размеров окна
        frame.setIconImage(Toolkit.getDefaultToolkit().createImage(Main.class.getResource("icon.png"))); // Устанавливаем иконку окна
        frame.setContentPane(new Form1().panel1); // Устанавливаем панель содержимого окна
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); // Устанавливаем действие при закрытии окна
        frame.setSize(500, 500); // Устанавливаем размер окна
        frame.setLocationRelativeTo(null); // Устанавливаем положение окна по центру
        frame.pack(); // Устанавливаем оптимальный размер окна
        frame.setVisible(true); // Устанавливаем видимость окна
    }
}