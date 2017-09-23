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
import android.graphics.Typeface;
import android.os.Vibrator;
import android.support.v4.media.RatingCompat;
import android.view.Display;
import android.view.WindowManager;

import static android.content.Context.VIBRATOR_SERVICE;


public class DrawingThread extends Thread {

	int total_circleItem ;

	String courseShortName ;
	String timeremaining;
	Bitmap nextCourseIcon;
	int displayXbyTwo;
	public  Bitmap navigationicon;
	public 	Bitmap centerIconMain;
	public 	Bitmap centerIconPause;
	Point circleCentre ;
	float circleDiamiter;
	float circleRadius;
	float permaincell;
	float icon_all_height ;
	boolean vibrating,permission;
	Paint paintCourseCode,smallcircle;
	Paint paintCourseName;
	Paint paintRoomTime;
	Paint paintCourseShortName;
ArrayList<String> names;
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
        names = new ArrayList<String>();
		Point displayDimension=new Point();
		defaultDisplay.getSize(displayDimension);
		displayX=displayDimension.x;
		displayXbyTwo = displayX/2;
		displayY=displayDimension.y;
		permaincell = displayY/16f;
		icon_all_height = permaincell*1.2f;
		circleCentre = new Point(displayX/2,(int)permaincell*11);
		circleDiamiter = permaincell*7.5f;
		circleRadius = circleDiamiter/2;
		vibrating = false;
		permission = false;


		Bitmap tempBitmap=BitmapFactory.decodeResource(context.getResources(), R.drawable.center);
		centerIconMain=Bitmap.createScaledBitmap(tempBitmap, (int)circleDiamiter, (int)circleDiamiter, true);
		centerIcon = centerIconMain;
		Bitmap tempBitmap1=BitmapFactory.decodeResource(context.getResources(), R.drawable.center);
		centerIconPause=Bitmap.createScaledBitmap(tempBitmap1, (int)circleDiamiter, (int)circleDiamiter, true);
		centerIcon = centerIconPause;


		backgroundBitmap=BitmapFactory.decodeResource(context.getResources(), R.drawable.bg,null);
		backgroundBitmap=Bitmap.createScaledBitmap(backgroundBitmap, displayX, (backgroundBitmap.getHeight()/backgroundBitmap.getWidth())*displayY, true);


		paintCourseCode = new Paint();
		paintCourseCode.setTextAlign(Paint.Align.CENTER);
		paintCourseCode.setColor(Color.parseColor("#D2DEE5"));
		paintCourseCode.setTextSize(0.6f*permaincell);

		paintCourseName = new Paint();
		paintCourseName.setTextAlign(Paint.Align.CENTER);
		paintCourseName.setColor(Color.parseColor("#C3D5D5"));
		paintCourseName.setTextSize(0.42f*permaincell);


		paintRoomTime = new Paint();
		paintRoomTime.setTextAlign(Paint.Align.CENTER);
		paintRoomTime.setColor(Color.parseColor("#A5C1C1"));
		paintRoomTime.setTextSize(0.37f*permaincell);

