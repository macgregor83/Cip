/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package es.cip.bussines.dao.control;

import es.cip.bussines.dao.control.exceptions.NonexistentEntityException;
import es.cip.bussines.dao.model.EstatusProyecto;
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
public class EstatusProyectoJpaController implements Serializable {

    public EstatusProyectoJpaController(EntityManagerFactory emf) {
        this.emf = emf;
    }
    private EntityManagerFactory emf = null;

    public EntityManager getEntityManager() {
        return emf.createEntityManager();
    }

    public void create(EstatusProyecto estatusProyecto) {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            em.persist(estatusProyecto);
            em.getTransaction().commit();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public void edit(EstatusProyecto estatusProyecto) throws NonexistentEntityException, Exception {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            estatusProyecto = em.merge(estatusProyecto);
            em.getTransaction().commit();
        } catch (Exception ex) {
            String msg = ex.getLocalizedMessage();
            if (msg == null || msg.length() == 0) {
                Integer id = estatusProyecto.getId();
                if (findEstatusProyecto(id) == null) {
                    throw new NonexistentEntityException("The estatusProyecto with id " + id + " no longer exists.");
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
            EstatusProyecto estatusProyecto;
            try {
                estatusProyecto = em.getReference(EstatusProyecto.class, id);
                estatusProyecto.getId();
            } catch (EntityNotFoundException enfe) {
                throw new NonexistentEntityException("The estatusProyecto with id " + id + " no longer exists.", enfe);
            }
            em.remove(estatusProyecto);
            em.getTransaction().commit();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public List<EstatusProyecto> findEstatusProyectoEntities() {
        return findEstatusProyectoEntities(true, -1, -1);
    }

    public List<EstatusProyecto> findEstatusProyectoEntities(int maxResults, int firstResult) {
        return findEstatusProyectoEntities(false, maxResults, firstResult);
    }

    private List<EstatusProyecto> findEstatusProyectoEntities(boolean all, int maxResults, int firstResult) {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            cq.select(cq.from(EstatusProyecto.class));
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

    public EstatusProyecto findEstatusProyecto(Integer id) {
        EntityManager em = getEntityManager();
        try {
            return em.find(EstatusProyecto.class, id);
        } finally {
            em.close();
        }
    }

    public int getEstatusProyectoCount() {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            Root<EstatusProyecto> rt = cq.from(EstatusProyecto.class);
            cq.select(em.getCriteriaBuilder().count(rt));
            Query q = em.createQuery(cq);
            return ((Long) q.getSingleResult()).intValue();
        } finally {
            em.close();
        }
    }
    
}
