package at.campus02.iwi.pr1.bsp1;

import java.util.Arrays;

public class Erdbeerlösung {
    final static int GRÜN = 1;
    final static int REIF = 2;
    final static int VERDORBEN = 3;
    final static int BECHER_GRÖSZE = 10;
    final static int BECHER_VORHANDEN = 100;

    public static void main(String[] args) {
        final double[] GEWICHTE = Erdbeeren.WEIGHTS;
        final int[] KLASSIFIZIERUNG = Erdbeeren.CLASSIFICATION;

        System.out.println(istVerdorben(KLASSIFIZIERUNG, 0));
        System.out.println(istGrün(KLASSIFIZIERUNG, 7));

        System.out.println("Reife Beeren: " + anzahlReifeBeeren(KLASSIFIZIERUNG));
        System.out.println("Nehme: " + nimmReifeBeeren(KLASSIFIZIERUNG, 390));
        System.out.println("Mittleres Gewicht: " + mittleresGewicht(GEWICHTE));
        System.out.println("Gewicht reifer Beeren: " + mittleresGewichtReif(GEWICHTE, KLASSIFIZIERUNG));

        int[] ersterBecher = fülleBecher(KLASSIFIZIERUNG, 0);
        System.out.println("Erster Becher: " + Arrays.toString(ersterBecher));
        System.out.println("Gewicht: " + becherNettoGewicht(GEWICHTE,ersterBecher));
    }

    public static boolean istVerdorben(int[] beerenKlassifiziert, int index) {
        return beerenKlassifiziert[index] == VERDORBEN;
    }

    public static boolean istGrün(int[] beerenKlassifiziert, int index) {
        return beerenKlassifiziert[index] == GRÜN;
    }

    public static int anzahlReifeBeeren(int[] beerenKlassifiziert) {
        int anzahl = 0;
        for (int klassifizierung : beerenKlassifiziert) {
            if (klassifizierung == REIF)
                anzahl++;
        }
        return anzahl;
    }

    public static int nimmReifeBeeren(int[] beerenKlassifiziert, int index) {
        int anzahl = 0;
        while (beerenKlassifiziert[index++] == REIF) {
            anzahl++;
        }
        return anzahl;
    }

    public static double mittleresGewicht(double[] gewichte) {
        double summe = 0;
        for (double gewicht : gewichte) {
            summe += gewicht;
        }
        return summe / gewichte.length;
    }

    public static double mittleresGewichtReif(double[] gewichte, int[] beerenKlassifiziert) {
        double summe = 0;
        for (int i = 0; i < gewichte.length && i < beerenKlassifiziert.length; i++) {
            if (beerenKlassifiziert[i] == REIF)
                summe += gewichte[i];
        }
        return summe / anzahlReifeBeeren(beerenKlassifiziert);
    }

    public static int[] fülleBecher(int[] beerenKlassifiziert, int index) {
        int[] becher = new int[BECHER_GRÖSZE];
        int beere = 0;

        for (int i = index;
             i < beerenKlassifiziert.length && beere < BECHER_GRÖSZE;
             i++) {
            if (beerenKlassifiziert[i] == REIF) {
                becher[beere++] = i;
            }
        }
        return becher;
    }

    public static double becherNettoGewicht(double[] gewichte, int[] becherFüllung) {
        double summe = 0;
        for (int beere : becherFüllung) {
            summe += gewichte[beere];
        }
        return summe;
    }
}