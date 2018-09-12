package com.github.dnelson54.ui;

import com.github.dnelson54.controller.TimeCalculator;

import javax.swing.*;
import java.awt.*;

public class TimeCalculatorWindow extends JFrame {

    TimeCalculator timeCalculator;

    TimeCalculatorComponent calculatorComponent;


    public TimeCalculatorWindow(TimeCalculator timeCalculator) {
        Container contentPane = getContentPane();
        this.timeCalculator = timeCalculator;

        calculatorComponent = new TimeCalculatorComponent(this.timeCalculator);
        contentPane.add(calculatorComponent);

        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        pack();
        setVisible(true);
    }
}
