/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package es.cip.bussines.dao.control;

import es.cip.bussines.dao.control.exceptions.NonexistentEntityException;
import es.cip.bussines.dao.model.ObjetivoEspecifico;
import es.cip.util.Cte;
import java.io.Serializable;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Query;
import javax.persistence.EntityNotFoundException;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;

/**
 *
 * @author iMac
 */
public class ObjetivoEspecificoJpaController implements Serializable {

    public ObjetivoEspecificoJpaController(EntityManagerFactory emf) {
        this.emf = emf;
    }
    private EntityManagerFactory emf = null;

    public ObjetivoEspecificoJpaController() {
        this.emf = javax.persistence.Persistence.createEntityManagerFactory(Cte.Persistence_Unit_Name);
    }

    public EntityManager getEntityManager() {
        return emf.createEntityManager();
    }

    public void create(ObjetivoEspecifico objetivoEspecifico) {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            em.persist(objetivoEspecifico);
            em.getTransaction().commit();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public void edit(ObjetivoEspecifico objetivoEspecifico) throws NonexistentEntityException, Exception {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            objetivoEspecifico = em.merge(objetivoEspecifico);
            em.getTransaction().commit();
        } catch (Exception ex) {
            String msg = ex.getLocalizedMessage();
            if (msg == null || msg.length() == 0) {
                Integer id = objetivoEspecifico.getId();
                if (findObjetivoEspecifico(id) == null) {
                    throw new NonexistentEntityException("The objetivoEspecifico with id " + id + " no longer exists.");
                }
            }
            throw ex;
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public void destroy(Integer id) throws NonexistentEntityException {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            ObjetivoEspecifico objetivoEspecifico;
            try {
                objetivoEspecifico = em.getReference(ObjetivoEspecifico.class, id);
                objetivoEspecifico.getId();
            } catch (EntityNotFoundException enfe) {
                throw new NonexistentEntityException("The objetivoEspecifico with id " + id + " no longer exists.", enfe);
            }
            em.remove(objetivoEspecifico);
            em.getTransaction().commit();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public List<ObjetivoEspecifico> findObjetivoEspecificoEntities() {
        return findObjetivoEspecificoEntities(true, -1, -1);
    }

    public List<ObjetivoEspecifico> findObjetivoEspecificoEntities(int maxResults, int firstResult) {
        return findObjetivoEspecificoEntities(false, maxResults, firstResult);
    }

    private List<ObjetivoEspecifico> findObjetivoEspecificoEntities(boolean all, int maxResults, int firstResult) {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            cq.select(cq.from(ObjetivoEspecifico.class));
            Query q = em.createQuery(cq);
            if (!all) {
                q.setMaxResults(maxResults);
                q.setFirstResult(firstResult);
            }
            return q.getResultList();
        } finally {
            em.close();
        }
    }

    public ObjetivoEspecifico findObjetivoEspecifico(Integer id) {
        EntityManager em = getEntityManager();
        try {
            return em.find(ObjetivoEspecifico.class, id);
        } finally {
            em.close();
        }
    }

    public List<ObjetivoEspecifico> findProyecto(String idProyecto) {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery(ObjetivoEspecifico.class);
            Root<ObjetivoEspecifico> obj = cq.from(ObjetivoEspecifico.class);

            cq.select(obj);
            cq.where(
                    em.getCriteriaBuilder().like(obj.get("idProyecto"), idProyecto)
            );
            Query q = em.createQuery(cq);
            return q.getResultList();
        } finally {
            em.close();
        }
    }

    public int getObjetivoEspecificoCount() {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            Root<ObjetivoEspecifico> rt = cq.from(ObjetivoEspecifico.class);
            cq.select(em.getCriteriaBuilder().count(rt));
            Query q = em.createQuery(cq);
            return ((Long) q.getSingleResult()).intValue();
        } finally {
            em.close();
        }
    }

}
