import java.util.ArrayList;
import java.util.Scanner;

public class Main {

    static ArrayList<Student> students = new ArrayList<>();
    static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {

        while (true) {
            System.out.println("\n===== Student Management System =====");
            System.out.println("1. Add Student");
            System.out.println("2. View Students");
            System.out.println("3. Delete Student");
            System.out.println("4. Exit");

            System.out.print("Choose an option: ");
            int choice = scanner.nextInt();
            scanner.nextLine();

            switch (choice) {

                case 1:
                    addStudent();
                    break;

                case 2:
                    viewStudents();
                    break;

                case 3:
                    deleteStudent();
                    break;

                case 4:
                    System.out.println("Program closed.");
                    return;

                default:
                    System.out.println("Invalid option.");
            }
        }
    }

    static void addStudent() {

        System.out.print("Student ID: ");
        int id = scanner.nextInt();
        scanner.nextLine();

        System.out.print("Student Name: ");
        String name = scanner.nextLine();

        System.out.print("Department: ");
        String department = scanner.nextLine();

        students.add(new Student(id, name, department));

        System.out.println("Student added successfully.");
    }

    static void viewStudents() {

        if (students.isEmpty()) {
            System.out.println("No student found.");
            return;
        }

        for (Student student : students) {
            student.displayStudent();
        }
    }

    static void deleteStudent() {

        System.out.print("Enter Student ID: ");
        int id = scanner.nextInt();

        boolean removed = students.removeIf(
            student -> student.getId() == id
        );

        if (removed)
            System.out.println("Student deleted.");
        else
            System.out.println("Student not found.");
    }
}