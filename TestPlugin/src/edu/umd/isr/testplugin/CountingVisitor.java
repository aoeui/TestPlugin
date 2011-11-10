package edu.umd.isr.testplugin;

import java.util.HashMap;

import com.nomagic.magicdraw.uml.BaseElement;
import com.nomagic.magicdraw.uml.ClassTypes;
import com.nomagic.magicdraw.uml.InheritanceVisitor;
import com.nomagic.uml2.ext.jmi.reflect.VisitorContext;
import com.nomagic.uml2.ext.magicdraw.classes.mdkernel.Element;

public class CountingVisitor extends InheritanceVisitor {
  private HashMap<String,Integer> countMap = new HashMap<String,Integer>();

  /**
   * The visitation of the element.
   *
   * @param element the element to visit.
   * @param context the context of the visitor.
   */
  public void visitElement(Element element, VisitorContext context) {
      super.visitElement(element, context);
      // Call the count
      countElements(element);
  }

  /**
   * Count elements of each type.
   *
   * @param element the element to count.
   */
  public void countElements(BaseElement element) {
      // We get the human readable name of the element
      String classType = ClassTypes.getShortName(element.getClassType());
      // Then we get the count of this type of elements
      Integer count = countMap.get(classType);
      // If it is the first element of this type we visit, we need to create a new value for the counting
      if (count == null) {
          count = Integer.valueOf(0);
      }
      // Finally we increase the count
      countMap.put(classType, Integer.valueOf(count.intValue() + 1));
  }

  /**
   * Getter for countMap.
   * @return the countMap
   */
  public HashMap<String,Integer> getMap() {
      return countMap;
  }
}
