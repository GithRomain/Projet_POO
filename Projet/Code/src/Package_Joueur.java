import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.Scanner;

class Joueur
{
    private int numero;
    private char nom;
    private int score;
    private String etat;

    //Constructeurs
    public Joueur(int numero, char nom, int score, String etat)
    {
        this.numero = numero;
        this.nom = nom;
        this.score = score;
        this.etat = etat;
    }
    //Getters
    public int getNumero() {
        return numero;
    }

    public char getNom() {
        return nom;
    }

    public String getEtat()
    {
        return etat;
    }

    public int getScore() {
        return score;
    }
    //Setters
    public void setNumero(int numero) {
        this.numero = numero;
    }

    public void setNom(char nom) {
        this.nom = nom;
    }

    public void setScore(int score) {
        this.score = score;
    }

    public void setEtat(String etat) {
        this.etat = etat;
    }

    //Methodes
    public void saisie_joueur()
    {
        Scanner scanner = new Scanner(System.in);

        System.out.println("\n Saisie Joueur");
        System.out.println("(int) Saisir numéro : ");
        int numero = scanner.nextInt();
        System.out.println("(char) Saisir nom : ");
        String nom = scanner.next();
        System.out.println("(int) Saisir score : ");
        int score = scanner.nextInt();
        System.out.println("(String) Saisir état : ");
        String etat = scanner.nextLine();
        etat = scanner.nextLine();

        setNumero(numero);
        setNom(nom.charAt(0));
        setScore(score);
        setEtat(etat);
    }

    public void mise_a_jour_score(int points)
    {
        setScore(score + points);
    }

    public void changement_etat(String etat)
    {
        setEtat(etat);
    }

    @Override
    public String toString() {
        return "Joueur : " + "numero : " + numero + ", nom : " + nom + ", score : " + score + ", etat : " + etat;
    }
}

class Joueurs
{
    private List<Joueur> joueurs;

    //Constructeurs
    public Joueurs()
    {
        joueurs = new ArrayList<>();
        int ind = 0;
        int numero = 100;
        while (joueurs.size() != 20)
        {
            char nom = (char) (ind + 'A');
            int score = 0;
            String etat = "en attente";

            Joueur joueur = new Joueur(numero, nom, score, etat);
            joueurs.add(joueur);

            ind += 1;
            numero += 10;
        }
    }

    //Getters
    public List<Joueur> getJoueurs() {
        return joueurs;
    }

    //Setters
    public void setJoueurs(List<Joueur> joueurs) {
        this.joueurs = joueurs;
    }

    //Methodes
    public int selection_aleatoire_joueur()
    {
        int ind_alea = new Random().nextInt(joueurs.size());
        if(joueurs.get(ind_alea).getEtat().equals("éliminé"))
        {
            return ind_alea;
        }
        else {
            joueurs.get(ind_alea).setEtat("sélectionné");
            return ind_alea;
        }
    }

    public void generer_ensemble_participants(int n)
    {
        List<Joueur> new_joueurs = new ArrayList<>();

        while (new_joueurs.size() != n)
        {
            int ind = selection_aleatoire_joueur();
            if(joueurs.get(ind).getEtat().equals("éliminé"))
            {
                joueurs.remove(ind);
            }
            else {
                new_joueurs.add(joueurs.get(ind));
                joueurs.remove(ind);
            }
        }
        setJoueurs(new_joueurs);
    }

    @Override
    public String toString() {
        String str = "\nListe des joueurs :";

        for(Joueur joueur : joueurs)
        {
            str += "\n" + joueur;
        }
        return str;
    }
}
