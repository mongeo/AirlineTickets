package com.example.g.airlinetickets;

import java.util.UUID;

public class User {
    private UUID userID;
    private String uname;
    private String pword;

    public User(){
        userID = UUID.randomUUID();
    }

    public User(String uname, String pword) {
        this.userID = UUID.randomUUID();
        this.uname = uname;
        this.pword = pword;
    }

    public UUID getUserID() {
        return userID;
    }

    public void setUserID(UUID userID) {
        this.userID = userID;
    }

    public String getUname() {
        return uname;
    }

    public void setUname(String uname) {
        this.uname = uname;
    }

    public String getPword() {
        return pword;
    }

    public void setPword(String pword) {
        this.pword = pword;
    }


}
