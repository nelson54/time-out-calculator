package com.github.dnelson54.model;

import java.util.ArrayList;
import java.util.List;

public class TimeValidator {
    private static final String N = "Invalid hour";
    private static final String INVALID_HOURS = "Invalid hour";
    private static final String INVALID_MINUTES = "Invalid hour";

    public List<String> validate(Time time) {
        List<String> messages = new ArrayList<>();
        if(time.getHours() == null || time.getHours() > 12) {
            messages.add(INVALID_HOURS);
        }

        if(time.getMinutes() == null || time.getMinutes() > 60) {
            messages.add(INVALID_MINUTES);
        }

        return messages;
    }
}
