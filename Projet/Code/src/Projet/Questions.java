package Projet;

import java.util.*;

class Questions { //faire tableaux en fct du theme
    private Themes themes;
    private List<LinkedList<Question>> mat_questions; //exception taille entre 5 et 10 à faire
    private int ind_question;

    //Constructeur
    public Questions(Themes themes) {
        this.themes = themes;
        mat_questions = new ArrayList<LinkedList<Question>>(); //Array car on va bcp se déplacer dans la liste des thèmes
        for (String theme : themes.getThemeList()) {
            mat_questions.add(new LinkedList<>()); //ajouter les lignes dans la matrice
        }
        //ind_question on l'instanci par default
    }

    //Getters
    public List<LinkedList<Question>> getMat_questions() {
        return mat_questions;
    }

    //Setters
    public void setInd_question(int ind_question) {
        this.ind_question = ind_question;
    }

    //Methodes
    public void ajout_question(Question question) {
        mat_questions.get(themes.selection_theme(question.getT())).add(question);
    }

    public void suppr_question(String theme, int i) {
        mat_questions.get(themes.selection_theme(theme)).remove(i);
    }

    public void suppr_theme(String theme) {
        mat_questions.remove(themes.selection_theme(theme));
        themes.suppr(theme);
    }

    public void selection_n_theme_saisie(int n) //
    {
        List<Integer> integerList = new LinkedList<>();
        List<Integer> integerList2 = new LinkedList<>();
        List<String> stringList = new LinkedList<>();
        Scanner scanner = new Scanner(System.in);
        System.out.println("\nSaisir 3 indices differents parmis :" + themes);

        for (int i = 0; i < n; i++) {
            String ind = scanner.next();
            Jeu.sortir((ind));
            integerList.add(Integer.parseInt(ind));
        }
        for (int i = 0; i < themes.getThemeList().size(); i++) {
            if (!integerList.contains(i)) {
                integerList2.add(i);
            }
        }
        for (int i : integerList2) {
            stringList.add(themes.getThemeList().get(i));
        }

        for (int i = 0; i < integerList2.size(); i++) {
            suppr_theme(stringList.get(i));
        }
    }

    public Question selection(int phase) {
        Question question = null;
        switch (phase) {
            case 1:
            case 3: {
                while (question == null) {
                    if (phase == mat_questions.get(themes.getInd_theme()).get(ind_question).getD()) //on selectionne la question avec la bonne difficulte
                    {
                        question = mat_questions.get(themes.getInd_theme()).get(ind_question); //selection question
                        setInd_question((ind_question + 1) % mat_questions.get(themes.getInd_theme()).size()); //on passe a la question suivante pour la selection de la question suivante
                    } else {
                        setInd_question((ind_question + 1) % mat_questions.get(themes.getInd_theme()).size()); //si la difficulté n'est pas la bonn e on avance dans la liste
                    }
                }
                break;
            }
            case 2: {
                List<String> stringList_select = themes.selection_n_theme(5); //on préselctionne 5 theme a chaque noiuvelle questions
                themes.selection_theme_saisie(stringList_select); //et le joueur en chosit 1
                setInd_question(new Random().nextInt(mat_questions.get(themes.getInd_theme()).size()));

                while (question == null) {
                    if (phase == mat_questions.get(themes.getInd_theme()).get(ind_question).getD()) {
                        question = mat_questions.get(themes.getInd_theme()).get(ind_question);
                        suppr_theme(themes.getThemeList().get(themes.getInd_theme()));
                    } else {
                        setInd_question((ind_question + 1) % mat_questions.get(themes.getInd_theme()).size());
                    }
                }
                break;
            }
            default: //pass
        }
        return question;
    }

    public Question selection_theme_phase2_IA()
    {
        Question question = null;
        List<String> stringList_select = themes.selection_n_theme(5); //on préselctionne 5 theme a chaque noiuvelle questions
        int ind = new Random().nextInt(stringList_select.size());
        themes.selection_theme_saisie_IA(stringList_select, ind); //et le joueur en chosit 1
        setInd_question(new Random().nextInt(mat_questions.get(themes.getInd_theme()).size()));
        System.out.println(ind);

        while (question == null) {
            if (2 == mat_questions.get(themes.getInd_theme()).get(ind_question).getD()) {
                question = mat_questions.get(themes.getInd_theme()).get(ind_question);
                suppr_theme(themes.getThemeList().get(themes.getInd_theme()));
            } else {
                setInd_question((ind_question + 1) % mat_questions.get(themes.getInd_theme()).size());
            }
        }
        return question;
    }

    @Override
    public String toString() {
        String str = "Listes des questions par thèmes :";

        for (LinkedList<Question> liste_question : mat_questions) {
            str += "\n" + themes.getThemeList().get(mat_questions.indexOf(liste_question)) + " :";
            for (Question question : liste_question) {
                str += "\n  - " + question;
            }
            str += "\n";
        }
        return str;
    }
}
