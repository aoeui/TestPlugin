package edu.umd.isr.testplugin;

import javax.swing.JOptionPane;

import com.nomagic.actions.ActionsCategory;
import com.nomagic.magicdraw.actions.ActionsConfiguratorsManager;
// import com.nomagic.magicdraw.core.Application;
import com.nomagic.magicdraw.plugins.Plugin;

public class SimplePlugin extends Plugin {
	@Override
  public boolean close() {
	JOptionPane.showMessageDialog( null, "My Plugin close");
	return true;
  }

	@Override
  public void init() {
    try {
      JOptionPane.showMessageDialog( null, "My Plugin init");
        // We create a new actions category
      ActionsCategory category = new ActionsCategory(null, null);
      // We add our plugin action in this newly created category
      category.addAction(new SimplePluginAction());
      // We get the MagicDraw action manager
      ActionsConfiguratorsManager manager = ActionsConfiguratorsManager.getInstance();
      // We add our new configuration for our category in the MagicDraw action manager
      manager.addContainmentBrowserContextConfigurator(new BrowserContextConfigurator(category));
      // If everything is OK we log it to the MagicDraw GUI logger
      // Not really clever to put it there, but it's just to show how to log something in MagicDraw
      // Application.getInstance().getGUILog().log("[Simple Plugin] Loading OK");
      JOptionPane.showMessageDialog(null, "[SimplePlugin] Loading OK");
    } catch (Exception e) {
      // If something goes wrong we log it to the MagicDraw GUI logger
      /* Application.getInstance().getGUILog().log(
              "[Simple Plugin] Could not instantiate plugin : " + e.toString()); */
      JOptionPane.showMessageDialog(null, "[Simple Plugin] Could not instantiate plugin : " + e.toString());
    }
  }

	@Override
  public boolean isSupported() {
    return true;
  }
}