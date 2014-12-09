package com.isn;
import java.util.ArrayList;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBar;
import android.support.v7.app.ActionBarActivity;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.AdapterView;
import android.widget.GridView;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.isn.adapter.ProductAdapter;
import com.isn.model.Mobile;

public class MobileActivity  extends ActionBarActivity implements
NavigationDrawerFragment.NavigationDrawerCallbacks, IActionBarUpdate{

	private NavigationDrawerFragment mNavigationDrawerFragment;
	private ActionBar actionBar = null;
	private RelativeLayout imgcartwithcircle = null;
	private ImageView imgcartcircle = null;
	private ImageView imgCart = null;
	private int checkForActionbarIcon = -1;
	private ImageView imgLocation = null; 
	private boolean popupCheck = false;
	private ProductAdapter adapter = null;
	private ArrayList<Mobile> mobileProductList = new ArrayList<Mobile>();
	private GridView gridView = null;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_men);
		
		mNavigationDrawerFragment = (NavigationDrawerFragment) getSupportFragmentManager()
				.findFragmentById(R.id.navigation_drawer);

		// Set up the drawer.
		mNavigationDrawerFragment.setUp(R.id.navigation_drawer,
				(DrawerLayout) findViewById(R.id.drawer_layout));
		gridView = (GridView)findViewById(R.id.gridView1);
		
		mobileProductList = loadData();

		
		adapter = new ProductAdapter(getApplicationContext(), mobileProductList);
		gridView.setAdapter(adapter);

		gridView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
               
            }
        });
		
		NavigationDrawerFragment.selHomeActivity=false;
		NavigationDrawerFragment.selMenActivity=false;
		
	}
	
	private ArrayList<Mobile> loadData() {
		// TODO Auto-generated method stub
		 int count=1;
		 Mobile mobile = new Mobile();
		 ArrayList<Mobile> list = new ArrayList<Mobile>();
		 mobile.setProductId(count);
		 count++;
		 mobile.setName("Apple iPhone 5S");
		 mobile.setDescription("Business Features	 Document Viewer, Microsoft Word, Microsoft Excel, Microsoft PowerPoint, PDF, PPT, PPTX, XLS, XLSX, TXT, DOC, DOCX\r\nHandset Color	 Gold\r\nForm	 Bar\r\nSIM Size	 Nano SIM\r\nCall Features	 Loudspeaker\r\nTouch Screen	 Yes, Capacitive\r\nSIM Type	 Single Sim, GSM\r\nModel ID	 iPhone 5S\r\n\r\nCAMERA\r\nVideo Recording	 Yes, 1920 x 1080, 30 fps\r\nSecondary Camera	 Yes, 1.2 Megapixel\r\nFlash	 Dual LED\r\nOther Camera Features	 Primary Camera: Auto Focus, Tap to Focus, Face Detection, Panorama, Continuous Burst Mode, Geo-tagging, Sapphire Crystal Lens Cover, True Tone Flash, Backside Illumination Sensor, Five-element Lens, Hybrid IR Filter, Video Recording: 3x Zoom, 15 % Larger Image Sensor, f/2.2 Larger Aperture, 33 % Increase in Light Sensivity, Auto Image Stabilization, Square Photos, Slow-motion Video");
		 mobile.setOs("ios");
		 mobile.setPrice(37382);
		 mobile.setProductScreenSize(1136);
		 mobile.setScreenWidth(16384);
		 mobile.setRam(1024);
		 mobile.setProductImage("http://www.mobilejury.com/wp-content/uploads/2013/11/apple-iphone-4.jpeg");
		 list.add(mobile);
		 
		 mobile = new Mobile();
		 mobile.setProductId(count);
		 count++;
		 mobile.setName("Nokia Lumia");
		 mobile.setDescription("Business Features	 Document Viewer, Document Editor, Pushmail (Microsoft Exchange ActiveSync), Excel, Word, Power Point, OneNote, OneDrive Storage for Documents and Notes, Adobe Reader, PDF, Outlook, Office 365\r\nForm	 Bar\r\nSIM Size	 Micro SIM\r\nCall Features	 Conference Call, Speed Dialing, Loudspeaker, Call Divert\r\nModel Name	 Lumia\r\nTouch Screen	 Yes, Capacitive\r\n\r\nSIM Type	 Dual Sim, GSM + GSM\r\nModel ID	 630\r\nIn the Box	 Battery, Handset, Quick Guide, Charger\r\n\r\nMULTIMEDIA\r\nSound Enhancement	 Integrated Hands-free Speakers, Noise Cancellation, Music Apps: Nokia MixRadio, Xbox Music, DRM Support: PlayReady, Album Graphics Display in Music Player, Cloud Music Offline Playback, Cloud Music Playback, Podcasts\r\nVideo Player	 Yes, Supports M4V, 3G2, 3GP, AVI, MP4, MOV, WMV, HD\r\nRingtone	 MP3\r\nFM	 Yes\r\nMusic Player	 Yes, Supports MP3, WMA, AAC, M4A, AMR, ASF\r\n\r\nCAMERA\r\nVideo Recording");
		 mobile.setOs("Windows v8.1");
		 mobile.setPrice(9096);
		 mobile.setProductScreenSize(720);
		 mobile.setScreenWidth(1280);
		 mobile.setRam(512);
		 mobile.setProductImage("http://www.mobilejury.com/wp-content/uploads/2013/11/Nokia-Lumia-520.jpg");
		 
		 
		 list.add(mobile);
		 mobile = new Mobile();
		 mobile.setProductId(count);
		 count++;
		 mobile.setName("Samsung Galaxy S6");
		 mobile.setDescription("Business Features	 Document Viewer, Document Editor, Pushmail (Microsoft Exchange ActiveSync), Excel, Word, Power Point, OneNote, OneDrive Storage for Documents and Notes, Adobe Reader, PDF, Outlook, Office 365\r\nForm	 Bar\r\nSIM Size	 Micro SIM\r\nCall Features	 Conference Call, Speed Dialing, Loudspeaker, Call Divert\r\nModel Name	 Lumia\r\nTouch Screen	 Yes, Capacitive\r\n\r\nSIM Type	 Dual Sim, GSM + GSM\r\nModel ID	 630\r\nIn the Box	 Battery, Handset, Quick Guide, Charger\r\n\r\nMULTIMEDIA\r\nSound Enhancement	 Integrated Hands-free Speakers, Noise Cancellation, Music Apps: Nokia MixRadio, Xbox Music, DRM Support: PlayReady, Album Graphics Display in Music Player, Cloud Music Offline Playback, Cloud Music Playback, Podcasts\r\nVideo Player	 Yes, Supports M4V, 3G2, 3GP, AVI, MP4, MOV, WMV, HD\r\nRingtone	 MP3\r\nFM	 Yes\r\nMusic Player	 Yes, Supports MP3, WMA, AAC, M4A, AMR, ASF\r\n\r\nCAMERA\r\nVideo Recording");
		 mobile.setOs("android");
		 mobile.setPrice(14000);
		 mobile.setProductScreenSize(720);
		 mobile.setScreenWidth(1280);
		 mobile.setRam(2056);
		 mobile.setProductImage("http://www.machibazar.com/MachiBazar/Deal/10004082.jpg");
		 list.add(mobile);
		 list.add(mobile);		
		 list.add(mobile);
		 list.add(mobile);
		 list.add(mobile);
		 mobile = new Mobile();
		 mobile.setProductId(count);
		 count++;
		 mobile.setName("Apple iPhone 5S");
		 mobile.setDescription("Business Features	 Document Viewer, Microsoft Word, Microsoft Excel, Microsoft PowerPoint, PDF, PPT, PPTX, XLS, XLSX, TXT, DOC, DOCX\r\nHandset Color	 Gold\r\nForm	 Bar\r\nSIM Size	 Nano SIM\r\nCall Features	 Loudspeaker\r\nTouch Screen	 Yes, Capacitive\r\nSIM Type	 Single Sim, GSM\r\nModel ID	 iPhone 5S\r\n\r\nCAMERA\r\nVideo Recording	 Yes, 1920 x 1080, 30 fps\r\nSecondary Camera	 Yes, 1.2 Megapixel\r\nFlash	 Dual LED\r\nOther Camera Features	 Primary Camera: Auto Focus, Tap to Focus, Face Detection, Panorama, Continuous Burst Mode, Geo-tagging, Sapphire Crystal Lens Cover, True Tone Flash, Backside Illumination Sensor, Five-element Lens, Hybrid IR Filter, Video Recording: 3x Zoom, 15 % Larger Image Sensor, f/2.2 Larger Aperture, 33 % Increase in Light Sensivity, Auto Image Stabilization, Square Photos, Slow-motion Video");
		 mobile.setOs("ios");
		 mobile.setPrice(37382);
		 mobile.setProductScreenSize(1136);
		 mobile.setScreenWidth(16384);
		 mobile.setRam(1024);
		 mobile.setProductImage("http://www.mobilejury.com/wp-content/uploads/2013/11/apple-iphone-4.jpeg");
		 list.add(mobile);
		
		 list.add(mobile);
		 list.add(mobile);
		 list.add(mobile);
		 list.add(mobile);
		 mobile = new Mobile();
		 mobile.setProductId(count);
		 count++;
		 mobile.setName("Samsung Galaxy S6");
		 mobile.setDescription("Business Features	 Document Viewer, Document Editor, Pushmail (Microsoft Exchange ActiveSync), Excel, Word, Power Point, OneNote, OneDrive Storage for Documents and Notes, Adobe Reader, PDF, Outlook, Office 365\r\nForm	 Bar\r\nSIM Size	 Micro SIM\r\nCall Features	 Conference Call, Speed Dialing, Loudspeaker, Call Divert\r\nModel Name	 Lumia\r\nTouch Screen	 Yes, Capacitive\r\n\r\nSIM Type	 Dual Sim, GSM + GSM\r\nModel ID	 630\r\nIn the Box	 Battery, Handset, Quick Guide, Charger\r\n\r\nMULTIMEDIA\r\nSound Enhancement	 Integrated Hands-free Speakers, Noise Cancellation, Music Apps: Nokia MixRadio, Xbox Music, DRM Support: PlayReady, Album Graphics Display in Music Player, Cloud Music Offline Playback, Cloud Music Playback, Podcasts\r\nVideo Player	 Yes, Supports M4V, 3G2, 3GP, AVI, MP4, MOV, WMV, HD\r\nRingtone	 MP3\r\nFM	 Yes\r\nMusic Player	 Yes, Supports MP3, WMA, AAC, M4A, AMR, ASF\r\n\r\nCAMERA\r\nVideo Recording");
		 mobile.setOs("android");
		 mobile.setPrice(14000);
		 mobile.setProductScreenSize(720);
		 mobile.setScreenWidth(1280);
		 mobile.setRam(2056);
		 mobile.setProductImage("http://www.machibazar.com/MachiBazar/Deal/10004082.jpg");
		 list.add(mobile);
		 list.add(mobile);
		 list.add(mobile);
		 list.add(mobile);
		 mobile = new Mobile();
		 mobile.setProductId(count);
		 count++;
		 mobile.setName("Nokia Lumia");
		 mobile.setDescription("Business Features	 Document Viewer, Document Editor, Pushmail (Microsoft Exchange ActiveSync), Excel, Word, Power Point, OneNote, OneDrive Storage for Documents and Notes, Adobe Reader, PDF, Outlook, Office 365\r\nForm	 Bar\r\nSIM Size	 Micro SIM\r\nCall Features	 Conference Call, Speed Dialing, Loudspeaker, Call Divert\r\nModel Name	 Lumia\r\nTouch Screen	 Yes, Capacitive\r\n\r\nSIM Type	 Dual Sim, GSM + GSM\r\nModel ID	 630\r\nIn the Box	 Battery, Handset, Quick Guide, Charger\r\n\r\nMULTIMEDIA\r\nSound Enhancement	 Integrated Hands-free Speakers, Noise Cancellation, Music Apps: Nokia MixRadio, Xbox Music, DRM Support: PlayReady, Album Graphics Display in Music Player, Cloud Music Offline Playback, Cloud Music Playback, Podcasts\r\nVideo Player	 Yes, Supports M4V, 3G2, 3GP, AVI, MP4, MOV, WMV, HD\r\nRingtone	 MP3\r\nFM	 Yes\r\nMusic Player	 Yes, Supports MP3, WMA, AAC, M4A, AMR, ASF\r\n\r\nCAMERA\r\nVideo Recording");
		 mobile.setOs("Windows v8.1");
		 mobile.setPrice(9096);
		 mobile.setProductScreenSize(720);
		 mobile.setScreenWidth(1280);
		 mobile.setRam(512);
		 mobile.setProductImage("http://www.mobilejury.com/wp-content/uploads/2013/11/Nokia-Lumia-520.jpg");
		 list.add(mobile);
		 list.add(mobile);
		 list.add(mobile);
		 mobile = new Mobile();
		 mobile.setProductId(count);
		 count++;
		 mobile.setName("Samsung Galaxy S6");
		 mobile.setDescription("Business Features	 Document Viewer, Document Editor, Pushmail (Microsoft Exchange ActiveSync), Excel, Word, Power Point, OneNote, OneDrive Storage for Documents and Notes, Adobe Reader, PDF, Outlook, Office 365\r\nForm	 Bar\r\nSIM Size	 Micro SIM\r\nCall Features	 Conference Call, Speed Dialing, Loudspeaker, Call Divert\r\nModel Name	 Lumia\r\nTouch Screen	 Yes, Capacitive\r\n\r\nSIM Type	 Dual Sim, GSM + GSM\r\nModel ID	 630\r\nIn the Box	 Battery, Handset, Quick Guide, Charger\r\n\r\nMULTIMEDIA\r\nSound Enhancement	 Integrated Hands-free Speakers, Noise Cancellation, Music Apps: Nokia MixRadio, Xbox Music, DRM Support: PlayReady, Album Graphics Display in Music Player, Cloud Music Offline Playback, Cloud Music Playback, Podcasts\r\nVideo Player	 Yes, Supports M4V, 3G2, 3GP, AVI, MP4, MOV, WMV, HD\r\nRingtone	 MP3\r\nFM	 Yes\r\nMusic Player	 Yes, Supports MP3, WMA, AAC, M4A, AMR, ASF\r\n\r\nCAMERA\r\nVideo Recording");
		 mobile.setOs("android");
		 mobile.setPrice(14000);
		 mobile.setProductScreenSize(720);
		 mobile.setScreenWidth(1280);
		 mobile.setRam(2056);
		 mobile.setProductImage("http://www.machibazar.com/MachiBazar/Deal/10004082.jpg");
		 list.add(mobile);
		 list.add(mobile);
		 list.add(mobile);
		 
		 return list;
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
}
