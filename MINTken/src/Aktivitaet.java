/**
 * Die Klasse repraesentiert eine Aktivitaet der Anforderungsfelder I-III, welche
 * zum Erfuellen eines Anforderungsfelds, ferner, bei mehreren Aktivitaeten, 
 * dem MINT-Zertifikat benoetigt wird.
 * @author Joana Bergsiek
 * @version 1.1
 */
public class Aktivitaet {
    
    //Eigenschaften einer Aktivitaet
    
    private String name;
    private int niveau;
    private boolean istWettbewerb;
    private boolean erfuellt;
    private int[] hatNiveaus;
    private String[] anforderungen;
    
    //Konstruktore
    /**
     * Eine leere Aktivitaet deren Parameter noch nicht initialisiert wurden.
     */
    public Aktivitaet() {
    }
    
    
    /**
     * Erstellt eine noch nicht erfuellte Aktivitaet.
     * @param name Der Name der einzufuegenden Aktivitaet.
     * @param istWettbewerb Ist die Aktivitaet ein Wettbewerb oder eine Lernveranstaltung? false = Lernveranstaltung; true = Wettbewerb
     * @param anforderungen Welche Anforderungen fuer die jeweilige Stufe erfuellt werden muessen von 1 aufwaerts
     */
    public Aktivitaet(String name, boolean istWettbewerb, String[] anforderungen) {
        this.name = name;
        this.istWettbewerb = istWettbewerb;
        this.anforderungen = anforderungen;
        niveau = 0;
        erfuellt = false;
        hatNiveaus = new int[] {1,2,3};
    }
    
    
    //Sondierende Methoden
    
    public String getName() {
        return name;
    }

    public int getNiveau() {
        return niveau;
    }

    public boolean isIstWettbewerb() {
        return istWettbewerb;
    }

    public boolean isErfuellt() {
        return erfuellt;
    }

    public int[] getHatNiveaus() {
        return hatNiveaus;
    }

    public String getAnforderung(int anforderungsnummer) {
        return anforderungen[anforderungsnummer];
    }
    
    
    //Veraendernde Methoden
    
    public void setName(String name) {
        this.name = name;
    }

    public void setNiveau(int niveau) {
        this.niveau = niveau;
    }

    public void setIstWettbewerb(boolean istWettbewerb) {
        this.istWettbewerb = istWettbewerb;
    }

    public void setErfuellt(boolean erfuellt) {
        this.erfuellt = erfuellt;
    }

    public void setHatNiveaus(int[] hatNiveaus) {
        this.hatNiveaus = hatNiveaus;
    }

    public void setAnforderungen(String[] anforderungen) {
        this.anforderungen = anforderungen;
    }
    
    
}
