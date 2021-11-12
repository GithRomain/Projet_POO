import java.util.List;
import java.util.Scanner;

interface Phase
{
    public abstract Joueur selectionner_joueur();
    public abstract void poser_question(Joueur joueur, Question question);
    public abstract String reponse_question(Question question);
    public abstract void test_reponse(Joueur joueur, Question question, String reponse);
    public abstract void question_reponse(List<Question> questions_posees);
    public abstract void determiner_gagant_et_elimine();
    public abstract void deroulement_phase();
}

class Phase1 implements Phase
{
    private final int phase = 1;
    private Joueurs joueurs;
    private Themes themes;
    private Questions questions;

    //Constructeurs
    public Phase1(Joueurs joueurs, Themes themes, Questions questions)
    {
        this.joueurs = joueurs;
        this.themes = themes;
        this.questions = questions;
    }

    //Setters
    public void setJoueurs(Joueurs joueurs) {
        this.joueurs = joueurs;
    }

    public void setThemes(Themes themes) {
        this.themes = themes;
    }

    public void setQuestions(Questions questions) {
        this.questions = questions;
    }

    //Methodes
    public Joueur selectionner_joueur()
    {
        Joueur joueur = joueurs.selection_aleatoire_joueur();
        return joueur;
    }

    public void poser_question(Joueur joueur, Question question)
    {
        String str = "Joueur : " + joueur.getNom()
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

    public void question_reponse(List<Question> questions_posees)
    {
        for(int i = 0; i < joueurs.getJoueurs().size(); i++)
        {
            Joueur joueur = selectionner_joueur();
            Question question = questions_posees.get(i);
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
                minIndex = maxIndex;
            }
            else
            {
                maxIndex = minIndex;
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

    public void deroulement_phase()
    {
        joueurs.generer_ensemble_participants(); //Générer les 4 joueurs
        List<Question> questions_posees = questions.selection(phase); //générer les questions

        question_reponse(questions_posees);
        determiner_gagant_et_elimine();
    }
}
