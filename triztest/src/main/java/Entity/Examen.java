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
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author Winsido
 */
@Entity
@Table(name = "examen")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Examen.findAll", query = "SELECT e FROM Examen e")
    , @NamedQuery(name = "Examen.findByIdEtudiant", query = "SELECT e FROM Examen e WHERE e.examenPK.idEtudiant = :idEtudiant")
    , @NamedQuery(name = "Examen.findByIdModule", query = "SELECT e FROM Examen e WHERE e.examenPK.idModule = :idModule")
    , @NamedQuery(name = "Examen.findByNoteExamen", query = "SELECT e FROM Examen e WHERE e.noteExamen = :noteExamen")})
public class Examen implements Serializable {

    private static final long serialVersionUID = 1L;
    @EmbeddedId
    protected ExamenPK examenPK;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Column(name = "NoteExamen")
    private Float noteExamen;

    public Examen() {
    }

    public Examen(ExamenPK examenPK) {
        this.examenPK = examenPK;
    }

    public Examen(int idEtudiant, int idModule) {
        this.examenPK = new ExamenPK(idEtudiant, idModule);
    }

    public ExamenPK getExamenPK() {
        return examenPK;
    }

    public void setExamenPK(ExamenPK examenPK) {
        this.examenPK = examenPK;
    }

    public Float getNoteExamen() {
        return noteExamen;
    }

    public void setNoteExamen(Float noteExamen) {
        this.noteExamen = noteExamen;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (examenPK != null ? examenPK.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Examen)) {
            return false;
        }
        Examen other = (Examen) object;
        if ((this.examenPK == null && other.examenPK != null) || (this.examenPK != null && !this.examenPK.equals(other.examenPK))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Entity.Examen[ examenPK=" + examenPK + " ]";
    }
    
}
