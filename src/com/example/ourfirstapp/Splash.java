package com.example.ourfirstapp;

import android.app.Activity;
import android.content.Intent;
import android.media.MediaPlayer;
import android.os.Bundle;

public class Splash extends Activity {
	MediaPlayer mpSplash;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		setContentView(R.layout.splash);
		
	    mpSplash = MediaPlayer.create (this,R.raw.crowd);
		mpSplash.start();
		
		Thread timer = new Thread(){
			public void run(){
				try{
					sleep(5000);
					
				}catch(InterruptedException e){
					e.printStackTrace();
				}finally{
					Intent openMainActivity = new Intent("com.example.ourfirstapp.MENU");
					startActivity(openMainActivity);
				}
			}
		};
		
		timer.start();
	}
	
	@Override
	protected void onPause() {
		// TODO Auto-generated method stub
		super.onPause();
		mpSplash.release();
		finish();
	}
	

}
