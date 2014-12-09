package com.isn;

import java.util.List;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.Button;
import android.widget.ListView;

public class ShoppingCartActivity extends Activity {
 
 private List<Product> mCartList;
 private ProductAdapter mProductAdapter;
 private Button payPalButton = null;
 
 @Override
 protected void onCreate(Bundle savedInstanceState) {
  super.onCreate(savedInstanceState);
  setContentView(R.layout.shoppingcart);
  

  mCartList = ShoppingCartHelper.getCartList();
  
  // Make sure to clear the selections
  for(int i=0; i<mCartList.size(); i++) {
   mCartList.get(i).selected = false;
  }
  
  // Create the list
  final ListView listViewCatalog = (ListView) findViewById(R.id.ListViewCatalogc);
  mProductAdapter = new ProductAdapter(mCartList, getLayoutInflater(), true);
  listViewCatalog.setAdapter(mProductAdapter);
  
  listViewCatalog.setOnItemClickListener(new OnItemClickListener() {

   @Override
   public void onItemClick(AdapterView<?> parent, View view, int position,
     long id) {
    Intent productDetailsIntent = new Intent(getBaseContext(),ProductDetailsActivity.class);
    productDetailsIntent.putExtra(ShoppingCartHelper.PRODUCT_INDEX, position);
    startActivity(productDetailsIntent);
   }
  });
  
  payPalButton = (Button)findViewById(R.id.Button02c);
	
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

 }
 
 @Override
 protected void onResume() {
  super.onResume();
  
  // Refresh the data
  if(mProductAdapter != null) {
   mProductAdapter.notifyDataSetChanged();
  }
 }

}