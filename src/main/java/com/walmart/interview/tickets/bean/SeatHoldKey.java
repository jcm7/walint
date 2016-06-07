package com.walmart.interview.tickets.bean;

/**
 * Represents a key for a seat reservation.
 *
 * @author juliorojas
 */
public class SeatHoldKey {

    private final int id;
    private final String customerEmail;

    public SeatHoldKey(int id, String customerEmail) {
        this.id = id;
        this.customerEmail = customerEmail;
    }

    public int getId() {
        return id;
    }

    public String getCustomerEmail() {
        return customerEmail;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == null || !(obj instanceof SeatHold)) {
            return false;
        }
        SeatHoldKey other = (SeatHoldKey) obj;
        if (this.id != other.id) {
            return false;
        }
        if (this.customerEmail == null && other.getCustomerEmail() == null) {
            return true;
        }
        return (this.customerEmail != null
                && this.customerEmail.equals(other.getCustomerEmail()));
    }

    @Override
    public int hashCode() {
        int hashcode = 1;
        hashcode = 31 * hashcode + id;
        hashcode = 31 * hashcode + customerEmail.hashCode();
        return hashcode;
    }
}
