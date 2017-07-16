package com.parvez_n_jabed_co.ccc_project;

import java.util.Random;

import android.content.Context;
import android.graphics.Point;
import android.provider.ContactsContract;
import android.view.MotionEvent;
import android.view.SurfaceHolder;
import android.view.SurfaceHolder.Callback;
import android.view.SurfaceView;

public class GameView extends SurfaceView implements Callback{
	Context context;
	SurfaceHolder surfaceHolder;
	DrawingThread drawingThread;
	GameActivity gameActivity;

	int selectedindex = -1;
	int selectedicon = -1;
     float incr = 0f;
	AnimationThread animationThread;
    int flag = 0;
	public GameView(Context context, GameActivity gameActivity1) {
		super(context);
		this.context=context;
		this.gameActivity = gameActivity1;
		surfaceHolder=getHolder();
		surfaceHolder.addCallback(this);
		
		drawingThread=new DrawingThread( this, context);

		 animationThread=new AnimationThread(drawingThread);


	}


	@Override
	public void surfaceChanged(SurfaceHolder holder, int format, int width,
			int height) {
		// TODO Auto-generated method stub
		
	}


	@Override
	public void surfaceCreated(SurfaceHolder holder) {
		try {
			drawingThread.start();
			animationThread.start();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			restartTread();
		}
	}


	private void restartTread() {
		drawingThread.stopThread();
		drawingThread=null;
		drawingThread=new DrawingThread(this, context);
		drawingThread.start();
		animationThread.stopThread();
		animationThread=null;
		animationThread = new AnimationThread(drawingThread);
		animationThread.start();
		// TODO Auto-generated method stub
		
	}


	@Override
	public void surfaceDestroyed(SurfaceHolder holder) {
		drawingThread.stopThread();
	}
	
	@Override
	public boolean onTouchEvent(MotionEvent event) {
		long  startTime =0 ;
		long  endtTime =0;

		Point touchPoint=new Point();
		touchPoint=new Point((int)event.getX(), (int)event.getY());
		Random random=new Random();

		switch (event.getAction()) {
		case MotionEvent.ACTION_DOWN:
//			 startTime = event.getEventTime();


				break;
		case MotionEvent.ACTION_UP:

			long timm = event.getEventTime()-event.getDownTime();
			if(timm<250) {

				animationThread.stopThread();
				float ax = (float) touchPoint.x;
				float ay = (float) touchPoint.y;
				Point center = new Point();
				center = drawingThread.getScreenCenter();
				double disc2t = Math.sqrt(((ax - center.x) * (ax - center.x)) + ((ay - center.y) * (ay - center.y)));
				float radius = 300f - drawingThread.allPossibleRobots.get(0).getWidth() / 2;
				if (disc2t - drawingThread.allPossibleRobots.get(0).getWidth() / 2 < radius && disc2t + drawingThread.allPossibleRobots.get(0).getWidth() / 2 > radius) {
					selectedicon = -1;
					endtTime = 0;
					for (int i = 0; i < drawingThread.allRobots.size(); i++) {
						Point point = new Point();
						point = drawingThread.allRobots.get(i).getCenter();
						float bx = (float) point.x;
						float by = (float) point.y;
						double dis = Math.sqrt(((ax - bx) * (ax - bx)) + ((ay - by) * (ay - by)));
						if (dis < (drawingThread.allRobots.get(i).width / 2.0f)) {
							selectedicon = i;
						}

					}
				}
				if (selectedicon == 0) {
					gameActivity.startActivityCCC();
				} else if (selectedicon == 1) {
					gameActivity.startActivityEducation();
				} else if (selectedicon == 2) {
					gameActivity.startActivityHealth();
				} else if (selectedicon == 3) {
					gameActivity.startActivityCirtificate();
				} else if (selectedicon == 4) {
					gameActivity.startActivityForms();
				} else if (selectedicon == 5) {
					gameActivity.startActivityTax();
				} else if (selectedicon == 6) {
					gameActivity.startActivityTender();
				} else if (selectedicon == 7) {
					gameActivity.startActivityComunication();
				} else if (selectedicon == 8) {
					gameActivity.startActivityEntertainment();
				} else if (selectedicon == 9) {
					gameActivity.startActivityEmargency();
				} else if (selectedicon == 10) {
					gameActivity.startActivityComplain();
				} else if (selectedicon == 11) {
					gameActivity.startActivityHealpline();
				}


			}
			selectedindex = -1;
			selectedicon =  -1;
//			  endtTime = event.getEventTime();
			break;
		case MotionEvent.ACTION_MOVE:
			float ax = (float)touchPoint.x;
			float ay = (float)touchPoint.y;

			Point center = new Point();
			center = drawingThread.getScreenCenter();
			double disc2t = Math.sqrt(((ax-center.x)*(ax-center.x))+((ay-center.y)*(ay-center.y)));
			double radius = 300f-drawingThread.allPossibleRobots.get(0).getWidth()/2;
			if(selectedindex==-1&&disc2t-drawingThread.allPossibleRobots.get(0).getWidth()<radius && disc2t+drawingThread.allPossibleRobots.get(0).getWidth()>radius) {
				animationThread.stopThread();

               incr=incr +2f;
				incr = incr%360;

				endtTime = 0;
				for (int i = 0; i < drawingThread.allRobots.size(); i++) {
					Point point = new Point();
					point = drawingThread.allRobots.get(i).getCenter();
					float bx = (float) point.x;
					float by = (float) point.y;
					double dis = Math.sqrt(((ax - bx) * (ax - bx)) + ((ay - by) * (ay - by)));
					if (dis < (drawingThread.allRobots.get(i).width / 2.0f)) {
						selectedindex = i;
					}

				}


		}
			if(selectedindex!=-1) {
				double disZeroToTouch = Math.sqrt((((center.x+radius)-ax)*((center.x+radius)-ax))+((ay-center.y)*(ay-center.y)));
				double ans = (radius*radius + disc2t*disc2t- disZeroToTouch*disZeroToTouch)/(2.0*radius*disc2t);
				double angl = Math.acos(ans);

				angl = angl *(180f/(float) Math.PI);
				if(ay<center.y)
				{
					angl = 360-angl;
				}
				animationThread.updateAllPositions((int) angl,selectedindex);

			}

			break;
	
			

		default:
			break;
		}


		
		return true;
	}

}
