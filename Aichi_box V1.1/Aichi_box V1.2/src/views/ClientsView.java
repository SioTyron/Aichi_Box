package views;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.util.List;
import model.Client;

public class ClientsView extends JFrame {
    private JTable clientsTable;
    private JButton addButton, editButton, deleteButton, backButton;

    public ClientsView() {
        setTitle("Gestion des Clients");
        setSize(800, 600);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setLocationRelativeTo(null); // Centrer la fenêtre
        setLayout(new BorderLayout(10, 10)); // Espacement autour des panneaux

        // Titre
        JLabel titleLabel = new JLabel("Gestion des Clients", SwingConstants.CENTER);
        titleLabel.setFont(new Font("Arial", Font.BOLD, 24));
        titleLabel.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));
        add(titleLabel, BorderLayout.NORTH);

        // Table des clients
        clientsTable = new JTable(new DefaultTableModel(new Object[]{"ID", "Nom", "Adresse", "Téléphone", "Email"}, 0));
        clientsTable.setFont(new Font("Arial", Font.PLAIN, 14));
        clientsTable.setRowHeight(25);
        clientsTable.getTableHeader().setFont(new Font("Arial", Font.BOLD, 14));
        add(new JScrollPane(clientsTable), BorderLayout.CENTER);

        // Panneau des boutons
        JPanel buttonPanel = new JPanel();
        buttonPanel.setLayout(new BoxLayout(buttonPanel, BoxLayout.Y_AXIS));
        buttonPanel.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10)); // Marges internes

        addButton = new JButton("Ajouter Client");
        editButton = new JButton("Modifier Client");
        deleteButton = new JButton("Supprimer Client");
        backButton = new JButton("Retour");

        styleButton(addButton);
        styleButton(editButton);
        styleButton(deleteButton);
        styleButton(backButton);

        buttonPanel.add(addButton);
        buttonPanel.add(Box.createRigidArea(new Dimension(0, 10))); // Espacement entre les boutons
        buttonPanel.add(editButton);
        buttonPanel.add(Box.createRigidArea(new Dimension(0, 10))); // Espacement entre les boutons
        buttonPanel.add(deleteButton);
        buttonPanel.add(Box.createRigidArea(new Dimension(0, 10))); // Espacement entre les boutons
        buttonPanel.add(backButton);

        add(buttonPanel, BorderLayout.EAST);

        // Action pour le bouton Retour
        backButton.addActionListener(e -> this.dispose());
    }

    // Méthode pour styliser un bouton
    private void styleButton(JButton button) {
        button.setFont(new Font("Arial", Font.PLAIN, 16));
        button.setPreferredSize(new Dimension(200, 40)); // Taille uniforme pour les boutons
        button.setAlignmentX(Component.CENTER_ALIGNMENT);
    }

    public JTable getClientsTable() {
        return clientsTable;
    }

    public JButton getAddButton() {
        return addButton;
    }

    public JButton getEditButton() {
        return editButton;
    }

    public JButton getDeleteButton() {
        return deleteButton;
    }

    public JButton getBackButton() {
        return backButton;
    }

    // Méthode pour mettre à jour la table avec les nouvelles données
    public void updateTable(List<Client> clients) {
        DefaultTableModel model = (DefaultTableModel) clientsTable.getModel();
        model.setRowCount(0); // Effacer les lignes existantes

        for (Client client : clients) {
            model.addRow(new Object[]{
                client.getId(),
                client.getNom(),
                client.getAdresse(),
                client.getTelephone(),
                client.getEmail()
            });
        }
    }
}
