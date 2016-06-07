package com.walmart.interview.tickets.bean;

import java.util.HashMap;
import java.util.Map;

/**
 * Represents a venue for reserving tickets.
 *
 * @author juliorojas
 */
public abstract class Venue {

    /**
     * This map holds both the seat holds and reservations.
     */
    private final Map<SeatHoldKey, SeatHold> reservations = new HashMap<>();

    protected Level[] levels;

    public Level[] getLevels() {
        return levels;
    }

    public Map<SeatHoldKey, SeatHold> getReservations() {
        return reservations;
    }
}
