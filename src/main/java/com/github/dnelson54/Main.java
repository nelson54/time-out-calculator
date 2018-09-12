package com.github.dnelson54;

import com.github.dnelson54.controller.TimeCalculator;
import com.github.dnelson54.model.Time;
import com.github.dnelson54.model.TimeAmount;
import com.github.dnelson54.model.TimeUnit;
import com.github.dnelson54.model.TimeValidator;
import com.github.dnelson54.ui.TimeCalculatorWindow;

import javax.swing.*;

public class Main {

    private final TimeCalculatorWindow window;

    public static void main(String[] args) {
        Main main = new Main();
    }

    private Main() {
        try {
            UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
        } catch(Exception e) {
            //TODO: Handle this
        }

        TimeValidator timeValidator = new TimeValidator();

        TimeCalculator timeCalculator = new TimeCalculator();
        timeCalculator.setStartOfDay(new Time(8L, 0L, false));
        timeCalculator.setLunchLength(new TimeAmount(0L, TimeUnit.MINUTES));
        timeCalculator.setWorkDayLength(new TimeAmount(8L, TimeUnit.HOURS));

        window = new TimeCalculatorWindow(timeCalculator);
    }
}
