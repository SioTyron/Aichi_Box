package controller;

import model.Commande;
import model.CommandeDAO; // Vous devez créer ce modèle pour interagir avec la base de données
import views.CommandesView;

import javax.swing.*;
import java.sql.Date;
import java.util.List;

public class CommandesController {
    private CommandesView commandesView;
    private CommandeDAO commandeDAO;

    public CommandesController() {
        this.commandesView = new CommandesView();
        this.commandeDAO = new CommandeDAO();
        
        loadCommandes(); // Charge les commandes lors de l'initialisation

        // Ajout des listeners pour les boutons
        commandesView.getAddButton().addActionListener(e -> addCommande());
        commandesView.getEditButton().addActionListener(e -> editCommande());
        commandesView.getDeleteButton().addActionListener(e -> deleteCommande());
    }

    public void showCommandesView() {
        commandesView.setVisible(true);
    }

    private void loadCommandes() {
        List<Commande> commandes = commandeDAO.getAllCommandes();
        commandesView.updateTable(commandes); // Vous devez créer cette méthode dans CommandesView
    }

    public void addCommande() {
        // Logique pour ajouter une commande
        String clientIdStr = JOptionPane.showInputDialog("ID du client :");
        String articleIdStr = JOptionPane.showInputDialog("ID de l'article :");
        String quantityStr = JOptionPane.showInputDialog("Quantité :");
        
        try {
            int clientId = Integer.parseInt(clientIdStr);
            int articleId = Integer.parseInt(articleIdStr);
            int quantity = Integer.parseInt(quantityStr);
            Date date = new Date(System.currentTimeMillis()); // Date actuelle

            if (commandeDAO.addCommande(clientId, articleId, date, quantity)) {
                JOptionPane.showMessageDialog(commandesView, "Commande ajoutée !");
                loadCommandes(); // Recharge les commandes
            } else {
                JOptionPane.showMessageDialog(commandesView, "Erreur lors de l'ajout.", "Erreur", JOptionPane.ERROR_MESSAGE);
            }
        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(commandesView, "Veuillez entrer des nombres valides.", "Erreur", JOptionPane.ERROR_MESSAGE);
        }
    }

    public void editCommande() {
        // Logique pour modifier une commande
        int row = commandesView.getCommandesTable().getSelectedRow();
        if (row != -1) {
            int id = (int) commandesView.getCommandesTable().getValueAt(row, 0); // Récupère l'ID de la commande sélectionnée
            
            String newClientIdStr = JOptionPane.showInputDialog("Nouvel ID du client :");
            String newArticleIdStr = JOptionPane.showInputDialog("Nouvel ID de l'article :");
            String newQuantityStr = JOptionPane.showInputDialog("Nouvelle quantité :");
            
            try {
                int newClientId = Integer.parseInt(newClientIdStr);
                int newArticleId = Integer.parseInt(newArticleIdStr);
                int newQuantity = Integer.parseInt(newQuantityStr);
                Date date = new Date(System.currentTimeMillis()); // Date actuelle

                if (commandeDAO.updateCommande(id, newClientId, newArticleId, date, newQuantity)) {
                    JOptionPane.showMessageDialog(commandesView, "Commande modifiée !");
                    loadCommandes(); // Recharge les commandes
                } else {
                    JOptionPane.showMessageDialog(commandesView, "Erreur lors de la modification.", "Erreur", JOptionPane.ERROR_MESSAGE);
                }
            } catch (NumberFormatException e) {
                JOptionPane.showMessageDialog(commandesView, "Veuillez entrer des nombres valides.", "Erreur", JOptionPane.ERROR_MESSAGE);
            }
        } else {
            JOptionPane.showMessageDialog(commandesView, "Veuillez sélectionner une commande.", "Attention", JOptionPane.WARNING_MESSAGE);
        }
    }

    public void deleteCommande() {
        // Logique pour supprimer une commande
        int row = commandesView.getCommandesTable().getSelectedRow();
        if (row != -1) {
            int id = (int) commandesView.getCommandesTable().getValueAt(row, 0); // Récupère l'ID de la commande sélectionnée
            if (commandeDAO.deleteCommande(id)) {
                JOptionPane.showMessageDialog(commandesView, "Commande supprimée !");
                loadCommandes(); // Recharge les commandes
            } else {
                JOptionPane.showMessageDialog(commandesView, "Erreur lors de la suppression.", "Erreur", JOptionPane.ERROR_MESSAGE);
            }
        } else {
            JOptionPane.showMessageDialog(commandesView, "Veuillez sélectionner une commande.", "Attention", JOptionPane.WARNING_MESSAGE);
        }
    }
}