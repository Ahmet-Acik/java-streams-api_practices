package com.ahmet.services;
import com.ahmet.data.StudentRecord;
import com.ahmet.model.Student;


import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.*;

import static org.junit.jupiter.api.Assertions.*;

public class StudentServiceTest {

    private StudentService studentService;
    private List<Student> students;

    @BeforeEach
    public void setUp() {
        studentService = new StudentService();
        students = StudentRecord.getStudents();
    }

    @Test
    public void testFilterStudentsByDepartment() {
        List<Student> filtered = studentService.filterStudentsByDepartment(students, "Computer Science");
        assertEquals(4, filtered.size());
        assertTrue(filtered.stream().anyMatch(s -> "Ahmet".equals(s.getFirstName())));
    }

    @Test
    public void testCountStudentsByDepartment() {
        Map<String, Long> counts = studentService.countStudentsByDepartment(students);
        assertEquals(6, counts.size());
        assertEquals(4L, counts.get("Computer Science"));
    }

    @Test
    public void testGroupStudentsByDepartment() {
        Map<String, List<Student>> grouped = studentService.groupStudentsByDepartment(students);
        assertEquals(6, grouped.size());
        assertEquals(4, grouped.get("Computer Science").size());
    }

    @Test
    public void testGetAllStudentNames() {
        List<String> names = studentService.getAllStudentNames(students);
        assertTrue(names.contains("Ahmet"));
        assertEquals(20, names.size());
    }

    @Test
    public void testFindStudentWithHighestRank() {
        Optional<Student> student = studentService.findStudentWithHighestRank(students);
        assertTrue(student.isPresent());
        assertEquals(245, student.get().getRank());
    }

    @Test
    public void testSummarizeStudentAges() {
        IntSummaryStatistics stats = studentService.summarizeStudentAges(students);
        assertEquals(21, stats.getMin());
        assertEquals(24, stats.getMax());
        assertEquals(22.5, stats.getAverage(), 0.01);
    }

    @Test
    public void testPartitionStudentsByGender() {
        Map<Boolean, List<Student>> partitioned = studentService.partitionStudentsByGender(students);
        assertTrue(partitioned.containsKey(true));
        assertTrue(partitioned.containsKey(false));
        assertTrue(partitioned.get(true).stream().allMatch(s -> "Male".equals(s.getGender())));
    }

    @Test
    public void testGetSortedStudentNames() {
        List<String> sorted = studentService.getSortedStudentNames(students);
        assertEquals(20, sorted.size());
        assertEquals("Ahmet", sorted.get(0));
    }

    @Test
    public void testCountStudentsByCity() {
        Map<String, Long> counts = studentService.countStudentsByCity(students);
        assertTrue(counts.containsKey("London"));
        assertTrue(counts.values().stream().anyMatch(v -> v > 0));
    }

    @Test
    public void testGetUniqueStudents() {
        Set<Student> unique = studentService.getUniqueStudents(students);
        assertEquals(20, unique.size());
    }

    @Test
    public void testGetAllContactNumbers() {
        List<String> contacts = studentService.getAllContactNumbers(students);
        assertEquals(20, contacts.size());
        assertTrue(contacts.contains("07926884433"));
    }

    @Test
    public void testMapStudentNamesToAges() {
        Map<String, Integer> map = studentService.mapStudentNamesToAges(students);
        assertEquals(20, map.size());
        assertEquals(23, map.get("Ahmet"));
    }

    @Test
    public void testGroupStudentsByCityAndDepartment() {
        Map<String, Map<String, List<Student>>> grouped = studentService.groupStudentsByCityAndDepartment(students);
        assertTrue(grouped.containsKey("London"));
        assertTrue(grouped.get("London").containsKey("Computer Science") || grouped.get("London").size() > 0);
    }

    @Test
    public void testCalculateAverageAge() {
        double avg = studentService.calculateAverageAge(students);
        assertEquals(22.5, avg, 0.01);
    }

    @Test
    public void testMapStudentNamesToUppercase() {
        List<String> upper = studentService.mapStudentNamesToUppercase(students);
        assertTrue(upper.contains("AHMET"));
    }

    @Test
    public void testFindMinimumRank() {
        OptionalInt min = studentService.findMinimumRank(students);
        assertTrue(min.isPresent());
        assertEquals(55, min.getAsInt());
    }

    @Test
    public void testFindMaximumRank() {
        OptionalInt max = studentService.findMaximumRank(students);
        assertTrue(max.isPresent());
        assertEquals(245, max.getAsInt());
    }

    @Test
    public void testJoinStudentNames() {
        String joined = studentService.joinStudentNames(students);
        assertTrue(joined.contains("Ahmet"));
        assertTrue(joined.contains("John"));
    }

    @Test
    public void testAreAllStudentsAboveAge() {
        assertFalse(studentService.areAllStudentsAboveAge(students, 22));
        assertTrue(studentService.areAllStudentsAboveAge(students, 20));
    }

    @Test
    public void testIsAnyStudentFromCity() {
        assertTrue(studentService.isAnyStudentFromCity(students, "London"));
        assertFalse(studentService.isAnyStudentFromCity(students, "NonexistentCity"));
    }

