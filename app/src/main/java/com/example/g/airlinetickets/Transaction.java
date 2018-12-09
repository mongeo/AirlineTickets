package com.example.g.airlinetickets;

import java.util.Date;
import java.util.UUID;
import java.text.SimpleDateFormat;

public class Transaction {

    private UUID transactionID;
    private String transactionType;
    private String uname;
    private String flightNum;
    private String reservationNum;

    private SimpleDateFormat ft = new SimpleDateFormat("dd-M-yyyy @ HH:mm:ss");
    private Date date;

    public Transaction() {
        transactionID = UUID.randomUUID();
    }

    public Transaction(String transactionType, String uname, String flightNum, String reservationNum) {
        this.transactionID = UUID.randomUUID();
        this.transactionType = transactionType;
        this.uname = uname;
        this.flightNum = flightNum;
        this.reservationNum = reservationNum;
        this.date = new Date();
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

    public SimpleDateFormat getDateFormat() {
        return ft;
    }

    public Date getDate() {
        return date;
    }

    public String getDateString() {
        return ft.format(date);
    }

    public void setDate(Date date) {
        this.date = date;
    }
}