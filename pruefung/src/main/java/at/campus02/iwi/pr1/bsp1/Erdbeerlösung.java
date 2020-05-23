package at.campus02.iwi.pr1.bsp1;

import java.util.Arrays;

public class Erdbeerlösung {
    // Constants defined to make life easier
    final static int GRÜN = 1;
    final static int REIF = 2;
    final static int VERDORBEN = 3;
    final static int BECHER_GRÖSZE = 10;
    final static int BECHER_VORHANDEN = 100;

    // The main method can serve as a testing ground
    public static void main(String[] args) {
        // Import data for convenience of having both
        // German and English naming available now
        final double[] GEWICHTE = Erdbeeren.WEIGHTS;
        final int[] KLASSIFIZIERUNG = Erdbeeren.CLASSIFICATION;

        // *** Trying out our methods ***
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
        /*
        equal to: int beere = beerenKlassifiziert[index];
                  if (beere == VERDORBEN) {
                      return true;
                  } else {
                      return false;
                  }
        */
        return beerenKlassifiziert[index] == VERDORBEN;
    }

    public static boolean istGrün(int[] beerenKlassifiziert, int index) {
        // See previous method
        return beerenKlassifiziert[index] == GRÜN;
    }

    public static int anzahlReifeBeeren(int[] beerenKlassifiziert) {
        // Initialising the variable holding the value we wish to return
        int anzahl = 0;
        // Using a for-each loop we don't have to keep track of any index
        // It yields one value after another contained in the array
        for (int klassifizierung : beerenKlassifiziert) {
            // Each integer in the array represents the ripeness category
            // of a berry. We do not care *which* berry it is, thus we 
            // do not need any index. 
            // If a berry is said to be ripe, we count:
            if (klassifizierung == REIF)
                anzahl++; // ++ increments the value held in "anzahl"
        }
        return anzahl;
    }

    public static int nimmReifeBeeren(int[] beerenKlassifiziert, int index) {
        // Initialising the variable holding the value we wish to return
        int anzahl = 0; // Starting with 0 meaning we take no berries so far
        /*
        Unlike a for-each or a classical for-loop, in a while loop we have to
        take care of incrementing all of our index variable ourselves.
        Here it is important to remember the difference in between:
            ++index    and    index++
            
        ++index : Increments index first, then returns the value in index.
                  So if index was to be 5, array[++index] would yield the 
                  value with index 6 and index would also be 6 afterwards.
        
        index++ : First returns the value held in index, then increments it.
                  So if index was to be 5, array[index++] would yield the
                  value with index 5 but index would be at 6 afterwards.
                  
        We use this property of (++) here to our advantage. We check if the
        berry at index is ripe but after checking, index already points to the
        next berry thanks to the (++) after index.
        
        So if the berry at index is ripe, we increment anzahl, taking this one
        berry. Then we return to the while clause but index now points at the 
        next berry and we check if that one is ripe too.
        */
        while (beerenKlassifiziert[index++] == REIF) {
            anzahl++;
        }
        return anzahl;
    }

    public static double mittleresGewicht(double[] gewichte) {
        // Initialising the variable holding the value we wish to return        
        double summe = 0;
        // Using a for-each loop we don't have to keep track of any index
        // It yields one value after another contained in the array
        for (double gewicht : gewichte) {
            // Each double in the array represents the weight of a berry.
            // We do not care *which* berry it is we just want to know the
            // total weight of *all* berries. So we sum them up.
            summe += gewicht;
            // Remember:
            //     a += b
            // is equal to
            //     a = a + b
        }
        // To turn the sum into the mean, we devide by the amount of berries.
        // While we could have also count, it is conveniently stored in the length
        // attribute of the array.
        return summe / gewichte.length;
    }

    public static double mittleresGewichtReif(double[] gewichte, int[] beerenKlassifiziert) {
        // Initialising the variable holding the value we wish to return 
        double summe = 0;
        // We need to iterate over two arrays. Hence we use a classical for-loop allowing
        // us to define an index variable (i).
        for (int i = 0; i < gewichte.length && i < beerenKlassifiziert.length; i++) {
            // Now we need to care *which* berry weight we are looking at, because we can
            // only add it to our sum if it is said to be ripe.
            if (beerenKlassifiziert[i] == REIF)
                summe += gewichte[i];
                // Remember:
                //     a += b;
                // is equal to
                //     a = a + b;
        }
        // To turn the sum into the mean, we devide by the amount of berries.
        // While we could have also counted here, we have the convenience of
        // already having written a method to do so:
        // (It would of course save us iterating over the array twice if we didn't)
        return summe / anzahlReifeBeeren(beerenKlassifiziert);
    }

    public static int[] fülleBecher(int[] beerenKlassifiziert, int index) {
        // Here our return value is of type int[]. So we initialise an array
        // to hold our result
        int[] becher = new int[BECHER_GRÖSZE]; // A cup is as big as BECHER_GRÖSZE defines
        int beere = 0; // So far we have 0 berries in the cup

        // We need to iterate over the int[] beerenKlassifiziert
        // So naturally we define an index variable i. 
        // However, we do not start at 0 necessarily but at any 'int index'
        // given as parameter to the function.
        // Thus: 'int i = index;)
        for (int i = index;
             // The next part of the for-loop parentheses checks *if* the
             // loop should continue or stop.
             // The first part of the clause is as usual:
             
             //     i < beerenKlassifiziert.length
             
             // it checks if we have reached the end of the array we're
             // trying to iterate over.
             // However, we are also iterating over a second array: 
             // Our return value stored in 'int[] becher' !!
             // So the we also need to check (&&) if we have already
             // reached the maximum berries that the cup can take:
             
             //     beere < BECHER_GRÖSZE
             
             // We could also check for: beere < becher.length
             
             i < beerenKlassifiziert.length && beere < BECHER_GRÖSZE;
             // The last part of we increment our index variable
             i++) {
            // We check if the berry at index i is ripe
            if (beerenKlassifiziert[i] == REIF) {
                // If the berry 'i' is ripe we store the value of 'i'
                // in the array 'becher'
                // Here again we use the property of (++) as described above.
                
                // Assume we are at beere 0 (our first berry in the cup)
                // and the berry at index i = 63 is ripe. Then:
                
                becher[beere++] = i;
                
                // will set the value at index 0 of the 'becher' to 63
                // But after doing so, 'beere' would be incremented and hold 
                // a value of 1.
                
                /*
                becher[beere++] = i;
                
                is equal to:
                
                becher[beere] = i;
                beere++; 
                                
                (Additional info: 
                    becher[++beere] = i;
                    would be equal to
                    beere++;
                    becher[beere] = i;                   
                */
            }
        }
        return becher;
    }

    public static double becherNettoGewicht(double[] gewichte, int[] becherFüllung) {
        // Initialising the variable holding the value we wish to return         
        double summe = 0;
        // Using a for-each loop we don't have to keep track of any index
        // It yields one value after another contained in the array
        for (int beere : becherFüllung) {
            // Each integer in the array represents the index this particular
            // berry has in the array "GEWICHTE" (and also in "KLASSIFIZIERUNG")
            // 
            // So if we want to know its weight, we look at this index in the array
            // holding the weights:
            summe += gewichte[beere];
        }
        return summe;
    }
}
