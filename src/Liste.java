import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;

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

    public Liste prefixer(Arbre arbre) {
        Liste nouvListe = new Liste(arbre);
        nouvListe.reste = this;
        return nouvListe;
    }

    /* fonction qui prends un Arbre arbre en paramètre et qui insère cet arbre à sa place dans la liste en fonction de sa fréquence
    cette fonction renvoi une nouvelle Liste */
    public Liste insererOrd(Arbre arbre) {
        if (this.vide || arbre.getFrequence() <= this.tete.getFrequence()) {
            return this.prefixer(arbre);
        } else
            return this.reste.insererOrd(arbre).prefixer(this.tete);
    }

    /* fonction qui prends le chemin du fichier des fréquences en paramètre
    lis toutes les fréquences et les lettres associés dans le fichier et insere en ordre les arbres correspondants dans la liste
    une nouvelle liste est renvoyée */
    public Liste insererFrequences(String filePath) throws IOException {
        File file = new File(filePath);

        BufferedReader reader = new BufferedReader(new FileReader(file));
        String ligne;
        Liste liste = new Liste();

        while ((ligne = reader.readLine()) != null) {
            liste = liste.insererOrd(new Arbre(ligne.charAt(0), Integer.parseInt(ligne.substring(2))));
        }
        reader.close();
        return liste;
    }

    static public Arbre algoHuffman(Liste liste) {
        if(!liste.reste.vide) {
            Arbre arbre = new Arbre(liste.tete.getFrequence() + liste.reste.tete.getFrequence());
            arbre.setFilsGauche(liste.tete);
            arbre.setFilsDroit(liste.reste.tete);
            return Liste.algoHuffman(liste.reste.reste.insererOrd(arbre));
        }
        else return liste.tete;
    }
}