package com.studyplanner.service;

import com.studyplanner.model.Difficulty;
import com.studyplanner.model.Subject;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;



public class SubjectManager {

    private List<Subject> subjects = new ArrayList<>();
    private ExamManager examManager;

    public SubjectManager(ExamManager examManager) {
        this.examManager = examManager;
    }

    public void add(Subject subject) {
        if (subject == null) {
            throw new IllegalArgumentException("Subject cannot be null.");
        }
        for (Subject s : subjects) {
            if (s.getName().equalsIgnoreCase(subject.getName())) {
                throw new IllegalArgumentException("Subject with name '" + subject.getName() + "' already exists.");
            }
        }
        subjects.add(subject);
    }

    public List<Subject> getAll() {
        return Collections.unmodifiableList(subjects);
    }

    public List<Subject> searchByName(String text) {
        List<Subject> results = new ArrayList<>();
        if (text == null) {
            return results;
        }
        for (Subject s : subjects) {
            if (s.getName().toLowerCase().contains(text.toLowerCase())) {
                results.add(s);
            }
        }
        return results;
    }

    public Subject findById(int id) {
        for (Subject s : subjects) {
            if (s.getId() == id) {
                return s;
            }
        }
        return null;
    }

    public void update(int id, String name, int coefficient, Difficulty difficulty) {
        Subject subject = findById(id);
        if (subject == null) {
            throw new IllegalArgumentException("Subject with ID " + id + " not found.");
        }
        subject.update(name, coefficient, difficulty);
    }

    public boolean remove(int id) {
        Subject subject = findById(id);
        if (subject == null) {
            return false;
        }
        if (examManager.hasExamFor(subject)) {
            throw new IllegalArgumentException("Cannot delete '" + subject.getName() + "': it has exams. Delete its exams first.");
        }
        return subjects.remove(subject);
    }
}