package com.ahmet.services;

import com.ahmet.model.Student;

import java.util.*;
import java.util.stream.*;

public class StudentService {

    public List<Student> filterStudentsByDepartment(List<Student> students, String department) {
        return students.stream()
                .filter(s -> s.getDepartment().equals(department))
                .collect(Collectors.toList());
    }

    public Map<String, Long> countStudentsByDepartment(List<Student> students) {
        return students.stream()
                .collect(Collectors.groupingBy(Student::getDepartment, Collectors.counting()));
    }

    public Map<String, List<Student>> groupStudentsByDepartment(List<Student> students) {
        return students.stream()
                .collect(Collectors.groupingBy(Student::getDepartment));
    }

    public List<String> getAllStudentNames(List<Student> students) {
        return students.stream()
                .map(Student::getFirstName)
                .collect(Collectors.toList());
    }

    public Optional<Student> findStudentWithHighestRank(List<Student> students) {
        return students.stream().max(Comparator.comparingInt(Student::getRank));
    }

    public IntSummaryStatistics summarizeStudentAges(List<Student> students) {
        return students.stream().mapToInt(Student::getAge).summaryStatistics();
    }

    public Map<Boolean, List<Student>> partitionStudentsByGender(List<Student> students) {
        return students.stream()
                .collect(Collectors.partitioningBy(s -> "Male".equals(s.getGender())));
    }

    public List<String> getSortedStudentNames(List<Student> students) {
        return students.stream()
                .map(Student::getFirstName)
                .sorted()
                .collect(Collectors.toList());
    }

    public Map<String, Long> countStudentsByCity(List<Student> students) {
        return students.stream()
                .collect(Collectors.groupingBy(Student::getCity, Collectors.counting()));
    }

    public Set<Student> getUniqueStudents(List<Student> students) {
        return new HashSet<>(students);
    }

    public List<String> getAllContactNumbers(List<Student> students) {
        return students.stream()
                .flatMap(s -> s.getContactNumbers().stream())
                .collect(Collectors.toList());
    }

    public Map<String, Integer> mapStudentNamesToAges(List<Student> students) {
        return students.stream()
                .collect(Collectors.toMap(Student::getFirstName, Student::getAge, (a, b) -> a));
    }

    public Map<String, Map<String, List<Student>>> groupStudentsByCityAndDepartment(List<Student> students) {
        return students.stream()
                .collect(Collectors.groupingBy(Student::getCity,
                        Collectors.groupingBy(Student::getDepartment)));
    }

    public double calculateAverageAge(List<Student> students) {
        return students.stream().mapToInt(Student::getAge).average().orElse(0);
    }

    public List<String> mapStudentNamesToUppercase(List<Student> students) {
        return students.stream()
                .map(s -> s.getFirstName().toUpperCase())
                .collect(Collectors.toList());
    }

    public OptionalInt findMinimumRank(List<Student> students) {
        return students.stream().mapToInt(Student::getRank).min();
    }

    public OptionalInt findMaximumRank(List<Student> students) {
        return students.stream().mapToInt(Student::getRank).max();
    }

    public String joinStudentNames(List<Student> students) {
        return students.stream()
                .map(Student::getFirstName)
                .collect(Collectors.joining(", "));
    }

    public boolean areAllStudentsAboveAge(List<Student> students, int age) {
        return students.stream().allMatch(s -> s.getAge() > age);
    }

    public boolean isAnyStudentFromCity(List<Student> students, String city) {
        return students.stream().anyMatch(s -> s.getCity().equals(city));
    }

    public long countDistinctDepartments(List<Student> students) {
        return students.stream().map(Student::getDepartment).distinct().count();
    }

    public List<String> findStudentsWithSpecificContact(List<Student> students, String contact) {
        return students.stream()
                .filter(s -> s.getContactNumbers().contains(contact))
                .map(Student::getFirstName)
                .collect(Collectors.toList());
    }

    public Map<String, List<Student>> groupStudentsByRankRange(List<Student> students) {
        return students.stream().collect(Collectors.groupingBy(s -> {
            if (s.getRank() <= 100)
                return "1-100";
            else if (s.getRank() <= 500)
                return "101-500";
            else
                return "501+";
        }));
    }

    public Optional<Student> findFirstStudentFromCity(List<Student> students, String city) {
        return students.stream().filter(s -> s.getCity().equals(city)).findFirst();
    }

    public Map<String, Long> countDistinctDepartmentsByCity(List<Student> students) {
        return students.stream()
                .collect(Collectors.groupingBy(Student::getCity,
                        Collectors.mapping(Student::getDepartment,
                                Collectors.collectingAndThen(Collectors.toSet(), Set::size))))
                .entrySet().stream()
                .collect(Collectors.toMap(Map.Entry::getKey, e -> (long) e.getValue()));
    }

    public Set<String> getUniqueContactNumbers(List<Student> students) {
        return students.stream()
                .flatMap(s -> s.getContactNumbers().stream())
                .collect(Collectors.toSet());
    }

    public List<String> mapStudentsToDescriptions(List<Student> students) {
        return students.stream()
                .map(s -> s.getFirstName() + " from " + s.getCity() + " studying " + s.getDepartment())
                .collect(Collectors.toList());
    }

