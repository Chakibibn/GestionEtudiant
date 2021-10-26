/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Beans;

import Entity.Examen;
import Entity.ExamenPK;
import Entity.Module;
import Entity.Moyennesemestre;
import Entity.MoyennesemestrePK;
import Entity.Semestre;
import Entity.Specialite;
import Entity.SpecialiteModule;
import Entity.SpecialiteSemestre;
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
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
public class calculermoyenne {

    private int idpourcalculer;
    private String idsemestre;
    private String etudiantPName;
    private String etudiantName;
    private String etudiantDate;
    private String idSpecialite;
    private List<SpecialiteSemestre> listeSemestre = new ArrayList<>();
    private List<SpecialiteModule> listeModuleparSemestre = new ArrayList<>();
    private List<Double> notemodule = new ArrayList<>();
    private List<Examen> listetudiantnoteexamen = new ArrayList<>();
    private Examen etudiantnoteexamen = new Examen();
    private int Idetu;
    private int Idm;
    private Float noteexman;

    public void intiCalc() {
        Configuration con = (Configuration) new Configuration().configure("hibernate.cfg.xml");
        SessionFactory sf = con.buildSessionFactory();
        Session session = sf.openSession();
        Transaction tx = session.beginTransaction();
       
       Query q2 = session.createQuery("SELECT s FROM SpecialiteSemestre s WHERE s.specialiteSemestrePK.idSpecialite = :a");
       q2.setParameter("a", Integer.parseInt(idSpecialite));
        listeSemestre = q2.list();

    }

