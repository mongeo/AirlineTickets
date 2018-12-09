package com.example.g.airlinetickets;

import java.util.UUID;

public class Flight {
    private UUID flightID;
    private String flightNum;
    private String departure;
    private String arrival;
    private String departureTime;
    private int seats;
    private double price;

    public Flight(){
        this.flightID = UUID.randomUUID();
    }

    public Flight(String flightNum, String departure, String arrival, String departureTime, int seats, double price) {
        this.flightID = UUID.randomUUID();
        this.flightNum = flightNum;
        this.departure = departure;
        this.arrival = arrival;
        this.departureTime = departureTime;
        this.seats = seats;
        this.price = price;
    }

    public UUID getFlightID() {
        return flightID;
    }

    public void setFlightID(UUID flightID) {
        this.flightID = flightID;
    }

    public String getFlightNum() {
        return flightNum;
    }

    public void setFlightNum(String flightNum) {
        this.flightNum = flightNum;
    }

    public String getDeparture() {
        return departure;
    }

    public void setDeparture(String departure) {
        this.departure = departure;
    }

    public String getArrival() {
        return arrival;
    }

    public void setArrival(String arrival) {
        this.arrival = arrival;
    }

    public String getDepartureTime() {
        return departureTime;
    }

    public void setDepartureTime(String departureTime) {
        this.departureTime = departureTime;
    }

    public int getSeats() {
        return seats;
    }

    public void setSeats(int seats) {
        this.seats = seats;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }
}