    public Optional<Student> findYoungestStudent(List<Student> students) {
        return students.stream().min(Comparator.comparingInt(Student::getAge));
    }

    public Optional<Student> findOldestStudent(List<Student> students) {
        return students.stream().max(Comparator.comparingInt(Student::getAge));
    }

    public int calculateTotalRank(List<Student> students) {
        return students.stream().mapToInt(Student::getRank).sum();
    }

    public String concatenateAllContactNumbers(List<Student> students) {
        return students.stream()
                .flatMap(s -> s.getContactNumbers().stream())
                .collect(Collectors.joining(","));
    }

    public boolean isNoStudentYoungerThan(List<Student> students, int age) {
        return students.stream().noneMatch(s -> s.getAge() < age);
    }

    public IntSummaryStatistics summarizeRanks(List<Student> students) {
        return students.stream().mapToInt(Student::getRank).summaryStatistics();
    }

    public Map<Integer, List<String>> groupDepartmentsByAge(List<Student> students) {
        return students.stream()
                .collect(Collectors.groupingBy(Student::getAge,
                        Collectors.mapping(Student::getDepartment, Collectors.toList())));
    }

    public Map<String, Integer> mapStudentNamesToContactSize(List<Student> students) {
        return students.stream()
                .collect(Collectors.toMap(Student::getFirstName, s -> s.getContactNumbers().size(), (a, b) -> a));
    }

    public List<Student> sortStudentsByCity(List<Student> students) {
        return students.stream()
                .sorted(Comparator.comparing(Student::getCity))
                .collect(Collectors.toList());
    }

    public boolean doAllStudentsHaveMultipleContacts(List<Student> students) {
        return students.stream().allMatch(s -> s.getContactNumbers().size() > 1);
    }

    public long countTotalContacts(List<Student> students) {
        return students.stream().flatMap(s -> s.getContactNumbers().stream()).count();
    }

    public Map<String, List<Student>> groupStudentsByAgeRange(List<Student> students) {
        return students.stream().collect(Collectors.groupingBy(s -> {
            if (s.getAge() < 22)
                return "Under 22";
            else if (s.getAge() <= 24)
                return "22-24";
            else
                return "25+";
        }));
    }

    public long countStudentsWithSpecificAge(List<Student> students, int age) {
        return students.stream().filter(s -> s.getAge() == age).count();
    }

    public Map<String, List<String>> mapDepartmentsToStudentNames(List<Student> students) {
        return students.stream()
                .collect(Collectors.groupingBy(Student::getDepartment,
                        Collectors.mapping(Student::getFirstName, Collectors.toList())));
    }

    public Optional<String> findLongestContactNumber(List<Student> students) {
        return students.stream()
                .flatMap(s -> s.getContactNumbers().stream())
                .max(Comparator.comparingInt(String::length));
    }

    public Map<String, Double> calculateAverageAgeByGender(List<Student> students) {
        return students.stream()
                .collect(Collectors.groupingBy(Student::getGender,
                        Collectors.averagingInt(Student::getAge)));
    }

    public Map<String, List<Student>> groupStudentsByGenderAndCity(List<Student> students) {
        return students.stream()
                .collect(Collectors.groupingBy(s -> s.getGender() + " - " + s.getCity()));
    }

    public List<Student> filterStudentsByCityAndRank(List<Student> students, String city, int minRank) {
        return students.stream()
                .filter(s -> s.getCity().equals(city) && s.getRank() >= minRank)
                .collect(Collectors.toList());
    }

    public Map<String, Long> countStudentsByGenderAndCity(List<Student> students) {
        return students.stream()
                .collect(Collectors.groupingBy(s -> s.getGender() + " - " + s.getCity(), Collectors.counting()));
    }

    public Map<String, List<Student>> groupStudentsByCityAndRank(List<Student> students) {
        return students.stream()
                .collect(Collectors.groupingBy(
                        Student::getCity,
                        Collectors.toList()));
    }

    public Map<String, List<Student>> groupStudentsByDepartmentAndCity(List<Student> students) {
        return students.stream()
                .collect(Collectors.groupingBy(s -> s.getDepartment() + " - " + s.getCity()));
    }

    public Map<String, Long> countStudentsByCityAndDepartment(List<Student> students) {
        return students.stream()
                .collect(Collectors.groupingBy(s -> s.getCity() + " - " + s.getDepartment(), Collectors.counting()));
    }

    public Map<String, List<Student>> groupStudentsByAgeAndGender(List<Student> students) {
        return students.stream()
                .collect(Collectors.groupingBy(s -> s.getAge() + " - " + s.getGender()));
    }

    public Map<String, List<Student>> groupStudentsByCityAndGender(List<Student> students) {
        return students.stream()
                .collect(Collectors.groupingBy(s -> s.getCity() + " - " + s.getGender()));
    }

    public Map<String, List<Student>> groupStudentsByDepartmentAndGender(List<Student> students) {
        return students.stream()
                .collect(Collectors.groupingBy(s -> s.getDepartment() + " - " + s.getGender()));
    }

