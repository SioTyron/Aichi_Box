package model;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class CommandeDAO {
    private Connection connection;

    public CommandeDAO() {
        this.connection = ConnexionDAO.getConnexion();
    }

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
        System.out.println("Nombre de commandes récupérées : " + commandes.size()); // Ajoutez ce message pour le débogage
        return commandes;
    }

    public boolean addCommande(int clientId, int articleId, Date date, String statut) {
        String query = "INSERT INTO commandes (ID_Utilisateur, ID_Client, Date, Statut) VALUES (?, ?, ?, ?)";

        try (PreparedStatement stmt = connection.prepareStatement(query)) {
            stmt.setInt(1, clientId);
            stmt.setInt(2, articleId);
            stmt.setDate(3, new java.sql.Date(date.getTime()));
            stmt.setString(4, statut); // Assurez-vous d'ajouter le statut ici
            stmt.executeUpdate();
            return true; // Retourne true si l'ajout a réussi
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false; // Retourne false en cas d'erreur
    }

    public boolean updateCommande(int id, int newClientId, int newArticleId, Date date, String newStatut) {
        String query = "UPDATE commandes SET ID_Utilisateur = ?, ID_Client = ?, Date = ?, Statut = ? WHERE ID = ?";
        try (PreparedStatement stmt = connection.prepareStatement(query)) {
            stmt.setInt(1, newClientId);
            stmt.setInt(2, newArticleId);
            stmt.setDate(3, new java.sql.Date(date.getTime()));
            stmt.setString(4, newStatut); // Mettre à jour le statut ici
            stmt.setInt(5, id); // ID de la commande à mettre à jour
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
    public boolean clientExists(int clientId) {
        String query = "SELECT COUNT(*) FROM clients WHERE ID = ?";
        try (PreparedStatement stmt = connection.prepareStatement(query)) {
            stmt.setInt(1, clientId);
            ResultSet rs = stmt.executeQuery();
            if (rs.next()) {
                return rs.getInt(1) > 0; // Retourne true si le client existe
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false; // Retourne false en cas d'erreur
    }
}