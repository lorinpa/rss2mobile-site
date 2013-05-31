/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.pa.data.format;

import com.pa.data.Node;
import org.apache.commons.lang.StringEscapeUtils;

/**
 *  The purpose of this class is to add the html document parent
 *   markup tags, header section including link references to CSS and 
 *   JavaScript resources. 
 * 
 * @author lorinpa
 * 
 */
public class NodeDoc {
    
    private Node node;
    private StringBuilder sb;
    private String prerenderFileName ="index";
    private final static String SIDE = "A"; // custom value corresponding to my site
    /**
     * 
     * @param node  Node is the logical article (title and body). 
     */
    public NodeDoc(Node node) {
        this.node = node;
        sb = new StringBuilder();
    }

    public NodeDoc() {
        sb = new StringBuilder();
    }

    /**
     * 
     * @param node Sets the node (article) value.
     */
    public void setNode(Node node) {
        this.node = node;
    }
    /**
     *  Clears the stringbuilder in case we want to reuse this object.
     */
    public void clear() {
        this.sb.setLength(0);
    }
    
    /**
     * 
     * @return Returns a complete html document.
     */
    public String toHtmlDoc() {
        sb.append(String.format(HtmlConstants.DOC_OPEN_TEMPLATE, HtmlConstants.EMPTY,node.getTitle(),prerenderFileName,prerenderFileName,SIDE));
        sb.append(HtmlConstants.CONTAINER_OPEN);
        sb.append(HtmlConstants.ARTICLE_OPEN);
        sb.append(String.format(HtmlConstants.TITLE_TEMPLATE, node.getTitle()));
        sb.append(StringEscapeUtils.unescapeHtml(node.getBody()));
        sb.append(HtmlConstants.ARTICLE_CLOSE);
        sb.append(HtmlConstants.FOOTER_TEMPLATE);
        sb.append(HtmlConstants.CONTAINER_CLOSE);
        sb.append(HtmlConstants.DOC_CLOSE);
        return sb.toString();
    }
}
