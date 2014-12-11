/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package application_library;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Lenka
 */
public class UserSettings implements Serializable{
    
    public UserSettings(){
        password             = "";
        lookAndFeelClassName = "";
    }
    
    public void setPassword(char[] password){
        this.password = new String(password);
    }
    
    public String getPassword(){
        return password;
    }
    
    public void setLookAndFeel(String className){
        lookAndFeelClassName = className;
    }
    
    public String getLookAndFeel(){
        return lookAndFeelClassName;
    }
    
    public static void saveSettings(UserSettings us){
        FileOutputStream   fos;
        ObjectOutputStream oos;
        
        try {
            fos = new FileOutputStream(path);
            oos = new ObjectOutputStream(fos);
            
            oos.writeObject(us);
            oos.flush();
            oos.close();   
        } catch (FileNotFoundException ex) {
            Logger.getLogger(Library.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(Library.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public static UserSettings loadSettings(){
        FileInputStream   fis;
        ObjectInputStream oin;
        
        UserSettings us = new UserSettings();
        
        try {
            fis = new FileInputStream(path);
            oin = new ObjectInputStream(fis);
            
            us = (UserSettings) oin.readObject();
        } catch (FileNotFoundException ex) {
            Logger.getLogger(Library.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException | ClassNotFoundException ex) {
            Logger.getLogger(Library.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        return us;
    }
    
    private static final String path = "users.stg";
    
    private String password;
    private String lookAndFeelClassName;
}
