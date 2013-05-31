package com.pa.data.format;

import com.pa.data.Node;
import com.pa.data.NodeList;

/**
 * The purpose of this class is to prepare the the table of contents,
 * as a html document. We add parent markup tags, link references to CSS, JavsScipt,
 * Cache Manifest files, etc.
 * 
 * @author lorinpa
 *  
 */
public class TocDoc {
    
    private NodeList list;
    private StringBuilder sb;
    private String title;
    private String prerenderFileName ="a-side";
    private final static String SIDE = "AA";

    /**
     * 
     * @param list Collect of nodes (articles)
     * @param title The text used for the html document title tag. The text displayed by a web browser tab control. 
     */
    public TocDoc(NodeList list, String title) {
        this.list = list;
        this.sb =  new StringBuilder();
        this.title = title;
    }
    
    /**
     * 
     * @return Returns a complete html document. 
     */
     public String toHtmlDoc() {
        sb.append(String.format(HtmlConstants.DOC_OPEN_TEMPLATE,HtmlConstants.MANIFEST, title,prerenderFileName,prerenderFileName,SIDE));
        sb.append(HtmlConstants.CONTAINER_OPEN);
        sb.append(String.format(HtmlConstants.OPEN_NAV_LIST_TEMPLATE, title));
        String  file_name = null;
        int nIndex =0;
        
        for (Node n :  list) {
            file_name = String.format(HtmlConstants.DEFAULT_FILENAME_TEMPLATE, nIndex++);
             sb.append(String.format(HtmlConstants.NAV_LIST_ITEM_TEMPLATE, file_name, n.getTitle()));
          }
        sb.append(HtmlConstants.CLOSE_NAV_LIST);
        sb.append(HtmlConstants.CONTAINER_CLOSE);
        sb.append(HtmlConstants.DOC_CLOSE);
        return sb.toString();
     }
    
    
}
