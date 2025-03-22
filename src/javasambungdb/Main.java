package javasambungdb;

import java.sql.SQLException;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        try {
            SambungOperations operations = new SambungOperations();
            Scanner scanner = new Scanner(System.in);
            int choice;

            do {
                System.out.println("\n--- Sam-Bung List Menu ---");
                System.out.println("1. Add Sam-Bung");
                System.out.println("2. View All Sam-Bungs");
                System.out.println("3. Update Sam-Bungs");
                System.out.println("4. Delete Sam-Bungs");
                System.out.println("5. Mark Sam-Bungs as Completed");
                System.out.println("0. Exit");
                System.out.print("Enter your choice: ");
                choice = scanner.nextInt();
                scanner.nextLine(); // Consume newline

                switch (choice) {
                    case 1:
                        System.out.print("Enter title: ");
                        String title = scanner.nextLine();
                        System.out.print("Enter description: ");
                        String description = scanner.nextLine();
                        operations.addSambung(new Sambung(title, description));
                        break;

                    case 2:
                        System.out.println("All Sam-Bung:");
                        operations.getSambungin().forEach(System.out::println);
                        break;

                    case 3:
                        System.out.print("Enter Sam-Bung ID to update: ");
                        int updateId = scanner.nextInt();
                        scanner.nextLine();
                        System.out.print("Enter new title: ");
                        String newTitle = scanner.nextLine();
                        System.out.print("Enter new description: ");
                        String newDescription = scanner.nextLine();
                        operations.updateSambung(updateId, newTitle, newDescription);
                        break;

                    case 4:
                        System.out.print("Enter Sam-Bung ID to delete: ");
                        int deleteId = scanner.nextInt();
                        operations.deleteSambung(deleteId);
                        break;

                    case 5:
                        System.out.print("Enter Sam-Bung ID to mark as completed: ");
                        int completeId = scanner.nextInt();
                        operations.markAsCompleted(completeId);
                        break;

                    case 0:
                        System.out.println("Exiting...");
                        break;

                    default:
                        System.out.println("Invalid choice! Please try again.");
                }
            } while (choice != 0);

            scanner.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
