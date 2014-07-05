
/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
import java.awt.FileDialog;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.nio.file.FileAlreadyExistsException;
import java.nio.file.Files;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import javax.swing.UIManager;

/**
 *
 * @author Pubudu nn
 */
public class ComposeJava {

    ArrayList<String> fileList = new ArrayList<>();         //list of files read
    Map<String, String> packages = new HashMap<>();         //list of packages of one for each file
    static int fileCount = -1;                              //count of java  files read
    String dir;                                             //current directory of the program

    public String readDirectory() {                         //this method imports files and then calls another method(read()) to process the imported files
        try {
            UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());    //sets windows default look and feel
        } catch (Exception ex) {
            System.out.println(ex);
        }
        FileDialog fd = new FileDialog((java.awt.Frame) null);  //file dialog to select and import java files
        fd.setMultipleMode(true);                               //allow selecting multiple files
        fd.setVisible(true);                                    //show the file dialog
        File[] files = fd.getFiles();                           //import java files
        dir = System.getProperty("user.dir");                   //identifies the root directory
        read(files, dir);
        return dir;
    }

    /*
     * This Method processes the files read in the given Directory and stores
     * them in an array list. Also maintains a file count
     */
    private void read(File[] files, String dir) {
        String packName;                             //to temporarily store the package name of files 
        for (File file : files) {                           //for each file...
            packName = "";
            try {
                if (file.getName().substring(file.getName().length() - 5).compareTo(".java") != 0) {    //second test to make sure it is a java file
                    continue;
                }
                fileCount++;
                fileList.add(file.getName());               //add file names to the arraylist
            } catch (Exception e) {
                continue;                                   //exception raised if processed file is not a java file
            }

            try {
                BufferedReader reader = new BufferedReader(new FileReader(file));
                String line;
                while ((line = reader.readLine()) != null) {    //check until end of file
                    if (line.contains("package ")) {            //to extract the package name from the java file, if any
                        int index = line.indexOf("package");
                        if (index != 0) {
                            break;
                        }
                        packName = line.substring(8, line.length() - 1);
                        packages.put(file.getName().substring(0, file.getName().length() - 5), packName);
                        System.out.println(file.getName().substring(0, file.getName().length() - 5) + " ..... " + packName);
                        // System.out.println(file.getName().substring(0,file.getName().length()-5));
                    }
                }
            } catch (Exception ex) {
                System.out.println("read Files " + ex);     //exception at read files method
            }

            String dirToCopy = dir + "\\" + packName;       //derive absoolute path for a new file to be copied
            try {
                final File dest = new File(dirToCopy);      //new folder in derived destination
                dest.mkdir();                               //create directory

                dirToCopy = dirToCopy + "\\" + file.getName();  //absolute path with file name
                final File destFile = new File(dirToCopy);      //new file in derived destination
                dest.mkdir();                                   //create directory

                Files.copy(file.toPath(), destFile.toPath());   //upload file


            } catch (FileAlreadyExistsException e) {
                System.out.println("File Already Exists");
            } catch (Exception ex) {
                System.out.println(ex);
            }

        }

    }

    public String getPackage(String className) {        //returns the package of the program
        if (packages.get(className) == null) {
            return "";                                  //case when no package
        }
        return packages.get(className) + ".";           //package name with a dot appended at the end
    }

    /*
     * This method (tries to)compile the files found at the given directory
     */
    public String compile() {
        int remain = fileCount;
        while (remain >= 0) {
            //System.out.println(fileCount-remain);
            String file = fileList.get(fileCount - remain);    //evaluate absolute path to the java files
            file = file.substring(0, file.length() - 5);
            String pkg = packages.get(file);
            System.out.println(file);

            try {
                //      System.out.println("javac "+file);
                Runtime.getRuntime().exec(("javac \"" + dir + "\\" + pkg + "\\" + "*.java\""));
                System.out.println("javac \"" + dir + "\\" + pkg + "\\" + "*.java\"");
            } catch (IOException ex) {
                return ex.toString();                       //return exception to be printed on the shellView
            }
            remain--;
        }
        return (fileCount + " Files compiled successfully");    //return success message to be printed on the shellView
    }

    public String getDir() {
        return dir;             //return current directory(root director)
    }

    public static int getFileCount() {
        return fileCount;       //return number of files
    }

    public ArrayList<String> getFileList() {
        return fileList;        //return an arraylist which contains all the files read
    }
}
