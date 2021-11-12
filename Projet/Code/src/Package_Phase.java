import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.Scanner;

interface Phase
{
    //public abstract void selectionner_joueur();

    public abstract Joueurs getJoueurs();
    public abstract Themes getThemes();
    public abstract Questions getQuestions();

    public abstract Joueur deroulement_phase();
}

class Presentation implements Phase
{
    private Joueurs joueurs;
    private Themes themes;
    private Questions questions;

    //Constructeurs
    public Presentation() {}

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

    public void selectionner_joueur() {}

    public void initialisation_jeu()
    {
        //Creer la liste des 20 joueurs
        joueurs = new Joueurs();

        //4, 1, 2

        //Creer la liste des themes
        List<String> themeList = new ArrayList<>();
        themeList.add("Animaux");
        themeList.add("Sport");
        themeList.add("Voiture");
        themeList.add("Histoire");
        themeList.add("Français");
        themeList.add("Cinema");
        themeList.add("Géographie");
        themeList.add("Corps humain");
        themeList.add("Faits divers");
        themeList.add("Jeux vidéos");

        themes = new Themes(themeList);

        //Creer la liste des questions
        Question question0 = new VF("Animaux", 1, "Les chauves-souris sont les seuls mammifères qui peuvent voler", "true");
        Question question1 = new QCM("Animaux", 1, "Qui est le cheval de lucky luke ?", "Wolly wopper", "Dalton", "Jolly jumper", "Jolly jumper");
        Question question2 = new VF("Animaux", 1, "Les rongeurs communiquent souvent à l’aide de vibrations", "true");
        Question question3 = new RC("Animaux", 1, "Quel mammifère marin est un cousin de l'éléphant ?", "Le lamantin");
        Question question4 = new QCM("Animaux", 2, "Quel est le plus grand mammifère marin de la planète ?", "Le requin", "La tortue", "La baleine", "La baleine");
        Question question5 = new RC("Animaux", 3, "Que mange le gorille ?", "Des plantes");
        Question question6 = new VF("Animaux", 3, "Le diable de Tasmanie vient d'Australie", "true");

        Question question7 = new VF("Sport", 1, "Tony Parker est considéré comme le meilleur joueur de basket-ball de tous les temps", "false");
        Question question8 = new QCM("Sport", 1, "Combien de joueurs composent une équipe de rugby ?", "5", "10", "15", "15");
        Question question9 = new VF("Sport", 1, "le volley-ball a était inventé au japon", "false");
        Question question10 = new RC("Sport", 1, "Quel mammifère marin est un cousin de l'éléphant ?", "Le lamantin");
        Question question11 = new QCM("Sport", 2, "Quel est le plus grand mammifère marin de la planète ?", "Le requin", "La tortue", "La baleine", "La baleine");
        Question question12 = new RC("Sport", 3, "Que mange le gorille ?", "Des plantes");
        Question question13 = new VF("Sport", 3, "Le diable de Tasmanie vient d'Australie", "true");

        Question question14 = new VF("Voiture", 1, "Les chauves-souris sont les seuls mammifères qui peuvent voler", "true");
        Question question15 = new QCM("Voiture", 1, "Qui est le cheval de lucky luke ?", "Wolly wopper", "Dalton", "Jolly jumper", "Jolly jumper");
        Question question16 = new VF("Voiture", 1, "Les rongeurs communiquent souvent à l’aide de vibrations", "true");
        Question question17 = new RC("Voiture", 1, "Quel mammifère marin est un cousin de l'éléphant ?", "Le lamantin");
        Question question18 = new QCM("Voiture", 2, "Quel est le plus grand mammifère marin de la planète ?", "Le requin", "La tortue", "La baleine", "La baleine");
        Question question19 = new RC("Voiture", 3, "Que mange le gorille ?", "Des plantes");
        Question question20 = new VF("Voiture", 3, "Le diable de Tasmanie vient d'Australie", "true");

        Question question21 = new VF("Histoire", 1, "Les chauves-souris sont les seuls mammifères qui peuvent voler", "true");
        Question question22 = new QCM("Histoire", 1, "Qui est le cheval de lucky luke ?", "Wolly wopper", "Dalton", "Jolly jumper", "Jolly jumper");
        Question question23 = new VF("Histoire", 1, "Les rongeurs communiquent souvent à l’aide de vibrations", "true");
        Question question24 = new RC("Histoire", 1, "Quel mammifère marin est un cousin de l'éléphant ?", "Le lamantin");
        Question question25 = new QCM("Histoire", 2, "Quel est le plus grand mammifère marin de la planète ?", "Le requin", "La tortue", "La baleine", "La baleine");
        Question question26 = new RC("Histoire", 3, "Que mange le gorille ?", "Des plantes");
        Question question27 = new VF("Histoire", 3, "Le diable de Tasmanie vient d'Australie", "true");

        Question question28 = new VF("Français", 1, "Les chauves-souris sont les seuls mammifères qui peuvent voler", "true");
        Question question29 = new QCM("Français", 1, "Qui est le cheval de lucky luke ?", "Wolly wopper", "Dalton", "Jolly jumper", "Jolly jumper");
        Question question30 = new VF("Français", 1, "Les rongeurs communiquent souvent à l’aide de vibrations", "true");
        Question question31 = new RC("Français", 1, "Quel mammifère marin est un cousin de l'éléphant ?", "Le lamantin");
        Question question32 = new QCM("Français", 2, "Quel est le plus grand mammifère marin de la planète ?", "Le requin", "La tortue", "La baleine", "La baleine");
        Question question33 = new RC("Français", 3, "Que mange le gorille ?", "Des plantes");
        Question question34 = new VF("Français", 3, "Le diable de Tasmanie vient d'Australie", "true");

        Question question35 = new VF("Cinema", 1, "Les chauves-souris sont les seuls mammifères qui peuvent voler", "true");
        Question question36 = new QCM("Cinema", 1, "Qui est le cheval de lucky luke ?", "Wolly wopper", "Dalton", "Jolly jumper", "Jolly jumper");
        Question question37 = new VF("Cinema", 1, "Les rongeurs communiquent souvent à l’aide de vibrations", "true");
        Question question38 = new RC("Cinema", 1, "Quel mammifère marin est un cousin de l'éléphant ?", "Le lamantin");
        Question question39 = new QCM("Cinema", 2, "Quel est le plus grand mammifère marin de la planète ?", "Le requin", "La tortue", "La baleine", "La baleine");
        Question question40 = new RC("Cinema", 3, "Que mange le gorille ?", "Des plantes");
        Question question41 = new VF("Cinema", 3, "Le diable de Tasmanie vient d'Australie", "true");

        Question question42 = new VF("Géographie", 1, "Les chauves-souris sont les seuls mammifères qui peuvent voler", "true");
        Question question43 = new QCM("Géographie", 1, "Qui est le cheval de lucky luke ?", "Wolly wopper", "Dalton", "Jolly jumper", "Jolly jumper");
        Question question44 = new VF("Géographie", 1, "Les rongeurs communiquent souvent à l’aide de vibrations", "true");
        Question question45 = new RC("Géographie", 1, "Quel mammifère marin est un cousin de l'éléphant ?", "Le lamantin");
        Question question46 = new QCM("Géographie", 2, "Quel est le plus grand mammifère marin de la planète ?", "Le requin", "La tortue", "La baleine", "La baleine");
        Question question47 = new RC("Géographie", 3, "Que mange le gorille ?", "Des plantes");
        Question question48 = new VF("Géographie", 3, "Le diable de Tasmanie vient d'Australie", "true");

        Question question49 = new VF("Corps humain", 1, "Les chauves-souris sont les seuls mammifères qui peuvent voler", "true");
        Question question50 = new QCM("Corps humain", 1, "Qui est le cheval de lucky luke ?", "Wolly wopper", "Dalton", "Jolly jumper", "Jolly jumper");
        Question question51 = new VF("Corps humain", 1, "Les rongeurs communiquent souvent à l’aide de vibrations", "true");
        Question question52 = new RC("Corps humain", 1, "Quel mammifère marin est un cousin de l'éléphant ?", "Le lamantin");
        Question question53 = new QCM("Corps humain", 2, "Quel est le plus grand mammifère marin de la planète ?", "Le requin", "La tortue", "La baleine", "La baleine");
        Question question54 = new RC("Corps humain", 3, "Que mange le gorille ?", "Des plantes");
        Question question55 = new VF("Corps humain", 3, "Le diable de Tasmanie vient d'Australie", "true");

        Question question56 = new VF("Faits divers", 1, "Les chauves-souris sont les seuls mammifères qui peuvent voler", "true");
        Question question57 = new QCM("Faits divers", 1, "Qui est le cheval de lucky luke ?", "Wolly wopper", "Dalton", "Jolly jumper", "Jolly jumper");
        Question question58 = new VF("Faits divers", 1, "Les rongeurs communiquent souvent à l’aide de vibrations", "true");
        Question question59 = new RC("Faits divers", 1, "Quel mammifère marin est un cousin de l'éléphant ?", "Le lamantin");
        Question question60 = new QCM("Faits divers", 2, "Quel est le plus grand mammifère marin de la planète ?", "Le requin", "La tortue", "La baleine", "La baleine");
        Question question61 = new RC("Faits divers", 3, "Que mange le gorille ?", "Des plantes");
        Question question62 = new VF("Faits divers", 3, "Le diable de Tasmanie vient d'Australie", "true");

        Question question63 = new VF("Jeux vidéos", 1, "Les chauves-souris sont les seuls mammifères qui peuvent voler", "true");
        Question question64 = new QCM("Jeux vidéos", 1, "Qui est le cheval de lucky luke ?", "Wolly wopper", "Dalton", "Jolly jumper", "Jolly jumper");
        Question question65 = new VF("Jeux vidéos", 1, "Les rongeurs communiquent souvent à l’aide de vibrations", "true");
        Question question66 = new RC("Jeux vidéos", 1, "Quel mammifère marin est un cousin de l'éléphant ?", "Le lamantin");
        Question question67 = new QCM("Jeux vidéos", 2, "Quel est le plus grand mammifère marin de la planète ?", "Le requin", "La tortue", "La baleine", "La baleine");
        Question question68 = new RC("Jeux vidéos", 3, "Que mange le gorille ?", "Des plantes");
        Question question69 = new VF("Jeux vidéos", 3, "Le diable de Tasmanie vient d'Australie", "true");

        /*
        Question question3 = new VF("Sport", 1, "Mazeazeaze ?", "true");
        Question question4 = new RC("Voiture", 1, "BOF", "TEST");
         */

        questions = new Questions(themes);

        questions.ajout_question(question0);
        questions.ajout_question(question1);
        questions.ajout_question(question2);
        questions.ajout_question(question3);
        questions.ajout_question(question4);
        questions.ajout_question(question5);
        questions.ajout_question(question6);
        questions.ajout_question(question7);
        questions.ajout_question(question8);
        questions.ajout_question(question9);
        questions.ajout_question(question10);
        questions.ajout_question(question11);
        questions.ajout_question(question12);
        questions.ajout_question(question13);
        questions.ajout_question(question14);
        questions.ajout_question(question15);
        questions.ajout_question(question16);
        questions.ajout_question(question17);
        questions.ajout_question(question18);
        questions.ajout_question(question19);
        questions.ajout_question(question20);
        questions.ajout_question(question21);
        questions.ajout_question(question22);
        questions.ajout_question(question23);
        questions.ajout_question(question24);
        questions.ajout_question(question25);
        questions.ajout_question(question26);
        questions.ajout_question(question27);
        questions.ajout_question(question28);
        questions.ajout_question(question29);
        questions.ajout_question(question30);
        questions.ajout_question(question31);
        questions.ajout_question(question32);
        questions.ajout_question(question33);
        questions.ajout_question(question34);
        questions.ajout_question(question35);
        questions.ajout_question(question36);
        questions.ajout_question(question37);
        questions.ajout_question(question38);
        questions.ajout_question(question39);
        questions.ajout_question(question40);
        questions.ajout_question(question41);
        questions.ajout_question(question42);
        questions.ajout_question(question43);
        questions.ajout_question(question44);
        questions.ajout_question(question45);
        questions.ajout_question(question46);
        questions.ajout_question(question47);
        questions.ajout_question(question48);
        questions.ajout_question(question49);
        questions.ajout_question(question50);
        questions.ajout_question(question51);
        questions.ajout_question(question52);
        questions.ajout_question(question53);
        questions.ajout_question(question54);
        questions.ajout_question(question55);
        questions.ajout_question(question56);
        questions.ajout_question(question57);
        questions.ajout_question(question58);
        questions.ajout_question(question59);
        questions.ajout_question(question60);
        questions.ajout_question(question61);
        questions.ajout_question(question62);
        questions.ajout_question(question63);
        questions.ajout_question(question64);
        questions.ajout_question(question65);
        questions.ajout_question(question66);
        questions.ajout_question(question67);
        questions.ajout_question(question68);
        questions.ajout_question(question69);

        questions.setInd_question(new Random().nextInt(questions.getMat_questions().get(this.themes.getInd_theme()).size()));
        /*
        questions.ajout_question(question3);
        questions.ajout_question(question4);
         */
    }

