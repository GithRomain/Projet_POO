import java.util.*;

/*
class Questions extends Themes
{
    private List<Question> questionList; //exception taille entre 5 et 10 à faire
    private int ind_question;

    //Constructeur
    public Questions(List<String> themeList, int ind_theme, int ind_question) {
        super(themeList, ind_theme);
        questionList = new LinkedList<>();
        this.ind_question = ind_question;
    }

    //Getters

    //Setters

    //Methode
    public void ajout(Question question)
    {
        super.setInd_theme(super.selection_theme(question.getT()));
        questionList.add(question);
    }

    public void suppression_question(int ind_question)
    {
        questionList.remove(ind_question);
    }

    public void selection(int phase)
    {

    }

    public void afficher()
    {
        System.out.println(questionList);
    }

    @Override
    public String toString()
    {
        String str = "\nListe questions par thèmes :";

        for(String theme : super.getThemeList())
        {
            str += "\n" + theme;
            setInd_theme(selection_theme(theme));

            for(Question question : questionList)
            {
                str += "\n" + question;
            }
        }
        return str;
    }
}
 */

/*
class Themes
{
    private List<String> themes;
    private int ind_theme;

    //Constructeur
    public Themes(List<Theme> themeList, int ind_theme) {
        themes = new ArrayList<>();
        themes.add("Animaux");
        themes.add("Sport");
        themes.add("Histoire");
        this.ind_theme = -1;
    }

    //Getters
    public List<String> getThemes() {
        return themes;
    }

    public int getInd_theme() {
        return ind_theme;
    }

    //Setters
    public void setInd_theme(int ind_theme) {
        this.ind_theme = ind_theme;
    }

    //Methodes
    public int selection_theme(String new_theme) //gerer exception, theme exist pas dans la liste
    {
        for(String theme : themes)
        {
            if(theme.equals(new_theme))
            {
                if(themes.indexOf(theme) != ind_theme)
                {
                    setInd_theme(themes.indexOf(theme));
                }
            }

        }
        return ind_theme;
    }

    public int selection_theme_saisie() //gerer exception, theme exist pas dans la liste
    {
        Scanner scanner = new Scanner(System.in);
        System.out.println("(String) Saisir thème parmis :\n" + toString());
        String new_theme = scanner.next();

        for(String theme : themes)
        {
            if(theme.equals(new_theme))
            {
                if(themes.indexOf(theme) != ind_theme)
                {
                    setInd_theme(themes.indexOf(theme));
                }
                else
                {
                    System.out.println("Ce thème à était choisit par le candidat précédent, veuillez en choisir un autre");
                    selection_theme_saisie();
                }
            }

        }
        return ind_theme;
    }

    public List<Integer> selection_n_theme(int n) //exception
    {
        List<Integer> tab = new ArrayList<>();

        for(int i = 0; i < n; i++)
        {
            int ind = selection_theme_saisie();
            tab.add(ind);
        }
        return tab;
    }

    public void suppr(String theme)
    {
        themes.remove(selection_theme(theme));
    }

    @Override
    public String toString()
    {
        String str = "Liste des thèmes :\n";
        for(String theme : themes)
        {
            str += "Theme : " + theme + ", Indice : " + themes.indexOf(theme)
                    + "\n";
        }
        return str;
    }
}

 */

public class Main {
    public static void main(String[]args)
    {
        //Creer la liste des 20 joueurs
        Joueurs joueurs = new Joueurs();

        //Creer la liste des themes
        List<String> themeList = new ArrayList<>();
        themeList.add("Animaux");
        themeList.add("Sport");
        themeList.add("Voiture");

        Themes themes = new Themes(themeList);

        //Creer la liste des questions
        Question question0 = new VF("Animaux", 1, "Les chauves-souris sont les seuls mammifères qui peuvent voler", "true");
        Question question1 = new QCM("Animaux", 2, "Qui est le cheval de lucky luke ?", "Wolly wopper", "Dalton", "Jolly jumper", "Jolly jumper");
        Question question2 = new VF("Animaux", 2, "Les rongeurs communiquent souvent à l’aide de vibrations", "true");
        Question question3 = new VF("Sport", 1, "Mazeazeaze ?", "true");
        Question question4 = new RC("Voiture", 1, "BOF", "TEST");

        Questions questions = new Questions(themes);
        questions.ajout_question(question0);
        questions.ajout_question(question1);
        questions.ajout_question(question2);
        questions.ajout_question(question3);
        questions.ajout_question(question4);

        //Phase
        Phase phase1 = new Phase1(joueurs, themes, questions);
        phase1.deroulement_phase();

        System.out.println(joueurs);
    }
}
