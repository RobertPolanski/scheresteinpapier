package de.robertpolanski.spiel.scheresteinpapier.enums;

/**
 * Aufzählungstyp der implementierten Strategien.
 * <p>ZUFALL - Die Strategie wird ausgelost</p>
 * <p>IMMER_STEIN - Es wird immer Stein Figure benutzt</p>
 */
public enum StrategieEnum {

    ZUFALL(1, "Zufall"),
    IMMER_STEIN(2, "Immer Stein");

    private int eingabeOptionId;
    private String name;

    StrategieEnum(int eingabeOptionId, String name) {
        this.eingabeOptionId = eingabeOptionId;
        this.name = name;
    }

    public int getEingabeOptionId() {
        return eingabeOptionId;
    }

    public String getName() {
        return name;
    }

    public static StrategieEnum findStrategieByEingabeOptionId(int eingabeOptionId) {
        for (StrategieEnum strategie : StrategieEnum.values()) {
            if (strategie.eingabeOptionId == eingabeOptionId) {
                return strategie;
            }
        }
        return null;
    }
}
