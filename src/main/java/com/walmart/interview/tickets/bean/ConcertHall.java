package com.walmart.interview.tickets.bean;

/**
 * This is a venue for Concert Halls.
 *
 * @author juliorojas
 */
public class ConcertHall extends Venue {

    public ConcertHall() {
        levels = new Level[4];
        levels[0] = new Level(1, "Orchestra", 100, 25, 50);
        levels[1] = new Level(2, "Main", 75, 20, 100);
        levels[2] = new Level(3, "Balcony 1", 50, 15, 100);
        levels[3] = new Level(4, "Balcony 2", 40, 15, 100);
    }
}
