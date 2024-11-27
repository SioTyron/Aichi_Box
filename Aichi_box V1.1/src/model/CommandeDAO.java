package model;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class CommandeDAO {
    private Connection connection;

    public CommandeDAO() {
        this.connection = ConnexionDAO.getConnexion();
    }

    // Méthode pour récupérer toutes les commandes
    public List<Commande> getAllCommandes() {
        List<Commande> commandes = new ArrayList<>();
        String query = "SELECT * FROM commandes";

        try (Statement stmt = connection.createStatement();
             ResultSet rs = stmt.executeQuery(query)) {

            while (rs.next()) {
                commandes.add(new Commande(
                        rs.getInt("ID"),
                        rs.getInt("ID_Utilisateur"),
                        rs.getInt("ID_Client"),
                        rs.getDate("Date"),
                        rs.getString("Statut")
                ));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return commandes;
    }

    // Méthode pour ajouter une commande
    public boolean addCommande(int idUtilisateur, int idClient, Date date, int quantity) {
        String query = "INSERT INTO commandes (ID_Utilisateur, ID_Client, Date, Statut) VALUES (?, ?, ?, ?)";

        try (PreparedStatement stmt = connection.prepareStatement(query)) {
            stmt.setInt(1, idUtilisateur);
            stmt.setInt(2, idClient);
            stmt.setDate(3, new java.sql.Date(date.getTime()));
            stmt.setInt(4, quantity);
            stmt.executeUpdate();
            return true; // Retourne true si l'ajout a réussi
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false; // Retourne false en cas d'erreur
    }

    // Méthode pour mettre à jour une commande
    public boolean updateCommande(int id, int idUtilisateur, int idClient, Date date, int newQuantity) {
        String query = "UPDATE commandes SET ID_Utilisateur = ?, ID_Client = ?, Date = ?, Statut = ? WHERE ID = ?";

        try (PreparedStatement stmt = connection.prepareStatement(query)) {
            stmt.setInt(1, idUtilisateur);
            stmt.setInt(2, idClient);
            stmt.setDate(3, new java.sql.Date(date.getTime()));
            stmt.setInt(4, newQuantity);
            stmt.setInt(5, id);
            stmt.executeUpdate();
            return true; // Retourne true si la mise à jour a réussi
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false; // Retourne false en cas d'erreur
    }

    // Méthode pour supprimer une commande
    public boolean deleteCommande(int id) {
        String query = "DELETE FROM commandes WHERE ID = ?";

        try (PreparedStatement stmt = connection.prepareStatement(query)) {
            stmt.setInt(1, id);
            stmt.executeUpdate();
            return true; // Retourne true si la suppression a réussi
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false; // Retourne false en cas d'erreur
    }
}