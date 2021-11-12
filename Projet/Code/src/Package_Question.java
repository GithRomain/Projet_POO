import java.util.*;

abstract class Question
{
    private static int N = 0;
    private String T;
    private int D;
    private String Q;
    private String R;

    //Constructeurs
    public Question(String T, int D, String Q, String R)
    {
        this.T = T;
        this.D = D;
        this.Q = Q;
        this.R = R;
        N += 1; //incr N
    }

    public Question() {
        N += 1; //incr N
    }

    //Getters
    public int getN() {
        return N;
    }

    public String getT() {
        return T;
    }

    public int getD() {
        return D;
    }

    public String getD_String() {
        switch (D)
        {
            case 1:
            {
                return "Niveau facile";
            }
            case 2:
            {
                return "Niveau moyen";
            }
            case 3:
            {
                return "Niveau difficile";
            }
            default: return "Le niveau de difficulté rentré n'existe pas";
        }
    }

    public String getQ() {
        return Q;
    }

    public String getR() {
        return R;
    }

    //Setters
    public void setT(String t) {
        T = t;
    }

    public void setD(int d) {
        D = d;
    }

    public void setQ(String q) {
        Q = q;
    }

    public void setR(String r) {
        R = r;
    }

    //Méthodes
    public abstract void saisie_question();
    public abstract String toString();
}

class QCM extends Question
{
    private String C1, C2, C3;
    private int num;

    //Constructeurs
    public QCM(String T, int D, String Q, String C1, String C2, String C3, String R)
    {
        super(T, D, Q, R); //On incrémente N
        this.C1 = C1;
        this.C2 = C2;
        this.C3 = C3;
        num = getN();
    }

    public QCM() {
        super(); //On incrémente N
        num = getN();
        saisie_question();
    }

    //Getters

    //Setters
    public void setC1(String c1) {
        C1 = c1;
    }

    public void setC2(String c2) {
        C2 = c2;
    }

    public void setC3(String c3) {
        C3 = c3;
    }

    //Methodes
    public void saisie_question()
    {
        Scanner scanner = new Scanner(System.in);

        System.out.println("\n Saisie question QCM");
        System.out.println("(String) Saisir thème : ");
        String T = scanner.next();
        System.out.println("(int) Saisir niveau de difficulté : ");
        int D = scanner.nextInt();
        System.out.println("(String) Saisir question : ");
        String Q = scanner.nextLine();
        Q = scanner.nextLine();
        System.out.println("(String) Saisir choix 1 : ");
        String C1 = scanner.next();
        System.out.println("(String) Saisir choix 2 : ");
        String C2 = scanner.next();
        System.out.println("(String) Saisir choix 3 : ");
        String C3 = scanner.next();
        System.out.println("(String) Saisir reponse : ");
        String R = scanner.next();

        setT(T);
        setD(D);
        setQ(Q);
        setC1(C1);
        setC2(C2);
        setC3(C3);
        setR(R);
    }

    @Override
    public String toString() {
        return "Type : QCM, Numéro : " + num + ", Theme : " + getT() + ", Niveau de difficulté : " + getD_String() + ", Enoncé : " + getQ() + ", Réponses proposées : " + C1 + " ou " + C2 + " ou " + C3;
    }
}

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
        System.out.println("(int) Saisir niveau de difficulté : ");
        int D = scanner.nextInt();
        System.out.println("(String) Saisir question : ");
        String Q = scanner.nextLine();
        Q = scanner.nextLine();
        System.out.println("(Boolean) Saisir reponse : ");
        String R = scanner.next();

        setT(T);
        setD(D);
        setQ(Q);
        setR(R);
    }

    @Override
    public String toString() {
        return "Type : VF : Numéro : " + num + ", Theme : " + getT() + ", Niveau de difficulté : " + getD_String() + ", Enoncé : " + getQ() + ", Réponses proposées : " + "Vrai ou Faux";
    }
}

class RC extends Question
{
    private int num;

    //Constructeurs
    public RC(String T, int D, String Q, String R)
    {
        super(T, D, Q, R); //Augmenter N
        num = getN();
    }

    public RC() {
        super(); //Augmenter N
        num = getN();
        saisie_question();
    }

    //Getters

    //Setters

