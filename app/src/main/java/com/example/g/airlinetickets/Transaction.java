package com.example.g.airlinetickets;

import java.util.UUID;
import java.text.SimpleDateFormat;

public class Transaction {

    private UUID transactionID;
    private String transactionType;
    private String uname;
    private String flightNum;
    private String reservationNum;
    private SimpleDateFormat date = new SimpleDateFormat("dd-M-yyyy");
    private SimpleDateFormat time = new SimpleDateFormat("HH:mm:ss");

    public Transaction(){
        transactionID = UUID.randomUUID();
    }

    public Transaction(String transactionType, String uname, String flightNum, String reservationNum, SimpleDateFormat date, SimpleDateFormat time) {
        this.transactionID = UUID.randomUUID();
        this.transactionType = transactionType;
        this.uname = uname;
        this.flightNum = flightNum;
        this.reservationNum = reservationNum;
        this.date = date;
        this.time = time;
    }

    public UUID getTransactionID() {
        return transactionID;
    }

    public void setTransactionID(UUID transactionID) {
        this.transactionID = transactionID;
    }

    public String getTransactionType() {
        return transactionType;
    }

    public void setTransactionType(String transactionType) {
        this.transactionType = transactionType;
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

    public String getReservationNum() {
        return reservationNum;
    }

    public void setReservationNum(String reservationNum) {
        this.reservationNum = reservationNum;
    }

    public SimpleDateFormat getDate() {
        return date;
    }

    public void setDate(SimpleDateFormat date) {
        this.date = date;
    }

    public SimpleDateFormat getTime() {
        return time;
    }

    public void setTime(SimpleDateFormat time) {
        this.time = time;
    }
}
