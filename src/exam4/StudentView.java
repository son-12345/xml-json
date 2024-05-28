package exam4;

import java.sql.Date; // Add this import statement
import java.util.Scanner;

public class StudentView {
    private Scanner scanner = new Scanner(System.in);

    public Student getStudentDetails() {
        System.out.print("Enter ID: ");
        int ID = scanner.nextInt();
        scanner.nextLine();  // Consume newline

        System.out.print("Enter name: ");
        String name = scanner.nextLine();

        System.out.print("Enter address: ");
        String address = scanner.nextLine();

        System.out.print("Enter email: ");
        String email = scanner.nextLine();

        System.out.print("Enter phone: ");
        String phone = scanner.nextLine();

        System.out.print("Enter DOB (YYYY-MM-DD): ");
        String dobStr = scanner.nextLine();
        Date dob = Date.valueOf(dobStr);
        return new Student(ID, name, address, email, phone, dob);
    }

    public void displayJSON(String json) {
        System.out.println(json);
    }

    public String getSearchQuery(String field) {
        System.out.print("Enter " + field + " to search: ");
        return scanner.nextLine();
    }
}
