package edu.mit.dig.amaexample;

import android.app.Activity;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import java.util.HashMap;
import java.util.Map;

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

        // Set accessible text change listener
        final EditText accessibleTest = (EditText) findViewById(R.id.accessible_input_edit);
        final TextView accessibleInd = (TextView) findViewById(R.id.accessible_ind_text);

        accessibleTest.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {

                boolean isAccessible = AMA.isStringAccessible(charSequence.toString());
                if(isAccessible) {
                    accessibleInd.setText(getString(R.string.string_is_accessible));
                } else {
                    accessibleInd.setText(getString(R.string.string_not_accessible));
                }

            }

            @Override
            public void afterTextChanged(Editable editable) {

            }
        });

        // Set button classes
        final Button clearButton = (Button) findViewById(R.id.clear_button);
        final Button sendButton = (Button) findViewById(R.id.send_button);
        final Button increaseSpacingButton = (Button) findViewById(R.id.increase_margin_button);
        increaseSpacingButton.setTag(1);
        final Button convertButton = (Button) findViewById(R.id.convert_button);

        AMA.setActionClass(this, clearButton, ActionClass.DANGER);
        AMA.setActionClass(this, sendButton, ActionClass.SUCCESS);
        AMA.setActionClass(this, increaseSpacingButton, ActionClass.PRIMARY);
        AMA.setActionClass(this, convertButton, ActionClass.SUCCESS);

        clearButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                accessibleTest.setText("");
            }
        });

        sendButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                AMA.speak(activity, getString(R.string.accessible_send_text));
            }
        });

        increaseSpacingButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if((Integer) view.getTag() == 1) {
                    increaseSpacingButton.setTag(2);
                    increaseSpacingButton.setText(R.string.button_increse_margin_decrease_text);
                    AMA.increaseSpacing(100, AMA.getAllViews(activity));
                } else {
                    increaseSpacingButton.setTag(1);
                    increaseSpacingButton.setText(R.string.button_increse_margin_text);
                    AMA.increaseSpacing(-100, AMA.getAllViews(activity));
                }
            }
        });


        convertButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Map<String,String> stringHashMap = new HashMap<>();
                stringHashMap.put("hitherto", "before");
                stringHashMap.put("veiling", "surrounding");
                stringHashMap.put("sole", "only");
                stringHashMap.put("mournful", "sad");
                AMA.setSimpleStringAlternatives(activity, stringHashMap);
            }
        });
    }

}