    //Methodes
    public void saisie_question()
    {
        Scanner scanner = new Scanner(System.in);

        System.out.println("\nSaisie question RC");
        System.out.println("(String) Saisir thème : ");
        String T = scanner.next();
        System.out.println("(int) Saisir niveau de difficulté : ");
        int D = scanner.nextInt();
        System.out.println("(String) Saisir question : ");
        String Q = scanner.nextLine();
        Q = scanner.nextLine();
        System.out.println("(String) Saisir reponse : ");
        String R = scanner.next();

        setT(T);
        setD(D);
        setQ(Q);
        setR(R);
    }

    @Override
    public String toString() {
        return "Type : RC, Numéro : " + num +", Theme : " + getT() + ", Niveau de difficulté : " + getD_String() + ", Enoncé : " + getQ();
    }
}

class Questions
{ //faire tableaux en fct du theme
    private Themes themes;
    private List<LinkedList<Question>> mat_questions; //exception taille entre 5 et 10 à faire
    private int ind_question;

    //Constructeur
    public Questions(Themes themes)
    {
        this.themes = themes;
        mat_questions = new ArrayList<LinkedList<Question>>();
        for(String theme : themes.getThemeList())
        {
            mat_questions.add(new LinkedList<>());
        }
        //ind_question = new Random().nextInt(mat_questions.get(this.themes.getInd_theme()).size()); deja init dans presentation
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
    public void ajout_question(Question question)
    {
        mat_questions.get(themes.selection_theme(question.getT())).add(question);
    }

    public void suppr_question(String theme, int i)
    {
        mat_questions.get(themes.selection_theme(theme)).remove(i);
    }

    public void suppr_theme(String theme)
    {
        mat_questions.remove(themes.selection_theme(theme));
        themes.suppr(theme);
    }

    public void selection_n_theme_saisie(int n)
    {
        List<Integer> integerList = new LinkedList<>();
        List<Integer> integerList2 = new LinkedList<>();
        List<String> stringList = new LinkedList<>();
        Scanner scanner = new Scanner(System.in);
        System.out.println("\nSaisir 3 indices differents parmis :" + themes);

        for(int i = 0; i < n; i++)
        {
            int ind = scanner.nextInt();
            integerList.add(ind);
        }
        for(int i = 0; i < themes.getThemeList().size(); i++)
        {
            if(!integerList.contains(i))
            {
                integerList2.add(i);
            }
        }
        for(int i : integerList2)
        {
            stringList.add(themes.getThemeList().get(i));
        }

        for(int i = 0; i < integerList2.size(); i++)
        {
            suppr_theme(stringList.get(i));
        }
    }

    public Question selection(int phase)
    {
        Question question = null;
        switch(phase)
        {
            case 1:
            {
                while (question == null)
                {
                    if (phase == mat_questions.get(themes.getInd_theme()).get(ind_question).getD())
                    {
                        question = mat_questions.get(themes.getInd_theme()).get(ind_question);
                        setInd_question((ind_question + 1) % mat_questions.get(themes.getInd_theme()).size());
                    }
                    else
                    {
                        setInd_question((ind_question + 1) % mat_questions.get(themes.getInd_theme()).size());
                    }
                }
                break;
            }
            case 2:
            {
                List<String> stringList_select = themes.selection_n_theme(5);
                themes.selection_theme_saisie(stringList_select);
                setInd_question(new Random().nextInt(mat_questions.get(themes.getInd_theme()).size()));

                while (question == null)
                {
                    if (phase == mat_questions.get(themes.getInd_theme()).get(ind_question).getD())
                    {
                        question = mat_questions.get(themes.getInd_theme()).get(ind_question);
                        suppr_theme(themes.getThemeList().get(themes.getInd_theme()));
                    }
                    else
                    {
                        setInd_question((ind_question + 1) % mat_questions.get(themes.getInd_theme()).size());
                    }
                }
                break;
            }
            case 3:
            {
                while (question == null)
                {
                    if (phase == mat_questions.get(themes.getInd_theme()).get(ind_question).getD())
                    {
                        question = mat_questions.get(themes.getInd_theme()).get(ind_question);
                        setInd_question((ind_question + 1) % mat_questions.get(themes.getInd_theme()).size());
                    }
                    else
                    {
                        setInd_question((ind_question + 1) % mat_questions.get(themes.getInd_theme()).size());
                    }
                }
                break;
            }
            default: //pass
        }
        return question;
    }

    @Override
    public String toString() {
        String str = "Listes des questions par thèmes :";

        for(LinkedList<Question> liste_question : mat_questions)
        {
            str += "\n" + themes.getThemeList().get(mat_questions.indexOf(liste_question)) + " :";
            for(Question question : liste_question)
            {
                str += "\n  - " + question;
            }
            str += "\n";
        }
        return str;
    }
}
