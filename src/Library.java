import java.util.*;

public class Library {
    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        while (true) {
            System.out.println("\nLibrary Inventory System");
            System.out.println("1. Add Book");
            System.out.println("2. List Books");
            System.out.println("3. Edit Books");
            System.out.println("4. Delete Book");
            System.out.println("5. Add Member");
            System.out.println("6. List Members");
            System.out.println("7. Update Members");
            System.out.println("8. Delete Member");
            System.out.println("9. Exit");
            System.out.print("Choose an option: ");

            int choice = scanner.nextInt();
            scanner.nextLine(); // Consume newline

            switch (choice) {
                case 1:
                    System.out.print("Enter book title: ");
                    String title = scanner.nextLine();
                    System.out.print("Enter author: ");
                    String author = scanner.nextLine();
                    System.out.print("Enter published year: ");
                    int year = scanner.nextInt();
                    BookNavigation.addBook(title, author, year);
                    break;
                case 2:
                    BookNavigation.listBooks();
                    break;
                case 3:
                    System.out.print("Enter Book ID to update: ");
                    int bookID = scanner.nextInt();
                    scanner.nextLine();
                    System.out.print("Enter new book title: ");
                    String newTitle = scanner.nextLine();
                    System.out.print("Enter new author: ");
                    String newAuthor = scanner.nextLine();
                    System.out.print("Enter updated published year: ");
                    int newYear = scanner.nextInt();
                    BookNavigation.updateBook(bookID, newTitle, newAuthor, newYear);
                    break;
                case 4:
                    System.out.print("Enter book ID to delete: ");
                    int bookId = scanner.nextInt();
                    BookNavigation.deleteBook(bookId);
                    break;
                case 5:
                    System.out.print("Enter member name: ");
                    String name = scanner.nextLine();
                    System.out.print("Enter member email: ");
                    String email = scanner.nextLine();
                    MemberNavigation.addMember(name, email);
                    break;
                case 6:
                    MemberNavigation.listMembers();
                    break;
                case 7:
                    System.out.print("Enter member ID to update: ");
                    int memberID = scanner.nextInt();
                    scanner.nextLine();
                    System.out.print("Enter new member name: ");
                    String newName = scanner.nextLine();
                    System.out.print("Enter new member email: ");
                    String newEmail = scanner.nextLine();
                    MemberNavigation.updateMember(memberID, newName, newEmail);
                    break;
                case 8:
                    System.out.print("Enter member ID to delete: ");
                    int memberId = scanner.nextInt();
                    MemberNavigation.deleteMember(memberId);
                    break;
                case 9:
                    System.out.println("Exiting...");
                    return;
                default:
                    System.out.println("Invalid option. Please try again.");
            }
        }
    }
}
