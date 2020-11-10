/**
 * Arbre
 */
public class Arbre {

    private boolean vide;
    private char lettre;
    private int frequence;
    private Arbre filsGauche, filsDroit;

    public Arbre() {
        this.vide = true;
    }

    public Arbre(char lettre, int frequence) {
        this.vide = false;
        this.lettre = lettre;
        this.frequence = frequence;
        this.filsGauche = new Arbre();
        this.filsDroit = new Arbre();
    }

    public Arbre(int frequence) {
        this.vide = false;
        this.frequence = frequence;
        this.filsGauche = new Arbre();
        this.filsDroit = new Arbre();
    }

    public Arbre getFilsGauche() {
        return filsGauche;
    }

    public void setFilsGauche(Arbre filsGauche) {
        this.filsGauche = filsGauche;
    }

    public Arbre getFilsDroit() {
        return filsDroit;
    }

    public void setFilsDroit(Arbre filsDroit) {
        this.filsDroit = filsDroit;
    }

    public char getLettre() {
        return lettre;
    }

    public int getFrequence() {
        return frequence;
    }

    public boolean isVide() {
        return vide;
    }

}