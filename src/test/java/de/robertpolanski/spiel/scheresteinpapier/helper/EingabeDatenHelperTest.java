package de.robertpolanski.spiel.scheresteinpapier.helper;

import de.robertpolanski.spiel.scheresteinpapier.enums.Meldungen;
import de.robertpolanski.spiel.scheresteinpapier.enums.StrategieEnum;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;

class EingabeDatenHelperTest {

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


    @DisplayName("Soll zurückliefern die richtige Strategie für die Console-Eingabe")
    @ParameterizedTest(name = "{index} => Spieler1-Figur = {0}, StrategieEnum = {1}")
    @MethodSource("strategieEingabeProvider")
    void shouldReturnRichtigeStrategieFuerDieConsoleEingabe(String eingabe, StrategieEnum strategieEnum) {

        //Given
        EingabeDatenHelper eingabeDatenHelper = new EingabeDatenHelper();

        //When
        ByteArrayInputStream input = new ByteArrayInputStream(eingabe.getBytes());
        StrategieEnum strategie = eingabeDatenHelper.getSpieler1StrategieInt(input,
                Meldungen.WAEHL_EINE_STRATEGIE_FUER_DEN_ERSTEN_SPIELER.getText());

        //Then
        assertEquals(strategieEnum, strategie);

    }

    private static Stream<Arguments> strategieEingabeProvider() {
        return Stream.of(
                Arguments.of("1", StrategieEnum.ZUFALL),
                Arguments.of("2", StrategieEnum.IMMER_STEIN)
        );
    }

    @DisplayName("Soll zurückliefern eine richtige Fehlermeldung when unrichtige Zahl eingegeben worden ist.")
    @ParameterizedTest(name = "{index} => unrichtige Benutzer-Eingabe = {0}, Fehlermeldung = {1}")
    @MethodSource("unrichtigeZahlEingabeProvider")
    void shouldAusgebenEineRichtigeFehlerMeldungWhenUnrichtigeZahlEingegebenWordenIst(String inputText,
                                                                                             String consoleMeldung) {

        //Given
        EingabeDatenHelper eingabeDatenHelper = new EingabeDatenHelper();

        //When
        ByteArrayInputStream input = new ByteArrayInputStream(inputText.getBytes());
        int scanZahl = eingabeDatenHelper.scanZahl(input);

        //Then
        assertEquals(consoleMeldung, outContent.toString());
        assertEquals(1, scanZahl);
    }

    private static Stream<Arguments> unrichtigeZahlEingabeProvider() {
        return Stream.of(
                Arguments.of("UnrichtigeZahl" + NEW_LINE + "1", Meldungen.ES_IST_KEINE_ZAHL.getText() + NEW_LINE),
                Arguments.of("UnrichtigeZahl" + NEW_LINE + "UnrichtigeZahl" + NEW_LINE + "1",
                        Meldungen.ES_IST_KEINE_ZAHL.getText() + NEW_LINE +
                        Meldungen.ES_IST_KEINE_ZAHL.getText() + NEW_LINE)
        );

    }

}
