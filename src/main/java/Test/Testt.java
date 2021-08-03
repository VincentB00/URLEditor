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
        
    }
    
    public static void println(LinkedList list)
    {
        for(int count = 0; count < list.size(); count++)
            System.out.println(list.get(count));
    }
}