
import java.util.ArrayList;


/**
 * Anforderungsfeld III des MINT-Zertifikats.
 * @author Joana Bergsiek.
 * @version 1.3.2
 */
public class AnforderungsfeldDrei extends Anforderungsfeld {
    
    private int punkteS1;
    private int punkteS2;
    private int gesamtPunktzahl;
    private ArrayList<Aktivitaet> erfuellteAktivitaetenS1 = new ArrayList<>();
    private ArrayList<Aktivitaet> erfuellteAktivitaetenS2 = new ArrayList<>();
    
    public AnforderungsfeldDrei() {
        //Folgende Felder sind in der Reihenfolge geordnet, wie sie auch in den offiziellen Dokumenten angeorndet sind.
        //Alle Aktivitaeten sind mit einem EINDEUTIGEN Code von inklusive 101 - 999 zu versehen
        //Derzeit hoechster Code: 150
        
        //Falls noch nicht in Anforderungsfeld I oder II eingebracht (Implementiere dafuer eine Ueberpruefung in GUI als Fehlerabfang des Nutzers)
        this.erfuellbareAktivitaeten.add(new Aktivitaet("Fachwissenschaftliche Arbeit mit mindestens 10 Seiten (Falls noch nicht in Anforderungsfeld I oder II eingebracht)", false, new String[] {">= 9 Notenpunkte", ">= 11 Notenpunkte", ">= 13 Notenpunkte"},false, "101",2));
        this.erfuellbareAktivitaeten.add(new Aktivitaet("Besondere Lernleistung (Falls noch nicht in Anforderungsfeld I oder II eingebracht)", false, new String[] {">= 9 Notenpunkte", ">= 11 Notenpunkte", ">= 13 Notenpunkte"},false, "149",2));
        this.erfuellbareAktivitaeten.add(new Aktivitaet("Wissenschaftspropädeutisches Fach (Falls noch nicht in Anforderungsfeld I oder II eingebracht)", false, new String[] {"Mittelwert aller Kurshalbjahre >= 9 Notenpunkte","Mittelwert aller Kurshalbjahre >= 11 Notenpunkte","Mittelwert aller Kurshalbjahre >= 13 Notenpunkte"}, false,"102",2));
        this.erfuellbareAktivitaeten.add(new Aktivitaet("Zusätzlicher MINT-Kurs durchgängig in der Qualifikationsphase belegt (Falls noch nicht in Anforderungsfeld I oder II eingebracht)", false, new String[] {"Mittelwert aller Kurshalbjahre >= 9 Notenpunkte","Mittelwert aller Kurshalbjahre >= 11 Notenpunkte","Mittelwert aller Kurshalbjahre >= 13 Notenpunkte"}, false,"150",2));
        
        //Wettbewerbe
        this.erfuellbareAktivitaeten.add(new Aktivitaet("BundesUmwelt Wettbewerb", true, new String[] {"Urkunde", "Förder- oder Anerkennungspreis", "Haupt- oder Sonderpreis"},true, "103",3));
        this.erfuellbareAktivitaeten.add(new Aktivitaet("Bundeswettbewerb Informatik", true, new String[] {"ernsthafte Teilnahme", "Qualifikation für die 2. Runde", "Qualifikation für die 3. Runde"},true,"104",3));
        this.erfuellbareAktivitaeten.add(new Aktivitaet("Bundeswettbewerb Mathematik", true, new String[] {"1. Runde (ernsthafte Teilnahme)", "Qualifikation für die 2. Runde", "Qualifikation für die 3. Runde"},true,"105",3));
        this.erfuellbareAktivitaeten.add(new Aktivitaet("DECHEMAX", true, new String[] {"Qualifikation für die 2. Runde", "Sonderpreis / bestes Klassenstufenteam", "Siegerteam"},true, "106",3));
        this.erfuellbareAktivitaeten.add(new Aktivitaet("Dr. Hans-Riegel-Fachpreis", true, new String[] {"", "", "Preisträger"}, true, "107",3));
        this.erfuellbareAktivitaeten.add(new Aktivitaet("FIRST LEGO League", true, new String[] {"ernsthafte Teilnahme Regionalwettbewerb", "Preisträger Regionalwettbewerb", "Qualifikation Semi-Finals / Finale Zentraleuropa"},true,"108",3));
        this.erfuellbareAktivitaeten.add(new Aktivitaet("Formel 1 in der Schule", true, new String[] {"ernsthafte Teilnahme Landesmeisterschaft", "Preisträger Landesmeisterschaft", "Qualifikation Deutschlandfinale"},true,"109",3));
        this.erfuellbareAktivitaeten.add(new Aktivitaet("Heureka", true, new String[] {"ernsthafte Teilnahme Landesmeisterschaft", "Preisträger Landesmeisterschaft", "Qualifikation Deutschlandfinale"},true,"110",3));
        this.erfuellbareAktivitaeten.add(new Aktivitaet("Informatik-Biber", true, new String[] {"3 mal ernsthafte Teilnahme oder 3. Preis", "1. Preis oder 2. Preis",""},true,"111",3));
        this.erfuellbareAktivitaeten.add(new Aktivitaet("Internationale BiologieOlympiade", true, new String[] {"ernsthafte Teilnahme", "Qualifikation für die 2. Runde", "Qualifikation für die 3. Runde"},true,"112",3));
        this.erfuellbareAktivitaeten.add(new Aktivitaet("Internationale ChemieOlympiade", true, new String[] {"ernsthafte Teilnahme", "Qualifikation für die 2. Runde", "Qualifikation für die 3. Runde"},true,"113",3));
        this.erfuellbareAktivitaeten.add(new Aktivitaet("Internationaler Chemiewettbewerb", true, new String[] {"Certificate of Merit / Certificate of High Destination", "Certificate of Excellence",""},true, "114",3));
        this.erfuellbareAktivitaeten.add(new Aktivitaet("Internationale Junior Science Olympiade", true, new String[] {"ernsthafte Teilnahme", "Teilnahme am Quiz", "Qualifikation für die 2.Runde"},true, "115",3));
        this.erfuellbareAktivitaeten.add(new Aktivitaet("Internationale PhysikOlympiade", true, new String[] {"ernsthafte Teilnahme", "Qualifikation für die 2. Runde", "Qualifikation für die 3. Runde"},true,"116",3));
        this.erfuellbareAktivitaeten.add(new Aktivitaet("Jugend präsentiert", true, new String[] {"3 mal ernsthafte Teilnahme oder 3. Preis", "1. oder 2. Preis", ""},true,"117",3));
        this.erfuellbareAktivitaeten.add(new Aktivitaet("Känguru der Mathematik", true, new String[] {"3 mal ernsthafte Teilnahme oder 3. Preis", "1. Preis oder 2. Preis",""},true, "118",3));
        this.erfuellbareAktivitaeten.add(new Aktivitaet("Mathematik-Olympiade", true, new String[] {"3 ernsthafte Teilnahme an der Schulrunde", "Qualifikation für die Regionalrunde (Stadt/Kreis)", "Qualifikation für die Landesrunde oder Bundeswettbewerb"}, true, "119",3));
        this.erfuellbareAktivitaeten.add(new Aktivitaet("Mathe / Physik im Advent", true, new String[] {">= 21 korrekte Antworten bei einer Teilnahme", ">= 21 korrekte Antworten bei je 2 Teilnahmen", ""},true, "120",3));
        this.erfuellbareAktivitaeten.add(new Aktivitaet("MINT-EC SchoolSlam", true, new String[] {"ernsthafte Teilnahme", "Preisträger", ""},true,"121",3));
        this.erfuellbareAktivitaeten.add(new Aktivitaet("MNU-Bundeswettbewerb Physik", true, new String[] {"ernsthafte Teilnahme", "Qualifikation für die 2. Runde", "Qualifikation für die Bundesrunde"},true,"122",3));
        this.erfuellbareAktivitaeten.add(new Aktivitaet("RoboCup", true, new String[] {"ernsthafte Teilnahme am Qualifikationsturnier", "Qualifikation für Deutsche Meisterschaft", "Preisträger Deutsche Meisterschaft"},true,"123",3));
        this.erfuellbareAktivitaeten.add(new Aktivitaet("Schüler experimentieren, Jugend forscht", true, new String[] {"ernsthafte Teilnahme", "alle Preisträger beim Regionalwettbewerb", "Qualifikation für den Landes- oder Bundeswettbewerb"},true,"124",3));
        this.erfuellbareAktivitaeten.add(new Aktivitaet("Schülerwettbewerb der Siemens Stiftung", true, new String[] {"ernsthafte Teilnahme", "Vorentscheid erreicht", "Finalteilnahme"},true, "125",3));
        this.erfuellbareAktivitaeten.add(new Aktivitaet("World Robot Olympiad", true, new String[] {"ernsthafte Teilnahme am Regionalwettbewerb", "1. Preis oder 2. Preis", ""},true,"126",3));
        this.erfuellbareAktivitaeten.add(new Aktivitaet("BW Landeswettbewerb Mathematik", true, new String[] {"ernsthafte Teilnahme", "Preisträger 1. Runde", "Preisträger 2. Runde"}, true, "127",3));
        this.erfuellbareAktivitaeten.add(new Aktivitaet("Experimente antworten (BY)", true, new String[] {"3 mal ernsthafte Teilnahme", "3 mal Sachpreis", "Superpreis"}, true, "128",3));
        this.erfuellbareAktivitaeten.add(new Aktivitaet("Explore Science (BW)", true, new String[] {"ernsthafte Teilnahme", "technischer Preisträger", ""}, true, "129",3));
        this.erfuellbareAktivitaeten.add(new Aktivitaet("Freestyle Physics (NW)", true, new String[] {"ernsthafte Teilnahme", "technischer Preisträger", ""}, true, "130",3));
        this.erfuellbareAktivitaeten.add(new Aktivitaet("NW bio-logisch", true, new String[] {"3 mal ernsthafte Teilnahme oder Urkunde 'mit gutem Erfolg'", "Urkunde 'mit sehr gutem Erfolg'", "Hall of Fame (Schülerakademie)"}, true, "131",3));
        this.erfuellbareAktivitaeten.add(new Aktivitaet("NW zdi-Roboterwettbewerb",true, new String[] {"ernsthafte Teilnahme", "Preisträger",""},true, "132",3));
        this.erfuellbareAktivitaeten.add(new Aktivitaet("RP Landeswettbewerb Mathematik", true, new String[] {"Qualifikation für die 2. Runde", "Preisträger der 2. Runde", " Teilnahme an der 3. Runde"}, true, "133",3));
        this.erfuellbareAktivitaeten.add(new Aktivitaet("RP Landeswettbewerb Physik", true, new String[] {"ernsthafte Teilnahme", "Qualifikation für die 2. Runde", "Teilnahme an der 3. Runde"}, true, "134", 3));
        this.erfuellbareAktivitaeten.add(new Aktivitaet("Schulintern 'Problem des Monats'", true, new String[] {"ernsthafte Teilnahme im gesamten Schuljahr", "", ""}, true, "135", 3));
        
        
        //Lehr- und Lernveranstaltungen
        this.erfuellbareAktivitaeten.add(new Aktivitaet("Camp / Ferienakademie / Forschungsexpedition", false, new String[] {"2 Tage", ">= 3 Tage", ">= 7 Tage"}, false, "136",3));
        this.erfuellbareAktivitaeten.add(new Aktivitaet("öffentliche Vorträge halten (außerunterrichtlich)", false, new String[] {"gute Leistung", "sehr gute Leistung",""},false, "137",3));
        this.erfuellbareAktivitaeten.add(new Aktivitaet("Mentorentätigkeit", false, new String[] {"regelmäßig 1 Jahr", "regelmäßig 2 Jahre", "regelmäßig 3 Jahre"},false, "138",3));
        this.erfuellbareAktivitaeten.add(new Aktivitaet("Universität / Hochschule", false, new String[] {"Schnupperstudium (keine eintätigen Besuche) oder MOOCs (max.2)", "Probestudium (Frühstudium, ein Semester lang)", "Probestudium mit Leistungsnachweis"}, false, "139",3));
        this.erfuellbareAktivitaeten.add(new Aktivitaet("freiweilliges Ferien- oder Wochenendpraktikum mit eindeutigem MINT-Bezug", false, new String[] {">= 5 Tage", ">= 10 Tage",""}, false, "140",3));
        this.erfuellbareAktivitaeten.add(new Aktivitaet("verpflichtendes Berufspraktikum mit eindeutigem MINT-Bezug", false, new String[] {">= 5 Tage", "", ""}, false, "141",3));
        this.erfuellbareAktivitaeten.add(new Aktivitaet("MINT-AG SI", false, new String[] {"1 Jahreswochenstunde", "2 Jahreswochenstunden", "3 Jahreswochenstunden"}, false , "142",1));
        this.erfuellbareAktivitaeten.add(new Aktivitaet("MINT-AG SII", false, new String[] {"1 Jahreswochenstunde", "2 Jahreswochenstunden", "3 Jahreswochenstunden"},false, "143",2));
        this.erfuellbareAktivitaeten.add(new Aktivitaet("MINT-EC-Programm (zurzeit Fraunhofer Talents, MINTLehrernachwuchsförderung)", false, new String[] {"", "", "15 Punkte pro Jahr"}, true, "144",3));
        this.erfuellbareAktivitaeten.add(new Aktivitaet("MINT-Wahl(pflicht)fach SI (2-3 Wochenstunden)/ Junior-Ingenieur-Akademie", false, new String[] {"1 Jahr / Ernsthafte Teilnahme", "2 Jahre", ""}, false, "145",1));
        this.erfuellbareAktivitaeten.add(new Aktivitaet("MINT 100 oder vergleichbare Veranstaltung außerhalb des Unterrichts",false, new String[] {"ganztägig","",""}, false,"146",1));
        this.erfuellbareAktivitaeten.add(new Aktivitaet("Naturwissenschaftliche Profilklasse", false, new String[] {"1 Jahr", "2 Jahre", "3 Jahre"}, false, "147",3));
        this.erfuellbareAktivitaeten.add(new Aktivitaet("Schüler-Ingenieur-Akademie", false, new String[] {"" , "", "15 Punkte bei erfolgreicher Teilnahme"}, false, "148",3));
        
        this.fokus = "Zusätzliche MINT-Aktivitäten in der SI und in der SII";
        
        //Schulspezifische Aktivitaeten
        
    }   
    
