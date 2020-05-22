# Angabe

**(English version below)**

## German

Der Sommer kommt, die Temperaturen steigen und es kommt wieder Betrieb auf im Erdbeerland. Von den ersten 1000 Beeren gibt es in der Klasse „Erdbeeren“ (bereits in „Erdbeerland importiert) ein double Array „WEIGHTS“ mit den Gewichten und ein int Array „CLASSIFICATION“ mit den Klassifizierungen als grün, reif und verdorben. (Die Klassifizierungen sind als konstante Ganzzahlen in der Klasse „Erdbeerland“ hinterlegt)

1. Die Methoden „istVerdorben“ und „istGrün“ haben als Rückgabewert einen Bool’schen Wert. Übergibt man ihnen ein Array mit Klassifizierungen und den Index einer Erdbeere sollen sie somit bestimmen, ob diese Erdbeere verdorben bzw. grün ist.

2. Die Methode „anzahlReifeBeeren“ hat als Parameter ebenfalls ein int Array mit Klassifizierungen. Der Rückgabewert soll eine Ganzzahl mit der Anzahl der reifen Beeren sein.

3. Die Methode „nimmReifeBeeren“ übernimmt wiederum ein int Array mit Klassifizierungen und einen ganzzahligen Index. Ausgehend von diesem Index soll die Methode abzählen wie viele reife Beeren folgen. 
Landet man also zB mit dem Index 4 auf einer reifen Beere und auf Index 5 folgt eine grüne Beere, so ist das Ergebnis, dass man 1 Beere nehmen kann. Landet man auf einer verdorbenen oder grünen Beere nimmt man 0. Folgen auf eine reife Beere noch drei reife Beeren und dann eine verdorbene, ist das Ergebnis 4.

4. Mit der Methode „mittleresGewicht“ soll sich das durchschnittliche Gewicht aller Beeren bestimmen lassen. Dazu ist ein Parameter mit einem double Array der Gewichte vorgesehen.

5. Ähnlich dazu ist die Methode „mittleresGewichtReif“, nur dass hier nur die reifen Beeren bei der Berechnung des Durchschnittsgewichts beachtet werden sollen. Deshalb benötigt man als zweiten Parameter ein int Array mit den Klassifizierungen.
Eine Beere mit Index „i“ hat das Gewicht „Erdbeeren.WEIGHTS[i]“ und die Klassifizierung „Erdbeeren.CLASSIFICATION[i]“

6. Im Erdbeerland sind 100 Becher vorhanden (final int BECHER_VORHANDEN). In jeden dieser Becher passen 10 Erdbeeren (final int BECHER_GRÖSZE). Die Methode „fülleBecher“ bestimmt welche Beeren ausgehend von einem Index in einen Becher kommen. Dazu übernimmt sie als Parameter die Klassifizerungen und den Index von welchem losgestartet werden soll. Von diesem Index aus sollen die nächsten 10 reifen Erdbeeren in den Becher gelangen.
Der Rückgabewert ist dann ein int Array in welchem die Indizes dieser 10 reifen Erdbeeren (inkl. falls diese reif ist, der Erdbeere mit der laut Index gestartet wurde) enthalten sind.

7. In der letzten Methode soll mittels des double Arrays mit Gewichten und eines solchen int Arrays mit Erdbeeren in einem Becher das Netto-Gewicht eines Bechers (welcher mittels Methode „fülleBecher“ aus Aufgabe 6 erstellt werden kann) zurückgegeben werden.

## English

Summer is coming, temperatures are rising and the “Erdbeerland” (Strawberry-Land) is back in business. From the first 1000 berries there is a double array "WEIGHTS" with the weights and an int array "CLASSIFICATION" with the classifications as green, ripe and spoiled. (The classes are stored as constant integers in the class "Erdbeerland", the arrays can be found in the class “Erdbeeren” but are already imported.)

1. The methods "istVerdorben" and "istGrün" have a Boolean value as return value If you pass them an array with classifications and the index of a strawberry, they should determine whether this strawberry is spoiled or green.

2. The method "anzahlReifeBeeren" also has an int array with classifications as parameter. The return value should be an integer with the number of ripe berries.

3. The method "nimmReifeBeeren" again takes an int array with classifications and an integer index. Based on this index the method shall count how many ripe berries follow.
If you e.g. land on a ripe berry with index 4 and on index 5 follows a green berry, the result is that you can take 1 berry. If you land on a rotten or green berry, you take 0. If a ripe berry is followed by three ripe berries and then a rotten berry, the result is 4.

4. With the method "mittleresGewicht" the average weight of all berries should be determined. A parameter with a double array of weights is provided for this purpose.

5. The "mittleresGewichtReif" method is similar, except that here only the ripe berries should be taken into account when calculating the average weight. Therefore, an int array with the classifications is needed as a second parameter.
A berry with index "i" has the weight "Erdbeeren.WEIGHTS[i]" and the classification "Erdbeeren.CLASSIFICATION[i]".

6. 100 cups are available in the Erdbeerland (final int BECHER_VORHANDEN). In each of these cups 10 strawberries fit (final int BECHER_GRÖSZE). The method "fülleBecher" determines which berries are put into a cup starting from an index. For this purpose, it takes as parameters the classifications and the index from which it should start. From this index, the next 10 ripe strawberries should be placed in the cup.
The return value is then an int array containing the indices of these 10 ripe strawberries (including, if ripe, the strawberry with which the index was started).

7. In the last method the net weight of a cup should be returned using the double array with weights and such an int array with strawberries in a cup (as given by the method “fülleBecher” of task 6).
