package com.walmart.interview.tickets.bean;

/**
 * Represents a seat reservation.
 *
 * @author juliorojas
 */
public class SeatHold {

    private SeatHoldKey key;
    private Seat[] seats;
    private Status status;
    private String confirmNumber;

    public SeatHold(SeatHoldKey key, Seat[] seats, Status status) {
        this.key = key;
        this.seats = seats;
        this.status = status;
    }

    public SeatHoldKey getKey() {
        return key;
    }

    public void setKey(SeatHoldKey key) {
        this.key = key;
    }

    public Seat[] getSeats() {
        return seats;
    }

    public void setSeats(Seat[] seats) {
        this.seats = seats;
    }

    public Status getStatus() {
        return status;
    }

    public void setStatus(Status status) {
        this.status = status;
    }

    public String getConfirmNumber() {
        return confirmNumber;
    }

    public void setConfirmNumber(String confirmNumber) {
        this.confirmNumber = confirmNumber;
    }
}
