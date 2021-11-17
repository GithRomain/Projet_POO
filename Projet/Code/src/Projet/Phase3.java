package Projet;

import java.util.Random;
import java.util.Scanner;

class Phase3 implements Phase {
    private final int num_phase = 3;
    private Joueurs joueurs;
    private Themes themes;
    private Questions questions;

    //Constructeurs
    public Phase3(Phase phase) {
        joueurs = phase.getJoueurs();
        themes = phase.getThemes();
        questions = phase.getQuestions();
    }

    //Getters
    public Joueurs getJoueurs() {
        return joueurs;
    }

    public Themes getThemes() {
        return themes;
    }

    public Questions getQuestions() {
        return questions;
    }

    //Setters

    //Methodes
    public void selectionner_joueur() {
        joueurs.generer_ensemble_participants(2); //Générer les 3 joueurs
    }

    public void poser_question(Joueur joueur, Question question) {
        String str = "\nJoueur : " + joueur.getNom()
                + "\nRépondez à la question suivante : \n"
                + question;
        System.out.println(str);
    }

    public String reponse_question(Question question) {
        Scanner scanner = new Scanner(System.in);
        String reponse = scanner.nextLine();
        Jeu.sortir(reponse);
        return reponse;
    }

    public String reponse_question_IA(Question question) {
        String reponse = question.reponse_IA();

        Jeu.sortir(reponse);
        return reponse;
    }

    public void test_reponse(Joueur joueur, Question question, String reponse) {
        if (question.getR().equals(reponse)) {
            joueur.mise_a_jour_score(5);
            System.out.println("Réponse juste");
        } else {
            System.out.println("Réponse fausse");
        }
    }

    public void question_reponse(int nb_question_par_themes) {
        for (int k = 0; k < themes.getThemeList().size(); k++) {
            themes.setInd_theme(k);
            questions.setInd_question(new Random().nextInt(questions.getMat_questions().get(themes.getInd_theme()).size()));
            for (int j = 0; j < nb_question_par_themes; j++) {
                for (int i = 0; i < joueurs.getJoueurs().size(); i++) {
                    Joueur joueur = joueurs.getJoueurs().get(i);
                    Question question = questions.selection(num_phase);

                    poser_question(joueur, question);

                    //chrono start/resume
                    if(j == 0)
                    {
                        joueur.getChrono().start();
                    }
                    else
                    {
                        joueur.getChrono().resume();
                    }

                    String reponse = reponse_question(question);

                    //chrono end/pause
                    if(j == nb_question_par_themes - 1)
                    {
                        joueur.getChrono().stop();
                    }
                    else
                    {
                        joueur.getChrono().pause();
                    }

                    test_reponse(joueur, question, reponse);
                    joueur.setEtat("répondu");
                }
            }
        }
    }

    public void question_reponse_IA(int nb_question_par_themes) {
        for (int k = 0; k < themes.getThemeList().size(); k++) {
            themes.setInd_theme(k);
            questions.setInd_question(new Random().nextInt(questions.getMat_questions().get(themes.getInd_theme()).size()));
            for (int j = 0; j < nb_question_par_themes; j++) {
                for (int i = 0; i < joueurs.getJoueurs().size(); i++) {
                    Joueur joueur = joueurs.getJoueurs().get(i);
                    Question question = questions.selection(num_phase);

                    poser_question(joueur, question);

                    //chrono start/resume
                    if(j == 0)
                    {
                        joueur.getChrono().start();
                    }
                    else
                    {
                        joueur.getChrono().resume();
                    }

                    String reponse = reponse_question_IA(question);
                    System.out.println(reponse);

                    //chrono end/pause
                    if(j == nb_question_par_themes - 1)
                    {
                        joueur.getChrono().stop();
                    }
                    else
                    {
                        joueur.getChrono().pause();
                    }

                    test_reponse(joueur, question, reponse);
                    joueur.setEtat("répondu");
                }
            }
        }
    }

    public void determiner_gagant_et_elimine() {
        int minIndex = 0;
        int maxIndex = 0;

        //min
        for (int i = 1; i < joueurs.getJoueurs().size(); i++) {
            if (joueurs.getJoueurs().get(i).getScore() < joueurs.getJoueurs().get(minIndex).getScore())
            {
                minIndex = i;
            }
            else if(joueurs.getJoueurs().get(i).getScore() == joueurs.getJoueurs().get(minIndex).getScore())
            {
                if(joueurs.getJoueurs().get(i).getChrono().getDureeMs() > joueurs.getJoueurs().get(minIndex).getChrono().getDureeMs())
                {
                    minIndex = i;
                }
            }
        }

        //max
        for (int i = 1; i < joueurs.getJoueurs().size(); i++) {
            if (joueurs.getJoueurs().get(i).getScore() > joueurs.getJoueurs().get(maxIndex).getScore()) {
                maxIndex = i;
            }
            else if(joueurs.getJoueurs().get(i).getScore() == joueurs.getJoueurs().get(maxIndex).getScore())
            {
                if(joueurs.getJoueurs().get(i).getChrono().getDureeMs() < joueurs.getJoueurs().get(maxIndex).getChrono().getDureeMs())
                {
                    maxIndex = i;
                }
            }
        }

        //Mise a niveaux des états
        joueurs.getJoueurs().get(maxIndex).changement_etat("super gagnant");
        joueurs.getJoueurs().get(minIndex).changement_etat("éliminé");

        for (Joueur joueur : joueurs.getJoueurs()) //pour les autres joueurs
        {
            if (joueur.getEtat().equals("répondu")) {
                joueur.setEtat("gagnant");
            }
        }

        System.out.println(joueurs);
    }

    public void remise_a_zero_chrono()
    {
        for(Joueur joueur : joueurs.getJoueurs())
        {
            joueur.getChrono().reset();
        }
    }

    public Joueur deroulement_phase() {
        System.out.println("\nPhase 3 :");

        selectionner_joueur();
        System.out.println(joueurs);

        System.out.println("\nMaitre du jeu : ");
        questions.selection_n_theme_saisie(3);
        System.out.println(themes);

        question_reponse(2);

        determiner_gagant_et_elimine();

        joueurs.generer_ensemble_participants(1);
        joueurs.getJoueurs().get(0).setEtat("super gagnant");

        remise_a_zero_chrono();

        return joueurs.getJoueurs().get(0);
    }

    public Joueur deroulement_phase_IA() {
        System.out.println("\nPhase 3 :");

        selectionner_joueur();
        System.out.println(joueurs);

        System.out.println("\nMaitre du jeu : ");
        questions.selection_n_theme_saisie(3);
        System.out.println(themes);

        question_reponse_IA(2);

        determiner_gagant_et_elimine();

        joueurs.generer_ensemble_participants(1);
        joueurs.getJoueurs().get(0).setEtat("super gagnant");

        remise_a_zero_chrono();

        return joueurs.getJoueurs().get(0);
    }

    @Override
    public Joueur deroulement_phase_grand_jeu() {
        return null;
    }
}
