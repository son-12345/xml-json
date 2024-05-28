package mockapi;

import java.util.Scanner;

public class MockApiExample {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.println("\nMenu:");
            System.out.println("1. GET");
            System.out.println("2. POST");
            System.out.println("3. PUT");
            System.out.println("4. DELETE");
            System.out.println("5. Exit");
            System.out.print("Choose an option: ");
            int choice = Integer.parseInt(scanner.nextLine());

            try {
                switch (choice) {
                    case 1:
                        GetMockApi.get();
                        break;
                    case 2:
                        PostMockApi.post(scanner);
                        break;
                    case 3:
                        PutMockApi.put(scanner);
                        break;
                    case 4:
                        DeleteMockApi.delete(scanner);
                        break;
                    case 5:
                        System.out.println("Exiting...");
                        scanner.close();
                        return;
                    default:
                        System.out.println("Invalid choice, please try again.");
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }
}
