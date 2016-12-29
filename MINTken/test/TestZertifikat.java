
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 * Testen des Systems
 * @author Joana Bergsiek
 * @version 1.1
 */
public class TestZertifikat {
    Zertifikat zer;
    Zertifikat zer1;
    Zertifikat zer2;
    Zertifikat zer3;
    Zertifikat zer4;
    AnforderungsfeldDrei drei;
    AnforderungsfeldDrei drei2;
    AnforderungsfeldZwei zwei;
    AnforderungsfeldEins eins;
    AnforderungsfeldDrei fehlendeNiveausZu2;
    AnforderungsfeldDrei fehlendeNiveausZu3_1;
    
    public TestZertifikat() {
    }
    
    @Before
    public void setUp() {
        zer = new Zertifikat();
        zer1 = new Zertifikat();
        zer2 = new Zertifikat();
        zer3 = new Zertifikat();
        zer4 = new Zertifikat();
        drei = new AnforderungsfeldDrei();
        drei2 = new AnforderungsfeldDrei();
        zwei = new AnforderungsfeldZwei();
        eins = new AnforderungsfeldEins();
        fehlendeNiveausZu2 = new AnforderungsfeldDrei();
        fehlendeNiveausZu3_1 = new AnforderungsfeldDrei();
        zer.getAnforderungsfeldEins().aktivitaetErfuellt(zer.getAnforderungsfeldEins().getErfuellbareAktivitaeten().get(0), 3);
        zer.getAnforderungsfeldZwei().aktivitaetErfuellt(zer.getAnforderungsfeldZwei().getErfuellbareAktivitaeten().get(3), 2);
        zer.getAnforderungsfeldDrei().aktivitaetErfuelltS2(zer.getAnforderungsfeldDrei().getErfuellbareAktivitaeten().get(0), 3);
        
        zer2.getAnforderungsfeldEins().aktivitaetErfuellt(zer2.getAnforderungsfeldEins().getErfuellbareAktivitaeten().get(1), 1);
        zer2.getAnforderungsfeldZwei().aktivitaetErfuellt(zer2.getAnforderungsfeldZwei().getErfuellbareAktivitaeten().get(4), 3);
        zer2.getAnforderungsfeldDrei().aktivitaetErfuelltS2(zer2.getAnforderungsfeldDrei().getErfuellbareAktivitaeten().get(6), 3);
        zer2.getAnforderungsfeldDrei().aktivitaetErfuelltS2(zer2.getAnforderungsfeldDrei().getErfuellbareAktivitaeten().get(7), 3);
        zer2.getAnforderungsfeldDrei().aktivitaetErfuelltS2(zer2.getAnforderungsfeldDrei().getErfuellbareAktivitaeten().get(8), 3);
        zer2.getAnforderungsfeldDrei().aktivitaetErfuelltS2(zer2.getAnforderungsfeldDrei().getErfuellbareAktivitaeten().get(9), 2);
        
        zer3.getAnforderungsfeldEins().aktivitaetErfuellt(zer3.getAnforderungsfeldEins().getErfuellbareAktivitaeten().get(1), 2);
        zer3.getAnforderungsfeldZwei().aktivitaetErfuellt(zer3.getAnforderungsfeldZwei().getErfuellbareAktivitaeten().get(4), 3);
        zer3.getAnforderungsfeldDrei().aktivitaetErfuelltS2(zer3.getAnforderungsfeldDrei().getErfuellbareAktivitaeten().get(6), 3);
        zer3.getAnforderungsfeldDrei().aktivitaetErfuelltS2(zer3.getAnforderungsfeldDrei().getErfuellbareAktivitaeten().get(7), 3);
        zer3.getAnforderungsfeldDrei().aktivitaetErfuelltS2(zer3.getAnforderungsfeldDrei().getErfuellbareAktivitaeten().get(8), 3);
        zer3.getAnforderungsfeldDrei().aktivitaetErfuelltS2(zer3.getAnforderungsfeldDrei().getErfuellbareAktivitaeten().get(9), 3);
        
        
        zer4.getAnforderungsfeldEins().aktivitaetErfuellt(zer4.getAnforderungsfeldEins().getErfuellbareAktivitaeten().get(1), 2);
        zer4.getAnforderungsfeldZwei().aktivitaetErfuellt(zer4.getAnforderungsfeldZwei().getErfuellbareAktivitaeten().get(4), 3);
        zer4.getAnforderungsfeldDrei().aktivitaetErfuelltS1(zer4.getAnforderungsfeldDrei().getErfuellbareAktivitaeten().get(6), 3);
        zer4.getAnforderungsfeldDrei().aktivitaetErfuelltS1(zer4.getAnforderungsfeldDrei().getErfuellbareAktivitaeten().get(7), 3);
        zer4.getAnforderungsfeldDrei().aktivitaetErfuelltS1(zer4.getAnforderungsfeldDrei().getErfuellbareAktivitaeten().get(8), 3);
        zer4.getAnforderungsfeldDrei().aktivitaetErfuelltS1(zer4.getAnforderungsfeldDrei().getErfuellbareAktivitaeten().get(9), 3);
        zer4.getAnforderungsfeldDrei().aktivitaetErfuelltS2(zer4.getAnforderungsfeldDrei().getErfuellbareAktivitaeten().get(1), 3);
        zer4.getAnforderungsfeldDrei().aktivitaetErfuelltS2(zer4.getAnforderungsfeldDrei().getErfuellbareAktivitaeten().get(2), 3);
        zer4.getAnforderungsfeldDrei().aktivitaetErfuelltS2(zer4.getAnforderungsfeldDrei().getErfuellbareAktivitaeten().get(3), 3);
        //Sollten nicht mitberechnet werden
        zer4.getAnforderungsfeldEins().aktivitaetErfuellt(zer4.getAnforderungsfeldEins().getErfuellbareAktivitaeten().get(1), 2);
        zer4.getAnforderungsfeldZwei().aktivitaetErfuellt(zer4.getAnforderungsfeldZwei().getErfuellbareAktivitaeten().get(4), 3);
        zer4.getAnforderungsfeldDrei().aktivitaetErfuelltS1(zer4.getAnforderungsfeldDrei().getErfuellbareAktivitaeten().get(6), 3);
        zer4.getAnforderungsfeldDrei().aktivitaetErfuelltS1(zer4.getAnforderungsfeldDrei().getErfuellbareAktivitaeten().get(7), 3);
        zer4.getAnforderungsfeldDrei().aktivitaetErfuelltS1(zer4.getAnforderungsfeldDrei().getErfuellbareAktivitaeten().get(8), 3);
        zer4.getAnforderungsfeldDrei().aktivitaetErfuelltS1(zer4.getAnforderungsfeldDrei().getErfuellbareAktivitaeten().get(9), 3);
        zer4.getAnforderungsfeldDrei().aktivitaetErfuelltS2(zer4.getAnforderungsfeldDrei().getErfuellbareAktivitaeten().get(1), 3);
        zer4.getAnforderungsfeldDrei().aktivitaetErfuelltS2(zer4.getAnforderungsfeldDrei().getErfuellbareAktivitaeten().get(2), 3);
        zer4.getAnforderungsfeldDrei().aktivitaetErfuelltS2(zer4.getAnforderungsfeldDrei().getErfuellbareAktivitaeten().get(3), 3);
        
        drei2.aktivitaetErfuelltS1(drei2.getErfuellbareAktivitaeten().get(6), 3);
        drei2.aktivitaetErfuelltS1(drei2.getErfuellbareAktivitaeten().get(9), 3);
        drei2.aktivitaetErfuelltS1(drei2.getErfuellbareAktivitaeten().get(7), 3);
        drei2.aktivitaetErfuelltS1(drei2.getErfuellbareAktivitaeten().get(20), 3);
        drei2.aktivitaetErfuelltS1(drei2.getErfuellbareAktivitaeten().get(32), 3);
        drei2.aktivitaetErfuelltS2(drei2.getErfuellbareAktivitaeten().get(2), 3);
        
        fehlendeNiveausZu2.aktivitaetErfuelltS1(fehlendeNiveausZu2.getErfuellbareAktivitaeten().get(0), 3);
        fehlendeNiveausZu2.aktivitaetErfuelltS1(fehlendeNiveausZu2.getErfuellbareAktivitaeten().get(1), 3);
        fehlendeNiveausZu2.aktivitaetErfuelltS1(fehlendeNiveausZu2.getErfuellbareAktivitaeten().get(2), 3);
        fehlendeNiveausZu2.aktivitaetErfuelltS1(fehlendeNiveausZu2.getErfuellbareAktivitaeten().get(3), 3);
        fehlendeNiveausZu2.aktivitaetErfuelltS2(fehlendeNiveausZu2.getErfuellbareAktivitaeten().get(5), 1);
        fehlendeNiveausZu2.aktivitaetErfuelltS2(fehlendeNiveausZu2.getErfuellbareAktivitaeten().get(6), 1);
        fehlendeNiveausZu2.aktivitaetErfuelltS2(fehlendeNiveausZu2.getErfuellbareAktivitaeten().get(8), 1);
        fehlendeNiveausZu2.aktivitaetErfuelltS2(fehlendeNiveausZu2.getErfuellbareAktivitaeten().get(9), 1);
        fehlendeNiveausZu2.aktivitaetErfuelltS2(fehlendeNiveausZu2.getErfuellbareAktivitaeten().get(10), 1);
        
        fehlendeNiveausZu3_1.aktivitaetErfuelltS1(fehlendeNiveausZu3_1.getErfuellbareAktivitaeten().get(0), 3);
        fehlendeNiveausZu3_1.aktivitaetErfuelltS1(fehlendeNiveausZu3_1.getErfuellbareAktivitaeten().get(1), 3);
        fehlendeNiveausZu3_1.aktivitaetErfuelltS1(fehlendeNiveausZu3_1.getErfuellbareAktivitaeten().get(2), 3);
        fehlendeNiveausZu3_1.aktivitaetErfuelltS2(fehlendeNiveausZu3_1.getErfuellbareAktivitaeten().get(6), 1);
        fehlendeNiveausZu3_1.aktivitaetErfuelltS2(fehlendeNiveausZu3_1.getErfuellbareAktivitaeten().get(8), 1);
        fehlendeNiveausZu3_1.aktivitaetErfuelltS2(fehlendeNiveausZu3_1.getErfuellbareAktivitaeten().get(9), 1);
        fehlendeNiveausZu3_1.aktivitaetErfuelltS2(fehlendeNiveausZu3_1.getErfuellbareAktivitaeten().get(10), 1);
        fehlendeNiveausZu3_1.aktivitaetErfuelltS2(fehlendeNiveausZu3_1.getErfuellbareAktivitaeten().get(11), 1);
        fehlendeNiveausZu3_1.aktivitaetErfuelltS2(fehlendeNiveausZu3_1.getErfuellbareAktivitaeten().get(12), 1);
        fehlendeNiveausZu3_1.aktivitaetErfuelltS2(fehlendeNiveausZu3_1.getErfuellbareAktivitaeten().get(13), 1);
    }
    
