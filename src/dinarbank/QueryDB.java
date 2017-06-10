/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dinarbank;

import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Query;

/**
 *
 * @author sholjun
 */
public class QueryDB {
    public void Add (Object object){
        
        EntityManagerFactory emf = javax.persistence.Persistence.createEntityManagerFactory("DinarBankPU");
        EntityManager em = emf.createEntityManager();  
        em.getTransaction().begin();
        try {
                em.persist(object);
                em.getTransaction().commit();
        } catch (Exception e) {
                e.printStackTrace();
                em.getTransaction().rollback();
        } finally {
                em.close();
        }
    }
    
    public void update(long id,String nama,String alamat,String nohp){
        EntityManagerFactory emf = javax.persistence.Persistence.createEntityManagerFactory("DinarBankPU");
        EntityManager em = emf.createEntityManager();  
        em.getTransaction().begin();
        em.createQuery("UPDATE tabelnasabah e SET e.nama=?1,e.alamat=?2,e.nohp=?3 WHERE e.id=?4",tabelnasabah.class)
                .setParameter(1, nama)
                .setParameter(2, alamat)
                .setParameter(3, nohp)
                .setParameter(4,id)
                .executeUpdate();       
        em.getTransaction().commit();
  }
    
    
public void hapus(long id){
        EntityManagerFactory emf = javax.persistence.Persistence.createEntityManagerFactory("DinarBankPU");
        EntityManager em = emf.createEntityManager();  
        em.getTransaction().begin();
        int hapusyu=em.createQuery("DELETE FROM tabelnasabah e WHERE e.id=:par").setParameter("par", id).executeUpdate();
        em.getTransaction().commit();
}
  public void Show() {
        EntityManagerFactory emf = javax.persistence.Persistence.createEntityManagerFactory("DinarBankPU");
        EntityManager em = emf.createEntityManager();
        Query query = em.createQuery("SELECT e FROM tabelnasabah e");
        List<tabelnasabah> result = query.getResultList();
        for (tabelnasabah e : result) {
                 System.out.println("ID AGEN :"+ e.getId() + "\n NAMA :" + e.getNama()+"\n Alamat :"+ e.getAlamat()+"\n NO HP :" +e.getNohp());   
        }
    }
}
