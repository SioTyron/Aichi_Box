package model;

public class Article {
    private int id;
    private String nom;
    private String description;
    private double prix;
    private int quantiteEnStock;

    public Article(int id, String nom, String description, double prix, int quantiteEnStock) {
        this.id = id;
        this.nom = nom;
        this.description = description;
        this.prix = prix;
        this.quantiteEnStock = quantiteEnStock;
    }

    public int getId() {
        return id;
    }

    public String getNom() {
        return nom;
    }

    public String getDescription() {
        return description;
    }

    public double getPrix() {
        return prix;
    }

    public int getQuantiteEnStock() {
        return quantiteEnStock;
    }
}
