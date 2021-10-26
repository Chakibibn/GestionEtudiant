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
@Table(name = "etudiant")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Etudiant.findAll", query = "SELECT e FROM Etudiant e")
    , @NamedQuery(name = "Etudiant.findByIdEtudiant", query = "SELECT e FROM Etudiant e WHERE e.idEtudiant = :idEtudiant")
    , @NamedQuery(name = "Etudiant.findByNomEtudiant", query = "SELECT e FROM Etudiant e WHERE e.nomEtudiant = :nomEtudiant")
    , @NamedQuery(name = "Etudiant.findByMPEtudiant", query = "SELECT e FROM Etudiant e WHERE e.mPEtudiant = :mPEtudiant")
    , @NamedQuery(name = "Etudiant.findByLPEtudiant", query = "SELECT e FROM Etudiant e WHERE e.lPEtudiant = :lPEtudiant")
    , @NamedQuery(name = "Etudiant.findByAdresse", query = "SELECT e FROM Etudiant e WHERE e.adresse = :adresse")
    , @NamedQuery(name = "Etudiant.findByNumTel", query = "SELECT e FROM Etudiant e WHERE e.numTel = :numTel")
    , @NamedQuery(name = "Etudiant.findByEmail", query = "SELECT e FROM Etudiant e WHERE e.email = :email")
    , @NamedQuery(name = "Etudiant.findByPrenomPere", query = "SELECT e FROM Etudiant e WHERE e.prenomPere = :prenomPere")
    , @NamedQuery(name = "Etudiant.findByNomMere", query = "SELECT e FROM Etudiant e WHERE e.nomMere = :nomMere")
    , @NamedQuery(name = "Etudiant.findByPrenomMere", query = "SELECT e FROM Etudiant e WHERE e.prenomMere = :prenomMere")
    , @NamedQuery(name = "Etudiant.findByIdSpecialte", query = "SELECT e FROM Etudiant e WHERE e.idSpecialte = :idSpecialte")
    , @NamedQuery(name = "Etudiant.findByDateNaissance", query = "SELECT e FROM Etudiant e WHERE e.dateNaissance = :dateNaissance")
    , @NamedQuery(name = "Etudiant.findByActif", query = "SELECT e FROM Etudiant e WHERE e.actif = :actif")})
public class Etudiant implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "IdEtudiant")
    private Integer idEtudiant;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 20)
    @Column(name = "NomEtudiant")
    private String nomEtudiant;
    @Size(max = 10)
    @Column(name = "MPEtudiant")
    private String mPEtudiant;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 30)
    @Column(name = "LPEtudiant")
    private String lPEtudiant;
    @Size(max = 30)
    @Column(name = "Adresse")
    private String adresse;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 10)
    @Column(name = "NumTel")
    private String numTel;
    // @Pattern(regexp="[a-z0-9!#$%&'*+/=?^_`{|}~-]+(?:\\.[a-z0-9!#$%&'*+/=?^_`{|}~-]+)*@(?:[a-z0-9](?:[a-z0-9-]*[a-z0-9])?\\.)+[a-z0-9](?:[a-z0-9-]*[a-z0-9])?", message="Invalid email")//if the field contains email address consider using this annotation to enforce field validation
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 30)
    @Column(name = "Email")
    private String email;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 30)
    @Column(name = "PrenomPere")
    private String prenomPere;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 30)
    @Column(name = "NomMere")
    private String nomMere;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 30)
    @Column(name = "PrenomMere")
    private String prenomMere;
    @Basic(optional = false)
    @NotNull
    @Column(name = "IdSpecialte")
    private int idSpecialte;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 30)
    @Column(name = "DateNaissance")
    private String dateNaissance;
    @Basic(optional = false)
    @NotNull
    @Column(name = "actif")
    private int actif;

    public Etudiant() {
    }

    public Etudiant(Integer idEtudiant) {
        this.idEtudiant = idEtudiant;
    }

    public Etudiant(Integer idEtudiant, String nomEtudiant, String lPEtudiant, String numTel, String email, String prenomPere, String nomMere, String prenomMere, int idSpecialte, String dateNaissance, int actif) {
        this.idEtudiant = idEtudiant;
        this.nomEtudiant = nomEtudiant;
        this.lPEtudiant = lPEtudiant;
        this.numTel = numTel;
        this.email = email;
        this.prenomPere = prenomPere;
        this.nomMere = nomMere;
        this.prenomMere = prenomMere;
        this.idSpecialte = idSpecialte;
        this.dateNaissance = dateNaissance;
        this.actif = actif;
    }

    public Integer getIdEtudiant() {
        return idEtudiant;
    }

    public void setIdEtudiant(Integer idEtudiant) {
        this.idEtudiant = idEtudiant;
    }

    public String getNomEtudiant() {
        return nomEtudiant;
    }

    public void setNomEtudiant(String nomEtudiant) {
        this.nomEtudiant = nomEtudiant;
    }

    public String getMPEtudiant() {
        return mPEtudiant;
    }

    public void setMPEtudiant(String mPEtudiant) {
        this.mPEtudiant = mPEtudiant;
    }

    public String getLPEtudiant() {
        return lPEtudiant;
    }

    public void setLPEtudiant(String lPEtudiant) {
        this.lPEtudiant = lPEtudiant;
    }

    public String getAdresse() {
        return adresse;
    }

    public void setAdresse(String adresse) {
        this.adresse = adresse;
    }

    public String getNumTel() {
        return numTel;
    }

    public void setNumTel(String numTel) {
        this.numTel = numTel;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPrenomPere() {
        return prenomPere;
    }

    public void setPrenomPere(String prenomPere) {
        this.prenomPere = prenomPere;
    }

    public String getNomMere() {
        return nomMere;
    }

    public void setNomMere(String nomMere) {
        this.nomMere = nomMere;
    }

    public String getPrenomMere() {
        return prenomMere;
    }

    public void setPrenomMere(String prenomMere) {
        this.prenomMere = prenomMere;
    }

    public int getIdSpecialte() {
        return idSpecialte;
    }

    public void setIdSpecialte(int idSpecialte) {
        this.idSpecialte = idSpecialte;
    }

    public String getDateNaissance() {
        return dateNaissance;
    }

    public void setDateNaissance(String dateNaissance) {
        this.dateNaissance = dateNaissance;
    }

    public int getActif() {
        return actif;
    }

    public void setActif(int actif) {
        this.actif = actif;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idEtudiant != null ? idEtudiant.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Etudiant)) {
            return false;
        }
        Etudiant other = (Etudiant) object;
        if ((this.idEtudiant == null && other.idEtudiant != null) || (this.idEtudiant != null && !this.idEtudiant.equals(other.idEtudiant))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Entity.Etudiant[ idEtudiant=" + idEtudiant + " ]";
    }
    
}
