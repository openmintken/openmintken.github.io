import java.io.*;
import java.util.ArrayList;

/**
 * Die Klasse Zertifikat kombiniert die verschiedenen Anforderungsfelder und 
 * ueberprueft, ob die Bedingungen zum MINT-Zertifikat erfuellt worden sind; ggf.
 * in welcher Stufe; was noch erfuellt werden muss.
 * @author Joana Bergsiek
 * @version 1.3.2
 */
public class Zertifikat {
    private int zertifikatsstufe;
    private final AnforderungsfeldEins anforderungsfeldEins;
    private final AnforderungsfeldZwei anforderungsfeldZwei;
    private final AnforderungsfeldDrei anforderungsfeldDrei;
    
    public Zertifikat() {
        anforderungsfeldEins = new AnforderungsfeldEins();
        anforderungsfeldZwei = new AnforderungsfeldZwei();
        anforderungsfeldDrei = new AnforderungsfeldDrei();
    }

    public int getZertifikatsstufe() {
        aktualisiereAlle();
        return zertifikatsstufe;
    }
    
    /**
     * Methode zur Ueberpruefung, ob das erste Anforderungsfeld erfuellt ist.
     * @return Erfuellung des ersten Anforderungsfeldes.
     */
    public boolean istErfuelltE() {
        aktualisiereAlle();
        return zertifikatsstufe >= 1;
    }
    
    /**
     * Methode zur Ueberpruefung, ob das zweite Anforderungsfeld erfuellt ist.
     * @return Erfuellung des zweiten Anforderungsfeldes.
     */
    public boolean istErfuelltZ() {
        aktualisiereAlle();
        return zertifikatsstufe >= 2;
    }
    
    /**
     * Methode zur Ueberpruefung, ob das dritte Anforderungsfeld erfuellt ist.
     * @return Erfuellung des dritten Anforderungsfeldes.
     */
    public boolean istErfuelltD() {
        aktualisiereAlle();
        return zertifikatsstufe >= 3;
    }
    
    /**
     * Nennt der Person die erledigten Aktivitaeten sowie was noch zur naechsten Stufe fehlt.
     * @return Den Beratungstext.
     */
    public String berate() {
        aktualisiereAlle();
        String ausgabe = String.format("Anforderungsfeld I:%n" + anforderungsfeldEins.zurNaechstenStufe() + " _// %nAnforderungsfeld II:%n" + anforderungsfeldZwei.zurNaechstenStufe() + " _// %nAnforderungsfeld III:%n" + anforderungsfeldDrei.zurNaechstenStufe() + " _// %nGesamtstufe: " + zertifikatsstufe + " _// %nDas Ergebnis muss nicht dem endgültigen Zertifikat entsprechen und soll lediglich einen Überblick geben.") ;
        return ausgabe;
    }
    
    /**
     * Aktualisiert alle Anforderungsfelder
     */
    public void aktualisiereAlle () {
        anforderungsfeldEins.aktualisieren();
        anforderungsfeldZwei.aktualisieren();
        anforderungsfeldDrei.aktualisieren();
        
        //Die Zertifikatsberechnung
        //Der mathematisch gerundete Mitterwert der einzelnen Zertifikatsstufen macht die Endstufe aus
        int[] zertifikatsstufen = {anforderungsfeldEins.getZertifikatsstufe(), anforderungsfeldZwei.getZertifikatsstufe(), anforderungsfeldDrei.getZertifikatsstufe()};
        int endstufe = 0;
        if (zertifikatsstufen[0] < 1 || zertifikatsstufen[1] < 1 || zertifikatsstufen[2] < 1) {
            //Jedes Anforderungsfeld muss mindestens mit der Stufe 1 erfuellt werden; endstufe bleibt 0.
        } else {
            int gesamtwert = 0;
            for(int i=0;i<zertifikatsstufen.length;i++){  
                gesamtwert += zertifikatsstufen[i];
            } 
            float mittelwert = (float) (gesamtwert / 3.0);
            endstufe = Math.round(mittelwert);
        }
        zertifikatsstufe = endstufe;
    }
    
