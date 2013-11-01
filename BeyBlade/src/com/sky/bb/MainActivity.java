package com.sky.bb;

import android.os.Bundle;
import android.app.Activity;
import android.content.Intent;
import android.view.Menu;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;

public class MainActivity extends Activity implements OnClickListener{

Button bp,bs,be;	
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		 
		initialize();
		
		
		 
	}

	private void initialize() {
		// TODO Auto-generated method stub
		
		bp = (Button) findViewById(R.id.bplay);
		bs = (Button) findViewById(R.id.bset);
		be = (Button) findViewById(R.id.bexit);
		bp.setOnClickListener(this);
		bs.setOnClickListener(this);
		be.setOnClickListener(this);
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		//getMenuInflater().inflate(R.menu.main, menu);
		return true;
	}

	@Override
	public void onBackPressed() {
		// TODO Auto-generated method stub
		super.onBackPressed();
		super.finish(); 
	}

	@Override
	public void onClick(View v) {
		// TODO Auto-generated method stub 
		switch(v.getId()){
		
		case R.id.bplay:
			           Intent i = new Intent(this,BladeSelct.class);
			           startActivity(i);
			           break;
		case R.id.bset:
		               Intent j = new Intent(this,Set.class);
		               startActivity(j);
	                   break;
		case R.id.bexit:
		               this.finish();
	                   break;               
	                   
		
		
		}
	}

}
