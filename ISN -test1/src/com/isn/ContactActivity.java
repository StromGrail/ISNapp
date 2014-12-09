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
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.AdapterView;
import android.widget.GridView;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.isn.adapter.ProductAdapter;
import com.isn.adapter.WAdapter;
import com.isn.model.Mobile;
import com.isn.model.women;

public class ContactActivity  extends ActionBarActivity {

Animation myAnimation;
TextView myText;

@Override
protected void onCreate(Bundle savedInstanceState) {
 super.onCreate(savedInstanceState);
 setContentView(R.layout.activity_contact);
 myText = (TextView)findViewById(R.id.contact);
 
 myAnimation = AnimationUtils.loadAnimation(this, R.anim.myanimation);
 
 myText.setOnClickListener(new OnClickListener(){

  @Override
  public void onClick(View arg0) {
   myText.startAnimation(myAnimation);
  }});
}}