    @Test
    public void testCountDistinctDepartments() {
        long count = studentService.countDistinctDepartments(students);
        assertEquals(6, count);
    }

    @Test
    public void testFindStudentsWithSpecificContact() {
        List<String> names = studentService.findStudentsWithSpecificContact(students, "07926884433");
        assertTrue(names.contains("Ahmet"));
    }

    @Test
    public void testGroupStudentsByRankRange() {
        Map<String, List<Student>> grouped = studentService.groupStudentsByRankRange(students);
        assertTrue(grouped.containsKey("1-100"));
        assertTrue(grouped.containsKey("101-500"));
    }

    @Test
    public void testFindFirstStudentFromCity() {
        Optional<Student> student = studentService.findFirstStudentFromCity(students, "London");
        assertTrue(student.isPresent());
        assertEquals("London", student.get().getCity());
    }

    @Test
    public void testCountDistinctDepartmentsByCity() {
        Map<String, Long> map = studentService.countDistinctDepartmentsByCity(students);
        assertTrue(map.containsKey("London"));
        assertTrue(map.get("London") > 0);
    }

    @Test
    public void testGetUniqueContactNumbers() {
        Set<String> contacts = studentService.getUniqueContactNumbers(students);
        assertTrue(contacts.contains("07926884433"));
        assertEquals(20, contacts.size());
    }

    @Test
    public void testMapStudentsToDescriptions() {
        List<String> desc = studentService.mapStudentsToDescriptions(students);
        assertTrue(desc.get(0).contains("from"));
        assertTrue(desc.get(0).contains("studying"));
    }

    @Test
    public void testFindYoungestStudent() {
        Optional<Student> student = studentService.findYoungestStudent(students);
        assertTrue(student.isPresent());
        assertEquals(21, student.get().getAge());
    }

    @Test
    public void testFindOldestStudent() {
        Optional<Student> student = studentService.findOldestStudent(students);
        assertTrue(student.isPresent());
        assertEquals(24, student.get().getAge());
    }

    @Test
    public void testCalculateTotalRank() {
        int total = studentService.calculateTotalRank(students);
        assertTrue(total > 0);
    }

    @Test
    public void testConcatenateAllContactNumbers() {
        String contacts = studentService.concatenateAllContactNumbers(students);
        assertTrue(contacts.contains("07926884433"));
    }

    @Test
    public void testIsNoStudentYoungerThan() {
        assertTrue(studentService.isNoStudentYoungerThan(students, 20));
        assertFalse(studentService.isNoStudentYoungerThan(students, 22));
    }

    @Test
    public void testSummarizeRanks() {
        IntSummaryStatistics stats = studentService.summarizeRanks(students);
        assertEquals(55, stats.getMin());
        assertEquals(245, stats.getMax());
    }

    @Test
    public void testGroupDepartmentsByAge() {
        Map<Integer, List<String>> grouped = studentService.groupDepartmentsByAge(students);
        assertTrue(grouped.containsKey(21));
        assertTrue(grouped.get(21).contains("Biology"));
    }

    @Test
    public void testMapStudentNamesToContactSize() {
        Map<String, Integer> map = studentService.mapStudentNamesToContactSize(students);
        assertEquals(1, map.get("Ahmet"));
    }

    @Test
    public void testSortStudentsByCity() {
        List<Student> sorted = studentService.sortStudentsByCity(students);
        assertEquals(20, sorted.size());
        assertTrue(sorted.get(0).getCity().compareTo(sorted.get(1).getCity()) <= 0);
    }

    @Test
    public void testDoAllStudentsHaveMultipleContacts() {
        assertFalse(studentService.doAllStudentsHaveMultipleContacts(students));
    }

    @Test
    public void testCountTotalContacts() {
        long count = studentService.countTotalContacts(students);
        assertEquals(20, count);
    }

    @Test
    public void testGroupStudentsByAgeRange() {
        Map<String, List<Student>> grouped = studentService.groupStudentsByAgeRange(students);
        assertTrue(grouped.containsKey("Under 22"));
        assertTrue(grouped.containsKey("22-24"));
    }

    @Test
    public void testCountStudentsWithSpecificAge() {
        long count = studentService.countStudentsWithSpecificAge(students, 23);
        assertTrue(count > 0);
    }

    @Test
    public void testMapDepartmentsToStudentNames() {
        Map<String, List<String>> map = studentService.mapDepartmentsToStudentNames(students);
        assertTrue(map.containsKey("Computer Science"));
        assertTrue(map.get("Computer Science").contains("Ahmet"));
    }

    @Test
    public void testFindLongestContactNumber() {
        Optional<String> contact = studentService.findLongestContactNumber(students);
        assertTrue(contact.isPresent());
        assertEquals(11, contact.get().length());
    }

    @Test
    public void testCalculateAverageAgeByGender() {
        Map<String, Double> avg = studentService.calculateAverageAgeByGender(students);
        assertTrue(avg.containsKey("Male"));
        assertTrue(avg.containsKey("Female"));
        assertEquals(22.9, avg.get("Male"), 0.1);
        assertEquals(22.1, avg.get("Female"), 0.1);
    }
}