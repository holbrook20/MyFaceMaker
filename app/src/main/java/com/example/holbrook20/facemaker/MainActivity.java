package com.example.holbrook20.facemaker;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.SeekBar;
import android.widget.Spinner;

/**Main Activity Class of FaceMaker.
 * This code draws a face to a surface view. The user is
 * able to adjust the RGB values of the eyes, skin, and hair
 * separately. This is done using spinners. The user can
 * also choose from three hair styles using a spinner
 * and use a random face button.
 *
 * Created by Cole Holbrook on 2/09/2018.
 */

public class MainActivity extends AppCompatActivity implements Spinner.OnItemSelectedListener, View.OnClickListener, SeekBar.OnSeekBarChangeListener {


    private Artwork artwork; //New artwork so I can call the setters

    private RadioButton eyes, face, hair; //New radio buttons

    private String[] hairs = {"Double Bun", "Angelic", "Classic"}; //String to fill the spinner

    private SeekBar redSeekBar, blueSeekBar, greenSeekBar; //New seekbars

    private Spinner hairStyle;

    /**
     * onCreate()
     *
     * This method creates new instances of all of the views and
     * listeners. Makes three radio button listener, a random button
     * listener, a spinner listener and three seek bar listeners.
     *
     * @param savedInstanceState
     */
    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //Random Face button listener
        Button randomFaceButton = (Button) findViewById(R.id.button);
        randomFaceButton.setOnClickListener(this);

        artwork = (Artwork) findViewById(R.id.surfaceView); //Create instance of Artwork

        eyes = (RadioButton) findViewById(R.id.eyeRadioButton);       //Radio button listeners
        face = (RadioButton) findViewById(R.id.skinRadioButton);
        hair = (RadioButton) findViewById(R.id.hairRadioButton);
        eyes.setOnClickListener(this);
        face.setOnClickListener(this);
        hair.setOnClickListener(this);

        //Fills the spinner and sets the listener
        ArrayAdapter<String> hairAdapter =
                new ArrayAdapter<String>(this, android.R.layout.simple_spinner_dropdown_item, hairs);
        hairStyle = (Spinner) findViewById(R.id.hairSpinner);
        hairStyle.setAdapter(hairAdapter);
        hairStyle.setOnItemSelectedListener(this);
        hairStyle.setSelection( (int) Math.random()*3);

        /**
         External Citation
         Date: 12 February 2018
         Problem: Did not know how to fill the Spinner with Strings
         Resource:
         https://developer.android.com/guide/topics/ui/controls/spinner.html
         Solution: I followed examples on how to fill the spinner.
         */

        redSeekBar = (SeekBar) findViewById(R.id.redSeekBar);     //Red seekbar listener
        redSeekBar.setOnSeekBarChangeListener(this);

        blueSeekBar = (SeekBar) findViewById(R.id.blueSeekBar);   //Blue seekbar listener
        blueSeekBar.setOnSeekBarChangeListener(this);