		paintCourseShortName = new Paint();
		paintCourseShortName.setTypeface(Typeface.create(Typeface.DEFAULT,Typeface.BOLD));
		paintCourseShortName.setTextAlign(Paint.Align.CENTER);
		paintCourseShortName.setColor(Color.parseColor("#D2DEE5"));
		paintCourseShortName.setTextSize(0.5f*permaincell);
		smallcircle = new Paint();
		//smallcircle.setStyle(Paint.Style.FILL);
		smallcircle.setColor(Color.WHITE);
		smallcircle.setStrokeWidth(2);

initializeAllPossibleRobots();
	}


	private void initializeAllPossibleRobots() {
		allRobots=new ArrayList<Robot>();
		allPossibleRobots=new ArrayList<Bitmap>();


		allPossibleRobots.add(giveResizedRobotBitmap(R.drawable.officials));
		allPossibleRobots.add(giveResizedRobotBitmap(R.drawable.education));
		allPossibleRobots.add(giveResizedRobotBitmap(R.drawable.health));
		allPossibleRobots.add(giveResizedRobotBitmap(R.drawable.newspaper));
		allPossibleRobots.add(giveResizedRobotBitmap(R.drawable.forms));
		allPossibleRobots.add(giveResizedRobotBitmap(R.drawable.tax));
		allPossibleRobots.add(giveResizedRobotBitmap(R.drawable.tender));
		allPossibleRobots.add(giveResizedRobotBitmap(R.drawable.communication));
		allPossibleRobots.add(giveResizedRobotBitmap(R.drawable.entertainment));
		allPossibleRobots.add(giveResizedRobotBitmap(R.drawable.emergency));
		allPossibleRobots.add(giveResizedRobotBitmap(R.drawable.complain));
		allPossibleRobots.add(giveResizedRobotBitmap(R.drawable.helpline));
		names.add("চসিক অফিসিয়ালস"); //CCC Internal
		names.add("শিক্ষা"); //Education
				names.add("স্বাস্থ্য");//Health
				names.add("প্রেস রিলিজ"); //Press Release
				names.add("ফর্ম"); //
				names.add("ট্যাক্স");
				names.add("ই-টেন্ডার");
				names.add("যোগাযোগ"); //Communication
				names.add("বিনোদন");
				names.add("জরুরী সেবা");
				names.add("অভিযোগ বাক্স");
				names.add("হেল্পলাইন");
		double angl = 360/12;
		for(int i=0;i<12;i++)
		{
			Point pointn = GetPosition(getScreenCenter(),(int)(i*angl)%360,circleRadius-allPossibleRobots.get(0).getWidth()/2);
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

	public void setplay()
	{
		centerIcon = centerIconMain;
	}
	public  void  setpause()
	{
		centerIcon = centerIconPause;
	}


	public Point getScreenCenter()
	{
		Point temp = new Point();
		temp.x = displayX/2;
		temp.y=displayY/2;
		return  temp;
	}
	private void updateDisplay() {
		Paint paint = new Paint();
		paint.setAntiAlias(false);
		paint.setDither(true);
		canvas.drawBitmap(backgroundBitmap, 0	, 0	, paint);


		canvas.drawBitmap(centerIcon,getScreenCenter().x-circleRadius,getScreenCenter().y-circleRadius,null);
/*

		RoutineForSort temp = myclasses.get(0);
		canvas.drawText(temp.courseCode, displayXbyTwo, (permaincell*4.6f), paintCourseCode);
		canvas.drawText(temp.courseFullName, displayXbyTwo, (permaincell*5.2f), paintCourseName);
		canvas.drawText("Room : "+temp.roomNumber+"       Time: "+myclasses.get(0).startTime, displayXbyTwo, (permaincell*5.6f), paintRoomTime);
		canvas.drawText("Section : "+temp.section, displayXbyTwo, (permaincell*6.0f), paintRoomTime);
		canvas.drawText(temp.miniAlarm.getTimeUntilNextAlarmMessage(temp.miniAlarm.getTimeUntilNextLongtime())+"", displayXbyTwo, (permaincell*6.4f), paintRoomTime);
*/



		// Down part

		//canvas.drawText("jdhsjdg", displayXbyTwo, (displayY/2)+circleRadius+icon_all_height, paintCourseShortName);

		float radius = getScreenCenter().y-(circleRadius - icon_all_height / 2);
		canvas.drawCircle(displayXbyTwo,radius,icon_all_height/8,paint);

		for (int i = 0; i < allRobots.size(); i++) {
			Robot tempRobot=allRobots.get(i);

			canvas.drawBitmap(tempRobot.robotBitmap, tempRobot.centerX-(tempRobot.width/2), tempRobot.centerY-(tempRobot.height/2), tempRobot.robotPaint);


			double disc2t = Math.sqrt(((tempRobot.centerX - displayXbyTwo) * (tempRobot.centerX - displayXbyTwo)) + ((tempRobot.centerY -radius) * (tempRobot.centerY -radius)));

			if(disc2t<icon_all_height/4){

				courseShortName = names.get(i) ;

				//	 canvas.drawText(courseShortName, displayXbyTwo, (permaincell*15f), paintCourseShortName);
				//	 canvas.drawText(timeremaining, displayXbyTwo, (permaincell*15.4f), paintRoomTime);
			}
		}

		canvas.drawText(courseShortName, displayXbyTwo, (displayY/2)+circleRadius+icon_all_height, paintCourseShortName);
//		canvas.drawText(timeremaining, displayXbyTwo, (permaincell*15.4f), paintRoomTime);
	}


	public void stopThread() {
		threadFlag=false;
	}
	
	
}
