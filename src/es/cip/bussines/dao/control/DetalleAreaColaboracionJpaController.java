/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package es.cip.bussines.dao.control;

import es.cip.bussines.dao.control.exceptions.NonexistentEntityException;
import es.cip.bussines.dao.model.DetalleAreaColaboracion;
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
public class DetalleAreaColaboracionJpaController implements Serializable {

    public DetalleAreaColaboracionJpaController(EntityManagerFactory emf) {
        this.emf = emf;
    }
    private EntityManagerFactory emf = null;

    public EntityManager getEntityManager() {
        return emf.createEntityManager();
    }

    public void create(DetalleAreaColaboracion detalleAreaColaboracion) {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            em.persist(detalleAreaColaboracion);
            em.getTransaction().commit();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public void edit(DetalleAreaColaboracion detalleAreaColaboracion) throws NonexistentEntityException, Exception {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            detalleAreaColaboracion = em.merge(detalleAreaColaboracion);
            em.getTransaction().commit();
        } catch (Exception ex) {
            String msg = ex.getLocalizedMessage();
            if (msg == null || msg.length() == 0) {
                Integer id = detalleAreaColaboracion.getId();
                if (findDetalleAreaColaboracion(id) == null) {
                    throw new NonexistentEntityException("The detalleAreaColaboracion with id " + id + " no longer exists.");
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
            DetalleAreaColaboracion detalleAreaColaboracion;
            try {
                detalleAreaColaboracion = em.getReference(DetalleAreaColaboracion.class, id);
                detalleAreaColaboracion.getId();
            } catch (EntityNotFoundException enfe) {
                throw new NonexistentEntityException("The detalleAreaColaboracion with id " + id + " no longer exists.", enfe);
            }
            em.remove(detalleAreaColaboracion);
            em.getTransaction().commit();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public List<DetalleAreaColaboracion> findDetalleAreaColaboracionEntities() {
        return findDetalleAreaColaboracionEntities(true, -1, -1);
    }

    public List<DetalleAreaColaboracion> findDetalleAreaColaboracionEntities(int maxResults, int firstResult) {
        return findDetalleAreaColaboracionEntities(false, maxResults, firstResult);
    }

    private List<DetalleAreaColaboracion> findDetalleAreaColaboracionEntities(boolean all, int maxResults, int firstResult) {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            cq.select(cq.from(DetalleAreaColaboracion.class));
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

    public DetalleAreaColaboracion findDetalleAreaColaboracion(Integer id) {
        EntityManager em = getEntityManager();
        try {
            return em.find(DetalleAreaColaboracion.class, id);
        } finally {
            em.close();
        }
    }

    public int getDetalleAreaColaboracionCount() {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            Root<DetalleAreaColaboracion> rt = cq.from(DetalleAreaColaboracion.class);
            cq.select(em.getCriteriaBuilder().count(rt));
            Query q = em.createQuery(cq);
            return ((Long) q.getSingleResult()).intValue();
        } finally {
            em.close();
        }
    }
    
}
