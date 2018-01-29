/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tdi.bootcamp.latihan.hibernate.model;

import java.io.Serializable;
import java.sql.Timestamp;
import javax.persistence.Column;
import javax.persistence.MappedSuperclass;

/**
 *
 * @author rodiyatunmardiyah
 */
@MappedSuperclass
public class BaseClass implements Serializable{
    
    @Column(name = "id_update", length = 30)
    private String idUpdate;
    
    @Column(name = "d_update")
    private Timestamp dUpdate;
    
    @Column(name = "d_entry")
    private Timestamp dEntry;
    
    @Column(name = "id_entry", length = 30)
    private String idEntry;

    public String getIdUpdate() {
        return idUpdate;
    }

    public void setIdUpdate(String idUpdate) {
        this.idUpdate = idUpdate;
    }

    public Timestamp getdUpdate() {
        return dUpdate;
    }

    public void setdUpdate(Timestamp dUpdate) {
        this.dUpdate = dUpdate;
    }

    public Timestamp getdEntry() {
        return dEntry;
    }

    public void setdEntry(Timestamp dEntry) {
        this.dEntry = dEntry;
    }

    public String getIdEntry() {
        return idEntry;
    }

    public void setIdEntry(String idEntry) {
        this.idEntry = idEntry;
    }
}
