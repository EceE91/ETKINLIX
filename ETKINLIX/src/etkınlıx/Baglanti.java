/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package etkınlıx;

import java.sql.Connection;
import java.sql.Driver;
import java.sql.SQLException;

/**
 *
 * @author ECE
 */
public class Baglanti {
    public static Connection conn;
    public static Connection baglanttiac() throws ClassNotFoundException, InstantiationException, IllegalAccessException, SQLException{
            Class c = Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
            Driver drv = (Driver) c.newInstance();
           conn = drv.connect("jdbc:sqlserver://159.253.37.201; databaseName=mustafa; user=mustafauser; password=mustafa2703", null);
           return conn;
    }
}
