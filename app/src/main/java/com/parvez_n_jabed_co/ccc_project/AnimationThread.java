package com.parvez_n_jabed_co.ccc_project;

import android.graphics.Point;

public class AnimationThread extends Thread {

	float angl=0f;
	private boolean flag=false;
	float gravityX,gravityY;
	float timeConstant=0.3f;
	float retardationRatio=-0.7f;
	int width,height;
	int left,right,top,bottom;

	DrawingThread drawingThread;


	public AnimationThread(DrawingThread drawingThread) {
		super();
		this.drawingThread = drawingThread;
		updateDimensions();
	}

	private void updateDimensions() {
		width=drawingThread.allPossibleRobots.get(0).getWidth();
		height=drawingThread.allPossibleRobots.get(0).getHeight();

		left=width/2;
		top=height/2;
		right=drawingThread.displayX-(width/2);
		bottom=drawingThread.displayY-(height/2);
	}

	@Override
	public void run() {
		angl=0;
		flag=true;
		while (flag) {
			angl+=0.5;
			angl = angl%360;
			updateAllPositions((int)angl,0);

			try {
				sleep(20);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}


		}
	}

	public void updateAllPositions(int angll,int index) {


		for (int i = 0; i < drawingThread.allRobots.size(); i++) {

			index = index%12;
			updateRobotsPosition(drawingThread.allRobots.get(index),angll,i);
			index++;
		}


	}

	private void updateRobotsPosition(Robot robot,int angll,int ind) {
		/*robot.centerX+=(robot.velocityX*timeConstant+0.5*gravityX*timeConstant*timeConstant);
		robot.velocityX+=gravityX*timeConstant;

		robot.centerY+=(robot.velocityY*timeConstant+0.5*gravityY*timeConstant*timeConstant);
		robot.velocityY+=gravityY*timeConstant;
		*/

		float ang = 360f/12f;
		Point pointn = drawingThread.GetPosition(drawingThread.getScreenCenter(),(angll+(ang*ind))%360,drawingThread.centerIcon.getWidth()/2-drawingThread.allPossibleRobots.get(0).getWidth()/2);
		robot.setCenter(pointn);


	}



	public void stopThread() {
		flag=false;
	}

}
