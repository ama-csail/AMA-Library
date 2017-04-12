package edu.mit.dig.ama.core.menu.services.language;

import android.app.Activity;
import android.content.Context;
import android.support.annotation.NonNull;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.LinearLayout;
import android.widget.TextView;

import edu.mit.dig.ama.R;
import edu.mit.dig.ama.core.AMA;
import io.mattcarroll.hover.Navigator;
import io.mattcarroll.hover.NavigatorContent;

/**
 * The accessibility menu module for displaying instructions and options
 * related to language. Satisfies the following list of WCAG 2.0 requirements:
 *      - 3.1.5
 * @author Aaron Vontell
 */
public class LanguageNavigatorContent extends LinearLayout implements NavigatorContent {

    private LanguageMenuModule menuModule;

    public LanguageNavigatorContent(@NonNull Context context, LanguageMenuModule menuModule) {
        super(context);
        LayoutInflater.from(getContext())
                .inflate(R.layout.language_menu_module, this, true);
        this.menuModule = menuModule;

        Log.d("MENU", "Creating language content");
        prepareSimpleStringToggle();
        showGlossary();

    }

    /**
     * Causes the checkbox within the language module to toggle simple strings
     * within the application, given by the mapping of complex strings to simple
     * strings
     */
    private void prepareSimpleStringToggle() {

        CheckBox simpleBox = (CheckBox) this.findViewById(R.id.simple_checkbox);

        simpleBox.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton compoundButton, boolean b) {

                if(b) {
                    // TODO: Make sure context is activity
                    Log.d("SIMPLE","" + menuModule.getSimpleAlts().size());
                    AMA.setSimpleStringAlternatives((Activity) getContext(), menuModule.getSimpleAlts());
                } else {
                    AMA.restoreSimpleStringAlternatives((Activity) getContext());
                }

            }
        });

    }

    /**
     * Iterates through the list of terms given by the developer, and displays
     * the term and its definition within the glossary
     */
    private void showGlossary() {

        for(String word : menuModule.getDefinitions().keySet()) {

            TextView text = new TextView(getContext());
            text.setText("\n" + word + " - " + menuModule.getDefinitions().get(word));
            ((LinearLayout) this.getChildAt(0)).addView(text);

        }

    }

    /**
     * Returns the visual display of this content.
     *
     * @return the visual representation of this content
     */
    @NonNull
    @Override
    public View getView() {
        return this;
    }

    /**
     * Called when this content is displayed to the user.
     *
     * @param navigator the {@link Navigator} that is displaying this content.
     */
    @Override
    public void onShown(@NonNull Navigator navigator) {
        Log.d("MENU", "Showing sitemap");
    }

    /**
     * Called when this content is no longer displayed to the user.
     * <p>
     * Implementation Note: a {@code NavigatorContent} can be brought back due to user navigation so
     * this call must not release resources that are required to show this content again.
     */
    @Override
    public void onHidden() {

    }

}
