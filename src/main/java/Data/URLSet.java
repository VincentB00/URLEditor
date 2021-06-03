/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Data;

import java.util.LinkedList;

/**
 *
 * @author vince
 */
public class URLSet 
{
    public URL url;
    public LinkedList<URLContent> urlContentList;
    public int beforeSortedID;
    public int afterSortedID;
    public int urlLevel;
    public String[] paths;
    public URLSet(URL url)
    {
        this.url = url;
        this.urlContentList = new LinkedList<URLContent>();
        this.beforeSortedID = url.id;
        this.paths = url.path.substring(1).split("/");
        this.urlLevel = paths.length;
        
    }
    public void addURLContent(URLContent urlContent)
    {
        urlContentList.add(urlContent);
    }

    @Override
    public String toString() {
        return "URLSet{" + "url=" + url + ", urlContentList=" + urlContentList + ", beforeShortID=" + beforeSortedID + ", afterShortID=" + afterSortedID + ", urlLevel=" + urlLevel + ", level=" + paths + '}';
    }
    
}
