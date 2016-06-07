package com.walmart.interview.tickets.bean;

/**
 * Represents a row in a given Level.
 *
 * @author juliorojas
 */
public class Row {

    private final int id;
    private final Level level;
    private final Seat[] seats;

    public Row(int id, Level level, int numSeats) {
        this.id = id;
        this.level = level;
        this.seats = buildSeats(numSeats);
    }

    /**
     * Builds the seats for the row. Each row starts from seat 0.
     *
     * @param numSeats the number of seats to create
     * @return the seats created for the row
     */
    private Seat[] buildSeats(int numSeats) {
        Seat[] seats = new Seat[numSeats];
        for (int i = 0; i < numSeats; i++) {
            seats[i] = new Seat(i, this);
        }
        return seats;
    }

    public int getId() {
        return id;
    }

    public Level getLevel() {
        return level;
    }

    public Seat[] getSeats() {
        return seats;
    }
}
