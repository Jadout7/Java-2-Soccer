package main;

/**
 * Created Enum for the type of Card, each card having their own amounts for fines
 */
public enum Card {
    /**
     * Yellow card with a fine of 18.32
     */
    YELLOW(18.32),
    /**
     * Red card with a fine of 41.60
     */
    RED(41.60),
    /**
     * Black card with a fine of 349.76
     */
    BLACK(349.76);

    /**
     * Variable to return the fine for a certain card (`final` because the amount for the fines do not change)
     */
    private final double fine;

    /**
     * Constructor for Card enum
     *
     * @param fine the fine amount for the card
     */
    Card(double fine) {
        this.fine = fine;
    }

    /**
     * Method to get the fine for a specific card
     *
     * @return the fine amount for the card
     */
    public double getFine() {
        return fine;
    }
}
