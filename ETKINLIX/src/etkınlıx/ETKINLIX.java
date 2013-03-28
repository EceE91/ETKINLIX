/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package etkınlıx;

import java.sql.Connection;
import java.sql.Driver;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

/**
 *
 * @author ECE
 */
public class ETKINLIX {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        try {

            Class c = Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");

            Driver drv = (Driver) c.newInstance();

            Connection conn = drv.connect("jdbc:sqlserver://159.253.37.201; databaseName=mustafa; user=mustafauser; password=mustafa2703", null);

            Statement stmt = conn.createStatement();



            ResultSet rs;

            rs = stmt.executeQuery("select * from eceokul.Etkinlikler");

            while (rs.next()) {
                System.out.println(rs.getString("E_id")+"  "+ rs.getString("E_adi"));
               
                
            }

        } catch (ClassNotFoundException e) {

            e.printStackTrace();

        } catch (SQLException e2) {

            e2.printStackTrace();

        } catch (InstantiationException e) {

            e.printStackTrace();

        } catch (IllegalAccessException e) {

            e.printStackTrace();

        }

    }
}