    public void ajout_nouvelles_questions()
    {
        System.out.println("\nEst ce que le maitre du jeu veux implémenter une nouvelle question ?"
                        + "\n(y, n)");
        Question question;
        Scanner scanner = new Scanner(System.in);
        String str = scanner.next();

        if(str.equals("y"))
        {
            System.out.println("\nQuel type de question voulez vous implémenter ?"
                            + "\n(QCM, VF, RC)");
            Scanner scanner1 = new Scanner(System.in);
            String type = scanner1.next();

            if(type.equals("QCM"))
            {
                question = new QCM();
                questions.ajout_question(question);
            }
            else if(type.equals("VF"))
            {
                question = new VF();
                questions.ajout_question(question);
            }
            else if(type.equals("RC"))
            {
                question = new RC();
            }
            else
            {
                System.out.println("\nCe type de question n'existe pas");
                ajout_nouvelles_questions();
            }
        }
    }

    public Joueur deroulement_phase()
    {
        System.out.println("Bienvenue dans notre jeu !");
        initialisation_jeu();
        ajout_nouvelles_questions();
        System.out.println(joueurs);
        System.out.println(themes);
        System.out.println(questions);
        return null;
    }
}

class Phase1 implements Phase
{
    private final int num_phase = 1;
    private Joueurs joueurs;
    private Themes themes;
    private Questions questions;

