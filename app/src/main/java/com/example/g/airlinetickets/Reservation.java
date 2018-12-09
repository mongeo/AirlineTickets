package com.example.g.airlinetickets;

import java.util.UUID;

public class Reservation {
    private UUID reservationID;
    private int reservationNum;
    private String uname;
    private String flightNum;
    private int ticketCount;

    public Reservation(){
        reservationID = UUID.randomUUID();
    }

    public Reservation(int reservationNum, String uname, String flightNum, int ticketCount) {
        this.reservationID = UUID.randomUUID();
        this.reservationNum = reservationNum;
        this.uname = uname;
        this.flightNum = flightNum;
        this.ticketCount = ticketCount;
    }

    public UUID getReservationID() {
        return reservationID;
    }

    public void setReservationID(UUID reservationID) {
        this.reservationID = reservationID;
    }

    public int getReservationNum() {
        return reservationNum;
    }

    public void setReservationNum(int reservationNum) {
        this.reservationNum = reservationNum;
    }

    public String getUname() {
        return uname;
    }

    public void setUname(String uname) {
        this.uname = uname;
    }

    public String getFlightNum() {
        return flightNum;
    }

    public void setFlightNum(String flightNum) {
        this.flightNum = flightNum;
    }

    public int getTicketCount() {
        return ticketCount;
    }

    public void setTicketCount(int ticketCount) {
        this.ticketCount = ticketCount;
    }
}
