package com.isn;

import java.util.Timer;

import java.util.TimerTask;

import android.annotation.SuppressLint;
import android.annotation.TargetApi;
import android.content.Intent;
import android.graphics.Color;
import android.os.Build;
import android.os.Bundle;
import android.os.Handler;
import android.support.v7.app.ActionBarActivity;
import android.view.Menu;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;



import android.app.Activity;
import android.app.Dialog;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;



@TargetApi(Build.VERSION_CODES.ICE_CREAM_SANDWICH) public class SignUPActivity  extends ActionBarActivity {

	EditText editTextUserName,editTextPassword,editTextConfirmPassword;
    Button btnCreateAccount;
 
    LoginDataBaseAdapter loginDataBaseAdapter;
    @Override
    protected void onCreate(Bundle savedInstanceState) 
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.signup);
 
        // get Instance  of Database Adapter
        loginDataBaseAdapter=new LoginDataBaseAdapter(this);
        loginDataBaseAdapter=loginDataBaseAdapter.open();
 
        // Get Refferences of Views
        editTextUserName=(EditText)findViewById(R.id.editTextUserName);
        editTextPassword=(EditText)findViewById(R.id.editTextPassword);
        editTextConfirmPassword=(EditText)findViewById(R.id.editTextConfirmPassword);
 
        btnCreateAccount=(Button)findViewById(R.id.buttonCreateAccount);
        btnCreateAccount.setOnClickListener(new View.OnClickListener() {
 
        public void onClick(View v) {
            // TODO Auto-generated method stub
 
            String userName=editTextUserName.getText().toString();
            String password=editTextPassword.getText().toString();
            String confirmPassword=editTextConfirmPassword.getText().toString();
 
            // check if any of the fields are vaccant
            if(userName.equals("")||password.equals("")||confirmPassword.equals(""))
            {
                    Toast.makeText(getApplicationContext(), "Field Vaccant", Toast.LENGTH_LONG).show();
                    return;
            }
            // check if both password matches
            if(!password.equals(confirmPassword))
            {
                Toast.makeText(getApplicationContext(), "Password does not match", Toast.LENGTH_LONG).show();
                return;
            }
            else
            {
                // Save the Data in Database
                loginDataBaseAdapter.insertEntry(userName, password);
                Toast.makeText(getApplicationContext(), "Account Successfully Created ", Toast.LENGTH_LONG).show();
            }
        }
    });
}
    @Override
    protected void onDestroy() {
        // TODO Auto-generated method stub
        super.onDestroy();
 
        loginDataBaseAdapter.close();
    }
}