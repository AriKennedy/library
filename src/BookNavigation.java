import java.sql.*;
import java.util.*;

public class BookNavigation {

    public static void addBook(String title, String author, int year) {
        String sql = "INSERT INTO books (title, author, published_year) VALUES (?, ?, ?)";

        try (Connection conn = DataConnection.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setString(1, title);
            stmt.setString(2, author);
            stmt.setInt(3, year);
            stmt.executeUpdate();
            System.out.println("Book added successfully.");

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public static void listBooks() {
        String sql = "SELECT * FROM books";

        try (Connection conn = DataConnection.getConnection();
             Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery(sql)) {

            System.out.println("\n--- Book List ---");
            while (rs.next()) {
                System.out.println(rs.getInt("id") + ". " +
                        rs.getString("title") + " by " +
                        rs.getString("author") + " (" +
                        rs.getInt("published_year") + ")");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public static void updateBook(int bookID, String newTitle, String newAuthor, int newYear) {
        String sql = "UPDATE Books SET title = ?, author = ?, published_year = ? WHERE id = ?";

        try {
            Connection conn = DataConnection.getConnection();
            PreparedStatement stmt = conn.prepareStatement(sql);

            stmt.setString(1, newTitle);
            stmt.setString(2, newAuthor);
            stmt.setInt(3, newYear);
            stmt.setInt(4, bookID);
            int rowsUpdated = stmt.executeUpdate();

            if (rowsUpdated > 0) {
                System.out.println("Book updated successfully.");
            } else {
                System.out.println("Book not found.");
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public static void deleteBook(int bookId) {
        String sql = "DELETE FROM books WHERE id = ?";

        try (Connection conn = DataConnection.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setInt(1, bookId);
            int rowsDeleted = stmt.executeUpdate();
            if (rowsDeleted > 0) {
                System.out.println("Book deleted successfully.");
            } else {
                System.out.println("Book not found.");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

}
