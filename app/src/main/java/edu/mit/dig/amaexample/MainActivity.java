package edu.mit.dig.amaexample;

import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.widget.EditText;
import android.widget.TextView;

import edu.mit.dig.ama.core.AccessibleAppCompatActivity;
import edu.mit.dig.ama.features.Voice;

/**
 * Main activity for the demo app of Accessiblity for Mobile Applications
 *
 * Features of this app:
 *      - Provides ActionClass button types
 *      - Custom TalkBack speaking
 *      - Check if a string is Accessible
 *      - Speak back when orientation changed
 *
 * @author Aaron Vontell
 * @author William Caruso
 * @author Byungkyu Park
 * @version 12.3.2016
 */
public class MainActivity extends AccessibleAppCompatActivity {

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

        final EditText accessibleTest = (EditText) findViewById(R.id.accessible_input_edit);
        final TextView accessibleInd = (TextView) findViewById(R.id.accessible_ind_text);

        accessibleTest.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {

                boolean isAccessible = Voice.isStringAccessible(charSequence.toString());
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

    }

}
