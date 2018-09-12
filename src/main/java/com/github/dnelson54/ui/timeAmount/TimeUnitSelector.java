package com.github.dnelson54.ui.timeAmount;

import com.github.dnelson54.model.TimeUnit;

import javax.swing.*;

class TimeUnitSelector extends JComboBox {
    private static final String[] timeUnits = {"Hours", "Minutes"};

    TimeUnitSelector(TimeUnit timeUnit) {
        super(timeUnits);
        setSelectedIndex(getIndexOfTimeUnit(timeUnit));
    }

    TimeUnit getValue() {
        return TimeUnit.fromString(timeUnits[getSelectedIndex()]);
    }

    private int getIndexOfTimeUnit(TimeUnit timeUnit) {
        if(timeUnit.equals(timeUnits[0])) {
            return 0;
        } else {
            return 1;
        }
    }
}
