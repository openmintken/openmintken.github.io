import java.io.*;

/**
 * Die Klasse Zertifikat kombiniert die verschiedenen Anforderungsfelder und 
 * ueberprueft, ob die Bedingungen zum MINT-Zertifikat erfuellt worden sind; ggf.
 * in welcher Stufe; was noch erfuellt werden muss.
 * @author Joana Bergsiek
 * @version 1.1
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
        String ausgabe = "Anforderungsfeld I: " + anforderungsfeldEins.zurNaechstenStufe() + " _// Anforderungsfeld II: " + anforderungsfeldZwei.zurNaechstenStufe() + " _// Anforderungsfeld III: " + anforderungsfeldDrei.zurNaechstenStufe() + " _// Gesamtstufe: " + zertifikatsstufe ;
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
     * und dem Beratungstext der Methode berate(). Die Datei heißt "MINTkenAuswertung",
     * befindet sich im Projektordner und diese kann man dann schließlich dem MINT-zustaendigen Lehrer senden.
     * @param pfad Der Zielpfad der Datei, noch ohne Fortmatende ".txt" der Auswertungsdatei.
     */
    public void erfuellteAktivitaetenTextdatei (String pfad) {
        aktualisiereAlle();
        BufferedWriter bufferedWriter = null;
        String dateipfad = pfad + ".txt";
        
        try {
            //Erzeuge die Datei
            File file = new File(dateipfad);
            FileWriter fileWriter = new FileWriter(file);
            bufferedWriter = new BufferedWriter(fileWriter);
            
            //System.out.println(file.getCanonicalPath());
            
            
            //Schreibe nun den Text der Datei...
            String[] beratungsText = berate().split(" _// "); //Teilung des Textes, somit man ein Anforderungsfeld pro Zeile haben wird
            bufferedWriter.write(beratungsText[0]);
            bufferedWriter.newLine();
            bufferedWriter.write(beratungsText[1]);
            bufferedWriter.newLine();
            bufferedWriter.write(beratungsText[2]);
            bufferedWriter.newLine();
            bufferedWriter.write(beratungsText[3]);
            bufferedWriter.newLine();
            
            //Nun die Aktivitaeten zusaetzlich nennen...
            //S1...
            for (Aktivitaet taet : anforderungsfeldDrei.getErfuellteAktivitaetenS1()) {
                String zeile = taet.getName() + ", Niveau " + taet.getNiveau() + " und somit "+ taet.getNiveau()*5 +" Punkte.";
                bufferedWriter.write(zeile);
                bufferedWriter.newLine();
            }
            
            //S2...
            for (Aktivitaet taet : anforderungsfeldDrei.getErfuellteAktivitaetenS2()) {
                String zeile = taet.getName() + ", Niveau " + taet.getNiveau() + " und somit "+ taet.getNiveau()*5 +" Punkte.";
                bufferedWriter.write(zeile);
                bufferedWriter.newLine();
            }
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
