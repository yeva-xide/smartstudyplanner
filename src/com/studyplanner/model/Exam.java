package com.studyplanner.model;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.temporal.ChronoUnit;
// FIX: removed LocalTime, DateTimeFormatter, DateTimeParseException (not used here;
//      parsing text into dates is the menu's job)

public class Exam {
    private static int nextId = 1;
    private final int id;

    private String name;
    private LocalDateTime date;
    private Subject subject;

    public Exam(String name, LocalDateTime date, Subject subject) {
        update(name, date, subject);
 
        this.id = nextId;
        nextId++;
    }

    private void validate(String name, LocalDateTime date, Subject subject) {
        if (name == null || name.isBlank()) {
            throw new IllegalArgumentException("Exam name cannot be empty.");
        }
        if (date == null) {
            throw new IllegalArgumentException("Exam date and time are required.");
        }
        if (subject == null) {
            throw new IllegalArgumentException("An exam must have a subject.");
        }
        if (date.isBefore(LocalDateTime.now())) {
            throw new IllegalArgumentException("Exam date cannot be in the past.");
        }
    }

    public void update(String name, LocalDateTime dateTime, Subject subject) {
        validate(name, dateTime, subject); 
        this.name = name.trim();
        this.subject = subject;
        this.date = dateTime;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public LocalDateTime getDate() {
        return date;
    }

    public Subject getSubject() {
        return subject;
    }

    public long daysRemaining() {
        return ChronoUnit.DAYS.between(LocalDate.now(), date.toLocalDate());
    }
}