package views;

import javax.swing.*;
import java.awt.*;

public class FConnexionView extends JFrame {
    private JTextField userField;
    private JPasswordField passwordField;
    private JButton connexionButton;

    public FConnexionView() {
        setTitle("Connexion");
        setSize(400, 200);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new GridLayout(3, 2));

        add(new JLabel("Utilisateur:"));
        userField = new JTextField();
        add(userField);

        add(new JLabel("Mot de passe:"));
        passwordField = new JPasswordField();
        add(passwordField);

        connexionButton = new JButton("Se connecter");
        add(connexionButton);
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
}
