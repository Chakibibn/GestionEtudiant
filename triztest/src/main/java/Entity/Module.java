/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Entity;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author Winsido
 */
@Entity
@Table(name = "module")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Module.findAll", query = "SELECT m FROM Module m")
    , @NamedQuery(name = "Module.findByIdModule", query = "SELECT m FROM Module m WHERE m.idModule = :idModule")
    , @NamedQuery(name = "Module.findByNomModule", query = "SELECT m FROM Module m WHERE m.nomModule = :nomModule")
    , @NamedQuery(name = "Module.findByCoeif", query = "SELECT m FROM Module m WHERE m.coeif = :coeif")
    , @NamedQuery(name = "Module.findByCredit", query = "SELECT m FROM Module m WHERE m.credit = :credit")})
public class Module implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "IdModule")
    private Integer idModule;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 30)
    @Column(name = "NomModule")
    private String nomModule;
    @Basic(optional = false)
    @NotNull
    @Column(name = "coeif")
    private int coeif;
    @Basic(optional = false)
    @NotNull
    @Column(name = "credit")
    private int credit;

    public Module() {
    }

    public Module(Integer idModule) {
        this.idModule = idModule;
    }

    public Module(Integer idModule, String nomModule, int coeif, int credit) {
        this.idModule = idModule;
        this.nomModule = nomModule;
        this.coeif = coeif;
        this.credit = credit;
    }

    public Integer getIdModule() {
        return idModule;
    }

    public void setIdModule(Integer idModule) {
        this.idModule = idModule;
    }

    public String getNomModule() {
        return nomModule;
    }

    public void setNomModule(String nomModule) {
        this.nomModule = nomModule;
    }

    public int getCoeif() {
        return coeif;
    }

    public void setCoeif(int coeif) {
        this.coeif = coeif;
    }

    public int getCredit() {
        return credit;
    }

    public void setCredit(int credit) {
        this.credit = credit;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idModule != null ? idModule.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Module)) {
            return false;
        }
        Module other = (Module) object;
        if ((this.idModule == null && other.idModule != null) || (this.idModule != null && !this.idModule.equals(other.idModule))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Entity.Module[ idModule=" + idModule + " ]";
    }
    
}
