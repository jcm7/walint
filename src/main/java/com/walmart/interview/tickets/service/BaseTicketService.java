package com.walmart.interview.tickets.service;

import com.walmart.interview.tickets.bean.SeatHold;
import com.walmart.interview.tickets.bean.SeatHoldKey;
import com.walmart.interview.tickets.bean.Status;
import com.walmart.interview.tickets.bean.Venue;
import java.util.Map;
import java.util.Optional;

/**
 * Provides base implementations of the TicketService interface.
 *
 * @author juliorojas
 */
public abstract class BaseTicketService<T> implements TicketService<T> {

    protected Venue venue;
    private final ConfirmationService confirmService = new ConfirmationServiceImpl();
    private final VenueService venueService = new VenueServiceImpl();

    @Override
    public int numSeatsAvailable(Optional<Integer> venueLevel) {
        return venueService.getNumSeatsAvailable(venue, venueLevel);
    }

    @Override
    public SeatHold findAndHoldSeats(int numSeats, Optional<Integer> minLevel,
            Optional<Integer> maxLevel, String customerEmail) {
        return venueService.findAndHoldSeats(venue, numSeats, minLevel,
                maxLevel, customerEmail);
    }

    @Override
    public String reserveSeats(int seatHoldId, String customerEmail) {
        Map<SeatHoldKey, SeatHold> reservations = venue.getReservations();
        SeatHold seatHold = reservations.get(new SeatHoldKey(seatHoldId, customerEmail));
        if (seatHold == null) {
            return "Cannot find seats hold";
        }
        return reserve(seatHold);
    }

    /**
     * Makes the reservation, creates a confirmation number and sets it to the
     * reservation
     *
     * @param seatHold the reservation to confirm
     * @return reservation's confirmation number
     */
    private String reserve(SeatHold seatHold) {
        seatHold.setStatus(Status.RESERVED);
        String confirmId = confirmService.generateConfirmation(seatHold);
        seatHold.setConfirmNumber(confirmId);
        return confirmId;
    }
}
