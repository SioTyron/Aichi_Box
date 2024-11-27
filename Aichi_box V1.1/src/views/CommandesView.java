package views;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.util.List; // Importation de List
import controller.CommandesController;
import model.Commande;

public class CommandesView extends JFrame {
    private JTable commandesTable;
    private JButton addButton, editButton, deleteButton;

    public CommandesView() {
        setTitle("Gestion des Commandes");
        setSize(600, 400);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new BorderLayout());

        // Table pour afficher les commandes
        setCommandesTable(new JTable(new DefaultTableModel(new Object[]{"ID", "Nom du Client", "Nom de l'Article", "Quantité"}, 0))); // Initialisation avec un modèle
        add(new JScrollPane(getCommandesTable()), BorderLayout.CENTER);

        // Panneau pour les boutons
        JPanel buttonPanel = new JPanel();
        setAddButton(new JButton("Ajouter Commande"));
        setEditButton(new JButton("Modifier Commande"));
        setDeleteButton(new JButton("Supprimer Commande"));

        buttonPanel.add(getAddButton());
        buttonPanel.add(getEditButton());
        buttonPanel.add(getDeleteButton());
        add(buttonPanel, BorderLayout.SOUTH);

        // Actions des boutons
        getAddButton().addActionListener(e -> new CommandesController().addCommande());
        getEditButton().addActionListener(e -> new CommandesController().editCommande());
        getDeleteButton().addActionListener(e -> new CommandesController().deleteCommande());
    }
    
    // Méthode pour mettre à jour la table avec les nouvelles données
    public void updateTable(List<Commande> commandes) {
        DefaultTableModel model = (DefaultTableModel) commandesTable.getModel();
        model.setRowCount(0); // Efface les lignes existantes

        for (Commande commande : commandes) {
            model.addRow(new Object[]{
                commande.getId(),
                commande.getClientName(),
                commande.getArticleName(),
                commande.getQuantity()
            });
        }
    }

    // Getters et Setters
    public JButton getAddButton() {
        return addButton;
    }
    
    public void setAddButton(JButton addButton) {
        this.addButton = addButton;
    }
    
    public JButton getEditButton() {
        return editButton;
    }
    
    public void setEditButton(JButton editButton) {
        this.editButton = editButton;
    }
    
    public JButton getDeleteButton() {
        return deleteButton;
    }
    
    public void setDeleteButton(JButton deleteButton) {
        this.deleteButton = deleteButton;
    }
    
    public JTable getCommandesTable() {
        return commandesTable;
    }
    
    public void setCommandesTable(JTable commandesTable) {
        this.commandesTable = commandesTable;
    }
}