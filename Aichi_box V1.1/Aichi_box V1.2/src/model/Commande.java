package model;

import java.util.Date;

public class Commande {
    private int id;
    private int idUtilisateur;
    private int idClient;
    private Date date;
    private String statut;

    public Commande(int id, int idUtilisateur, int idClient, Date date, String statut) {
        this.id = id;
        this.idUtilisateur = idUtilisateur;
        this.idClient = idClient;
        this.date = date;
        this.statut = statut;
    }

    public int getId() {
        return id;
    }

    public int getIdUtilisateur() {
        return idUtilisateur;
    }

    public int getIdClient() {
        return idClient;
    }

    public Date getDate() {
        return date;
    }

    public String getStatut() {
        return statut;
    }

	public Object getClientName() {
		// TODO Auto-generated method stub
		return null;
	}

	public Object getArticleName() {
		// TODO Auto-generated method stub
		return null;
	}


	public Object getNomArticle() {
		// TODO Auto-generated method stub
		return null;
	}

	public Object getQuantity() {
		// TODO Auto-generated method stub
		return null;
	}
}