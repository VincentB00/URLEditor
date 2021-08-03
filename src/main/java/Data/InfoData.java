/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Data;

/**
 *
 * @author vince
 */
public class InfoData implements java.io.Serializable
{
    
    public String ip;
    public int port;
    public String username;
    public String password;
    public String schema;

    public InfoData(String ip, int port, String username, String password, String schema) 
    {
        this.ip = ip;
        this.port = port;
        this.username = username;
        this.password = password;
        this.schema = schema;
    }
    
    @Override
    public String toString() 
    {
        return username + "@" + ip;
    }
    
}
