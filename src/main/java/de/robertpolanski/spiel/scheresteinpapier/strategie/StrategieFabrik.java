package de.robertpolanski.spiel.scheresteinpapier.strategie;

import de.robertpolanski.spiel.scheresteinpapier.enums.StrategieEnum;
import de.robertpolanski.spiel.scheresteinpapier.strategie.impl.ImmerSteinStrategie;
import de.robertpolanski.spiel.scheresteinpapier.strategie.impl.ZufallStrategie;

/**
 * Eine Fabrik für die gewählte Strategie.
 */
public class StrategieFabrik {

    public Strategie createStrategie(StrategieEnum strategiEnum) {

        switch (strategiEnum) {
            case ZUFALL:
                return new ZufallStrategie();
            case IMMER_STEIN:
                return new ImmerSteinStrategie();
            default:
                throw new IllegalArgumentException("Diese Strategie existiert nicht");
        }
    }
}
