
/**
 * Anforderungsfeld II des MINT-Zertifikats.
 * @author Joana Bergsiek.
 * @version 1.3.1
 */
public class AnforderungsfeldZwei extends Anforderungsfeld {
    /**
     * Ein noch unerfuelltes Anforderungsfeld mit den moeglichen Aktivitaeten, die man abschließen kann, ebenfalls noch nicht erfuellt.
     */
    public AnforderungsfeldZwei() {
        //Initialisierung von erfuellbareAktivitaeten mit den 2 verfuegbaren Moeglichkeiten, dieses Anforderungsfeld zu erfuellen.
        this.erfuellbareAktivitaeten.add(new Aktivitaet("Fachwissenschaftliche Arbeit mit mind. 10 Seiten", false, new String[]{">= 9 Notenpunkte",">= 11 Notenpunkte",">= 13 Notenpunkte"},"051"));
        this.erfuellbareAktivitaeten.add(new Aktivitaet("Wissenschaftspropädeutisches Fach",false, new String[]{">= 9 Notenpunkte",">= 11 Notenpunkte",">= 13 Notenpunkte"},"052"));
        this.erfuellbareAktivitaeten.add(new Aktivitaet("Besondere Lernleistung", false, new String[]{">= 9 Notenpunkte",">= 11 Notenpunkte",">= 13 Notenpunkte"},"053"));
        this.erfuellbareAktivitaeten.add(new Aktivitaet("Jugend forscht-Wettbewerb", true, new String[]{"Ernsthafte Teilnahme am Regionalwettbewerb","Preisträger im Regionalwettbewerb (keine Sonderpreise)","Teilnahme am Landes- oder Bundeswettbewerb"},"054"));
        this.erfuellbareAktivitaeten.add(new Aktivitaet("Vergleichbarem Wettbewerb zu Jugend forscht",true, new String[]{"Ernsthafte Teilnahme am Regionalwettbewerb","Preisträger im Regionalwettbewerb (keine Sonderpreise)","Teilnahme am Landes- oder Bundeswettbewerb"},"055"));
        
        
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
                return String.format(String.format("%10s", "") + "Für Stufe 1 fehlen >= 9 Notenpkt. entweder in einer fachwi. Arbeit mit mind. 10 Seiten, einem wissenschaftspropädeutischem Fach oder in einer besonderen Lernleistung. %n"+String.format("%10s", "") +  "Alternativ eine ernsthafte Teilnahme am Regionalwettbewerb bei einem Jugend forscht- oder vergleichbaren Wettbewerb.%n");
            case 3: 
                Aktivitaet referenz = this.erfuellteAktivitaeten.get(0);
                if (referenz.isIstWettbewerb() == true ) {
                    return String.format(String.format("%10s", "") + "Höchste Stufe wurde mit einer Teilnahme am Landes- oder Bundeswettbewerb erreicht durch " + referenz.getName()+"%n");
                } else {
                    return String.format(String.format("%10s", "") + "Höchste Stufe wurde mit >= 13 Notenpunkten erreicht durch " + referenz.getName()+"%n");
                }
            default: 
                Aktivitaet referenz2 = this.erfuellteAktivitaeten.get(0);
                return String.format(String.format("%10s", "") + "Stufe " + this.zertifikatsstufe + " wurde mit der Erfüllung von " +referenz2.getAnforderung(zertifikatsstufe-1)+" in " +referenz2.getName() + " erreicht. %n"+String.format("%10s", "") +  "Zur nächsten Stufe muss folgendes erfüllt werden: " +referenz2.getAnforderung(zertifikatsstufe)+"%n");
                
        }
    }
}
