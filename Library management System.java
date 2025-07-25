import java.util.Scanner;

public class LibraryManagementSystem {
    static String[] titles = new String[100];
    static String[] authors = new String[100];
    static int[] ids = new int[100];
    static int count = 0;

    public static void addBook(Scanner sc) {
        if (count >= 100) {
            System.out.println("Library is full! Cannot add more books.");
            return;
        }

        System.out.print("Enter Book ID: ");
        int newId = sc.nextInt();
        sc.nextLine(); // consume newline

        // Check for duplicate ID
        for (int i = 0; i < count; i++) {
            if (ids[i] == newId) {
                System.out.println("Book ID already exists! Cannot add duplicate.\n");
                return;
            }
        }

        System.out.print("Enter Book Title: ");
        String title = sc.nextLine();

        System.out.print("Enter Author Name: ");
        String author = sc.nextLine();

        ids[count] = newId;
        titles[count] = title;
        authors[count] = author;
        count++;

        System.out.println("Book added successfully!\n");
    }

    public static void displayBooks() {
        if (count == 0) {
            System.out.println("No books in the library.\n");
            return;
        }

        System.out.println("\nLibrary Books:\n");
        for (int i = 0; i < count; i++) {
            System.out.println("Book ID: " + ids[i]);
            System.out.println("Title: " + titles[i]);
            System.out.println("Author: " + authors[i]);
            System.out.println("---------------------");
        }
    }

    public static void searchBook(Scanner sc) {
        System.out.print("Enter title to search: ");
        String searchTitle = sc.nextLine();

        boolean found = false;
        for (int i = 0; i < count; i++) {
            if (titles[i].equalsIgnoreCase(searchTitle)) {
                System.out.println("Book found:");
                System.out.println("Book ID: " + ids[i]);
                System.out.println("Title: " + titles[i]);
                System.out.println("Author: " + authors[i]);
                System.out.println("---------------------");
                found = true;
                break;
            }
        }

        if (!found) {
            System.out.println("Book not found.\n");
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int choice;

        do {
            System.out.println("==== Library Management System ====");
            System.out.println("1. Add Book");
            System.out.println("2. Display Books");
            System.out.println("3. Search Book by Title");
            System.out.println("4. Exit");
            System.out.print("Enter your choice: ");

            while (!sc.hasNextInt()) {
                System.out.println("Invalid input. Please enter a number.");
                sc.next(); // discard invalid input
                System.out.print("Enter your choice: ");
            }

            choice = sc.nextInt();
            sc.nextLine(); // consume newline

            switch (choice) {
                case 1:
                    addBook(sc);
                    break;
                case 2:
                    displayBooks();
                    break;
                case 3:
                    searchBook(sc);
                    break;
                case 4:
                    System.out.println("Exiting the system. Goodbye!");
                    break;
                default:
                    System.out.println("Invalid choice! Please try again.\n");
            }
        } while (choice != 4);

        sc.close();
    }
}