package practice.linked_list;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ListPerformanceGUI {
    private JFrame frame;
    private JTextField sizeField;
    private JButton runButton;
    private JPanel resultsPanel;

    public ListPerformanceGUI() {
        initialize();
    }

    private void initialize() {
        frame = new JFrame();
        frame.setBounds(200, 100, 1500, 500);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.getContentPane().setLayout(new BorderLayout(0, 0));

        JPanel inputPanel = new JPanel();
        frame.getContentPane().add(inputPanel, BorderLayout.NORTH);

        JLabel sizeLabel = new JLabel("Размер списка:");
        inputPanel.add(sizeLabel);

        sizeField = new JTextField();
        sizeField.setColumns(10);
        inputPanel.add(sizeField);

        runButton = new JButton("Запустить тесты");
        inputPanel.add(runButton);

        resultsPanel = new JPanel();
        frame.getContentPane().add(resultsPanel, BorderLayout.CENTER);
        resultsPanel.setLayout(new BoxLayout(resultsPanel, BoxLayout.Y_AXIS));

        runButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                runTests();
            }
        });
    }

    private void runTests() {
        resultsPanel.removeAll();
        int size = Integer.parseInt(sizeField.getText());



        // Здесь должен быть код для запуска тестов и получения результатов
        // Предположим, что у нас есть метод getTestResults, который возвращает результаты
        TestResult results = new TestResult().getTestResults(size);

        for (TestResult result : results.getResults()) {
            JLabel testLabel = new JLabel(result.getTestName());
            resultsPanel.add(testLabel);

            JProgressBar arrayListBar = new JProgressBar();
            arrayListBar.setMaximum((int) Math.max(result.getArrayListTime(), result.getLinkedListTime()));
            arrayListBar.setValue((int) result.getArrayListTime());
            arrayListBar.setString("ArrayList: " + result.getArrayListTime() + " нс");
            arrayListBar.setStringPainted(true);
            resultsPanel.add(arrayListBar);

            JProgressBar linkedListBar = new JProgressBar();
            linkedListBar.setMaximum((int) Math.max(result.getArrayListTime(), result.getLinkedListTime()));
            linkedListBar.setValue((int) result.getLinkedListTime());
            linkedListBar.setString("LinkedList: " + result.getLinkedListTime() + " нс");
            linkedListBar.setStringPainted(true);
            resultsPanel.add(linkedListBar);
        }

        resultsPanel.revalidate();
        resultsPanel.repaint();
    }

    public void show() {
        frame.setVisible(true);
    }

    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    ListPerformanceGUI window = new ListPerformanceGUI();
                    window.show();
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
    }
}

