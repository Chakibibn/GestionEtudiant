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
public class MoyennesemestrePK implements Serializable {

    @Basic(optional = false)
    @NotNull
    @Column(name = "IdEtudiant")
    private int idEtudiant;
    @Basic(optional = false)
    @NotNull
    @Column(name = "IdSemestre")
    private int idSemestre;

    public MoyennesemestrePK() {
    }

    public MoyennesemestrePK(int idEtudiant, int idSemestre) {
        this.idEtudiant = idEtudiant;
        this.idSemestre = idSemestre;
    }

    public int getIdEtudiant() {
        return idEtudiant;
    }

    public void setIdEtudiant(int idEtudiant) {
        this.idEtudiant = idEtudiant;
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
        hash += (int) idEtudiant;
        hash += (int) idSemestre;
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof MoyennesemestrePK)) {
            return false;
        }
        MoyennesemestrePK other = (MoyennesemestrePK) object;
        if (this.idEtudiant != other.idEtudiant) {
            return false;
        }
        if (this.idSemestre != other.idSemestre) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Entity.MoyennesemestrePK[ idEtudiant=" + idEtudiant + ", idSemestre=" + idSemestre + " ]";
    }
    
}
