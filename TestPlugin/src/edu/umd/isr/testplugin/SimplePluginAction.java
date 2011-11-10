package edu.umd.isr.testplugin;

import java.awt.event.ActionEvent;

import javax.swing.JOptionPane;

import com.nomagic.magicdraw.ui.browser.actions.DefaultBrowserAction;
import com.nomagic.uml2.ext.magicdraw.classes.mdkernel.Element;

public class SimplePluginAction extends DefaultBrowserAction {
  private static final long serialVersionUID = 1L;
  // The name of the action which will be displayed in MagicDraw
  private static final String SIMPLE_PLUGIN_ACTION_NAME = "Simple Plugin Action";
  // The id of the action which will be displayed in MagicDraw
  private static final String SIMPLE_PLUGIN_ACTION_ID = "SimplePluginActionID";
  
  public SimplePluginAction() throws Exception {
    super(SIMPLE_PLUGIN_ACTION_ID, SIMPLE_PLUGIN_ACTION_NAME, null, null);
  }
  
  public void actionPerformed(ActionEvent actionEvent) {
    SimplePluginBehavior simplePluginBehavior = new SimplePluginBehavior();
    CountingVisitor countingVisitor = simplePluginBehavior.getVisitor();
    // Clear the map for a clean count
    countingVisitor.getMap().clear();

    // Visit the children for counting elements of each type
    simplePluginBehavior.visitChildren((Element)getSelectedObject());
    // Display the counting results
    String result = simplePluginBehavior.returnResults(countingVisitor.getMap());
    JOptionPane.showMessageDialog(null, result);
  }
}
