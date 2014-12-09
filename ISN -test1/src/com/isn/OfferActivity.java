package com.isn;
import java.util.Random;

import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.widget.Toast;

public class OfferActivity  extends ActionBarActivity {

	private static int random,min=2,max=40;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_men);
		

		Random r = new Random();
		random = r.nextInt(max - min + 1) + min;
		
        Toast.makeText(OfferActivity.this, "Offer :- "+random+"% discount", Toast.LENGTH_LONG).show();
        
		
	}
}
