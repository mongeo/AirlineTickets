package com.example.g.airlinetickets.database;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import com.example.g.airlinetickets.Transaction;
import com.example.g.airlinetickets.User;

import java.text.SimpleDateFormat;

public class DataBaseHelper extends SQLiteOpenHelper {
    private static final String LOG = "DatabaseHelper";
    private static final int DATABASE_VERSION = 1;
    private static final String DATABASE_NAME = "airlines.db";

    //Table create statements
    //Table users
    private static final String CREATE_TABLE_USER =
            "create table " + UserSchema.UserTable.NAME + "(" +
                    " _id integer primary key autoincrement, " +
                    UserSchema.UserTable.Cols.UUID + ","+
                    UserSchema.UserTable.Cols.UNAME + ","+
                    UserSchema.UserTable.Cols.PWORD +  ")";

    //Table flights
    private static final String CREATE_TABLE_FLIGHT =
            "create table " + FlightSchema.FlightTable.NAME + "(" +
                    " _id integer primary key autoincrement, " +
                    FlightSchema.FlightTable.Cols.UUID + ","+
                    FlightSchema.FlightTable.Cols.FLIGHT + ","+
                    FlightSchema.FlightTable.Cols.DEPARTURE + ","+
                    FlightSchema.FlightTable.Cols.ARRIVAL + ","+
                    FlightSchema.FlightTable.Cols.DEPARTURE_TIME + ","+
                    FlightSchema.FlightTable.Cols.SEATS + ","+
                    FlightSchema.FlightTable.Cols.PRICE + ")";

    //Table reservations
    private static final String CREATE_TABLE_RESERVATION =
            "create table " + ReservationSchema.ReservationTable.NAME + "(" +
                    " _id integer primary key autoincrement, " +
                    ReservationSchema.ReservationTable.Cols.UUID + ","+
                    ReservationSchema.ReservationTable.Cols.RESERVATION_NUM + ","+
                    ReservationSchema.ReservationTable.Cols.UNAME + ","+
                    ReservationSchema.ReservationTable.Cols.FLIGHT_NUM + ","+
                    ReservationSchema.ReservationTable.Cols.TICKET_COUNT + ")";

    //Table transactions
    private static final String CREATE_TABLE_TRANSACTION=
            "create table " + TransactionSchema.TransactionTable.NAME + "(" +
                    " _id integer primary key autoincrement, " +
                    TransactionSchema.TransactionTable.Cols.UUID + ","+
                    TransactionSchema.TransactionTable.Cols.TYPE + ","+
                    TransactionSchema.TransactionTable.Cols.UNAME + ","+
                    TransactionSchema.TransactionTable.Cols.FLIGHT_NUM + ","+
                    TransactionSchema.TransactionTable.Cols.RESERVATION_NUM + ","+
                    TransactionSchema.TransactionTable.Cols.DATE + ")";

    private SQLiteDatabase db;

    public DataBaseHelper(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    //User functions
    public boolean userExists(String username){
        SQLiteDatabase db = this.getReadableDatabase();
        String selectQuery =
                "SELECT _id " +
                "FROM " + UserSchema.UserTable.NAME + " " +
                "WHERE " + UserSchema.UserTable.Cols.UNAME + " = \"" + username + "\";";
        Cursor userCount = db.rawQuery(selectQuery, null);
        if (userCount.getCount() > 0){
            userCount.close();
            return true;
        }
        userCount.close();
        return false;
    }

    public boolean addUser(String username, String password){
        SQLiteDatabase db = this.getWritableDatabase();
        User user = new User(username, password);

        ContentValues values = new ContentValues();

        values.put(UserSchema.UserTable.Cols.UUID, user.getUserID().toString());
        values.put(UserSchema.UserTable.Cols.UNAME, user.getUname());
        values.put(UserSchema.UserTable.Cols.PWORD, user.getPword());


        // insert row
        db.insert(UserSchema.UserTable.NAME, null, values);
        return true;
    }

    //Transaction functions
    //user created
    public boolean addTransaction(String username){
        SQLiteDatabase db = this.getWritableDatabase();
        Transaction transaction = new Transaction("UserCreated", username, "null", "null");

        ContentValues values = new ContentValues();

        values.put(TransactionSchema.TransactionTable.Cols.UUID, transaction.getTransactionID().toString());
        values.put(TransactionSchema.TransactionTable.Cols.TYPE, transaction.getTransactionType());
        values.put(TransactionSchema.TransactionTable.Cols.UNAME, transaction.getUname());
        values.put(TransactionSchema.TransactionTable.Cols.FLIGHT_NUM, transaction.getFlightNum());
        values.put(TransactionSchema.TransactionTable.Cols.RESERVATION_NUM, transaction.getReservationNum());
        values.put(TransactionSchema.TransactionTable.Cols.DATE, transaction.getDate().getTime());

        // insert row
        db.insert(TransactionSchema.TransactionTable.NAME, null, values);
        return true;
    }

@Override
    public void onCreate(SQLiteDatabase db) {
        // creating required tables
        db.execSQL(CREATE_TABLE_USER);
        db.execSQL(CREATE_TABLE_FLIGHT);
        db.execSQL(CREATE_TABLE_RESERVATION);
        db.execSQL(CREATE_TABLE_TRANSACTION);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        // on upgrade drop older tables
        db.execSQL("DROP TABLE IF EXISTS " + UserSchema.UserTable.NAME);
        db.execSQL("DROP TABLE IF EXISTS " + FlightSchema.FlightTable.NAME);
        db.execSQL("DROP TABLE IF EXISTS " + ReservationSchema.ReservationTable.NAME);
        db.execSQL("DROP TABLE IF EXISTS " + TransactionSchema.TransactionTable.NAME);

        // create new tables
        onCreate(db);
    }
}
