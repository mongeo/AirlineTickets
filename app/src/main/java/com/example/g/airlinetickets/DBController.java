package com.example.g.airlinetickets;

import android.content.Context;
import com.example.g.airlinetickets.database.DataBaseHelper;

public class DBController {
    private static DBController sDBController;
    private Context mContext;
    private DataBaseHelper mDataBaseHelper;

    private DBController(Context context) {
        mContext = context.getApplicationContext();
        mDataBaseHelper = new DataBaseHelper(mContext);
    }

    public static DBController get(Context context) {
        if (sDBController == null) {
            sDBController = new DBController(context);
        }
        return sDBController;
    }

    //User functions
    public boolean userExists(String user){
        return mDataBaseHelper.userExists(user);
    }

    public boolean addUser(String username, String password){
        return mDataBaseHelper.addUser(username, password);
    }

    //Transaction functions
    public boolean addTransaction(String username){
        return mDataBaseHelper.addTransaction(username);
    }
}
