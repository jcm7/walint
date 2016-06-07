package com.walmart.interview.tickets.service;

import com.walmart.interview.tickets.bean.SeatHold;

/**
 * Provides methods for generating confirmation messages.
 *
 * @author juliorojas
 */
public interface ConfirmationService {

    /**
     * Generates a confirmation id from the seat reservation
     *
     * @param seatHold the reservation to generate the confirmation for
     * @return the confirmation code
     */
    public abstract String generateConfirmation(SeatHold seatHold);
}
