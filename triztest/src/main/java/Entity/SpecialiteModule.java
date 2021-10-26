/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Entity;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author Winsido
 */
@Entity
@Table(name = "specialite_module")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "SpecialiteModule.findAll", query = "SELECT s FROM SpecialiteModule s")
    , @NamedQuery(name = "SpecialiteModule.findByIdSpecialte", query = "SELECT s FROM SpecialiteModule s WHERE s.specialiteModulePK.idSpecialte = :idSpecialte")
    , @NamedQuery(name = "SpecialiteModule.findByIdModule", query = "SELECT s FROM SpecialiteModule s WHERE s.specialiteModulePK.idModule = :idModule")
    , @NamedQuery(name = "SpecialiteModule.findByIdSemestre", query = "SELECT s FROM SpecialiteModule s WHERE s.idSemestre = :idSemestre")})
public class SpecialiteModule implements Serializable {

    private static final long serialVersionUID = 1L;
    @EmbeddedId
    protected SpecialiteModulePK specialiteModulePK;
    @Basic(optional = false)
    @NotNull
    @Column(name = "IdSemestre")
    private int idSemestre;

    public SpecialiteModule() {
    }

    public SpecialiteModule(SpecialiteModulePK specialiteModulePK) {
        this.specialiteModulePK = specialiteModulePK;
    }

    public SpecialiteModule(SpecialiteModulePK specialiteModulePK, int idSemestre) {
        this.specialiteModulePK = specialiteModulePK;
        this.idSemestre = idSemestre;
    }

    public SpecialiteModule(int idSpecialte, int idModule) {
        this.specialiteModulePK = new SpecialiteModulePK(idSpecialte, idModule);
    }

    public SpecialiteModulePK getSpecialiteModulePK() {
        return specialiteModulePK;
    }

    public void setSpecialiteModulePK(SpecialiteModulePK specialiteModulePK) {
        this.specialiteModulePK = specialiteModulePK;
    }

    public int getIdSemestre() {
        return idSemestre;
    }

    public void setIdSemestre(int idSemestre) {
        this.idSemestre = idSemestre;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (specialiteModulePK != null ? specialiteModulePK.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof SpecialiteModule)) {
            return false;
        }
        SpecialiteModule other = (SpecialiteModule) object;
        if ((this.specialiteModulePK == null && other.specialiteModulePK != null) || (this.specialiteModulePK != null && !this.specialiteModulePK.equals(other.specialiteModulePK))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Entity.SpecialiteModule[ specialiteModulePK=" + specialiteModulePK + " ]";
    }
    
}
