package de.robertpolanski.spiel.scheresteinpapier.helper;

import de.robertpolanski.spiel.scheresteinpapier.enums.Meldungen;
import de.robertpolanski.spiel.scheresteinpapier.enums.StrategieEnum;
import de.robertpolanski.spiel.scheresteinpapier.pojos.SpielParameters;
import de.robertpolanski.spiel.scheresteinpapier.pojos.Spieler;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.text.MessageFormat;

class ZusammenFassungHelperTest {

    private static final String NEW_LINE = System.lineSeparator();

    private final ByteArrayOutputStream outContent = new ByteArrayOutputStream();
    private final PrintStream originalOut = System.out;


    @BeforeEach
    void setUpStreams() {
        System.setOut(new PrintStream(outContent));
    }

    @AfterEach
    void restoreStreams() {
        System.setOut(originalOut);
    }


    @Test
    void shouldReturnRichtigeStrategieFuerDieConsoleEingabe() {
        //Given
        int spieler1Punkte = 3;
        int spieler2Punkte = 6;
        int rundenAnzahl = 10;
        ZusammenFassungHelper zusammenFassungHelper = new ZusammenFassungHelper();
        Spieler spieler1 = new Spieler(StrategieEnum.IMMER_STEIN, spieler1Punkte);
        Spieler spieler2 = new Spieler(StrategieEnum.ZUFALL, spieler2Punkte);
        SpielParameters spielParameters = new SpielParameters(spieler1, spieler2, rundenAnzahl);
        MessageFormat spieler1PunkteMessage = new MessageFormat(Meldungen.SPIELER_1_HAT_PUNKTE.getText());
        MessageFormat spieler2PunkteMessage = new MessageFormat(Meldungen.SPIELER_2_HAT_PUNKTE.getText());

        //When
        zusammenFassungHelper.fassAllesZussamen(spielParameters);

        //Then
        Assertions.assertEquals(Meldungen.ANZAHL_DER_RUNDEN.getText() + "10" + NEW_LINE +
                NEW_LINE +
                spieler1PunkteMessage.format(new Object [] {"3"}) + NEW_LINE +
                spieler2PunkteMessage.format(new Object [] {"6"}) + NEW_LINE, outContent.toString());

    }
}
