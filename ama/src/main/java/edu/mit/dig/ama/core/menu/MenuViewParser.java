package edu.mit.dig.ama.core.menu;

import android.app.Activity;
import android.content.Context;
import android.view.View;
import android.view.ViewGroup;

import java.util.LinkedHashMap;
import java.util.Map;

import edu.mit.dig.ama.core.menu.services.DefaultMenuAdapter;
import edu.mit.dig.ama.core.menu.services.navigation.NavigationNavigatorContent;
import io.mattcarroll.hover.NavigatorContent;
import io.mattcarroll.hover.defaulthovermenu.view.ViewHoverMenu;

/**
 * This class takes the parameters from the MenuConfig, and displays the
 * appropriate views within the accessibility menu
 * @author Aaron Vontell
 */
public class MenuViewParser {

    private MenuConfig config;
    private Context context;
    private ViewHoverMenu viewHoverMenu;

    /**
     * Creates the menu view parser which will create an actual hover menu
     * with the options given from the menu configuration file
     * @param context The context that this menu will be displayed in
     * @param config The MenuConfig (either new or loaded from memory) which
     *               will hold and track information form developers and users
     */
    public MenuViewParser(Context context, MenuConfig config) {
        this.config = config;
        this.context = context;
    }

    /**
     * Begins the preparation of the hover menu
     */
    public void prepareMenu() {

        // TODO: How should we do this?
        if(context instanceof Activity) {
            ViewHoverMenu hoverMenu = new ViewHoverMenu(context);
            View content = ((Activity) context).findViewById(android.R.id.content);
            if(content instanceof ViewGroup) {
                //TODO: if not viewgroup, wrap in one?
                ((ViewGroup) content).addView(hoverMenu);
                hoverMenu.setAdapter(buildDefaultMenuAdapter());
                this.viewHoverMenu = hoverMenu;
            }
        }

    }

    /**
     * Returns the default menu adapter, which will be populated and constructed
     * using the options and preferences within the used MenuConfig
     * @return The default menu adapter for this menu
     */
    public DefaultMenuAdapter buildDefaultMenuAdapter() {

        Map<String, NavigatorContent> demoMenu = new LinkedHashMap<>();
        demoMenu.put(config.getNavigationMenuModule().getSitemapTitle(), new NavigationNavigatorContent(context, config.getNavigationMenuModule()));

        return new DefaultMenuAdapter(context, config, demoMenu);
    }

}
