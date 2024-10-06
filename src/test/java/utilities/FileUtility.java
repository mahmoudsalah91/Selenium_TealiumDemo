package utilities;


import java.util.ResourceBundle;


public class FileUtility {
    public static ResourceBundle getFile (String fileName){
        ResourceBundle Data=ResourceBundle.getBundle(fileName);
        return Data;
    }

}
