package com.studyplanner.model;

public class Subject {

    private static int nextId = 1;
    private final int id;

    private String name;
    private int coefficient;
    private Difficulty difficulty;

    public Subject(String name, int coefficient, Difficulty difficulty) {
        update(name, coefficient, difficulty);
        this.id = nextId;
        nextId++;
    }

    private void validate(String name, int coefficient, Difficulty difficulty) {
    if (name == null || name.isBlank()) {
        throw new IllegalArgumentException("Subject name cannot be empty.");
    }
    if (coefficient < 1 || coefficient > 5) {
        throw new IllegalArgumentException("Coefficient must be between 1 and 5.");
    }
    if (difficulty == null) {
        throw new IllegalArgumentException("Difficulty is required.");
    }
}
public void update(String name, int coefficient, Difficulty difficulty) {
    validate(name, coefficient, difficulty);

    this.name = name.trim();
    this.coefficient = coefficient;
    this.difficulty = difficulty;
}
    
    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public int getCoefficient() {
        return coefficient;
    }

    public Difficulty getDifficulty() {
        return difficulty;
    }
}