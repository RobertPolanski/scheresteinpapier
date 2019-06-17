package de.robertpolanski.spiel.scheresteinpapier.strategie.impl;

import de.robertpolanski.spiel.scheresteinpapier.enums.FigurEnum;
import de.robertpolanski.spiel.scheresteinpapier.strategie.Strategie;

import java.util.Random;

/**
 * Eine Implementierung von "Zufall" Strategie.
 * Eine Figur (Stein, Schere, Papier) wird ausgelost.
 */
public class ZufallStrategie implements Strategie {


    @Override
    public FigurEnum generiereFigur() {
        FigurEnum[] figurEnumValues = FigurEnum.values();
        return figurEnumValues[new Random().nextInt(figurEnumValues.length)];
    }
}
