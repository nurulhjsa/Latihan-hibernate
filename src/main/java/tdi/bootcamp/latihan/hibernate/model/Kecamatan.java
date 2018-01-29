/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tdi.bootcamp.latihan.hibernate.model;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

/**
 *
 * @author rodiyatunmardiyah
 */
@Entity
@Table(name="m_kecamatan", schema="public")
public class Kecamatan extends BaseClass{
    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    @Column(name="id_kecamatan", updatable = false, nullable = false)
    private int idKec;
    
    @Column(name = "nm_kec", length= 150)
    private String namaKec;
    
    @OneToOne(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    @JoinColumn (name = "id_kota_kab")
    private Kota kotaKabupaten ;

    public int getIdKec() {
        return idKec;
    }

    public void setIdKec(int idKec) {
        this.idKec = idKec;
    }

    public String getNamaKec() {
        return namaKec;
    }

    public void setNamaKec(String namaKec) {
        this.namaKec = namaKec;
    }

    public Kota getKotaKabupaten() {
        return kotaKabupaten;
    }

    public void setKotaKabupaten(Kota kotaKabupaten) {
        this.kotaKabupaten = kotaKabupaten;
    }

    public Object getKab() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    public Object getKotakabupaten() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}