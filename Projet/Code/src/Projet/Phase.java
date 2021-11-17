package Projet;

interface Phase {
    //public abstract void selectionner_joueur();

    public abstract Joueurs getJoueurs();

    public abstract Themes getThemes();

    public abstract Questions getQuestions();

    public abstract Joueur deroulement_phase();

    public abstract Joueur deroulement_phase_grand_jeu();

    public abstract Joueur deroulement_phase_IA();
}
