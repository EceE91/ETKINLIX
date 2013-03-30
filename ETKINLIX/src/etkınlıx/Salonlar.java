/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package etkınlıx;

import java.io.Serializable;
import java.util.Collection;
import javax.persistence.*;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author ECE
 */
@Entity
@Table(name = "Salonlar")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Salonlar.findAll", query = "SELECT s FROM Salonlar s"),
    @NamedQuery(name = "Salonlar.findBySalonadi", query = "SELECT s FROM Salonlar s WHERE s.salonadi = :salonadi"),
    @NamedQuery(name = "Salonlar.findBySalonkontenjan", query = "SELECT s FROM Salonlar s WHERE s.salonkontenjan = :salonkontenjan"),
    @NamedQuery(name = "Salonlar.findBySalonid", query = "SELECT s FROM Salonlar s WHERE s.salonid = :salonid")})
public class Salonlar implements Serializable {
    private static final long serialVersionUID = 1L;
    @Basic(optional = false)
    @Column(name = "Salon_adi")
    private String salonadi;
    @Basic(optional = false)
    @Column(name = "Salon_kontenjan")
    private int salonkontenjan;
    @Id
    @Basic(optional = false)
    @Column(name = "Salon_id")
    private Integer salonid;
    @ManyToMany(mappedBy = "salonlarCollection")
    private Collection<Etkinlikler> etkinliklerCollection;
    @OneToMany(mappedBy = "salontabloid")
    private Collection<Rezervasyon> rezervasyonCollection;
    @JoinColumn(name = "Sehir_tablo_id", referencedColumnName = "Sehir_id")
    @ManyToOne(optional = false)
    private Sehirler sehirtabloid;

    public Salonlar() {
    }

    public Salonlar(Integer salonid) {
        this.salonid = salonid;
    }

    public Salonlar(Integer salonid, String salonadi, int salonkontenjan) {
        this.salonid = salonid;
        this.salonadi = salonadi;
        this.salonkontenjan = salonkontenjan;
    }

    public String getSalonadi() {
        return salonadi;
    }

    public void setSalonadi(String salonadi) {
        this.salonadi = salonadi;
    }

    public int getSalonkontenjan() {
        return salonkontenjan;
    }

    public void setSalonkontenjan(int salonkontenjan) {
        this.salonkontenjan = salonkontenjan;
    }

    public Integer getSalonid() {
        return salonid;
    }

    public void setSalonid(Integer salonid) {
        this.salonid = salonid;
    }

    @XmlTransient
    public Collection<Etkinlikler> getEtkinliklerCollection() {
        return etkinliklerCollection;
    }

    public void setEtkinliklerCollection(Collection<Etkinlikler> etkinliklerCollection) {
        this.etkinliklerCollection = etkinliklerCollection;
    }

    @XmlTransient
    public Collection<Rezervasyon> getRezervasyonCollection() {
        return rezervasyonCollection;
    }

    public void setRezervasyonCollection(Collection<Rezervasyon> rezervasyonCollection) {
        this.rezervasyonCollection = rezervasyonCollection;
    }

    public Sehirler getSehirtabloid() {
        return sehirtabloid;
    }

    public void setSehirtabloid(Sehirler sehirtabloid) {
        this.sehirtabloid = sehirtabloid;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (salonid != null ? salonid.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Salonlar)) {
            return false;
        }
        Salonlar other = (Salonlar) object;
        if ((this.salonid == null && other.salonid != null) || (this.salonid != null && !this.salonid.equals(other.salonid))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "etk\u0131nl\u0131x.Salonlar[ salonid=" + salonid + " ]";
    }
    
}
