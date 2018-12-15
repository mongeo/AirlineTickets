package com.example.g.airlinetickets;

import android.app.AlertDialog;
import android.app.Dialog;
import android.app.DialogFragment;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class CreateAccountActivity extends AppCompatActivity {

    DBController dbController;

    private TextView mCreateAccountUsernameField;
    private TextView mCreateAccountPasswordField;
    private Button mSubmitCreateAccountButton;

    private String name;
    private String pass;

    private int count;

    protected Context mContext;

    private boolean validCredentials(String username, String password){
        boolean validUser = false;
        boolean validPass = false;

        //test user
        int alphaCount = 0;
        int numericCount = 0;
        for (int i = 0; i < username.length(); i++){
            if (Character.isDigit(username.charAt(i))){
                numericCount++;
            } else if (Character.isAlphabetic(username.charAt(i))){
                alphaCount++;
            }
        }
        if (alphaCount > 2 && numericCount > 0){
            validUser = true;
        }

        //test pass
        alphaCount = 0;
        numericCount = 0;
        for (int i = 0; i < password.length(); i++){
            if (Character.isDigit(password.charAt(i))){
                numericCount++;
            } else if (Character.isAlphabetic(password.charAt(i))){
                alphaCount++;
            }
        }
        if (alphaCount > 2 && numericCount > 0){
            validPass = true;
        }
        if (validUser && validPass)
            return true;
        return false;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_create_account);

        mContext = this.getApplicationContext();

        dbController = DBController.get(mContext);

        count = 0;

        mCreateAccountUsernameField = (TextView) findViewById(R.id.create_account_username_field);
        mCreateAccountPasswordField = (TextView) findViewById(R.id.create_account_password_field);




        mSubmitCreateAccountButton = (Button) findViewById(R.id.submit_create_account_button);
        mSubmitCreateAccountButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                name = mCreateAccountUsernameField.getText().toString();
                pass = mCreateAccountPasswordField.getText().toString();

                boolean exists = dbController.userExists(name);
                boolean valid = validCredentials(name, pass);

                if (count > 0 && (exists || !valid )){
                    String errorText = "";

                    if (!validCredentials(name, pass)){
                        errorText = "Invalid format.";
                    } else if (dbController.userExists(name) == true){
                        errorText = "Username already exists.";
                    }
                    AlertDialog createdUnsuccessfullyAlert = new AlertDialog.Builder(CreateAccountActivity.this).create();
                    createdUnsuccessfullyAlert.setTitle("Unsuccessful");
                    createdUnsuccessfullyAlert.setMessage(errorText);
                    createdUnsuccessfullyAlert.setButton(AlertDialog.BUTTON_NEUTRAL, "OK",
                            new DialogInterface.OnClickListener() {
                                public void onClick(DialogInterface dialog, int which) {
                                    finish();
                                }
                            });
                    createdUnsuccessfullyAlert.show();
                } else {
                    //check if proper format
                    if (!valid){
                        Toast.makeText(CreateAccountActivity.this,
                                "Invalid format.",
                                Toast.LENGTH_SHORT).show();
                    }

                    //check if user already exists
                    else if (exists){
                        Toast.makeText(CreateAccountActivity.this,
                                "Username already exist.",
                                Toast.LENGTH_SHORT).show();
                    }

                    //user is added
                    else {
                        dbController.addUser(name, pass);
                        dbController.addTransaction(name);


                        AlertDialog createdSuccessfullyAlert = new AlertDialog.Builder(CreateAccountActivity.this).create();
                        createdSuccessfullyAlert.setTitle("Success!");
                        createdSuccessfullyAlert.setMessage("User " + name + " created successfully!");
                        createdSuccessfullyAlert.setButton(AlertDialog.BUTTON_NEUTRAL, "OK",
                                new DialogInterface.OnClickListener() {
                                    public void onClick(DialogInterface dialog, int which) {
                                        finish();
                                    }
                                });
                        createdSuccessfullyAlert.show();

                        //Toast.makeText(CreateAccountActivity.this,
                        //        "User " + name + " created!",
                        //        Toast.LENGTH_SHORT).show();

                    }

                    count++;
                }
            }
        });
    }
}
