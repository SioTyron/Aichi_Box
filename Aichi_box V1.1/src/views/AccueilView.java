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
        setTitle("Accueil - " + "Connecté en tant que : " + user.getNom());
        setSize(400, 300);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setLayout(new GridLayout(6, 1));

        articlesButton = new JButton("Voir les Articles");
        add(articlesButton);
        
        commandeButton = new JButton("Gestion des Commandes");
        add(commandeButton);
        
        clientButton = new JButton("Gestion des Clients");
        add(clientButton);
        
        decoButton = new JButton("Déconnexion");
        decoButton.addActionListener(e -> System.exit(0)); // Action pour quitter
        add(decoButton);

        // Listener pour afficher la vue Articles
        articlesButton.addActionListener(e -> new ArticlesController().showArticlesView());
        commandeButton.addActionListener(e -> new CommandesController().showCommandesView()); // Lien vers gestion des commandes
        clientButton.addActionListener(e -> new ClientsController().showClientsView()); // Lien vers gestion des clients
    }

    public JButton getDecoButton() {
        return decoButton;
    }
}