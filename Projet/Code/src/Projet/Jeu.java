package Projet;

import java.util.List;

public class Jeu {
    private Phase presentation = new Presentation();
    public Jeu()
    {
        presentation.deroulement_phase();
    }

    public Jeu(String str)
    {
        presentation.deroulement_phase_grand_jeu();
    }

    public void start() {
        //Phase
        Phase phase1 = new Phase1(presentation);
        phase1.deroulement_phase();

        Phase phase2 = new Phase2(phase1);
        phase2.deroulement_phase();

        Phase phase3 = new Phase3(phase2);
        Joueur joueur_gagnant = phase3.deroulement_phase();

        System.out.println("\nLe gagnant du jeu est :\n" + joueur_gagnant);
    }

    public Joueur start_grand_jeu(List<Joueur> joueurs) {
        //Phase
        Phase phase1 = new Phase1(presentation, joueurs);
        phase1.deroulement_phase();

        Phase phase2 = new Phase2(phase1);
        phase2.deroulement_phase();

        Phase phase3 = new Phase3(phase2);
        Joueur joueur_gagnant = phase3.deroulement_phase();

        System.out.println("\nLe gagnant du jeu est :\n" + joueur_gagnant);

        return joueur_gagnant;
    }

    public Joueur start_all_star(List<Joueur> joueurs) {
        //Phase
        Phase phase2 = new Phase2(presentation, joueurs);
        phase2.deroulement_phase();

        Phase phase3 = new Phase3(phase2);
        Joueur joueur_gagnant = phase3.deroulement_phase();

        System.out.println("\nLe gagnant du jeu est :\n" + joueur_gagnant);

        return joueur_gagnant;
    }

    public void start_IA()
    {
        //Phase
        Phase phase1 = new Phase1(presentation);
        phase1.deroulement_phase_IA();

        Phase phase2 = new Phase2(phase1);
        phase2.deroulement_phase_IA();

        Phase phase3 = new Phase3(phase2);
        Joueur joueur_gagnant = phase3.deroulement_phase_IA();

        System.out.println("\nLe gagnant du jeu est :\n" + joueur_gagnant);
    }

    public Joueur start_grand_jeu_IA(List<Joueur> joueurs) {
        //Phase
        Phase phase1 = new Phase1(presentation, joueurs);
        phase1.deroulement_phase_IA();

        Phase phase2 = new Phase2(phase1);
        phase2.deroulement_phase_IA();

        Phase phase3 = new Phase3(phase2);
        Joueur joueur_gagnant = phase3.deroulement_phase_IA();

        System.out.println("\nLe gagnant du jeu est :\n" + joueur_gagnant);

        return joueur_gagnant;
    }

    public Joueur start_all_star_IA(List<Joueur> joueurs) {
        //Phase
        Phase phase2 = new Phase2(presentation, joueurs);
        phase2.deroulement_phase_IA();

        Phase phase3 = new Phase3(phase2);
        Joueur joueur_gagnant = phase3.deroulement_phase_IA();

        System.out.println("\nLe gagnant du jeu est :\n" + joueur_gagnant);

        return joueur_gagnant;
    }

    public Phase getPresentation() {
        return presentation;
    }

    public static void sortir(String str)
    {
        if(str.equals("fin"))
        {
            System.out.println("Au revoir, a bientot dans notre jeu !");
            System.exit(0);
        }
    }
}
