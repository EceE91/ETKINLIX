/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package etkınlıx;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.*;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author ECE
 */
@Entity
@Table(name = "Yorumlar")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Yorumlar.findAll", query = "SELECT y FROM Yorumlar y"),
    @NamedQuery(name = "Yorumlar.findByYorumid", query = "SELECT y FROM Yorumlar y WHERE y.yorumid = :yorumid"),
    @NamedQuery(name = "Yorumlar.findByYorumyapankisimail", query = "SELECT y FROM Yorumlar y WHERE y.yorumyapankisimail = :yorumyapankisimail"),
    @NamedQuery(name = "Yorumlar.findByYorumtarih", query = "SELECT y FROM Yorumlar y WHERE y.yorumtarih = :yorumtarih"),
    @NamedQuery(name = "Yorumlar.findByYorum", query = "SELECT y FROM Yorumlar y WHERE y.yorum = :yorum")})
public class Yorumlar implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "Yorum_id")
    private Integer yorumid;
    @Basic(optional = false)
    @Column(name = "Yorum_yapan_kisi_mail")
    private String yorumyapankisimail;
    @Basic(optional = false)
    @Column(name = "Yorum_tarih")
    @Temporal(TemporalType.TIMESTAMP)
    private Date yorumtarih;
    @Basic(optional = false)
    @Column(name = "Yorum")
    private String yorum;
    @JoinColumn(name = "Etkinlik_Tablo_id", referencedColumnName = "E_id")
    @ManyToOne(optional = false)
    private Etkinlikler etkinlikTabloid;

    public Yorumlar() {
    }

    public Yorumlar(Integer yorumid) {
        this.yorumid = yorumid;
    }

    public Yorumlar(Integer yorumid, String yorumyapankisimail, Date yorumtarih, String yorum) {
        this.yorumid = yorumid;
        this.yorumyapankisimail = yorumyapankisimail;
        this.yorumtarih = yorumtarih;
        this.yorum = yorum;
    }

    public Integer getYorumid() {
        return yorumid;
    }

    public void setYorumid(Integer yorumid) {
        this.yorumid = yorumid;
    }

    public String getYorumyapankisimail() {
        return yorumyapankisimail;
    }

    public void setYorumyapankisimail(String yorumyapankisimail) {
        this.yorumyapankisimail = yorumyapankisimail;
    }

    public Date getYorumtarih() {
        return yorumtarih;
    }

    public void setYorumtarih(Date yorumtarih) {
        this.yorumtarih = yorumtarih;
    }

    public String getYorum() {
        return yorum;
    }

    public void setYorum(String yorum) {
        this.yorum = yorum;
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
        hash += (yorumid != null ? yorumid.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Yorumlar)) {
            return false;
        }
        Yorumlar other = (Yorumlar) object;
        if ((this.yorumid == null && other.yorumid != null) || (this.yorumid != null && !this.yorumid.equals(other.yorumid))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "etk\u0131nl\u0131x.Yorumlar[ yorumid=" + yorumid + " ]";
    }
    
}
