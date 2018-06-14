/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package database;

import data.PropertyLoader;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

/**
 *
 * @author Florian
 */
public class Database
{
    private static Database instance;
    
    private Connection connection;
    
    private String user;
    private String url;
    private String passwd;
    private String driver;

    private Database(String user, String url, String passwd, String driver) throws ClassNotFoundException, SQLException {
        this.user = user;
        this.url = url;
        this.passwd = passwd;
        this.driver = driver;
    
        Class.forName(driver);
        connect();
    }

    private Database() throws ClassNotFoundException, SQLException
    {
        user = PropertyLoader.getProperties("db_user");
        passwd = PropertyLoader.getProperties("db_passwd");
        url = PropertyLoader.getProperties("db_url");
        driver = PropertyLoader.getProperties("db_driver");
                
        Class.forName(driver);
        connect();
    }

    public static Database getInstance() throws ClassNotFoundException, SQLException
    {
        if(instance == null)
        {
            instance = new Database();
        }
        return instance;
    }
    
    public static Database getInstance(String user, String url, String passwd, String driver) throws ClassNotFoundException, SQLException
    {
        if(instance == null)
        {
            instance = new Database(user, url, passwd, driver);
        }
        return instance;
    }
    
    public void connect() throws SQLException
    {
        connection = DriverManager.getConnection(url, user, passwd);
    }
    
    public void close() throws SQLException
    {
        connection.close();
        instance = null;
    }
    
    public Statement getStatement() throws SQLException, Exception
    {
        if(connection!=null)
        {
            return connection.createStatement();
        }
        throw new Exception("No database available!");
    }
}
