package com.example.g.airlinetickets.database;

public class FlightSchema {

    public static final class FlightTable {

        public static final String NAME = "flights";

        public static final class Cols {
            public static final String UUID = "uuid";
            public static final String FLIGHT = "flight";
            public static final String DEPARTURE = "departure";
            public static final String ARRIVAL = "arrival";
            public static final String DEPARTURE_TIME = "departureTime";
            public static final String SEATS = "seats";
            public static final String PRICE = "price";
        }
    }
}
