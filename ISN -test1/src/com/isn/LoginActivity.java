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



@TargetApi(Build.VERSION_CODES.ICE_CREAM_SANDWICH) public class LoginActivity  extends ActionBarActivity {

	Button btnSignIn,btnSignUp;
    LoginDataBaseAdapter loginDataBaseAdapter;
 
    @Override
    protected void onCreate(Bundle savedInstanceState) 
    {
         super.onCreate(savedInstanceState);
         setContentView(R.layout.activity_login);
 
         // create a instance of SQLite Database
         loginDataBaseAdapter=new LoginDataBaseAdapter(this);
         loginDataBaseAdapter=loginDataBaseAdapter.open();
 
         // Get The Refference Of Buttons
         btnSignIn=(Button)findViewById(R.id.buttonSignIN);
         btnSignUp=(Button)findViewById(R.id.buttonSignUP);
 
        // Set OnClick Listener on SignUp button 
        btnSignUp.setOnClickListener(new View.OnClickListener() {
        public void onClick(View v) {
            // TODO Auto-generated method stub
 
            /// Create Intent for SignUpActivity  abd Start The Activity
            Intent intentSignUP=new Intent(getApplicationContext(),SignUPActivity.class);
            startActivity(intentSignUP);
            }
        });
    }
    // Methos to handleClick Event of Sign In Button
    public void signIn(View V)
       {
            final Dialog dialog = new Dialog(LoginActivity.this);
            dialog.setContentView(R.layout.login);
            dialog.setTitle("Login");
 
            // get the Refferences of views
            final  EditText editTextUserName=(EditText)dialog.findViewById(R.id.editTextUserNameToLogin);
            final  EditText editTextPassword=(EditText)dialog.findViewById(R.id.editTextPasswordToLogin);
 
            Button btnSignIn=(Button)dialog.findViewById(R.id.buttonSignIn);
 
            // Set On ClickListener
            btnSignIn.setOnClickListener(new View.OnClickListener() {
 
                public void onClick(View v) {
                    // get The User name and Password
                    String userName=editTextUserName.getText().toString();
                    String password=editTextPassword.getText().toString();
 
                    // fetch the Password form database for respective user name
                    String storedPassword=loginDataBaseAdapter.getSinlgeEntry(userName);
 
                    // check if the Stored password matches with  Password entered by user
                    if(password.equals(storedPassword))
                    {
                    	Toast.makeText(getApplicationContext(), "Redirecting...", 
                    		      Toast.LENGTH_SHORT).show();
                        dialog.dismiss();
                        Intent iAbout = new Intent(getApplicationContext(), HomeActivity.class);
						iAbout.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
						startActivity(iAbout);
						overridePendingTransition(R.anim.slide_in_left,
			                    R.anim.slide_out_left);
                    }
                    else
                    {
                        Toast.makeText(LoginActivity.this, "User Name or Password does not match", Toast.LENGTH_LONG).show();
                    }
                }
            });
 
            dialog.show();
    }
 
    @Override
    protected void onDestroy() {
        super.onDestroy();
        // Close The Database
        loginDataBaseAdapter.close();
    }	
	
    
    
    
}
	 /*  private EditText  username=null;
	   private EditText  password=null;
	   private TextView attempts;
	   private Button login;
	   int counter = 3;
	   @SuppressLint("CutPasteId") @Override
	   protected void onCreate(Bundle savedInstanceState) {
	      super.onCreate(savedInstanceState);
	      setContentView(R.layout.activity_login);
	      username = (EditText)findViewById(R.id.username);
	      password = (EditText)findViewById(R.id.password);
	      attempts = (TextView)findViewById(R.id.attempt);
	      attempts.setText(Integer.toString(counter));
	      login = (Button)findViewById(R.id.loginbutton);
	      
			
	      login.setOnClickListener(new View.OnClickListener() {
		         public void onClick(final View view) {
		        	 Handler handler = new Handler(); 
		        	    handler.postDelayed(new Runnable() { 
		        	         public void run() { 
		        	        	 login(view);
		        	         } 
		        	    }, 1000); 
		        	    if(username.getText().toString().equals("admin") && 
		        	  	      password.getText().toString().equals("admin")){
		        	 Intent iAbout = new Intent(getApplicationContext(), HomeActivity.class);
						iAbout.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
						startActivity(iAbout);
						overridePendingTransition(R.anim.slide_in_left,
			                    R.anim.slide_out_left);
		        	    }else{}
		      }
		   });

	      
	   }

	   public void login(View view){
	      if(username.getText().toString().equals("admin") && 
	      password.getText().toString().equals("admin")){
	      Toast.makeText(getApplicationContext(), "Redirecting...", 
	      Toast.LENGTH_SHORT).show();
	      
	   }	
	   else{
	      Toast.makeText(getApplicationContext(), "Wrong Credentials ....",
	      Toast.LENGTH_SHORT).show();
	      attempts.setBackgroundColor(Color.RED);	
	      counter--;
	      attempts.setText(Integer.toString(counter));
	      if(counter==0){
	         login.setEnabled(false);
	      }

	   }

	}
	   @Override
	   public boolean onCreateOptionsMenu(Menu menu) {
	      // Inflate the menu; this adds items to the action bar if it is present.
	      getMenuInflater().inflate(R.menu.main, menu);
	      return true;
	   }


}*/