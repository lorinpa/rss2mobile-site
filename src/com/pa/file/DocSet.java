package com.pa.file;

import com.pa.data.NodeList;
import com.pa.data.format.HtmlConstants;
import com.pa.data.format.NodeDoc;
import com.pa.data.format.TocDoc;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.util.logging.Level;
import java.util.logging.Logger;


/**
 * The purpose of this class is to write the our imported content (articles extracted from RSS xml feed) 
 *  to disk. We create an output directory and then create a set of files.
 * 
 * @author lorinpa
 * 
 */
public class DocSet {
    
    private String dirName;
    private NodeList list;
    String cwd = System.getProperty("user.dir");
    String subdir;

    /**
     * 
     * @param dirName This is our output directory. A directory name which is created relative to where the program is being run from.
     * @param list Collection of articles (nodes) prepared as mobile web pages.
     */
    public DocSet(String dirName, NodeList list) {
        this.dirName = dirName;
        this.list = list;
        subdir = cwd + "/" + dirName;
    }
    
    /**
     *  Main process for this class. We create the output directory. Write each node (article) to disk (in the output directory).
     *  We write the table of contents (index.html) page to disk (in the output directory).
     */
    public void create() {
        createDir();
        NodeDoc nodeDoc = new NodeDoc();
        int num_nodes = list.size();
        String file_name;
        for (int nIndex= 0; nIndex < num_nodes; nIndex++) {
                file_name = String.format(HtmlConstants.DEFAULT_FILENAME_TEMPLATE, nIndex);
                nodeDoc.clear();
                nodeDoc.setNode(list.get(nIndex));   
                createFile(file_name, nodeDoc.toHtmlDoc());
        }
         
        TocDoc toc = new TocDoc(list,HtmlConstants.DEFAULT_INDEX_TITLE);
        file_name = HtmlConstants.DEFAULT_INDEX_FILENAME;
        createFile(file_name, toc.toHtmlDoc());    
    }
    
    /**
     * Creates a directory.
     */
    private void createDir() {
       
        File file = new File(subdir);
        if (!file.exists()) {
            file.mkdir();
        }
    }
    
    /**
     * Creates a file.
     * @param file_name Name of the file we are writing to disk.
     * @param doc  The actual file content (document) we are writing to disk.
     */
    private void createFile(String file_name, String doc) {
        FileOutputStream fos = null; 
       OutputStreamWriter out= null;
        try {
             fos = new FileOutputStream(subdir+ "/" + file_name); 
             out = new OutputStreamWriter(fos, "UTF-8");
             out.write(doc);
        } catch(Exception e) {
            System.err.println(e.getMessage());
        } finally {
            try {
                out.close();
                fos = null;
            } catch (IOException ex) {
                Logger.getLogger(DocSet.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }
    
}
