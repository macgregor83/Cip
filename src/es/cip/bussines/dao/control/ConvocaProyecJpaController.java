/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package es.cip.bussines.dao.control;

import es.cip.bussines.dao.control.exceptions.NonexistentEntityException;
import es.cip.bussines.dao.model.ConvocaProyec;
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
public class ConvocaProyecJpaController implements Serializable {

    public ConvocaProyecJpaController(EntityManagerFactory emf) {
        this.emf = emf;
    }
    private EntityManagerFactory emf = null;

    public EntityManager getEntityManager() {
        return emf.createEntityManager();
    }

    public void create(ConvocaProyec convocaProyec) {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            em.persist(convocaProyec);
            em.getTransaction().commit();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public void edit(ConvocaProyec convocaProyec) throws NonexistentEntityException, Exception {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            convocaProyec = em.merge(convocaProyec);
            em.getTransaction().commit();
        } catch (Exception ex) {
            String msg = ex.getLocalizedMessage();
            if (msg == null || msg.length() == 0) {
                int id = convocaProyec.getId();
                if (findConvocaProyec(id) == null) {
                    throw new NonexistentEntityException("The convocaProyec with id " + id + " no longer exists.");
                }
            }
            throw ex;
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public void destroy(int id) throws NonexistentEntityException {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            ConvocaProyec convocaProyec;
            try {
                convocaProyec = em.getReference(ConvocaProyec.class, id);
                convocaProyec.getId();
            } catch (EntityNotFoundException enfe) {
                throw new NonexistentEntityException("The convocaProyec with id " + id + " no longer exists.", enfe);
            }
            em.remove(convocaProyec);
            em.getTransaction().commit();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public List<ConvocaProyec> findConvocaProyecEntities() {
        return findConvocaProyecEntities(true, -1, -1);
    }

    public List<ConvocaProyec> findConvocaProyecEntities(int maxResults, int firstResult) {
        return findConvocaProyecEntities(false, maxResults, firstResult);
    }

    private List<ConvocaProyec> findConvocaProyecEntities(boolean all, int maxResults, int firstResult) {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            cq.select(cq.from(ConvocaProyec.class));
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

    public ConvocaProyec findConvocaProyec(int id) {
        EntityManager em = getEntityManager();
        try {
            return em.find(ConvocaProyec.class, id);
        } finally {
            em.close();
        }
    }

    public int getConvocaProyecCount() {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            Root<ConvocaProyec> rt = cq.from(ConvocaProyec.class);
            cq.select(em.getCriteriaBuilder().count(rt));
            Query q = em.createQuery(cq);
            return ((Long) q.getSingleResult()).intValue();
        } finally {
            em.close();
        }
    }
    
}
