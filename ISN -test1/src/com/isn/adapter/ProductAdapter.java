package com.isn.adapter;

import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

import android.content.Context;
import android.graphics.Bitmap;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.isn.R;
import com.isn.model.Mobile;
import com.isn.model.women;
import com.nostra13.universalimageloader.core.DisplayImageOptions;
import com.nostra13.universalimageloader.core.ImageLoader;
import com.nostra13.universalimageloader.core.display.FadeInBitmapDisplayer;
import com.nostra13.universalimageloader.core.listener.ImageLoadingListener;
import com.nostra13.universalimageloader.core.listener.SimpleImageLoadingListener;

public class ProductAdapter extends BaseAdapter {

    private Context context;
    private Context context1;
    private ArrayList<Mobile> items;
    LayoutInflater inflater;
    DisplayImageOptions options;
	protected ImageLoader imageLoader = ImageLoader.getInstance();
	private ImageLoadingListener animateFirstListener = new AnimateFirstDisplayListener();


	 public ProductAdapter(Context context, ArrayList<Mobile> items) {
	        this.context = context;
	        this.items = items;
	        inflater = (LayoutInflater) this.context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
	    }
	
    
	public View getView(final int position, View convertView, ViewGroup parent) {

        if (convertView == null) {
            convertView = inflater.inflate(R.layout.productcell, null);
            final ImageView image = (ImageView)convertView.findViewById(R.id.productimage);
            final TextView textName = (TextView)convertView.findViewById(R.id.nametext);
            final TextView textPrice = (TextView)convertView.findViewById(R.id.txtprice);
            
            textName.setText(items.get(position).getName());
            textPrice.setText(items.get(position).getPrice()+"");
            
    		imageLoader.getInstance().displayImage(items.get(position).getProductImage(), image, options, animateFirstListener);

        }
        else
        {
        	convertView = (View) convertView;
        }
 
        return convertView;
    }

    @Override
    public int getCount() {
        return items.size();
    }

    @Override
    public Object getItem(int position) {
        return items.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
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
