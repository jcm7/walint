package com.walmart.interview.tickets.service;

import com.walmart.interview.tickets.bean.ConcertHall;

/**
 * Implementation of the BaseTicketService interface.
 *
 * @author juliorojas
 */
public class ConcertHallTicketService extends BaseTicketService<ConcertHall> {

    public ConcertHallTicketService() {
        this.venue = new ConcertHall();
    }
}
