/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Beans;

import Entity.Etudiant;
import Entity.Inscrit;
import Entity.InscritPK;
import Entity.Specialite;


import Entity.SpecialiteModule;
import java.util.List;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.bean.ViewScoped;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

/**
 *
 * @author Winsido
 */
@ManagedBean
@ViewScoped
public class AjouterEtudian {

    private int Idpourcalculer;
    private boolean modifier = true;
    private String canEdit;
    private String etudiantName;
    private String etudiantPName;
    private String etudiantDate;
    private String NomEtudiant;
    private String PrenomEtudiant;
    private String Adresse;
    private String NumTel;
    private String Email;
    private String PrenomPere;
    private String datenaissance;
    private String NomMere;
    private String PrenomMere;
    private String IdSpecialite;
    private String Resultatdecommande = "";
    private String messagetete = "";
    private List<Etudiant> etudiants;
    private Etudiant etudiantSelected;
    private String calc;

    public void initFormEtudiant() {
        System.out.println("initFormEtudiant");
        Configuration con = (Configuration) new Configuration().configure("hibernate.cfg.xml");
        SessionFactory sf = con.buildSessionFactory();
        Session session = sf.openSession();
        Transaction tx = session.beginTransaction();
        System.out.println("***********  etudiantName  " + etudiantName);
        if (etudiantName != null) {
            NomEtudiant = etudiantName;
        }
        if (etudiantPName != null) {
            PrenomEtudiant = etudiantPName;
        }
        if (etudiantDate != null) {
            datenaissance = etudiantDate;
        }
        modifier = false;
        if (canEdit != null) {
            if ("true".equalsIgnoreCase(canEdit)) {
                modifier = true;
            }
        }
        Query q = session.createQuery("From Etudiant c where c.nomEtudiant =  :b and  c.lPEtudiant= :a and  c.dateNaissance=:d ");
        q.setParameter("b", NomEtudiant);
        q.setParameter("a", PrenomEtudiant);
        q.setParameter("d", datenaissance);
        Etudiant e = (Etudiant) q.uniqueResult();
        System.out.println("***********  e  " + e);
        if (e != null) {
            etudiantSelected = e;
            messagetete = "Consulter etudiant";
            if (modifier) {
                messagetete = "Modifier etudiant";
            }
        } else {
            etudiantSelected = new Etudiant();
            messagetete = "Ajouter etudiant";
        }

    }

    public AjouterEtudian() {
        Configuration con = (Configuration) new Configuration().configure("hibernate.cfg.xml");
        SessionFactory sf = con.buildSessionFactory();
        Session session = sf.openSession();
        Transaction tx = session.beginTransaction();
        Query q = session.createQuery("From Etudiant c where c.actif = :b");
        q.setParameter("b", 1);
        etudiants = q.list();
        for (Etudiant etudiant : etudiants) {
            System.err.println("" + etudiant.getPrenomPere());
        }
    }

    public String ajouterEtudiant() {
        etudiantSelected.getNomEtudiant();
        Configuration con = (Configuration) new Configuration().configure("hibernate.cfg.xml");
        SessionFactory sf = con.buildSessionFactory();
        Session session = sf.openSession();
        Transaction tx = session.beginTransaction();


        Query q = session.createQuery("From Etudiant c where c.nomEtudiant =  :b and  c.lPEtudiant= :a and  c.dateNaissance=:d ");
        q.setParameter("b", etudiantSelected.getNomEtudiant());
        q.setParameter("a", etudiantSelected.getLPEtudiant());
        q.setParameter("d", etudiantSelected.getDateNaissance());
        Etudiant e = (Etudiant) q.uniqueResult();
        if (e != null) {
            if (etudiantSelected.getNomEtudiant().equals(e.getNomEtudiant()) && etudiantSelected.getLPEtudiant().equals(e.getLPEtudiant())) {
                String ids = Integer.toString(e.getIdSpecialte());
                if (String.valueOf(etudiantSelected.getIdSpecialte()).equals(ids)) {
                    Resultatdecommande = "L'etudiant :" + e.getNomEtudiant() + " " + e.getLPEtudiant() + " Existe Déja";
                }
                
            }
           

        } else {

            etudiantSelected.setActif(1);
           Query ins = session.createQuery("SELECT  s FROM SpecialiteModule s where s.specialiteModulePK.idSpecialte= :b");
             ins.setParameter("b", etudiantSelected.getIdSpecialte());
             List<SpecialiteModule> specm = ins.list();
             
    
            
            session.save(etudiantSelected);
                    
         
                Inscrit EtudiantInscritDansUnModule = new Inscrit();
                InscritPK inspk = new InscritPK();
               Query q1 = session.createQuery("select Max(e.idEtudiant) From Etudiant e");
               int maxetu = (int) q1.uniqueResult();
             
        
           
            System.err.println("je suis inscrit");
            for(SpecialiteModule i : specm){
            
                System.err.println("****** id Etudian "+maxetu+" *************"+i.getSpecialiteModulePK().getIdModule());
               session.save(new Inscrit(etudiantSelected.getIdEtudiant(), i.getSpecialiteModulePK().getIdModule()));
                System.err.println("saved"+maxetu);
            
            }
           
            tx.commit();

        }

        session.close();
        System.err.println("***" + NomEtudiant);

        modifier = false;
        return consulter();
    }
     public String supprimerEtudiant() {
        etudiantSelected.getNomEtudiant();
        Configuration con = (Configuration) new Configuration().configure("hibernate.cfg.xml");
        SessionFactory sf = con.buildSessionFactory();
        Session session = sf.openSession();
        Transaction tx = session.beginTransaction();
        Query q = session.createQuery("update Etudiant e set e.actif= :a where e.idEtudiant = :z ");
        q.setParameter("a", 0);
        q.setParameter("z", etudiantSelected.getIdEtudiant());
        q.executeUpdate();
        session.close();
        return "afficherEtudiant.xhtml?faces-redirect=true";
     
        
     
     }
    public String supprimer() {
        Configuration con = (Configuration) new Configuration().configure("hibernate.cfg.xml");
        SessionFactory sf = con.buildSessionFactory();
        Session session = sf.openSession();
        Transaction tx = session.beginTransaction();
        Query q = session.createQuery("update Etudiant e set e.actif= :a where e.idEtudiant = :z ");
        q.setParameter("a", 0);
        q.setParameter("z", etudiantSelected.getIdEtudiant());
        q.executeUpdate();
        session.close();
        return "AfficherEtudiant.xhtml";
    }

