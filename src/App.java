import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import manager.StudentManager;
import models.Student;
import utils.MenuUtil;
import utils.Validator;

public class App {
    public static void main(String[] args) throws Exception {
        Scanner scanner = new Scanner(System.in);
        List<Student> students = new ArrayList<>();
        students.add(new Student("3120221377", "Hoang", 21, "Nam", "04/07/2003", "Huế", "21CNTT1", 3.00f));
        students.add(new Student("3120221377", "Anh", 21, "Nam", "04/07/2003", "Huế", "21CNTT1", 3.00f));
        students.add(new Student("3120221378", "Lan", 20, "Nữ", "15/05/2003", "Đà Nẵng", "21CNTT1", 3.50f));
        students.add(new Student("3120221379", "Mai", 22, "Nữ", "23/11/2002", "Hà Nội", "21CNTT2", 3.80f));
        students.add(new Student("3120221380", "Nam", 23, "Nam", "11/02/2001", "Hồ Chí Minh", "21CNTT2", 2.90f));
        students.add(new Student("3120221381", "Linh", 20, "Nữ", "01/12/2003", "Quảng Bình", "21CNTT1", 3.60f));
        students.add(new Student("3120221382", "Khoa", 24, "Nam", "14/09/1999", "Nha Trang", "21CNTT3", 3.20f));

        StudentManager studentManager = new StudentManager(students);
        int i;
        do {
            MenuUtil.printMenu();
            do {
                i = Validator.getInt(scanner, "Choice: ");
                if ((i < 1) || (i > 7)) {
                    System.out.println("Enter a number form 1 to 7.");
                }
            } while ((i < 1) || (i > 7));
            BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
            switch (i) {
                case 1 -> studentManager.addStudent();
                case 2 -> studentManager.displayStudents();
                case 3 -> studentManager.updateStudent(students, null);
                case 4 -> studentManager.removeStudent(students);
                case 5 -> {
                    System.out.print("Enter ID or Name for search: ");
                    String search = br.readLine().trim();
                    studentManager.searchStudentByIdOrName(search);
                }
                case 6 -> studentManager.shelfStudent();
                case 7 -> System.out.println("You are exit!");
            }
        } while (i != 7);
        scanner.close();
    }
}
