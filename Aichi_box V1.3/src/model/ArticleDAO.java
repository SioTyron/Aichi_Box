package model;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class ArticleDAO {
    private Connection connection;

    public ArticleDAO() {
        this.connection = ConnexionDAO.getConnexion();
    }

    public List<Article> getAllArticles() {
        List<Article> articles = new ArrayList<>();
        String query = "SELECT * FROM articles";

        try (Statement stmt = connection.createStatement();
             ResultSet rs = stmt.executeQuery(query)) {

            while (rs.next()) {
                articles.add(new Article(
                        rs.getInt("Id"),
                        rs.getString("Nom"),
                        rs.getString("Description"),
                        rs.getDouble("Prix"),
                        rs.getInt("QuantiteEnStock")
                ));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return articles;
    }

    public List<Article> searchArticlesByName(String name) {
        List<Article> articles = new ArrayList<>();
        String query = "SELECT * FROM articles WHERE Nom LIKE ?";

        try (PreparedStatement stmt = connection.prepareStatement(query)) {
            stmt.setString(1, "%" + name + "%");
            ResultSet rs = stmt.executeQuery();

            while (rs.next()) {
                articles.add(new Article(
                        rs.getInt("Id"),
                        rs.getString("Nom"),
                        rs.getString("Description"),
                        rs.getDouble("Prix"),
                        rs.getInt("QuantiteEnStock")
                ));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return articles;
    }

    public boolean addArticle(String nom, String description, double prix, int quantiteEnStock) {
        String query = "INSERT INTO articles (Nom, Description, Prix, QuantiteEnStock) VALUES (?, ?, ?, ?)";

        try (PreparedStatement stmt = connection.prepareStatement(query)) {
            stmt.setString(1, nom);
            stmt.setString(2, description);
            stmt.setDouble(3, prix);
            stmt.setInt(4, quantiteEnStock);
            stmt.executeUpdate();
            return true;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }

    public boolean deleteArticle(int id) {
        String query = "DELETE FROM articles WHERE Id = ?";

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
