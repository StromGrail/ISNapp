package com.isn;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.graphics.Bitmap;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBar;
import android.support.v7.app.ActionBarActivity;
import android.util.Log;
import android.view.Menu;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.isn.model.women;
import com.nostra13.universalimageloader.core.DisplayImageOptions;
import com.nostra13.universalimageloader.core.ImageLoader;
import com.nostra13.universalimageloader.core.display.FadeInBitmapDisplayer;
import com.nostra13.universalimageloader.core.listener.ImageLoadingListener;
import com.nostra13.universalimageloader.core.listener.SimpleImageLoadingListener;

public class ProductInfoActivity  extends ActionBarActivity implements
NavigationDrawerFragment.NavigationDrawerCallbacks, IActionBarUpdate{

	private NavigationDrawerFragment mNavigationDrawerFragment;
	private ActionBar actionBar = null;
	private RelativeLayout imgcartwithcircle = null;
	private ImageView imgcartcircle = null;
	private ImageView imgCart = null;
	private int checkForActionbarIcon = -1;
	private ImageView imgLocation = null; 
	private boolean popupCheck = false;
	private women obj = null;
	private ImageView imgProduct = null;
	private TextView txtName, txtPrice, txtDescription;
	
	DisplayImageOptions options;
	protected ImageLoader imageLoader = ImageLoader.getInstance();
	private ImageLoadingListener animateFirstListener = new AnimateFirstDisplayListener();
	
	private Button payPalButton = null;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		setContentView(R.layout.productinfo);
		
		obj = (women)getIntent().getSerializableExtra("womenobj");
		
		imgProduct = (ImageView)findViewById(R.id.imageView1);
		txtName = (TextView)findViewById(R.id.textView2);
		txtPrice = (TextView)findViewById(R.id.txtprice);
		txtDescription = (TextView)findViewById(R.id.txtdesc);
		
		payPalButton = (Button)findViewById(R.id.button1);
		
		payPalButton.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				Intent iAbout = new Intent(getApplicationContext(), PayPalActivity.class);
				iAbout.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
				startActivity(iAbout);
				overridePendingTransition(R.anim.slide_in_left,
	                    R.anim.slide_out_left);	
			}
		});
		
		if(obj.getName() != null)
		txtName.setText(obj.getName());
		
		if(obj.getPrice() != 0)
		txtPrice.setText(obj.getPrice()+"");
		
		if(obj.getDescription() != null)
		txtDescription.setText(obj.getDescription());
		
		if(obj.getProductImage() != null)
		imageLoader.getInstance().displayImage(obj.getProductImage(), imgProduct, options, animateFirstListener);

		
		mNavigationDrawerFragment = (NavigationDrawerFragment) getSupportFragmentManager()
				.findFragmentById(R.id.navigation_drawer);

		// Set up the drawer.
		mNavigationDrawerFragment.setUp(R.id.navigation_drawer,
				(DrawerLayout) findViewById(R.id.drawer_layout));
		
		NavigationDrawerFragment.selHomeActivity=false;
		NavigationDrawerFragment.selMenActivity=false;
		
		
		 Button startBtn = (Button) findViewById(R.id.makeCall);
	      startBtn.setOnClickListener(new View.OnClickListener() {
	         public void onClick(View view) {
	         makeCall();
	      }
	   });
	      
	      

			 Button startBtn2 = (Button) findViewById(R.id.sendEmail);
		      startBtn2.setOnClickListener(new View.OnClickListener() {
		         public void onClick(View view) {
		         sendEmail();
		      }
		   });

		
	}
	


	
	protected void sendEmail() {
	      Log.i("Send email", "");

	      String[] TO = {"mohitatul0803@gmail.com"};
	      String[] CC = {"vidipmalhotra@gmail.com"};
	      Intent emailIntent = new Intent(Intent.ACTION_SEND);
	      emailIntent.setData(Uri.parse("mailto:"));
	      emailIntent.setType("text/plain");


	      emailIntent.putExtra(Intent.EXTRA_EMAIL, TO);
	      emailIntent.putExtra(Intent.EXTRA_CC, CC);
	      emailIntent.putExtra(Intent.EXTRA_SUBJECT, "Your subject");
	      emailIntent.putExtra(Intent.EXTRA_TEXT, "Email message goes here");

	      try {
	         startActivity(Intent.createChooser(emailIntent, "Send mail..."));
	         finish();
	         Log.i("Finished sending email...", "");
	      } catch (android.content.ActivityNotFoundException ex) {
	         Toast.makeText(ProductInfoActivity.this, 
	         "There is no email client installed.", Toast.LENGTH_SHORT).show();
	      }
	   }
	  
	

	
	protected void makeCall() {
	      Log.i("Make call", "");
	     
	      Intent phoneIntent = new Intent(Intent.ACTION_CALL);
	      phoneIntent.setData(Uri.parse("tel:"+8377095667L));

	      try {
	         startActivity(phoneIntent);
	         finish();
	         Log.i("Finished making a call...", "");
	      } catch (android.content.ActivityNotFoundException ex) {
	         Toast.makeText(ProductInfoActivity.this, 
	         "Call faild, please try again later.", Toast.LENGTH_SHORT).show();
	      }
	   }
	@Override
	   public boolean onCreateOptionsMenu(Menu menu) {
	      // Inflate the menu; this adds items to the action bar if it is present.
	      getMenuInflater().inflate(R.menu.main, menu);
	      return true;
	   }
	
	
	
	
	@Override
	protected void onResume() {
		// TODO Auto-generated method stub
		UpdateCartStatus();
		super.onResume();
		NavigationDrawerFragment.selHomeActivity=false;
		NavigationDrawerFragment.selMenActivity=false;
	}
	

	@Override
	public void onDestroy() {
		super.onDestroy(); 
	}


	@Override
	public void onStop() {
		super.onStop();
	}

	@Override
	public void onPause() {
		super.onPause();
	}

	
	@Override
	public void onNavigationDrawerItemSelected(int position) {
		// TODO Auto-generated method stub

	}


	

	@SuppressLint("NewApi")
	public void UpdateCartStatus()
	{
		actionBar = getSupportActionBar();
		actionBar.setCustomView(R.layout.actionbarlayout);
		imgLocation = (ImageView) actionBar.getCustomView().findViewById(R.id.imglocation);
		imgCart = (ImageView) actionBar.getCustomView().findViewById(R.id.imgcart); 
		@SuppressWarnings("unused")
		TextView actionbar_notifcation_textview =  (TextView) actionBar.getCustomView().findViewById(R.id.actionbar_notifcation_textview);
		
		TextView titletext =  (TextView) actionBar.getCustomView().findViewById(R.id.titletext);
//		titletext.setTypeface(Utility.UbuntuRegular);

		titletext.setText("Integrated Shoppers Network");
		
//		actionbar_notifcation_textview.setTypeface(Utility.UbuntuMedium);
		
		imgcartcircle = (ImageView) actionBar.getCustomView().findViewById(R.id.imgcartcircle);

		imgLocation.setBackgroundResource(R.drawable.location_iconction);
		
		imgcartwithcircle = (RelativeLayout) actionBar.getCustomView().findViewById(R.id.imgcartwithcircle); 
		
		/*if(!session.getBasketItemCount().equals("0"))
		{
		imgcartwithcircle.setVisibility(View.VISIBLE);
		imgCart.setVisibility(View.GONE);
		imgcartcircle.setBackgroundResource(R.drawable.cart_iconaction);
		actionbar_notifcation_textview.setText(session.getBasketItemCount());
		}
		else 
		{
			imgcartwithcircle.setVisibility(View.GONE);
			imgCart.setVisibility(View.VISIBLE);
			imgCart.setBackgroundResource(R.drawable.cart_iconaction);
		}
*/		actionBar.setDisplayOptions(ActionBar.DISPLAY_SHOW_CUSTOM | ActionBar.DISPLAY_SHOW_HOME);
	//	imgCart.setBackgroundResource(R.drawable.cartactive);		    
		 
	        imgCart.setOnClickListener(new OnClickListener() {
				@Override
				public void onClick(View v) {
					checkForActionbarIcon = 1;
					popupCheck = true;
					imgCart.setBackgroundResource(R.drawable.carticonwhite);
					callPopover(); 
				}
			});
	        
	        imgcartwithcircle.setOnClickListener(new OnClickListener() {
				@Override
				public void onClick(View v) {
					checkForActionbarIcon = 1;
					popupCheck = true;
					imgcartcircle.setBackgroundResource(R.drawable.carticonwhite);
					callPopover(); 
				}
			});
	        
	        imgLocation.setOnClickListener(new OnClickListener() {
				@Override
				public void onClick(View v) {
					checkForActionbarIcon = 0;
					popupCheck = true;
					imgLocation.setBackgroundResource(R.drawable.location_iconction_sel);
					locationPopup();
				}
			});
		
	}
	
	public void actionBarIconSelection(int check)
	{
		if(check == 1)			// for cart
		{
			imgcartcircle.setBackgroundResource(R.drawable.cart_iconaction);
			imgCart.setBackgroundResource(R.drawable.cart_iconaction);
			checkForActionbarIcon = -1;
			popupCheck = false;
		}
		else if(check == 0)		// for location
		{
			imgLocation.setBackgroundResource(R.drawable.location_iconction);
			checkForActionbarIcon = -1;
			popupCheck = false;
		}
		
	}
	
		
	public void locationPopup()
	{
	
		
	}
	
	public void callPopover()
	{
		
	}
	@Override
	public void updateActionBar() {
		// TODO Auto-generated method stub
		if(popupCheck)
		{
        	actionBarIconSelection(checkForActionbarIcon);
		}
	}
	
    private class AnimateFirstDisplayListener extends SimpleImageLoadingListener {

		List<String> displayedImages = Collections.synchronizedList(new LinkedList<String>());

		@Override
		public void onLoadingComplete(String imageUri, View view, Bitmap loadedImage) {
			if (loadedImage != null) {
				//((ImageView) view).setImageBitmap(loadedImage); 
				ImageView imageView = (ImageView) view;
				boolean firstDisplay = !displayedImages.contains(imageUri);
				if (firstDisplay) {
					FadeInBitmapDisplayer.animate(imageView, 500);
					displayedImages.add(imageUri);
				}
			}
		}
	}
}
