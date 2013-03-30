/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package etkınlıx;

import java.io.Serializable;
import java.util.Collection;
import java.util.Date;
import javax.persistence.*;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author ECE
 */
@Entity
@Table(name = "Etkinlikler")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Etkinlikler.findAll", query = "SELECT e FROM Etkinlikler e"),
    @NamedQuery(name = "Etkinlikler.findByEadi", query = "SELECT e FROM Etkinlikler e WHERE e.eadi = :eadi"),
    @NamedQuery(name = "Etkinlikler.findByEid", query = "SELECT e FROM Etkinlikler e WHERE e.eid = :eid"),
    @NamedQuery(name = "Etkinlikler.findByEbastarih", query = "SELECT e FROM Etkinlikler e WHERE e.ebastarih = :ebastarih"),
    @NamedQuery(name = "Etkinlikler.findByEbittarih", query = "SELECT e FROM Etkinlikler e WHERE e.ebittarih = :ebittarih"),
    @NamedQuery(name = "Etkinlikler.findByEyonetmen", query = "SELECT e FROM Etkinlikler e WHERE e.eyonetmen = :eyonetmen"),
    @NamedQuery(name = "Etkinlikler.findByEsure", query = "SELECT e FROM Etkinlikler e WHERE e.esure = :esure"),
    @NamedQuery(name = "Etkinlikler.findByEyapim", query = "SELECT e FROM Etkinlikler e WHERE e.eyapim = :eyapim"),
    @NamedQuery(name = "Etkinlikler.findByEtur", query = "SELECT e FROM Etkinlikler e WHERE e.etur = :etur")})
public class Etkinlikler implements Serializable {
    private static final long serialVersionUID = 1L;
    @Basic(optional = false)
    @Column(name = "E_adi")
    private String eadi;
    @Id
    @Basic(optional = false)
    @Column(name = "E_id")
    private Integer eid;
    @Basic(optional = false)
    @Column(name = "E_bas_tarih")
    @Temporal(TemporalType.TIMESTAMP)
    private Date ebastarih;
    @Basic(optional = false)
    @Column(name = "E_bit_tarih")
    @Temporal(TemporalType.TIMESTAMP)
    private Date ebittarih;
    @Column(name = "E_yonetmen")
    private String eyonetmen;
    @Basic(optional = false)
    @Column(name = "E_sure")
    private int esure;
    @Column(name = "E_yapim")
    private String eyapim;
    @Column(name = "E_tur")
    private String etur;
    @JoinTable(name = "Etkinlikler_Salonlar", joinColumns = {
        @JoinColumn(name = "Etkinlik_tablo_id", referencedColumnName = "E_id")}, inverseJoinColumns = {
        @JoinColumn(name = "Salonlar_tablo_id", referencedColumnName = "Salon_id")})
    @ManyToMany
    private Collection<Salonlar> salonlarCollection;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "etkinlikTabloid")
    private Collection<Oylama> oylamaCollection;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "etkinlikTabloid")
    private Collection<Rezervasyon> rezervasyonCollection;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "etkinliktabloid")
    private Collection<Sanatcilar> sanatcilarCollection;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "etkinlikTabloid")
    private Collection<Yorumlar> yorumlarCollection;
    @JoinColumn(name = "E_Tur_id", referencedColumnName = "Tur_id")
    @ManyToOne(optional = false)
    private EtkinlikTur eTurid;

    public Etkinlikler() {
    }

    public Etkinlikler(Integer eid) {
        this.eid = eid;
    }

    public Etkinlikler(Integer eid, String eadi, Date ebastarih, Date ebittarih, int esure) {
        this.eid = eid;
        this.eadi = eadi;
        this.ebastarih = ebastarih;
        this.ebittarih = ebittarih;
        this.esure = esure;
    }

    public String getEadi() {
        return eadi;
    }

    public void setEadi(String eadi) {
        this.eadi = eadi;
    }

    public Integer getEid() {
        return eid;
    }

    public void setEid(Integer eid) {
        this.eid = eid;
    }

    public Date getEbastarih() {
        return ebastarih;
    }

    public void setEbastarih(Date ebastarih) {
        this.ebastarih = ebastarih;
    }

    public Date getEbittarih() {
        return ebittarih;
    }

    public void setEbittarih(Date ebittarih) {
        this.ebittarih = ebittarih;
    }

    public String getEyonetmen() {
        return eyonetmen;
    }

    public void setEyonetmen(String eyonetmen) {
        this.eyonetmen = eyonetmen;
    }

    public int getEsure() {
        return esure;
    }

    public void setEsure(int esure) {
        this.esure = esure;
    }

    public String getEyapim() {
        return eyapim;
    }

    public void setEyapim(String eyapim) {
        this.eyapim = eyapim;
    }

    public String getEtur() {
        return etur;
    }

    public void setEtur(String etur) {
        this.etur = etur;
    }

    @XmlTransient
    public Collection<Salonlar> getSalonlarCollection() {
        return salonlarCollection;
    }

    public void setSalonlarCollection(Collection<Salonlar> salonlarCollection) {
        this.salonlarCollection = salonlarCollection;
    }

    @XmlTransient
    public Collection<Oylama> getOylamaCollection() {
        return oylamaCollection;
    }

    public void setOylamaCollection(Collection<Oylama> oylamaCollection) {
        this.oylamaCollection = oylamaCollection;
    }

    @XmlTransient
    public Collection<Rezervasyon> getRezervasyonCollection() {
        return rezervasyonCollection;
    }

    public void setRezervasyonCollection(Collection<Rezervasyon> rezervasyonCollection) {
        this.rezervasyonCollection = rezervasyonCollection;
    }

    @XmlTransient
    public Collection<Sanatcilar> getSanatcilarCollection() {
        return sanatcilarCollection;
    }

    public void setSanatcilarCollection(Collection<Sanatcilar> sanatcilarCollection) {
        this.sanatcilarCollection = sanatcilarCollection;
    }

    @XmlTransient
    public Collection<Yorumlar> getYorumlarCollection() {
        return yorumlarCollection;
    }

    public void setYorumlarCollection(Collection<Yorumlar> yorumlarCollection) {
        this.yorumlarCollection = yorumlarCollection;
    }

    public EtkinlikTur getETurid() {
        return eTurid;
    }

    public void setETurid(EtkinlikTur eTurid) {
        this.eTurid = eTurid;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (eid != null ? eid.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Etkinlikler)) {
            return false;
        }
        Etkinlikler other = (Etkinlikler) object;
        if ((this.eid == null && other.eid != null) || (this.eid != null && !this.eid.equals(other.eid))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "etk\u0131nl\u0131x.Etkinlikler[ eid=" + eid + " ]";
    }
    
}
