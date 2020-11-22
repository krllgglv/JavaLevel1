
package gui;

import javax.script.ScriptEngine;
import javax.script.ScriptEngineManager;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.InputStreamReader;


public class MainFrame extends JFrame {


    public MainFrame() {
        setTitle("Calculator");
        setBounds(100, 100, 300, 500);
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);

        setLayout(new BorderLayout());

        JPanel top = new JPanel();
        add(top, BorderLayout.CENTER);
        top.setLayout(new GridLayout(4, 3));
        JPanel bottom = new JPanel();
        add(bottom, BorderLayout.SOUTH);

        bottom.setLayout(new BorderLayout());

        JTextField inputField = new JTextField();
        DigitButtonListener digitButtonListener = new DigitButtonListener(inputField);
        for (int i = 0; i < 10; i++) {
            JButton btn = new JButton(String.valueOf(i));
            btn.addActionListener(digitButtonListener);
            top.add(btn);
        }
        MathOperationButtonListener mathOperationButtonListener = new MathOperationButtonListener(inputField);
        JButton minus = new JButton("-");
        minus.addActionListener(digitButtonListener);
        top.add(minus);
        JButton add = new JButton("+");
        add.addActionListener(mathOperationButtonListener);
        top.add(add);

        JButton multiple = new JButton("*");
        multiple.addActionListener(digitButtonListener);
        top.add(multiple);
        JButton divide = new JButton("/");
        divide.addActionListener(digitButtonListener);
        top.add(divide);
        JButton pow = new JButton("^");
        pow.addActionListener(digitButtonListener);
        top.add(pow);
        JButton calc = new JButton("=");
        calc.addActionListener(new CalcButtonListener(inputField));
        top.add(calc);


        bottom.add(inputField, BorderLayout.CENTER);
        JButton clear = new JButton("C");
        clear.addActionListener(new ClearButtonListener(inputField));
        bottom.add(clear, BorderLayout.EAST);

        setVisible(true);


    }

    public static class CalcButtonListener implements ActionListener {
//        int leftDigit;
//        int rightDigit;
//        float result;
        private JTextField inputField;
        public CalcButtonListener(JTextField inputField) {
            this.inputField = inputField;
        }
        @Override
        public void actionPerformed(ActionEvent e) {
            StringBuilder sb = new StringBuilder(inputField.getText());

//            leftDigit = Integer.parseInt(inputField.getText().split("\\D")[0]);
//            rightDigit = Integer.parseInt(inputField.getText().split("\\D")[1]);
//            switch (inputField.getText().replaceAll("\\d","")) {
//                case "+":
//                    result = leftDigit+rightDigit;
//                    sb.append(" = ");
//                    sb.append((int)result);
//                    break;
//                case "-":
//                    result = leftDigit-rightDigit;
//                    sb.append(" = ");
//                    sb.append((int)result);
//                    break;
//                case "*":
//                    result = leftDigit*rightDigit;
//                    sb.append(" = ");
//                    sb.append((int)result);
//                    break;
//                case "/":
//                result = (float)leftDigit/rightDigit;
//
//                sb.append(" = ");
//                sb.append(result);
//                break;
//            }

            try {
                ScriptEngineManager mgr = new ScriptEngineManager();
                ScriptEngine engine = mgr.getEngineByName("JavaScript");
                sb.append(" = ");
                sb.append(engine.eval(inputField.getText()));
            } catch (Exception exception) {
                exception.printStackTrace();
            }
            inputField.setText(sb.toString());


        }
    }

    public static class ClearButtonListener implements ActionListener {
        private JTextField inputField;

        public ClearButtonListener(JTextField inputField) {
            this.inputField = inputField;

        }

        @Override
        public void actionPerformed(ActionEvent e) {
            inputField.setText("");
        }
    }

    public class MathOperationButtonListener implements ActionListener {
        private JTextField inputField;

        public MathOperationButtonListener(JTextField inputField) {
            this.inputField = inputField;
        }

        @Override
        public void actionPerformed(ActionEvent e) {
            StringBuilder sb = new StringBuilder(inputField.getText());
            JButton btn = (JButton) e.getSource();
            sb.append(btn.getText());
            inputField.setText(sb.toString());


        }


    }
}

