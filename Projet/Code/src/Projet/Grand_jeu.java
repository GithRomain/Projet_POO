package Projet;

import java.util.LinkedList;
import java.util.List;

public class Grand_jeu {
    private Jeu jeu = new Jeu();

    private List<Joueur> joueurs1;
    private List<Joueur> joueurs2;
    private List<Joueur> joueurs3;

    private List<Joueur> gagnants = new LinkedList<>();

    private Jeu jeu1;
    private Jeu jeu2;
    private Jeu jeu3;

    private Jeu all_star;

    public Grand_jeu()
    {
        joueurs1 = jeu.getPresentation().getJoueurs().generer_ensemble_participants_grand_jeu(4);
        joueurs2 = jeu.getPresentation().getJoueurs().generer_ensemble_participants_grand_jeu(4);
        joueurs3 = jeu.getPresentation().getJoueurs().generer_ensemble_participants_grand_jeu(4);
    }

    public void start()
    {
        System.out.println("Jeu1");
        jeu1 = new Jeu("GJ");
        Joueur gagnant1 = jeu1.start_grand_jeu(joueurs1);
        gagnant1.setScore(0);

        System.out.println("\nJeu2");
        jeu2 = new Jeu("GJ");
        Joueur gagnant2 = jeu2.start_grand_jeu(joueurs2);
        gagnant2.setScore(0);

        System.out.println("\nJeu3");
        jeu3 = new Jeu("GJ");
        Joueur gagnant3 = jeu3.start_grand_jeu(joueurs3);
        gagnant3.setScore(0);

        gagnants.add(gagnant1);
        gagnants.add(gagnant2);
        gagnants.add(gagnant3);

        System.out.println("\nAll star game");
        all_star = new Jeu("GJ");
        Joueur super_gagnant = all_star.start_all_star(gagnants);

        System.out.println("\nLe grand gagnant du grand jeu est : " + "\n" + super_gagnant);
    }

    public void start_IA()
    {
        System.out.println("Jeu1");
        jeu1 = new Jeu("GJ");
        Joueur gagnant1 = jeu1.start_grand_jeu_IA(joueurs1);
        gagnant1.mise_a_jour_score(0);

        System.out.println("\nJeu2");
        jeu2 = new Jeu("GJ");
        Joueur gagnant2 = jeu2.start_grand_jeu_IA(joueurs2);
        gagnant2.mise_a_jour_score(0);

        System.out.println("\nJeu3");
        jeu3 = new Jeu("GJ");
        Joueur gagnant3 = jeu3.start_grand_jeu_IA(joueurs3);
        gagnant3.mise_a_jour_score(0);

        gagnants.add(gagnant1);
        gagnants.add(gagnant2);
        gagnants.add(gagnant3);

        System.out.println("\nAll star game");
        all_star = new Jeu("GJ");
        Joueur super_gagnant = all_star.start_all_star_IA(gagnants);

        System.out.println("\nLe grand gagnant du grand jeu est : " + "\n" + super_gagnant);
    }
}
