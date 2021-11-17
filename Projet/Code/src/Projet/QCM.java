package Projet;

import com.sun.source.tree.BreakTree;

import java.util.Random;
import java.util.Scanner;

class QCM extends Question {
    private String C1, C2, C3; //choix de la question
    private int num; //numero

    //Constructeurs
    public QCM(String T, int D, String Q, String C1, String C2, String C3, String R) {
        super(T, D, Q, R); //On incrémente N
        this.C1 = C1;
        this.C2 = C2;
        this.C3 = C3;
        num = getN(); //on fixe N au moment donnée car sinon static
    }

    public QCM() {
        super(); //on incrémente N
        num = getN();
        saisie_question(); //declencher la fct de saisie (voir plus bas)
    }

    //Getters

    //Setters
    public void setC1(String c1) {
        C1 = c1;
    }

    public void setC2(String c2) {
        C2 = c2;
    }

    public void setC3(String c3) {
        C3 = c3;
    }

    //Methodes
    public void saisie_question() {
        Scanner scanner = new Scanner(System.in);

        System.out.println("\n Saisie question QCM");

        System.out.println("(String) Saisir thème : ");
        String T = scanner.next();
        Jeu.sortir(T);

        System.out.println("(int) Saisir niveau de difficulté : ");
        int D = scanner.nextInt();
        Jeu.sortir(String.valueOf(D));

        System.out.println("(String) Saisir question : ");
        String Q = scanner.nextLine();
        Q = scanner.nextLine();
        Jeu.sortir(Q);

        System.out.println("(String) Saisir choix 1 : ");
        String C1 = scanner.next();
        Jeu.sortir(C1);

        System.out.println("(String) Saisir choix 2 : ");
        String C2 = scanner.next();
        Jeu.sortir(C2);

        System.out.println("(String) Saisir choix 3 : ");
        String C3 = scanner.next();
        Jeu.sortir(C3);

        System.out.println("(String) Saisir reponse : ");
        String R = scanner.next();
        Jeu.sortir(R);

        setT(T);
        setD(D);
        setQ(Q);
        setC1(C1);
        setC2(C2);
        setC3(C3);
        setR(R);
    }

    public String reponse_IA()
    {
        String str = null;
        int ind = new Random().nextInt(3);
        switch (ind)
        {
            case 0 -> str = C1;
            case 1 -> str = C2;
            case 2 -> str = C3;
            default -> System.out.println("Probleme reponse IA");
        }
        return str;
    }

    @Override
    public String toString() {
        return "Type : QCM, Numéro : " + num + ", Theme : " + getT() + ", Niveau de difficulté : " + getD_String() + ", Enoncé : " + getQ() + ", Réponses proposées : " + C1 + " ou " + C2 + " ou " + C3;
    }
}
