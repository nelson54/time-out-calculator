package com.github.dnelson54.controller;

import com.github.dnelson54.model.Time;
import com.github.dnelson54.model.TimeAmount;

import java.time.LocalTime;

public class TimeCalculator {
    private Time startOfDay;
    private TimeAmount workDayLength;
    private TimeAmount lunchLength;

    public Time getStartOfDay() {
        return startOfDay;
    }

    public void setStartOfDay(Time startOfDay) {
        this.startOfDay = startOfDay;
    }

    public TimeAmount getWorkDayLength() {
        return workDayLength;
    }

    public void setWorkDayLength(TimeAmount workDayLength) {
        this.workDayLength = workDayLength;
    }

    public TimeAmount getLunchLength() {
        return lunchLength;
    }

    public void setLunchLength(TimeAmount lunchLength) {
        this.lunchLength = lunchLength;
    }

    public LocalTime calculateEndOfDay() {
        return this.startOfDay.asLocalTime()
                .plus(workDayLength.asDuration())
                .plus(lunchLength.asDuration());
    }
}
