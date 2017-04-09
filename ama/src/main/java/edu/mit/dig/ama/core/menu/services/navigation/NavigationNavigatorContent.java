package edu.mit.dig.ama.core.menu.services.navigation;

import android.app.Activity;
import android.content.Context;
import android.support.annotation.NonNull;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;

import edu.mit.dig.ama.R;
import io.mattcarroll.hover.Navigator;
import io.mattcarroll.hover.NavigatorContent;

/**
 * The accessibility menu module for navigating through the app in an accessible
 * way. Satisfies the following list of WCAG 2.0 requirements:
 *      - 2.4.5
 * @author Aaron Vontell
 */
public class NavigationNavigatorContent extends LinearLayout implements NavigatorContent {

    private NavigationMenuModule menuModule;

    public NavigationNavigatorContent(@NonNull Context context, NavigationMenuModule menuModule) {
        super(context);
        LayoutInflater.from(getContext())
                .inflate(R.layout.navigation_menu_module, this, true);
        this.menuModule = menuModule;

        Log.d("MENU", "Creating navigation content");

    }

    public void loadSitemap() {

        ((TextView) this.findViewById(R.id.navigation_title)).setText(this.menuModule.getSitemapTitle());

        for(final IntentEntry entry : menuModule.getIntentEntries()) {

            Log.d("MENU", "Adding sitemap button for " + entry.getTitle());
            Button button = new Button(this.getContext());
            button.setText(entry.getTitle());
            button.setOnClickListener(new OnClickListener() {
                @Override
                public void onClick(View view) {
                    getContext().startActivity(entry.getIntent());
                    ((Activity) getContext()).finish();
                }
            });
            ((LinearLayout) this.getChildAt(0)).addView(button);

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
        loadSitemap();
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
