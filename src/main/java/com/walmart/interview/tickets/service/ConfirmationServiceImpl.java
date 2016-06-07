package com.walmart.interview.tickets.service;

import com.walmart.interview.tickets.bean.SeatHold;
import java.util.UUID;

/**
 * Implementation of the ConfirmationService interface.
 *
 * @author juliorojas
 */
public class ConfirmationServiceImpl implements ConfirmationService {

    @Override
    public String generateConfirmation(SeatHold seatHold) {
        String uuid = UUID.randomUUID().toString();
        return uuid;
    }
}
