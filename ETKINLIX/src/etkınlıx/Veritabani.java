/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package etkınlıx;

import java.sql.*;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author ECE
 */
public class Veritabani {

    Statement stmt = null;
    ResultSet rs;
    static Connection conn;

    public Veritabani() {
        try {
            baglan();
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(Veritabani.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(Veritabani.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    private void baglan() throws ClassNotFoundException, SQLException {
        try {
            stmt = conn.createStatement();
            Class c = Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");

            Driver drv = (Driver) c.newInstance();

            conn = drv.connect("jdbc:sqlserver://159.253.37.201; databaseName=mustafa; user=mustafauser; password=mustafa2703", null);
        } catch (Exception e) {
        }
    }

    public Boolean isLogin(String id, String sifre) {
    Boolean giris=false;    
    try {
            stmt = conn.createStatement();
            rs = stmt.executeQuery("select * from eceokul.LoginEtkinlix lgn where lgn.Login_kullanici_adi='"+id+"' and lgn.Login_pwd='"+sifre+"'");
            
            if(rs.next()){
             giris = true;            
            }
            
        } catch (SQLException ex) {
            Logger.getLogger(ETKINLIX_GIRIS_FRAME.class.getName()).log(Level.SEVERE, null, ex);
        }

        return giris;
    }
}
