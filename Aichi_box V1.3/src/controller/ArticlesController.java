package controller;

import model.Article;
import model.ArticleDAO;
import views.ArticlesView;

import javax.swing.*;
import java.util.List;

public class ArticlesController {
    private ArticlesView articlesView;
    private ArticleDAO articleDAO;

    public ArticlesController() {
        this.articlesView = new ArticlesView();
        this.articleDAO = new ArticleDAO();

        loadArticles();

        // Ajout des listeners pour les boutons
        articlesView.getSearchButton().addActionListener(e -> searchArticle());
        articlesView.getAddButton().addActionListener(e -> addArticle());
        articlesView.getDeleteButton().addActionListener(e -> deleteArticle());
        articlesView.getBackButton().addActionListener(e -> backMenu());
    }

    public void showArticlesView() {
        articlesView.setVisible(true);
    }

    private void loadArticles() {
        List<Article> articles = articleDAO.getAllArticles();
        articlesView.updateTable(articles);
    }

    private void searchArticle() {
        String keyword = articlesView.getSearchField().getText();
        List<Article> articles = articleDAO.searchArticlesByName(keyword);
        articlesView.updateTable(articles);
    }

    private void addArticle() {
        String nom = JOptionPane.showInputDialog("Nom de l'article :");
        String description = JOptionPane.showInputDialog("Description de l'article :");
        double prix = Double.parseDouble(JOptionPane.showInputDialog("Prix de l'article :"));
        int quantite = Integer.parseInt(JOptionPane.showInputDialog("Quantité en stock :"));

        if (articleDAO.addArticle(nom, description, prix, quantite)) {
            JOptionPane.showMessageDialog(articlesView, "Article ajouté !");
            loadArticles(); // Recharge les articles
        } else {
            JOptionPane.showMessageDialog(articlesView, "Erreur lors de l'ajout.", "Erreur", JOptionPane.ERROR_MESSAGE);
        }
    }

    private void deleteArticle() {
        int row = articlesView.getArticlesTable().getSelectedRow();
        if (row != -1) {
            int id = (int) articlesView.getArticlesTable().getValueAt(row, 0); // Récupère l'ID de l'article sélectionné
            if (articleDAO.deleteArticle(id)) {
                JOptionPane.showMessageDialog(articlesView, "Article supprimé !");
                loadArticles(); // Recharge les articles
            } else {
                JOptionPane.showMessageDialog(articlesView, "Erreur lors de la suppression.", "Erreur", JOptionPane.ERROR_MESSAGE);
            }
        } else {
            JOptionPane.showMessageDialog(articlesView, "Veuillez sélectionner un article.", "Attention", JOptionPane.WARNING_MESSAGE);
        }
    }
    
    private void backMenu() {
    	articlesView.dispose();
    }
}
