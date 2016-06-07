package com.walmart.interview.tickets.bean;

/**
 * Represents a seat in a Row.
 *
 * @author juliorojas
 */
public class Seat {

    private final int id;
    private final Row row;
    private Status status;

    public Seat(int id, Row row) {
        this.id = id;
        this.row = row;
        status = Status.AVAILABLE;
    }

    public int getId() {
        return id;
    }

    public Row getRow() {
        return row;
    }

    public Status getStatus() {
        return status;
    }

    public void setStatus(Status status) {
        this.status = status;
    }
}
