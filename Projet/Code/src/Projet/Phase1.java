package Projet;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

class Phase1 implements Phase {
    private final int num_phase = 1;
    private Joueurs joueurs;
    private Themes themes;
    private Questions questions;

    //Constructeurs
    public Phase1(Phase phase) {
        joueurs = phase.getJoueurs();
        themes = phase.getThemes();
        questions = phase.getQuestions();
    }

    public Phase1(Phase phase, List<Joueur> joueurs) {
        this.joueurs = phase.getJoueurs();
        this.joueurs.setJoueurs(joueurs);
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
        joueurs.generer_ensemble_participants(4); //Générer les 4 joueurs
    }

    public void poser_question(Joueur joueur, Question question) {
        String str = "\nJoueur : " + joueur.getNom()
                + "\nRépondez à la question suivante : \n"
                + question;
        System.out.println(str);
    }

    public String reponse_question(Question question, int i) {
        Scanner scanner = new Scanner(System.in);

        joueurs.getJoueurs().get(i).getChrono().start();
        String reponse = scanner.nextLine();
        joueurs.getJoueurs().get(i).getChrono().stop();

        Jeu.sortir(reponse);

        return reponse;
    }

    public String reponse_question_IA(Question question, int i) {
        joueurs.getJoueurs().get(i).getChrono().start();
        String reponse = question.reponse_IA();
        joueurs.getJoueurs().get(i).getChrono().stop();

        Jeu.sortir(reponse);

        return reponse;
    }

    public void test_reponse(Joueur joueur, Question question, String reponse) {
        if (question.getR().equals(reponse)) {
            joueur.mise_a_jour_score(2);
            System.out.println("Réponse juste");
        } else {
            System.out.println("Réponse fausse");
        }
    }

    public void question_reponse() {
        for (int i = 0; i < joueurs.getJoueurs().size(); i++) //on pose une question par joueur
        {
            Joueur joueur = joueurs.getJoueurs().get(i);
            Question question = questions.selection(num_phase);

            poser_question(joueur, question);

            String reponse = reponse_question(question, i);

            test_reponse(joueur, question, reponse);
            joueur.setEtat("répondu");
        }
    }

    public void question_reponse_IA() {
        for (int i = 0; i < joueurs.getJoueurs().size(); i++) //on pose une question par joueur
        {
            Joueur joueur = joueurs.getJoueurs().get(i);
            Question question = questions.selection(num_phase);

            poser_question(joueur, question);

            String reponse = reponse_question_IA(question, i);
            System.out.println(reponse);

            test_reponse(joueur, question, reponse);
            joueur.setEtat("répondu");
        }
    }

    public void determiner_gagant_et_elimine()
    {
        /*
        List<Integer> list_score = new ArrayList<>(); //tableau de scores des joueurs de la phase
        List<Integer> indice_score_min_repetition = new ArrayList<>(); //tableau des indices des joueurs qui ont un score minimum
        List<Long> list_chrono = new ArrayList<>(); //tableau des chronos des joueurs qui ont un score minimum
        List<Integer> indice_chrono_min_repetition = new ArrayList<>();

        //score min

        //créer la liste des scores de chaque joueurs
        for(Joueur joueur : joueurs.getJoueurs())
        {
            list_score.add(joueur.getScore());
        }

        //trouver la valeur minimal de score
        int minIndex = list_score.indexOf(Collections.min(list_score));

        //creer la liste des repetitions de score minimal
        for(int i = 0; i < list_score.size(); i++)
        {
            if(list_score.get(i) == list_score.get(minIndex))
            {
                indice_score_min_repetition.add(i);
            }
        }

        //creer la liste des chronos des joueurs de score minimal
        for(int i : indice_score_min_repetition)
        {
            list_chrono.add(joueurs.getJoueurs().get(i).getChrono().getDureeMs());
        }

        minIndex = list_chrono.indexOf(Collections.max(list_chrono));

        //creer les repetition des chronos
        for(int i = 0; i < list_chrono.size(); i++)
        {
            if(list_chrono.get(i) == list_chrono.get(minIndex))
            {
                indice_chrono_min_repetition.add(i);
            }
        }

        if (indice_chrono_min_repetition.size() == 1) //si pas de repetition
        {
            //min index garde sa valeur
        }
        else //on creer un test de une question chacun entre les joueurs de même score minimal et même chrono
        {
            System.out.println("\nIl y égalité de score et de chrono entre plusieurs joueurs, on va les départager en leurs posant 3 questions aléatoire :");

            List<Joueur> joueurList_int = new ArrayList<>();
            for(int i : indice_chrono_min_repetition)
            {
                joueurList_int.add(joueurs.getJoueurs().get(indice_score_min_repetition.get(indice_chrono_min_repetition.get(i))));
            }

            System.out.println(joueurList_int);

            List<Integer> list_score_int = new ArrayList<>(); //tableau de scores des joueurs de la phase
            List<Integer> indice_score_min_repetition_int = new ArrayList<>(); //tableau des indices des joueurs qui ont un score minimum
            List<Long> list_chrono_int = new ArrayList<>(); //tableau des chronos des joueurs qui ont un score minimum
            List<Integer> indice_chrono_min_repetition_int = new ArrayList<>();

            for (int i = 0; i < joueurList_int.size(); i++) //on pose une question par joueur_int
            {
                Joueur joueur = joueurList_int.get(i);
                Question question = questions.selection(1);

                poser_question(joueur, question);

                Scanner scanner = new Scanner(System.in);

                joueur.getChrono().start();
                String reponse = scanner.next();
                joueur.getChrono().stop();

                Jeu.sortir(reponse);

                test_reponse(joueur, question, reponse);
                joueur.setEtat("répondu");
            }

            for(Joueur joueur : joueurList_int)
            {
                list_score_int.add(joueur.getScore());
            }

            int minIndex_int = list_score_int.indexOf(Collections.min(list_score_int));

            System.out.println(minIndex_int);

            for(int i = 0; i < list_score_int.size(); i++)
            {
                if(list_score_int.get(i) == list_score_int.get(minIndex_int))
                {
                    indice_score_min_repetition_int.add(i);
                }
            }

            for(int i : indice_score_min_repetition_int)
            {
                list_chrono_int.add(joueurList_int.get(i).getChrono().getDureeMs());
            }

            minIndex_int = list_chrono_int.indexOf(Collections.max(list_chrono_int));

            for(int i = 0; i < list_chrono_int.size(); i++)
            {
                if(list_chrono_int.get(i) == list_chrono_int.get(minIndex))
                {
                    indice_chrono_min_repetition_int.add(i);
                }
            }

            if (indice_chrono_min_repetition_int.size() == 1)
            {
                //minç_index_test_garde sa valeur
            }
            else
            {
              System.out.println("A faire");
            }
        }

        //score max
        int maxIndex = 0;

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
         */

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
        System.out.println("\nPhase 1 :");

        selectionner_joueur();
        System.out.println(joueurs);

        question_reponse();

        determiner_gagant_et_elimine();

        remise_a_zero_chrono();
        return null;
    }

    public Joueur deroulement_phase_IA() {
        System.out.println("\nPhase 1 :");

        selectionner_joueur();
        System.out.println(joueurs);

        question_reponse_IA();

        determiner_gagant_et_elimine();

        remise_a_zero_chrono();
        return null;
    }

    @Override
    public Joueur deroulement_phase_grand_jeu() {
        return null;
    }
}