    //Constructeurs
    public Phase1(Phase phase)
    {
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
    public void selectionner_joueur()
    {
        joueurs.generer_ensemble_participants(4); //Générer les 4 joueurs
    }

    public void poser_question(Joueur joueur, Question question)
    {
        String str = "\nJoueur : " + joueur.getNom()
                +"\nRépondez à la question suivante : \n"
                + question;
        System.out.println(str);
    }

    public String reponse_question(Question question)
    {
        Scanner scanner = new Scanner(System.in);
        String reponse = scanner.next();

        return reponse;
    }

    public void test_reponse(Joueur joueur, Question question, String reponse)
    {
        if(question.getR().equals(reponse))
        {
            joueur.mise_a_jour_score(2);
            System.out.println("Réponse juste");
        }
        else
        {
            System.out.println("Réponse fausse");
        }
    }

    public void question_reponse()
    {
        for(int i = 0; i < joueurs.getJoueurs().size(); i++)
        {
            Joueur joueur = joueurs.getJoueurs().get(i);
            Question question = questions.selection(num_phase);

            poser_question(joueur, question);

            String reponse = reponse_question(question);

            test_reponse(joueur, question, reponse);
            joueur.setEtat("répondu");
        }
    }

    public void determiner_gagant_et_elimine()
    {
        int maxIndex = 0;
        int minIndex = 0;
        for(int i = 1; i < joueurs.getJoueurs().size(); i++)
        {
            if(joueurs.getJoueurs().get(i).getScore() > joueurs.getJoueurs().get(maxIndex).getScore())
            {
                maxIndex = i;
            }
        }
        for(int i = 1; i < joueurs.getJoueurs().size(); i++)
        {
            if(joueurs.getJoueurs().get(i).getScore() < joueurs.getJoueurs().get(maxIndex).getScore())
            {
                minIndex = i;
            }
        }

        joueurs.getJoueurs().get(maxIndex).changement_etat("super gagnant");
        joueurs.getJoueurs().get(minIndex).changement_etat("éliminé");

        for(Joueur joueur : joueurs.getJoueurs())
        {
            if(joueur.getEtat().equals("répondu"))
            {
                joueur.setEtat("gagnant");
            }
        }

        System.out.println(joueurs);
    }

    public Joueur deroulement_phase()
    {
        System.out.println("\nPhase 1 :");

        selectionner_joueur();
        System.out.println(joueurs);

        question_reponse();

        determiner_gagant_et_elimine();
        return null;
    }
}

class Phase2 implements Phase
{
    private final int num_phase = 2;
    private Joueurs joueurs;
    private Themes themes;
    private Questions questions;

