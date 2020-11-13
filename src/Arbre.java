import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

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
    /* fonction qui redirige vers la fonction récursive codageChar avec en paramètres un ArrayList vide et un String vide
    la fonction retourne un ArrayList*/
    public ArrayList<Couple> codageLettres() {
        ArrayList<Couple> tab = new ArrayList<Couple>();
        String code = "";
        codageChar(tab, code);
        return tab;
    }
    /* fonction qui prend en paramètres un ArrayList vide et un String vide et qui calcule pour chaque lettre le code correspondant*/
    private void codageChar(ArrayList<Couple> tab, String code) {
        if (this.filsGauche.vide && this.filsDroit.vide) {
            tab.add(new Couple(this.lettre, code));
        }
        if (!this.filsGauche.vide) {
            this.filsGauche.codageChar(tab, code + "0");
        }
        if (!this.filsDroit.vide) {
            this.filsDroit.codageChar(tab, code + "1");
        }
    }
    /* fonction qui prend en paramètre le chemin d'un texte à coder et qui calcule le texte codé grâce à la fonction codageLettres
    la fonction renvoie le texte codé*/
    public String codageTexte(String filePath) throws IOException {
        String tempString = "";
        ArrayList<Couple> tempCodes = codageLettres();

        File file = new File(filePath);

        BufferedReader reader = new BufferedReader(new FileReader(file));
        String ligne;

        while ((ligne = reader.readLine()) != null) {
            for (int i = 0; i < ligne.length(); i++) {
                for (int j = 0; j < tempCodes.size(); j++) {
                    if (ligne.charAt(i) == tempCodes.get(j).getCaractere()) {
                        tempString += tempCodes.get(j).getCode();
                        break;
                    }
                }
            }
        }
        reader.close();
        return tempString;
    }
    /* fonction qui prend en paramètre le texte codé et retrouve pour chaque code le caractère associé en suivant le code
    fonction retourne le texte décodé*/
    public String decodageTexte(String texteCode) {
        String tempString = "";
        Arbre arbre = this;
        for (int i = 0; i < texteCode.length(); i++) {
            if (texteCode.charAt(i) == '0') {
                arbre = arbre.filsGauche;
            }
            else arbre = arbre.filsDroit;

            if (arbre.filsGauche.vide && arbre.filsDroit.vide) {
                tempString += arbre.lettre;
                arbre = this;
            }
        }
        return tempString;
    }
}