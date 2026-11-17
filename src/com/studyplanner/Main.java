package com.studyplanner;

import com.studyplanner.model.Difficulty;
import com.studyplanner.model.Subject;
import com.studyplanner.service.SubjectManager;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String text;
        SubjectManager manager = new SubjectManager();
        Subject s;
        List<Subject> results;
        int i;

        manager.add(new Subject("Java", 3, Difficulty.HIGH));
        manager.add(new Subject("Databases", 2, Difficulty.MEDIUM));
        manager.add(new Subject("Algorithms", 3, Difficulty.HIGH));

        for (i = 0; i < manager.getAll().size(); i++) {
            s = manager.getAll().get(i);
            System.out.println(s.getId() + " | " + s.getName());
        }

        System.out.print("Search for a subject by name: ");
        text = scanner.nextLine();

        System.out.println("--- Search: '" + text + "' ---");
        results = manager.searchByName(text);

        for (i = 0; i < results.size(); i++) {
            s = results.get(i);
            System.out.println(s.getId() + " | " + s.getName());
        }



        scanner.close();
    }
}