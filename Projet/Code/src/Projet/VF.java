package Projet;

import java.util.*;

class VF extends Question
{
    private int num;

    //Constructeurs
    public VF(String T, int D, String Q, String R)
    {
        super(T, D, Q, R); //pour augmenter N
        num = getN();
    }

    public VF() {
        super(); //pour augmenter N
        num = getN();
        saisie_question();
    }

    //Getters

    //Setters

    //Methodes
    public void saisie_question()
    {
        Scanner scanner = new Scanner(System.in);

        System.out.println("\nSaisie question VF");

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

        System.out.println("(Boolean) Saisir reponse : ");
        String R = scanner.next();
        Jeu.sortir(R);

        setT(T);
        setD(D);
        setQ(Q);
        setR(R);
    }

    public String reponse_IA()
    {
        String str = null;
        int ind = new Random().nextInt(2);
        switch (ind)
        {
            case 0 -> str = "true";
            case 1 -> str = "false";
            default -> System.out.println("Probleme reponse IA");
        }
        return str;
    }

    @Override
    public String toString() {
        return "Type : VF : Numéro : " + num + ", Theme : " + getT() + ", Niveau de difficulté : " + getD_String() + ", Enoncé : " + getQ() + ", Réponses proposées : " + "Vrai ou Faux";
    }
}
