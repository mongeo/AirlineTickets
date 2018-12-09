package com.example.g.airlinetickets.database;

public class UserSchema {

    public static final class UserTable {

        public static final String NAME = "users";

        public static final class Cols {
            public static final String UUID = "uuid";
            public static final String UNAME = "uname";
            public static final String PWORD = "pword";
        }
    }
}