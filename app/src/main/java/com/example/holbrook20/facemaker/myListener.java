package com.example.holbrook20.facemaker;

import android.view.View;
import android.widget.SeekBar;

/**
 * Created by holbrook20 on 2/11/2018.
 */

public class myListener implements View.OnClickListener, SeekBar.OnSeekBarChangeListener {

    @Override
    public void onClick(View v) {
    System.out.println("click");
    }

    @Override
    public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
    //Every time the progress changes, we want the corresponding color value to change.
    //We should return the new progress value.
    System.out.println(progress);

    }

    @Override
    public void onStartTrackingTouch(SeekBar seekBar) {

    }

    @Override
    public void onStopTrackingTouch(SeekBar seekBar) {

    }
}
