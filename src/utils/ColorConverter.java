package utils;

import javafx.scene.paint.Color;

public class ColorConverter {

    public static HairColor toHairColor(Color JFXColor) {
        if (JFXColor == null) {return new HairColor(0.0, 0.0, 0.0);}
        return new HairColor(JFXColor.getRed(), JFXColor.getGreen(), JFXColor.getBlue());
    }

    public static Color toJFXColor(HairColor hairColor) {
        if (hairColor == null) {return Color.BLACK;}
        return new Color(hairColor.r(), hairColor.g(), hairColor.b(), 1.0);
    }

    /**
     * ACCEPTABLE TYPES: HairColor
     */
    public static Color toJFXColor(Object o) {
        if (o instanceof HairColor) {
            return toJFXColor((HairColor) o);
        } else {
            throw new IllegalArgumentException("only acceptable param types");
        }
    }
}
