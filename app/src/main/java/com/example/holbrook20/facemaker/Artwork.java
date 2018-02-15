package com.example.holbrook20.facemaker;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.RectF;
import android.support.v4.content.ContextCompat;
import android.util.AttributeSet;
import android.view.SurfaceView;

/**Artwork class to paint to the surface view.
 *
 * Created by Cole Holbrook on 2/09/2018.
 */

public class Artwork extends SurfaceView {
    //For RGB values getting passed in
    private int newRedEye;
    private int newBlueEye;
    private int newGreenEye;

    private int newRedFace;
    private int newBlueFace;
    private int newGreenFace;

    private int newRedHair;
    private int newBlueHair;
    private int newGreenHair;
    //For style getting passed in
    private int style;

    public Artwork(Context context)
    {
        super(context);
        generalInit();
        randomColors();
    }

    public Artwork(Context context, AttributeSet attrs)
    {
        super(context, attrs);
        generalInit();
        randomColors();
    }

    public Artwork(Context context, AttributeSet attrs, int defStyleAttr)
    {
        super(context, attrs, defStyleAttr);
        generalInit();
        randomColors();
    }

    private void generalInit() {
        setWillNotDraw(false);
    }

    /**
     * drawOnDraw()
     *
     * This method draws every part of the face onto the canvas
     * @param canvas
     *      this is a space that is allowing us to draw to the surface view
     */
    @Override
    public void onDraw(Canvas canvas)
    {
        int doubleBun=0;   //Setting the int values from the
        int angelic=1;     //spinner to the names of the
        int classic=2;     //hairstyles

        Paint skinPaint = new Paint();
        skinPaint.setStrokeWidth(5.0f);

        if (style == doubleBun) { drawLeftBun(canvas); }//Draws Left Bun

        if (style == angelic) { drawAngelic(canvas); } //Draws Angelic Style

        drawFace(canvas); //Draws the Face

        if (style == classic) { drawHat(canvas); } //Draws the Top Hat

        if (style == doubleBun) { drawRightBun(canvas); } //Draws the Right Bun

        drawEye(canvas); //Draws the Eyes

        if (style == classic) { drawMonocle(canvas); } //Draws the monocle
    }

    /**
     * drawEye()
     *
     * This method draws the eye
     */
    private void drawEye(Canvas canvas)
    {
        Paint skinPaint = new Paint();
        skinPaint.setStrokeWidth(5.0f);
        skinPaint.setColor(Color.BLACK);
        canvas.drawCircle(790.0f, 600.0f, 20.0f, skinPaint);
        canvas.drawCircle(840.0f, 600.0f, 20.0f, skinPaint);

        //Paints the eye whites
        skinPaint.setColor(Color.WHITE);
        canvas.drawCircle(710.0f, 470.0f, 75.0f, skinPaint);
        canvas.drawCircle(970.0f, 470.0f, 75.0f, skinPaint);

        //Draws the iris
        skinPaint.setColor(Color.rgb(newRedEye, newGreenEye, newBlueEye));
        canvas.drawCircle(720.0f, 470.0f, 40.0f, skinPaint);
        canvas.drawCircle(980.0f, 470.0f, 40.0f, skinPaint);

        //Paints the pupils
        skinPaint.setColor(Color.BLACK);
        canvas.drawCircle(720.0f, 470.f, 20.0f, skinPaint);
        canvas.drawCircle(980.0f, 470.f, 20.0f, skinPaint);

        //Outlines the eyes with a black ring.
        skinPaint.setStyle(Paint.Style.STROKE);
        skinPaint.setColor(Color.BLACK);
        canvas.drawCircle(710.0f, 470.0f, 75.0f, skinPaint);
        canvas.drawCircle(970.0f, 470.0f, 75.0f, skinPaint);
    }

