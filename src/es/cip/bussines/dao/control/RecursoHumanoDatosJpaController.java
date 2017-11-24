/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package es.cip.bussines.dao.control;

import es.cip.bussines.dao.control.exceptions.NonexistentEntityException;
import es.cip.bussines.dao.model.RecursoHumanoDatos;
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
public class RecursoHumanoDatosJpaController implements Serializable {

    public RecursoHumanoDatosJpaController(EntityManagerFactory emf) {
        this.emf = emf;
    }
    private EntityManagerFactory emf = null;

    public EntityManager getEntityManager() {
        return emf.createEntityManager();
    }

    public void create(RecursoHumanoDatos recursoHumanoDatos) {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            em.persist(recursoHumanoDatos);
            em.getTransaction().commit();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public void edit(RecursoHumanoDatos recursoHumanoDatos) throws NonexistentEntityException, Exception {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            recursoHumanoDatos = em.merge(recursoHumanoDatos);
            em.getTransaction().commit();
        } catch (Exception ex) {
            String msg = ex.getLocalizedMessage();
            if (msg == null || msg.length() == 0) {
                Integer id = recursoHumanoDatos.getId();
                if (findRecursoHumanoDatos(id) == null) {
                    throw new NonexistentEntityException("The recursoHumanoDatos with id " + id + " no longer exists.");
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
            RecursoHumanoDatos recursoHumanoDatos;
            try {
                recursoHumanoDatos = em.getReference(RecursoHumanoDatos.class, id);
                recursoHumanoDatos.getId();
            } catch (EntityNotFoundException enfe) {
                throw new NonexistentEntityException("The recursoHumanoDatos with id " + id + " no longer exists.", enfe);
            }
            em.remove(recursoHumanoDatos);
            em.getTransaction().commit();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public List<RecursoHumanoDatos> findRecursoHumanoDatosEntities() {
        return findRecursoHumanoDatosEntities(true, -1, -1);
    }

    public List<RecursoHumanoDatos> findRecursoHumanoDatosEntities(int maxResults, int firstResult) {
        return findRecursoHumanoDatosEntities(false, maxResults, firstResult);
    }

    private List<RecursoHumanoDatos> findRecursoHumanoDatosEntities(boolean all, int maxResults, int firstResult) {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            cq.select(cq.from(RecursoHumanoDatos.class));
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

    public RecursoHumanoDatos findRecursoHumanoDatos(Integer id) {
        EntityManager em = getEntityManager();
        try {
            return em.find(RecursoHumanoDatos.class, id);
        } finally {
            em.close();
        }
    }

    public int getRecursoHumanoDatosCount() {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            Root<RecursoHumanoDatos> rt = cq.from(RecursoHumanoDatos.class);
            cq.select(em.getCriteriaBuilder().count(rt));
            Query q = em.createQuery(cq);
            return ((Long) q.getSingleResult()).intValue();
        } finally {
            em.close();
        }
    }
    
}
