package com.parvez_n_jabed_co.ccc_project;

import java.util.ArrayList;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Point;
import android.view.Display;
import android.view.WindowManager;


public class DrawingThread extends Thread {

	private Canvas canvas;
	private GameView gameView;
	private Context context;
	
	boolean threadFlag=false;
	
	Bitmap backgroundBitmap;
	int displayX,displayY;
	Bitmap centerIcon;
	ArrayList<Robot> allRobots;
	ArrayList<Bitmap> allPossibleRobots;
	
	
	public DrawingThread( GameView gameView, Context context) {
		super();
		this.gameView = gameView;
		this.context = context;
	
		initializeAll();
		
	
	}


	private void initializeAll() {
		WindowManager windowManager=(WindowManager) context.getSystemService(Context.WINDOW_SERVICE);
		Display defaultDisplay=windowManager.getDefaultDisplay();
		
		Point displayDimension=new Point();
		defaultDisplay.getSize(displayDimension);
		
		displayX=displayDimension.x;
		displayY=displayDimension.y;
		
		backgroundBitmap=BitmapFactory.decodeResource(context.getResources(), R.drawable.background	);
		backgroundBitmap=Bitmap.createScaledBitmap(backgroundBitmap, displayX, displayY, true);
		
		initializeAllPossibleRobots();

		Point point = new Point();

	//	allRobots.add(new Robot(allPossibleRobots.get(0), ));

	}


	private void initializeAllPossibleRobots() {
		allRobots=new ArrayList<Robot>();
		allPossibleRobots=new ArrayList<Bitmap>();

		Bitmap tempBitmap=BitmapFactory.decodeResource(context.getResources(), R.drawable.health);
		centerIcon=Bitmap.createScaledBitmap(tempBitmap, displayX/4, (tempBitmap.getHeight()/tempBitmap.getWidth())*(displayX/4), true);


		allPossibleRobots.add(giveResizedRobotBitmap(R.drawable.officials));
		allPossibleRobots.add(giveResizedRobotBitmap(R.drawable.education));
		allPossibleRobots.add(giveResizedRobotBitmap(R.drawable.health));
		allPossibleRobots.add(giveResizedRobotBitmap(R.drawable.location));
		allPossibleRobots.add(giveResizedRobotBitmap(R.drawable.forms));
		allPossibleRobots.add(giveResizedRobotBitmap(R.drawable.tax));
		allPossibleRobots.add(giveResizedRobotBitmap(R.drawable.tender));
		allPossibleRobots.add(giveResizedRobotBitmap(R.drawable.communication));
		allPossibleRobots.add(giveResizedRobotBitmap(R.drawable.entertainment));
		allPossibleRobots.add(giveResizedRobotBitmap(R.drawable.emergency));
		allPossibleRobots.add(giveResizedRobotBitmap(R.drawable.complain));
		allPossibleRobots.add(giveResizedRobotBitmap(R.drawable.helpline));

		double angl = 360/12;
		for(int i=0;i<12;i++)
		{
			Point pointn = GetPosition(getScreenCenter(),(int)(i*angl)%360,200f-allPossibleRobots.get(0).getWidth()/2);

			allRobots.add(new Robot(allPossibleRobots.get(i),pointn));
		}
		
	}
	
	private Bitmap giveResizedRobotBitmap(int resourceID) {
		Bitmap tempBitmap=BitmapFactory.decodeResource(context.getResources(), resourceID);
		tempBitmap=Bitmap.createScaledBitmap(tempBitmap, displayX/6, (tempBitmap.getHeight()/tempBitmap.getWidth())*(displayX/6), true);
	
		return tempBitmap;
	}


	@Override
	public void run() {
		threadFlag=true;


		while (threadFlag) {
			
			canvas=gameView.surfaceHolder.lockCanvas();
			
			try {
				synchronized (gameView.surfaceHolder) {
					
					updateDisplay();
					
				}
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} finally{
				if (canvas!=null) {
					gameView.surfaceHolder.unlockCanvasAndPost(canvas);
				}
			}
			
			
			try {
				Thread.sleep(10);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
			
			
			
		}



	}

	public Point GetPosition(Point CurPos, float angle, float distance)
	{
		//Get SOH
		angle = angle *(float) Math.PI / 180f;
		float op = (float)Math.sin(angle) * distance;
		//Get CAH
		float ad = (float)Math.cos(angle) * distance;
		//Add to old Vector
		CurPos.x +=ad;
		CurPos.y+=op;
		return (CurPos);
	}

	public Point getScreenCenter()
	{
		Point temp = new Point();
		temp.x = displayX/2;
		temp.y=displayY/2;
		return  temp;
	}
	private void updateDisplay() {
		canvas.drawBitmap(backgroundBitmap, 0	, 0	, null);


		Paint paint = new Paint();
		paint.setStyle(Paint.Style.FILL);
		paint.setColor(Color.BLACK);
		paint.setAlpha(20);
		paint.setStrokeWidth(2);
		float centerposx = backgroundBitmap.getWidth()/2;
		float centerposy = backgroundBitmap.getHeight()/2;
		canvas.drawCircle(centerposx,centerposy,200f,paint);

		canvas.drawBitmap(centerIcon,centerposx-centerIcon.getWidth()/2,centerposy-centerIcon.getHeight()/2,null);

		for (int i = 0; i < allRobots.size(); i++) {
			Robot tempRobot=allRobots.get(i);
			
			canvas.drawBitmap(tempRobot.robotBitmap, tempRobot.centerX-(tempRobot.width/2), tempRobot.centerY-(tempRobot.height/2), tempRobot.robotPaint);
		}
	}


	public void stopThread() {
		threadFlag=false;
	}
	
	
}
