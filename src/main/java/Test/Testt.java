/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Test;

import Data.InfoData;
import Data.InfoSer;
import Data.SQL;
import Data.URL;
import Data.URLContent;
import Data.URLSet;
import java.io.IOException;
import java.sql.ResultSet;
import java.util.Enumeration;
import java.util.LinkedList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.tree.TreeNode;

/**
 *
 * @author vince
 */
public class Testt 
{

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) 
    {
        SQL sql = new SQL("67.241.4.218", 3307, "vincentbui1999", "Tivinh265@Vv");
        LinkedList<URL> urlList = new LinkedList<URL>();
        LinkedList<URLContent> urlContentList = new LinkedList<URLContent>();
        
        try
        {
            ResultSet rs = sql.executeQuery(String.format("Select * from %s.URL", "PublicCode"));
            
            while(rs.next())
                urlList.add(new URL(rs.getInt("id"), rs.getString("name"), rs.getString("URL"), rs.getBoolean("protected"), rs.getString("user_group")));
            
            rs.close();
            sql.closeConnection();
            
            rs = sql.executeQuery(String.format("Select * from %s.URL_content", "PublicCode"));
            
            while(rs.next())
                urlContentList.add(new URLContent(rs.getInt("id"), rs.getInt("URL_id"), rs.getString("content")));
            
            rs.close();
            sql.closeConnection();
        }
        catch(Exception ex)
        {
            ex.printStackTrace();
        }
        
        System.out.println("--------Old list----------");
        println(urlList);
        System.out.println("------------------");
        println(urlContentList);
        System.out.println("---------End of old list---------");
       autoShortURL(urlList, urlContentList);
    }
    
    public static void autoShortURL(LinkedList<URL> urlList, LinkedList<URLContent> urlContentList)
    {
        LinkedList<URLSet> list = new LinkedList<URLSet>();
        LinkedList<URLSet> listT;
        LinkedList<URLSet> sortedList = new LinkedList<URLSet>();
        for(int count = 0; count < urlList.size(); count++)
        {
            list.add(new URLSet(urlList.get(count)));
        }
        for(int count = 0; count < urlContentList.size(); count++)
        {
            addURLContentToSet(list, urlContentList.get(count));
        }
        
//        println(list);
        
        int maxLevel = 1;
        for(int count = 0; count < list.size(); count++)
        {
            if(list.get(count).beforeSortedID > maxLevel)
                maxLevel = list.get(count).beforeSortedID;
        }
        
        for(int level = 1; level <= maxLevel; level++)
        {
            listT = new LinkedList<URLSet>();
            
            //add each level to list T for sorting
            for(int count = 0; count < list.size(); count++)
                if(list.get(count).urlLevel == level)
                    listT.add(list.get(count));
            
            while(!listT.isEmpty())
            {
                sortedList.add(getSmallest(listT, level - 1));
            }
        }
        
        println(sortedList);
    }
    
    public static URLSet getSmallest(LinkedList<URLSet> list, int level)
    {
        int index = 0;
        for(int count = 0; count < list.size(); count++)
        {
            if(list.get(count).paths[level].charAt(0) < list.get(index).paths[level].charAt(0))
                index = count;
        }
        
        URLSet set = list.get(index);
        list.remove(index);
        return set;
    }
    
    public static void addURLContentToSet(LinkedList<URLSet> urlList, URLContent urlContent)
    {
        int urlContentID = urlContent.URL_id;
        for(int count = 0; count < urlList.size(); count++)
        {
            int urlID = urlList.get(count).beforeSortedID;
            if(urlID == urlContentID)
            {
                urlList.get(count).urlContentList.add(urlContent);
                return;
            }
                
        }
    }
    
    public static void println(LinkedList list)
    {
        for(int count = 0; count < list.size(); count++)
            System.out.println(list.get(count));
    }
}