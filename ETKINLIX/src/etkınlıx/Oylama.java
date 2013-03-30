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
@Table(name = "Oylama")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Oylama.findAll", query = "SELECT o FROM Oylama o"),
    @NamedQuery(name = "Oylama.findByOyid", query = "SELECT o FROM Oylama o WHERE o.oyid = :oyid"),
    @NamedQuery(name = "Oylama.findByOyrating", query = "SELECT o FROM Oylama o WHERE o.oyrating = :oyrating")})
public class Oylama implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "Oy_id")
    private Integer oyid;
    @Basic(optional = false)
    @Column(name = "Oy_rating")
    private int oyrating;
    @JoinColumn(name = "Etkinlik_Tablo_id", referencedColumnName = "E_id")
    @ManyToOne(optional = false)
    private Etkinlikler etkinlikTabloid;

    public Oylama() {
    }

    public Oylama(Integer oyid) {
        this.oyid = oyid;
    }

    public Oylama(Integer oyid, int oyrating) {
        this.oyid = oyid;
        this.oyrating = oyrating;
    }

    public Integer getOyid() {
        return oyid;
    }

    public void setOyid(Integer oyid) {
        this.oyid = oyid;
    }

    public int getOyrating() {
        return oyrating;
    }

    public void setOyrating(int oyrating) {
        this.oyrating = oyrating;
    }

    public Etkinlikler getEtkinlikTabloid() {
        return etkinlikTabloid;
    }

    public void setEtkinlikTabloid(Etkinlikler etkinlikTabloid) {
        this.etkinlikTabloid = etkinlikTabloid;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (oyid != null ? oyid.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Oylama)) {
            return false;
        }
        Oylama other = (Oylama) object;
        if ((this.oyid == null && other.oyid != null) || (this.oyid != null && !this.oyid.equals(other.oyid))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "etk\u0131nl\u0131x.Oylama[ oyid=" + oyid + " ]";
    }
    
}
