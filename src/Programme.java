import java.io.IOException;
import java.util.ArrayList;

public class Programme {

    public static void main(String[] args) throws IOException {
        
        Liste liste = new Liste();
        // liste = liste.insererFrequences("C:/Users/Tizba/Documents/AlgoA/Projet-AlgoA/input/freq.txt");
        liste = liste.insererFrequences("/Users/los/Nextcloud/llecard/S3/ALGO. AVANCEE/Projet-AlgoA/input/freq.txt");

        Arbre arbreCodage = Liste.ListeVersArbreCodage(liste);

        ArrayList<Couple> tabCodes = arbreCodage.codageLettres();
        System.out.println("\nTableau de codage : \n\n" + tabCodes);

        String texteCode = arbreCodage.codageTexte("/Users/los/Nextcloud/llecard/S3/ALGO. AVANCEE/Projet-AlgoA/input/texteSE.txt");
        System.out.println("\nTexte codé : \n\n" + texteCode);
        
        String texteDecode = arbreCodage.decodageTexte(texteCode);
        System.out.println("\nTexte décodé : \n\n" + texteDecode);
    }
}
