package com.github.dnelson54.ui;

import com.github.dnelson54.controller.TimeCalculator;
import com.github.dnelson54.model.TimeValidator;
import com.github.dnelson54.ui.messages.MessageViewer;
import com.github.dnelson54.ui.time.TimeComponent;
import com.github.dnelson54.ui.timeAmount.TimeAmountComponent;

import javax.swing.*;
import java.awt.*;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Collection;

class TimeCalculatorComponent extends JPanel {
    private final TimeValidator timeValidator;
    private final TimeCalculator timeCalculator;
    private final DateTimeFormatter dateFormat;


    private final LayoutManager layout;
    private final TimeComponent startTime;
    private final TimeAmountComponent dayLength;
    private final TimeAmountComponent lunchLength;
    private final Button calculate;
    private final ResultViewer resultViewer;
    private final MessageViewer messageViewer;


    TimeCalculatorComponent(TimeCalculator timeCalculator) {
        super();

        this.timeCalculator = timeCalculator;

        timeValidator = new TimeValidator();
        dateFormat = DateTimeFormatter.ofPattern("hh:mm a");

        layout = new BoxLayout(this, BoxLayout.PAGE_AXIS);
        this.setLayout(layout);

        startTime = new TimeComponent("Start of day", timeCalculator.getStartOfDay());
        add(startTime);

        dayLength = new TimeAmountComponent("Work Day Length", timeCalculator.getWorkDayLength());
        add(dayLength);

        lunchLength = new TimeAmountComponent("Lunch Length", timeCalculator.getLunchLength());
        add(lunchLength);

        resultViewer = new ResultViewer();
        resultViewer.updateResult(calculate());

        messageViewer = new MessageViewer();


        calculate = new Button("Calculate");
        calculate.addActionListener((actionEvent)->{
            recalculate();
        });
        add(calculate);

        add(resultViewer);

        add(messageViewer);


    }

    private String calculate() {
        return dateFormat.format(timeCalculator.calculateEndOfDay());
    }

    private void recalculate() {
        Collection<String> messages = timeValidator.validate(timeCalculator.getStartOfDay());

        if(messages.size() > 0) {
            messageViewer.show(messages);
            resultViewer.updateResult(" ");

            for(String message : messages) {
                System.out.println(message);
            }
        } else {
            messageViewer.show(new ArrayList<>());
            resultViewer.updateResult(calculate());
            System.out.println(calculate());
        }
    }
}
