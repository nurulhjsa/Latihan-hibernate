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
import javax.persistence.OneToOne;
import javax.persistence.Table;

/**
 *
 * @author rodiyatunmardiyah
 */
@Entity
@Table(name="m_provinsi", schema="public")
public class Provinsi extends BaseClass{
    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    @Column(name="id_provinsi", updatable = false, nullable = false)
    private int idProv;
    
    @Column(name = "nm_provinsi", length= 150)
    private String namaProv;
    
    @Column (name = "id_negara", updatable = false, nullable = false)
    private int idNeg;

    public int getIdProv() {
        return idProv;
    }

    public void setIdProv(int idProv) {
        this.idProv = idProv;
    }

    public String getNamaProv() {
        return namaProv;
    }

    public void setNamaProv(String namaProv) {
        this.namaProv = namaProv;
    }

    public int getIdNeg() {
        return idNeg;
    }

    public void setIdNeg(int idNeg) {
        this.idNeg = idNeg;
    }
}