    //Constructeurs
    public Phase2(Phase phase)
    {
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
    public void selectionner_joueur()
    {
        joueurs.generer_ensemble_participants(3); //Générer les 3 joueurs
    }

    public void poser_question(Joueur joueur, Question question)
    {
        String str = "\nRépondez à la question suivante : \n"
                + question;
        System.out.println(str);
    }

    public String reponse_question(Question question)
    {
        Scanner scanner = new Scanner(System.in);
        String reponse = scanner.next();
        return reponse;
    }

    public void test_reponse(Joueur joueur, Question question, String reponse)
    {
        if(question.getR().equals(reponse))
        {
            joueur.mise_a_jour_score(3);
            System.out.println("Réponse juste");
        }
        else
        {
            System.out.println("Réponse fausse");
        }
    }

    public void question_reponse(int nb_question_par_themes)
    {
        for (int j = 0; j < nb_question_par_themes; j++)
        {
            for (int i = 0; i < joueurs.getJoueurs().size(); i++) {
                Joueur joueur = joueurs.getJoueurs().get(i);
                System.out.println("\nJoueur : " + joueur.getNom());
                Question question = questions.selection(num_phase);

                poser_question(joueur, question);

                String reponse = reponse_question(question);

                test_reponse(joueur, question, reponse);
                joueur.setEtat("répondu");
            }
        }
    }

    public void determiner_gagant_et_elimine()
    {
        int maxIndex = 0;
        int minIndex = 0;
        for(int i = 1; i < joueurs.getJoueurs().size(); i++)
        {
            if(joueurs.getJoueurs().get(i).getScore() > joueurs.getJoueurs().get(maxIndex).getScore())
            {
                maxIndex = i;
            }
        }
        for(int i = 1; i < joueurs.getJoueurs().size(); i++)
        {
            if(joueurs.getJoueurs().get(i).getScore() < joueurs.getJoueurs().get(maxIndex).getScore())
            {
                minIndex = i;
            }
        }

        joueurs.getJoueurs().get(maxIndex).changement_etat("super gagnant");
        joueurs.getJoueurs().get(minIndex).changement_etat("éliminé");

        for(Joueur joueur : joueurs.getJoueurs())
        {
            if(joueur.getEtat().equals("répondu"))
            {
                joueur.setEtat("gagnant");
            }
        }

        System.out.println(joueurs);
    }

    public Joueur deroulement_phase()
    {
        System.out.println("\nPhase 2 :");

        selectionner_joueur();
        System.out.println(joueurs);

        question_reponse(2);

        determiner_gagant_et_elimine();
        return null;
    }
}

class Phase3 implements Phase
{
    private final int num_phase = 3;
    private Joueurs joueurs;
    private Themes themes;
    private Questions questions;

