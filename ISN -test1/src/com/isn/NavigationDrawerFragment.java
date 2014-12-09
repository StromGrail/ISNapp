package com.isn;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.res.Configuration;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.support.v4.app.ActionBarDrawerToggle;
import android.support.v4.app.Fragment;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBar;
import android.support.v7.app.ActionBarActivity;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.BaseExpandableListAdapter;
import android.widget.ExpandableListView;
import android.widget.ExpandableListView.OnChildClickListener;
import android.widget.ExpandableListView.OnGroupClickListener;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;


/**
 * Fragment used for managing interactions for and presentation of a navigation drawer.
 * See the <a href="https://developer.android.com/design/patterns/navigation-drawer.html#Interaction">
 * design guidelines</a> for a complete explanation of the behaviors implemented here.
 */
public class NavigationDrawerFragment extends Fragment {

	/**
	 * Remember the position of the selected item.
	 */
	private static final String STATE_SELECTED_POSITION = "selected_navigation_drawer_position";

	/**
	 * Per the design guidelines, you should show the drawer on launch until the user manually
	 * expands it. This shared preference tracks this.
	 */
	private static final String PREF_USER_LEARNED_DRAWER = "navigation_drawer_learned";

	/**
	 * Helper component that ties the action bar to the navigation drawer.
	 */
	private ActionBarDrawerToggle mDrawerToggle;

	private DrawerLayout mDrawerLayout;
	private ExpandableListView mDrawerListView;
	private View mFragmentContainerView;

