package com.walmart.interview.tickets.service;

import com.walmart.interview.tickets.bean.Level;
import com.walmart.interview.tickets.bean.Row;
import com.walmart.interview.tickets.bean.Seat;
import com.walmart.interview.tickets.bean.SeatHold;
import com.walmart.interview.tickets.bean.SeatHoldKey;
import com.walmart.interview.tickets.bean.Status;
import com.walmart.interview.tickets.bean.Venue;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.Random;

/**
 * Implementation of VenueService.
 *
 * @author juliorojas
 */
public class VenueServiceImpl implements VenueService {

    private final Random random = new Random();

    @Override
    public int getNumSeatsAvailable(Venue venue, Optional<Integer> venueLevel) {
        int totalAvailable = 0;
        if (venueLevel.isPresent()) {
            return venue.getLevels()[venueLevel.get()].getNumSeatsAvailable();
        }
        for (Level level : venue.getLevels()) {
            totalAvailable += level.getNumSeatsAvailable();
        }
        return totalAvailable;
    }

    @Override
    public SeatHold findAndHoldSeats(Venue venue, int numSeats, Optional<Integer> minLevel,
            Optional<Integer> maxLevel, String customerEmail) {
        List<Seat> holdSeats = findSeats(venue, numSeats, minLevel, maxLevel);
        if (holdSeats.size() == numSeats) {
            for (Seat seat : holdSeats) {
                seat.setStatus(Status.ON_HOLD); // Change the status of the seat to ON_HOLD.
                int availLevel = seat.getRow().getLevel().getNumSeatsAvailable();
                seat.getRow().getLevel().setNumSeatsAvailable(availLevel - 1);
            }

            SeatHoldKey key = new SeatHoldKey(random.nextInt(), customerEmail);
            SeatHold seatHold = new SeatHold(key, holdSeats.toArray(new Seat[0]), Status.ON_HOLD);
            venue.getReservations().put(key, seatHold);
            return seatHold;
        }
        return null;
    }

    /**
     * Finds the available seat per row per level
     *
     * @param venue the venue
     * @param numSeats the number of seats to find
     * @param minLevel the minium level to search from
     * @param maxLevel the maximum level to search from
     * @return list of available seats found
     */
    private List<Seat> findSeats(Venue venue, int numSeats, Optional<Integer> minLevel,
            Optional<Integer> maxLevel) {
        int startLevel = minLevel.orElse(0);
        int endLevel = maxLevel.orElse(venue.getLevels().length - 1);
        List<Seat> holdSeats = new ArrayList<>();
        int numHold = 0;
        // Check the available seats per Row per Level.
        for (int nLevel = startLevel; nLevel <= endLevel; nLevel++) {
            Level level = venue.getLevels()[nLevel];
            Row[] rows = level.getRows();
            for (int nRow = 0; nRow < rows.length; nRow++) {
                Seat[] seats = rows[nRow].getSeats();
                for (int nSeat = 0; nSeat < seats.length; nSeat++) {
                    // Only consider seats with Status = Available.
                    if (seats[nSeat].getStatus() == Status.AVAILABLE) {
                        holdSeats.add(seats[nSeat]);
                        numHold++;
                        // Return when the number of desired seats has been found.
                        if (numHold == numSeats) {
                            return holdSeats;
                        }
                    }
                }
            }
        }
        return holdSeats;
    }
}
