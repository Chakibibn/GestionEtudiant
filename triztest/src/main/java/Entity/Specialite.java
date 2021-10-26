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
@Table(name = "specialite")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Specialite.findAll", query = "SELECT s FROM Specialite s")
    , @NamedQuery(name = "Specialite.findByIdSpecialte", query = "SELECT s FROM Specialite s WHERE s.idSpecialte = :idSpecialte")
    , @NamedQuery(name = "Specialite.findByNomSpecialte", query = "SELECT s FROM Specialite s WHERE s.nomSpecialte = :nomSpecialte")
    , @NamedQuery(name = "Specialite.findByIdCycle", query = "SELECT s FROM Specialite s WHERE s.idCycle = :idCycle")})
public class Specialite implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "IdSpecialte")
    private Integer idSpecialte;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 80)
    @Column(name = "NomSpecialte")
    private String nomSpecialte;
    @Basic(optional = false)
    @NotNull
    @Column(name = "IdCycle")
    private int idCycle;

    public Specialite() {
    }

    public Specialite(Integer idSpecialte) {
        this.idSpecialte = idSpecialte;
    }

    public Specialite(Integer idSpecialte, String nomSpecialte, int idCycle) {
        this.idSpecialte = idSpecialte;
        this.nomSpecialte = nomSpecialte;
        this.idCycle = idCycle;
    }

    public Integer getIdSpecialte() {
        return idSpecialte;
    }

    public void setIdSpecialte(Integer idSpecialte) {
        this.idSpecialte = idSpecialte;
    }

    public String getNomSpecialte() {
        return nomSpecialte;
    }

    public void setNomSpecialte(String nomSpecialte) {
        this.nomSpecialte = nomSpecialte;
    }

    public int getIdCycle() {
        return idCycle;
    }

    public void setIdCycle(int idCycle) {
        this.idCycle = idCycle;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idSpecialte != null ? idSpecialte.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Specialite)) {
            return false;
        }
        Specialite other = (Specialite) object;
        if ((this.idSpecialte == null && other.idSpecialte != null) || (this.idSpecialte != null && !this.idSpecialte.equals(other.idSpecialte))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Entity.Specialite[ idSpecialte=" + idSpecialte + " ]";
    }
    
}
