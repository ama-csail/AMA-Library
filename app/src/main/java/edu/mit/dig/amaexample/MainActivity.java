package edu.mit.dig.amaexample;

import android.content.Context;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import edu.mit.dig.ama.core.AMA;
import edu.mit.dig.ama.core.AccessibleAppCompatActivity;
import edu.mit.dig.ama.core.menu.MenuViewParser;

/**
 * Main activity for the demo app of Accessiblity for Mobile Applications
 *
 * Features of this app:
 *      - Grayscale filtering
 *      - Increased spacing for visual clarity
 *      - Complex string replacement for congitive ease
 *
 * @author Aaron Vontell
 * @author William Caruso
 * @author Byungkyu Park
 * @author Metin Say
 * @version 12.3.2016
 */
public class MainActivity extends AccessibleAppCompatActivity {

    private Context context;

    private TextView title;
    private TextView paragraph;
    private ImageView image;
    private Button grayBtn;
    private Button simpleBtn;
    private Button incSpaceBtn;
    private Button decSpaceBtn;
    private Map<String, String> simpleMappings;
    private List<View> spacingViews;

    private boolean isGrayScale = false;
    private boolean isSimple = false;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Enable the custom orientation changed listener
        enableOrientationChangedListener(true);

        simpleMappings = new HashMap<>();
        simpleMappings.put("complex", "simple");
        simpleMappings.put("UI", "user interface");
        simpleMappings.put("quite", "very");

        this.context = this;

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
        incSpaceBtn = (Button) findViewById(R.id.inc_space_btn);
        decSpaceBtn = (Button) findViewById(R.id.dec_space_btn);

        spacingViews = new ArrayList<>();
        spacingViews.add(title);
        spacingViews.add(image);
        spacingViews.add(paragraph);
        spacingViews.add(grayBtn);
        spacingViews.add(simpleBtn);

        // Set the listeners for each button
        simpleBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //makeActivitySimple();
                checkDrawOverlayPermission();
                MenuViewParser viewParser = new MenuViewParser(context, null);
                viewParser.prepareMenu();
            }
        });
        grayBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                makeActivityGrayscale();
            }
        });
        incSpaceBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                AMA.increaseSpacing(10, spacingViews);
            }
        });
        decSpaceBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                AMA.increaseSpacing(-10, spacingViews);
            }
        });

    }

    /**
     * Makes the activity grayscale (text, background, and images)
     */
    private void makeActivityGrayscale() {

        if(!isGrayScale) {

            grayBtn.setText(getString(R.string.grayscale_btn_off));
            isGrayScale = true;
            AMA.setViewsToGrayscale(this);

        } else {

            grayBtn.setText(getString(R.string.grayscale_btn_on));
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
            AMA.setSimpleStringAlternatives(this, simpleMappings);

        } else {

            simpleBtn.setText(getString(R.string.simple_btn_off));
            isSimple = false;
            AMA.restoreSimpleStringAlternatives(this);

        }

    }

}