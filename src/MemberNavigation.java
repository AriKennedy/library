import java.sql.*;
import java.util.*;

public class MemberNavigation {

    public static void addMember(String name, String email) {
        String sql = "INSERT INTO members (name, email) VALUES (?, ?)";

        try (Connection conn = DataConnection.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setString(1, name);
            stmt.setString(2, email);
            stmt.executeUpdate();
            System.out.println("Member added successfully.");

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public static void listMembers() {
        String sql = "SELECT * FROM members";

        try (Connection conn = DataConnection.getConnection();
             Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery(sql)) {

            System.out.println("\n--- Member List ---");
            while (rs.next()) {
                System.out.println(rs.getInt("id") + ". " +
                        rs.getString("name") + " (" +
                        rs.getString("email") + ")");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public static void updateMember(int memberID, String newName, String newEmail) {
        String sql = "UPDATE members SET name = ?, email = ? WHERE id = ?";

        try (Connection conn = DataConnection.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setString(1, newName);
            stmt.setString(2, newEmail);
            stmt.setInt(3, memberID);
            int rowsUpdated = stmt.executeUpdate();

            if (rowsUpdated > 0) {
                System.out.println("Member updated successfully.");
            } else {
                System.out.println("Member not found.");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public static void deleteMember(int memberId) {
        String sql = "DELETE FROM members WHERE id = ?";

        try (Connection conn = DataConnection.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setInt(1, memberId);
            int rowsDeleted = stmt.executeUpdate();
            if (rowsDeleted > 0) {
                System.out.println("Member deleted successfully.");
            } else {
                System.out.println("Member not found.");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

}
