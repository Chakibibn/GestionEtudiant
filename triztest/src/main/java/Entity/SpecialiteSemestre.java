/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Entity;

import java.io.Serializable;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author Winsido
 */
@Entity
@Table(name = "specialite_semestre")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "SpecialiteSemestre.findAll", query = "SELECT s FROM SpecialiteSemestre s")
    , @NamedQuery(name = "SpecialiteSemestre.findByIdSpecialite", query = "SELECT s FROM SpecialiteSemestre s WHERE s.specialiteSemestrePK.idSpecialite = :idSpecialite")
    , @NamedQuery(name = "SpecialiteSemestre.findByIdSemestre", query = "SELECT s FROM SpecialiteSemestre s WHERE s.specialiteSemestrePK.idSemestre = :idSemestre")})
public class SpecialiteSemestre implements Serializable {

    private static final long serialVersionUID = 1L;
    @EmbeddedId
    protected SpecialiteSemestrePK specialiteSemestrePK;

    public SpecialiteSemestre() {
    }

    public SpecialiteSemestre(SpecialiteSemestrePK specialiteSemestrePK) {
        this.specialiteSemestrePK = specialiteSemestrePK;
    }

    public SpecialiteSemestre(int idSpecialite, int idSemestre) {
        this.specialiteSemestrePK = new SpecialiteSemestrePK(idSpecialite, idSemestre);
    }

    public SpecialiteSemestrePK getSpecialiteSemestrePK() {
        return specialiteSemestrePK;
    }

    public void setSpecialiteSemestrePK(SpecialiteSemestrePK specialiteSemestrePK) {
        this.specialiteSemestrePK = specialiteSemestrePK;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (specialiteSemestrePK != null ? specialiteSemestrePK.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof SpecialiteSemestre)) {
            return false;
        }
        SpecialiteSemestre other = (SpecialiteSemestre) object;
        if ((this.specialiteSemestrePK == null && other.specialiteSemestrePK != null) || (this.specialiteSemestrePK != null && !this.specialiteSemestrePK.equals(other.specialiteSemestrePK))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Entity.SpecialiteSemestre[ specialiteSemestrePK=" + specialiteSemestrePK + " ]";
    }
    
}
