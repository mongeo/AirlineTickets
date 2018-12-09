package com.example.g.airlinetickets.database;

public class ReservationSchema {
    public static final class ReservationTable {

        public static final String NAME = "reservations";

        public static final class Cols {
            public static final String UUID = "uuid";
            public static final String RESERVATION_NUM = "reservationNum";
            public static final String UNAME = "uname";
            public static final String FLIGHT_NUM = "flightNum";
            public static final String TICKET_COUNT = "ticketCount";
        }
    }
}