    /**
     * drawAngelic()
     *
     * This method draws the halo and clouds for the Angelic Style
     */
    private void drawAngelic(Canvas canvas)
    {
        Paint skinPaint = new Paint();
        skinPaint.setStrokeWidth(5.0f);
        skinPaint.setColor(Color.rgb(newRedHair, newGreenHair, newBlueHair));
        RectF oval = new RectF(680, 150, 1200, 200);
        RectF oval2 = new RectF(710, 164, 1170, 188);
        canvas.drawOval(oval, skinPaint);
        skinPaint.setColor(Color.BLACK);
        canvas.drawOval(oval2, skinPaint);
        skinPaint.setColor(0xFFFFCF40);
        canvas.drawCircle(950.0f, 550.0f, 340.0f, skinPaint);

        /**
         External Citation
         Date: 12 February 2018
         Problem: Did not know how to draw an oval
         Resource:
         https://stackoverflow.com/questions/5012685/draw-an-oval-shape-around-the-text-on-canvas
         Solution: I followed examples on how to draw an oval.
         */

        skinPaint.setColor(Color.rgb(newRedHair, newGreenHair, newBlueHair));
        canvas.drawCircle(300, 1220, 420, skinPaint); //Outline of the clouds in
        canvas.drawCircle(50, 1100, 370, skinPaint);  //the hair color

        canvas.drawCircle(1800, 1200, 420, skinPaint);
        canvas.drawCircle(1900, 900, 320, skinPaint);

        skinPaint.setColor(Color.WHITE); //Draw Clouds
        canvas.drawCircle(300, 1220, 400, skinPaint);
        canvas.drawCircle(50, 1100, 350, skinPaint);

        canvas.drawCircle(1800, 1200, 400, skinPaint);
        canvas.drawCircle(1900, 900, 300, skinPaint);
    }

    /**
     * drawFace()
     *
     * This method draws the Face
     */
    private void drawFace(Canvas canvas)
    {
        Paint skinPaint = new Paint();
        skinPaint.setStrokeWidth(5.0f);
        skinPaint.setColor(0xFFEAC086);
        skinPaint.setColor(Color.rgb(newRedFace, newGreenFace, newBlueFace));
        canvas.drawCircle(950.0f, 550.0f, 300.0f, skinPaint);
    }

    /**
     * drawhat()
     *
     * This method draws the hat for the Classic style
     */
    private void drawHat(Canvas canvas)
    {
        Paint skinPaint = new Paint();
        skinPaint.setStrokeWidth(5.0f);
        skinPaint.setColor(Color.rgb(newRedHair, newGreenHair, newBlueHair));
        RectF oval3 = new RectF(600, 350, 1300, 300);
        canvas.drawOval(oval3, skinPaint);//Rim of the hat
        canvas.drawRect(730, 50, 1150, 320, skinPaint);
        skinPaint.setColor(Color.WHITE);//Little stripe on the hat
        canvas.drawRect(730, 265, 1150, 300, skinPaint);
    }

    /**
     * drawMonocle()
     *
     * This method draws the monocle for the Classic
     * Hair Style
     */
    private void drawMonocle(Canvas canvas)
    {
        Paint skinPaint = new Paint();
        skinPaint.setStrokeWidth(5.0f);
        skinPaint.setColor(Color.rgb(newRedHair, newGreenHair, newBlueHair));
        canvas.drawCircle(1050.0f, 540.0f, 13.0f, skinPaint);
        canvas.drawCircle(1060.0f, 560.0f, 13.0f, skinPaint);
        canvas.drawCircle(1065.0f, 583.0f, 13.0f, skinPaint);
        canvas.drawCircle(1068.0f, 605.0f, 13.0f, skinPaint);
        canvas.drawCircle(1068.0f, 630.0f, 13.0f, skinPaint);
        canvas.drawCircle(1068.0f, 655.0f, 13.0f, skinPaint);
        skinPaint.setStyle(Paint.Style.STROKE);
        skinPaint.setStrokeWidth(15.0f);
        skinPaint.setColor(Color.rgb(newRedHair, newGreenHair, newBlueHair));
        canvas.drawCircle(970.0f, 470.0f, 95.0f, skinPaint);//Lens of the monocle
    }

