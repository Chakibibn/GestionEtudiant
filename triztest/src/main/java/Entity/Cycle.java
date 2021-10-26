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
@Table(name = "cycle")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Cycle.findAll", query = "SELECT c FROM Cycle c")
    , @NamedQuery(name = "Cycle.findByIdCycle", query = "SELECT c FROM Cycle c WHERE c.idCycle = :idCycle")
    , @NamedQuery(name = "Cycle.findByNomCycle", query = "SELECT c FROM Cycle c WHERE c.nomCycle = :nomCycle")})
public class Cycle implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "IdCycle")
    private Integer idCycle;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 30)
    @Column(name = "NomCycle")
    private String nomCycle;

    public Cycle() {
    }

    public Cycle(Integer idCycle) {
        this.idCycle = idCycle;
    }

    public Cycle(Integer idCycle, String nomCycle) {
        this.idCycle = idCycle;
        this.nomCycle = nomCycle;
    }

    public Integer getIdCycle() {
        return idCycle;
    }

    public void setIdCycle(Integer idCycle) {
        this.idCycle = idCycle;
    }

    public String getNomCycle() {
        return nomCycle;
    }

    public void setNomCycle(String nomCycle) {
        this.nomCycle = nomCycle;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idCycle != null ? idCycle.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Cycle)) {
            return false;
        }
        Cycle other = (Cycle) object;
        if ((this.idCycle == null && other.idCycle != null) || (this.idCycle != null && !this.idCycle.equals(other.idCycle))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Entity.Cycle[ idCycle=" + idCycle + " ]";
    }
    
}
