/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package database;

import java.sql.SQLException;

/**
 *
 * @author Florian
 */
public class DBAccess
{
    Database database;
    
    public DBAccess() throws ClassNotFoundException, SQLException
    {
        database = Database.getInstance();
    }
    
    public DBAccess(String user, String url, String passwd, String driver) throws ClassNotFoundException, SQLException
    {
        database = Database.getInstance(user, url, passwd, driver);
    }
}
