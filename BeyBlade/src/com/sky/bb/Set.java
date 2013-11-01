package com.sky.bb;

import java.util.Random;

import android.app.Activity;
import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
import android.hardware.SensorManager;
import android.os.Bundle;
import android.os.PowerManager;
import android.os.PowerManager.WakeLock;
import android.view.SurfaceHolder;
import android.view.SurfaceView;
import android.view.View;
import android.view.View.OnLongClickListener;
import android.view.Window;
import android.view.WindowManager;

public class Set extends Activity implements SensorEventListener,
		OnLongClickListener {

	float  sensorX,b, c, sensorY, X, Y, centerX, centerY, dcX, dcY,l = 0,n = 1,sX,sY;
	Bitmap ball, blade,bkg;
	SensorManager sm;
	int z,x, y, i = 0, j, k = 0, B1 = 0, B2 = 0,m=0;
	
	WakeLock wL;
	MyAnimeSurface ourSurfaceView;
	Random r = new Random();
	TextCont t;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		PowerManager pm = (PowerManager) getSystemService(Context.POWER_SERVICE);
		wL = pm.newWakeLock(PowerManager.FULL_WAKE_LOCK, "whatever");
		requestWindowFeature(Window.FEATURE_NO_TITLE);
		getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,
				WindowManager.LayoutParams.FLAG_FULLSCREEN);

		j =z= 30;
		sm = (SensorManager) getSystemService(Context.SENSOR_SERVICE);
		if (sm.getSensorList(Sensor.TYPE_ACCELEROMETER).size() != 0) {
			Sensor s = sm.getSensorList(Sensor.TYPE_ACCELEROMETER).get(0);
			sm.registerListener(this, s, SensorManager.SENSOR_DELAY_UI);

		}
		ball = BitmapFactory.decodeResource(getResources(), R.raw.drcle);
		blade = BitmapFactory.decodeResource(getResources(), R.raw.drgun);
		bkg = BitmapFactory.decodeResource(getResources(), R.raw.cptbkg);
		sensorX = sensorY=sX=sY = 0;
		X = Y =dcX=dcY= 100;
		centerX=300;
		centerY=100;
		x = y =0;
		b=c=1000000;
		wL.acquire();
		
		ourSurfaceView = new MyAnimeSurface(this);
		ourSurfaceView.resume();
		ourSurfaceView.setOnLongClickListener(this);
		t= new TextCont(null);
		setContentView(ourSurfaceView);
	}

	@Override
	protected void onPause() {
		// TODO Auto-generated method stub

		sm.unregisterListener(this);
		wL.release();
		wL=null;
		ourSurfaceView.pause();
		super.onPause();
		
	}

	@Override
	protected void onResume() {
		// TODO Auto-generated method stub
		super.onResume();
	}

	@Override
	public void onAccuracyChanged(Sensor arg0, int arg1) {
		// TODO Auto-generated method stub

	}

	public boolean onLongClick(View arg0) {
		// TODO Auto-generated method stub
		n = 2-l;
		return false;
	}

	@Override
	public void onSensorChanged(SensorEvent e) {
		// TODO Auto-generated method stub
		sensorX = e.values[0];
		sensorY = e.values[1];
	}

	public class MyAnimeSurface extends SurfaceView implements Runnable {

		SurfaceHolder ourHolder;
		Thread ourThread = null;
		boolean isRunning = false;

		public MyAnimeSurface(Context context) {
			// TODO Auto-generated constructor stub
			super(context);
			ourHolder = getHolder();
		}

		public void pause() {
			isRunning = false;
			while (true) {
				try {
					ourThread.join();
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				break;
			}
			ourThread = null;
		}

		public void resume() {
			isRunning = true;
			ourThread = new Thread(this);
			ourThread.start();
		}

		@Override
		public void run() {
			// TODO Auto-generated method stub
			while (isRunning) {
				if (!ourHolder.getSurface().isValid())
					continue;
				Canvas canvas = ourHolder.lockCanvas();
				Paint textPaint = new Paint();
				x=(int)c/1000;
				y=(int)b/1000;
				try {
					Thread.sleep(24);
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				if (B1 == 100 || B2 == 100) {
					canvas.drawRGB(255,255,255);					
					t.HitFinish(textPaint, canvas, B1, B2);
				}else if(x<=0||y<=0){
					canvas.drawRGB(255,255,255);					
					t.rpmFinish(textPaint, canvas, x, y);
					}else {
						canvas.drawBitmap(bkg, 0,0, null);
					if(l==1){
						secondObject();
					}else{
						ToPoint();
					}
					switch ((int)n) {
					case 1:
						senSor(canvas);
						break;
					case 2:
						spiral(canvas);
						break;
					}
					if (((centerX -dcX <25)&&(centerX-dcX>0)&&(centerY -dcY <25)&&(centerY-dcY>0))||
						    ((dcX -centerX <25)&&(dcX-centerX>0)&&(dcY -centerY <25)&&(dcY-centerY>0))) {
						B1 += r.nextInt(2);
						c-=r.nextInt(9200);
						b-=r.nextInt(9200);
						B2 += r.nextInt(2);
						if(n==2||l==1){
							}
						else{
							m=1;
						}
						
						Bcheck();
						collision();
						}
						canvas.save();
						canvas.rotate(c, centerX + blade.getWidth() / 2,centerY + blade.getHeight() / 2);
						c-=50;
						canvas.drawBitmap(blade, centerX, centerY, null);
						canvas.restore();
						canvas.save();
						canvas.rotate(b, dcX + ball.getWidth() / 2,dcY + ball.getHeight() / 2);
						b-=50;
						canvas.drawBitmap(ball, dcX, dcY, null);
						canvas.restore();
					
					t.CalHit(textPaint, canvas, B1, B2, x, y);
					
				}
				ourHolder.unlockCanvasAndPost(canvas);
			}
		}}
		private void Bcheck() {
			// TODO Auto-generated method stub
			
			if(dcX<50||dcX>395)
				sX=(-sX)/2;
			if(dcY<75||dcY>280)
				sY=((-sY*4)/5);
			if(sX==0&&sY==0)
			{
				secondObject();
				ToPoint();
			}
			
		}

		private void collision() {
			// TODO Auto-generated method stub
			if ((Math.abs((centerX +(blade.getWidth()/2)) - (dcX+(ball.getWidth()/2))) <(blade.getWidth()/2 +ball.getWidth()/2))
				&&(Math.abs((centerY +(blade.getHeight()/2)) - (dcY+(ball.getHeight()/2))) <(blade.getHeight()/2 + ball.getHeight()/2 ))) 
			    {
				secondObject();
				ToPoint();
					
			    }}

		private void ToPoint() {
			// TODO Auto-generated method stub
			if(((X-dcX<=sX)&&(X-dcX>=0))||((dcX-X>=sX)&&(dcX-X<=0))||m==1||n==2){
				if(m==1||n==2){
					l = k /15;
					X =60+r.nextInt(305) ;
					Y =70+r.nextInt(200) ;
				}else{
				l = k /15;
				secondObject();
				}
				sX=(X-dcX)/30;
				sY=(Y-dcY)/30;
				m=0;
			}
			else{
				dcX+=sX;
				dcY+=sY;
			}
			}
		
		private void spiral(Canvas canvas) {
			// TODO Auto-generated method stub
			centerX = dcX + (float) (z * Math.cos(0.1f*i));
			centerY = dcY + (float) (z * Math.sin(0.1f*i));
			if (i < 360) {
				i += 5;
			} else {
				i = 0;
				n -= 0.1;
				B1 += 1;
			}
		}

		private void senSor(Canvas canvas) {
		if(centerX<=400&&centerX>55&&centerY<=280&&centerY>65){
			centerX +=  (sensorY *2);
			centerY +=  (sensorX*2 );
		}else{
		if(centerX>=400){
			centerX -=3;
			//centerY -=3;
		}
		if(centerX<=55){
			centerX +=3;
			//centerY +=3;
		}
		if(centerY>=280){
			//centerX-=2;
			centerY -= 2;
		}
		if(centerY<=65){
			//centerX +=3;
			centerY +=3;
		}
		}
	}

		private void secondObject() {
			// TODO Auto-generated method stub
			if(dcX>=400){
				j*=-1;
				//centerY -=3;
			}
			if(dcX<=55){
				j*=-1;
				//centerY +=3;
			}
			if(dcY>=280){
				//centerX-=2;
				j*=-1;
			}
			if(dcY<=65){
				//centerX +=3;
				j*=-1;
			}else{
			switch ((int)l) {
			case 0: {
				if(k==14){
					X=centerX;
					Y=centerY;
				}else{
					X =60+r.nextInt(305) ;
					Y =70+r.nextInt(200) ;
				}
				k += 1;
				break;
			}
			case 1: {
				dcX = centerX + (float) (j * Math.cos(0.1f*i));
				dcY = centerY + (float) (j * Math.sin(0.1f*i));
				if (i < 360) {
					i += 5;
				} else {
					i = 0;
					l=sX=sY=0;
					X=dcX;
					Y=dcY;
					k = 1;
					B2 += 1;
				}
			}
				break;
			}
		}}}

