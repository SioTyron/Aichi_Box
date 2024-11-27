package views;

import javax.swing.*;
import controller.ArticlesController;
import controller.CommandesController; // Ajout du contrôleur pour les commandes
import controller.ClientsController; // Ajout du contrôleur pour les clients
import java.awt.*;
import model.User;

public class AccueilView extends JFrame {
    private JButton articlesButton, commandeButton, clientButton, decoButton;

    public AccueilView(User user) {
        setTitle("Accueil - Connecté en tant que : " + user.getNom());
        setSize(500, 400); // Taille augmentée pour un meilleur espacement
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null); // Centré sur l'écran
        setLayout(new BorderLayout()); // Utilisation d'un BorderLayout pour une meilleure organisation

        // Panel principal
        JPanel mainPanel = new JPanel();
        mainPanel.setLayout(new BoxLayout(mainPanel, BoxLayout.Y_AXIS));
        mainPanel.setBorder(BorderFactory.createEmptyBorder(20, 20, 20, 20)); // Marges autour du panneau

        // Titre
        JLabel titleLabel = new JLabel("Bienvenue sur Aichi Guadeloupe", SwingConstants.CENTER);
        titleLabel.setFont(new Font("Arial", Font.BOLD, 20));
        titleLabel.setAlignmentX(Component.CENTER_ALIGNMENT);
        mainPanel.add(titleLabel);
        mainPanel.add(Box.createRigidArea(new Dimension(0, 20))); // Espacement vertical

        // Bouton Articles
        articlesButton = new JButton("Voir les Articles");
        styleButton(articlesButton);
        mainPanel.add(articlesButton);

        // Bouton Commandes
        commandeButton = new JButton("Gestion des Commandes");
        styleButton(commandeButton);
        mainPanel.add(commandeButton);

        // Bouton Clients
        clientButton = new JButton("Gestion des Clients");
        styleButton(clientButton);
        mainPanel.add(clientButton);

        // Espacement
        mainPanel.add(Box.createRigidArea(new Dimension(0, 20)));

        // Bouton Déconnexion
        decoButton = new JButton("Déconnexion");
        styleButton(decoButton);
        decoButton.addActionListener(e -> System.exit(0)); // Action pour quitter
        mainPanel.add(decoButton);

        // Ajouter le panneau principal à la fenêtre
        add(mainPanel, BorderLayout.CENTER);

        // Listeners pour les actions des boutons
        articlesButton.addActionListener(e -> new ArticlesController().showArticlesView());
        commandeButton.addActionListener(e -> new CommandesController().showCommandesView());
        clientButton.addActionListener(e -> new ClientsController().showClientsView());
    }

    // Méthode pour appliquer un style uniforme aux boutons
    private void styleButton(JButton button) {
        button.setFont(new Font("Arial", Font.PLAIN, 16));
        button.setAlignmentX(Component.CENTER_ALIGNMENT);
        button.setMaximumSize(new Dimension(200, 40)); // Taille maximale pour uniformiser les boutons
    }

    public JButton getDecoButton() {
        return decoButton;
    }
}
