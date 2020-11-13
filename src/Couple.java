/**
 * Arbre
 */
public class Couple {
    private String code;
    private char caractere;

    public Couple(char caractere, String code) {
        this.code = code;
        this.caractere = caractere;
    }

    public char getCaractere() {
		return caractere;
	}

    public String getCode() {
        return code;
    }
    @Override
	public String toString() {
        return "'" + caractere + "'" + "\t" + code + "\n";
    }
}