package com.parvez_n_jabed_co.ccc_project;

import java.util.Random;

import android.content.Context;
import android.graphics.PixelFormat;
import android.graphics.Point;
import android.provider.ContactsContract;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.SurfaceHolder;
import android.view.SurfaceHolder.Callback;
import android.view.SurfaceView;
import android.view.VelocityTracker;
import android.widget.Toast;

public class GameView extends SurfaceView implements Callback{
	Context context;
	SurfaceHolder surfaceHolder;
	DrawingThread drawingThread;
	GameActivity gameActivity;
	VelocityTracker velocityTracker;
	int selectedindex = -1;
	int selectedicon = -1;
	boolean moved = false;
	Point movedownpos = null;
     float incr = 0f;
	double angl = 0;
	float speed = 0.0f;
	AnimationThread animationThread;
	AnimationMoveTouch animationMoveTouch;
    int flag = 0;
	public GameView(Context context, GameActivity gameActivity1) {
		super(context);
		this.context=context;
		this.gameActivity = gameActivity1;
		surfaceHolder=getHolder();
		surfaceHolder.addCallback(this);
		velocityTracker=VelocityTracker.obtain();
		drawingThread=new DrawingThread( this, context);
		animationMoveTouch = new AnimationMoveTouch(drawingThread,0f,0f,0);
		 animationThread=new AnimationThread(drawingThread);


	}

	public GameView(Context context, AttributeSet attrs, int defStyle) {
		super(context, attrs, defStyle);

		this.context=context;
		surfaceHolder=getHolder();
		surfaceHolder.setFormat(PixelFormat.RGBA_8888);
		surfaceHolder.addCallback(this);
		velocityTracker=VelocityTracker.obtain();
		drawingThread=new DrawingThread( this, context);
		animationMoveTouch = new AnimationMoveTouch(drawingThread,0f,0f,0);
		animationThread=new AnimationThread(drawingThread);
	}




	public GameView(Context context, AttributeSet attrs) {
		super(context, attrs);
		this.context=context;

		surfaceHolder=getHolder();
		surfaceHolder.setFormat(PixelFormat.RGBA_8888);
		surfaceHolder.addCallback(this);
		velocityTracker=VelocityTracker.obtain();
		drawingThread=new DrawingThread( this, context);
		animationMoveTouch = new AnimationMoveTouch(drawingThread,0f,0f,0);
		animationThread=new AnimationThread(drawingThread);
	}

	public void setActivity(GameActivity gameActivity)
	{
		this.gameActivity = gameActivity;
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
		//Random random=new Random();

		switch (event.getAction()) {
		case MotionEvent.ACTION_DOWN:
//			 startTime = event.getEventTime();
			moved = false;

			animationMoveTouch.stopThread();
			movedownpos = touchPoint;

				break;
		case MotionEvent.ACTION_UP:

			//long timm = event.getEventTime()-event.getDownTime();
			if(!moved) {


				animationThread.stopThread();
				float ax = (float) touchPoint.x;
				float ay = (float) touchPoint.y;
				Point center = new Point();
				center = drawingThread.getScreenCenter();
				double disc2t = Math.sqrt(((ax - center.x) * (ax - center.x)) + ((ay - center.y) * (ay - center.y)));
				float radius = drawingThread.centerIcon.getWidth()/2 - drawingThread.allPossibleRobots.get(0).getWidth() / 2;
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
			else {
				if(selectedindex!=-1) {
					double vx, vy, mainv;
					velocityTracker.computeCurrentVelocity(5);
					vx = velocityTracker.getXVelocity();
					vy = velocityTracker.getYVelocity();
				//	Toast.makeText(context,"x: "+vx+" , y: "+vy,Toast.LENGTH_SHORT).show();
					mainv = Math.sqrt(vx * vx + vy * vy);
					if (mainv > 0f) {
						//	animationMoveTouch.updateAllPositions((int) angl, selectedindex);
						animationMoveTouch = null;
						animationMoveTouch = new AnimationMoveTouch(drawingThread, (float) mainv, (float) angl, selectedindex);
						//		animationMoveTouch.setspeed(10f);
						animationMoveTouch.start();
					}
				}


			}
			selectedindex = -1;
			selectedicon =  -1;
//			  endtTime = event.getEventTime();
			break;
		case MotionEvent.ACTION_MOVE:
			float ax = (float)touchPoint.x;
			float ay = (float)touchPoint.y;
			velocityTracker.addMovement(event);

			double movedist = Math.sqrt(((ax-movedownpos.x)*(ax-movedownpos.x))+((ay-movedownpos.y)*(ay-movedownpos.y)));
			if(movedist>drawingThread.allPossibleRobots.get(0).getWidth()/5&&!moved) {
				moved = true;
			}
			if(moved) {
				Point center = new Point();
				center = drawingThread.getScreenCenter();
				double disc2t = Math.sqrt(((ax - center.x) * (ax - center.x)) + ((ay - center.y) * (ay - center.y)));
				double radius = drawingThread.centerIcon.getWidth() / 2 - drawingThread.allPossibleRobots.get(0).getWidth() / 2;
				if (selectedindex == -1 && disc2t - drawingThread.allPossibleRobots.get(0).getWidth() < radius && disc2t + drawingThread.allPossibleRobots.get(0).getWidth() > radius) {
					animationThread.stopThread();

					incr = incr + 2f;
					incr = incr % 360;

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
				if (selectedindex != -1) {
					double disZeroToTouch = Math.sqrt((((center.x + radius) - ax) * ((center.x + radius) - ax)) + ((ay - center.y) * (ay - center.y)));
					double ans = (radius * radius + disc2t * disc2t - disZeroToTouch * disZeroToTouch) / (2.0 * radius * disc2t);
					 angl = Math.acos(ans);

					angl = angl * (180f / (float) Math.PI);
					if (ay < center.y) {
						angl = 360 - angl;
					}
					animationThread.updateAllPositions((int) angl, selectedindex);

				}
			}

			break;
	
			

		default:
			break;
		}


		
		return true;
	}

}
