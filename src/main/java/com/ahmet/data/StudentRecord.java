package com.ahmet.data;

import com.ahmet.model.Student;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class StudentRecord {
    public static List<Student> getStudents() {
        List<Student> students = new ArrayList<>();
        students.add(new Student("Ahmet", "Acik", 23, "Male", "Computer Science", "London", 245, Arrays.asList("07926884433")));
        students.add(new Student("John", "Doe", 22, "Male", "Mathematics", "Manchester", 120, Arrays.asList("07926884434")));
        students.add(new Student("Jane", "Smith", 21, "Female", "Biology", "London", 55, Arrays.asList("07926884435")));
        students.add(new Student("Emily", "Clark", 24, "Female", "Physics", "Birmingham", 200, Arrays.asList("07926884436")));
        students.add(new Student("Michael", "Brown", 22, "Male", "Chemistry", "Leeds", 180, Arrays.asList("07926884437")));
        students.add(new Student("Sarah", "Davis", 23, "Female", "Computer Science", "London", 210, Arrays.asList("07926884438")));
        students.add(new Student("David", "Wilson", 24, "Male", "Mathematics", "London", 130, Arrays.asList("07926884439")));
        students.add(new Student("Laura", "Moore", 21, "Female", "Biology", "Liverpool", 60, Arrays.asList("07926884440")));
        students.add(new Student("Robert", "Taylor", 22, "Male", "Physics", "London", 175, Arrays.asList("07926884441")));
        students.add(new Student("Linda", "Anderson", 23, "Female", "Chemistry", "Manchester", 190, Arrays.asList("07926884442")));
        students.add(new Student("James", "Thomas", 24, "Male", "Computer Science", "Leeds", 220, Arrays.asList("07926884443")));
        students.add(new Student("Barbara", "Jackson", 21, "Female", "Biology", "London", 70, Arrays.asList("07926884444")));
        students.add(new Student("William", "White", 22, "Male", "Physics", "Birmingham", 160, Arrays.asList("07926884445")));
        students.add(new Student("Elizabeth", "Harris", 23, "Female", "Chemistry", "London", 185, Arrays.asList("07926884446")));
        students.add(new Student("Richard", "Martin", 24, "Male", "History", "Liverpool", 230, Arrays.asList("07926884447")));
        students.add(new Student("Susan", "Thompson", 21, "Female", "Biology", "Leeds", 80, Arrays.asList("07926884448")));
        students.add(new Student("Joseph", "Garcia", 22, "Male", "Mathematics", "London", 140, Arrays.asList("07926884449")));
        students.add(new Student("Jessica", "Martinez", 23, "Female", "Physics", "Manchester", 195, Arrays.asList("07926884450")));
        students.add(new Student("Thomas", "Robinson", 24, "Male", "Chemistry", "London", 175, Arrays.asList("07926884451")));
        students.add(new Student("Karen", "Clark", 21, "Female", "Computer Science", "Birmingham", 90, Arrays.asList("07926884452")));
        return students;
    }
}