        greenSeekBar = (SeekBar) findViewById(R.id.greenSeekBar); //Green seekbar listener
        greenSeekBar.setOnSeekBarChangeListener(this);
    }

    /**
     * onClick()
     *
     * This method is called anytime Random Button or
     * a Radio Button is pressed. The radio Buttons choose
     * a face feature while the random button randomizes
     * everything.
     *
     * @param v
     *      v is the view being passed in, the random button or
     *      one of the radio buttons.
     */
    @Override
    public void onClick(View v)
    {
        if(v.getId() == R.id.button) { randomButtonPressed(); }//Calls Random Button if pressed

        if(v.getId() == R.id.eyeRadioButton)//Checks to see if the eye radio button is clicked
        {
            //Unclicks the other two radio buttons
            hair.setChecked(false);
            face.setChecked(false);

            updateSelectedRadio();

            /**
             External Citation
             Date: 12 February 2018
             Problem: Did not know how to make the surface view update
             Resource:
             https://stackoverflow.com/questions/18607335/how-to-update-a-surfaceview
             Solution: I followed example online to update my surface view
             */
        }

        if(v.getId() == R.id.hairRadioButton)//Checks to see if the hair radio button is clicked
        {
            //Unclicks the other two radio buttons
            eyes.setChecked(false);
            face.setChecked(false);

            updateSelectedRadio();

        }

        if(v.getId() == R.id.skinRadioButton)//Checks to see if the face radio button is clicked
        {
            //Unclicks the other two radio buttons
            hair.setChecked(false);
            eyes.setChecked(false);
            updateSelectedRadio();

        }
        /**
         External Citation
         Date: 12 February 2018
         Problem: Did not know how to use Radio Buttons
         Resource:
         https://developer.android.com/guide/topics/ui/controls/radiobutton.html
         Solution: I followed example on Radio Buttons to set up what happens
         when clickes.
         */
        artwork.invalidate();
    }

    /**
     * onProgressChanged()
     *
     * This method is used to update the RGB values based on the
     * progress of seekbars.
     *
     * @param seekBar
     *      This is the seekbar item passed into the method that the progress
     *      value is received from.
     * @param progress
     *      This is an integer value for where the thumb is on the seekbar. This
     *      value is passed into artwork to update the RGB values of the
     *      drawings
     */
    @Override
    public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser)
      {


        //Checks to see which radio button is pressed
        if (eyes.isChecked())
        {
            updateEyeColorProgress(seekBar, progress);

        } else if (face.isChecked())
        {
            updateSkinColorProgress(seekBar, progress);

        } else if (hair.isChecked())
        {
            updateHairColorProgress(seekBar, progress);
        }

        artwork.invalidate();
      }


    /**
     * updateSelectedRadio()
     *
     * This method is used to updates the RGB values for the progress
     * bars depending on which radio button is pressed.
     */
     private void updateSelectedRadio()
     {
         if(eyes.isChecked() )
         {
             redSeekBar.setProgress(artwork.getRedEyeValue());
             blueSeekBar.setProgress(artwork.getBlueEyeValue());
             greenSeekBar.setProgress(artwork.getGreenEyeValue());
         }
         if(face.isChecked() )
         {
             redSeekBar.setProgress(artwork.getRedFaceValue());
             blueSeekBar.setProgress(artwork.getBlueFaceValue());
             greenSeekBar.setProgress(artwork.getGreenFaceValue());
         }
         if(hair.isChecked() )
         {
             redSeekBar.setProgress(artwork.getRedHairValue());
             blueSeekBar.setProgress(artwork.getBlueHairValue());
             greenSeekBar.setProgress(artwork.getGreenHairValue());
         }
     }

    @Override
    public void onStartTrackingTouch(SeekBar seekBar) { /*This should be empty*/ }

    @Override
    public void onStopTrackingTouch(SeekBar seekBar) { /*This should be empty*/ }

    /**
     * onItemSelected()
     *
     * This method sets the hair style that is selected in the
     * spinner by passing it into artwork through setMyHairStyle
     */
    @Override
    public void onItemSelected(AdapterView<?> parent, View view, int position, long id)
    {
            //Gets the position of the spinner and passes it in as an integer to Artwork
            artwork.setMyHairStyle(position);
            artwork.invalidate();
    }

    @Override
    public void onNothingSelected(AdapterView<?> parent) { /*This should be empty */ }

    /**
     * randomButtonPressed()
     *
     * This method randomizes all of the colors and the hairstyle when the
     * "Random Button" is pressed and then reset the progress bar of the
     * currently clicked radio button
     *
     */
    public void randomButtonPressed()
    {
        artwork.randomColors();//make random colors

        hairStyle.setSelection(artwork.getMyHairStyle());//Set the hair style

        updateSelectedRadio();//Resets the seekbars for whichever radio button is clicked

        artwork.invalidate();//Redraw the artwork
    }

    /**
     * updateSkinColorProgress()
     *
     * This method updates the RGB values for the
     * location of the seekbars only if the skin radio button is checked.
     *
     * @param seekBar
     * @param progress
     */
    private void updateSkinColorProgress( SeekBar seekBar, int progress)
    {
        if(seekBar.getId() == R.id.redSeekBar)
        {
            artwork.setMyRedFaceColor(progress);
        }
        else if ( seekBar.getId() == R.id.greenSeekBar)
        {
            artwork.setMyGreenFaceColor(progress);

        }
        else if (seekBar.getId() == R.id.blueSeekBar)
        {
            artwork.setMyBlueFaceColor(progress);
        }
    }

    /**
     * updateEyeColorProgress()
     *
     * This method updates the RGB values for the
     * location of the seekbars only if the skin radio button is checked.
     *
     * @param seekBar
     * @param progress
     */
    private void updateEyeColorProgress( SeekBar seekBar, int progress)
    {
        if(seekBar.getId() == R.id.redSeekBar)
        {
            artwork.setMyRedEyeColor(progress);
        }
        else if ( seekBar.getId() == R.id.greenSeekBar)
        {
            artwork.setMyGreenEyeColor(progress);

        }
        else if (seekBar.getId() == R.id.blueSeekBar)
        {
            artwork.setMyBlueEyeColor(progress);
        }
    }

    /**
     * updateHairColorProgress()
     *
     * This method updates the RGB values for the
     * location of the seekbars only if the skin radio button is checked.
     *
     * @param seekBar
     * @param progress
     */
    private void updateHairColorProgress( SeekBar seekBar, int progress)
    {
        if(seekBar.getId() == R.id.redSeekBar)
        {
            artwork.setMyRedHairColor(progress);
        }
        else if ( seekBar.getId() == R.id.greenSeekBar)
        {
            artwork.setMyGreenHairColor(progress);
        }
        else if (seekBar.getId() == R.id.blueSeekBar)
        {
            artwork.setMyBlueHairColor(progress);
        }
    }
}
/**
 External Citation
 Date: 12 February 2018
 Problem: I was having issues with my listeners and how to pass information.
 Resource:
 Tutor named Matthew through the Resource Center
 Solution: I put my listener methods inside of the Main Activity
 */



