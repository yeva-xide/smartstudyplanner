package com.studyplanner.service;


import com.studyplanner.model.Subject;
import java.util.ArrayList;
import java.util.List;

public class SubjectManager {

    private List<Subject> subjects = new ArrayList<>();

    public void add(Subject subject) {
        subjects.add(subject);
    }

    public List<Subject> getAll() {
        return subjects;
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
    
}