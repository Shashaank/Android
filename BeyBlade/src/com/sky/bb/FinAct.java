/*
This activity publishes the end result after a game.

*/

package com.sky.bb;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.ImageButton;
import android.widget.TextView;

public class FinAct extends Activity implements OnClickListener{
	
	TextView t,v;
    ImageButton i;
	@Override
	public void onBackPressed() {
		// TODO Auto-generated method stub
		super.onBackPressed();
		finish();
		
	}

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		setContentView(R.layout.finact);
		
		init();
		
		
	}

	private void init() {                                     // initialization of variables
		// TODO Auto-generated method stub
		
		t=(TextView)findViewById(R.id.textView1);
		v=(TextView)findViewById(R.id.textView2);
		i= (ImageButton)findViewById(R.id.imageButton1);
		i.setOnClickListener(this);
		Bundle b = getIntent().getExtras();
		int d = b.getInt("outcome");
		int p = b.getInt("result");
		if(p==0)
			 t.setText("You Lost ");
		else
			 t.setText("You Won ");
		v.setText("By "+ d + "Hit");
		
	}

	@Override
	public void onClick(View arg0) {
		// TODO Auto-generated method stub
		if(arg0.getId()==R.id.imageButton1){
			finish();
		}
		
	}
		
		
	}

