package com.pa.data;

import java.util.ArrayList;
import java.util.Iterator;

/**
 * Logical representation of a list of articles (web pages).
 * Internally this is a list on Node objects.
 * 
 * @author lorinpa
 * 
 */
public class NodeList extends ArrayList<Node>  {
    
    /**
     * 
     * @param e The node we are adding to our list.
     * @return true for success. false for failure.
     */
   @Override
  public boolean add(Node e) {
    return super.add(e);
  }

  /**
   * 
   * @return An iterator object that allows to select one Node at a time.
   */
  @Override
  public Iterator<Node> iterator() {
    return super.iterator();
  }
    
}
