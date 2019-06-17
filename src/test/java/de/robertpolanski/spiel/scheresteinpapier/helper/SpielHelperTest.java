package de.robertpolanski.spiel.scheresteinpapier.helper;

import de.robertpolanski.spiel.scheresteinpapier.enums.FigurEnum;
import de.robertpolanski.spiel.scheresteinpapier.enums.StrategieEnum;
import de.robertpolanski.spiel.scheresteinpapier.pojos.SpielParameters;
import de.robertpolanski.spiel.scheresteinpapier.pojos.Spieler;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static de.robertpolanski.spiel.scheresteinpapier.enums.FigurEnum.*;
import static de.robertpolanski.spiel.scheresteinpapier.helper.SpielHelper.*;
import static org.junit.jupiter.api.Assertions.assertEquals;

class SpielHelperTest {


    @DisplayName("Soll zurückliefern welcher Spieler gewonnen hat. Alle Figuren-Kombinationen werden berücksichtigt.")
    @ParameterizedTest(name = "{index} => Spieler1-Figur = {0}, Spieler2-Figur = {1}, Ergebnis = {2}")
    @MethodSource("figurProvider")
    void shouldReturnWelcherSpielerGewonnenHatFuerAlleOptionenVonFiguren(FigurEnum spieler1Figur,
                                                                                FigurEnum spieler2Figur,
                                                                                int erwartetesErgebnis) {

        //Given
        SpielHelper spielHelper = new SpielHelper();

        //When
        int ergebnis = spielHelper.spielEineRunde(spieler1Figur, spieler2Figur);

        //Than
        assertEquals(erwartetesErgebnis, ergebnis);

    }

    private static Stream<Arguments> figurProvider() {
        return Stream.of(
                Arguments.of(SCHERE, SCHERE, REMIS),
                Arguments.of(SCHERE, PAPIER, SPIELER1_GEWWINT),
                Arguments.of(SCHERE, STEIN, SPIELER2_GEWWINT),

                Arguments.of(PAPIER, SCHERE, SPIELER2_GEWWINT),
                Arguments.of(PAPIER, PAPIER, REMIS),
                Arguments.of(PAPIER, STEIN, SPIELER1_GEWWINT),

                Arguments.of(STEIN, SCHERE, SPIELER1_GEWWINT),
                Arguments.of(STEIN, PAPIER, SPIELER2_GEWWINT),
                Arguments.of(STEIN, STEIN, REMIS)

        );
    }

    @Test
    void shouldReturnEinRichtigeSpielerPunkteUndRundenAnzahl() {

        final int RUNDENANZAHL = 3;

        //Given
        SpielHelper spielHelper = new SpielHelper();
        Spieler spieler1 = new Spieler(StrategieEnum.IMMER_STEIN);
        Spieler spieler2 = new Spieler(StrategieEnum.IMMER_STEIN);

        SpielParameters spielParameters = new SpielParameters(spieler1, spieler2, RUNDENANZAHL);

        //When
        spielParameters = spielHelper.simulierDasSpiel(spielParameters);

        //Than
        assertEquals(RUNDENANZAHL, spielParameters.getRundenAnzahl());
        assertEquals(0, spielParameters.getSpieler1().getPunkte());
        assertEquals(0, spielParameters.getSpieler2().getPunkte());
    }

}
