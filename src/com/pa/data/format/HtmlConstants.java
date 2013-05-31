/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.pa.data.format;

/**
 *
 * @author lorinpa
 * 
 */
public class HtmlConstants {
    
    public final static String ARTICLE_OPEN = "<article>";
     public final static String ARTICLE_CLOSE = "</article>";
     public final static String TITLE_OPEN = "<header><h4 class=\"h4\">";
     public final static String TITLE_CLOSE = "</h4></header>";
     
    // public final static String TITLE_TEMPLAGE = "<header><h4 class=\"h4\">%s</h4></header>";
     public final static String TITLE_TEMPLATE = "<div class=\"page-header\"><h4 class=\"h4\">%s</h4><div class=\"pull-right\"><a href=\"index.html\"><i class=\"icon-home\"></i> - Home</a></div></div>";

     public final static String FOOTER_TEMPLATE = "<div class=\"pull-right\"><a href=\"index.html\"><i class=\"icon-home\"></i> - Home</a></div>";
     
     public final static String CONTAINER_OPEN = "<div class=\"container-fluid\">";
     public final static String CONTAINER_CLOSE = "</div>";
     
     
 /*    public final static String DOC_OPEN_TEMPATE = "<!DOCTYPE html>\n" +
"<html manifest=\"cache.appcache\">\n" +
"    <head>\n" +
"        <title>%s</title>\n" +
"        <meta name=\"viewport\" content=\"width=device-width, initial-scale=1.0\">\n" +
"        <meta http-equiv=\"Content-Type\" content=\"text/html; charset=UTF-8\">\n" +
"        <link type=\"text/css\" href=\"css/bootstrap/css/bootstrap.min.css\" media=\"all\" rel=\"stylesheet\" id=\"bootstrap\"/>\n" +
"      </head>\n" +
             
"      <body>";*/
     
     
   /*  public final static String DOC_OPEN_TEMPLATE = "<!DOCTYPE html>\n" +
"<html manifest=\"cache.appcache\">\n" +
"    <head>\n" +
"        <title>%s</title>\n" +
"        <meta name=\"viewport\" content=\"width=device-width, initial-scale=1.0\">\n" +
"        <meta http-equiv=\"Content-Type\" content=\"text/html; charset=UTF-8\">\n" +
"        <link type=\"text/css\" href=\"css/bootstrap/css/bootstrap.min.css\" media=\"all\" rel=\"stylesheet\" id=\"bootstrap\"/>\n" +
"         <style>\n" +
"            .wow {\n" +
"                color:white;\n" +
"            }\n" +
"            .wee {\n" +
"                color:gold;\n" +
"            }\n" +
"            .contact:hoover:after {\n" +
"                content: \"<div>lorinmk@public-action.org</div>\";\n" +
"            }\n" +
"        \n" +
"            @media all and (max-width: 480px)  {\n" +
"                .greeting {\n" +
"                  margin-bottom: 5px;\n" +
"            }\n" +
"}\n" +
"        </style>\n" +
"        <link rel=\"shortcut icon\" href=\"favicon.png\">\n" +
"         <link rel=\"prerender\" href=\"http://public-action.org/mob/%s.html\" />\n" +
"    </head>\n" +
"    <body>";*/
     
     public final static String EMPTY ="";
     public final static String MANIFEST = " manifest=\"cache.appcache\"";
     
     public final static String DOC_OPEN_TEMPLATE = "<!DOCTYPE html>\n" +
"<html%s>\n" +
"    <head>\n" +
"        <title>%s</title>\n" +
"        <meta name=\"viewport\" content=\"width=device-width, initial-scale=1.0\">\n" +
"        <meta http-equiv=\"Content-Type\" content=\"text/html; charset=UTF-8\">\n" +
"        <link type=\"text/css\" href=\"css/bootstrap/css/bootstrap.min.css\" media=\"all\" rel=\"stylesheet\" id=\"bootstrap\"/>\n" +
"         <style>\n" +
"            .wow {\n" +
"                color:white;\n" +
"            }\n" +
"            .wee {\n" +
"                color:gold;\n" +
"            }\n" +
"            .contact:hoover:after {\n" +
"                content: \"<div>lorinmk@public-action.org</div>\";\n" +
"            }\n" +
"        \n" +
"            @media all and (max-width: 480px)  {\n" +
"                .greeting {\n" +
"                  margin-bottom: 5px;\n" +
"            }\n" +
"}\n" +
"        </style>\n" +
"        <link rel=\"shortcut icon\" href=\"favicon.png\">\n" +
"         <link rel=\"prerender\" href=\"http://public-action.org/mob/%s.html\" />\n" +
"    </head>\n" +
"    <body><div class=\"container-fluid\">\n" +
"            <div class=\"navbar navbar-inverse\">\n" +
"                <div class=\"navbar-inner\">\n" +
"                    <ul class=\"nav\">\n" +
"                        <li><a class=\"brand\" href=\"#\"><span class=\"wow\">Public</span> <span class=\"wee\">Action</span></a></li>\n" +
"                        <li><a href=\"%s.html\">%s-side</a></li>\n" +
"                    </ul>      \n" +
"                </div>\n" +
"            </div>";
     
     public final static String DOC_CLOSE ="</body>\n</html>";
     
     public final static String OPEN_NAV_LIST_TEMPLATE = "<ul class=\"nav nav-list\">\n" +
"  <li class=\"nav-header\">%s</li>";
     
     public final static String NAV_LIST_ITEM_TEMPLATE = "<li><a href=\"%s\">%s</a></li>";     
     public final static String CLOSE_NAV_LIST = "</ul>";
     
     public final static String DEFAULT_FILENAME_TEMPLATE = "doc-%d.html";
     public final static String DEFAULT_INDEX_TITLE = "Public Action Articles";
     public final static String DEFAULT_INDEX_FILENAME = "index.html";
     
}
