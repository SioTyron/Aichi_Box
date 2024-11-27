package views;

import javax.swing.*;
import java.awt.*;

public class FConnexionView extends JFrame {
    private JTextField userField;
    private JPasswordField passwordField;
    private JButton connexionButton;
    private JButton quitterButton;

    public FConnexionView() {
        setTitle("Connexion");
        setSize(400, 300); // Augmenté pour plus de place
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null); // Centré sur l'écran
        setLayout(new GridBagLayout()); // Utilisation de GridBagLayout pour un meilleur design

        GridBagConstraints gbc = new GridBagConstraints();
        gbc.insets = new Insets(10, 10, 10, 10); // Marges entre les composants
        gbc.fill = GridBagConstraints.HORIZONTAL;
        gbc.gridx = 0;
        gbc.gridy = 0;
        gbc.gridwidth = 2; // Étendre sur 2 colonnes

        // Titre
        JLabel titleLabel = new JLabel("Aichi Guadeloupe", SwingConstants.CENTER);
        titleLabel.setFont(new Font("Arial", Font.BOLD, 24));
        add(titleLabel, gbc);

        // Champs utilisateur
        gbc.gridy++;
        gbc.gridwidth = 1; // Revenir à une seule colonne
        gbc.anchor = GridBagConstraints.LINE_END;
        add(new JLabel("Utilisateur:"), gbc);

        gbc.gridx++;
        gbc.anchor = GridBagConstraints.LINE_START;
        userField = new JTextField(15); // Taille ajustée
        add(userField, gbc);

        // Champs mot de passe
        gbc.gridy++;
        gbc.gridx = 0;
        gbc.anchor = GridBagConstraints.LINE_END;
        add(new JLabel("Mot de passe:"), gbc);

        gbc.gridx++;
        gbc.anchor = GridBagConstraints.LINE_START;
        passwordField = new JPasswordField(15); // Taille ajustée
        add(passwordField, gbc);

        // Boutons
        gbc.gridy++;
        gbc.gridx = 0;
        gbc.gridwidth = 2; // Étendre sur 2 colonnes
        gbc.anchor = GridBagConstraints.CENTER;

        JPanel buttonPanel = new JPanel(new FlowLayout(FlowLayout.CENTER, 20, 0)); // Alignement horizontal des boutons
        connexionButton = new JButton("Se connecter");
        quitterButton = new JButton("Quitter");
        quitterButton.addActionListener(e -> System.exit(0)); // Action pour quitter
        buttonPanel.add(connexionButton);
        buttonPanel.add(quitterButton);

        add(buttonPanel, gbc);
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
        return quitterButton;
    }
}
