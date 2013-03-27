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

    public Veritabani() {
    }
   
    public void baglan() throws ClassNotFoundException, SQLException{
        Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
        String cstr = "jdbc:sqlserver://localhost;databaseName:EtkinliX";
        Connection conn = DriverManager.getConnection(cstr,"sa","1234567?");
    }
}
