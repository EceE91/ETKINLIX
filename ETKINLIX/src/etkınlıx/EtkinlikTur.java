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
@Table(name = "Etkinlik_Tur")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "EtkinlikTur.findAll", query = "SELECT e FROM EtkinlikTur e"),
    @NamedQuery(name = "EtkinlikTur.findByTurid", query = "SELECT e FROM EtkinlikTur e WHERE e.turid = :turid"),
    @NamedQuery(name = "EtkinlikTur.findByTuradi", query = "SELECT e FROM EtkinlikTur e WHERE e.turadi = :turadi")})
public class EtkinlikTur implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "Tur_id")
    private Integer turid;
    @Basic(optional = false)
    @Column(name = "Tur_adi")
    private String turadi;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "eTurid")
    private Collection<Etkinlikler> etkinliklerCollection;

    public EtkinlikTur() {
    }

    public EtkinlikTur(Integer turid) {
        this.turid = turid;
    }

    public EtkinlikTur(Integer turid, String turadi) {
        this.turid = turid;
        this.turadi = turadi;
    }

    public Integer getTurid() {
        return turid;
    }

    public void setTurid(Integer turid) {
        this.turid = turid;
    }

    public String getTuradi() {
        return turadi;
    }

    public void setTuradi(String turadi) {
        this.turadi = turadi;
    }

    @XmlTransient
    public Collection<Etkinlikler> getEtkinliklerCollection() {
        return etkinliklerCollection;
    }

    public void setEtkinliklerCollection(Collection<Etkinlikler> etkinliklerCollection) {
        this.etkinliklerCollection = etkinliklerCollection;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (turid != null ? turid.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof EtkinlikTur)) {
            return false;
        }
        EtkinlikTur other = (EtkinlikTur) object;
        if ((this.turid == null && other.turid != null) || (this.turid != null && !this.turid.equals(other.turid))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "etk\u0131nl\u0131x.EtkinlikTur[ turid=" + turid + " ]";
    }
    
}
