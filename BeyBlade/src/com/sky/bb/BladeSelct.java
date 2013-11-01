/*
A very basic interface to select the beyblade u want to choose
for the battle.
  Every blade has a different set of properties related.
  choose the one that suits you.

*/
package com.sky.bb;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.TabHost;
import android.widget.TabHost.TabSpec;

public class BladeSelct extends Activity implements OnClickListener{

	Button bstart,bUp,bDown;
	int x=1,y=0,z=0;
	ImageView I,J;
	TabHost th;
	ProgressBar Abar,Dbar,Sbar;
  
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		setContentView(R.layout.menuact);

		I = (ImageView)findViewById(R.id.imageView1);
		J = (ImageView)findViewById(R.id.imageView2);
		I.setImageResource(R.raw.blade1);
		J.setImageResource(R.raw.weight);
		
		Abar=(ProgressBar)findViewById(R.id.progressBar1);
		Abar.setProgress(50);
		Dbar=(ProgressBar)findViewById(R.id.progressBar2);
		Dbar.setProgress(30);
		Sbar=(ProgressBar)findViewById(R.id.progressBar3);
		Sbar.setProgress(30);
		
		th = (TabHost) findViewById(R.id.tabhost);
		
		z = th.getCurrentTab();
		th.setup();
		TabSpec specs = th.newTabSpec("tag1");		
		specs.setContent(R.id.tab1);
		specs.setIndicator("Attack");
		th.addTab(specs);
		
		specs = th.newTabSpec("tag2");
		specs.setContent(R.id.tab2);
		specs.setIndicator("Defence");
		th.addTab(specs);
		
		specs = th.newTabSpec("tag3");
		specs.setContent(R.id.tab3);
		specs.setIndicator("core");
		th.addTab(specs);
		
		specs = th.newTabSpec("tag4");
		specs.setContent(R.id.tab4);
		specs.setIndicator("tip");
		th.addTab(specs);

		
		
		bstart = (Button)findViewById(R.id.bStart);
		bUp = (Button)findViewById(R.id.bUp);
		bDown = (Button)findViewById(R.id.bDown);
		bUp.setOnClickListener(this);
		bDown.setOnClickListener(this);
		bstart.setOnClickListener(this);
		
	}


	@Override
	public void onClick(View arg0) {
		// TODO Auto-generated method stub
		z = th.getCurrentTab();
		switch(arg0.getId()){
		
		case R.id.bStart:
			 
			            Bundle b = new Bundle();                       //create bundle to send params across classes
			            b.putInt("key", x);                            // puttting data intio the bundle
			            Intent i = new Intent(this,Play.class);        // a new activity
                        this.finish();                                 //finishing this activity, so to reach main menu after the game finishes
                        i.putExtras(b);
                        startActivity(i);
                        break;
                        
		case R.id.bUp   :
			            if(z==0){	                                    //selection of the blade
                        	 if(x!=0||x<9)
                        		  ++x;
			            switch(x){
			            case 1:
			                   I.setImageResource(R.raw.blade1);
			                   Abar.setProgress(50);
			                   Dbar.setProgress(30);
			                   Sbar.setProgress(30);
			           		   break;
			            case 2:	
                               I.setImageResource(R.raw.blade2);
                               Abar.setProgress(60);
                               Dbar.setProgress(20);
			                   Sbar.setProgress(25);
                               break;
			            case 3:	
                               I.setImageResource(R.raw.blade3);
                               Abar.setProgress(70);
                               Dbar.setProgress(10);
			                   Sbar.setProgress(20);
                               break;
			            case 4:	
                               I.setImageResource(R.raw.blade4);
                               Abar.setProgress(50);
                               Dbar.setProgress(30);
			                   Sbar.setProgress(30);
                               break;
			            case 5:	
                               I.setImageResource(R.raw.blade5);
                               Abar.setProgress(40);
                               Dbar.setProgress(30);
			                   Sbar.setProgress(35);
                               break;
			            case 6:	
                               I.setImageResource(R.raw.blade6);
                               Abar.setProgress(50);
                               Dbar.setProgress(20);
			                   Sbar.setProgress(40);
                               break;
			            case 7:	
                               I.setImageResource(R.raw.blade7);
                               Abar.setProgress(70);
                               Dbar.setProgress(10);
			                   Sbar.setProgress(20);
                               break; 
			            case 8:	
                               I.setImageResource(R.raw.blade8);
                               Abar.setProgress(60);
                               Dbar.setProgress(20);
			                   Sbar.setProgress(25);
                               break;    
                        default:
                               x=8;
                        	   break;
			            }}
                         
                        if(z==1)
                            {
                        	++y;
                        	switch(y%2){
    			            case 0:
    			                   J.setImageResource(R.raw.drgun);
    			                   break;
    			            case 1:	
                                   J.setImageResource(R.raw.drcle);
                                   break;
    			             }
                            }
			            break;	            
		case R.id.bDown :
			            if(z==0){	                                         //scrolling down
	                            if(x>1)
	                            	--x;	                            
	                            switch(x){
	                            case 1:
	 			                   I.setImageResource(R.raw.blade1);
	 			                   Abar.setProgress(50);
	 			                   Dbar.setProgress(30);
	 			                   Sbar.setProgress(30);
	 			           		   break;
	 			            case 2:	
	                                I.setImageResource(R.raw.blade2);
	                                Abar.setProgress(60);
	                                Dbar.setProgress(20);
	 			                   Sbar.setProgress(25);
	                                break;
	 			            case 3:	
	                                I.setImageResource(R.raw.blade3);
	                                Abar.setProgress(70);
	                                Dbar.setProgress(10);
	 			                   Sbar.setProgress(20);
	                                break;
	 			            case 4:	
	                                I.setImageResource(R.raw.blade4);
	                                Abar.setProgress(50);
	                                Dbar.setProgress(30);
	 			                   Sbar.setProgress(30);
	                                break;
	 			            case 5:	
	                                I.setImageResource(R.raw.blade5);
	                                Abar.setProgress(40);
	                                Dbar.setProgress(30);
	 			                   Sbar.setProgress(35);
	                                break;
	 			            case 6:	
	                                I.setImageResource(R.raw.blade6);
	                                Abar.setProgress(50);
	                                Dbar.setProgress(20);
	 			                   Sbar.setProgress(40);
	                                break;
	 			            case 7:	
	                                I.setImageResource(R.raw.blade7);
	                                Abar.setProgress(70);
	                                Dbar.setProgress(10);
	 			                   Sbar.setProgress(20);
	                                break; 
	 			            case 8:	
	                                I.setImageResource(R.raw.blade8);
	                                Abar.setProgress(60);
	                                Dbar.setProgress(20);
	 			                   Sbar.setProgress(25);
	                                break;             
                                default:
                                	   x=1;
                                	   break;
	                           }}
			            if(z==1)
			            {
			            ++y;
			            switch(y%2){
			            case 0:
			                   J.setImageResource(R.raw.drgun);
			                   break;
			            case 1:	
                               J.setImageResource(R.raw.drcle);
                               break;
			            }}
			            break;
			            
		}
	}

}
