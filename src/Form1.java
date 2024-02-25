import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Random;

public class Form1 {
    private JTable table1;
    private JButton buttonRandom;
    private JButton buttonChangeData;
    protected JPanel panel1;
    private JButton buttonExit;


    public Form1() {

        // Добавляем обработчик события нажатия на кнопку "Случайные числа"
        buttonRandom.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // Создаем новый двумерный массив для хранения случайных чисел
                Object[][] data = new Object[5][5];

                // Создаем экземпляр класса Random
                Random random = new Random();

                // Заполняем массив случайными числами
                for (int i = 0; i < data.length; i++) {
                    for (int j = 0; j < data[i].length; j++) {
                        data[i][j] = String.valueOf(random.nextInt(100)); // Генерируем случайное число от 0 до 99
                    }
                }

                // Создаем заголовки столбцов для таблицы
                String[] columnNames = {"Column1", "Column2", "Column3", "Column4", "Column5"};

                // Создаем новую модель таблицы с нашими данными и заголовками столбцов
                DefaultTableModel model = new DefaultTableModel(data, columnNames);

                // Устанавливаем новую модель для нашей таблицы
                table1.setModel(model);
            }
        });

        buttonRandom.doClick(); // Вызываем событие нажатия на кнопку "Случайные числа" при запуске программы

        // Добавляем обработчик события нажатия на кнопку "Изменить данные"
        buttonChangeData.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // Получаем модель таблицы
                DefaultTableModel model = (DefaultTableModel) table1.getModel();

                // Инициализируем переменные для хранения максимального и минимального значения и их индексов
                int max = Integer.MIN_VALUE;
                int min = Integer.MAX_VALUE;
                int maxRow = -1;
                int maxCol = -1;
                int minRow = -1;
                int minCol = -1;

                // Проходим по всем ячейкам таблицы
                for (int row = 0; row < model.getRowCount(); row++) {
                    for (int col = 0; col < model.getColumnCount(); col++) {
                        // Получаем значение текущей ячейки
                        int value;

                        // Пытаемся преобразовать значение ячейки в целое число
                        try {
                            value = Integer.parseInt((String) model.getValueAt(row, col));
                        } catch (NumberFormatException ex) {
                            JOptionPane.showMessageDialog(null, "Ошибка в ячейке [" + (row + 1) + ", " + (col + 1) + "]");
                            return;
                        }

                        // Если текущее значение больше максимального, обновляем максимум и его индексы
                        if (value > max) {
                            max = value;
                            maxRow = row;
                            maxCol = col;
                        }

                        // Если текущее значение меньше минимального, обновляем минимум и его индексы
                        if (value < min) {
                            min = value;
                            minRow = row;
                            minCol = col;
                        }
                    }
                }

                // Меняем местами максимальное и минимальное значение
                model.setValueAt(Integer.toString(min), maxRow, maxCol);
                model.setValueAt(Integer.toString(max), minRow, minCol);
            }
        });

        // Добавляем обработчик события нажатия на кнопку "Выход"
        buttonExit.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.exit(0); // Завершаем программу
            }
        });
    }
}
