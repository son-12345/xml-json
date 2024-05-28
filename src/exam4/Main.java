package exam4;
import java.util.Scanner;

//public class Main {
//    public static void main(String[] args) {
//        StudentDAO studentDAO = new StudentDAO();
//        StudentView studentView = new StudentView();
//        StudentController studentController = new StudentController(studentDAO, studentView);
//
//        studentController.writeDataToJSON();
//
//        Scanner scanner = new Scanner(System.in);
//        while (true) {
//            System.out.println("Choose an option:");
//            System.out.println("1. Add new student");
//            System.out.println("2. Display all students");
//            System.out.println("3. Search by name");
//            System.out.println("4. Search by email");
//            System.out.println("5. Exit");
//            System.out.println("Your choice: ");
//            int choice = scanner.nextInt();
//            scanner.nextLine();  // Consume newline
//
//            switch (choice) {
//                case 1:
//                    studentController.addStudent();
//                    break;
//                case 2:
//                    studentController.displayAllStudents();
//                    break;
//                case 3:
//                    studentController.searchByName();
//                    break;
//                case 4:
//                    studentController.searchByEmail();
//                    break;
//                case 5:
//                    System.out.println("Exiting.");
//                    scanner.close();
//                    return;
//                default:
//                    System.out.println("Invalid choice.");
//            }
//        }
//    }
//}
public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        StudentDAO studentDAO = new StudentDAO();
        StudentView studentView = new StudentView();
        StudentController studentController = new StudentController(studentDAO, studentView);

        boolean exit = false;
        while (!exit) {
            System.out.println("Menu:");
            System.out.println("1. Display all students");
            System.out.println("2. Add a new student");
            System.out.println("3. Search by name");
            System.out.println("4. Search by email");
            System.out.println("5. Exit");
            System.out.print("Enter your choice: ");
            int choice = scanner.nextInt();
            scanner.nextLine(); // Consume newline

            switch (choice) {
                case 1:
                    studentController.displayAllStudents();
                    break;
                case 2:
                    studentController.addStudent();
                    break;
                case 3:
                    studentController.searchByName();
                    break;
                case 4:
                    studentController.searchByEmail();
                    break;
                case 5:
                    exit = true;
                    break;
                default:
                    System.out.println("Invalid choice. Please enter a number between 1 and 5.");
            }
        }

        scanner.close();
        System.out.println("Exiting the program...");
    }
}
