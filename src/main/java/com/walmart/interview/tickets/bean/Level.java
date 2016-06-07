package com.walmart.interview.tickets.bean;

/**
 * Represents a level in a venue.
 *
 * @author juliorojas
 */
public class Level {

    private final int id;
    private final String name;
    private final double price;
    private final Row[] rows;
    private int numSeatsAvailable;

    public Level(int id, String name, double price, int nRows, int nSeatsInRow) {
        this.id = id;
        this.name = name;
        this.price = price;
        this.rows = buildRows(nRows, nSeatsInRow);
        this.numSeatsAvailable = nRows * nSeatsInRow;
    }

    private Row[] buildRows(int nRows, int nSeatsInRow) {
        Row[] rows = new Row[nRows];
        for (int i = 0; i < nRows; i++) {
            rows[i] = new Row(i, this, nSeatsInRow);
        }
        return rows;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public double getPrice() {
        return price;
    }

    public Row[] getRows() {
        return rows;
    }

    public int getNumSeatsAvailable() {
        return numSeatsAvailable;
    }

    public void setNumSeatsAvailable(int numSeatsAvailable) {
        this.numSeatsAvailable = numSeatsAvailable;
    }
}
