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
@Table(name = "Rezervasyon")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Rezervasyon.findAll", query = "SELECT r FROM Rezervasyon r"),
    @NamedQuery(name = "Rezervasyon.findByRid", query = "SELECT r FROM Rezervasyon r WHERE r.rid = :rid"),
    @NamedQuery(name = "Rezervasyon.findByRkoltukno", query = "SELECT r FROM Rezervasyon r WHERE r.rkoltukno = :rkoltukno"),
    @NamedQuery(name = "Rezervasyon.findByRtarih", query = "SELECT r FROM Rezervasyon r WHERE r.rtarih = :rtarih")})
public class Rezervasyon implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "R_id")
    private Integer rid;
    @Basic(optional = false)
    @Column(name = "R_koltuk_no")
    private int rkoltukno;
    @Basic(optional = false)
    @Column(name = "R_tarih")
    @Temporal(TemporalType.TIMESTAMP)
    private Date rtarih;
    @JoinColumn(name = "Salon_tablo_id", referencedColumnName = "Salon_id")
    @ManyToOne
    private Salonlar salontabloid;
    @JoinColumn(name = "Personel_Info_id", referencedColumnName = "Id")
    @ManyToOne(optional = false)
    private PersonelInfo personelInfoid;
    @JoinColumn(name = "Etkinlik_Tablo_id", referencedColumnName = "E_id")
    @ManyToOne(optional = false)
    private Etkinlikler etkinlikTabloid;

    public Rezervasyon() {
    }

    public Rezervasyon(Integer rid) {
        this.rid = rid;
    }

    public Rezervasyon(Integer rid, int rkoltukno, Date rtarih) {
        this.rid = rid;
        this.rkoltukno = rkoltukno;
        this.rtarih = rtarih;
    }

    public Integer getRid() {
        return rid;
    }

    public void setRid(Integer rid) {
        this.rid = rid;
    }

    public int getRkoltukno() {
        return rkoltukno;
    }

    public void setRkoltukno(int rkoltukno) {
        this.rkoltukno = rkoltukno;
    }

    public Date getRtarih() {
        return rtarih;
    }

    public void setRtarih(Date rtarih) {
        this.rtarih = rtarih;
    }

    public Salonlar getSalontabloid() {
        return salontabloid;
    }

    public void setSalontabloid(Salonlar salontabloid) {
        this.salontabloid = salontabloid;
    }

    public PersonelInfo getPersonelInfoid() {
        return personelInfoid;
    }

    public void setPersonelInfoid(PersonelInfo personelInfoid) {
        this.personelInfoid = personelInfoid;
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
        hash += (rid != null ? rid.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Rezervasyon)) {
            return false;
        }
        Rezervasyon other = (Rezervasyon) object;
        if ((this.rid == null && other.rid != null) || (this.rid != null && !this.rid.equals(other.rid))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "etk\u0131nl\u0131x.Rezervasyon[ rid=" + rid + " ]";
    }
    
}
