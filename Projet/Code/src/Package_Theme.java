import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

class Themes
{
    private List<String> themeList;
    private int ind_theme;

    //Constructeur
    public Themes(List<String> themeList)
    {
        this.themeList = themeList;
        ind_theme = 0;
    }

    //Getters
    public List<String> getThemeList() {
        return themeList;
    }

    public int getInd_theme() {
        return ind_theme;
    }

    //Setters
    public void setInd_theme(int ind_theme) {
        this.ind_theme = ind_theme;
    }

    //Methode
    public int selection_theme(String new_theme) //gerer exception, theme exist pas dans la liste
    {
        for(String theme : themeList)
        {
            if(theme.equals(new_theme))
            {
                if(themeList.indexOf(theme) != ind_theme)
                {
                    setInd_theme(themeList.indexOf(theme));
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

        for(String theme : themeList)
        {
            if(theme.equals(new_theme))
            {
                if(themeList.indexOf(theme) != ind_theme)
                {
                    setInd_theme(themeList.indexOf(theme));
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
        themeList.remove(selection_theme(theme));
    }

    @Override
    public String toString()
    {
        String str = "Liste des thèmes :\n";
        for(String theme : themeList)
        {
            str += theme + ", Indice : " + themeList.indexOf(theme)
                    + "\n";
        }
        return str;
    }
}