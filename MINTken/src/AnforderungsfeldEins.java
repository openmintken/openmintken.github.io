
/**
 * Anforderungsfeld I des MINT-Zertifikats.
 * @author Joana Bergsiek.
 * @version 1.3.2
 */
public class AnforderungsfeldEins extends Anforderungsfeld {
    
    /**
     * Ein noch unerfuelltes Anforderungsfeld mit den moeglichen Aktivitaeten, die man abschließen kann, ebenfalls noch nicht erfuellt.
     */
    public AnforderungsfeldEins() {
        //Initialisierung von erfuellbareAktivitaeten mit den 3 verfuegbaren Moeglichkeiten, dieses Anforderungsfeld zu erfuellen.
        //Alle Aktivitaeten sind mit einem EINDEUTIGEN Code von inklusive 1 - 50 zu versehen
        //Derzeit hoechster Code: 3
        this.erfuellbareAktivitaeten.add(new Aktivitaet("3 MINT-Fächer, davon mind. 1 Abiturfach auf erhöhtem Niveau", false, new String[]{"Mittelwert aller anzurechnender Kurse >= 9 Notenpunkte","Mittelwert aller anzurechnender Kurse >= 11 Notenpunkte","Mittelwert aller anzurechnender Kurse >= 13 Notenpunkte"},"001"));
        this.erfuellbareAktivitaeten.add(new Aktivitaet("2 MINT-Abiturfächer, 1 auf erhöhtem Niveau und 1 Grundkurs auf 4-Stunden-Basis", false, new String[]{"Mittelwert aller anzurechnender Kurse >= 9 Notenpunkte","Mittelwert aller anzurechnender Kurse >= 11 Notenpunkte","Mittelwert aller anzurechnender Kurse >= 13 Notenpunkte"},"002"));
        this.erfuellbareAktivitaeten.add(new Aktivitaet("2 MINT-Abiturfächer, 1 auf erhöhtem Niveau und Zusatzangebot im 2. wahrgenommen", false, new String[]{"Mittelwert aller anzurechnender Kurse >= 9 Notenpunkte","Mittelwert aller anzurechnender Kurse >= 11 Notenpunkte","Mittelwert aller anzurechnender Kurse >= 13 Notenpunkte"},"003"));
        
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
                return String.format(String.format("%10s", "") + "Für Stufe 1 fehlt die Erfüllung ("+ this.erfuellbareAktivitaeten.get(0).getAnforderung(0) +") einer der drei Aktivitäten:%n"
                        + String.format("%10s", "") + this.erfuellbareAktivitaeten.get(0).getName() +"%n"  // 3 Kurse mit einem LK
                        + String.format("%10s", "") + "ODER " + this.erfuellbareAktivitaeten.get(1).getName()+"%n" // 2 Kurse, 1 LK 
                        + String.format("%10s", "") + "ODER " + this.erfuellbareAktivitaeten.get(2).getName())+"%n"; // 2 Kurse, 1 LK und Zusatzangebot
                
            case 3:
                //Hoechste Stufe wurde erreicht.
                return String.format(String.format("%10s", "") + "Höchste Stufe wurde mit >=13 Notenpunkten erreicht durch " +this.erfuellteAktivitaeten.get(0).getName() + "%n"); 
            default:
                //Stufe 1 oder 2
                return String.format(String.format("%10s", "") + "Stufe " + this.zertifikatsstufe+ " wurde mit der Erfüllung von " +this.erfuellteAktivitaeten.get(0).getAnforderung(zertifikatsstufe-1) + " erreicht in " + this.erfuellteAktivitaeten.get(0).getName() +". %n"+String.format("%10s", "") +  "Zur nächsten Stufe fehlen 2 weitere Punkte.%n");
        }
    }
    
    
}
