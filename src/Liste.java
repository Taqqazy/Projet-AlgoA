/**
 * Liste
 */
public class Liste {

    private boolean vide;
    private Arbre tete;
    private Liste reste;

    public Liste() {
        this.vide = true;
    }

    public Liste(Arbre tete) {
        this.vide = false;
        this.tete = tete;
        this.reste = new Liste();
    }

    public boolean isVide() {
        return vide;
    }

    public Arbre getTete() {
        return tete;
    }

    public Liste getReste() {
        return reste;
    }
}