    public String ajouter() {

        String url = "index.xhtml?faces-redirect=true";

        url = url + "&canedit=true";

        return url;
    }

    public String consulter() {

        String url = "index.xhtml?faces-redirect=true";

        url = url + "&canedit=false";

        System.out.println("------------- 1 etudiantSelected ------------  1 " + etudiantSelected);
        if (etudiantSelected != null) {
            url = url + "&nom=" + etudiantSelected.getNomEtudiant() + "&pnom=" + etudiantSelected.getLPEtudiant() + "&date=" + etudiantSelected.getDateNaissance();
            System.out.println("-------------  etudiantSelected ------------   " + etudiantSelected);
        }
        return url;
    }
    public String specialiteparid(int idSpecialiteViewed){
            
        Configuration con = (Configuration) new Configuration().configure("hibernate.cfg.xml");
        SessionFactory sf = con.buildSessionFactory();
        Session session = sf.openSession();
        Transaction tx = session.beginTransaction();
        Query q = session.createQuery("select s from Specialite s where s.idSpecialte= :a");
        q.setParameter("a", idSpecialiteViewed);
        Specialite specialitevouluafficher = (Specialite) q.uniqueResult();
        session.close();
    
        return specialitevouluafficher.getNomSpecialte();
    }
    public String modifier() {

        String url = "index.xhtml?faces-redirect=true";

        url = url + "&canedit=true";

        if (etudiantSelected != null) {
            url = url + "&nom=" + etudiantSelected.getNomEtudiant() + "&pnom=" + etudiantSelected.getLPEtudiant() + "&date=" + etudiantSelected.getDateNaissance();
        }
        return url;
    }
    public String verscalculer(){
        
        String url = "CalculerMoyenne.xhtml?faces-redirect=true";
        if(etudiantSelected !=null){
            url = url + "&id="+etudiantSelected.getIdEtudiant()+"&pnom="+etudiantSelected.getNomEtudiant()+"&lnom="+etudiantSelected.getLPEtudiant()+"&date="+etudiantSelected.getDateNaissance()+"&spec="+etudiantSelected.getIdSpecialte();
        }
        return url;
        
    }

    public String getResultatdecommande() {
        return Resultatdecommande;
    }

    public void setResultatdecommande(String Resultatdecommande) {
        this.Resultatdecommande = Resultatdecommande;
    }

    public String getNomEtudiant() {
        return NomEtudiant;
    }

    public void setNomEtudiant(String NomEtudiant) {
        this.NomEtudiant = NomEtudiant;
    }

    public String getPrenomEtudiant() {
        return PrenomEtudiant;
    }

    public void setPrenomEtudiant(String PrenomEtudiant) {
        this.PrenomEtudiant = PrenomEtudiant;
    }

    public String getAdresse() {
        return Adresse;
    }

    public void setAdresse(String Adresse) {
        this.Adresse = Adresse;
    }

    public String getNumTel() {
        return NumTel;
    }

    public void setNumTel(String NumTel) {
        this.NumTel = NumTel;
    }

    public String getEmail() {
        return Email;
    }

    public void setEmail(String Email) {
        this.Email = Email;
    }

    public String getPrenomPere() {
        return PrenomPere;
    }

