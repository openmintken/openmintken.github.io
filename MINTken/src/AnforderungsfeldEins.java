
/**
 * Anforderungsfeld I des MINT-Zertifikats.
 * @author Joana Bergsiek.
 * @version 1.0
 */
public class AnforderungsfeldEins extends Anforderungsfeld {
    
    /**
     * Ein noch unerfuelltes Anforderungsfeld mit den moeglichen Aktivitaeten, die man abschließen kann, ebenfalls noch nicht erfuellt.
     */
    public AnforderungsfeldEins() {
        //Initialisierung von erfuellbareAktivitaeten mit den 2 verfuegbaren Moeglichkeiten, dieses Anforderungsfeld zu erfuellen.
        this.erfuellbareAktivitaeten.add(new Aktivitaet("2 Abiturfächer auf erhöhtem Niveau mit >= 4 Wochenstunden bzw. 2 Leistungskurse", false, new String[]{"Mittelwert aller anzurechnender Kurse >= 9 Notenpunkte","Mittelwert aller anzurechnender Kurse >= 11 Notenpunkte","Mittelwert aller anzurechnender Kurse >= 13 Notenpunkte"}));
        this.erfuellbareAktivitaeten.add(new Aktivitaet("3 Kurse, davon mindestens 1 Abiturfach auf erhöhtem Niveau mit >= 4 Wochenstunden bzw  1 Leistungskurs jeweils durchgehend in der Qualifikationsphase belegt; alle anzurechnenden Kurse >= 5 Punkte", false, new String[]{"Mittelwert aller anzurechnender Kurse >= 9 Notenpunkte","Mittelwert aller anzurechnender Kurse >= 11 Notenpunkte","Mittelwert aller anzurechnender Kurse >= 13 Notenpunkte"}));
    
        this.fokus = "Fachliche Kompetenz in den MINT-Fächern der SII";
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
                return "Für Stufe 1 fehlt die Erfüllung ("+ this.erfuellbareAktivitaeten.get(0).getAnforderung(0) +") einer der beiden Aktivitäten:  " + this.erfuellbareAktivitaeten.get(0).getName() +  //2 LKs
                        "  ODER " + this.erfuellbareAktivitaeten.get(1).getName(); //1LK
            case 3:
                //Hoechste Stufe wurde erreicht.
                return "Höchste Stufe wurde mit >=13 Notenpunkten erreicht durch " +this.erfuellteAktivitaeten.get(0).getName(); 
            default:
                //Stufe 1 oder 2
                return "Stufe " + this.zertifikatsstufe+ " wurde mit der Erfüllung von " +this.erfuellteAktivitaeten.get(0).getAnforderung(zertifikatsstufe-1) + " erreicht in " + this.erfuellteAktivitaeten.get(0).getName() +".  Zur nächsten Stufe fehlen 2 weitere Punkte.";
        }
    }
    
    
}