    /**
     * drawRightBun()
     *
     * This method draws the right bun for the Hair Style
     * "Double Bun"
     */
    private void drawRightBun(Canvas canvas)
    {
        Paint skinPaint = new Paint();
        skinPaint.setStrokeWidth(5.0f);
        skinPaint.setColor(Color.rgb(newRedHair, newGreenHair, newBlueHair));
        canvas.drawCircle(1150.0f, 330.0f, 150.0f, skinPaint);
        canvas.drawCircle(1190.0f, 500.0f, 40.0f, skinPaint);
        canvas.drawCircle(1220.0f, 560.0f, 40.0f, skinPaint);
        canvas.drawCircle(1265.0f, 605.0f, 40.0f, skinPaint);
    }

    /**
     * drawLeftBun()
     *
     * This method draws the left bun for the Hair Style
     * "Double Bun"
     */
    private void drawLeftBun(Canvas canvas)
    {
        Paint skinPaint = new Paint();
        skinPaint.setStrokeWidth(5.0f);
        skinPaint.setColor(Color.rgb(newRedHair, newGreenHair, newBlueHair));
        canvas.drawCircle(700.0f, 320.0f, 150.0f, skinPaint);
        canvas.drawCircle(630.0f, 480.0f, 40.0f, skinPaint);
        canvas.drawCircle(605.0f, 540.0f, 40.0f, skinPaint);
        canvas.drawCircle(560.0f, 590.0f, 40.0f, skinPaint);
    }

    /**
     * randomColors()
     *
     * This method sets random RGB values for the Eyes,
     * Face, and Hair
     */
    public void randomColors()
    {
        newRedEye=(int) (Math.random()*255+1);
        newGreenEye=(int) (Math.random()*255+1);
        newBlueEye=(int) (Math.random()*255+1);

        newRedFace=(int) (Math.random()*255+1);
        newGreenFace=(int) (Math.random()*255+1);
        newBlueFace=(int) (Math.random()*255+1);

        newRedHair=(int) (Math.random()*255+1);
        newGreenHair=(int) (Math.random()*255+1);
        newBlueHair=(int) (Math.random()*255+1);

        style = ((int) (Math.random()*3));
    }

    //Setters for the RGB values for eye, face, and hair
    public void setMyRedEyeColor(int progress) {
        newRedEye = progress;
    }
    public void setMyBlueEyeColor(int progress) {
        newBlueEye = progress;
    }
    public void setMyGreenEyeColor(int progress) {
        newGreenEye = progress;
    }

    public void setMyRedFaceColor(int progress) {
        newRedFace = progress;
    }
    public void setMyBlueFaceColor(int progress) {
        newBlueFace = progress;
    }
    public void setMyGreenFaceColor(int progress) {
        newGreenFace = progress;
    }

    public void setMyRedHairColor(int progress) {
        newRedHair = progress;
    }
    public void setMyBlueHairColor(int progress) {
        newBlueHair = progress;
    }
    public void setMyGreenHairColor(int progress) {
        newGreenHair = progress;
    }

    //Getters for the RGB values for the eye, face, and hair
    public int getRedEyeValue() {return newRedEye;}
    public int getBlueEyeValue() {return newBlueEye;}
    public int getGreenEyeValue() {return newGreenEye;}

    public int getRedFaceValue() {return newRedFace;}
    public int getBlueFaceValue() {return newBlueFace;}
    public int getGreenFaceValue() {return newGreenFace;}

    public int getRedHairValue() {return newRedHair;}
    public int getBlueHairValue() {return newBlueHair;}
    public int getGreenHairValue() {return newGreenHair;}

    //Passes in the hair style picked
    public void setMyHairStyle(int hairdo) {
        style = hairdo;
    }
    public int getMyHairStyle() {return style;}


}




