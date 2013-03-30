/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package etkınlıx;

import java.io.Serializable;
import javax.persistence.*;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author ECE
 */
@Entity
@Table(name = "LoginEtkinlix")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "LoginEtkinlix.findAll", query = "SELECT l FROM LoginEtkinlix l"),
    @NamedQuery(name = "LoginEtkinlix.findByLoginid", query = "SELECT l FROM LoginEtkinlix l WHERE l.loginid = :loginid"),
    @NamedQuery(name = "LoginEtkinlix.findByLoginkullaniciadi", query = "SELECT l FROM LoginEtkinlix l WHERE l.loginkullaniciadi = :loginkullaniciadi"),
    @NamedQuery(name = "LoginEtkinlix.findByLoginpwd", query = "SELECT l FROM LoginEtkinlix l WHERE l.loginpwd = :loginpwd")})
public class LoginEtkinlix implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "Login_id")
    private Integer loginid;
    @Basic(optional = false)
    @Column(name = "Login_kullanici_adi")
    private String loginkullaniciadi;
    @Basic(optional = false)
    @Column(name = "Login_pwd")
    private String loginpwd;

    public LoginEtkinlix() {
    }

    public LoginEtkinlix(Integer loginid) {
        this.loginid = loginid;
    }

    public LoginEtkinlix(Integer loginid, String loginkullaniciadi, String loginpwd) {
        this.loginid = loginid;
        this.loginkullaniciadi = loginkullaniciadi;
        this.loginpwd = loginpwd;
    }

    public Integer getLoginid() {
        return loginid;
    }

    public void setLoginid(Integer loginid) {
        this.loginid = loginid;
    }

    public String getLoginkullaniciadi() {
        return loginkullaniciadi;
    }

    public void setLoginkullaniciadi(String loginkullaniciadi) {
        this.loginkullaniciadi = loginkullaniciadi;
    }

    public String getLoginpwd() {
        return loginpwd;
    }

    public void setLoginpwd(String loginpwd) {
        this.loginpwd = loginpwd;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (loginid != null ? loginid.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof LoginEtkinlix)) {
            return false;
        }
        LoginEtkinlix other = (LoginEtkinlix) object;
        if ((this.loginid == null && other.loginid != null) || (this.loginid != null && !this.loginid.equals(other.loginid))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "etk\u0131nl\u0131x.LoginEtkinlix[ loginid=" + loginid + " ]";
    }
    
}
