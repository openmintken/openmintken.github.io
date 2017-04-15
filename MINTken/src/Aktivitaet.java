/**
 * Die Klasse repraesentiert eine Aktivitaet der Anforderungsfelder I-III, welche
 * zum Erfuellen eines Anforderungsfelds, ferner, bei mehreren Aktivitaeten, 
 * dem MINT-Zertifikat benoetigt wird.
 * @author Joana Bergsiek
 * @version 1.3
 */
public class Aktivitaet {
    
    //Eigenschaften einer Aktivitaet
    
    private String name;
    private int niveau;
    private boolean istWettbewerb;
    private boolean erfuellt;
    private String[] anforderungen;
    private boolean mehrfachWertbar;
    private String aktivitaetsID;
    private int erfuellbarFuer;
    
    //Konstruktore
    /**
     * Eine leere Aktivitaet deren Parameter noch nicht initialisiert wurden.
     */
    public Aktivitaet() {
    }
    
    /**
     * Eine vom Nutzer erstellbare A3-Aktivitaet. Alle uebrigen Wahrheitswertattribute werden auf true gesetzt, die Aktivitaet ist fuer SI und SII erfuellbar und es gibt nur eine Anforderung
     * @param name Der Name der einzufuegenden Aktivitaet.
     * @param niveau Das Niveau, in dem die Aktivitaet erfuellt wurde
     * @param anforderung Die Anforderung, die fuer das jeweilige Niveau erfuellt wurde
     */
    public Aktivitaet(String name, int niveau, String anforderung) {
        this.name = name;
        this.niveau = niveau;
        anforderungen = new String[] {"" , "" , ""};
        anforderungen[niveau-1] = anforderung;
        istWettbewerb = true;
        mehrfachWertbar = true;
        aktivitaetsID = "000";
        erfuellt = true;
        erfuellbarFuer = 3;
    }
    
    /**
     * Erstellt eine noch nicht erfuellte Aktivitaet des Andorderungsfelds 3.
     * @param name Der Name der einzufuegenden Aktivitaet.
     * @param istWettbewerb Ist die Aktivitaet ein Wettbewerb oder eine Lernveranstaltung? false = Lernveranstaltung; true = Wettbewerb
     * @param anforderungen Welche Anforderungen fuer die jeweilige Stufe erfuellt werden muessen von 1 aufwaerts
     * @param mehrfachWertbar Kann man die jeweilige Aktivitaet mehr als ein mal werten lassen? false = nein; true = ja
     * @param aktivitaetsID Einmalige ID der Aktivitaet. "001"-"050" fuer A1-Aktivitaeten; "051"-"100" fuer A2-Aktivitaeten; "101"-"999" fuer A3-Aktivitaeten; "000" fuer eine nutzererstellte Aktivitaet
     * @param erfuellbarFuer Wann die jeweilige Aktivitaet abgeschlossen werden kann. 1 = Aktivitaet ist nur in S1 erfuellbar; 2 = Aktivitaet ist nur in S2 erfuellbar; 3 = Aktivitaet ist in SI und SII erfuellbar
     */
    public Aktivitaet(String name, boolean istWettbewerb, String[] anforderungen, boolean mehrfachWertbar, String aktivitaetsID, int erfuellbarFuer) {
        this.name = name;
        this.istWettbewerb = istWettbewerb;
        this.anforderungen = anforderungen;
        this.mehrfachWertbar = mehrfachWertbar;
        this.aktivitaetsID = aktivitaetsID;
        this.erfuellbarFuer = erfuellbarFuer;
        niveau = 0;
        erfuellt = false;
    }
    
    /**
     * Erstellt eine noch nicht erfuellte Aktivitaet des Anforderungsfelds 1 oder 2.
     * @param name Der Name der einzufuegenden Aktivitaet.
     * @param istWettbewerb Ist die Aktivitaet ein Wettbewerb oder eine Lernveranstaltung? false = Lernveranstaltung; true = Wettbewerb
     * @param anforderungen Welche Anforderungen fuer die jeweilige Stufe erfuellt werden muessen von 1 aufwaerts
     * @param aktivitaetsID Einmalige ID der Aktivitaet. "001"-"050" fuer A1-Aktivitaeten; "051"-"100" fuer A2-Aktivitaeten; "101"-"999" fuer A3-Aktivitaeten; "000" fuer eine nutzererstellte Aktivitaet
     */
    public Aktivitaet(String name, boolean istWettbewerb, String[] anforderungen, String aktivitaetsID) {
        this.name = name;
        this.istWettbewerb = istWettbewerb;
        this.anforderungen = anforderungen;
        this.aktivitaetsID = aktivitaetsID;
        niveau = 0;
        erfuellt = false;
    }
    
    /**
     * Kopiert die jeweilige Aktivitaet des 3. Anforderungsfeldes
     * @return ein neu erstelltes Objekt aus den Paramatern des zu kopierenden Objekts
     */
    public Aktivitaet kopieren() {
        String kname =  this.getName();
        boolean kIstWett = this.isIstWettbewerb();
        String[] kAnforderungen = new String[3];
        kAnforderungen[0] = this.getAnforderung(0);
        kAnforderungen[1] = this.getAnforderung(1);
        kAnforderungen[2] = this.getAnforderung(2);
        boolean kMehrfach = this.isMehrfachWertbar();
        String kID = this.getAktivitaetsID();
        int kErf = this.getErfuellbarFuer();
        
        return new Aktivitaet(kname, kIstWett, kAnforderungen, kMehrfach, kID, kErf);
    }
    
