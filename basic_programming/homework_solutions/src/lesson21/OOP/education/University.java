package lesson21.OOP.education;

import java.util.Arrays;
import java.util.Objects;

// Класс Университет, расширяющий EducationalInstitution и реализующий CommunityEngagement
public class University extends EducationalInstitution implements CommunityEngagement {
    private String name;
    private String address;
    private String[] faculties;
    private int facultyCount;
    private String[] students;
    private int studentCount;

    public University(String name, String address) {
        this.name = name;
        this.address = address;
        this.faculties = new String[0]; // Начальный размер массива факультетов равен 0
        this.facultyCount = 0;
        this.students = new String[0]; // Начальный размер массива студентов равен 0
        this.studentCount = 0;
    }

    // Геттеры и сеттеры
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public int getFacultyCount() {
        return facultyCount;
    }

    public int getStudentCount() {
        return studentCount;
    }

    // Методы из EducationalInstitution

    @Override
    public void addFaculty(String faculty) {
        faculties = Arrays.copyOf(faculties, facultyCount + 1);
        faculties[facultyCount++] = faculty;
    }

    @Override
    public void enrollStudent(String student, String faculty) {
        if (Arrays.asList(faculties).contains(faculty)) {
            students = Arrays.copyOf(students, studentCount + 1);
            students[studentCount++] = student;
        } else {
            System.out.println("Факультет \"" + faculty + "\" не найден.");
        }
    }

    @Override
    public void expelStudent(String student) {
        for (int i = 0; i < studentCount; i++) {
            if (students[i] != null && students[i].equals(student)) {
                System.arraycopy(students, i + 1, students, i, studentCount - i - 1);
                students = Arrays.copyOf(students, studentCount - 1);
                studentCount--;
                return;
            }
        }
        System.out.println("Студент \"" + student + "\" не найден.");
    }

    @Override
    public void displayFaculties() {
        System.out.println("Факультеты университета " + name + ": " +
                String.join(", ", Arrays.copyOf(faculties, facultyCount)));
    }

    // Метод из CommunityEngagement
    @Override
    public void conductResearchProject(String researchTopic) {
        System.out.println("Проводится исследовательский проект на тему: " + researchTopic);
    }

    // Переопределение метода equals
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof University)) return false;
        University that = (University) o;
        return Objects.equals(name, that.name) &&
                Objects.equals(address, that.address) &&
                Arrays.equals(faculties, that.faculties) && // Используем Arrays.equals для сравнения массивов
                Arrays.equals(students, that.students);
    }
}
