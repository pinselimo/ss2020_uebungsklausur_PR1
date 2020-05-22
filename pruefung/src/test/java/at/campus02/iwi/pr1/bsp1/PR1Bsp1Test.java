package at.campus02.iwi.pr1.bsp1;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

public class PR1Bsp1Test {

    private int[] CLASSES;
    private double[] WEIGHTS;

    @Before
    public void setup(){
        CLASSES = Erdbeeren.CLASSIFICATION;
        WEIGHTS = Erdbeeren.WEIGHTS;
    }

    @Test
    public void testClassification() {
        assertTrue(Erdbeerland.istVerdorben(CLASSES, 0));
        assertTrue(Erdbeerland.istGrün(CLASSES, 7));
    }

    @Test
    public void testRipeBerries() {
        assertEquals(Erdbeerland.anzahlReifeBeeren(CLASSES), 498);
    }

    @Test
    public void testTakeSome() {
        assertEquals(Erdbeerland.nimmReifeBeeren(CLASSES, 33), 6);
        assertEquals(Erdbeerland.nimmReifeBeeren(CLASSES, 390), 3);
    }

    @Test
    public void testAvgWeight() {
        double w = Erdbeerland.mittleresGewicht(WEIGHTS);
        assertTrue(w > 11.77371646253);
        assertTrue(w < 11.77371646255);
    }

    @Test
    public void testAvgWeightRipe() {
        double w = Erdbeerland.mittleresGewichtReif(WEIGHTS, CLASSES);
        assertTrue(w > 11.8506343687);
        assertTrue(w < 11.850634369);
    }

    @Test
    public void testCups() {
        int[] firstCup = new int[]{1, 6, 9, 16, 17, 19, 20, 21, 23, 25};
        int someCupIdx = 390;
        int[] someCup = new int[]{390, 391, 392, 394, 396, 397, 402, 410, 412, 415};

        assertEquals(Erdbeerland.fülleBecher(CLASSES, 0), firstCup);
        assertEquals(Erdbeerland.fülleBecher(CLASSES, someCupIdx), someCup);
    }

    @Test
    public void testCupWeights() {
        int[] firstCup = new int[]{1, 6, 9, 16, 17, 19, 20, 21, 23, 25};
        double fcw = Erdbeerland.becherNettoGewicht(WEIGHTS, firstCup);
        assertTrue(fcw > 110.498836412610);
        assertTrue(fcw < 110.498836412612);
        int[] someCup = new int[]{390, 391, 392, 394, 396, 397, 402, 410, 412, 415};
        double scw = Erdbeerland.becherNettoGewicht(WEIGHTS, someCup);
        assertTrue(scw > 126.969435004756);
        assertTrue(scw < 126.969435004758);
    }
}