    //Sondierende Methoden
    
    /**
     * @return den Namen der Aktivitaet
     */
    public String getName() {
        return name;
    }
    
    /**
     * @return das Niveau, in dem die Aktivitaet erfuellt wurde wobei 0 = nicht erfuellt
     */
    public int getNiveau() {
        return niveau;
    }
    
    /**
     * @return true wenn die Aktivitaet ein Wettbewerb ist, false wenn sie eine Lern- und Lehrveranstaltung ist
     */
    public boolean isIstWettbewerb() {
        return istWettbewerb;
    }
    
    /**
     * @return die einmalige ID der Aktivitaet wobei "001"-"050" fuer A1-Aktivitaeten; "051"-"100" fuer A2-Aktivitaeten; "101"-"999" fuer A3-Aktivitaeten; "000" fuer eine nutzererstellte Aktivitaet
     */
    public String getAktivitaetsID() {
        return aktivitaetsID;
    }
    
    /**
     *
     * @return wann die jeweilige Aktivitaet abgeschlossen werden kann. 1 = Aktivitaet ist nur in S1 erfuellbar; 2 = Aktivitaet ist nur in S2 erfuellbar; 3 = Aktivitaet ist in SI und SII erfuellbar 
     */

    public int getErfuellbarFuer() {
        return erfuellbarFuer;
    }

    /**
     *
     * @return true wenn die Aktivitaet mehrfach wertbar ist; false wenn nicht
     */

    public boolean isMehrfachWertbar() {
        return mehrfachWertbar;
    }
    
    /**
     * @return die Anforderung am pAnforderungsnummer. Index; 0 -> Niveau 1; 1 -> Niveau 2; 2 -> Niveau 3; gibt null aus, wenn pAnforderungsnummer nicht zwischen inklusive 0-2 entspricht.
     */
    public String getAnforderung(int pAnforderungsnummer) {
        if ( pAnforderungsnummer < 0 || pAnforderungsnummer > 2) {
            return null;
        }
        return anforderungen[pAnforderungsnummer];
    }
    
    
    //Veraendernde Methoden
    
    /**
     *
     * @param name Der Name der einzufuegenden Aktivitaet.
     */

    public void setName(String name) {
        this.name = name;
    }

    /**
     *
     * @param niveau In welchem Niveau sich die Aktivitaet befindet wobei 0 = nicht erfuellt
     * Falls niveau nicht zwischen inklusive 0-3 ist, aendert sich nichts
     */
    public void setNiveau(int niveau) {
        if (niveau < 0 || niveau > 3) {
        
        } else {
            this.niveau = niveau;
        }
    }

    /**
     *
     * @param istWettbewerb Ist die Aktivitaet ein Wettbewerb oder eine Lernveranstaltung? false = Lernveranstaltung; true = Wettbewerb
     */
    public void setIstWettbewerb(boolean istWettbewerb) {
        this.istWettbewerb = istWettbewerb;
    }

    /**
     *
     * @param erfuellt true wenn die Aktivitaet erfuellt wurde; false wenn sie noch erfuellt werden muss
     */
    public void setErfuellt(boolean erfuellt) {
        this.erfuellt = erfuellt;
    }

    /**
     *
     * @param anforderungen Welche Anforderungen fuer die jeweilige Stufe erfuellt werden muessen von 1 aufwaerts
     * Aendert nichts, wenn der Array nicht gleich 3 Felder hat
     */
    public void setAnforderungen(String[] anforderungen) {
        if (anforderungen.length != 3) {
        
        } else {
            this.anforderungen = anforderungen;
        }
    }

    /**
     *
     * @param mehrfachWertbar Kann man die jeweilige Aktivitaet mehr als ein mal werten lassen? false = nein; true = ja
     */
    public void setMehrfachWertbar(boolean mehrfachWertbar) {
        this.mehrfachWertbar = mehrfachWertbar;
    }

    /**
     *
     * @param aktivitaetsID Einmalige ID der Aktivitaet. "001"-"050" fuer A1-Aktivitaeten; "051"-"100" fuer A2-Aktivitaeten; "101"-"999" fuer A3-Aktivitaeten; "000" fuer eine nutzererstellte Aktivitaet
     * Aendert nichts, wenn die Laenge des Strings nicht gleich 3 ist
     */
    public void setAktivitaetsID(String aktivitaetsID) {
        if (aktivitaetsID.length() != 3) {
        
        } else {
            this.aktivitaetsID = aktivitaetsID;
        }
    }

    /**
     *
     * @param erfuellbarFuer Wann die jeweilige Aktivitaet abgeschlossen werden kann. 1 = Aktivitaet ist nur in S1 erfuellbar; 2 = Aktivitaet ist nur in S2 erfuellbar; 3 = Aktivitaet ist in SI und SII erfuellbar
     * Aendert nichts, wenn erfuellbarFuer nicht zwischen inklusive 1-3 liegt
     */
    public void setErfuellbarFuer(int erfuellbarFuer) {
        if (erfuellbarFuer < 1 || erfuellbarFuer > 3) {
        
        } else {
            this.erfuellbarFuer = erfuellbarFuer;
        }
    }
    
    
}
