package manager;

import java.util.List;
import java.util.Scanner;
import models.Student;
import java.util.ArrayList;
import java.util.Comparator;

public class StudentManager {
    private List<Student> students;

    public StudentManager() {
    }

    public StudentManager(List<Student> students) {
        this.students = students;
    }

    // Tìm kiếm
    public void searchStudentByIdOrName(String search) {
        search = search.toLowerCase();
        int d = 0;
        for (Student student : students) {
            String id = student.getId().toLowerCase();
            String name = student.getName().toLowerCase();
            if ((id.contains(search)) || (name.contains(search))) {
                student.printStudent();
                d++;
            }
        }
        if (d == 0) {
            System.out.println("No Matching result was found");
        } else {
            System.out.printf("There are %d results were found\n", d);
        }
    }

    // thêm sinh viên
    public void addStudent() {
        Student st = new Student();
        st.inputInformation(students);
        students.add(st);
    }

    // Cập nhật sinh viên
    public void updateStudent(List<Student> students, Student studentToUpdate) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter Student ID to update: ");
        String searchUpdateString = scanner.nextLine().trim();
        for (Student s : students) {
            if (s.getId().equalsIgnoreCase(searchUpdateString) || s.getName().equalsIgnoreCase(searchUpdateString)) {
                studentToUpdate = s;
                studentToUpdate.printStudent();
                break;
            }
        }
        if (studentToUpdate == null) {
            System.out.println("Student with ID " + searchUpdateString + " not found.");
            return;
        }
        studentToUpdate.inputInformationUpdate(scanner);
        scanner.close();
    }

    // Hiển thị sinh viên
    public void displayStudents() {
        if (students.isEmpty()) {
            System.out.println("No students available.");
        } else {
            System.out.println("List of all students:");
            for (Student student : students) {
                student.printStudent();
            }
        }
    }

    // Xoá sinh viên
    public void removeStudent(List<Student> students) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter Student ID to delete: ");
        String id = scanner.nextLine().trim();
        Student studentToRemove = null;
        for (Student s : students) {
            if (s.getId().equals(id)) {
                studentToRemove = s;
                studentToRemove.printStudent();
                break;
            }
        }
        if (studentToRemove == null) {
            System.out.println("Student with ID " + id + " not found.");
            return;
        }
        students.remove(studentToRemove);
        System.out.println("Student with ID " + id + " has been successfully removed.");
        scanner.close();
    }

    public void shelfStudent() {
        List<Student> listsStudents = new ArrayList<>(students);
        listsStudents.sort(Comparator.comparing(Student::getGPA, Comparator.reverseOrder())
                .thenComparing(Student::getName));

        int[] gpaCount = new int[5];
        
        System.out.println("List of students sorted by GPA (high to low) and name (A to Z):");
        for (Student student : listsStudents) {

            String studentInfo = String.format("ID: %-10s | Name: %-20s | Class: %-10s | GPA: %.2f",
                    student.getId(), student.getName(), student.getClassGroup(), student.getGPA());
            System.out.println(studentInfo);

            gpaCount[getGPACategory(student.getGPA())]++;
        }

        System.out.println("\nStudent GPA classification:");
        System.out.println("Undergraduate (GPA < 2): " + gpaCount[0]);
        System.out.println("Average (GPA < 2.5): " + gpaCount[1]);
        System.out.println("Good (GPA < 3.2): " + gpaCount[2]);
        System.out.println("Excellent (GPA < 3.6): " + gpaCount[3]);
        System.out.println("Outstanding (GPA >= 3.6): " + gpaCount[4]);
    }

    private int getGPACategory(float gpa) {
        if (gpa < 2)
            return 0;
        if (gpa < 2.5)
            return 1;
        if (gpa < 3.2)
            return 2;
        if (gpa < 3.6)
            return 3;
        return 4;
    }
}
