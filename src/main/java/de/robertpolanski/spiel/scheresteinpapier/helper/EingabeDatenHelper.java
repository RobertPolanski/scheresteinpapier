package de.robertpolanski.spiel.scheresteinpapier.helper;

import de.robertpolanski.spiel.scheresteinpapier.enums.Meldungen;
import de.robertpolanski.spiel.scheresteinpapier.enums.StrategieEnum;
import de.robertpolanski.spiel.scheresteinpapier.pojos.SpielParameters;
import de.robertpolanski.spiel.scheresteinpapier.pojos.Spieler;

import java.io.InputStream;
import java.util.Scanner;

/**
 * Helper Klasse für Benutzer-Eingaben.
 */
public class EingabeDatenHelper {


    public SpielParameters fuellSpielParametersAus() {

        int anzahlDerRunden = getAnzahlDerRunden(System.in);

        StrategieEnum spieler1Strategie = getSpieler1StrategieInt(System.in,
                Meldungen.WAEHL_EINE_STRATEGIE_FUER_DEN_ERSTEN_SPIELER.getText());
        StrategieEnum spieler2Strategie = getSpieler1StrategieInt(System.in,
                Meldungen.WAEHL_EINE_STRATEGIE_FUER_DEN_ZWEITEN_SPIELER.getText());

        Spieler spieler1 = new Spieler(spieler1Strategie);
        Spieler spieler2 = new Spieler(spieler2Strategie);

        return new SpielParameters(spieler1, spieler2, anzahlDerRunden);

    }

    StrategieEnum getSpieler1StrategieInt(InputStream inputStream, String s) {

        System.out.println(s);
        System.out.println("1 - Zufall");
        System.out.println("2 - Immer ein Stein");

        int strategieId;

        strategieId = scanZahl(inputStream);

        return StrategieEnum.findStrategieByEingabeOptionId(strategieId);
    }

    private int getAnzahlDerRunden(InputStream inputStream) {

        System.out.println(Meldungen.GIB_DIE_ANZAHL_DER_RUNDEN_EIN.getText());
        return scanZahl(inputStream);
    }


    int scanZahl(InputStream inputStream) {
        int strategieId;
        Scanner scanner = new Scanner(inputStream);
        do {
            while (!scanner.hasNextInt()) {
                System.out.println(Meldungen.ES_IST_KEINE_ZAHL.getText());
                scanner.next();
            }
            strategieId = scanner.nextInt();
        } while (strategieId <= 0);

        return strategieId;
    }


}
