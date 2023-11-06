package main;

// Created Enum for the type of Card, each card having their own amounts for fines
public enum Card {
    YELLOW(18.32),
    RED(41.60),
    BLACK(349.76);

    // Variable to return the fine for a certain card (`final` because the amount for the fines do not change)
    private final double fine;

    Card(double fine) {
        this.fine = fine;
    }

    public double getFine() {
        return fine;
    }
}