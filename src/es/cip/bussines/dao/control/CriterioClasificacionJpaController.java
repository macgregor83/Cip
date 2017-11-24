/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package es.cip.bussines.dao.control;

import es.cip.bussines.dao.control.exceptions.NonexistentEntityException;
import es.cip.bussines.dao.model.CriterioClasificacion;
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
public class CriterioClasificacionJpaController implements Serializable {

    public CriterioClasificacionJpaController(EntityManagerFactory emf) {
        this.emf = emf;
    }
    private EntityManagerFactory emf = null;

    public EntityManager getEntityManager() {
        return emf.createEntityManager();
    }

    public void create(CriterioClasificacion criterioClasificacion) {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            em.persist(criterioClasificacion);
            em.getTransaction().commit();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public void edit(CriterioClasificacion criterioClasificacion) throws NonexistentEntityException, Exception {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            criterioClasificacion = em.merge(criterioClasificacion);
            em.getTransaction().commit();
        } catch (Exception ex) {
            String msg = ex.getLocalizedMessage();
            if (msg == null || msg.length() == 0) {
                Integer id = criterioClasificacion.getId();
                if (findCriterioClasificacion(id) == null) {
                    throw new NonexistentEntityException("The criterioClasificacion with id " + id + " no longer exists.");
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
            CriterioClasificacion criterioClasificacion;
            try {
                criterioClasificacion = em.getReference(CriterioClasificacion.class, id);
                criterioClasificacion.getId();
            } catch (EntityNotFoundException enfe) {
                throw new NonexistentEntityException("The criterioClasificacion with id " + id + " no longer exists.", enfe);
            }
            em.remove(criterioClasificacion);
            em.getTransaction().commit();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public List<CriterioClasificacion> findCriterioClasificacionEntities() {
        return findCriterioClasificacionEntities(true, -1, -1);
    }

    public List<CriterioClasificacion> findCriterioClasificacionEntities(int maxResults, int firstResult) {
        return findCriterioClasificacionEntities(false, maxResults, firstResult);
    }

    private List<CriterioClasificacion> findCriterioClasificacionEntities(boolean all, int maxResults, int firstResult) {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            cq.select(cq.from(CriterioClasificacion.class));
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

    public CriterioClasificacion findCriterioClasificacion(Integer id) {
        EntityManager em = getEntityManager();
        try {
            return em.find(CriterioClasificacion.class, id);
        } finally {
            em.close();
        }
    }

    public int getCriterioClasificacionCount() {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            Root<CriterioClasificacion> rt = cq.from(CriterioClasificacion.class);
            cq.select(em.getCriteriaBuilder().count(rt));
            Query q = em.createQuery(cq);
            return ((Long) q.getSingleResult()).intValue();
        } finally {
            em.close();
        }
    }
    
}
