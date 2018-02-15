package com.example.holbrook20.facemaker;

import android.graphics.Canvas;
import android.graphics.Paint;

/**
 * Created by holbrook20 on 2/12/2018.
 */

public class Hair {

    int redInt;
    int blueInt;
    int greenInt;

    int newRed;
    int newBlue;
    int newGreen;

    public Hair(int oldRed, int oldBlue, int oldGreen) {
        redInt = oldRed;
        blueInt = oldBlue;
        greenInt = oldGreen;
    }

    public void draw(Canvas canvas) {

        Paint skinPaint = new Paint();
        skinPaint.setColor(redInt + blueInt + greenInt);
        canvas.drawCircle(20.0f, 30.5f, 20.0f, skinPaint);


    }

    public void setMyRedColor(int progress) {
        redInt = newRed;
    }

    public void setMyBlueColor(int progress) {
        blueInt = newBlue;
    }

    public void setMyGreenColor(int progress) {
        greenInt = newGreen;
    }
}
