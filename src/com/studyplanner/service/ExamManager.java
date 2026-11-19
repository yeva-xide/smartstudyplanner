package com.studyplanner.service;

import com.studyplanner.model.Exam;
import com.studyplanner.model.Subject;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class ExamManager {

    private List<Exam> exams = new ArrayList<>();

    
    public void add(Exam exam) {
        if (exam == null) {
            throw new IllegalArgumentException("Exam cannot be null.");
        }
        exams.add(exam);
    }

    
    public List<Exam> getAll() {
        return Collections.unmodifiableList(exams);
    }

    
    public Exam findById(int id) {
        for (Exam e : exams) {
            if (e.getId() == id) {
                return e;
            }
        }
        return null;
    }

    
    public void update(int id, String name, LocalDateTime date, Subject subject) {
        Exam exam = findById(id);
        if (exam == null) {
            throw new IllegalArgumentException("Exam with ID " + id + " not found.");
        }
        exam.update(name, date, subject);
    }


    public boolean remove(int id) {
        Exam exam = findById(id);
        if (exam == null) {
            return false;
        }
        return exams.remove(exam);
    }

    public boolean hasExamFor(Subject subject) {
        for (Exam e : exams) {
            if (e.getSubject() == subject) {
                return true;
            }
        }
        return false;
    }

    public List<Exam> getUpcoming() {
        List<Exam> results = new ArrayList<>();
        for (Exam e : exams) {
            if (e.getDate().isAfter(LocalDateTime.now())) {
                results.add(e);
            }
        }
        return results;
    }

    public void sortByDate() {
        exams.sort(Comparator.comparing(Exam::getDate));
    }
}