    /**Diese Klasse erstellt eine Textdatei mit den erledigten Aktivitaeten, samt Punkte
     * und dem Beratungstext der Methode berate().
     * @param pfad Der Zielpfad der Datei inklusive Name am Ende des Pfades, noch ohne Fortmatende ".txt"
     */
    public void erfuellteAktivitaetenTextdatei (String pfad) {
        aktualisiereAlle();
        BufferedWriter bufferedWriter = null;
        String dateipfad = pfad;
        if (!pfad.endsWith(".txt")) {
            dateipfad += ".txt";
        }
        
        try {
            //Erzeuge die Datei
            File file = new File(dateipfad);
            FileWriter fileWriter = new FileWriter(file);
            bufferedWriter = new BufferedWriter(fileWriter);
            
            //Schreibe nun den Text der Datei...
            bufferedWriter.write("MINTken-Auswertung von:");
            String[] beratungsText = berate().split(" _// "); //Teilung des Textes, somit man ein Anforderungsfeld pro Absatz haben wird
            for (int i = 0; i < beratungsText.length; i++) {
                for (int k = 0; k < 2; k++) {
                    bufferedWriter.newLine(); //Schreibe k leere Zeilen zwischen den Beratungstexten der einzelnen Anforderungsfeldern
                }
                bufferedWriter.write(beratungsText[i]);
            }
            for (int k = 0; k < 3; k++) {
                    bufferedWriter.newLine();
            }
            
            //Nun die Aktivitaeten zusaetzlich nennen...
            
            //A1...
            String A1Zeile = "";
            if (anforderungsfeldEins.getErfuellteAktivitaeten().isEmpty()) {
                //Keine Aktivitaet wurde hier erfuellt, mache nichts
            } else {
                Aktivitaet taetA1 = anforderungsfeldEins.getErfuellteAktivitaeten().get(0);
                String aktivitaetsIDA1 = taetA1.getAktivitaetsID()+ Integer.toString(taetA1.getNiveau()) + "1"; //Eine ID der Laenge 5, die sich aus der eigentlichen AktivitaetsID, deren erfuelltes Niveau und das Anforderungsfeld zusammensetzt
                A1Zeile = aktivitaetsIDA1 + " "+ taetA1.getName() + ", " + taetA1.getAnforderung(taetA1.getNiveau()-1) + " und somit Niveau "+ taetA1.getNiveau() +".";
                bufferedWriter.write(A1Zeile);
                bufferedWriter.newLine();
            }
            
            
            
            //A2...
            String A2Zeile = "";
            if (anforderungsfeldZwei.getErfuellteAktivitaeten().isEmpty()) {
                //Keine Aktivitaet wurde hier erfuellt, mache nichts
            } else {
                Aktivitaet taetA2 = anforderungsfeldZwei.getErfuellteAktivitaeten().get(0);
                String aktivitaetsIDA2 = taetA2.getAktivitaetsID()+ Integer.toString(taetA2.getNiveau()) + "2" ;  
                A2Zeile = aktivitaetsIDA2 + " "+ taetA2.getName() + ",  " + taetA2.getAnforderung(taetA2.getNiveau()-1) + " und somit Niveau "+ taetA2.getNiveau() +".";
                bufferedWriter.write(A2Zeile);
                bufferedWriter.newLine();
            }
            
            
            
            //A3
            //S1...
            for (Aktivitaet taet : anforderungsfeldDrei.getErfuellteAktivitaetenS1()) {
                String A3S1Zeile = "";
                String aktivitaetsID = taet.getAktivitaetsID()+ Integer.toString(taet.getNiveau()) + "4"; //Die letzte Zahl fuer A3S1 Aktivitaeten ist immer 4 (3 + 1) 
                A3S1Zeile = aktivitaetsID + " "+ taet.getName() + ", Niveau "+taet.getNiveau()+" durch " + taet.getAnforderung(taet.getNiveau()-1) + " und somit "+ taet.getNiveau()*5 +" Punkte.";
                bufferedWriter.write(A3S1Zeile);
                bufferedWriter.newLine();
            }
            
            //S2...
            for (Aktivitaet taet : anforderungsfeldDrei.getErfuellteAktivitaetenS2()) {
                String A3S2Zeile = "";
                String aktivitaetsID = taet.getAktivitaetsID()+  Integer.toString(taet.getNiveau()) + "5"; //Die letzte Zahl fuer A3S2 Aktivitaeten ist immer 5 (3 + 2) 
                A3S2Zeile = aktivitaetsID + " "+ taet.getName() + ", Niveau "+taet.getNiveau()+" durch " + taet.getAnforderung(taet.getNiveau()-1) + " und somit "+ taet.getNiveau()*5 +" Punkte.";
                bufferedWriter.write(A3S2Zeile);
                bufferedWriter.newLine();
            }
            for (int k = 0; k < 3; k++) {
                    bufferedWriter.newLine();
            }
            bufferedWriter.write("Falls die Datei noch geladen werden soll, bitte die Zahlen vor den Aktivitäten nicht verändern!");
            
        } catch (IOException ex) {   
        
        } finally {
            //Datei schließen
            try {
                if (bufferedWriter != null) {
                    bufferedWriter.close();
                } 
            } catch (IOException e) {
            
            }
        }
    }
    
