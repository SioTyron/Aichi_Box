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
        setSize(800, 600);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setLayout(new BorderLayout());

        // Barre de recherche
        JPanel searchPanel = new JPanel(new FlowLayout());
        searchField = new JTextField(20);
        searchButton = new JButton("Rechercher");
        searchPanel.add(new JLabel("Rechercher un article :"));
        searchPanel.add(searchField);
        searchPanel.add(searchButton);
        add(searchPanel, BorderLayout.NORTH);

        // Table des articles
        articlesTable = new JTable(new DefaultTableModel(new Object[]{"Id", "Nom", "Description", "Prix", "Quantité"}, 0));
        add(new JScrollPane(articlesTable), BorderLayout.CENTER);

        // Boutons
        JPanel buttonPanel = new JPanel(new FlowLayout());
        addButton = new JButton("Ajouter");
        deleteButton = new JButton("Supprimer");
        backButton = new JButton("Retour");
        buttonPanel.add(addButton);
        buttonPanel.add(deleteButton);
        buttonPanel.add(backButton);
        add(buttonPanel, BorderLayout.SOUTH);
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
        model.setRowCount(0); // Clear existing rows
        for (Article article : articles) {
            model.addRow(new Object[]{article.getId(), article.getNom(), article.getDescription(), article.getPrix(), article.getQuantiteEnStock()});
        }
    }
}
