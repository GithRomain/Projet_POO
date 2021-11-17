package Projet;

import java.util.*;

class Joueurs
{
    private List<Joueur> joueurs;

    //Constructeurs
    public Joueurs()
    {
        joueurs = new ArrayList<>();
        int n = 20;
        int ind = 0;
        int numero = 100;

        System.out.println("\n(int) Combien de joueur en plus le maitre du jeu veut ajouter ?");
        Scanner scanner = new Scanner(System.in);
        int new_n = scanner.nextInt();
        Jeu.sortir(String.valueOf(new_n));
        n += new_n; //ajout de nouveaux joueurs aux 20 initials

        while (joueurs.size() != n)
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

    public Joueurs(String str)
    {
        joueurs = new ArrayList<>();
        int n = 20;
        int ind = 0;
        int numero = 100;

        while (joueurs.size() != n)
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
        if(joueurs.get(ind_alea).getEtat().equals("éliminé")) //si le joueur est éliminé, on garde son indice pour le supprimer
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
        List<Joueur> new_joueurs = new LinkedList<>();

        while (new_joueurs.size() != n)
        {
            int ind = selection_aleatoire_joueur();
            if(joueurs.get(ind).getEtat().equals("éliminé")) //si le joueur est éliminé, on le supprime
            {
                joueurs.remove(ind);
            }
            else {
                new_joueurs.add(joueurs.get(ind));
                joueurs.remove(ind); //pour ne pas le reselectionner
            }
        }
        setJoueurs(new_joueurs);
    }

    public List<Joueur> generer_ensemble_participants_grand_jeu(int n)
    {
        List<Joueur> new_joueurs = new LinkedList<>();

        while (new_joueurs.size() != n)
        {
            int ind = selection_aleatoire_joueur();
            if(joueurs.get(ind).getEtat().equals("éliminé")) //si le joueur est éliminé, on le supprime
            {
                joueurs.remove(ind);
            }
            else {
                new_joueurs.add(joueurs.get(ind));
                joueurs.remove(ind); //pour ne pas le reselectionner
            }
        }
        return new_joueurs;
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
