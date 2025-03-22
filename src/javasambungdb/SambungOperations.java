package javasambungdb;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class SambungOperations {
    private Connection connection;

    public SambungOperations() throws SQLException {
        connection = DatabaseConnection.getConnection();
    }

    // Create
    public void addSambung(Sambung sambung) {
        String query = "INSERT INTO todos (title, description) VALUES (?, ?)";
        try (PreparedStatement stmt = connection.prepareStatement(query)) {
            stmt.setString(1, sambung.getTitle());
            stmt.setString(2, sambung.getDescription());
            stmt.executeUpdate();
            System.out.println("Sam-Bung added successfully!");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    // Read
    public List<Sambung> getSambungin() {
        List<Sambung> sambungin = new ArrayList<>();
        String query = "SELECT * FROM sambungin";
        try (Statement stmt = connection.createStatement();
             ResultSet rs = stmt.executeQuery(query)) {

            while (rs.next()) {
                sambungin.add(new Sambung(
                        rs.getInt("id"),
                        rs.getString("title"),
                        rs.getString("description"),
                        rs.getBoolean("is_completed"),
                        rs.getString("created_at")
                ));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return sambungin;
    }

    // Update
    public void updateSambung(int id, String newTitle, String newDescription) {
        String query = "UPDATE todos SET title = ?, description = ? WHERE id = ?";
        try (PreparedStatement stmt = connection.prepareStatement(query)) {
            stmt.setString(1, newTitle);
            stmt.setString(2, newDescription);
            stmt.setInt(3, id);
            stmt.executeUpdate();
            System.out.println("Sam-Bung updated successfully!");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    // Delete
    public void deleteSambung(int id) {
        String query = "DELETE FROM todos WHERE id = ?";
        try (PreparedStatement stmt = connection.prepareStatement(query)) {
            stmt.setInt(1, id);
            stmt.executeUpdate();
            System.out.println("Sam-Bung deleted successfully!");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    // Mark as Completed
    public void markAsCompleted(int id) {
        String query = "UPDATE todos SET is_completed = TRUE WHERE id = ?";
        try (PreparedStatement stmt = connection.prepareStatement(query)) {
            stmt.setInt(1, id);
            stmt.executeUpdate();
            System.out.println("Sam-Bung marked as completed!");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    Object getSambung() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}
