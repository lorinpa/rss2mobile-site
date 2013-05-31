package handler;

import com.pa.data.Node;
import com.pa.data.NodeList;
import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;

/**
 *
 * @author lorinpa
 * 
 */
public class NodeListHandler extends DefaultHandler {
  private StringBuilder buffer = new StringBuilder();
  private NodeList list;
  private Node node;
  boolean start = false;
  
  @Override
  public void startElement(String namespaceURI, String localName,
          String qName, Attributes atts) throws SAXException {
      buffer.setLength(0);
      if (qName.equals("language")) {
        list = new NodeList();
        start = true;
      } else if (qName.equals("item") && start) {
        node = new Node();
    }
  }

  @Override
  public void endElement(String uri, String localName, String qName) throws SAXException {
    if (start) {
        if (qName.equals("title")) {
          node.setTitle(buffer.toString());
        } else if (qName.equals("description")) {
          node.setBody(buffer.toString());
        } else if (qName.equals("item")) {
          list.add(node);
          node = new Node();
        }
    }
  }

  @Override
  public void characters(char[] ch, int start, int length) {
    buffer.append(ch, start, length);
  }

  public NodeList get() {
    return list;
  }
}
