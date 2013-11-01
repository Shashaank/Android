package com.sky.bb;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.os.PowerManager;
import android.os.PowerManager.WakeLock;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnLongClickListener;
import android.view.View.OnTouchListener;
import android.view.Window;
import android.view.WindowManager;

public class Play extends Activity implements OnLongClickListener,OnTouchListener {

	

	float  sensorX, sensorY;
	int x;
	WakeLock wL;
	
	MyAnimeSurface ourSurfaceView;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		
		PowerManager pm = (PowerManager) getSystemService(Context.POWER_SERVICE);
		wL = pm.newWakeLock(PowerManager.FULL_WAKE_LOCK, "whatever");
		
		requestWindowFeature(Window.FEATURE_NO_TITLE);
		getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,
				WindowManager.LayoutParams.FLAG_FULLSCREEN);
				
				
		wL.acquire();
		
		
		
	 	Bundle b = getIntent().getExtras();
		int data = b.getInt("key");
		
		ourSurfaceView = new MyAnimeSurface(this,data);
		ourSurfaceView.resume();
		ourSurfaceView.setOnLongClickListener(this);
		ourSurfaceView.setOnTouchListener(this);
		setContentView(ourSurfaceView);
		
	
		

	}

	@Override
	protected void onPause() {
		// TODO Auto-generated method stub

		ourSurfaceView.Pause();
		wL.release();
		wL=null;
		super.onPause();
	}
	

	
	@Override
	protected void onResume() {
		// TODO Auto-generated method stub
		super.onResume();
		
	}

	public boolean onLongClick(View arg0) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean onTouch(View arg0, MotionEvent arg1) {
		// TODO Auto-generated method stub
		
		sensorX=arg1.getX();
		sensorY=arg1.getY();
	    ourSurfaceView.Update(sensorX,sensorY);
	    
		return true;
	}

}
