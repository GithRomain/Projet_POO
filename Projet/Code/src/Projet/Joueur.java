package Projet;

import java.util.Scanner;
import java.util.Timer;

class Joueur {
    private int numero;
    private char nom;
    private int score;
    private String etat;
    private Chrono chrono = new Chrono();

    //Constructeurs
    public Joueur(int numero, char nom, int score, String etat)
    {
        this.numero = numero;
        this.nom = nom;
        this.score = score;
        this.etat = etat;
    }

    //Getters
    public int getNumero() {
        return numero;
    }

    public char getNom() {
        return nom;
    }

    public String getEtat() {
        return etat;
    }

    public int getScore() {
        return score;
    }

    public Chrono getChrono() {
        return chrono;
    }

    //Setters
    public void setNumero(int numero) {
        this.numero = numero;
    }

    public void setNom(char nom) {
        this.nom = nom;
    }

    public void setScore(int score) {
        this.score = score;
    }

    public void setEtat(String etat) {
        this.etat = etat;
    }

    public void setChrono(Chrono chrono) {
        this.chrono = chrono;
    }

    //Methodes
    /*
    public void saisie_joueur() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("\nSaisie Joueur");
    }
     */

    public void mise_a_jour_score(int points) {
        setScore(score + points);
    }

    public void changement_etat(String etat) {
        setEtat(etat);
    }

    @Override
    public String toString() {
        return "Joueur : " + "numero : " + numero + ", nom : " + nom + ", score : " + score + ", chrono : " + chrono + " millisecondes , etat : " + etat;
    }
}
