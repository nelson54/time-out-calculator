package com.github.dnelson54.ui.time;

import com.github.dnelson54.model.Time;
import com.github.dnelson54.ui.SimpleDocumentListener;

import javax.swing.*;
import javax.swing.border.Border;
import java.awt.*;


public class TimeComponent extends JPanel {
    private final Time time;

    private final LayoutManager layout;
    private final JTextField hours;
    private final JTextField minutes;
    private final AmPmSelector amPmSelector;

    public TimeComponent(String label, Time time) {
        super(new BorderLayout());

        this.time = time;

        layout = new BoxLayout(this, BoxLayout.X_AXIS);
        this.setLayout(layout);

        Border border = BorderFactory.createTitledBorder(label);
        this.setBorder(border);

        hours = new JTextField();
        hours.setText(time.getHours().toString());
        hours.getDocument().addDocumentListener((SimpleDocumentListener) event -> {
            System.out.println("Hours changed for: " + label);
            try {
                Long hourValue = Long.parseLong(hours.getText());
                time.setHours(hourValue);
            } catch(Exception exception) {
                time.setHours(null);
            }
        });
        add(hours);

        JLabel colon = new JLabel(" : ");
        add(colon);

        minutes = new JTextField();
        minutes.setText(time.getMinutes().toString());
        minutes.getDocument().addDocumentListener((SimpleDocumentListener) event -> {
            System.out.println("Minutes changed for: " + label);
            try {
                Long minuteValue = Long.parseLong(minutes.getText());
                time.setMinutes(minuteValue);
            } catch(Exception exception) {
                time.setMinutes(null);
            }
        });
        add(minutes);

        amPmSelector = new AmPmSelector(time);
        amPmSelector.addActionListener((event) -> {
            System.out.println("AM/PM selector changed for: " + label);
            time.setPm(amPmSelector.getValue());
        });

        add(amPmSelector);
    }
}
