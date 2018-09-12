package com.github.dnelson54.ui.time;

import com.github.dnelson54.model.Time;

import javax.swing.*;

class AmPmSelector extends JComboBox {
    private static final String[] timeUnits = {"AM", "PM"};


    AmPmSelector(Time time) {
        super(timeUnits);
        setSelectedIndex(getIndex(time.getPm()));
    }

    Boolean getValue() {
        return getSelectedIndex() == 1;
    }

    private int getIndex(Boolean isPM) {
        if(isPM) {
            return 1;
        } else {
            return 0;
        }
    }
}
