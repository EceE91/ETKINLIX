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
@Table(name = "Personel_Info")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "PersonelInfo.findAll", query = "SELECT p FROM PersonelInfo p"),
    @NamedQuery(name = "PersonelInfo.findById", query = "SELECT p FROM PersonelInfo p WHERE p.id = :id"),
    @NamedQuery(name = "PersonelInfo.findByAd", query = "SELECT p FROM PersonelInfo p WHERE p.ad = :ad"),
    @NamedQuery(name = "PersonelInfo.findBySoyad", query = "SELECT p FROM PersonelInfo p WHERE p.soyad = :soyad"),
    @NamedQuery(name = "PersonelInfo.findByCreditcarIBNN", query = "SELECT p FROM PersonelInfo p WHERE p.creditcarIBNN = :creditcarIBNN"),
    @NamedQuery(name = "PersonelInfo.findByAdress", query = "SELECT p FROM PersonelInfo p WHERE p.adress = :adress"),
    @NamedQuery(name = "PersonelInfo.findBySsn", query = "SELECT p FROM PersonelInfo p WHERE p.ssn = :ssn")})
public class PersonelInfo implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "Id")
    private Integer id;
    @Basic(optional = false)
    @Column(name = "Ad")
    private String ad;
    @Basic(optional = false)
    @Column(name = "Soyad")
    private String soyad;
    @Basic(optional = false)
    @Column(name = "creditcar_IBNN")
    private String creditcarIBNN;
    @Basic(optional = false)
    @Column(name = "Adress")
    private String adress;
    @Basic(optional = false)
    @Column(name = "Ssn")
    private String ssn;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "personelInfoid")
    private Collection<Rezervasyon> rezervasyonCollection;

    public PersonelInfo() {
    }

    public PersonelInfo(Integer id) {
        this.id = id;
    }

    public PersonelInfo(Integer id, String ad, String soyad, String creditcarIBNN, String adress, String ssn) {
        this.id = id;
        this.ad = ad;
        this.soyad = soyad;
        this.creditcarIBNN = creditcarIBNN;
        this.adress = adress;
        this.ssn = ssn;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getAd() {
        return ad;
    }

    public void setAd(String ad) {
        this.ad = ad;
    }

    public String getSoyad() {
        return soyad;
    }

    public void setSoyad(String soyad) {
        this.soyad = soyad;
    }

    public String getCreditcarIBNN() {
        return creditcarIBNN;
    }

    public void setCreditcarIBNN(String creditcarIBNN) {
        this.creditcarIBNN = creditcarIBNN;
    }

    public String getAdress() {
        return adress;
    }

    public void setAdress(String adress) {
        this.adress = adress;
    }

    public String getSsn() {
        return ssn;
    }

    public void setSsn(String ssn) {
        this.ssn = ssn;
    }

    @XmlTransient
    public Collection<Rezervasyon> getRezervasyonCollection() {
        return rezervasyonCollection;
    }

    public void setRezervasyonCollection(Collection<Rezervasyon> rezervasyonCollection) {
        this.rezervasyonCollection = rezervasyonCollection;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (id != null ? id.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof PersonelInfo)) {
            return false;
        }
        PersonelInfo other = (PersonelInfo) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "etk\u0131nl\u0131x.PersonelInfo[ id=" + id + " ]";
    }
    
}
