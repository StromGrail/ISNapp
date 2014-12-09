package com.isn;
import java.util.ArrayList;

import android.annotation.SuppressLint;
import android.content.Intent;
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

import com.isn.adapter.WAdapter;
import com.isn.model.women;

public class WomenActivity  extends ActionBarActivity implements
NavigationDrawerFragment.NavigationDrawerCallbacks, IActionBarUpdate{

	private NavigationDrawerFragment mNavigationDrawerFragment;
	private ActionBar actionBar = null;
	private RelativeLayout imgcartwithcircle = null;
	private ImageView imgcartcircle = null;
	private ImageView imgCart = null;
	private int checkForActionbarIcon = -1;
	private ImageView imgLocation = null; 
	private boolean popupCheck = false;
	private ArrayList<women> womenProd = new ArrayList<women>();
	private WAdapter adapter1 = null;
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
		
		womenProd = loadData();

		System.out.println(womenProd.size());
		adapter1 = new WAdapter(getApplicationContext(),womenProd);
		gridView.setAdapter(adapter1);

		gridView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
            	
                
                
                Intent i = new Intent(getApplicationContext(),ProductInfoActivity.class);
                i.putExtra("womenobj", womenProd.get(position)); 
                startActivity(i);
            }
        });
		
		NavigationDrawerFragment.selHomeActivity=false;
		NavigationDrawerFragment.selMenActivity=false;
		
	}