    /**
     * Aus einer Liste mit 5-stelligen Aktivitaetencodes werden dem Zertifikat erfuellte Aktivitaeten hinzugefuegt.
     * @param codes Eine Liste der erfuellten Aktivitaeten in Codeform
     */
    public void erzeugeZertfikatsdaten (ArrayList<String> codes) {
        for (int i = 0; i < codes.size(); i++) {
            if (codes.get(i).length() >= 5) {
                int anforderungsfeld = (int) Integer.valueOf(codes.get(i).substring(4, 5));
                
                switch (anforderungsfeld) {
                    case 1: anforderungsfeldEins.aktivitaetErfuellt(codes.get(i));
                            break;
                    case 2: anforderungsfeldZwei.aktivitaetErfuellt(codes.get(i));
                            break;
                    case 4:
                    case 5: anforderungsfeldDrei.aktivitaetErfuellt(codes.get(i));
                            break;
                    default: break;
                }
            }
        }
        aktualisiereAlle();
    } 
    
    /**
     * Liest eine MINTken-Auswertung durch und speichert alle gefundenen
     * Aktivitaeten-Codes in einer ArrayList.
     *
     * @param pPfad Die zu lesende Datei unter pPfad
     * @return Eine ArrayList mit allen gefundenen Codes
     */
    public ArrayList<String> erhalteCodesAusDatei(String pPfad) throws Exception {
        ArrayList<String> codes = new ArrayList<>();

        //Oeffne Datei unter pPfad
        FileReader file = new FileReader(pPfad);
        BufferedReader reader = new BufferedReader(file);

        //Lese Datei zeilenweise durch
        String line = reader.readLine();
        while (line != null) {
            //Ueberpruefe nun, ob in dieser Zeile ein 5-stelliger Code am Anfang steht
            if (line.length() >= 5) {
                String anfangDerZeile = line.substring(0, 5);
                //Ist der Anfang der Zeile tatsaechlich eine Zahl?
                    if (istGueltigerCode(anfangDerZeile)) { 
                        codes.add(anfangDerZeile);
                    }
            }
            line = reader.readLine();
        }
        return codes;
    }
    
    /**
     * Untersucht, ob gegebener Code ein legitimer 5-stelliger Aktivitaetencode
     * ist.
     *
     * @param code Der zu untersuchende Code
     * @return true bei einem gueltigen Code; false wenn nicht
     */
    public boolean istGueltigerCode(String code) {
        //Bedingungen fuer einen gueltigen Code:
        //1. Dieser ist 5 Zeichen lang
        if (code.length()!= 5) {
            return false;
        }
        //2. Das 5. Zeichen endet mit der Identifikation des Anforderungsfeldes 
        //1 -> A1; 2 -> A2; 4 -> A3 S1; 5 -> A3 S2
        if (!(code.endsWith("1")
                || code.endsWith("2")
                || code.endsWith("4")
                || code.endsWith("5"))) {
            return false;
        }
        
        //3. Das 4. Zeichen praesentiert die erreichte Niveaustufe der Aktivitaet
        char viertesZeichen = code.charAt(3);
        if (!(viertesZeichen == '1' || viertesZeichen == '2' || viertesZeichen == '3' )) {
            return false;
        }
        
        //4. Die ersten 3 Zeichen sind eine Zahl zwischen inklusive 0 und 999
        try {
            Integer potenCode = Integer.valueOf(code.substring(0, 3));
            
            //5. Wenn die vordere Zahl zwischen 0 und 51 ist, muss die letzte Zahl im Code eine 1 sein
            if ( potenCode < 0 ) {
                return false;
            }
            if ( potenCode > 0 && potenCode < 51 && !(code.endsWith("1"))) {
                return false;
            }
            
            //6. Wenn die vordere Zahl zwischen 50 und 101 ist, muss die letzte Zahl im Code eine 2 sein
            if ( potenCode > 50 && potenCode < 101 && !(code.endsWith("2"))) {
                return false;
            }
            
            //7. Wenn die vordere Zahl zwischen 100 und 1000 ist ODER eine 0, muss die letzte Zahl im Code eine 4 oder 5 sein
            if ( ( (potenCode > 100 && potenCode < 1000 ) || potenCode == 0)  && !(code.endsWith("4") || code.endsWith("5") )) {
                return false;
            }
            
        } catch (Exception ex) {
            //Die 3 ersten Zeichen sind keine gueltige Zahl
            return false;
        }
        
        return true;
    }
    
    //Sondierende Methoden
    
    public AnforderungsfeldEins getAnforderungsfeldEins() {
        return anforderungsfeldEins;
    }

    public AnforderungsfeldZwei getAnforderungsfeldZwei() {
        return anforderungsfeldZwei;
    }

    public AnforderungsfeldDrei getAnforderungsfeldDrei() {
        return anforderungsfeldDrei;
    }

    
}
