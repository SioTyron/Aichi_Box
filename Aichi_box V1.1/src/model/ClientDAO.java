package model;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class ClientDAO {
    private Connection connection;

    public ClientDAO() {
        this.connection = ConnexionDAO.getConnexion();
    }

    public List<Client> getAllClients() {
        List<Client> clients = new ArrayList<>();
        String query = "SELECT * FROM clients";

        try (Statement stmt = connection.createStatement();
             ResultSet rs = stmt.executeQuery(query)) {

            while (rs.next()) {
                clients.add(new Client(
                        rs.getInt("ID"),
                        rs.getString("Nom"),
                        rs.getString("Adresse"),
                        rs.getString("Telephone"),
                        rs.getString("Email")
                ));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return clients;
    }

    public boolean addClient(String nom, String adresse, String telephone, String email) {
        String query = "INSERT INTO clients (Nom, Adresse, Telephone, Email) VALUES (?, ?, ?, ?)";

        try (PreparedStatement stmt = connection.prepareStatement(query)) {
            stmt.setString(1, nom);
            stmt.setString(2, adresse);
            stmt.setString(3, telephone);
            stmt.setString(4, email);
            stmt.executeUpdate();
            return true;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }

    public boolean updateClient(int id, String nom, String adresse, String telephone, String email) {
        String query = "UPDATE clients SET Nom = ?, Adresse = ?, Telephone = ?, Email = ? WHERE ID = ?";

        try (PreparedStatement stmt = connection.prepareStatement(query)) {
            stmt.setString(1, nom);
            stmt.setString(2, adresse);
            stmt.setString(3, telephone);
            stmt.setString(4, email);
            stmt.setInt(5, id);
            stmt.executeUpdate();
            return true;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }

    public boolean deleteClient(int id) {
        String query = "DELETE FROM clients WHERE ID = ?";

        try (PreparedStatement stmt = connection.prepareStatement(query)) {
            stmt.setInt(1, id);
            stmt.executeUpdate();
            return true;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }
}