    //Constructeurs
    public Phase3(Phase phase)
    {
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
    public void selectionner_joueur()
    {
        joueurs.generer_ensemble_participants(2); //Générer les 3 joueurs
    }

    public void poser_question(Joueur joueur, Question question)
    {
        String str = "\nJoueur : " + joueur.getNom()
                +"\nRépondez à la question suivante : \n"
                + question;
        System.out.println(str);
    }

    public String reponse_question(Question question)
    {
        Scanner scanner = new Scanner(System.in);
        String reponse = scanner.next();
        return reponse;
    }

    public void test_reponse(Joueur joueur, Question question, String reponse)
    {
        if(question.getR().equals(reponse))
        {
            joueur.mise_a_jour_score(5);
            System.out.println("Réponse juste");
        }
        else
        {
            System.out.println("Réponse fausse");
        }
    }

    public void question_reponse(int nb_question_par_themes)
    {
        for(int k = 0; k < themes.getThemeList().size(); k++)
        {
            themes.setInd_theme(k);
            questions.setInd_question(new Random().nextInt(questions.getMat_questions().get(themes.getInd_theme()).size()));
            for (int j = 0; j < nb_question_par_themes; j++)
            {
                for (int i = 0; i < joueurs.getJoueurs().size(); i++)
                {
                    Joueur joueur = joueurs.getJoueurs().get(i);
                    Question question = questions.selection(num_phase);

                    poser_question(joueur, question);

                    String reponse = reponse_question(question);

                    test_reponse(joueur, question, reponse);
                    joueur.setEtat("répondu");
                }
            }
        }
    }

    public void determiner_gagant_et_elimine()
    {
        int maxIndex = 0;
        int minIndex = 0;
        for(int i = 1; i < joueurs.getJoueurs().size(); i++)
        {
            if(joueurs.getJoueurs().get(i).getScore() > joueurs.getJoueurs().get(maxIndex).getScore())
            {
                maxIndex = i;
            }
        }
        for(int i = 1; i < joueurs.getJoueurs().size(); i++)
        {
            if(joueurs.getJoueurs().get(i).getScore() < joueurs.getJoueurs().get(maxIndex).getScore())
            {
                minIndex = i;
            }
        }

        joueurs.getJoueurs().get(maxIndex).changement_etat("super gagnant");
        joueurs.getJoueurs().get(minIndex).changement_etat("éliminé");

        for(Joueur joueur : joueurs.getJoueurs())
        {
            if(joueur.getEtat().equals("répondu"))
            {
                joueur.setEtat("gagnant");
            }
        }

        System.out.println(joueurs);
    }

    public Joueur deroulement_phase()
    {
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

        return joueurs.getJoueurs().get(0);
    }
}
