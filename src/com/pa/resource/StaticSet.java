package com.pa.resource;

import java.io.File;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.apache.commons.io.FileUtils;

/**
 * The purpose of this class is to make of a copy of files and directories located 
 *  in our static source location. The copied files and directories are placed in our 
 *  site's output directory. This allows us to add content from sources other than our central 
 *  website RSS feed. 
 * 
 * @author lorinpa
 *
 */
public class StaticSet {
    
    /**
     * Makes a copy of the source directory contents and adds that content to the output direcory.
     * Content is either a file or directory. We use the Apache Common IO FileUtils to copy both directories
     * and files.
     * 
     * @param srcParentDir A path relative to where the program is being run from. The location (directory) of our static content.
     * @param destDir  The output directory (also a relative path to where the program is being run from).
     */
    public void copySet(String srcParentDir, String destDir) {
        File srcDir = new File(srcParentDir);
        File elem = null;
        String srcPath = null;
        String destPath = null;
        if (srcDir.isDirectory()) {
            String[] files = srcDir.list();      
            for (String file :files) {
                srcPath = srcParentDir + "/" + file;
                destPath = destDir + "/" + file;
                elem = new File(srcPath);
                if (elem.isDirectory()) {        
                    copyDir(srcPath, destPath);
                } else {
                    copyFile(srcPath,destPath);
                }
            }    
        }
    }
    
    /**
     * Copies an individual file from the source directory to the output (destination) directory.
     * 
     * @param src Name and location of file we are copying..
     * @param dest Output directory location.
     */
    public void copyFile(String src, String dest) {
        try {
            File srcDir = new File(src);
            File destDir = new File(dest);
            FileUtils.copyFile(srcDir, destDir);
        } catch (IOException ex) {
            System.err.println(ex.getMessage());
            Logger.getLogger(StaticSet.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }
    
    /**
     * Copies a directory (and all it's child files and subdirectories) to the output (destination) directory.
     * 
     * @param src Name and location of the directory we are copying.
     * @param dest Output directory location.
     */
    public void copyDir(String src, String dest) {          
            File srcDir = new File(src);
            File destDir = new File(dest);
        try {
            FileUtils.copyDirectory(srcDir, destDir);
        } catch (IOException ex) {
            System.err.println(ex.getMessage());
            Logger.getLogger(StaticSet.class.getName()).log(Level.SEVERE, null, ex);
        }  
    }
}
