package numbers;

public enum Property {
    EVEN,
    ODD,
    BUZZ,
    DUCK,
    PALINDROMIC,
    GAPFUL,
    SPY,
    SUNNY,
    JUMPING,
    HAPPY,
    SAD,
    SQUARE;


    public static boolean contains(String test) {

        for (Property c : Property.values()) {
            if (c.name().equals(test)) {
                return true;
            }
        }

        return false;
    }
}