package com.walmart.interview.tickets.test;

import com.walmart.interview.tickets.bean.ConcertHall;
import com.walmart.interview.tickets.bean.Level;
import com.walmart.interview.tickets.service.ConcertHallTicketService;
import com.walmart.interview.tickets.service.TicketService;
import java.util.Optional;
import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 * A test class for the TicketService interface.
 *
 * @author juliorojas
 */
public class TicketServiceTest {

    // Total available seats for concert hall: 
    //    Level 0: 25 rows, 50 seats  = 1250
    //    Level 1: 20 rows, 100 seats = 2000
    //    Level 2: 15 rows, 100 seats = 1500
    //    Level 3: 15 rows, 100 seats = 1500
    //                          Total = 6250
    TicketService ticketService;
    private static final String TEST_EMAIL = "test@test";

    @Before
    public void setup() {
        this.ticketService = new ConcertHallTicketService();
    }

    @Test
    public void testInitialTotalNumFound() {
        ConcertHall ch = new ConcertHall();
        int totalExpected = 0;
        for (Level level : ch.getLevels()) {
            totalExpected += level.getNumSeatsAvailable();
        }
        int totalActual = ticketService.numSeatsAvailable(Optional.empty());

        assertEquals(totalExpected, totalActual);
    }

    @Test
    public void testInitialTotalPerLevel() {
        ConcertHall ch = new ConcertHall();
        for (int i = 0; i < ch.getLevels().length; i++) {
            int totalExpected = ch.getLevels()[i].getNumSeatsAvailable();
            int totalActual = ticketService.numSeatsAvailable(Optional.of(i));

            assertEquals(totalExpected, totalActual);
        }
    }

    @Test
    public void testHoldPerLevel() {
        final int toReserve = 1;
        ConcertHall ch = new ConcertHall();
        int totalExpected = ch.getLevels()[0].getNumSeatsAvailable() - toReserve;
        ticketService.findAndHoldSeats(toReserve, Optional.of(0), Optional.of(0), TEST_EMAIL);
        int totalActual = ticketService.numSeatsAvailable(Optional.of(0));

        assertEquals(totalExpected, totalActual);
    }

    @Test
    public void testHoldPerMultiLevel() {
        final int toReserve = 1253; // reserve more than the alloted in level 0.
        ConcertHall ch = new ConcertHall();
        int totalExpected = (ch.getLevels()[0].getNumSeatsAvailable() + ch.getLevels()[1].getNumSeatsAvailable()) - toReserve;
        ticketService.findAndHoldSeats(toReserve, Optional.of(0), Optional.of(1), TEST_EMAIL);
        int totalActual = ticketService.numSeatsAvailable(Optional.of(0)) + ticketService.numSeatsAvailable(Optional.of(1));

        assertEquals(totalExpected, totalActual);
    }
}