    /**
     * Gibt einen Text aus, was noch bis zur naechsten Zertifikatsstufe erreicht werden muss. Ggf. was die Person erledigt hat, wenn sie schon auf der hoechsten Stufe ist.
     * @return Beratungstext
     */
    @Override
    public String zurNaechstenStufe() {
        this.aktualisieren();
        switch (this.zertifikatsstufe) {
            case 0:
                return String.format(String.format("%10s", "") + "Für Stufe 1 fehlen noch " + (40-gesamtPunktzahl)+ " Punkte. %n"+String.format("%10s", "") +  "Momentane Punktzahl: "+gesamtPunktzahl+" %n"+String.format("%10s", "") +  "Punkte in der SI erreicht: "+punkteS1+ " (maximal 20 Punkte werden in Stufe 1 gewertet) %n"+String.format("%10s", "") +  "Punkte in der SII erreicht: "+punkteS2);
            case 3: 
                String ausgabe = String.format(String.format("%10s", "") + "Höchste Stufe wurde mit " + gesamtPunktzahl+ " Punkten erreicht %n"+String.format("%10s", "") +  "Punkte in der SI erreicht: "+punkteS1+" (maximal 40 Punkte werden in Stufe 3 gewertet; maximal 30 Punkte in Stufe 2) %n"+String.format("%10s", "") +  "Punkte in der SII erreicht: "+punkteS2+" %n"+String.format("%20s", "") +  "Aktivitäten mit Niveau 2 oder höher in der SII:%n");
                for (Aktivitaet erfuellteAktivitaetenS21 : erfuellteAktivitaetenS2) {
                    if (erfuellteAktivitaetenS21.getNiveau() >= 2){
                        ausgabe += String.format("%20s", "") +  erfuellteAktivitaetenS21.getName() + "%n";
                    }
                }
                return ausgabe;
            case 1: 
                String ausgabe1="";
                //Ertsmal ueberpruefen, was genau fehlt. Sind es die Punkte oder ein hoeheres Aktivitaetenniveau?
                int niveaus2 = 0;
                for (Aktivitaet erfuellteAktivitaetenS22 : erfuellteAktivitaetenS2) {
                    if (erfuellteAktivitaetenS22.getNiveau() >= 2) {
                        niveaus2++;
                    }
                }
                if (niveaus2 == 0) { //Keine Kurse auf erhoehtem Niveau.
                    ausgabe1 = String.format(String.format("%10s", "") + "Zur Stufe 2 fehlt noch mindestens eine Aktivität mit Niveau 2 oder höher in der SII. %n"+String.format("%10s", "") +  "Momentane Punktzahl: " +gesamtPunktzahl +" %n"+String.format("%10s", "") +  "Punkte in der SI erreicht: " +punkteS1+ " (maximal 30 Punkte werden in Stufe 2 gewertet; maximal 20 Punkte in Stufe 1) %n"+String.format("%10s", "") +  "Punkte in der SII erreicht: "+punkteS2);
                } else { //Es fehlen Punkte.
                    ausgabe1 = String.format(String.format("%10s", "") +  "Zur Stufe 2 fehlen noch " + (60-gesamtPunktzahl) + " Punkte. %n"+String.format("%10s", "") +  "Momentane Punktzahl: "+gesamtPunktzahl+" %n"+String.format("%10s", "") +  "Punkte in der SI erreicht: "+punkteS1+" (maximal 30 Punkte werden in Stufe 2 gewertet; maximal 20 Punkte in Stufe 1) %n"+String.format("%10s", "") +  "Punkte in der SII erreicht: "+punkteS2+" %n"+String.format("%20s", "") +  "Aktivitäten mit Niveau 2 oder höher in der SII:%n");
                    for (Aktivitaet erfuellteAktivitaetenS23 : erfuellteAktivitaetenS2) {
                        if (erfuellteAktivitaetenS23.getNiveau() >= 2) {
                           ausgabe1 += String.format("%20s", "")  + erfuellteAktivitaetenS23.getName() + "%n";
                        }
                    }
                }
                return ausgabe1;
            default: 
                String ausgabe2="";
                //Ertsmal ueberpruefen, was genau fehlt. Sind es die Punkte oder ein hoeheres Aktivitaetenniveau?
                ArrayList<Aktivitaet> erhoeht = new ArrayList<>();
                for (Aktivitaet erfuellteAktivitaetenS22 : erfuellteAktivitaetenS2) {
                    if (erfuellteAktivitaetenS22.getNiveau() >= 2) {
                        erhoeht.add(erfuellteAktivitaetenS22);
                    }
                }
                if (erhoeht.size() == 0) { //Keine Kurse auf erhoehtem Niveau.
                    ausgabe2 = String.format(String.format("%10s", "") +  "Zur Stufe 3 fehlen noch mindestens zwei Aktivitäten mit Niveau 2 oder eine mit Niveau 3 in der SII. %n"+String.format("%10s", "") +  "Momentane Punktzahl: " +gesamtPunktzahl + " %n"+String.format("%10s", "") +  "Punkte in der SI erreicht: "+punkteS1+" (maximal 40 Punkte werden in Stufe 3 gewertet; maximal 30 Punkte in Stufe 2) %n"+String.format("%10s", "") +  "Punkte in der SII erreicht: "+punkteS2);
                } else if (erhoeht.size() == 1 && erhoeht.get(0).getNiveau() == 2 ) { //Ein Kurs auf Niveau 2
                    ausgabe2 = String.format(String.format("%10s", "") +  "Zur Stufe 3 fehlt noch mindestens eine Aktivität mit Niveau 2 oder höher in der SII. %n"+String.format("%10s", "") +  "Momentane Punktzahl: " +gesamtPunktzahl + " %n"+String.format("%10s", "") +  "Punkte in der SI erreicht: "+punkteS1+" (maximal 40 Punkte werden in Stufe 3 gewertet; maximal 30 Punkte in Stufe 2) %n"+String.format("%10s", "") +  "Punkte in der SII erreicht: "+punkteS2+" %n"+String.format("%20s", "") +  "Aktivität mit Niveau 2 oder höher:%n"+String.format("%20s", "")  + erhoeht.get(0).getName());
                } else { //Es fehlen Punkte.
                    ausgabe2 = String.format(String.format("%10s", "") +  "Zur Stufe 3 fehlen noch " + (80-gesamtPunktzahl)+ " Punkte. %n"+String.format("%10s", "") +  "Momentane Punktzahl: " +gesamtPunktzahl + " %n"+String.format("%10s", "") +  "Punkte in der SI erreicht: "+punkteS1+" (maximal 40 Punkte werden in Stufe 3 gewertet; maximal 30 Punkte in Stufe 2) %n"+String.format("%10s", "") +  "Punkte in der SII erreicht: "+punkteS2+" %n"+String.format("%20s", "") +  "Aktivitäten mit Niveau 2 oder höher in der SII:%n");
                    for (Aktivitaet erfuellteAktivitaetenS23 : erfuellteAktivitaetenS2) {
                        if (erfuellteAktivitaetenS23.getNiveau() >= 2) {
                           ausgabe2 += String.format("%20s", "") + erfuellteAktivitaetenS23.getName() + "%n";
                        }
                    }
                }
            return ausgabe2;
        }
    }
    
