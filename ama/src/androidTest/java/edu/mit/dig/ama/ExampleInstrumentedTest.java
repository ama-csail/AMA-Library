package edu.mit.dig.ama;

import android.app.Activity;
import android.content.Context;
import android.support.test.InstrumentationRegistry;
import android.support.test.runner.AndroidJUnit4;
import android.util.DisplayMetrics;
import android.view.View;
import android.widget.TextView;

import org.junit.Test;
import org.junit.runner.RunWith;

import edu.mit.dig.ama.core.AMA;
import edu.mit.dig.ama.core.ActionClass;

import static org.junit.Assert.*;

/**
 * Instrumentation test, which will execute on an Android device.
 *
 * @see <a href="http://d.android.com/tools/testing">Testing documentation</a>
 */
@RunWith(AndroidJUnit4.class)
public class ExampleInstrumentedTest {
    private Context appContext = InstrumentationRegistry.getTargetContext();

    @Test
    public void useAppContext() throws Exception {
        assertEquals("edu.mit.dig.ama.test", appContext.getPackageName());
    }

    @Test
    public void testSetGetHelpMessageTrue() {
        View view = new View(appContext);
        AMA.setHelpMessage(view, "this is top view");

        assertEquals("this is top view", AMA.getHelpMessage(view));
    }

    @Test
    public void testSetGetHelpMessageFalse() {
        View view = new View(appContext);
        AMA.setHelpMessage(view, "this is top view");
        assertEquals("this is top view", AMA.getHelpMessage(view));

        AMA.setHelpMessage(view, "this is not a top view");
        assertNotEquals("this is top view", AMA.getHelpMessage(view));
    }

    @Test
    public void testGetActionClassDefault() {
        View view = new View(appContext);

        assertEquals(ActionClass.DEFAULT, AMA.getActionClass(view));
    }

    @Test
    public void testSetFont() {
        TextView textView = new TextView(appContext);

        View[] views = new View[]{textView};
        AMA.setFont((float) 10.0, views);

        DisplayMetrics metrics = appContext.getResources().getDisplayMetrics();
        float actualTextSize = textView.getTextSize()/metrics.density;
        assertTrue(actualTextSize == 10.0);
    }


}
