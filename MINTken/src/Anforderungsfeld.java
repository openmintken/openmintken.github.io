import java.util.ArrayList;

/**
 * Das "Grundgeruest" fuer die drei Anforderungsfelder; die Klasse definiert
 * ausschließlich das, was die Anforderungsfelder alle gemeinsam haben. 
 * Da es kein allgemeines Anforderungsfeld gibt, ist diese Klasse abstrakt. 
 * @author Joana Bergsiek
 * @version 1.3
 */
public abstract class Anforderungsfeld {
    
    //Damit die Methoden mitvererbt werden sind diese oeffentlich.
    //Die Paramater sind so initialisiert, dass ein erzeugtes Anforderungsfeld zunaechst leer ist.
    public String fokus;
    public int zertifikatsstufe = 0;
    public boolean istErfuelltEins = false;
    public boolean istErfuelltZwei = false;
    public boolean istErfuelltDrei = false ;
    //Die Aktivitaeten werde in einer Liste gespeichert, damit problemlos weitere Aktivitaeten einfach hinzugefuegt werden koennen ohne dass Fehler auftreten
    public ArrayList<Aktivitaet> erfuellbareAktivitaeten = new ArrayList<>();
    public ArrayList<Aktivitaet> erfuellteAktivitaeten = new ArrayList<>();
    
    //Sondierende Methoden
    public String getFokus() {
        return fokus;
    }

    public int getZertifikatsstufe() {
        aktualisieren();
        return zertifikatsstufe;
    }

    public ArrayList<Aktivitaet> getErfuellbareAktivitaeten() {
        aktualisieren();
        return erfuellbareAktivitaeten;
    }

    public ArrayList<Aktivitaet> getErfuellteAktivitaeten() {
        aktualisieren();
        return erfuellteAktivitaeten;
    }
    
    //Sonst.
    
    /**
    * Fuegt der Liste erfuellteAktivitaeten eine Aktivitaet hinzu.
    * @param erfuellt Die erfuellte Aktivitaet, die der Liste hinzugefuegt werden soll.
    * @param niveau Das Niveau, auf dem die Aktivitaet abgeschlossen wurde
    */
    public void aktivitaetErfuellt(Aktivitaet erfuellt, int niveau) {
        Aktivitaet taet = erfuellt;
        taet.setErfuellt(true);
        taet.setNiveau(niveau);
        erfuellteAktivitaeten.add(taet);
        aktualisieren();
    }
    
    /**
     * Fuegt der Liste erfuellteAktivitaeten eine Aktivitaet hinzu.
     * @param pCode Die Aktivitaet unter pCode, welche hinzugefuegt werden soll. 
     * Falls die Id eines Codes zu keiner Aktivitaet gehoert oder ungueltig ist wird nichts gemacht. 
     * Die ersten 3 Zahlen sind die AktivitaetsID.
     * Die 4. Zahl des Codes das erfuellte Niveau.
     */
    public void aktivitaetErfuellt (String pCode) {
        if (pCode.length() >= 4) { //Code gueltige Laenge?
            String aktivitaetsID = pCode.substring(0,3); 
            if (enthaeltID(aktivitaetsID)) { //Ist die 3-stellige ID einer Aktivitaet zugewiesen?
                int niveau =(int) Integer.valueOf(pCode.substring(3,4));
                Aktivitaet taet = erhalteAktivitaetUnterID(aktivitaetsID);
                aktivitaetErfuellt(taet, niveau);
            }
        }
    }
    
    
    /**
     * Aktualisiert die Parameter eines Anforderungsfeldes.
     */
    public void aktualisieren() {
        
        if (this.erfuellteAktivitaeten.isEmpty()) {
            //Mach nichts
        } else {
            this.zertifikatsstufe = this.erfuellteAktivitaeten.get(0).getNiveau();
            if (this.zertifikatsstufe >= 1) {
                this.istErfuelltEins = true;
            }
            if (this.zertifikatsstufe >= 2) {
                this.istErfuelltZwei = true;
            }
            if (this.zertifikatsstufe == 3) {
                this.istErfuelltDrei = true;
            }
            
        }
    }
    
    /**
     * Abfrage, ob es bereits eine Aktivitaet unter pID gibt.
     * @param pID Die zu ueberpruefende ID
     * @return true wenn eine Aktivitaet bereits pID enthaelt; false wenn nicht
     */
    public boolean enthaeltID(String pID) {
        for (int i=0; i<this.erfuellbareAktivitaeten.size(); i++) {
            if(this.erfuellbareAktivitaeten.get(i).getAktivitaetsID().equals(pID)) {
                return true;
            } 
        }
        return false;
    }
    
    /**
     * Gibt die Aktivitaet unter einer ID wieder, falls existend.
     * @param pID Die ID der Aktivitat, welche man haben will.
     * @return Die Aktivitaet unter pID; wenn es die Aktivitaet unter pID nicht gibt, dann null
     */
    public Aktivitaet erhalteAktivitaetUnterID(String pID) {
        for (int i=0; i<this.erfuellbareAktivitaeten.size(); i++) {
            if(this.erfuellbareAktivitaeten.get(i).getAktivitaetsID().equals(pID)) {
                return this.erfuellbareAktivitaeten.get(i);
            } 
        }
        return null;
    }
    
    
    //Abstrakte Methode, deren Code je nach Anforderungsfeld variieren kann.

    /**
     * Gibt einen Text aus, was noch bis zur naechsten Zertifikatsstufe erreicht werden muss. Ggf. was die Person erledigt hat, wenn sie schon auf der hoechsten Stufe ist.
     * @return Beratungstext
     */
    public abstract String zurNaechstenStufe();
}