    @After
    public void tearDown() {
    }

    @Test
    public void testGroesse() {
        assertTrue(zer.getAnforderungsfeldEins().getErfuellbareAktivitaeten().size() == 2);
        assertEquals(2,eins.getErfuellbareAktivitaeten().size());
        assertTrue(zer.getAnforderungsfeldZwei().getErfuellbareAktivitaeten().size() == 5);
        assertEquals(5,zwei.getErfuellbareAktivitaeten().size());
        assertTrue(zer.getAnforderungsfeldDrei().getErfuellbareAktivitaeten().size() == 36);
        assertEquals(36,drei.getErfuellbareAktivitaeten().size());
    }
    
    @Test
    public void testNochNichtsErfuellt() {
        assertEquals(0, drei.getErfuellteAktivitaetenS1().size());
        assertEquals(0, drei.getErfuellteAktivitaetenS2().size());
        assertEquals(0, zwei.getErfuellteAktivitaeten().size());
        assertEquals(0, eins.getErfuellteAktivitaeten().size());
    }
    
    @Test
    public void testKeinePunkte() {
        assertEquals(0,zer1.getAnforderungsfeldDrei().getGesamtPunktzahl());
    }
    
    @Test
    public void testSzenario1() { 
        //Kein Zertifikat
        assertEquals(0, zer.getZertifikatsstufe());
    }
    
