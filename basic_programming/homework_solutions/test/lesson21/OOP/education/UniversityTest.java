package lesson21.OOP.education;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class UniversityTest {
    private University university;

    @BeforeEach
    void setUp() {
        university = new University("Test University", "123 University Street");
    }

    @Test
    void testAddFaculty() {
        university.addFaculty("Computer Science");
        university.displayFaculties();
        // Проверяем, что факультет был добавлен
        assertEquals(1, university.getFacultyCount());
    }

    @Test
    void testEnrollAndExpelStudent() {
        university.addFaculty("Computer Science");
        university.enrollStudent("John Doe", "Computer Science");
        assertEquals(1, university.getStudentCount());

        university.expelStudent("John Doe");
        assertEquals(0, university.getStudentCount());
    }

    @Test
    void testEnrollStudentToNonexistentFaculty() {
        university.enrollStudent("Jane Doe", "Nonexistent Faculty");
        assertEquals(0, university.getStudentCount());
    }

    @Test
    void testConductResearchProject() {
        university.conductResearchProject("Artificial Intelligence");
        // Тест может проверять вывод в консоль или другие эффекты этого метода
    }

    @Test
    void testEqualsMethod() {
        University anotherUniversity = new University("Test University", "123 University Street");
        assertEquals(university, anotherUniversity);

        anotherUniversity.addFaculty("Mathematics");
        assertNotEquals(university, anotherUniversity);
    }
}

