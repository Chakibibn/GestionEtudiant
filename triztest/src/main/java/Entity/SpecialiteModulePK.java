/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Entity;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Embeddable;
import javax.validation.constraints.NotNull;

/**
 *
 * @author Winsido
 */
@Embeddable
public class SpecialiteModulePK implements Serializable {

    @Basic(optional = false)
    @NotNull
    @Column(name = "IdSpecialte")
    private int idSpecialte;
    @Basic(optional = false)
    @NotNull
    @Column(name = "IdModule")
    private int idModule;

    public SpecialiteModulePK() {
    }

    public SpecialiteModulePK(int idSpecialte, int idModule) {
        this.idSpecialte = idSpecialte;
        this.idModule = idModule;
    }

    public int getIdSpecialte() {
        return idSpecialte;
    }

    public void setIdSpecialte(int idSpecialte) {
        this.idSpecialte = idSpecialte;
    }

    public int getIdModule() {
        return idModule;
    }

    public void setIdModule(int idModule) {
        this.idModule = idModule;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (int) idSpecialte;
        hash += (int) idModule;
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof SpecialiteModulePK)) {
            return false;
        }
        SpecialiteModulePK other = (SpecialiteModulePK) object;
        if (this.idSpecialte != other.idSpecialte) {
            return false;
        }
        if (this.idModule != other.idModule) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Entity.SpecialiteModulePK[ idSpecialte=" + idSpecialte + ", idModule=" + idModule + " ]";
    }
    
}
