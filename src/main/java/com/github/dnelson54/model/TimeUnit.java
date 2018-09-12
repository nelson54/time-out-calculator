package com.github.dnelson54.model;

public enum TimeUnit {
    MINUTES,
    HOURS;

    public static TimeUnit fromString(String text) {
        for (TimeUnit timeUnit : TimeUnit.values()) {
            if (timeUnit.toString().equalsIgnoreCase(text)) {
                return timeUnit;
            }
        }
        return null;
    }

    public Boolean equals(String text) {
        return this.toString().toLowerCase().equals(text.toLowerCase());
    }
}
