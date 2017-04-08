package edu.mit.dig.ama.core.menu;

import android.content.Context;
import android.support.annotation.NonNull;
import android.view.View;

import edu.mit.dig.ama.core.menu.services.DefaultMenuAdapter;
import io.mattcarroll.hover.HoverMenu;
import io.mattcarroll.hover.Navigator;
import io.mattcarroll.hover.NavigatorContent;
import io.mattcarroll.hover.defaulthovermenu.HoverMenuBuilder;

/**
 * This class takes the parameters from the MenuConfig, and displays the
 * appropriate views within the accessibility menu
 * @author Aaron Vontell
 */
public class MenuViewParser {

    private MenuConfig config;
    private Context context;
    private HoverMenu hoverMenu;

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

        // Build an adapter for the views
        DefaultMenuAdapter adapter = buildDefaultMenuAdapter();
        Navigator navigator = getMenuNavigator();

        // Build a HoverMenu.
        this.hoverMenu = new HoverMenuBuilder(context)
                .displayWithinWindow()
                .useNavigator(navigator)
                .useAdapter(adapter)
                .build();

        //hoverMenu.show();
        //hoverMenu.expandMenu();

    }

    public Navigator getMenuNavigator() {
        return new Navigator() {
            @Override
            public void pushContent(@NonNull NavigatorContent content) {

            }

            @Override
            public boolean popContent() {
                return false;
            }

            @Override
            public void clearContent() {

            }

            @NonNull
            @Override
            public View getView() {
                return null;
            }
        };
    }

    /**
     * Returns the default menu adapter, which will be populated and constructed
     * using the options and preferences within the used MenuConfig
     * @return The default menu adapter for this menu
     */
    public DefaultMenuAdapter buildDefaultMenuAdapter() {
        return new DefaultMenuAdapter(context, config);
    }

}