    /**
     * Aktualisiert die Parameter des dritten Anforderungsfeldes. Anders als bei
     * der Methode in der Superklasse wird hier die Gesamtpunktzahl miteinbezogen und
     * es wird anders ueberprueft, ob das Anforderungsfeld erfuellt ist (Punkte).
     */
    @Override
    public void aktualisieren() {
        //Zu aktualisierende Parameter: zertifikatsstufe, istErfuelltEins, istErfuelltZwei, istErfuelltDrei, punkteS1, punkteS2, gesamtPunktzahl
        //Diese muessen erst ordnungsgemaess zurueckgesetzt werden, sonst addieren sich die Punkte auf.
        zertifikatsstufe = 0;
        istErfuelltEins = false;
        istErfuelltZwei = false;
        istErfuelltDrei = false;
        punkteS1 = 0;
        punkteS2 = 0;
        gesamtPunktzahl = 0;
        
        
        //Erst werden die Punkte berechnet (Die urspruengliche Intention dieses Programms wird genau hier umgesetzt. Schoen!)
        for (Aktivitaet erfuellteAktivitaetenS11 : erfuellteAktivitaetenS1) { //Alle Aktivitaten der SI werden zusammenaddiert....
            switch (erfuellteAktivitaetenS11.getNiveau()) {
                case 1:
                    punkteS1 += 5;
                    break;
                case 2: 
                    punkteS1 += 10;
                    break;
                case 3:
                    punkteS1 += 15;
                    break;
            }
        }
        
        for (Aktivitaet erfuellteAktivitaetenS21 : erfuellteAktivitaetenS2) { //Alle Aktivitaten der SII werden zusammenaddiert....
            switch (erfuellteAktivitaetenS21.getNiveau()) {
                case 1:
                    punkteS2 += 5;
                    break;
                case 2: 
                    punkteS2 += 10;
                    break;
                case 3:
                    punkteS2 += 15;
                    break;
            }
        }
        
        //Gesamtpunkzahl bestimmen, dabei werden je nach Zertfikatsstufe die Punkte aus der SI angepasst...
        if (punkteS1 >= 40) { 
            int pufferS1 = 40; //Die Punkte aus der SI duerfen nicht hoeher als 40 sein bei der hoechsten Stufe (3)
            if(punkteS2 >= 40) { //Ueber gleich Stufe 3
                gesamtPunktzahl = pufferS1 + punkteS2;
            } else if (punkteS2 >= 30) { //Ueber gleich Stufe 2
                gesamtPunktzahl = punkteS2 + 30;
            } else { //Unter Stufe 2 und somit immer 20
                gesamtPunktzahl = punkteS2 + 20;
            }
        } else if (punkteS1 < 40 && punkteS1 >= 30 ) {
            int pufferS1 = 30;
            if((punkteS1 + punkteS2) >= 80) { //Ueber gleich Stufe 3
                gesamtPunktzahl = punkteS1 + punkteS2;
            } else if ((pufferS1 + punkteS2) >= 60) { //Ueber gleich Stufe 2
                gesamtPunktzahl = punkteS2 + pufferS1;
            } else { //Unter 2 und somit 20
                gesamtPunktzahl = punkteS2 + 20;
            }
        } else if (punkteS1 < 30 && punkteS1 >= 20 ) {
            if((punkteS1 + punkteS2) >= 80) { //Ueber gleich Stufe 3
                gesamtPunktzahl = punkteS1 + punkteS2;
            } else if ((punkteS1 + punkteS2) >= 60) { //Ueber gleich Stufe 2
                gesamtPunktzahl = punkteS2 + punkteS1;
            } else { //Unter 2 und somit 20
                gesamtPunktzahl = punkteS2 + 20;
            }
        } else {
            gesamtPunktzahl = punkteS2 + punkteS1;
        }
        
        //Welche Zertifikatsstufe erreicht wurde, dabei muessen die erreichten Nivaus der Akt. in S2 beruecksichtigt werden
        ArrayList<Aktivitaet> erhoeht = new ArrayList<>();
        ArrayList<Aktivitaet> erhoehtNiveau3 = new ArrayList<>();
                for (Aktivitaet erfuellteAktivitaetenS22 : erfuellteAktivitaetenS2) {
                    if (erfuellteAktivitaetenS22.getNiveau() >= 2) {
                        erhoeht.add(erfuellteAktivitaetenS22);
                    }
                    if (erfuellteAktivitaetenS22.getNiveau() == 3) {
                        erhoehtNiveau3.add(erfuellteAktivitaetenS22);
                    }
                }
        if (gesamtPunktzahl >= 40 && gesamtPunktzahl < 60) { //Gesamtpunktzahl zwischen 40 und 60, Niveaus muessen in der 1. Stufe nicht beruecksichtigt werden
            this.zertifikatsstufe = 1;
        } else if ((gesamtPunktzahl >= 60 && gesamtPunktzahl < 80) && !erhoeht.isEmpty()) { //Punktzahl zwischen 60 und 80, mind. eine Aktivitaet wurde in der S2 mit Niveau 2 oder hoeher vollendet
            this.zertifikatsstufe = 2;
        } else if((gesamtPunktzahl >= 60 && gesamtPunktzahl < 80) && erhoeht.isEmpty()) { //Punktzahl zwischen 60 und 80, aber es wurde keine Aktivitaet in der S2 mit Niveau 2 oder hoeher vollendet
            this.zertifikatsstufe = 1;
            //Es duerfen nur 20 Punkte in Stufe 1 aus der S1 gewertet werden
            if ( gesamtPunktzahl - punkteS2  > 20) {
                gesamtPunktzahl = punkteS2 + 20;
            }
        } else if (gesamtPunktzahl >= 80 && ( erhoeht.size() >= 2  || erhoehtNiveau3.size() >= 1 )) { //Punktzahl mind. 80, es wurden entweder zwei Aktivitaeten auf Niveau 2 oder hoeher vollendet ODER mind. eine auf Niveau 3
            this.zertifikatsstufe = 3; 
        } else if ( gesamtPunktzahl >= 80 && (erhoeht.size() == 1 && erhoeht.get(0).getNiveau() == 2 )) { //Punktzahl mind. 80, aber es wurde nur eine Aktivitaet auf Niveau 2 erfuellt; es sind 2 fuer Stufe 3 vonnoeten
            this.zertifikatsstufe = 2;
            //Es duerfen nur 30 Punkte in Stufe 1 aus der S1 gewertet werden
            if ( gesamtPunktzahl - punkteS2  > 30) {
                gesamtPunktzahl = punkteS2 + 30;
            }
        } else if ( gesamtPunktzahl >= 80 && erhoeht.isEmpty() ) { //Punktzahl mind. 80, aber es wurde keine Aktivitaet mit Niveau 2 oder hoeher in der S2 erfuellt
            this.zertifikatsstufe = 1;
            //Es duerfen nur 20 Punkte in Stufe 1 aus der S1 gewertet werden
            if ( gesamtPunktzahl - punkteS2  > 20) {
                gesamtPunktzahl = punkteS2 + 20;
            }
        }
        
        //Welche Stufen erfuellt wurden
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
    
    /**
    * Fuegt der Liste erfuellteAktivitaetenS1 eine Aktivitaet hinzu.
    * @param erfuellt Die erfuellte Aktivitaet, die der Liste hinzugefuegt werden soll.
    * @param niveau Das Niveau, auf dem die Aktivitaet abgeschlossen wurde
    */
    public void aktivitaetErfuelltS1(Aktivitaet erfuellt, int niveau) {
        if (erfuellt.getAnforderung(niveau-1).equals("")) {
            //Die Aktivitaet gibt es gar nicht fuer dieses Niveau
        } else {
            Aktivitaet taet = erfuellt.kopieren();
            taet.setNiveau(niveau);
            taet.setErfuellt(true);
            if ((erfuellteAktivitaetenS1.contains(taet) || erfuellteAktivitaetenS2.contains(taet)) && taet.isMehrfachWertbar() == false) {
            //Keine doppelten Aktivitaeten! Mache nichts
            } else {
                erfuellteAktivitaetenS1.add(taet); //Die Aktivitaet ist noch nicht in der Liste
            }
        }
        this.aktualisieren();
    } 
    
    
    /**
    * Fuegt der Liste erfuellteAktivitaetenS2 eine Aktivitaet hinzu.
    * @param erfuellt Die erfuellte Aktivitaet, die der Liste hinzugefuegt werden soll.
    * @param niveau Das Niveau, auf dem die Aktivitaet abgeschlossen wurde
    */
    public void aktivitaetErfuelltS2(Aktivitaet erfuellt, int niveau) {
        if (erfuellt.getAnforderung(niveau-1).equals("")) {
            //Die Aktivitaet gibt es gar nicht fuer dieses Niveau
        } else {
            Aktivitaet taet = erfuellt.kopieren();
            taet.setNiveau(niveau);
            taet.setErfuellt(true);
            if ((erfuellteAktivitaetenS1.contains(taet) || erfuellteAktivitaetenS2.contains(taet)) && taet.isMehrfachWertbar() == false) {
            //Keine doppelten Aktivitaeten! Mache nichts
            } else {
                erfuellteAktivitaetenS2.add(taet); //Die Aktivitaet ist noch nicht in der Liste
            }
        }
        this.aktualisieren();
    } 
    
    @Override
    /**
     * Fuegt der Liste erfuellteAktivitaeten eine Aktivitaet hinzu.
     * @param pCode Die Aktivitaet unter pCode, welche hinzugefuegt werden soll. 
     * Falls die Id eines Codes zu keiner Aktivitaet gehoert oder ungueltig ist wird nichts gemacht. 
     * Die ersten 3 Zahlen sind die AktivitaetsID.
     * Die 4. Zahl des Codes das erfuellte Niveau.
     * Die 5. Zahl ist die Kennung, ob diese Aktivitaet in der SI oder SII erfuellt wurde wobei 4 -> SI; 5 -> SII.
     */
    public void aktivitaetErfuellt(String pCode) {
        if (pCode.length() >= 5) { //Code gueltige Laenge?
            String aktivitaetsID = pCode.substring(0,3); 
            if (enthaeltID(aktivitaetsID)) { //Ist die 3-stellige ID einer Aktivitaet zugewiesen?
                int niveau =(int) Integer.valueOf(pCode.substring(3,4));
                Aktivitaet taet = erhalteAktivitaetUnterID(aktivitaetsID);
                if (pCode.substring(4, 5).equals("4")) {
                    aktivitaetErfuelltS1(taet, niveau);
                } else {
                    aktivitaetErfuelltS2(taet, niveau);
                }
            } 
        }
    }
    
    
    
    //Sondierende und veraendernde Methoden
    
    public int getPunkteS1() {
        this.aktualisieren();
        return punkteS1;
    }

    public void setPunkteS1(int punkteS1) {
        this.aktualisieren();
        this.punkteS1 = punkteS1;
    }

    public int getPunkteS2() {
        this.aktualisieren();
        return punkteS2;
    }

    public void setPunkteS2(int punkteS2) {
        this.aktualisieren();
        this.punkteS2 = punkteS2;
    }

    public int getGesamtPunktzahl() {
        this.aktualisieren();
        return gesamtPunktzahl;
    }

    public ArrayList<Aktivitaet> getErfuellteAktivitaetenS1() {
        this.aktualisieren();
        return erfuellteAktivitaetenS1;
    }

    public void setErfuellteAktivitaetenS1(ArrayList<Aktivitaet> erfuellteAktivitaetenS1) {
        this.aktualisieren();
        this.erfuellteAktivitaetenS1 = erfuellteAktivitaetenS1;
    }

    public ArrayList<Aktivitaet> getErfuellteAktivitaetenS2() {
        this.aktualisieren();
        return erfuellteAktivitaetenS2;
    }

    public void setErfuellteAktivitaetenS2(ArrayList<Aktivitaet> erfuellteAktivitaetenS2) {
        this.aktualisieren();
        this.erfuellteAktivitaetenS2 = erfuellteAktivitaetenS2;
    }
    
}
