/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package etkınlıx;

import java.sql.*;

/**
 *
 * @author ECE
 */
public class Veritabani {

    Statement stmt = null;
    ResultSet rs;

    public Veritabani() {

    
        /*
        
        Class c = Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");

        Driver drv = (Driver) c.newInstance();

        conn = drv.connect("jdbc:sqlserver://159.253.37.201; databaseName=mustafa; user=mustafauser; password=mustafa2703", null);
    
    */
    
    
    }

    public void baglan() throws ClassNotFoundException, SQLException {
        Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
        String cstr = "jdbc:sqlserver://localhost;databaseName:EtkinliX";
        Connection conn = DriverManager.getConnection(cstr, "sa", "1234567?");
    }
}
