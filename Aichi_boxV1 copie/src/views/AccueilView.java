package views;

import javax.swing.*;

import controller.ArticlesController;

import java.awt.*;
import model.User;

public class AccueilView extends JFrame {
    private JButton articlesButton, commandeButton, clientButton, decoButton;


    public AccueilView(User user) {
        setTitle("Accueil - "+ "Connecté en tant que : "+ user.getNom());
        setSize(400, 300);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setLayout(new GridLayout(6, 1)); // Mise en page simple

       // JLabel welcomeLabel = new JLabel("Bienvenue, " + user.getNom(), SwingConstants.CENTER);
        //add(welcomeLabel, BorderLayout.NORTH);

        articlesButton = new JButton("Voir les Articles");
        add(articlesButton, BorderLayout.CENTER);
        
        commandeButton = new JButton("Gestion des Commandes");
        add(commandeButton, BorderLayout.CENTER);
        
        clientButton = new JButton("Gestion des Clients");
        add(clientButton, BorderLayout.CENTER);
        
        decoButton = new JButton("Déconnexion");
        add(decoButton, BorderLayout.PAGE_END);

        // Listener pour afficher la vue Articles
        articlesButton.addActionListener(e -> new ArticlesController().showArticlesView());
        //commandeButton.addActionListener(e -> new CommandesController().showCommandesView());
        //clientButton.addActionListener(e -> new CLientsController().showClientsView());
        
    }
    
    public JButton getDecoButton() {
        return decoButton;
    }
}
