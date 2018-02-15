package com.example.holbrook20.facemaker;

import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;



/**
 * Created by holbrook20 on 2/12/2018.
 */

public class Eye {

    int redInt;
    int blueInt;
    int greenInt;

    int newRed;
    int newBlue;
    int newGreen;

    //Constructor for an Eye object
    public Eye(int oldRed, int oldBlue, int oldGreen) {
        redInt = oldRed;
        blueInt = oldBlue;
        greenInt = oldGreen;
    }

    //Class to draw the colored eyes
    public void draw(Canvas canvas) {

        Paint skinPaint = new Paint();
        skinPaint.setColor(Color.rgb(redInt, greenInt, blueInt));
        //skinPaint.setColor(redInt + blueInt + greenInt);
        canvas.drawCircle(620.0f, 270.0f, 40.0f, skinPaint);
        canvas.drawCircle(880.0f, 270.0f, 40.0f, skinPaint);


    }
    //Changes red value if the seekbar progress changes
     //public void setMyRedColor(int progress) {
    //    redInt = newRed;
  //  }
    //Changes red value if the seekbar changes
   // public void setMyBlueColor(int progress) {
    //    blueInt = newBlue;
   // }
    //Changes red value if the seekbar changes
   // public void setMyGreenColor(int progress) {
   //     greenInt = newGreen;
   // }
}





