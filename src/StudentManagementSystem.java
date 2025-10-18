import java.util.ArrayList;
import java.util.Scanner;

class Student {
    int id;
    String name;
    int age;
    double grade;

    public Student(int id, String name, int age, double grade) {
        this.id = id;
        this.name = name;
        this.age = age;
        this.grade = grade;
    }

    public void display() {
        System.out.println("ID: " + id + ", Name: " + name + 
                           ", Age: " + age + ", Grade: " + grade);
    }
}

public class StudentManagementSystem {

    static ArrayList<Student> students = new ArrayList<>();
    static Scanner sc = new Scanner(System.in);

    public static void main(String[] args) {
        int choice;
        do {
            System.out.println("\n--- Student Management System ---");
            System.out.println("1. Add Student");
            System.out.println("2. Display All Students");
            System.out.println("3. Search Student by ID");
            System.out.println("4. Delete Student by ID");
            System.out.println("5. Exit");
            System.out.print("Enter your choice: ");
            choice = sc.nextInt();

            switch(choice) {
                case 1: addStudent(); break;
                case 2: displayAllStudents(); break;
                case 3: searchStudent(); break;
                case 4: deleteStudent(); break;
                case 5: System.out.println("Exiting..."); break;
                default: System.out.println("Invalid choice!"); 
            }
        } while(choice != 5);
    }

  
    static void addStudent() {
        System.out.print("Enter Student ID: ");
        int id = sc.nextInt();
        sc.nextLine(); // consume newline
        System.out.print("Enter Name: ");
        String name = sc.nextLine();
        System.out.print("Enter Age: ");
        int age = sc.nextInt();
        System.out.print("Enter Grade: ");
        double grade = sc.nextDouble();

        Student s = new Student(id, name, age, grade);
        students.add(s);
        System.out.println("Student added successfully!");
    }

    
    static void displayAllStudents() {
        if(students.isEmpty()) {
            System.out.println("No students found.");
            return;
        }
        System.out.println("\n--- Student List ---");
        for(Student s : students) {
            s.display();
        }
    }

    // Search student by ID
    static void searchStudent() {
        System.out.print("Enter Student ID to search: ");
        int id = sc.nextInt();
        boolean found = false;
        for(Student s : students) {
            if(s.id == id) {
                System.out.println("Student Found:");
                s.display();
                found = true;
                break;
            }
        }
        if(!found) System.out.println("Student not found.");
    }

    static void deleteStudent() {
        System.out.print("Enter Student ID to delete: ");
        int id = sc.nextInt();
        boolean removed = students.removeIf(s -> s.id == id);
        if(removed) System.out.println("Student deleted successfully.");
        else System.out.println("Student not found.");
    }
}
