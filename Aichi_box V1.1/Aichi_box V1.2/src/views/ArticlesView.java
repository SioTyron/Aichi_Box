package views;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.util.List;
import model.Article;

public class ArticlesView extends JFrame {
    private JTable articlesTable;
    private JTextField searchField;
    private JButton searchButton, addButton, deleteButton, backButton;

    public ArticlesView() {
        setTitle("Gestion des Articles");
        setSize(900, 600);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setLocationRelativeTo(null); // Centrer la fenêtre à l'écran
        setLayout(new BorderLayout(10, 10)); // Espacement entre les sections

        // Titre
        JLabel titleLabel = new JLabel("Gestion des Articles", SwingConstants.CENTER);
        titleLabel.setFont(new Font("Arial", Font.BOLD, 24));
        titleLabel.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10)); // Espacement interne
        add(titleLabel, BorderLayout.NORTH);

        // Barre de recherche
        JPanel searchPanel = new JPanel();
        searchPanel.setLayout(new FlowLayout(FlowLayout.CENTER, 10, 10));
        searchField = new JTextField(25);
        searchField.setFont(new Font("Arial", Font.PLAIN, 14));
        searchButton = new JButton("Rechercher");
        styleButton(searchButton);
        searchPanel.add(new JLabel("Rechercher un article :"));
        searchPanel.add(searchField);
        searchPanel.add(searchButton);
        add(searchPanel, BorderLayout.NORTH);

        // Table des articles
        articlesTable = new JTable(new DefaultTableModel(new Object[]{"Id", "Nom", "Description", "Prix", "Quantité"}, 0));
        articlesTable.setFont(new Font("Arial", Font.PLAIN, 14));
        articlesTable.setRowHeight(25);
        articlesTable.getTableHeader().setFont(new Font("Arial", Font.BOLD, 14));
        add(new JScrollPane(articlesTable), BorderLayout.CENTER);

        // Panneau des boutons
        JPanel buttonPanel = new JPanel();
        buttonPanel.setLayout(new BoxLayout(buttonPanel, BoxLayout.Y_AXIS));
        buttonPanel.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10)); // Marges autour

        // Boutons Ajouter et Supprimer
        addButton = new JButton("Ajouter");
        deleteButton = new JButton("Supprimer");
        backButton = new JButton("Retour");

        styleButton(addButton);
        styleButton(deleteButton);
        styleButton(backButton);

        buttonPanel.add(Box.createRigidArea(new Dimension(0, 10))); // Espacement
        buttonPanel.add(addButton);
        buttonPanel.add(Box.createRigidArea(new Dimension(0, 10))); // Espacement
        buttonPanel.add(deleteButton);
        buttonPanel.add(Box.createRigidArea(new Dimension(0, 10))); // Espacement
        buttonPanel.add(backButton);

        add(buttonPanel, BorderLayout.EAST);
    }

    // Méthode pour styliser un bouton
    private void styleButton(JButton button) {
        button.setFont(new Font("Arial", Font.PLAIN, 16));
        button.setPreferredSize(new Dimension(150, 40)); // Taille uniforme pour les boutons
        button.setAlignmentX(Component.CENTER_ALIGNMENT);
    }

    public JTable getArticlesTable() {
        return articlesTable;
    }

    public JTextField getSearchField() {
        return searchField;
    }

    public JButton getSearchButton() {
        return searchButton;
    }

    public JButton getAddButton() {
        return addButton;
    }

    public JButton getDeleteButton() {
        return deleteButton;
    }
    
    public JButton getBackButton() {
        return backButton;
    }

    public void updateTable(List<Article> articles) {
        DefaultTableModel model = (DefaultTableModel) articlesTable.getModel();
        model.setRowCount(0); // Effacer les lignes existantes
        for (Article article : articles) {
            model.addRow(new Object[]{article.getId(), article.getNom(), article.getDescription(), article.getPrix(), article.getQuantiteEnStock()});
        }
    }
}
