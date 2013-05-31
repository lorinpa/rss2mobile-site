package com.pa.feed;

import com.pa.data.NodeList;
import com.pa.file.DocSet;
import com.pa.resource.StaticSet;
import handler.NodeListHandler;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.Reader;
import java.io.UnsupportedEncodingException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;
import org.xml.sax.InputSource;
import org.xml.sax.SAXException;
import org.xml.sax.XMLReader;

/**
 *
 * @author lorinpa
 * 
 */
public class Convert {

    private static final String SAX_NAMESPACE_PREFIXES = "http://xml.org/sax/features/namespace-prefixes";
    private static final String SAX_NAMESPACES = "http://xml.org/sax/features/namespaces";
    private static final String APP_USAGE = "Usage: java -jar  mobile-feed-convert.jar -src Source File  -out Output Sub-Directory Name";

    /**
     * This is the main entry point for the program. The main() method verifies the command line arguments. If the command
     *  line arguments pass verification, the process of creating a mobile version of our website is invoked. 
     * 
     * If the user has not passed a valid command line, the program displays an "usage" message.
     * 
     *  The program verifies the number of command line arguments along with the correct tokens (-sc and -out).
     * 
     * @param args the command line arguments
     *
     */
    public static void main(String[] args) {
        InputStream inputStream = null;

        int num_args = args.length;
        int nIndex = 0;
        String outputDir="/tmp";
        String srcFile="";
        boolean process = false;
        if (num_args != 4) {
            System.out.println(APP_USAGE);
        }

        if (args[0].equals("-src") && args[2].equals("-out")) {
            process = true;
            srcFile = args[1];
            outputDir = args[3];
        } else {
            System.out.println(APP_USAGE);
        }

        if (process) {

            try {
                File file = new File(srcFile);
                inputStream = new FileInputStream(file);
                Reader reader = new InputStreamReader(inputStream, "UTF-8");
                InputSource is = new InputSource(reader);
                is.setEncoding("UTF-8");
                Convert convert = new Convert();
                NodeList list = convert.parseObject(is);
                DocSet docSet = new DocSet(outputDir, list);
               
                docSet.create();
                // copy in our static content
                String cwd = System.getProperty("user.dir");
                StaticSet stat = new StaticSet();
                String srcDir = cwd + "/static-content";
                stat.copySet(srcDir, outputDir);

            } catch (FileNotFoundException ex) {
                Logger.getLogger(Convert.class.getName()).log(Level.SEVERE, null, ex);
            } catch (UnsupportedEncodingException ex) {
                Logger.getLogger(Convert.class.getName()).log(Level.SEVERE, null, ex);
            } finally {
                try {
                    inputStream.close();
                } catch (IOException ex) {
                    Logger.getLogger(Convert.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        }
    }

   /**
    * Factory method with instantiates and returns a SAX xml parser instance.
    * 
    * @return An instance of an SAX xml parser.
    * @throws ParserConfigurationException  
    * @throws SAXException - Thrown if our RSS XML file is not a valid document.
    */    
    private XMLReader initializeReader() throws ParserConfigurationException, SAXException {
        SAXParserFactory factory = SAXParserFactory.newInstance();
        factory.setFeature(SAX_NAMESPACE_PREFIXES, true);
        factory.setFeature(SAX_NAMESPACES, false);
        SAXParser parser = factory.newSAXParser();
        XMLReader xmlreader = parser.getXMLReader();
        return xmlreader;
    }

    /**
     * Method attaches our SAX event handler to the parser. Method 
     * also connects the opened XML file to the parser. Invokes the actual parsing, 
     * and returns the NodeList (article collection) built by our SAX event handler (NodeListHandler).
     * 
     * @param is Input source is our RSS xml file.
     * @return Returns a list of nodes(articles) parsed out of the RSS xml file.
     */
    public NodeList parseObject(InputSource is) {

        try {
            XMLReader xmlreader = initializeReader();
            NodeListHandler handler = new NodeListHandler();
            xmlreader.setContentHandler(handler);
            xmlreader.parse(is);
            return handler.get();
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }
}
