package com.sky.bb;

import java.util.Random;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.os.AsyncTask;
import android.view.SurfaceHolder;
import android.view.SurfaceView;



public class MyAnimeSurface extends SurfaceView implements Runnable {
	
	
	
	
	public class Blade  {
		Bitmap image;
		float posX,posY;
		int sX,sY;
		float rot=1000000,dx;
		int hit,dam=0,def=0;
		
		public  Blade (int id){
    		switch((id)){  
    		case 1:
    			image = BitmapFactory.decodeResource(getResources(), R.raw.blade1);
    			this.dam=5;
    			this.def=3;    			
    			this.dx=30;
    			break;
    		case 2:
    			image = BitmapFactory.decodeResource(getResources(), R.raw.blade2);
    			this.dam=6;
    			this.def=2;
    			this.dx=25;
    			   break;   
    		case 3:
    			image = BitmapFactory.decodeResource(getResources(), R.raw.blade3);
    			this.dam=7;
    			this.def=1;
    			this.dx=20;
    			   break; 	  
    		case 4:
    			image = BitmapFactory.decodeResource(getResources(), R.raw.blade4);
    			this.dam=5;
    			this.def=3;
    			this.dx=30;
    			   break; 	
    		case 5:
    			image = BitmapFactory.decodeResource(getResources(), R.raw.blade5);
    			this.dam=4;
    			this.def=3;
    			this.dx=35;
    			   break; 	
    		case 6:
    			image = BitmapFactory.decodeResource(getResources(), R.raw.blade6);
    			this.dam=5;
    			this.def=2;
    			this.dx=40;
    			   break; 	
    		case 7:
    			image = BitmapFactory.decodeResource(getResources(), R.raw.blade7);
    			this.dam=7;
    			this.def=1;
    			this.dx=20;
    			   break;
    		case 8:
    			image = BitmapFactory.decodeResource(getResources(), R.raw.blade8);
    			this.dam=6;
    			this.def=2;
    			this.dx=25;
    			   break;	   
    		}
    		this.image = Bitmap.createScaledBitmap(image,30, 30, true);
    		this.image.prepareToDraw();
    	   
    	/*	switch((id/100)%10){
		    case 1:
 			       break;
 		    case 2:
 			       break;
 		    case 3:
 			       break;
 		    case 4:
 			       break;
 			       
		    }
		    
		    switch((id/10)%10){
		    case 1:
 			       break;
 		    case 2:
 			       break;
 		    case 3:
 			       break;
 		    case 4:
 			       break;
 			       
		    }
		    
		    switch(id%10){
		    case 1:
 			       break;
 		    case 2:
 			       break;
 		    case 3:
 			       break;
 		    case 4:
 			       break;
		    }
		    */
	  }

	}
	
	
	public class back extends Thread  {

		@Override
		public void run() {
			// TODO Auto-generated method stub
			while(isRunning){
				
				try {
					Thread.sleep(25);
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				
				if(m!=1){
			    Bcheck();
				collision();
	    		ToPoint();
		    	senSor();
		    	}
  		}}
		
		private void Bcheck() {
			// TODO Auto-generated method stub
			
         // if(CHECK()==1)
			{if(User.posX<50||User.posX>395)
				{
				ssX=(-ssX*9)/10;
				CHECK();
				//s.play(ht, 1,1,0,0,1);
				}
			if(User.posY<75||User.posY>280)
				{
				//s.play(ht, 1,1,0,0,1);
				ssY=((-ssY*9)/10);
				CHECK();
				}}
              
              
        //  if(check()==1)
            {if(Bot.posX<50||Bot.posX>395)
				{
				sX=(-sX*9)/10;
				check();
			//	s.play(ht, 1,1,0,0,1);
				}
			if(Bot.posY<75||Bot.posY>280)
				{
				//s.play(ht, 1,1,0,0,1);
				sY=((-sY*9)/10);
				check();
				}}
			if(Math.abs(sX)<=2||Math.abs(sY)<=2)
			{
				secondObject();
				ToPoint();
				
			}
			
		}

		private void collision() {
			// TODO Auto-generated method stub
			
			float dis = (float) Math.sqrt(  (((User.posX +(User.image.getWidth()/2)) - (Bot.posX+(Bot.image.getWidth()/2)))*
					                         ((User.posX +(User.image.getWidth()/2)) - (Bot.posX+(Bot.image.getWidth()/2)))) 
					                         
					                         +
					                         
					                        (((User.posY +(User.image.getHeight()/2)) - (Bot.posY+(Bot.image.getHeight()/2)))*
					                         ((User.posY +(User.image.getHeight()/2)) - (Bot.posY+(Bot.image.getHeight()/2))))
					                         
					                         )  ;
			if (dis<minD-3) 
			    {
								
				Bot.hit += (User.dam-Bot.def+r.nextInt(3));
				User.rot-=r.nextInt(9200);
				
				User.hit+=(Bot.dam-User.def+r.nextInt(3));
				Bot.rot-=r.nextInt(9200);
				
				//s.play(ht, 1,1,0,0,1);
				if(sX>ssX||sY>ssY){
				
			    if(ssX>ssY)
					ssX=-ssX;
				else			  
				    ssY=-ssY;
				}
				else{			
					// s.play(ht, 1,1,0,0,1);
	    	    if(sX>sY)					 
					sX=-sX; 
				else				  
					sY=-sY;
					
			    }}
	}
		private void secondObject() {
			// TODO Auto-generated method stub
			// this is for Bot.hit.image
					X =50+ r.nextInt(344) ;
					Y =60+ r.nextInt(219) ;
					sX=Bot.dx*((X-Bot.posX)/1000);
					sY=Bot.dx*((Y-Bot.posY)/1000) ;
		}
	
	}
	
	 
	
