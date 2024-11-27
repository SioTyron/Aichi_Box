package views;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.util.List;
import model.Client;

public class ClientsView extends JFrame {
    private JTable clientsTable;
    private JButton addButton, editButton, deleteButton;

    public ClientsView() {
        setTitle("Gestion des Clients");
        setSize(600, 400);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new BorderLayout());

        // Table pour afficher les clients
        clientsTable = new JTable(new DefaultTableModel(new Object[]{"ID", "Nom", "Adresse", "Téléphone", "Email"}, 0));
        add(new JScrollPane(clientsTable), BorderLayout.CENTER);

        // Panneau pour les boutons
        JPanel buttonPanel = new JPanel();
        addButton = new JButton("Ajouter Client");
        editButton = new JButton("Modifier Client");
        deleteButton = new JButton("Supprimer Client");

        buttonPanel.add(addButton);
        buttonPanel.add(editButton);
        buttonPanel.add(deleteButton);
        add(buttonPanel, BorderLayout.SOUTH);
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