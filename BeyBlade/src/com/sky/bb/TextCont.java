package com.sky.bb;

import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Paint.Align;

public class TextCont {
	
	public TextCont(MyAnimeSurface myAnimeSurface) {
		// TODO Auto-generated constructor stub
	}

	
	
	public void CalHit(Paint textPaint,Canvas canvas,int B1,int B2,int x,int y){
		textPaint.setARGB(1000, 1, 1, 255);
		textPaint.setTextAlign(Align.LEFT);
		textPaint.setTextSize(canvas.getHeight()/22);
		canvas.drawText("BOT - HIT!!  " + B1, 10, 20, textPaint);
		canvas.drawText(x +" rmp",10 ,37,textPaint);
		textPaint.setARGB(1000, 255, 1, 1);
		textPaint.setTextAlign(Align.CENTER);
		canvas.drawText("YOUR - HIT!!  " + B2, canvas.getWidth()-70, 20, textPaint);
		canvas.drawText(y +" rmp",canvas.getWidth()-70,37,textPaint);
	}

	public void HitFinish(Paint textPaint,Canvas canvas,int B1,int B2) {
		// TODO Auto-generated method stub
		if (B1 >= 99) {
			
			textPaint.setARGB(1000, 1, 255, 1);
			textPaint.setTextAlign(Align.LEFT);
			textPaint.setTextSize(80);
			canvas.drawText("You Win by ", 60, 140,textPaint);	
			canvas.drawText((B1-B2)+" Hits", 80, 240,textPaint);
		} else if(B2>=99) {
			textPaint.setARGB(1000, 255, 1, 1);
			textPaint.setTextAlign(Align.LEFT);
			textPaint.setTextSize(80);
			canvas.drawText("PC Wins by ", 60, 140,textPaint);	
			canvas.drawText((B2-B1)+" Hits", 80, 240,textPaint);
			
		}	
	}
	
	
	public void rpmFinish(Paint textPaint,Canvas canvas,int x,int y) {
		// TODO Auto-generated method stub
		if(x<=0)
		{
			textPaint.setARGB(1000, 1, 255, 1);
			textPaint.setTextAlign(Align.LEFT);
			textPaint.setTextSize(80);
			canvas.drawText("You Win by ", 60, 140,textPaint);	
			canvas.drawText(y+" rmp", 80, 240,textPaint);
		}else{
			textPaint.setARGB(1000, 255, 1, 1);
			textPaint.setTextAlign(Align.LEFT);
			textPaint.setTextSize(80);
			canvas.drawText("PC Wins by ", 60, 140,textPaint);	
			canvas.drawText(x+" rmp", 80, 240,textPaint);
		}
	}}

