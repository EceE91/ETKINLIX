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
@Table(name = "Sehirler")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Sehirler.findAll", query = "SELECT s FROM Sehirler s"),
    @NamedQuery(name = "Sehirler.findBySehirid", query = "SELECT s FROM Sehirler s WHERE s.sehirid = :sehirid"),
    @NamedQuery(name = "Sehirler.findBySehirAdi", query = "SELECT s FROM Sehirler s WHERE s.sehirAdi = :sehirAdi")})
public class Sehirler implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "Sehir_id")
    private Integer sehirid;
    @Basic(optional = false)
    @Column(name = "Sehir_Adi")
    private String sehirAdi;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "sehirtabloid")
    private Collection<Salonlar> salonlarCollection;

    public Sehirler() {
    }

    public Sehirler(Integer sehirid) {
        this.sehirid = sehirid;
    }

    public Sehirler(Integer sehirid, String sehirAdi) {
        this.sehirid = sehirid;
        this.sehirAdi = sehirAdi;
    }

    public Integer getSehirid() {
        return sehirid;
    }

    public void setSehirid(Integer sehirid) {
        this.sehirid = sehirid;
    }

    public String getSehirAdi() {
        return sehirAdi;
    }

    public void setSehirAdi(String sehirAdi) {
        this.sehirAdi = sehirAdi;
    }

    @XmlTransient
    public Collection<Salonlar> getSalonlarCollection() {
        return salonlarCollection;
    }

    public void setSalonlarCollection(Collection<Salonlar> salonlarCollection) {
        this.salonlarCollection = salonlarCollection;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (sehirid != null ? sehirid.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Sehirler)) {
            return false;
        }
        Sehirler other = (Sehirler) object;
        if ((this.sehirid == null && other.sehirid != null) || (this.sehirid != null && !this.sehirid.equals(other.sehirid))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "etk\u0131nl\u0131x.Sehirler[ sehirid=" + sehirid + " ]";
    }
    
}