    public calculermoyenne() {

    }
    public String persistMoyenne(int idetudiant,int idSemestre, String Moyenne){
        Configuration con = (Configuration) new Configuration().configure("hibernate.cfg.xml");
        SessionFactory sf = con.buildSessionFactory();
        Session session = sf.openSession();
        Transaction tx = session.beginTransaction();
        
        Moyennesemestre moy = new Moyennesemestre();
        moy.setMoyennesemestrePK(new MoyennesemestrePK(idetudiant, idSemestre));
        moy.setMoyenne(Moyenne);
        session.save(moy);
         tx.commit();
         session.close();
        
       
         return "moyenne ajouter";
    }
    public String recupmodule(String idsemestre) {
        System.out.println("******1111111111111111****" + idsemestre);
       
        System.err.println("**********");
        return null;
    }
    public String semestreparId(Integer Idsemestrev){
    Configuration con = (Configuration) new Configuration().configure("hibernate.cfg.xml");
        SessionFactory sf = con.buildSessionFactory();
        Session session = sf.openSession();
        Transaction tx = session.beginTransaction();
        System.err.println("laaaaaaaaaaaaaaa");
        Query q = session.createQuery(" SELECT s FROM Semestre s WHERE s.idSemestre = :a");
        q.setParameter("a", Idsemestrev);
        Semestre s = (Semestre)q.uniqueResult();
        session.close();
        return ""+s.getNomSemestre();
    }
    public void moduleparsemestre(Integer Idsemestrev){
        listeModuleparSemestre = null;
         Configuration con = (Configuration) new Configuration().configure("hibernate.cfg.xml");
        SessionFactory sf = con.buildSessionFactory();
        Session session = sf.openSession();
        Transaction tx = session.beginTransaction();
        System.err.println("laaaaaaaaaaaaaaa");
        Query q = session.createQuery(" SELECT s FROM SpecialiteModule s WHERE s.idSemestre = :a");
        q.setParameter("a", Idsemestrev);
        
        listeModuleparSemestre = q.list();
        session.close();
         System.err.println("laaaaaaaaaaaaaaa2");
        for(SpecialiteModule s : listeModuleparSemestre){
        System.err.println("***"+s.getSpecialiteModulePK().getIdModule());}
    
    
    }
    public String goToListEtudiant(){
    String url = "afficherEtudiant.xhtml?faces-redirect=true";
    return url;
    }
    public int getCoeifparIdModule(int IdModule){
         Configuration con = (Configuration) new Configuration().configure("hibernate.cfg.xml");
        SessionFactory sf = con.buildSessionFactory();
        Session session = sf.openSession();
        Transaction tx = session.beginTransaction();
        
        Query q = session.createQuery(" SELECT s FROM Module s WHERE s.idModule = :a");
        q.setParameter("a", IdModule);
        System.err.println("laaaaaaaaaaaaaaa");
        Module module = (Module) q.uniqueResult();
      System.err.println("laaaaaaaaaaaaaaa"+module.getCoeif());
        return module.getCoeif();
    }
    public String getModuleparId(int IdModule){
             Configuration con = (Configuration) new Configuration().configure("hibernate.cfg.xml");
        SessionFactory sf = con.buildSessionFactory();
        Session session = sf.openSession();
        Transaction tx = session.beginTransaction();
        System.err.println("laaaaaaaaaaaaaaa");
        Query q = session.createQuery(" SELECT s FROM Module s WHERE s.idModule = :a");
        q.setParameter("a", IdModule);
        Module module = (Module)q.uniqueResult();
       /* etudiantnoteexamen.setExamenPK(new ExamenPK(idpourcalculer, IdModule));
       float ne = 0;
        etudiantnoteexamen.setNoteExamen(ne);
        etudiantnoteexamen.getExamenPK().setIdModule(IdModule);
        etudiantnoteexamen.getExamenPK().setIdEtudiant(idpourcalculer);
        System.err.println("Id Etudiant : "+etudiantnoteexamen.getExamenPK().getIdEtudiant()+" ID module"+etudiantnoteexamen.getExamenPK().getIdModule()+" Note Examen "+etudiantnoteexamen.getNoteExamen());
        listetudiantnoteexamen.add(etudiantnoteexamen);*/
        return module.getNomModule();
    }
    public String creationExamen(int idmodule){
         Examen e = new Examen();
         System.out.println("IDM");
        e.setExamenPK(new ExamenPK(idpourcalculer, idmodule));
        
        e.setNoteExamen(noteexman);
       /* etudiantnoteexamen.getExamenPK().setIdModule(IdModule);
        etudiantnoteexamen.getExamenPK().setIdEtudiant(idpourcalculer);*/
        System.err.println("Id Etudiant : "+e.getExamenPK().getIdEtudiant()+" ID module"+e.getExamenPK().getIdModule()+" Note Examen "+e.getNoteExamen());
        listetudiantnoteexamen.add(e);
        return null;
    }
    public int getIdpourcalculer() {
        return idpourcalculer;
    }

    public void setIdpourcalculer(int idpourcalculer) {
        this.idpourcalculer = idpourcalculer;
    }

    public String getEtudiantPName() {
        return etudiantPName;
    }

    public void setEtudiantPName(String etudiantPName) {
        this.etudiantPName = etudiantPName;
    }

    public String getEtudiantName() {
        return etudiantName;
    }

    public void setEtudiantName(String etudiantName) {
        this.etudiantName = etudiantName;
    }

    public String getEtudiantDate() {
        return etudiantDate;
    }

    public void setEtudiantDate(String etudiantDate) {
        this.etudiantDate = etudiantDate;
    }

    public String getIdSpecialite() {
        return idSpecialite;
    }

    public void setIdSpecialite(String idSpecialite) {
        this.idSpecialite = idSpecialite;
    }

    public List<SpecialiteSemestre> getListeSemestre() {
        return listeSemestre;
    }

    public void setListeSemestre(List<SpecialiteSemestre> listeSemestre) {
        this.listeSemestre = listeSemestre;
    }

    public String getIdsemestre() {
        System.out.println("idsemestre 22 " + idsemestre);
        return idsemestre;
    }

    public void setIdsemestre(String idsemestre) {
        System.out.println("setIdsemestre 44 " + idsemestre);
        this.idsemestre = idsemestre;
    }

    public List<SpecialiteModule> getListeModuleparSemestre() {
        return listeModuleparSemestre;
    }

