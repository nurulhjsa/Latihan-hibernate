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
@Table(name="m_kelurahan", schema="public")
public class Kelurahan extends BaseClass{
    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    @Column(name="id_kelurahan", updatable = false, nullable = false)
    private long idKel;
    
    @Column(name = "nm_keluraha", length= 150)
    private String namaKel;
    
    @OneToOne(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    @JoinColumn (name = "id_kec")
    private Kecamatan kecamatan ;

    public long getIdKel() {
        return idKel;
    }

    public void setIdKel(long idKel) {
        this.idKel = idKel;
    }

    public String getNamaKel() {
        return namaKel;
    }

    public void setNamaKel(String namaKel) {
        this.namaKel = namaKel;
    }

    public Kecamatan getKecamatan() {
        return kecamatan;
    }

    public void setKecamatan(Kecamatan kecamatan) {
        this.kecamatan = kecamatan;
    }
}