package views;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.util.List;
import controller.CommandesController;
import model.Commande;

public class CommandesView extends JFrame {
    private JTable commandesTable;
    private JButton addButton, editButton, deleteButton, backButton;

    public CommandesView() {
        setTitle("Gestion des Commandes");
        setSize(900, 600);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setLocationRelativeTo(null); // Centrer la fenêtre à l'écran
        setLayout(new BorderLayout(10, 10)); // Espacement entre les sections

        // Titre
        JLabel titleLabel = new JLabel("Gestion des Commandes", SwingConstants.CENTER);
        titleLabel.setFont(new Font("Arial", Font.BOLD, 24));
        titleLabel.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10)); // Espacement interne
        add(titleLabel, BorderLayout.NORTH);

        // Table des commandes
        setCommandesTable(new JTable(new DefaultTableModel(new Object[]{"ID", "Nom du Client", "Nom de l'Article", "Quantité", "Statut"}, 0))); 
        commandesTable.setFont(new Font("Arial", Font.PLAIN, 14));
        commandesTable.setRowHeight(25);
        commandesTable.getTableHeader().setFont(new Font("Arial", Font.BOLD, 14));
        add(new JScrollPane(getCommandesTable()), BorderLayout.CENTER);

        // Panneau des boutons
        JPanel buttonPanel = new JPanel();
        buttonPanel.setLayout(new BoxLayout(buttonPanel, BoxLayout.Y_AXIS));
        buttonPanel.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10)); // Marges autour

        // Boutons Ajouter, Modifier, Supprimer et Retour
        addButton = new JButton("Ajouter Commande");
        editButton = new JButton("Modifier Commande");
        deleteButton = new JButton("Supprimer Commande");
        backButton = new JButton("Retour");

        styleButton(addButton);
        styleButton(editButton);
        styleButton(deleteButton);
        styleButton(backButton);

        buttonPanel.add(Box.createRigidArea(new Dimension(0, 10))); // Espacement
        buttonPanel.add(addButton);
        buttonPanel.add(Box.createRigidArea(new Dimension(0, 10))); // Espacement
        buttonPanel.add(editButton);
        buttonPanel.add(Box.createRigidArea(new Dimension(0, 10))); // Espacement
        buttonPanel.add(deleteButton);
        buttonPanel.add(Box.createRigidArea(new Dimension(0, 10))); // Espacement
        buttonPanel.add(backButton);

        add(buttonPanel, BorderLayout.EAST);

        // Action pour le bouton de retour
        backButton.addActionListener(e -> this.dispose());

        // Actions des autres boutons
        addButton.addActionListener(e -> new CommandesController().addCommande());
        editButton.addActionListener(e -> new CommandesController().editCommande());
        deleteButton.addActionListener(e -> new CommandesController().deleteCommande());
    }

    // Méthode pour styliser les boutons
    private void styleButton(JButton button) {
        button.setFont(new Font("Arial", Font.PLAIN, 16));
        button.setPreferredSize(new Dimension(200, 40)); // Taille uniforme pour les boutons
        button.setAlignmentX(Component.CENTER_ALIGNMENT);
    }

    public void updateTable(List<Commande> commandes) {
        DefaultTableModel model = (DefaultTableModel) commandesTable.getModel();
        model.setRowCount(0); // Effacer les lignes existantes

        for (Commande commande : commandes) {
            model.addRow(new Object[]{
                commande.getId(),
                commande.getIdClient(),
                commande.getNomArticle(), // Assurez-vous d'avoir un moyen d'afficher le nom de l'article
                commande.getQuantity(),
                commande.getStatut() // Assurez-vous que le statut est bien affiché
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
