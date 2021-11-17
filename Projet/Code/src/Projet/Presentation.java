package Projet;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.Scanner;

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

        ajout_nouveau_themes();

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

        questions.setInd_question(new Random().nextInt(questions.getMat_questions().get(this.themes.getInd_theme()).size())); //initialisation pour la phase1
    }

    public void initialisation_jeu_grand_jeu()
    {
        //Creer la liste des 20 joueurs
        joueurs = new Joueurs("GJ");

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

        questions.setInd_question(new Random().nextInt(questions.getMat_questions().get(this.themes.getInd_theme()).size())); //initialisation pour la phase1
    }

    public void ajout_nouveau_themes()
    {
        System.out.println("\nEst ce que le maitre du jeu veux implémenter un nouveau thème ?"
                + "\n(y, n)");
        Scanner scanner = new Scanner(System.in);
        String str = scanner.next();
        Jeu.sortir(str);

        if(str.equals("y"))
        {
            System.out.println("\nQuel thème voulez vous implémenter ?");
            Scanner scanner1 = new Scanner(System.in);
            String theme = scanner1.next();
            Jeu.sortir(theme);
            themes.ajouter_theme(theme);
        }
        else if(str.equals("n"))
        {
        }
        else
        {
            System.out.println("Cette réponse n'existe pas");
            ajout_nouveau_themes();
        }

    }

    public void ajout_nouvelles_questions()
    {
        System.out.println("\nEst ce que le maitre du jeu veux implémenter une nouvelle question ?"
                + "\n(y, n)");
        Question question;
        Scanner scanner = new Scanner(System.in);
        String str = scanner.next();
        Jeu.sortir(str);

        if(str.equals("y"))
        {
            System.out.println("\nQuel type de question voulez vous implémenter ?"
                    + "\n(QCM, VF, RC)");
            Scanner scanner1 = new Scanner(System.in);
            String type = scanner1.next();
            Jeu.sortir(type);

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
                questions.ajout_question(question);
            }
            else
            {
                System.out.println("\nCe type de question n'existe pas");
                ajout_nouvelles_questions();
            }
        }
        else if(str.equals("n"))
        {
        }
        else
        {
            System.out.println("Cette réponse n'existe pas");
            ajout_nouvelles_questions();
        }
    }

    public Joueur deroulement_phase()
    {
        System.out.println("Bienvenue dans notre jeu !" + "\nPour sortir du jeu taper /fin/ à n'importe quel moment dans la console");
        initialisation_jeu();
        ajout_nouvelles_questions();
        System.out.println(joueurs);
        System.out.println(themes);
        System.out.println(questions);
        return null;
    }

    public Joueur deroulement_phase_grand_jeu()
    {
        initialisation_jeu_grand_jeu();
        return null;
    }

    @Override
    public Joueur deroulement_phase_IA() {
        return null;
    }
}
