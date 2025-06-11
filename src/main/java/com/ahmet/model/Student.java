package com.ahmet.model;

import java.util.List;
import java.util.Objects;

public class Student {
    private String firstName;
    private String lastName;
    private int age;
    private String gender;
    private String department;
    private String city;
    private int rank;
    private List<String> contactNumbers;

    public Student(String firstName, String lastName, int age, String gender, String department, String city, int rank, List<String> contactNumbers) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.age = age;
        this.gender = gender;
        this.department = department;
        this.city = city;
        this.rank = rank;
        this.contactNumbers = contactNumbers;
    }

    public String getFirstName() { return firstName; }
    public String getLastName() { return lastName; }
    public int getAge() { return age; }
    public String getGender() { return gender; }
    public String getDepartment() { return department; }
    public String getCity() { return city; }
    public int getRank() { return rank; }
    public List<String> getContactNumbers() { return contactNumbers; }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Student)) return false;
        Student student = (Student) o;
        return Objects.equals(firstName, student.firstName) &&
               Objects.equals(lastName, student.lastName) &&
               age == student.age &&
               Objects.equals(gender, student.gender) &&
               Objects.equals(department, student.department) &&
               Objects.equals(city, student.city) &&
               rank == student.rank &&
               Objects.equals(contactNumbers, student.contactNumbers);
    }

    @Override
    public int hashCode() {
        return Objects.hash(firstName, lastName, age, gender, department, city, rank, contactNumbers);
    }
}