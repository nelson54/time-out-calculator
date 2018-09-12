package com.github.dnelson54.ui.timeAmount;

import com.github.dnelson54.model.TimeAmount;
import com.github.dnelson54.ui.SimpleDocumentListener;

import javax.swing.*;
import javax.swing.border.Border;
import java.awt.*;

public class TimeAmountComponent extends JPanel {
    private final TimeAmount timeAmount;
    private final LayoutManager layout;
    private final JTextField amount;
    private final TimeUnitSelector timeUnitSelector;

    public TimeAmountComponent(String label,  TimeAmount timeAmount) {
        super();

        this.timeAmount = timeAmount;

        layout = new BoxLayout(this, BoxLayout.X_AXIS);
        this.setLayout(layout);

        Border border = BorderFactory.createTitledBorder(label);
        this.setBorder(border);

        amount = new JTextField();
        amount.setText(timeAmount.getAmount().toString());
        amount.getDocument().addDocumentListener((SimpleDocumentListener) event -> {
            System.out.println("Value changed for: " + label);
            try {
                timeAmount.setAmount(Long.parseLong(amount.getText()));
            } catch (Exception exception) {
                timeAmount.setAmount(null);
            }
        });
        add(amount);

        timeUnitSelector = new TimeUnitSelector(timeAmount.getUnit());
        timeUnitSelector.addActionListener((actionEvent) -> {
            System.out.println("Time unit Changed for: " + label);
            timeAmount.setUnit(timeUnitSelector.getValue());
        });
        add(timeUnitSelector);


    }
}
