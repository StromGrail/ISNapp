package com.isn;
import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import java.util.Timer;
import java.util.TimerTask;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.content.Intent;
import android.graphics.Bitmap;
import android.net.Uri;
import android.os.Bundle;
import android.os.Parcelable;
import android.support.v4.view.PagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBar;
import android.support.v7.app.ActionBarActivity;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup.LayoutParams;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.nostra13.universalimageloader.core.DisplayImageOptions;
import com.nostra13.universalimageloader.core.ImageLoader;
import com.nostra13.universalimageloader.core.display.FadeInBitmapDisplayer;
import com.nostra13.universalimageloader.core.display.RoundedBitmapDisplayer;
import com.nostra13.universalimageloader.core.listener.ImageLoadingListener;
import com.nostra13.universalimageloader.core.listener.SimpleImageLoadingListener;

public class HomeActivity  extends ActionBarActivity implements
NavigationDrawerFragment.NavigationDrawerCallbacks, IActionBarUpdate{

	private NavigationDrawerFragment mNavigationDrawerFragment;
	private ActionBar actionBar = null;
	private RelativeLayout imgcartwithcircle = null;
	private ImageView imgcartcircle = null;
	private ImageView imgCart = null;
	private int checkForActionbarIcon = -1;
	private ImageView imgLocation = null; 
	private boolean popupCheck = false;
	private ViewPagerAdapter adapter;
	private ViewPager myPager = null;
	private ArrayList<String> arList = null;
	protected ImageLoader imageLoader = ImageLoader.getInstance();
	private Timer timer;
	private MyTimerTask myTimerTask;
	private int counter = 1;
	private ImageView img1, img2, img3, img4;
	
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_home);
		
		mNavigationDrawerFragment = (NavigationDrawerFragment) getSupportFragmentManager()
				.findFragmentById(R.id.navigation_drawer);

		// Set up the drawer.
		mNavigationDrawerFragment.setUp(R.id.navigation_drawer,
				(DrawerLayout) findViewById(R.id.drawer_layout));
		
		myPager = (ViewPager) findViewById(R.id.myfivepanelpager);
		
		img1= (ImageView)findViewById(R.id.imageView1);
		ImageLoader.getInstance().displayImage("http://3.imimg.com/data3/BR/BN/MY-4543506895/58-copy-500x500.jpg", img1);
		
		
		img2= (ImageView)findViewById(R.id.imageView2);
		ImageLoader.getInstance().displayImage("http://picsg.files.wordpress.com/2014/01/shilpa-shetty-bollywood-indian-wear-ankle-length-fancy-anarkali-frock-new-fashion-dress-2.jpg", img2);

		img3= (ImageView)findViewById(R.id.imageView3);
		ImageLoader.getInstance().displayImage("http://images.cxotoday.com/2013/02/mobile_phones_voFvF.jpg", img3);

		img4= (ImageView)findViewById(R.id.imageView4);
		ImageLoader.getInstance().displayImage("http://www.bikeexchange.com.au/dbimages/bike/fn_3/40/102214040/popup/moon-300-04.jpg?201407021154", img4);

		arList = new ArrayList<String>();
		
		arList.add("http://i.bollywoodmantra.com/albums/wallpapers/hrithik-roshan-23/hrithik-roshan__748416.jpg");
		arList.add("http://img.wallpaperstock.net:81/well-dressed-male-model-wallpapers_35051_1920x1080.jpg");
		arList.add("http://static.jabong.com/cms/campaign/WeekendStyle_Cmpgp-211114.gif");
		arList.add("http://wallpaperscraft.com/image/louis_vuitton_mens_suit_coat_tie_shirt_43910_2560x1440.jpg");
		arList.add("http://img6a.flixcart.com/www/promos/new/20141106_150623_730x300_image-730-300.jpg");
		arList.add("http://images.wallpapersmela.com/2014/08/Full-View-and-Download-Model-Hd-Wallpaper.jpg");
		
		
		timer = new Timer();
	    myTimerTask = new MyTimerTask();
	    
	        //singleshot delay 1000 ms
	        timer.schedule(myTimerTask, 2000);
	        //delay 1000ms, repeat in 5000ms
	       // timer.schedule(myTimerTask, 1000, 5000);
		
		adapter = new ViewPagerAdapter(HomeActivity.this, arList);
		myPager.setAdapter(adapter);
		myPager.setCurrentItem(0);
		

		NavigationDrawerFragment.selHomeActivity=false;
		NavigationDrawerFragment.selMenActivity=false;
	
		img1.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				Intent iAbout = new Intent(getApplicationContext(), MenActivity.class);
				iAbout.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
				startActivity(iAbout);
				overridePendingTransition(R.anim.slide_in_left,
	                    R.anim.slide_out_left);	
				
				}
		});
		
		img2.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				Intent iAbout = new Intent(getApplicationContext(), WomenActivity.class);
				iAbout.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
				startActivity(iAbout);
				overridePendingTransition(R.anim.slide_in_left,
	                    R.anim.slide_out_left);
				}
		});
		
		img3.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				// TODO Auto-generated method stub
				Intent iAbout = new Intent(getApplicationContext(), MobileActivity.class);
				iAbout.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
				startActivity(iAbout);
				overridePendingTransition(R.anim.slide_in_left,
	                    R.anim.slide_out_left);
						}
		});
		
		img4.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				Toast.makeText(getApplicationContext(), "Image 4 clicked.", Toast.LENGTH_SHORT).show();
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
	         Toast.makeText(HomeActivity.this, 
	         "There is no email client installed.", Toast.LENGTH_SHORT).show();
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
		actionBar.getCustomView().findViewById(R.id.actionbar_notifcation_textview);
		
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
	
	class ViewPagerAdapter extends PagerAdapter {
		DisplayImageOptions options;
		protected ImageLoader imageLoader = ImageLoader.getInstance();
		private ImageLoadingListener animateFirstListener = new AnimateFirstDisplayListener();

		private Activity activity;
		private ArrayList<String> list;

		public ViewPagerAdapter(Activity act, ArrayList<String> cartList) {
			this.list = cartList;
			activity = act;
			
			animateFirstListener = new AnimateFirstDisplayListener();
			options = new DisplayImageOptions.Builder()
			.showImageOnLoading(R.drawable.line_popup)
			.showImageForEmptyUri(R.drawable.line_popup)
			.showImageOnFail(R.drawable.line_popup)
			.cacheInMemory(true)
			.cacheOnDisc(true)
			.considerExifParams(true)
			.displayer(new RoundedBitmapDisplayer(0))
			.build();
		}

		public int getCount() {
			return list.size();
		}


		@SuppressLint("InflateParams") @SuppressWarnings({ "deprecation", "static-access" })
		public Object instantiateItem(View collection, final int position) {
			View  view = new View (activity);
			view.setLayoutParams(new LayoutParams(LayoutParams.FILL_PARENT,LayoutParams.FILL_PARENT));
			//pagerPosstion=position;
			// not in cache, inflate manually
			LayoutInflater inflater = (LayoutInflater) collection.getContext().getSystemService(HomeActivity.LAYOUT_INFLATER_SERVICE);
			view = inflater.inflate(R.layout.headerflash, null);
			ImageView headerflashImageview = (ImageView)view.findViewById(R.id.headerimg); 

			imageLoader.getInstance().displayImage(list.get(position), headerflashImageview, options, animateFirstListener);

			((ViewPager) collection).addView(view, 0);			
			//	imageadapter.notifyDataSetChanged();

			return view;
		}

		@Override
		public void destroyItem(View arg0, int arg1, Object arg2) {
			((ViewPager) arg0).removeView((View) arg2);
		}

		@Override
		public boolean isViewFromObject(View arg0, Object arg1) {
			return arg0 == ((View) arg1);
		}

		@Override   
		public Parcelable saveState() {
			return null;
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
	
	class MyTimerTask extends TimerTask {

		  @Override
		  public void run() {
		   
		   runOnUiThread(new Runnable(){

		    @Override
		    public void run() {
		    	myPager.setCurrentItem(counter);
		    	timer.cancel();
		    	timer = new Timer();
			    myTimerTask = new MyTimerTask();
		    	 timer.schedule(myTimerTask, 2000);
		    	 
		    	 counter++;
		    	 if(counter == arList.size())
		    		 counter = 0;
		    
		    }});
		  }
	}
	
}
