package edu.umd.isr.testplugin;

import com.nomagic.actions.ActionsManager;
import com.nomagic.magicdraw.actions.BrowserContextAMConfigurator;
import com.nomagic.magicdraw.ui.browser.Tree;
import com.nomagic.actions.ActionsCategory;
import com.nomagic.actions.NMAction;
import com.nomagic.magicdraw.actions.MDActionsCategory;
import com.nomagic.actions.AMConfigurator;

public class BrowserContextConfigurator implements BrowserContextAMConfigurator {
  // Here is the category of the contextual menu where you'll find you plugin
  public final static String SIMPLE_PLUGIN_MENU_CATEGORY = "Simple Plugin Menu Category";
  // Here is the ID of your category
  public final static String SIMPLE_PLUGIN_MENU_ID = "SimplePluginMenuID";
  // Plugin action
  private NMAction action;

  public BrowserContextConfigurator(NMAction nmAction) {
    this.action = nmAction;
  }
  @Override
  public int getPriority() {
    return AMConfigurator.MEDIUM_PRIORITY;
  }

  @Override
  public void configure(ActionsManager mngr, Tree tree) {
    // We try to find the existing category
    ActionsCategory category = (ActionsCategory) mngr.getActionFor(SIMPLE_PLUGIN_MENU_ID);
    // If it doesn't exist we create it
    if (category == null) {
        category = new MDActionsCategory(SIMPLE_PLUGIN_MENU_ID, SIMPLE_PLUGIN_MENU_CATEGORY);
        category.setNested(true);
        mngr.addCategory(category);
    }
    // Then we add the action to the category
    category.addAction(action);
  }
}
