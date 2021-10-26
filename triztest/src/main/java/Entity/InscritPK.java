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
public class InscritPK implements Serializable {

    @Basic(optional = false)
    @NotNull
    @Column(name = "IdEtudiant")
    private int idEtudiant;
    @Basic(optional = false)
    @NotNull
    @Column(name = "IdModule")
    private int idModule;

    public InscritPK() {
    }

    public InscritPK(int idEtudiant, int idModule) {
        this.idEtudiant = idEtudiant;
        this.idModule = idModule;
    }

    public int getIdEtudiant() {
        return idEtudiant;
    }

    public void setIdEtudiant(int idEtudiant) {
        this.idEtudiant = idEtudiant;
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
        hash += (int) idEtudiant;
        hash += (int) idModule;
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof InscritPK)) {
            return false;
        }
        InscritPK other = (InscritPK) object;
        if (this.idEtudiant != other.idEtudiant) {
            return false;
        }
        if (this.idModule != other.idModule) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Entity.InscritPK[ idEtudiant=" + idEtudiant + ", idModule=" + idModule + " ]";
    }
    
}