	float  sensorX, sensorY, X, Y,sX,sY,ssX,ssY,minD;
	Blade Bot,User;
	Bitmap bkg;
	int x, y,m=0;
	TextCont t;
	back td;
	
	Random r = new Random();	
	
	SurfaceHolder ourHolder;
	Thread ourThread = null;
	boolean isRunning = false;
	Paint textPaint = new Paint();
	Canvas canvas;
	dobg d ;
	int ht=0;
	
	
	private class dobg extends AsyncTask<Integer,Integer,Integer>
	   {

		@Override
		protected Integer doInBackground(Integer... arg0) {
			// TODO Auto-generated method stub
			
			x=(int)User.rot/1000;
			y=(int)Bot.rot/1000;
			if (Bot.hit >= 500 || User.hit >= 500) {
				canvas.drawARGB(100,1,1,1);	
				t.HitFinish(textPaint, canvas, Bot.hit/5, User.hit/5);
				m=1;
			}else if(x<=0||y<=0){
				canvas.drawARGB(100,255,255,255);
				t.rpmFinish(textPaint, canvas, x, y);
				m=1;
			}else{
				drawIt();
			    t.CalHit(textPaint, canvas, Bot.hit/5, User.hit/5, x, y);
		     	
			}
			
			
			return null;
		}

				
	    }

	public MyAnimeSurface(Context context,int data) {
		// TODO Auto-generated constructor stub
		super(context);
		
		Bot = new Blade(1+r.nextInt(8));
		User = new Blade(data);
		td = new back();
		
		
		
		//s = new SoundPool(5,AudioManager.STREAM_MUSIC,0);
		//ht  = s.load(getContext(), R.raw.hit,1);
		
		
	    bkg = BitmapFactory.decodeResource(getResources(), R.drawable.cptbkg);		
	    bkg.prepareToDraw();
	    
		
		t = new TextCont(null);
		sensorX = sensorY =X=Y= 0;
	    User.posY=Bot.posX=Bot.posY= 100;
	    minD= (float) Math.sqrt( ((Bot.image.getWidth()/2 +User.image.getWidth()/2)*(Bot.image.getWidth()/2 +User.image.getWidth()/2))
	    		                 +
	    		                 ((Bot.image.getHeight()/2 +User.image.getHeight()/2)*(Bot.image.getHeight()/2 +User.image.getHeight()/2)));
		User.posX=300;
		Bot.hit =  User.hit = 0;
		sX=(X-Bot.posX)/30;
		sY=(Y-Bot.posY)/30;
		x=y=10;
		Bot.rot=User.rot=1000000;
		
		d= new dobg();
		ourHolder = getHolder();
	}
	
	

	
	public void Pause() {
		isRunning = false;
		while (!isRunning) {
			try {
				ourThread.join();
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			break;
		}
		td=null;
		ourThread = null;
	}

	public void resume() {
		isRunning = true;
		ourThread = new Thread(this);
		ourThread.start();
		td.start();
	}

	@Override
	public void run() {
		// TODO Auto-generated method stub
		while (isRunning) {
			if (!ourHolder.getSurface().isValid())
				continue;
			canvas = ourHolder.lockCanvas();
			canvas.drawRGB(255, 255, 255);
						
			try {
				Thread.sleep(50);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
			
			{
				canvas.drawBitmap(bkg, 0,0,null);
				 
			    d.doInBackground(null);
			}
			ourHolder.unlockCanvasAndPost(canvas);
		} 
		
	}

	
	private void drawIt() {
		// TODO Auto-generated method stub
		
		    
			canvas.save();
			canvas.rotate(User.rot, User.posX + User.image.getWidth() / 2,User.posY + User.image.getHeight() / 2);
			User.rot-=50;
			canvas.drawBitmap(User.image, User.posX, User.posY, null);
			canvas.restore();
			canvas.save();
			canvas.rotate(Bot.rot, Bot.posX + Bot.image.getWidth() / 2,Bot.posY + Bot.image.getHeight() / 2);
			Bot.rot-=50;
			canvas.drawBitmap(Bot.image, Bot.posX, Bot.posY, null);
			
			canvas.restore();
			
		}

	private void ToPoint() {
		// TODO Auto-generated method stub
		if(check()==1)
		{
			Bot.posX+=sX;
			Bot.posY+=sY;
		}
	}
 
	private int check(){
		
		int n = 0;
		if(Bot.posX+sX>395||Bot.posX+sX<50)
			{
			sX=sX/2;
			n+=1;
			}
		if(Bot.posY+sY>280||Bot.posY+sY<75)
			{
			sY=sY/2;
			n+=1;
			}
		  if(n!=0)
		   check();
		  
		   return 1;
	}
	
	
	private void senSor() {
		// TODO Auto-generated method stub
		
		if(CHECK()==1)
		{
		User.posX+=ssX;
		User.posY+=ssY;}
	}


	private int CHECK() {
		// TODO Auto-generated method stub
		int n = 0;
		if(User.posX+ssX>395||User.posX+ssX<50)
			{
			ssX=ssX/2;
			n+=1;
			}
		if(User.posY+ssY>280||User.posY+ssY<75)
			{
			ssY=ssY/2;
			n+=1;
			}
		  if(n!=0)
		   CHECK();
		  
		   return 1;
	}




	public void Update(float sensorX1, float sensorY1) {
		// TODO Auto-generated method stub

		sensorX=sensorX1;
		sensorY=sensorY1;
		
		ssX = User.dx*((sensorX-User.posX)/1000);
	    ssY=  User.dx*((sensorY-User.posY)/1000);
	}


     
}