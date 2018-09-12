package com.github.dnelson54.model;


import org.apache.commons.lang3.StringUtils;

import java.time.LocalTime;

public class Time {

    private Long hours;
    private Long minutes;
    private Boolean isPm;

    public Time() {
        hours = 0L;
        minutes = 0L;
        isPm = false;
    }

    public Time(Long hours, Long minutes, Boolean isPm) {
        setHours(hours);
        setMinutes(minutes);
        setPm(isPm);
    }

    public Long getHours() {
        return hours;
    }

    public void setHours(Long hours) {
        this.hours = hours;
    }

    public Long getMinutes() {
        return minutes;
    }

    public void setMinutes(Long minutes) {
        this.minutes = minutes;
    }

    public Boolean getPm() {
        return isPm;
    }

    public void setPm(Boolean pm) {
        isPm = pm;
    }

    public LocalTime asLocalTime() {
        return LocalTime.parse(toString());
    }

    @Override
    public String toString() {

        Long hours = (isPm ? this.hours + 12 : this.hours);
        String hrString = StringUtils.leftPad(hours.toString(), 2,"0");
        String minString = StringUtils.leftPad(this.minutes.toString(), 2, "0");
        return hrString + ":" + minString + ":00";
    }
}
