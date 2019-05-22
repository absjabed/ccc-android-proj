package com.parvez_n_jabed_co.ccc_project;

import android.graphics.Point;

/**
 * Created by PARVEZ on 30-Jul-17.
 */

public class AnimationMoveTouch extends  Thread {
    float angl=0f;
    float speed;
    private boolean flag=false;
    float gravityX,gravityY;
    float timeConstant=0.3f;
    float retardationRatio=-0.7f;
    int indx = 0;
    int width,height;
    int left,right,top,bottom;

    DrawingThread drawingThread;


    public AnimationMoveTouch(DrawingThread drawingThread,float speed,float angl,int indx) {
        super();
        this.angl = angl;
        this.indx = indx;
        this.speed = speed;
        this.drawingThread = drawingThread;
        updateDimensions();
    }
public void   setspeed(float speed){
    this.speed = speed;
}

    public void   setangl(float angl){
        this.angl = angl;
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

        flag=true;
        while (flag) {
            angl+=speed;
            speed-=0.05f;
            if(speed<=0)
            {
                flag = false;
            }
            angl = angl%360;
            updateAllPositions((int)angl,indx);

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
