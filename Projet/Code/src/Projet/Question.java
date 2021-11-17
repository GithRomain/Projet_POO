package Projet;

import java.util.LinkedList;

abstract class Question {
    private static int N; //numero
    private String T; //theme
    private int D; //difficulte
    private String Q; //enonce
    private String R; //reponse

    //Constructeurs
    public Question(String T, int D, String Q, String R) {
        this.T = T;
        this.D = D;
        this.Q = Q;
        this.R = R;
        N += 1; //A chaque nouvelle question cree on incremente automatiquement N
    }

    public Question() {
        N += 1; //incr N
    }

    //Getters
    public int getN() {
        return N;
    }

    public String getT() {
        return T;
    }

    public int getD() {
        return D;
    }

    public String getD_String() {
        switch (D) {
            case 1: {
                return "Niveau facile";
            }
            case 2: {
                return "Niveau moyen";
            }
            case 3: {
                return "Niveau difficile";
            }
            default:
                return "Le niveau de difficulté rentré n'existe pas";
        }
    }

    public String getQ() {
        return Q;
    }

    public String getR() {
        return R;
    }

    //Setters
    public void setT(String t) {
        T = t;
    }

    public void setD(int d) {
        D = d;
    }

    public void setQ(String q) {
        Q = q;
    }

    public void setR(String r) {
        R = r;
    }

    //Méthodes
    public abstract void saisie_question();

    public abstract String reponse_IA();

    public abstract String toString();
}
