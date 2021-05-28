/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Data;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.LinkedList;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author vince
 */
public class InfoSer implements java.io.Serializable
{
    public LinkedList<InfoData> list;
    
    public InfoSer()
    {
        list = new LinkedList<InfoData>();
        
    }
    
    public InfoSer(String fileName)
    {
        try 
        {
            list = deserialize(fileName).list;
        } 
        catch(Exception ex)
        {
            list = new LinkedList<InfoData>();
        }
    }
    
    public void serialize(String fileName) throws IOException
    {
        FileOutputStream fos = new FileOutputStream(fileName + ".ser");
        ObjectOutputStream oos = new ObjectOutputStream(fos);
        oos.writeObject(this);
        oos.close(); 
    }
    public static InfoSer deserialize(String fileName) throws FileNotFoundException, IOException, ClassNotFoundException
    {
        FileInputStream fis = new FileInputStream(fileName + ".ser");
        ObjectInputStream ois = new ObjectInputStream(fis);
        Object obj = ois.readObject();
        ois.close();
        return (InfoSer) obj;
    }
}
