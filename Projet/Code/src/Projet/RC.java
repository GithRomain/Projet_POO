package Projet;

import java.util.LinkedList;
import java.util.Random;
import java.util.Scanner;

class RC extends Question {
    private int num;
    private static LinkedList<String> list_reponses_RC = new LinkedList<>();

    //Constructeurs
    public RC(String T, int D, String Q, String R) {
        super(T, D, Q, R); //Augmenter N
        num = getN();
        list_reponses_RC.add(R);
    }

    public RC() {
        super(); //Augmenter N
        num = getN();
        saisie_question();
    }

    //Getters
    public LinkedList<String> getList_reponses_RC() {
        return list_reponses_RC;
    }

    //Setters

    //Methodes
    public void saisie_question() {
        Scanner scanner = new Scanner(System.in);

        System.out.println("\nSaisie question RC");

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

        System.out.println("(String) Saisir reponse : ");
        String R = scanner.next();
        Jeu.sortir(R);

        setT(T);
        setD(D);
        setQ(Q);
        setR(R);

        list_reponses_RC.add(R);
    }

    public String reponse_IA()
    {
        String str;
        int ind = new Random().nextInt(list_reponses_RC.size());
        str = list_reponses_RC.get(ind);
        return str;
    }

    @Override
    public String toString() {
        return "Type : RC, Numéro : " + num + ", Theme : " + getT() + ", Niveau de difficulté : " + getD_String() + ", Enoncé : " + getQ();
    }
}
