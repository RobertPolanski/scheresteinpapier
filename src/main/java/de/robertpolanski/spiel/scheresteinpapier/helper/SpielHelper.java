package de.robertpolanski.spiel.scheresteinpapier.helper;

import de.robertpolanski.spiel.scheresteinpapier.enums.FigurEnum;
import de.robertpolanski.spiel.scheresteinpapier.pojos.SpielParameters;
import de.robertpolanski.spiel.scheresteinpapier.pojos.Spieler;
import de.robertpolanski.spiel.scheresteinpapier.strategie.Strategie;
import de.robertpolanski.spiel.scheresteinpapier.strategie.StrategieFabrik;

/**
 * In dieser klasse ist die Spiellogik implementiert.
 */
public class SpielHelper {

    static final int SPIELER1_GEWWINT = -1;
    static final int REMIS = 0;
    static final int SPIELER2_GEWWINT = 1;

    private int[][] spielTab;


    public SpielHelper() {

        spielTab = new int[][]{
                {REMIS, SPIELER1_GEWWINT, SPIELER2_GEWWINT},
                {SPIELER2_GEWWINT, REMIS, SPIELER1_GEWWINT},
                {SPIELER1_GEWWINT, SPIELER2_GEWWINT, REMIS}
        };

    }

    public SpielParameters simulierDasSpiel(SpielParameters spielParameters) {

        StrategieFabrik strategieFabrik = new StrategieFabrik();
        Spieler spieler1 = spielParameters.getSpieler1();
        Spieler spieler2 = spielParameters.getSpieler2();

        Strategie spieler1Strategie = strategieFabrik.createStrategie(spieler1.getStrategieEnum());
        Strategie spieler2Strategie = strategieFabrik.createStrategie(spieler2.getStrategieEnum());

        int rundenAnzahl = spielParameters.getRundenAnzahl();


        for (int i = 0; i < rundenAnzahl; i++) {

            FigurEnum spieler1Figur = spieler1Strategie.generiereFigur();
            FigurEnum spieler2Figur = spieler2Strategie.generiereFigur();

            int ergebnis = spielEineRunde(spieler1Figur, spieler2Figur);

            setzePunkte(ergebnis, spieler1, spieler2);
        }


        return new SpielParameters(spieler1, spieler2, rundenAnzahl);

    }

    private void setzePunkte(int ergebnis, Spieler spieler1, Spieler spieler2) {
        switch (ergebnis) {
            case SPIELER1_GEWWINT:
                spieler1.inkrementierEinenPunkt();
                break;
            case SPIELER2_GEWWINT:
                spieler2.inkrementierEinenPunkt();
                break;
        }
    }

    int spielEineRunde(FigurEnum spieler1Figur, FigurEnum spieler2Figur) {
        return spielTab[spieler1Figur.getIndex()][spieler2Figur.getIndex()];
    }

}
