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
@Table(name = "inscrit")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Inscrit.findAll", query = "SELECT i FROM Inscrit i")
    , @NamedQuery(name = "Inscrit.findByIdEtudiant", query = "SELECT i FROM Inscrit i WHERE i.inscritPK.idEtudiant = :idEtudiant")
    , @NamedQuery(name = "Inscrit.findByIdModule", query = "SELECT i FROM Inscrit i WHERE i.inscritPK.idModule = :idModule")})
public class Inscrit implements Serializable {

    private static final long serialVersionUID = 1L;
    @EmbeddedId
    protected InscritPK inscritPK;

    public Inscrit() {
    }

    public Inscrit(InscritPK inscritPK) {
        this.inscritPK = inscritPK;
    }

    public Inscrit(int idEtudiant, int idModule) {
        this.inscritPK = new InscritPK(idEtudiant, idModule);
    }

    public InscritPK getInscritPK() {
        return inscritPK;
    }

    public void setInscritPK(InscritPK inscritPK) {
        this.inscritPK = inscritPK;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (inscritPK != null ? inscritPK.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Inscrit)) {
            return false;
        }
        Inscrit other = (Inscrit) object;
        if ((this.inscritPK == null && other.inscritPK != null) || (this.inscritPK != null && !this.inscritPK.equals(other.inscritPK))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Entity.Inscrit[ inscritPK=" + inscritPK + " ]";
    }
    
}