    @Test
    public void testEinzelnePunkte() {
        assertEquals(0, zer2.getAnforderungsfeldDrei().getPunkteS1());
        assertEquals(55, zer2.getAnforderungsfeldDrei().getPunkteS2());
        assertEquals(55, zer2.getAnforderungsfeldDrei().getGesamtPunktzahl());
    }
    
    @Test
    public void testSzenario2() {
        //Zertifikat mit Stufe 2
        assertEquals(2, zer2.getZertifikatsstufe());
    }
    
    @Test
    public void testSzenario3() {
        //Zertifikat mit Stufe 2
        assertEquals(2, zer3.getZertifikatsstufe());
    }
    
    @Test
    public void testSzenario4() {
        //Zertifikat mit Stufe 3
        assertEquals(3, zer4.getZertifikatsstufe());
    }
    
    @Test
    public void testEinzelnePunkte2() {
        //Jetzt auch mit SI und doppelten Eintraegen
        assertEquals(45, zer4.getAnforderungsfeldDrei().getPunkteS1());
        assertEquals(45, zer4.getAnforderungsfeldDrei().getPunkteS2());
        assertEquals(85, zer4.getAnforderungsfeldDrei().getGesamtPunktzahl());
    }
    
    @Test
    public void testGesamtpunktzahl() {
        assertEquals(35, drei2.getGesamtPunktzahl()); 
        assertEquals(0, drei2.getZertifikatsstufe());
    }
    