    public void setListeModuleparSemestre(List<SpecialiteModule> listeModuleparSemestre) {
        this.listeModuleparSemestre = listeModuleparSemestre;
    }

    public List<Double> getNotemodule() {
        return notemodule;
    }

    public void setNotemodule(List<Double> notemodule) {
        this.notemodule = notemodule;
    }

    public String  remplirNoteModule(Examen examen,int idsemy){
        System.err.println("-****-");
        int summcoeif=0;
        double summdecalcule=0;
//        System.err.println(""+etudiantnoteexamen.getExamenPK().getIdEtudiant());
       // For(Examen e : etudiantnoteexamen){}
      /* for(int i=0;i<etudiantnoteexamen.size();i++){
        
           System.err.println(""+etudiantnoteexamen.get(i));
       }*/
     /* if(examen !=null){
          System.err.println("***"+examen.toString()+" la note "+examen.getNoteExamen());
                    System.err.println(""+listetudiantnoteexamen.isEmpty());
                  if (listetudiantnoteexamen.contains(examen)) {
              int index = listetudiantnoteexamen.indexOf(examen);
              listetudiantnoteexamen.get(index).setNoteExamen(examen.getNoteExamen());
          }
          for (Examen e : listetudiantnoteexamen) {
              System.err.println("---"+e.getExamenPK().getIdEtudiant()+"---"+e.getExamenPK().getIdEtudiant()+"----"+e.getNoteExamen());
          }
          
          
      }*/
     if(listetudiantnoteexamen.contains(examen)){
         int index=   listetudiantnoteexamen.indexOf(examen);
         listetudiantnoteexamen.get(index).setNoteExamen(examen.getNoteExamen());
      }
        System.out.println("Beans.calculermoyenne.remplirNoteModule()"+listetudiantnoteexamen.size());
        for(Examen e : listetudiantnoteexamen){
                System.err.println("Id etudiant"+e.getExamenPK().getIdEtudiant()+"Id module "+e.getExamenPK().getIdModule()+" note module "+e.getNoteExamen());
               // int i = e.getExamenPK().getIdModule();
                //System.err.println(" coefff "+getCoeifparIdModule(e.getExamenPK().getIdModule()));
                //summcoeif = summcoeif+getCoeifparIdModule(e.getExamenPK().getIdModule());
                
              summcoeif = summcoeif+getCoeifparIdModule(e.getExamenPK().getIdModule());
               summdecalcule = summdecalcule+(e.getNoteExamen()*getCoeifparIdModule(e.getExamenPK().getIdModule()));
                //
                
                
        }
        double moyenne = (summdecalcule/summcoeif);
        DecimalFormat df = new DecimalFormat("00.00");
        String moyF = df.format(moyenne);
        System.err.println("***"+summcoeif+"**"+summdecalcule+" la moyenne est de "+moyF+" Id semestre "+idsemy);
        persistMoyenne(idpourcalculer, idsemy, moyF);
        
        return goToListEtudiant();
        
    }

    public List<Examen> getListetudiantnoteexamen() {
        return listetudiantnoteexamen;
    }

    public void setListetudiantnoteexamen(List<Examen> listetudiantnoteexamen) {
        this.listetudiantnoteexamen = listetudiantnoteexamen;
    }

    public Examen getEtudiantnoteexamen() {
        return etudiantnoteexamen;
    }

    public void setEtudiantnoteexamen(Examen etudiantnoteexamen) {
        this.etudiantnoteexamen = etudiantnoteexamen;
    }

    public int getIdetu() {
        return Idetu;
    }

    public void setIdetu(int Idetu) {
        this.Idetu = Idetu;
    }

    public int getIdm() {
        return Idm;
    }

    public void setIdm(int Idm) {
        System.err.println("idm"+Idm);
        this.Idm = Idm;
    }

    public Float getNoteexman() {
        return noteexman;
    }

    public void setNoteexman(Float noteexman) {
        this.noteexman = noteexman;
    }

    
    

}
