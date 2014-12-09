package com.isn;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

import android.annotation.SuppressLint;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBar;
import android.support.v7.app.ActionBarActivity;
import android.view.View;
import android.view.View.OnClickListener;
import android.webkit.WebView;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.nostra13.universalimageloader.core.DisplayImageOptions;
import com.nostra13.universalimageloader.core.ImageLoader;
import com.nostra13.universalimageloader.core.display.FadeInBitmapDisplayer;
import com.nostra13.universalimageloader.core.listener.ImageLoadingListener;
import com.nostra13.universalimageloader.core.listener.SimpleImageLoadingListener;

public class PayPalActivity  extends ActionBarActivity implements
NavigationDrawerFragment.NavigationDrawerCallbacks, IActionBarUpdate{

	private NavigationDrawerFragment mNavigationDrawerFragment;
	private ActionBar actionBar = null;
	private RelativeLayout imgcartwithcircle = null;
	private ImageView imgcartcircle = null;
	private ImageView imgCart = null;
	private int checkForActionbarIcon = -1;
	private ImageView imgLocation = null; 
	private boolean popupCheck = false;
	private String url = null;
	
	DisplayImageOptions options;
	protected ImageLoader imageLoader = ImageLoader.getInstance();
	private ImageLoadingListener animateFirstListener = new AnimateFirstDisplayListener();

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		setContentView(R.layout.paypal);
		
		//url = getIntent().getStringExtra("https://www.paypal.com");
		
		WebView web = (WebView)findViewById(R.id.webpaypal);
		web.loadUrl("https://www.paypal.com");
		
		
		mNavigationDrawerFragment = (NavigationDrawerFragment) getSupportFragmentManager()
				.findFragmentById(R.id.navigation_drawer);

		// Set up the drawer.
		mNavigationDrawerFragment.setUp(R.id.navigation_drawer,
				(DrawerLayout) findViewById(R.id.drawer_layout));
		
		NavigationDrawerFragment.selHomeActivity=false;
		NavigationDrawerFragment.selMenActivity=false;
		
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