    @Test
    public void testFehlendeNiveausZu2() {
        //Das Anforderungsfeld gelangt nicht in die 2. Stufe, weil keine Aktivitaeten auf Niveau 2 oder hoeher erfuellt worden sind
        assertEquals(1, fehlendeNiveausZu2.getZertifikatsstufe());
    }
    
    @Test
    public void testFehlendeNiveausZu3() {
        //Das Anforderungsfeld gelangt nicht in die 3. Stufe, weil nur eine Aktivitaeten auf Niveau 2 erfuellt worden ist
        fehlendeNiveausZu3_1.aktivitaetErfuelltS2(fehlendeNiveausZu3_1.getErfuellbareAktivitaeten().get(5), 2);
        assertEquals(75,fehlendeNiveausZu3_1.getGesamtPunktzahl());
        assertEquals(2, fehlendeNiveausZu3_1.getZertifikatsstufe());
    }
    
    @Test
    public void testFehlendeNiveausZu3_2() {
        //Das Anforderungsfeld gelangt nicht in die 3. Stufe, weil nur keine Aktivitaeten auf Niveau 2 erfuellt worden ist
        fehlendeNiveausZu3_1.aktivitaetErfuelltS2(fehlendeNiveausZu3_1.getErfuellbareAktivitaeten().get(5), 1);
        assertEquals(1, fehlendeNiveausZu3_1.getZertifikatsstufe());
    }
    
    
            
    @Test
    public void testBeratung() {
        System.out.println(zer.berate()) ;
        System.out.println(zer1.berate()) ;
        System.out.println(zer2.berate()) ;
        System.out.println(zer3.berate()) ;
        System.out.println(zer4.berate()) ;
        System.out.println(drei2.zurNaechstenStufe()) ;
        //zer3.erfuellteAktivitaetenTextdatei();
    }
    
    
    
}

