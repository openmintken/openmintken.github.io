
/**
 * Anforderungsfeld I des MINT-Zertifikats.
 * @author Joana Bergsiek.
 * @version 1.2
 */
public class AnforderungsfeldEins extends Anforderungsfeld {
    
    /**
     * Ein noch unerfuelltes Anforderungsfeld mit den moeglichen Aktivitaeten, die man abschließen kann, ebenfalls noch nicht erfuellt.
     */
    public AnforderungsfeldEins() {
        //Initialisierung von erfuellbareAktivitaeten mit den 2 verfuegbaren Moeglichkeiten, dieses Anforderungsfeld zu erfuellen.
        this.erfuellbareAktivitaeten.add(new Aktivitaet("2 Abiturfächer als Leistungskurse", false, new String[]{"Mittelwert aller anzurechnender Kurse >= 9 Notenpunkte","Mittelwert aller anzurechnender Kurse >= 11 Notenpunkte","Mittelwert aller anzurechnender Kurse >= 13 Notenpunkte"},"001"));
        this.erfuellbareAktivitaeten.add(new Aktivitaet("3 Kurse, davon mind. 1 Abiturfach als Leistungskurs", false, new String[]{"Mittelwert aller anzurechnender Kurse >= 9 Notenpunkte","Mittelwert aller anzurechnender Kurse >= 11 Notenpunkte","Mittelwert aller anzurechnender Kurse >= 13 Notenpunkte"},"002"));
    
        this.fokus = "Fachliche Kompetenz in den MINT-Fächern während der Qualifikationsphase";
    }
    
    /**
     * Gibt einen Text aus, was noch bis zur naechsten Zertifikatsstufe erreicht werden muss. Ggf. was die Person erledigt hat, wenn sie schon auf der hoechsten Stufe ist.
     * @return Beratungstext
     */
    @Override
    public String zurNaechstenStufe () {
        aktualisieren();
        //Erst werden die Randfaelle ueberprueft
        switch (this.zertifikatsstufe) {
            case 0:
                //Keine Aktivitaet wurde abgeschlossen
                return String.format(String.format("%10s", "") + "Für Stufe 1 fehlt die Erfüllung ("+ this.erfuellbareAktivitaeten.get(0).getAnforderung(0) +") einer der beiden Aktivitäten:%n"
                        + String.format("%10s", "") +this.erfuellbareAktivitaeten.get(0).getName() +"%n"  //2 LKs
                        + String.format("%10s", "") + "ODER " + this.erfuellbareAktivitaeten.get(1).getName())+"%n"; //1LK
                
            case 3:
                //Hoechste Stufe wurde erreicht.
                return String.format(String.format("%10s", "") + "Höchste Stufe wurde mit >=13 Notenpunkten erreicht durch " +this.erfuellteAktivitaeten.get(0).getName() + "%n"); 
            default:
                //Stufe 1 oder 2
                return String.format(String.format("%10s", "") + "Stufe " + this.zertifikatsstufe+ " wurde mit der Erfüllung von " +this.erfuellteAktivitaeten.get(0).getAnforderung(zertifikatsstufe-1) + " erreicht in " + this.erfuellteAktivitaeten.get(0).getName() +". %n"+String.format("%10s", "") +  "Zur nächsten Stufe fehlen 2 weitere Punkte.%n");
        }
    }
    
    
}
