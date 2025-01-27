package test;
import static org.junit.Assert.*;
import org.junit.Before;
import org.junit.Test;
import model.ClientDAO;
import model.ConnexionDAO;

import javax.swing.*;
import java.sql.*;

public class ClientDAOTest {
    private ClientDAO clientDAO;
    private Connection connection;

    @Before
    public void setUp() throws SQLException {
        // Utiliser ConnexionDAO pour obtenir la connexion à la base de données
        connection = ConnexionDAO.getConnexion();
        clientDAO = new ClientDAO();
        JOptionPane.showMessageDialog(null, "Connexion à la base de données réussie.");
    }

    @Test
    public void testAddClient() throws SQLException {
        String nom = "John Doe";
        String adresse = "123 Main St";
        String telephone = "555-1234";
        String email = "john.doe@example.com";

        boolean result = clientDAO.addClient(nom, adresse, telephone, email);
        assertTrue(result);
        JOptionPane.showMessageDialog(null, "Client ajouté avec succès.");

        // Vérifier que le client a été ajouté à la base de données
        String query = "SELECT * FROM clients WHERE Nom = ? AND Adresse = ? AND Telephone = ? AND Email = ?";
        try (PreparedStatement stmt = connection.prepareStatement(query)) {
            stmt.setString(1, nom);
            stmt.setString(2, adresse);
            stmt.setString(3, telephone);
            stmt.setString(4, email);
            try (ResultSet rs = stmt.executeQuery()) {
                assertTrue(rs.next());
                assertEquals(nom, rs.getString("Nom"));
                assertEquals(adresse, rs.getString("Adresse"));
                assertEquals(telephone, rs.getString("Telephone"));
                assertEquals(email, rs.getString("Email"));
                JOptionPane.showMessageDialog(null, "Vérification des données réussie.");
            }
        }
    }
}
