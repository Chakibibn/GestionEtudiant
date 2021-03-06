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
@Table(name = "semestre")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Semestre.findAll", query = "SELECT s FROM Semestre s")
    , @NamedQuery(name = "Semestre.findByIdSemestre", query = "SELECT s FROM Semestre s WHERE s.idSemestre = :idSemestre")
    , @NamedQuery(name = "Semestre.findByNomSemestre", query = "SELECT s FROM Semestre s WHERE s.nomSemestre = :nomSemestre")
    , @NamedQuery(name = "Semestre.findByIdCycle", query = "SELECT s FROM Semestre s WHERE s.idCycle = :idCycle")})
public class Semestre implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "IdSemestre")
    private Integer idSemestre;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 30)
    @Column(name = "NomSemestre")
    private String nomSemestre;
    @Basic(optional = false)
    @NotNull
    @Column(name = "IdCycle")
    private int idCycle;

    public Semestre() {
    }

    public Semestre(Integer idSemestre) {
        this.idSemestre = idSemestre;
    }

    public Semestre(Integer idSemestre, String nomSemestre, int idCycle) {
        this.idSemestre = idSemestre;
        this.nomSemestre = nomSemestre;
        this.idCycle = idCycle;
    }

    public Integer getIdSemestre() {
        System.out.println("idSemestre 11 ");
        return idSemestre;
    }

    public void setIdSemestre(Integer idSemestre) {
        this.idSemestre = idSemestre;
    }

    public String getNomSemestre() {
        return nomSemestre;
    }

    public void setNomSemestre(String nomSemestre) {
        this.nomSemestre = nomSemestre;
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
        hash += (idSemestre != null ? idSemestre.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Semestre)) {
            return false;
        }
        Semestre other = (Semestre) object;
        if ((this.idSemestre == null && other.idSemestre != null) || (this.idSemestre != null && !this.idSemestre.equals(other.idSemestre))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Entity.Semestre[ idSemestre=" + idSemestre + " ]";
    }

    public String valToString() {
        Integer val = idSemestre;
        System.out.println("valToString val  " + val);
        String ret = "2";
        if (val != null) {
            ret = String.valueOf(val);
        }
        System.out.println("valToString  ret " + ret);
        return ret;
    }

    public String getSemestre() {
        System.out.println("idSemestre 33 "+idSemestre);
        return String.valueOf(idSemestre);
    }
}
