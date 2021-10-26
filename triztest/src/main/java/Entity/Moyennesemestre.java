/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Entity;

import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author Winsido
 */
@Entity
@Table(name = "moyennesemestre")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Moyennesemestre.findAll", query = "SELECT m FROM Moyennesemestre m")
    , @NamedQuery(name = "Moyennesemestre.findByIdEtudiant", query = "SELECT m FROM Moyennesemestre m WHERE m.moyennesemestrePK.idEtudiant = :idEtudiant")
    , @NamedQuery(name = "Moyennesemestre.findByIdSemestre", query = "SELECT m FROM Moyennesemestre m WHERE m.moyennesemestrePK.idSemestre = :idSemestre")
    , @NamedQuery(name = "Moyennesemestre.findByMoyenne", query = "SELECT m FROM Moyennesemestre m WHERE m.moyenne = :moyenne")})
public class Moyennesemestre implements Serializable {

    private static final long serialVersionUID = 1L;
    @EmbeddedId
    protected MoyennesemestrePK moyennesemestrePK;
    @Size(max = 10)
    @Column(name = "moyenne")
    private String moyenne;

    public Moyennesemestre() {
    }

    public Moyennesemestre(MoyennesemestrePK moyennesemestrePK) {
        this.moyennesemestrePK = moyennesemestrePK;
    }

    public Moyennesemestre(int idEtudiant, int idSemestre) {
        this.moyennesemestrePK = new MoyennesemestrePK(idEtudiant, idSemestre);
    }

    public MoyennesemestrePK getMoyennesemestrePK() {
        return moyennesemestrePK;
    }

    public void setMoyennesemestrePK(MoyennesemestrePK moyennesemestrePK) {
        this.moyennesemestrePK = moyennesemestrePK;
    }

    public String getMoyenne() {
        return moyenne;
    }

    public void setMoyenne(String moyenne) {
        this.moyenne = moyenne;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (moyennesemestrePK != null ? moyennesemestrePK.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Moyennesemestre)) {
            return false;
        }
        Moyennesemestre other = (Moyennesemestre) object;
        if ((this.moyennesemestrePK == null && other.moyennesemestrePK != null) || (this.moyennesemestrePK != null && !this.moyennesemestrePK.equals(other.moyennesemestrePK))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Entity.Moyennesemestre[ moyennesemestrePK=" + moyennesemestrePK + " ]";
    }
    
}
