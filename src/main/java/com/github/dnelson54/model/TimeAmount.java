package com.github.dnelson54.model;

import java.time.Duration;

public class TimeAmount {
    private Long amount;
    private TimeUnit unit;

    public TimeAmount(Long amount, TimeUnit unit) {
        this.amount = amount;
        this.unit = unit;
    }

    public Long getAmount() {
        return amount;
    }

    public void setAmount(Long amount) {
        this.amount = amount;
    }

    public TimeUnit getUnit() {
        return unit;
    }

    public void setUnit(TimeUnit unit) {
        this.unit = unit;
    }

    public Duration asDuration() {
        if(unit.equals(TimeUnit.HOURS)) {
            return Duration.ofHours(this.amount);
        } else if(unit.equals(TimeUnit.MINUTES)) {
            return Duration.ofMinutes(this.amount);
        } else {
            throw new RuntimeException("Unable to convert to duration");
        }
    }
}
