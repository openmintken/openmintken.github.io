
import java.util.ArrayList;


/**
 * Anforderungsfeld III des MINT-Zertifikats.
 * @author Joana Bergsiek.
 * @version 1.1
 */
public class AnforderungsfeldDrei extends Anforderungsfeld {
    
    private int punkteS1;
    private int punkteS2;
    private int gesamtPunktzahl;
    private ArrayList<Aktivitaet> erfuellteAktivitaetenS1 = new ArrayList<>();
    private ArrayList<Aktivitaet> erfuellteAktivitaetenS2 = new ArrayList<>();
    
    public AnforderungsfeldDrei() {
        //Folgende Felder sind in der Reihenfolge geordnet, wie sie auch in den offiziellen Dokumenten angeorndet sind.
        
        //Falls noch nicht in Anforderungsfeld I oder II eingebracht (Implementiere dafuer eine Ueberpruefung in Zertifikat)
        this.erfuellbareAktivitaeten.add(new Aktivitaet("Naturwissenschaftliche Profilklasse (Falls noch nicht in Anforderungsfeld I oder II eingebracht)", false, new String[] {"1 Jahr", "2 Jahre", "3 Jahre"}));
        this.erfuellbareAktivitaeten.add(new Aktivitaet("Fachwissenschaftliche Arbeit mit mindestens 10 Seiten oder besondere Lernleistung (s.o.)", false, new String[] {">= 9 Notenpunkte", ">= 11 Notenpunkte", ">= 13 Notenpunkte"}));
        this.erfuellbareAktivitaeten.add(new Aktivitaet("wissenshaftspropädeutisches Fach oder zusätzlicher MINT-Kurs durchgängig in der Qualifikationsphase belegt (s.o)", false, new String[] {"Mittelwert aller Kurshalbjahre >= 9 Notenpunkte","Mittelwert aller Kurshalbjahre >= 11 Notenpunkte","Mittelwert aller Kurshalbjahre >= 13 Notenpunkte"}));
        
        //Wettbewerbe
        this.erfuellbareAktivitaeten.add(new Aktivitaet("BundesUmwelt Wettbewerb", true, new String[] {"Urkunde", "Förder- oder Anerkennungspreis", "Haupt- oder Sonderpreis"}));
        this.erfuellbareAktivitaeten.add(new Aktivitaet("Bundeswettbewerb Informatik", true, new String[] {"ernsthafte Teilnahme", "Qualifikation für die 2. Runde", "Qualifikation für die 3. Runde"}));
        this.erfuellbareAktivitaeten.add(new Aktivitaet("Bundeswettbewerb Mathematik", true, new String[] {"1. Runde (ernsthafte Teilnahme)", "Qualifikation für die 2. Runde", "Qualifikation für die 3. Runde"}));
        this.erfuellbareAktivitaeten.add(new Aktivitaet("DECHEMAX", true, new String[] {"Qualifikation für die 2. Runde", "Sonderpreis / bestes Klassenstufenteam", "Siegerteam"}));
        this.erfuellbareAktivitaeten.add(new Aktivitaet("Dr. Hans-Riegel-Fachpreis", true, new String[] {"", "", "Preisträger"}));
        this.erfuellbareAktivitaeten.add(new Aktivitaet("FIRST LEGO League", true, new String[] {"ernsthafte Teilnahme Regionalwettbewerb", "Preisträger Regionalwettbewerb", "Qualifikation Semi-Finals / Finale Zentraleuropa"}));
        this.erfuellbareAktivitaeten.add(new Aktivitaet("Informatik-Biber", true, new String[] {"3 mal ernsthafte Teilnahme oder 3. Preis", "1. Preis oder 2. Preis",""}));
        this.erfuellbareAktivitaeten.add(new Aktivitaet("Internationale BiologieOlympiade", true, new String[] {"ernsthafte Teilnahme", "Qualifikation für die 2. Runde", "Qualifikation für die 3. Runde"}));
        this.erfuellbareAktivitaeten.add(new Aktivitaet("Internationale ChemieOlympiade", true, new String[] {"ernsthafte Teilnahme", "Qualifikation für die 2. Runde", "Qualifikation für die 3. Runde"}));
        this.erfuellbareAktivitaeten.add(new Aktivitaet("Internationaler Chemiewettbewerb", true, new String[] {"Certificate of Merit / Certificate of High Destination", "Certificate of Excellence",""}));
        this.erfuellbareAktivitaeten.add(new Aktivitaet("Internationale Junior Science Olympiade", true, new String[] {"ernsthafte Teilnahme", "Qualifikation für die 2. Runde", "Qualifikation für das Bundesfinale"}));
        this.erfuellbareAktivitaeten.add(new Aktivitaet("Internationale PhysikOlympiade", true, new String[] {"ernsthafte Teilnahme", "Qualifikation für die 2. Runde", "Qualifikation für die 3. Runde"}));
        this.erfuellbareAktivitaeten.add(new Aktivitaet("Känguru der Mathematik", true, new String[] {"3 mal ernsthafte Teilnahme oder 3. Preis", "1. Preis oder 2. Preis",""}));
        this.erfuellbareAktivitaeten.add(new Aktivitaet("Mathematik-Olympiade", true, new String[] {"3 ernsthafte Teilnahme oder 3. Preis", "Qualifikation für die Regionalrunde (Stadt/Kreis)", "Qualifikation für die Landesrunde oder Bundeswettbewerb"}));
        this.erfuellbareAktivitaeten.add(new Aktivitaet("MNU-Bundeswettbewerb Physik", true, new String[] {"ernsthafte Teilnahme", "Qualifikation für die 2. Runde", "Qualifikation für die Bundesrunde"}));
        this.erfuellbareAktivitaeten.add(new Aktivitaet("NW bio-logisch", true, new String[] {"3 mal ernsthafte Teilnahme oder Urkunde 'mit gutem Erfolg'", "Urkunde 'mit sehr gutem Erfolg'", "Hall of Fame (Schülerakademie)"}));
        this.erfuellbareAktivitaeten.add(new Aktivitaet("NW Chemie entdecken", true, new String[] {"Urkunde 'mit gutem Erfolg'", "Urkunde 'mit sehr gutem Erfolg'", "Urkunde 'mit ausgezeichnetem Erfolg'"}));
        this.erfuellbareAktivitaeten.add(new Aktivitaet("NW zdi-Roboterwettbewerb",true, new String[] {"ernsthafte Teilnahme", "Preisträger",""}));
        this.erfuellbareAktivitaeten.add(new Aktivitaet("RP Landeswettbewerb Mathematik", true, new String[] {"Qualifikation für die 2. Runde", "Preisträger der 2. Runde", "Teilnahme an der 3. Runde"}));
        this.erfuellbareAktivitaeten.add(new Aktivitaet("RP Landeswettbewerb Physik", true, new String[] {"ernsthafte Teilnahme", "Qualifikation für die 2. Runde", "Teilnahme an der 3. Runde"}));
        this.erfuellbareAktivitaeten.add(new Aktivitaet("Schüler experimentieren, Jugend forscht", true, new String[] {"ernsthafte Teilnahme", "alle Preisträger beim Regionalwettbewerb", "Qualifikation für den Landes- oder Bundeswettbewerb"}));
        this.erfuellbareAktivitaeten.add(new Aktivitaet("Schülerwettbewerb der Siemens Stiftung", true, new String[] {"ernsthafte Teilnahme", "Vorentscheid erreicht", "Finalteilnahme"}));
        
        
        //Lehr- und Lernveranstaltungen
        this.erfuellbareAktivitaeten.add(new Aktivitaet("Camp / Ferienakademie / Forschungsexpedition", false, new String[] {"<= 2 Tage", ">= 3 Tage", ">= 7 Tage"}));
        this.erfuellbareAktivitaeten.add(new Aktivitaet("öffentliche Vorträge halten (außerunterrichtlich)", false, new String[] {"gute Leistung", "sehr gute Leistung",""}));
        this.erfuellbareAktivitaeten.add(new Aktivitaet("Mentorentätigkeit", false, new String[] {"regelmäßig 1 Jahr", "regelmäßig 2 Jahre", "regelmäßig 3 Jahre"}));
        this.erfuellbareAktivitaeten.add(new Aktivitaet("Universität / Hochschule", false, new String[] {"Schnupperstudium (keine eintätigen Besuche)", "Probestudium (Frühstudium, ein Semester lang)", "Probestudium mit Leistungsnachweis"}));
        this.erfuellbareAktivitaeten.add(new Aktivitaet("freiweilliges Ferien- oder Wochenendpraktikum mit eindeutigem MINT-Bezug", false, new String[] {">= 5 Tage", ">= 10 Tage",""}));
        this.erfuellbareAktivitaeten.add(new Aktivitaet("verpflichtendes Berufspraktikum mit eindeutigem MINT-Bezug", false, new String[] {">= 5 Tage (nur einmalig werten)", "", ""}));
        this.erfuellbareAktivitaeten.add(new Aktivitaet("MINT-AG SI", false, new String[] {"1 Jahreswochenstunde", "2 Jahreswochenstunden", "3 Jahreswochenstunden"}));
        this.erfuellbareAktivitaeten.add(new Aktivitaet("MINT-AG SII", false, new String[] {"1 Jahreswochenstunde", "2 Jahreswochenstunden", "3 Jahreswochenstunden"}));
        this.erfuellbareAktivitaeten.add(new Aktivitaet("MINT-EC-Programm (zurzeit Fraunhofer Talents, MINTLehrernachwuchsförderung)", false, new String[] {"", "", "15 Punkte pro Jahr"}));
        this.erfuellbareAktivitaeten.add(new Aktivitaet("MINT-Wahl(pflicht)fach SI (2-3 Wochenstunden)/ Junior-Ingenieur-Akademie", false, new String[] {"1 Jahr", "2 Jahre", ""}));
        this.erfuellbareAktivitaeten.add(new Aktivitaet("Schüler-Ingenieur-Akademie", false, new String[] {"" , "", "15 Punkte bei erfolgreicher Teilnahme"}));
        
        this.fokus = "Zusätzliche MINT-Aktivitäten in der SI und in der SII";
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
                return "Für Stufe 1 fehlen noch " + (40-gesamtPunktzahl)+ " Punkte. Momentane Punktzahl: "+gesamtPunktzahl+", Punkte in der SI erreicht: "+punkteS1+ " (maximal 20 Punkte werden in Stufe 1 gewertet), Punkte in der SII erreicht: "+punkteS2+".";
            case 3: 
                String ausgabe = "Höchste Stufe wurde mit " + gesamtPunktzahl+ " Punkten erreicht, Punkte in der SI erreicht: "+punkteS1+" (maximal 40 Punkte werden in Stufe 3 gewertet; maximal 30 Punkte in Stufe 2), Punkte in der SII erreicht: "+punkteS2+". Kurse mit Niveau 2 oder höher: ";
                for (Aktivitaet erfuellteAktivitaetenS21 : erfuellteAktivitaetenS2) {
                    if (erfuellteAktivitaetenS21.getNiveau() >= 2){
                        ausgabe += erfuellteAktivitaetenS21.getName() + ", ";
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
                    ausgabe1 = "Zur Stufe 2 fehlt noch mindestens eine Aktivität mit Niveau 2 oder höher in der SII. Momentane Punktzahl: " +gesamtPunktzahl +", Punkte in der SI erreicht: " +punkteS1+ " (maximal 30 Punkte werden in Stufe 2 gewertet; maximal 20 Punkte in Stufe 1), Punkte in der SII erreicht: "+punkteS2+".";
                } else { //Es fehlen Punkte.
                    ausgabe1 = "Zur Stufe 2 fehlen noch " + (60-gesamtPunktzahl) + " Punkte. Momentane Punktzahl: "+gesamtPunktzahl+", Punkte in der SI erreicht: "+punkteS1+" (maximal 30 Punkte werden in Stufe 2 gewertet; maximal 20 Punkte in Stufe 1), Punkte in der SII erreicht: "+punkteS2+". Kurse mit Niveau 2 oder höher in der SII: ";
                    for (Aktivitaet erfuellteAktivitaetenS23 : erfuellteAktivitaetenS2) {
                        if (erfuellteAktivitaetenS23.getNiveau() >= 2) {
                           ausgabe1 += erfuellteAktivitaetenS23.getName() + ", ";
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
                    ausgabe2 = "Zur Stufe 3 fehlen noch mindestens zwei Aktivitäten mit Niveau 2 oder eine mit Niveau 3 in der SII. Momentane Punktzahl: " +gesamtPunktzahl + ", Punkte in der SI erreicht: "+punkteS1+" (maximal 40 Punkte werden in Stufe 3 gewertet; maximal 30 Punkte in Stufe 2), Punkte in der SII erreicht: "+punkteS2+".";
                } else if (erhoeht.size() == 1 && erhoeht.get(0).getNiveau() == 2 ) { //Ein Kurs auf Niveau 2
                    ausgabe2 = "Zur Stufe 3 fehlt noch mindestens eine Aktivität mit Niveau 2 oder höher in der SII. Momentane Punktzahl: " +gesamtPunktzahl + ", Punkte in der SI erreicht: "+punkteS1+" (maximal 40 Punkte werden in Stufe 3 gewertet; maximal 30 Punkte in Stufe 2), Punkte in der SII erreicht: "+punkteS2+". Kurs mit Niveau 2 oder höher: " + erhoeht.get(0).getName();
                } else { //Es fehlen Punkte.
                    ausgabe2 = "Zur Stufe 3 fehlen noch " + (80-gesamtPunktzahl)+ " Punkte. Momentane Punktzahl: " +gesamtPunktzahl + ", Punkte in der SI erreicht: "+punkteS1+" (maximal 40 Punkte werden in Stufe 3 gewertet; maximal 30 Punkte in Stufe 2), Punkte in der SII erreicht: "+punkteS2+". Kurse mit Niveau 2 oder höher in der SII: ";
                    for (Aktivitaet erfuellteAktivitaetenS23 : erfuellteAktivitaetenS2) {
                        if (erfuellteAktivitaetenS23.getNiveau() >= 2) {
                           ausgabe2 += erfuellteAktivitaetenS23.getName() + ", ";
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
            Aktivitaet taet = erfuellt;
            taet.setNiveau(niveau);
            taet.setErfuellt(true);
            if (erfuellteAktivitaetenS1.contains(taet) || erfuellteAktivitaetenS2.contains(taet)) {
            //Keine doppelten Aktivitaeten! Mache nichts
            } else {
                for (Aktivitaet erfuellteAktivitaetenS11 : erfuellteAktivitaetenS1) { 
                    String check = erfuellteAktivitaetenS11.getName();
                    if (check.equals(taet.getName())) { //Ist die Aktivitaet schon unter einem anderen Niveau in der Liste?
                        if (taet.getNiveau() > erfuellteAktivitaetenS11.getNiveau()) { //Die neue Aktivitaet hat ein hoehres Niveau und wird deswegen mit der alten ersetzt 
                            erfuellteAktivitaetenS1.remove(erfuellteAktivitaetenS11);
                            erfuellteAktivitaetenS1.add(taet);
                            break;
                        } else {
                            //Mache nichts, nur die hoehere Aktivitaet wird gezaehlt und ggf. der Liste hinzugefuegt
                            break;
                        }
                    }
                }
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
            Aktivitaet taet = erfuellt;
            taet.setNiveau(niveau);
            taet.setErfuellt(true);
            if (erfuellteAktivitaetenS2.contains(taet) || erfuellteAktivitaetenS1.contains(taet)) {
            //Keine doppelten Aktivitaeten! Mache nichts
            } else {
                for (Aktivitaet erfuellteAktivitaetenS21 : erfuellteAktivitaetenS2) {
                    String check = erfuellteAktivitaetenS21.getName();
                    if (check.equals(taet.getName())) { //Ist die Aktivitaet schon unter einem anderen Niveau in der Liste?
                        if (taet.getNiveau() > erfuellteAktivitaetenS21.getNiveau()) { //Die neue Aktivitaet hat ein hoehres Niveau und wird deswegen mit der alten ersetzt 
                            erfuellteAktivitaetenS2.remove(erfuellteAktivitaetenS21);
                            erfuellteAktivitaetenS2.add(taet);
                            break;
                        } else {
                            //Mache nichts, nur die hoehere Aktivitaet wird gezaehlt und ggf. der Liste hinzugefuegt
                            break;
                        }
                    }
                }
                erfuellteAktivitaetenS2.add(taet); //Die Aktivitaet ist noch nicht in der Liste
            }
        }
        this.aktualisieren();
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
