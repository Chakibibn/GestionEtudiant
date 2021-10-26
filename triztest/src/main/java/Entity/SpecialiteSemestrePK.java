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
public class SpecialiteSemestrePK implements Serializable {

    @Basic(optional = false)
    @NotNull
    @Column(name = "IdSpecialite")
    private int idSpecialite;
    @Basic(optional = false)
    @NotNull
    @Column(name = "IdSemestre")
    private int idSemestre;

    public SpecialiteSemestrePK() {
    }

    public SpecialiteSemestrePK(int idSpecialite, int idSemestre) {
        this.idSpecialite = idSpecialite;
        this.idSemestre = idSemestre;
    }

    public int getIdSpecialite() {
        return idSpecialite;
    }

    public void setIdSpecialite(int idSpecialite) {
        this.idSpecialite = idSpecialite;
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
        hash += (int) idSpecialite;
        hash += (int) idSemestre;
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof SpecialiteSemestrePK)) {
            return false;
        }
        SpecialiteSemestrePK other = (SpecialiteSemestrePK) object;
        if (this.idSpecialite != other.idSpecialite) {
            return false;
        }
        if (this.idSemestre != other.idSemestre) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Entity.SpecialiteSemestrePK[ idSpecialite=" + idSpecialite + ", idSemestre=" + idSemestre + " ]";
    }
    
}
