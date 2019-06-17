package de.robertpolanski.spiel.scheresteinpapier.helper;

import de.robertpolanski.spiel.scheresteinpapier.enums.Meldungen;
import de.robertpolanski.spiel.scheresteinpapier.pojos.SpielParameters;
import de.robertpolanski.spiel.scheresteinpapier.pojos.Spieler;

import java.text.MessageFormat;

/**
 * Ein Helper-Klasse für die Zusammenfassung von Ergebnisen.
 */
public class ZusammenFassungHelper {

    public void fassAllesZussamen(SpielParameters spielParameters) {

        int rundenAnzahl = spielParameters.getRundenAnzahl();

        Spieler spieler1 = spielParameters.getSpieler1();
        Spieler spieler2 = spielParameters.getSpieler2();

        System.out.println(Meldungen.ANZAHL_DER_RUNDEN.getText() + rundenAnzahl);
        System.out.println();
        MessageFormat spieler1PunkteMessage = new MessageFormat(Meldungen.SPIELER_1_HAT_PUNKTE.getText());
        MessageFormat spieler2PunkteMessage = new MessageFormat(Meldungen.SPIELER_2_HAT_PUNKTE.getText());
        System.out.println(spieler1PunkteMessage.format(new Object [] {spieler1.getPunkte()}));
        System.out.println(spieler2PunkteMessage.format(new Object [] {spieler2.getPunkte()}));
    }

}
