package com.parvez_n_jabed_co.ccc_project;

import android.R.integer;
import android.graphics.Bitmap;
import android.graphics.Paint;
import android.graphics.Point;
import android.view.VelocityTracker;

public class Robot {
	int centerX,centerY;
	int height,width;
	Bitmap robotBitmap;
	Paint robotPaint;
	float velocityX,velocityY;
	public Robot(Bitmap bitmap) {
		robotBitmap=bitmap;
		centerX=centerY=0;
		velocityX=velocityY=0;
		height=robotBitmap.getHeight();
		width=robotBitmap.getWidth();
		robotPaint=new Paint();
	}

	public Robot(Bitmap bitmap,int cX,int cY) {
		this(bitmap);
		centerX=cX;
		centerY=cY;
		velocityX=velocityY=0;
	}

	public Robot(Bitmap bitmap, Point center) {
		this(bitmap, center.x, center.y);
	}
	
	public void setCenter(Point centerPoint) {
		centerX=centerPoint.x;
		centerY=centerPoint.y;
	}
	public Point getCenter() {
		Point point = new Point();
		point.x = centerX;
		point.y = centerY;
		return  point;
	}

	public void setVelocity(VelocityTracker velocityTracker) {
		velocityX=velocityTracker.getXVelocity();
		velocityY=velocityTracker.getYVelocity();
	}

}
