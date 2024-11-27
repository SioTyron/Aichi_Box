package controller;

import model.Client;
import model.ClientDAO; // Vous devez créer ce modèle pour interagir avec la base de données
import views.ClientsView;

import javax.swing.*;
import java.util.List;

public class ClientsController {
    private ClientsView clientsView;
    private ClientDAO clientDAO;

    public ClientsController() {
        this.clientsView = new ClientsView();
        this.clientDAO = new ClientDAO();
        
        loadClients(); // Charge les clients lors de l'initialisation

        // Ajout des listeners pour les boutons
        clientsView.getAddButton().addActionListener(e -> addClient());
        clientsView.getEditButton().addActionListener(e -> editClient());
        clientsView.getDeleteButton().addActionListener(e -> deleteClient());
    }

    public void showClientsView() {
        clientsView.setVisible(true);
    }

    private void loadClients() {
        List<Client> clients = clientDAO.getAllClients();
        clientsView.updateTable(clients); // Vous devez créer cette méthode dans ClientsView
    }

    public void addClient() {
        // Logique pour ajouter un client
        String name = JOptionPane.showInputDialog("Nom du client :");
        String email = JOptionPane.showInputDialog("Email du client :");
        
        if (clientDAO.addClient(name, email, email, email)) {
            JOptionPane.showMessageDialog(clientsView, "Client ajouté !");
            loadClients(); // Recharge les clients
        } else {
            JOptionPane.showMessageDialog(clientsView, "Erreur lors de l'ajout.", "Erreur", JOptionPane.ERROR_MESSAGE);
        }
    }

    public void editClient() {
        // Logique pour modifier un client
        int row = clientsView.getClientsTable().getSelectedRow();
        if (row != -1) {
            int id = (int) clientsView.getClientsTable().getValueAt(row, 0); // Récupère l'ID du client sélectionné
            // Modifier les détails du client
            String newName = JOptionPane.showInputDialog("Nouveau nom du client :");
            String newEmail = JOptionPane.showInputDialog("Nouvel email du client :");
            
            if (clientDAO.updateClient(id, newName, newEmail, newEmail, newEmail)) {
                JOptionPane.showMessageDialog(clientsView, "Client modifié !");
                loadClients(); // Recharge les clients
            } else {
                JOptionPane.showMessageDialog(clientsView, "Erreur lors de la modification.", "Erreur", JOptionPane.ERROR_MESSAGE);
            }
        } else {
            JOptionPane.showMessageDialog(clientsView, "Veuillez sélectionner un client.", "Attention", JOptionPane.WARNING_MESSAGE);
        }
    }

    public void deleteClient() {
        // Logique pour supprimer un client
        int row = clientsView.getClientsTable().getSelectedRow();
        if (row != -1) {
            int id = (int) clientsView.getClientsTable().getValueAt(row, 0); // Récupère l'ID du client sélectionné
            if (clientDAO.deleteClient(id)) {
                JOptionPane.showMessageDialog(clientsView, "Client supprimé !");
                loadClients(); // Recharge les clients
            } else {
                JOptionPane.showMessageDialog(clientsView, "Erreur lors de la suppression.", "Erreur", JOptionPane.ERROR_MESSAGE);
            }
        } else {
            JOptionPane.showMessageDialog(clientsView, "Veuillez sélectionner un client.", "Attention", JOptionPane.WARNING_MESSAGE);
        }
    }
}