private ArrayList<women> loadData(){
	 int count=1;
	 women wProd = new women();
	 ArrayList<women> list = new ArrayList<women>();
	 
	 wProd.setProductId(count);
	 	count++;
		wProd.setName("Women Ethic Wear");
		wProd.setDescription("In The Box Sari, Blouse Dimensions Length 	6.3 m General Details Pattern 	Printed Occasion 	Party Sari Details Region 	Gujrat Number of Contents in Sales Package 	Pack of 1 Fabric 	Art Silk Type 	Fashion Blouse Piece 	Yes ");
		wProd.setPrice(999);
		wProd.setProductImage("http://img6a.flixcart.com/image/sari/9/r/h/fbvp10920-fashion-boutique-400x400-imadydpsfpygsta7.jpeg");
		wProd.setStock_avail(20);
		list.add(wProd);
		
		wProd = new women();
		wProd.setProductId(count);
	 	count++;
		wProd.setName("Tosila Solid Kurti");
		wProd.setDescription("General Details Pattern 	Solid Occasion 	Casual Ideal For 	Womens Kurta Details Sleeve 	3/4 Sleeve Fabric 	Cotton Style 	Slit at Sides Neck 	Fashion Neck Design 	Embroidery Detail");
		wProd.setPrice(600);
		wProd.setProductImage("http://img5a.flixcart.com/image/kurta/z/c/m/mc511blue-tasrika-s-400x400-imaefwfvhfww4zxz.jpeg");
		wProd.setStock_avail(80);
		list.add(wProd);
		
		wProd = new women();
		wProd.setProductId(count);
	 	count++;
		wProd.setName("Tasrika Solid Women Kurta");
		wProd.setDescription("Kurta Details Sleeve 	3/4 Sleeve Fabric 	Cotton Style 	Side Slits Neck 	Fashion Neck Design 	Embroidery Detail General Details Pattern 	Solid Ideal For 	Women Occasion 	Casual ");
		wProd.setPrice(900);
		wProd.setProductImage("http://img5a.flixcart.com/image/kurta/h/s/r/mc513seagreen-tasrika-s-400x400-imaef3u45dnq7ehw.jpeg");
		wProd.setStock_avail(60);
		list.add(wProd);
		
		wProd = new women();
		wProd.setProductId(count);
	 	count++;
		wProd.setName("Women Ethic Wear");
		wProd.setDescription("In The Box Sari, Blouse Dimensions Length 	6.3 m General Details Pattern 	Printed Occasion 	Party Sari Details Region 	Gujrat Number of Contents in Sales Package 	Pack of 1 Fabric 	Art Silk Type 	Fashion Blouse Piece 	Yes ");
		wProd.setPrice(999);
		wProd.setProductImage("http://img6a.flixcart.com/image/sari/9/r/h/fbvp10920-fashion-boutique-400x400-imadydpsfpygsta7.jpeg");
		wProd.setStock_avail(20);
		list.add(wProd);
		
		wProd = new women();
		wProd.setProductId(count);
	 	count++;
		wProd.setName("Tosila Solid Kurti");
		wProd.setDescription("General Details Pattern 	Solid Occasion 	Casual Ideal For 	Womens Kurta Details Sleeve 	3/4 Sleeve Fabric 	Cotton Style 	Slit at Sides Neck 	Fashion Neck Design 	Embroidery Detail");
		wProd.setPrice(600);
		wProd.setProductImage("http://img5a.flixcart.com/image/kurta/z/c/m/mc511blue-tasrika-s-400x400-imaefwfvhfww4zxz.jpeg");
		wProd.setStock_avail(80);
		list.add(wProd);
		wProd = new women();
		wProd.setProductId(count);
	 	count++;
		wProd.setName("Tasrika Solid Women Kurta");
		wProd.setDescription("Kurta Details Sleeve 	3/4 Sleeve Fabric 	Cotton Style 	Side Slits Neck 	Fashion Neck Design 	Embroidery Detail General Details Pattern 	Solid Ideal For 	Women Occasion 	Casual ");
		wProd.setPrice(900);
		wProd.setProductImage("http://img5a.flixcart.com/image/kurta/h/s/r/mc513seagreen-tasrika-s-400x400-imaef3u45dnq7ehw.jpeg");
		wProd.setStock_avail(60);
		list.add(wProd);
		wProd = new women();
		wProd.setProductId(count);
	 	count++;
		wProd.setName("Women Ethic Wear");
		wProd.setDescription("In The Box Sari, Blouse Dimensions Length 	6.3 m General Details Pattern 	Printed Occasion 	Party Sari Details Region 	Gujrat Number of Contents in Sales Package 	Pack of 1 Fabric 	Art Silk Type 	Fashion Blouse Piece 	Yes ");
		wProd.setPrice(999);
		wProd.setProductImage("http://img6a.flixcart.com/image/sari/9/r/h/fbvp10920-fashion-boutique-400x400-imadydpsfpygsta7.jpeg");
		wProd.setStock_avail(20);
		list.add(wProd);
		
		wProd = new women();
		wProd.setProductId(count);
	 	count++;
		wProd.setName("Tosila Solid Kurti");
		wProd.setDescription("General Details Pattern 	Solid Occasion 	Casual Ideal For 	Womens Kurta Details Sleeve 	3/4 Sleeve Fabric 	Cotton Style 	Slit at Sides Neck 	Fashion Neck Design 	Embroidery Detail");
		wProd.setPrice(600);
		wProd.setProductImage("http://img5a.flixcart.com/image/kurta/z/c/m/mc511blue-tasrika-s-400x400-imaefwfvhfww4zxz.jpeg");
		wProd.setStock_avail(80);
		list.add(wProd);
		wProd = new women();
		wProd.setProductId(count);
	 	count++;
		wProd.setName("Tasrika Solid Women Kurta");
		wProd.setDescription("Kurta Details Sleeve 	3/4 Sleeve Fabric 	Cotton Style 	Side Slits Neck 	Fashion Neck Design 	Embroidery Detail General Details Pattern 	Solid Ideal For 	Women Occasion 	Casual ");
		wProd.setPrice(900);
		wProd.setProductImage("http://img5a.flixcart.com/image/kurta/h/s/r/mc513seagreen-tasrika-s-400x400-imaef3u45dnq7ehw.jpeg");
		wProd.setStock_avail(60);
		list.add(wProd);
		wProd = new women();
		wProd.setProductId(count);
	 	count++;
		wProd.setName("Women Ethic Wear");
		wProd.setDescription("In The Box Sari, Blouse Dimensions Length 	6.3 m General Details Pattern 	Printed Occasion 	Party Sari Details Region 	Gujrat Number of Contents in Sales Package 	Pack of 1 Fabric 	Art Silk Type 	Fashion Blouse Piece 	Yes ");
		wProd.setPrice(999);
		wProd.setProductImage("http://img6a.flixcart.com/image/sari/9/r/h/fbvp10920-fashion-boutique-400x400-imadydpsfpygsta7.jpeg");
		wProd.setStock_avail(20);
		list.add(wProd);
		
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
