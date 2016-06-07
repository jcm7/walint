package com.walmart.interview.tickets.service;

import com.walmart.interview.tickets.bean.SeatHold;
import com.walmart.interview.tickets.bean.Venue;
import java.util.Optional;

/**
 * Provides methods for find, reserving and getting total of available seats.
 *
 * @author juliorojas
 */
public interface VenueService {

    public abstract int getNumSeatsAvailable(Venue venue, Optional<Integer> venueLevel);

    public abstract SeatHold findAndHoldSeats(Venue venue, int numSeats, Optional<Integer> minLevel,
            Optional<Integer> maxLevel, String customerEmail);
}
