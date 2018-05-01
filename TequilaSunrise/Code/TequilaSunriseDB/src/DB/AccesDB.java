/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DB;

import com.mysql.jdbc.Connection;
import com.mysql.jdbc.Statement;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 *
 * @author Flori
 */
public class AccesDB {

    static Connection con = null;
    static Statement stat = null;
    static ResultSet rs = null;
    
    public void getConnection() {
        try {
            con = (Connection) DriverManager.getConnection("jdbc:mysql://127.0.0.1/mysql", "root", "");
            stat = (Statement) con.createStatement();
            rs = stat.executeQuery("SELECT * FROM tequilasunrise");
            //stat.execute("INSERT INTO mysql "+"tequilasunrise('Patrick2', '19.2.2018')");
            
            while (rs.next()) {
                System.out.println("---");
                System.out.print(rs.getString("Name") + " " + rs.getString("Datum"));
            }
        } catch (SQLException e) {
            System.out.println(e);
        }
    }

}
