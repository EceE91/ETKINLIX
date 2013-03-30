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
@Table(name = "Sanatcilar")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Sanatcilar.findAll", query = "SELECT s FROM Sanatcilar s"),
    @NamedQuery(name = "Sanatcilar.findBySanatciid", query = "SELECT s FROM Sanatcilar s WHERE s.sanatciid = :sanatciid"),
    @NamedQuery(name = "Sanatcilar.findBySanatciAdi", query = "SELECT s FROM Sanatcilar s WHERE s.sanatciAdi = :sanatciAdi"),
    @NamedQuery(name = "Sanatcilar.findBySanatciSoyadi", query = "SELECT s FROM Sanatcilar s WHERE s.sanatciSoyadi = :sanatciSoyadi")})
public class Sanatcilar implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "Sanatci_id")
    private Integer sanatciid;
    @Basic(optional = false)
    @Column(name = "Sanatci_Adi")
    private String sanatciAdi;
    @Basic(optional = false)
    @Column(name = "Sanatci_Soyadi")
    private String sanatciSoyadi;
    @JoinColumn(name = "Etkinlik_tablo_id", referencedColumnName = "E_id")
    @ManyToOne(optional = false)
    private Etkinlikler etkinliktabloid;

    public Sanatcilar() {
    }

    public Sanatcilar(Integer sanatciid) {
        this.sanatciid = sanatciid;
    }

    public Sanatcilar(Integer sanatciid, String sanatciAdi, String sanatciSoyadi) {
        this.sanatciid = sanatciid;
        this.sanatciAdi = sanatciAdi;
        this.sanatciSoyadi = sanatciSoyadi;
    }

    public Integer getSanatciid() {
        return sanatciid;
    }

    public void setSanatciid(Integer sanatciid) {
        this.sanatciid = sanatciid;
    }

    public String getSanatciAdi() {
        return sanatciAdi;
    }

    public void setSanatciAdi(String sanatciAdi) {
        this.sanatciAdi = sanatciAdi;
    }

    public String getSanatciSoyadi() {
        return sanatciSoyadi;
    }

    public void setSanatciSoyadi(String sanatciSoyadi) {
        this.sanatciSoyadi = sanatciSoyadi;
    }

    public Etkinlikler getEtkinliktabloid() {
        return etkinliktabloid;
    }

    public void setEtkinliktabloid(Etkinlikler etkinliktabloid) {
        this.etkinliktabloid = etkinliktabloid;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (sanatciid != null ? sanatciid.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Sanatcilar)) {
            return false;
        }
        Sanatcilar other = (Sanatcilar) object;
        if ((this.sanatciid == null && other.sanatciid != null) || (this.sanatciid != null && !this.sanatciid.equals(other.sanatciid))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "etk\u0131nl\u0131x.Sanatcilar[ sanatciid=" + sanatciid + " ]";
    }
    
}
