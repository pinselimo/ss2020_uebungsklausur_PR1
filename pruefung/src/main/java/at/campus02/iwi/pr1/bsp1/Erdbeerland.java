package at.campus02.iwi.pr1.bsp1;

public class Erdbeerland {
    final int GRÜN = 1;
    final int REIF = 2;
    final int VERDORBEN = 3;
    final static int BECHER_GRÖSZE = 10;
    final static int BECHER_VORHANDEN = 100;

    public static void main(String[] args) {
        final double[] GEWICHTE = Erdbeeren.WEIGHTS;
        final int[] KLASSIFIZIERUNG = Erdbeeren.CLASSIFICATION;
    }

    public static boolean istVerdorben(int[] beerenKlassifiziert, int index) {
        return false; // Platzhalter
    }

    public static boolean istGrün(int[] beerenKlassifiziert, int index) {
        return false; // Platzhalter
    }

    public static int anzahlReifeBeeren(int[] beerenKlassifiziert) {
        return 0; // Platzhalter
    }

    public static int nimmReifeBeeren(int[] beerenKlassifiziert, int index) {
        return 0; // Platzhalter
    }

    public static double mittleresGewicht(double[] gewichte) {
        return 0; // Platzhalter
    }

    public static double mittleresGewichtReif(double[] gewichte, int[] beerenKlassifiziert) {
        return 0; // Platzhalter
    }

    public static int[] fülleBecher(int[] beerenKlassifiziert, int index) {
        return new int[0]; // Platzhalter
    }

    public static double becherNettoGewicht(double[] gewichte, int[] becherFüllung) {
        return 0;
    }
}