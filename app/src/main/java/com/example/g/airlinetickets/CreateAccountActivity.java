package com.example.g.airlinetickets;

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
        //test user
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

        dbController = DBController.get(this.getApplicationContext());

        count = 0;

        mCreateAccountUsernameField = (TextView) findViewById(R.id.create_account_username_field);
        mCreateAccountPasswordField = (TextView) findViewById(R.id.create_account_password_field);

        mSubmitCreateAccountButton = (Button) findViewById(R.id.submit_create_account_button);
        mSubmitCreateAccountButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                name = mCreateAccountUsernameField.getText().toString();
                pass = mCreateAccountPasswordField.getText().toString();

                if (count > 0){
                    count = 0;
                    finish();
                } else {
                    //check if proper format
                    if (!validCredentials(name, pass)){
                        Toast.makeText(CreateAccountActivity.this,
                                "Invalid format",
                                Toast.LENGTH_SHORT).show();
                    }

                    //check if user already exists
                    else if (dbController.userExists(name) == true){
                        Toast.makeText(CreateAccountActivity.this,
                                "User already name exists",
                                Toast.LENGTH_SHORT).show();
                    }

                    //user is added
                    else {
                        dbController.addUser(name, pass);
                        Toast.makeText(CreateAccountActivity.this,
                                "User " + name + " created!",
                                Toast.LENGTH_SHORT).show();
                        finish();
                    }

                    count++;
                }
            }
        });
    }
}