	private int mCurrentSelectedPosition = 0;
	private boolean mFromSavedInstanceState;
	private boolean mUserLearnedDrawer;
	public static boolean selHomeActivity,selMenActivity,selWomenActivity,selLoginActivity=false,selContactActivity=false,selOfferActivity=false;
	String[] leftArray = new String[] { "HOME", "MEN", "WOMEN","LOGIN","OFFERS","QUICK PURCHASE"};
	private Integer[] mImageIds = { R.drawable.foodmenu_icon,
			R.drawable.mypizzaicone, R.drawable.deal_icone,
			R.drawable.feedback_icon, R.drawable.more,R.drawable.more};
	private static final String arrChildElements[][] = {
		{ "" },
		{ "Order Tracker","Order History", "My Favourites","My Profile" },
		{ "" },
		{ "" },
		{ "Details5A","Details5 B", "Details5 C" }

	};
	private CharSequence mTitle;
	public NavigationDrawerFragment() {
	}

	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);

		// Read in the flag indicating whether or not the user has demonstrated awareness of the
		// drawer. See PREF_USER_LEARNED_DRAWER for details.
		SharedPreferences sp = PreferenceManager.getDefaultSharedPreferences(getActivity());
		mUserLearnedDrawer = sp.getBoolean(PREF_USER_LEARNED_DRAWER, true);
		if (savedInstanceState != null) {
			mCurrentSelectedPosition = savedInstanceState.getInt(STATE_SELECTED_POSITION);
			mFromSavedInstanceState = true;
		}
		NavigationDrawerFragment.selHomeActivity=false;
		NavigationDrawerFragment.selMenActivity=false;
		NavigationDrawerFragment.selWomenActivity=false;

	}
	@Override
	public void onActivityCreated (Bundle savedInstanceState) {
		super.onActivityCreated(savedInstanceState);
		// Indicate that this fragment would like to influence the set of actions in the action bar.
		setHasOptionsMenu(true);
	}

	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container,
			Bundle savedInstanceState) {
		mDrawerListView = (ExpandableListView) inflater.inflate(
				R.layout.navigationfragment, container, false);
		mDrawerListView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
			@Override
			public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
				selectItem(position);
			}
		});
		mDrawerListView.setOnGroupClickListener(new OnGroupClickListener() {
			@Override
			public boolean onGroupClick(ExpandableListView parent, View v,
					int groupPosition, long id) {
				// TODO Auto-generated method stub
				if(groupPosition == 0){
					selectItem(groupPosition);
					return true;
				}else if(groupPosition == 1){
					selectItem(groupPosition);
					return true;
				}else if(groupPosition == 2){
					selectItem(groupPosition);
					return true;
				}else if(groupPosition == 3){
					selectItem(groupPosition);
					return true;
				}else if(groupPosition == 4){
					selectItem(groupPosition);
					return true;
				}else if(groupPosition == 5){
					selectItem(groupPosition);
					return true;
				}else{
					return false;
				}
			}
		});

		mDrawerListView.setOnChildClickListener(new OnChildClickListener() {

			@Override
			public boolean onChildClick(ExpandableListView parent, View v,
					int groupPosition, int childPosition, long id) {
				// TODO Auto-generated method stub
				if(childPosition == 2){
					selectChildItem(childPosition,groupPosition);
					return true;
				}
				else
					return false;
			}
		});
		ExpandableListAdapter adapter = new ExpandableListAdapter(getActionBar().getThemedContext(),inflater);
		mDrawerListView.setAdapter(adapter);
		mDrawerListView.setItemChecked(mCurrentSelectedPosition, true);
		return mDrawerListView;
	}

	public boolean isDrawerOpen() {
		return mDrawerLayout != null && mDrawerLayout.isDrawerOpen(mFragmentContainerView);
	}

	/**
	 * Users of this fragment must call this method to set up the navigation drawer interactions.
	 *
	 * @param fragmentId   The android:id of this fragment in its activity's layout.
	 * @param drawerLayout The DrawerLayout containing this fragment's UI.
	 */
	public void setUp(int fragmentId, DrawerLayout drawerLayout) {
		mFragmentContainerView = getActivity().findViewById(fragmentId);
		mDrawerLayout = drawerLayout;

		// set a custom shadow that overlays the main content when the drawer opens
		mDrawerLayout.setDrawerShadow(R.drawable.drawer_shadow, GravityCompat.START);
		// set up the drawer's list view with items and click listener

		ActionBar actionBar = getActionBar();
		actionBar.setHomeButtonEnabled(true);
		actionBar.setIcon(R.drawable.list); 
		actionBar.setBackgroundDrawable(new 
				ColorDrawable(getActionBar().getThemedContext().getResources().getColor(R.color.c_header))); 
		// ActionBarDrawerToggle ties together the the proper interactions
		// between the navigation drawer and the action bar app icon.
		mDrawerToggle = new ActionBarDrawerToggle(
				getActivity(),                    /* host Activity */
				mDrawerLayout,                    /* DrawerLayout object */
				R.drawable.ic_drawer,             /* nav drawer image to replace 'Up' caret */
				R.string.navigation_drawer_open,  /* "open drawer" description for accessibility */
				R.string.navigation_drawer_close  /* "close drawer" description for accessibility */
				) {
			@Override
			public void onDrawerClosed(View drawerView) {
				super.onDrawerClosed(drawerView);
				if (!isAdded()) {

					return;
				}

				getActivity().supportInvalidateOptionsMenu(); // calls onPrepareOptionsMenu()
			}

			@Override
			public void onDrawerOpened(View drawerView) {
				super.onDrawerOpened(drawerView);
				if (!isAdded()) {
					setTitle(mTitle);
					return;
				}

				if (!mUserLearnedDrawer) {
					// The user manually opened the drawer; store this flag to prevent auto-showing
					// the navigation drawer automatically in the future.
					mUserLearnedDrawer = true;
					SharedPreferences sp = PreferenceManager
							.getDefaultSharedPreferences(getActivity());
					sp.edit().putBoolean(PREF_USER_LEARNED_DRAWER, true).commit();
				}

				getActivity().supportInvalidateOptionsMenu(); // calls onPrepareOptionsMenu()
			}
		};

		// If the user hasn't 'learned' about the drawer, open it to introduce them to the drawer,
		// per the navigation drawer design guidelines.
		if (!mUserLearnedDrawer && !mFromSavedInstanceState) {
			mDrawerLayout.openDrawer(mFragmentContainerView);
		}

		// Defer code dependent on restoration of previous instance state.
		mDrawerLayout.post(new Runnable() {
			@Override
			public void run() {
				mDrawerToggle.syncState();
			}
		});

		mDrawerLayout.setDrawerListener(mDrawerToggle);
	}

	private void selectItem(int position) {
		mCurrentSelectedPosition = position;

		if (mDrawerLayout != null) {
			mDrawerLayout.closeDrawer(mFragmentContainerView);
		}


		if(position==0){
			if(!selHomeActivity){
			setTitle(leftArray[position]);
			Intent iAbout = new Intent(getActionBar().getThemedContext(), HomeActivity.class);
			iAbout.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
			startActivity(iAbout);
			mDrawerListView.setItemChecked(position, true); 
			}
		}else if(position==1){
			if(!selMenActivity){
			setTitle(leftArray[position]);
			Intent iAbout = new Intent(getActionBar().getThemedContext(), MenActivity.class);
			iAbout.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
			startActivity(iAbout);
			mDrawerListView.setItemChecked(position, true);
			}
		}else if(position==2){
			if(!selWomenActivity){
			setTitle(leftArray[position]);
			Intent iAbout = new Intent(getActionBar().getThemedContext(), WomenActivity.class);
			iAbout.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
			startActivity(iAbout);
			mDrawerListView.setItemChecked(position, true);
			}
		}else if(position==3){
			if(!selLoginActivity){
			setTitle(leftArray[position]);
			Intent iAbout = new Intent(getActionBar().getThemedContext(), LoginActivity.class);
			iAbout.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
			startActivity(iAbout);
			mDrawerListView.setItemChecked(position, true);
			}	
		}else if(position==4){
			if(!selOfferActivity){
			setTitle(leftArray[position]);
			Intent iAbout = new Intent(getActionBar().getThemedContext(), OfferActivity.class);
			iAbout.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
			startActivity(iAbout);
			mDrawerListView.setItemChecked(position, true);
			}	
		}else if(position==5){
			if(!selOfferActivity){
				setTitle(leftArray[position]);
				Intent iAbout = new Intent(getActionBar().getThemedContext(), CatalogActivity.class);
				iAbout.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
				startActivity(iAbout);
				mDrawerListView.setItemChecked(position, true);
				}	
		}

	}

	@Override
	public void onAttach(Activity activity) {
		super.onAttach(activity);
		try {
		} catch (ClassCastException e) {
			throw new ClassCastException("Activity must implement NavigationDrawerCallbacks.");
		}
	}

	@Override
	public void onDetach() {
		super.onDetach();
	}

	@Override
	public void onSaveInstanceState(Bundle outState) {
		super.onSaveInstanceState(outState);
		outState.putInt(STATE_SELECTED_POSITION, mCurrentSelectedPosition);
	}

	@Override
	public void onConfigurationChanged(Configuration newConfig) {
		super.onConfigurationChanged(newConfig);
		// Forward the new configuration the drawer toggle component.
		mDrawerToggle.onConfigurationChanged(newConfig);
	}

	/*@Override
	public void onCreateOptionsMenu(Menu menu, MenuInflater inflater) {
		// If the drawer is open, show the global app actions in the action bar. See also
		// showGlobalContextActionBar, which controls the top-left area of the action bar.
		if (mDrawerLayout != null && isDrawerOpen()) {
			inflater.inflate(R.menu.global_top_bar, menu);
			showGlobalContextActionBar();
			
			//addBadgeOnActionBar(R.id.action_cart_display);
			
		}
		super.onCreateOptionsMenu(menu, inflater);
	}*/
