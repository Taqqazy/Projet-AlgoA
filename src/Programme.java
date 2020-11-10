import java.io.IOException;

public class Programme {

    public static void main(String[] args) throws IOException {
        
        Liste liste = new Liste();
        liste = liste.insererFrequences("C:/Users/Tizba/Documents/AlgoA/Projet-AlgoA/input/freq.txt");
        Arbre arbreCodage = Liste.algoHuffman(liste);
    }


}
