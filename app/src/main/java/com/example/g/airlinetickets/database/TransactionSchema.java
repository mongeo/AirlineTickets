package com.example.g.airlinetickets.database;

public class TransactionSchema {

    public static final class TransactionTable {

        public static final String NAME = "transactions";

        public static final class Cols {
            public static final String UUID = "uuid";
            public static final String TYPE = "type";
            public static final String UNAME = "uname";
            public static final String FLIGHT_NUM = "flightNum";
            public static final String RESERVATION_NUM = "reservationNum";
            public static final String DATE = "date";
            public static final String TIME = "time";
        }
    }
}