    public Map<String, List<Student>> groupStudentsByRankAndCity(List<Student> students) {
        return students.stream()
                .collect(Collectors.groupingBy(
                        s -> s.getRank() <= 100 ? "1-100" : s.getRank() <= 500 ? "101-500" : "501+ - " + s.getCity()));
    }

    public Map<String, List<Student>> groupStudentsByRankAndDepartment(List<Student> students) {
        return students.stream()
                .collect(Collectors.groupingBy(s -> s.getRank() <= 100 ? "1-100"
                        : s.getRank() <= 500 ? "101-500" : "501+ - " + s.getDepartment()));
    }

    public Map<String, List<Student>> groupStudentsByCityAndAge(List<Student> students) {
        return students.stream()
                .collect(Collectors.groupingBy(s -> s.getCity() + " - "
                        + (s.getAge() < 22 ? "Under 22" : s.getAge() <= 24 ? "22-24" : "25+")));
    }

    public Map<String, List<Student>> groupStudentsByGenderAndRank(List<Student> students) {
        return students.stream()
                .collect(Collectors.groupingBy(s -> s.getGender() + " - "
                        + (s.getRank() <= 100 ? "1-100" : s.getRank() <= 500 ? "101-500" : "501+")));
    }

    public Map<String, List<Student>> groupStudentsByCityAndAgeRange(List<Student> students) {
        return students.stream()
                .collect(Collectors.groupingBy(s -> s.getCity() + " - "
                        + (s.getAge() < 22 ? "Under 22" : s.getAge() <= 24 ? "22-24" : "25+")));
    }

    public Map<String, List<Student>> groupStudentsByDepartmentAndAge(List<Student> students) {
        return students.stream()
                .collect(Collectors.groupingBy(s -> s.getDepartment() + " - "
                        + (s.getAge() < 22 ? "Under 22" : s.getAge() <= 24 ? "22-24" : "25+")));
    }

    public Map<String, List<Student>> groupStudentsByGenderAndAge(List<Student> students) {
        return students.stream()
                .collect(Collectors.groupingBy(s -> s.getGender() + " - "
                        + (s.getAge() < 22 ? "Under 22" : s.getAge() <= 24 ? "22-24" : "25+")));
    }

    public Map<String, List<Student>> groupStudentsByCityAndGenderAndRank(List<Student> students) {
        return students.stream()
                .collect(Collectors.groupingBy(s -> s.getCity() + " - " + s.getGender() + " - "
                        + (s.getRank() <= 100 ? "1-100" : s.getRank() <= 500 ? "101-500" : "501+")));
    }

    public Map<String, List<Student>> groupStudentsByDepartmentAndGenderAndCity(List<Student> students) {
        return students.stream()
                .collect(Collectors.groupingBy(s -> s.getDepartment() + " - " + s.getGender() + " - " + s.getCity()));
    }

    public Map<String, List<Student>> groupStudentsByCityAndDepartmentAndRank(List<Student> students) {
        return students.stream()
                .collect(Collectors.groupingBy(s -> s.getCity() + " - " + s.getDepartment() + " - "
                        + (s.getRank() <= 100 ? "1-100" : s.getRank() <= 500 ? "101-500" : "501+")));
    }

    public Map<String, List<Student>> groupStudentsByCityAndDepartmentAndAge(List<Student> students) {
        return students.stream()
                .collect(Collectors.groupingBy(s -> s.getCity() + " - " + s.getDepartment() + " - "
                        + (s.getAge() < 22 ? "Under 22" : s.getAge() <= 24 ? "22-24" : "25+")));
    }

    public Map<String, List<Student>> groupStudentsByCityAndGenderAndAge(List<Student> students) {
        return students.stream()
                .collect(Collectors.groupingBy(s -> s.getCity() + " - " + s.getGender() + " - "
                        + (s.getAge() < 22 ? "Under 22" : s.getAge() <= 24 ? "22-24" : "25+")));
    }

    public Map<String, List<Student>> groupStudentsByDepartmentAndGenderAndRank(List<Student> students) {
        return students.stream()
                .collect(Collectors.groupingBy(s -> s.getDepartment() + " - " + s.getGender() + " - "
                        + (s.getRank() <= 100 ? "1-100" : s.getRank() <= 500 ? "101-500" : "501+")));
    }

    public Map<String, List<Student>> groupStudentsByDepartmentAndCityAndRank(List<Student> students) {
        return students.stream()
                .collect(Collectors.groupingBy(s -> s.getDepartment() + " - " + s.getCity() + " - "
                        + (s.getRank() <= 100 ? "1-100" : s.getRank() <= 500 ? "101-500" : "501+")));
    }

    public Map<String, List<Student>> groupStudentsByCityAndRankAndAge(List<Student> students) {
        return students.stream()
                .collect(Collectors.groupingBy(s -> s.getCity() + " - "
                        + (s.getRank() <= 100 ? "1-100" : s.getRank() <= 500 ? "101-500" : "501+") + " - "
                        + (s.getAge() < 22 ? "Under 22" : s.getAge() <= 24 ? "22-24" : "25+")));
    }
}