package gui;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class MathOperationButtonListener implements ActionListener{




    private String typeOfMathOperation;
        private JTextField inputField;


        @Override
        public void actionPerformed(ActionEvent e) {
            StringBuilder sb = new StringBuilder(inputField.getText());
            JButton btn = (JButton) e.getSource();
            typeOfMathOperation = btn.getText();
            sb.append(btn.getText());
            inputField.setText(sb.toString());


        }


    }

