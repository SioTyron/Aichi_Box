package views;

import javax.swing.*;
import java.awt.*;

public class FConnexionView extends JFrame {
    private JTextField userField;
    private JPasswordField passwordField;
    private JButton connexionButton;
    private JButton quitterButton; // Nouveau bouton quitter

    public FConnexionView() {
        setTitle("Connexion");
        setSize(400, 200);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new GridLayout(4, 1)); // Augmenté pour le titre et le bouton quitter

        // Titre
        JLabel titleLabel = new JLabel("Aichi Guadeloupe", SwingConstants.CENTER);
        titleLabel.setFont(new Font("Arial", Font.BOLD, 20));
        add(titleLabel);

        // Champs de connexion
        add(new JLabel("Utilisateur:"));
        userField = new JTextField(10); // Réduit la taille
        add(userField);

        add(new JLabel("Mot de passe:"));
        passwordField = new JPasswordField(10); // Réduit la taille
        add(passwordField);

        // Boutons
        connexionButton = new JButton("Se connecter");
        add(connexionButton);
        
        quitterButton = new JButton("Quitter"); // Nouveau bouton quitter
        quitterButton.addActionListener(e -> System.exit(0)); // Action pour quitter
        add(quitterButton);
    }

    public JTextField getUserField() {
        return userField;
    }

    public JPasswordField getPasswordField() {
        return passwordField;
    }

    public JButton getConnexionButton() {
        return connexionButton;
    }

    public JButton getQuitterButton() {
        return quitterButton; // Accès au bouton quitter
    }
}