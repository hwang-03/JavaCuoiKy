package models;

import java.util.List;
import java.util.Scanner;
import utils.Validator;

public class Student {
    private String id;
    private String name;
    private int age;
    private String gender;
    private String dob;
    private String address;
    private String classGroup;
    private float GPA;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getDob() {
        return dob;
    }

    public void setDob(String dob) {
        this.dob = dob;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getClassGroup() {
        return classGroup;
    }

    public void setClassGroup(String classGroup) {
        this.classGroup = classGroup;
    }

    public float getGPA() {
        return GPA;
    }

    public void setGPA(float GPA) {
        this.GPA = GPA;
    }

    public Student() {
    }

    public Student(String id, String name, int age, String gender, String dob, String address, String classGroup,
            float GPA) {
        this.id = id;
        this.name = name;
        this.age = age;
        this.gender = gender;
        this.dob = dob;
        this.address = address;
        this.classGroup = classGroup;
        this.GPA = GPA;
    }

    @Override
    public String toString() {
        return "Student ID: " + id +
                ", Name: " + name +
                ", Age: " + age +
                ", Gender: " + gender +
                ", Date of Birth: " + dob +
                ", Address: " + address +
                ", Class: " + classGroup +
                ", GPA: " + GPA;
    }

    public void printStudent() {
        String st = "Student ID: " + id +
                ", Name: " + name +
                ", Age: " + age +
                ", Gender: " + gender +
                ", Date of Birth: " + dob +
                ", Address: " + address +
                ", Class: " + classGroup +
                ", GPA: " + GPA;
        System.out.println(st);
    }

    public void inputInformation(List<Student> students) {
        System.out.println("Enter Student Information!");
        Scanner scanner = new Scanner(System.in);
        boolean isValid;
        do {
            isValid = true;
            // System.out.print("Student ID");
            // this.id=scanner.next().trim();
            this.id = Validator.getString(scanner, "Student ID: ");
            for (Student itemStudent : students) {
                if (itemStudent.id.equalsIgnoreCase(this.id)) {
                    System.out.println("The ID is available");
                    isValid = false;
                    break;
                }
            }
        } while (!isValid);
        this.name = Validator.getString(scanner, "Name: ");
        this.age = Validator.getInt(scanner, "Age: ");
        scanner.nextLine();
        this.gender = Validator.getString(scanner, "Gender: ");
        this.dob = Validator.getString(scanner, "Dob: ");
        this.address = Validator.getString(scanner, "Address: ");
        this.classGroup = Validator.getString(scanner, "ClassGroup: ");
        this.GPA = Validator.getFloat(scanner, "GPA: ");
    }

    public void inputInformationUpdate(Scanner scanner) {
        setName(Validator.getString(scanner, "Enter new name: "));
        setAge(Validator.getInt(scanner, "Enter new age: "));
         scanner.nextLine();
        setGender(Validator.getString(scanner, "Enter new gender: "));
        setDob(Validator.getString(scanner, "Enter new date of birth (dd/mm/yyyy): "));
        setAddress(Validator.getString(scanner, "Enter new address: "));
        setClassGroup(Validator.getString(scanner, "Enter new class group: "));
        setGPA(Validator.getGPA(scanner, "Enter new GPA (must be between 0 and 4): "));
        System.out.println("Student information updated successfully!");
    }

}
