package edu.mit.dig.amaexample;

import android.app.Activity;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.List;

import edu.mit.dig.ama.core.AMA;
import edu.mit.dig.ama.core.AccessibleAppCompatActivity;
import edu.mit.dig.ama.core.ActionClass;

/**
 * Main activity for the demo app of Accessiblity for Mobile Applications
 *
 * Features of this app:
 *      - Provides ActionClass button types (DONE)
 *      - Custom TalkBack speaking (DONE)
 *      - Check if a string is Accessible (DONE)
 *      - Speak back when orientation changed (DONE)
 *
 * @author Aaron Vontell
 * @author William Caruso
 * @author Byungkyu Park
 * @version 12.3.2016
 */
public class MainActivity extends AccessibleAppCompatActivity {

    private final Activity activity = this;
    private TextView title;
    private TextView paragraph;
    private ImageView image;
    private Button grayBtn;
    private Button simpleBtn;

    private boolean isGrayScale = false;
    private boolean isSimple = false;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Enable the custom orientation changed listener
        enableOrientationChangedListener(true);

    }

    @Override
    protected void onResume() {

        super.onResume();

        // Grab each element of our activity
        title = (TextView) findViewById(R.id.title);
        paragraph = (TextView) findViewById(R.id.paragraph);
        image = (ImageView) findViewById(R.id.article_image);
        simpleBtn = (Button) findViewById(R.id.simple_btn);
        grayBtn = (Button) findViewById(R.id.grayscale_btn);

        // Set the listeners for each button
        simpleBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                makeActivitySimple();
            }
        });
        grayBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                makeActivityGrayscale();
            }
        });



        AMA.setViewsToGraycasle(this);
    }

    /**
     * Makes the activity grayscale (text, background, and images)
     */
    private void makeActivityGrayscale() {

        if(!isGrayScale) {

            grayBtn.setText(getString(R.string.grayscale_btn_on));
            isGrayScale = true;

        } else {

            grayBtn.setText(getString(R.string.grayscale_btn_off));
            isGrayScale = false;

        }

    }

    /**
     * Replaces all strings with simpler versions
     */
    private void makeActivitySimple() {

        if(!isSimple) {

            simpleBtn.setText(getString(R.string.simple_btn_on));
            isSimple = true;

        } else {

            simpleBtn.setText(getString(R.string.simple_btn_off));
            isSimple = false;

        }

    }

}