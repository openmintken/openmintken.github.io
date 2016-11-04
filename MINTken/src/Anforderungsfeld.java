import java.util.ArrayList;

/**
 * Das "Grundgeruest" fuer die drei Anforderungsfelder; die Klasse definiert
 * ausschließlich das, was die Anforderungsfelder alle gemeinsam haben. 
 * Da es kein allgemeines Anforderungsfeld gibt, ist diese Klasse abstrakt. 
 * @author Joana Bergsiek
 * @version 1.0
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
    
    
    //Abstrakte Methode, deren Code je nach Anforderungsfeld variieren kann.

    /**
     * Gibt einen Text aus, was noch bis zur naechsten Zertifikatsstufe erreicht werden muss. Ggf. was die Person erledigt hat, wenn sie schon auf der hoechsten Stufe ist.
     * @return Beratungstext
     */
    public abstract String zurNaechstenStufe();
}
