package edu.mit.dig.ama.core.menu.services;

import android.content.Context;
import android.support.annotation.NonNull;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

import java.util.HashMap;
import java.util.Map;

import edu.mit.dig.ama.R;
import edu.mit.dig.ama.core.menu.MenuConfig;
import edu.mit.dig.ama.core.menu.services.navigation.NavigationNavigatorContent;
import io.mattcarroll.hover.HoverMenuAdapter;
import io.mattcarroll.hover.NavigatorContent;

/**
 * The default adapter for the AMA accessible hover menu
 * @author Aaron Vontell
 * @author William Caruso
 * @author Byungkyu Park
 * @author Metin Say
 * @version 4.7.2017
 */
public class DefaultMenuAdapter implements HoverMenuAdapter {

    private final Context context;
    private MenuConfig config;
    private final Map<String, NavigatorContent> content;

    public DefaultMenuAdapter(@NonNull Context context, MenuConfig config, Map<String, NavigatorContent> content) {

        this.context = context;
        this.config = config;
        this.content = content;

    }

    /**
     * Returns the number of tabs that a {@code HoverMenu} should display.
     *
     * @return number of tabs
     */
    @Override
    public int getTabCount() {
        return content.size();
    }

    /**
     * Returns the unique ID for the tab that is currently at the given {@code position}. The ID
     * should be unique per tab, not per position.  If the same tab moves around in the tab list,
     * it should still return the same ID.
     *
     * @param position
     * @return ID of tab at given position
     */
    @Override
    public long getTabId(int position) {
        return position;
    }

    /**
     * Returns the visual representation of the {@code index}'th tab.
     *
     * @param position index of tab
     * @return visual representation of the {@code index}'th tab
     */
    @Override
    public View getTabView(int position) {

        ImageView icon =  new ImageView(context); // TODO: lol ;)

        switch (position) {
            case 0:
                icon.setImageDrawable(context.getResources().getDrawable(R.drawable.icon_accessibility));
                break;
            case 1:
                icon.setImageDrawable(context.getResources().getDrawable(R.drawable.icon_navigation));
                break;
        }

        return icon;

    }

    /**
     * Returns the {@link NavigatorContent} to display for the tab at the given {@code position}.
     *
     * @param position position of tab to activate
     */
    @Override
    public NavigatorContent getNavigatorContent(int position) {

        switch (position) {
            case 0:
                return content.get(config.getNavigationMenuModule().getTitle());
            default:
                return content.get(config.getLanguageMenuModule().getTitle());
        }

         // TODO: DON'T DO THIS
    }

    @Override
    public void addContentChangeListener(@NonNull ContentChangeListener listener) {

    }

    @Override
    public void removeContentChangeListener(@NonNull ContentChangeListener listener) {

    }
}
