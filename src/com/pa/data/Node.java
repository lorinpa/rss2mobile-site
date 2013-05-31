/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.pa.data;

import java.util.Objects;

/**
 *  This class is a logical representation of an article (web page).
 *  Simple document, just a title and body.
 * 
 * @author lorinpa
 * 
 */
public class Node {
    
    private String title;
    private String body;
    
    public Node() {}
    
    /**
     * 
     * @param title Title of article/page
     * @param body  Article content including html markup.
     */
    public Node(String title, String body) {
        this.title = title;
        this.body = body;
    }

    /**
     * 
     * @return Returns title text of the article. 
     */
    public String getTitle() {
        return title;
    }

    /**
     * 
     * @param title Simple setter for title of article.
     */
    public void setTitle(String title) {
        this.title = title;
    }

    /**
     * 
     * @return Returns the article's content including html markup.
     */
    public String getBody() {
        return body;
    }

   /**
    * 
    * @param body  Simple setter for title of article body.
    */
    public void setBody(String body) {
        this.body = body;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 67 * hash + Objects.hashCode(this.title);
        hash = 67 * hash + Objects.hashCode(this.body);
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Node other = (Node) obj;
        return true;
    }
     
}
