package com.studyplanner.service;


import com.studyplanner.model.Difficulty;
import com.studyplanner.model.Subject;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class SubjectManager {

    private List<Subject> subjects = new ArrayList<>();

    public void add(Subject subject) {
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

    public boolean remove(int id) {
    Subject subject = findById(id);
    if (subject == null) {
        return false;
    }
    return subjects.remove(subject);
    }


    public void update(int id, String name, int coefficient, Difficulty difficulty) {
        Subject subject = findById(id);
        if (subject != null) {
            subject.update(name, coefficient, difficulty);
            } else {
    throw new IllegalArgumentException("Subject with ID " + id + " not found.");
}
        }
    }