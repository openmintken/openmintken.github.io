
/**
 * Anforderungsfeld II des MINT-Zertifikats.
 * @author Joana Bergsiek.
 * @version 1.0
 */
public class AnforderungsfeldZwei extends Anforderungsfeld {
    /**
     * Ein noch unerfuelltes Anforderungsfeld mit den moeglichen Aktivitaeten, die man abschließen kann, ebenfalls noch nicht erfuellt.
     */
    public AnforderungsfeldZwei() {
        //Initialisierung von erfuellbareAktivitaeten mit den 2 verfuegbaren Moeglichkeiten, dieses Anforderungsfeld zu erfuellen.
        this.erfuellbareAktivitaeten.add(new Aktivitaet("Fachwissenschaftliche Arbeit mit mind. 10 Seiten", false, new String[]{">= 9 Notenpunkte",">= 11 Notenpunkte",">= 13 Notenpunkte"}));
        this.erfuellbareAktivitaeten.add(new Aktivitaet("Wissenschaftspropädeutisches Fach",false, new String[]{">= 9 Notenpunkte",">= 11 Notenpunkte",">= 13 Notenpunkte"}));
        this.erfuellbareAktivitaeten.add(new Aktivitaet("Besondere Lernleistung", false, new String[]{">= 9 Notenpunkte",">= 11 Notenpunkte",">= 13 Notenpunkte"}));
        this.erfuellbareAktivitaeten.add(new Aktivitaet("Jugend forscht-Wettbewerb", true, new String[]{"Ernsthafte Teilnahme am Regionalwettbewerb","Preisträger im Regionalwettbewerb (keine Sonderpreise)","Teilnahme am Landes- oder Bundeswettbewerb"}));
        this.erfuellbareAktivitaeten.add(new Aktivitaet("Vergleichbarem Wettbewerb zu Jugend forscht",true, new String[]{"Ernsthafte Teilnahme am Regionalwettbewerb","Preisträger im Regionalwettbewerb (keine Sonderpreise)","Teilnahme am Landes- oder Bundeswettbewerb"}));
        
        
        this.fokus = "Fachwissenschaftliches Arbeiten im MINT-Bereich der SII";
    }
    
    /**
     * Gibt einen Text aus, was noch bis zur naechsten Zertifikatsstufe erreicht werden muss. Ggf. was die Person erledigt hat, wenn sie schon auf der hoechsten Stufe ist.
     * @return Beratungstext
     */
    @Override
    public String zurNaechstenStufe () { 
        aktualisieren();
        switch (this.zertifikatsstufe) {
            case 0:
                return "Für Stufe 1 fehlen >= 9 Notenpkt. entweder in einer fachwi. Arbeit mit mind. 10 Seiten, einem wissenschaftspropädeutischem Fach oder in einer besonderen Lernleistung.  Alternativ eine ernsthafte Teilnahme am Regionalwettbewerb bei einem Jugend forscht- oder vergleichbaren Wettbewerb.";
            case 3: 
                Aktivitaet referenz = this.erfuellteAktivitaeten.get(0);
                if (referenz.isIstWettbewerb() == true ) {
                    return "Höchste Stufe wurde mit einer Teilnahme am Landes- oder Bundeswettbewerb erreicht durch " + referenz.getName();
                } else {
                    return "Höchste Stufe wurde mit >= 13 Notenpunkten erreicht durch " + referenz.getName();
                }
            default: 
                Aktivitaet referenz2 = this.erfuellteAktivitaeten.get(0);
                return "Stufe " + this.zertifikatsstufe + " wurde mit der Erfüllung von " +referenz2.getAnforderung(zertifikatsstufe-1)+" in " +referenz2.getName() + " erreicht.  Zur nächsten Stufe muss folgendes erfüllt werden: " +referenz2.getAnforderung(zertifikatsstufe);
                
        }
    }
}