/*
	public void addBadgeOnActionBar(int cartItemId){
		View target = ((Activity) getActionBar().getThemedContext()).findViewById(cartItemId);
		BadgeView badge = new BadgeView(getActionBar().getThemedContext(), target);
		PrefrenceManager session = new PrefrenceManager(getActionBar().getThemedContext());
		if(session.isBasketItemAvailale()){
			badge.setBackgroundResource(R.drawable.cart_active);
			badge.setText("1");
			badge.setTextSize(16);
			badge.setTextColor(getResources().getColor(R.color.c_red));
			badge.setPadding(0, 5, 15, 0);
			badge.setGravity(Gravity.RIGHT);
		}else{
			badge.setBackgroundResource(R.drawable.cart_icon);
		}

		badge.show();
	}
*/	
	
	@Override
	public boolean onOptionsItemSelected(MenuItem item) {
		// The action bar home/up action should open or close the drawer.
		// ActionBarDrawerToggle will take care of this.
		if (mDrawerToggle.onOptionsItemSelected(item)) {
			return true;
		}
		if (item.getItemId() == R.id.action_location) {
			Toast.makeText(getActivity(), "Locatio action.", Toast.LENGTH_SHORT).show();
			return true;
		}
		if (item.getItemId() == R.id.action_cart_display) {
			Toast.makeText(getActivity(), "Cart action.", Toast.LENGTH_SHORT).show();
			return true;
		}

		return super.onOptionsItemSelected(item);


	}

	private ActionBar getActionBar() {
		return ((ActionBarActivity) getActivity()).getSupportActionBar();
	}
	public void setTitle(CharSequence title) {
		mTitle = title;

		getActionBar().setTitle(mTitle);

	}
	/**
	 * Callbacks interface that all activities using this fragment must implement.
	 */
	public static interface NavigationDrawerCallbacks {
		/**
		 * Called when an item in the navigation drawer is selected.
		 */
		void onNavigationDrawerItemSelected(int position);

			
		void updateActionBar();
	}


	
	
	private void selectChildItem(int Childposition , int groupPosstion) {
		// update the main content by replacing fragments
		mCurrentSelectedPosition = groupPosstion;
		if (mDrawerLayout != null) {
			mDrawerLayout.closeDrawer(mFragmentContainerView);
		} 

	}



	public class ExpandableListAdapter extends BaseExpandableListAdapter {
		private Context mContext = null;

		public ExpandableListAdapter(Context themedContext, LayoutInflater inflater) {
			// TODO Auto-generated constructor stub
			mContext = themedContext;

		}

		@Override
		public Object getChild(int groupPosition, int childPosition) {
			return null;
		}
		@Override
		public long getChildId(int groupPosition, int childPosition) {
			return 0;
		}
		@SuppressLint("InflateParams") @Override
		public View getChildView(int groupPosition, int childPosition,
				boolean isLastChild, View convertView, ViewGroup parent) {
			if (convertView == null) {
				LayoutInflater inflater = (LayoutInflater) mContext
						.getSystemService(android.content.Context.LAYOUT_INFLATER_SERVICE);
				convertView = inflater.inflate(
						R.layout.article_list_child_item_layout, null);
			}
			TextView yourSelection = (TextView) convertView.findViewById(R.id.articleContentTextView);
			yourSelection.setText(arrChildElements[groupPosition][childPosition]);



			return convertView;
		}
		@Override
		public int getChildrenCount(int groupPosition) {
			return arrChildElements[groupPosition].length;
		}
		@Override
		public Object getGroup(int groupPosition) {
			return null;
		}
		@Override
		public int getGroupCount() {
			return leftArray.length;
		}
		@Override
		public long getGroupId(int groupPosition) {
			return 0;
		}
		@SuppressLint("InflateParams") public View getGroupView(int groupPosition, boolean isExpanded,
				View convertView, ViewGroup parent) {
			if (convertView == null) {
				LayoutInflater inflater = (LayoutInflater) mContext
						.getSystemService(android.content.Context.LAYOUT_INFLATER_SERVICE);
				convertView = inflater.inflate(
						R.layout.drawer_list_item, null);
			}
			TextView groupName = (TextView) convertView.findViewById(R.id.left_text);
			ImageView leftMenuImg = (ImageView) convertView.findViewById(R.id.left_menuimg);
			//groupName.setTypeface(Utility.UbuntuMedium);

			leftMenuImg.setBackgroundResource(mImageIds[groupPosition]);
			groupName.setText(leftArray[groupPosition]);
			return convertView;
		}
		@Override
		public boolean hasStableIds() {
			return false;
		}
		@Override
		public boolean isChildSelectable(int groupPosition, int childPosition) {
			return true;
		}


	}


}