    public void setPrenomPere(String PrenomPere) {
        this.PrenomPere = PrenomPere;
    }

    public String getDatenaissance() {
        return datenaissance;
    }

    public void setDatenaissance(String datenaissance) {
        this.datenaissance = datenaissance;
    }

    public String getNomMere() {
        return NomMere;
    }

    public void setNomMere(String NomMere) {
        this.NomMere = NomMere;
    }

    public String getPrenomMere() {
        return PrenomMere;
    }

    public void setPrenomMere(String PrenomMere) {
        this.PrenomMere = PrenomMere;
    }

    public String getIdSpecialite() {
        return IdSpecialite;
    }

    public void setIdSpecialite(String IdSpecialite) {
        this.IdSpecialite = IdSpecialite;
    }

    public int getIdpourcalculer() {
        return Idpourcalculer;
    }

    public void setIdpourcalculer(int Idpourcalculer) {
        this.Idpourcalculer = Idpourcalculer;
    }


    public List<Etudiant> getEtudiants() {
        return etudiants;
    }

    public void setEtudiants(List<Etudiant> etudiants) {
        this.etudiants = etudiants;
    }

    public Etudiant getEtudiantSelected() {
        return etudiantSelected;
    }

    public void setEtudiantSelected(Etudiant etudiantSelected) {
        this.etudiantSelected = etudiantSelected;
    }

    public boolean afficher() {
        System.err.println("" + etudiantSelected.getNomEtudiant());
        return true;
    }

    public String modifieretudiant() {
        NomEtudiant = etudiantSelected.getNomEtudiant();
        PrenomEtudiant = etudiantSelected.getLPEtudiant();
        Adresse = etudiantSelected.getAdresse();
        NumTel = etudiantSelected.getNumTel();
        Email = etudiantSelected.getEmail();
        PrenomPere = etudiantSelected.getPrenomPere();
        datenaissance = etudiantSelected.getDateNaissance();
        NomMere = etudiantSelected.getNomMere();
        PrenomMere = etudiantSelected.getPrenomPere();
        //IdSpecialite  = etudiantSelected.getIdSpecialte();
        Configuration con = (Configuration) new Configuration().configure("hibernate.cfg.xml");
        SessionFactory sf = con.buildSessionFactory();
        Session session = sf.openSession();
        Transaction tx = session.beginTransaction();
        Query q = session.createQuery("update Etudiant e set e.nomEtudiant = :a, e.lPEtudiant= :b, e.adresse = :c, e.numTel= :d, e.email= :f, e.prenomPere= :g, e.nomMere= :h, e.prenomMere= :i, e.idSpecialte= :j, e.dateNaissance= :k    where e.idEtudiant = :z ");
        q.setParameter("a", etudiantSelected.getNomEtudiant());
        q.setParameter("b", etudiantSelected.getLPEtudiant());
        q.setParameter("c", etudiantSelected.getAdresse());
        q.setParameter("d", etudiantSelected.getNumTel());
        q.setParameter("f", etudiantSelected.getEmail());
        q.setParameter("g", etudiantSelected.getPrenomPere());
        q.setParameter("h", etudiantSelected.getNomMere());
        q.setParameter("i", etudiantSelected.getPrenomMere());
        q.setParameter("j", etudiantSelected.getIdSpecialte());
        q.setParameter("k", etudiantSelected.getDateNaissance());
        q.setParameter("z", etudiantSelected.getIdEtudiant());
        q.executeUpdate();
        session.close();

        return "afficherEtudiant.xhtml";
    }

    public boolean isModifier() {
        return modifier;
    }

    public void setModifier(boolean modifier) {
        this.modifier = modifier;
    }

    public String getCanEdit() {
        return canEdit;
    }

    public void setCanEdit(String canEdit) {
        this.canEdit = canEdit;
    }

    public String getEtudiantName() {
        return etudiantName;
    }

    public void setEtudiantName(String etudiantName) {
        this.etudiantName = etudiantName;
    }

    public String to_update_page() {

        return "index.xhtml?faces-redirect=true&canedit=true";
    }

    public String to_consult_page() {

        return "index.xhtml?faces-redirect=true&canedit=false";
    }

    public String getEtudiantPName() {
        return etudiantPName;
    }

    public void setEtudiantPName(String etudiantPName) {
        this.etudiantPName = etudiantPName;
    }

    public String getEtudiantDate() {
        return etudiantDate;
    }

    public void setEtudiantDate(String etudiantDate) {
        this.etudiantDate = etudiantDate;
    }

    public String consulterListeEtudiant() {

        return "afficherEtudiant.xhtml?faces-redirect=true";
    }

    public String getMessagetete() {
        return messagetete;
    }

    public void setMessagetete(String messagetete) {
        this.messagetete = messagetete;
    }

    public String getCalc() {
        return calc;
    }

    public void setCalc(String calc) {
        this.calc = calc;
    }

    
   
    
    

}
