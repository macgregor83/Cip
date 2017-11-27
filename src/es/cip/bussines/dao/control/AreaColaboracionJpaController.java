/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package es.cip.bussines.dao.control;

import es.cip.bussines.dao.control.exceptions.NonexistentEntityException;
import es.cip.bussines.dao.model.AreaColaboracion;
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
public class AreaColaboracionJpaController implements Serializable {

    public AreaColaboracionJpaController(EntityManagerFactory emf) {
        this.emf = emf;
    }
    private EntityManagerFactory emf = null;

    public AreaColaboracionJpaController() {
        this.emf = javax.persistence.Persistence.createEntityManagerFactory(Cte.Persistence_Unit_Name);
    }

    public EntityManager getEntityManager() {
        return emf.createEntityManager();
    }

    public void create(AreaColaboracion areaColaboracion) {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            em.persist(areaColaboracion);
            em.getTransaction().commit();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public void edit(AreaColaboracion areaColaboracion) throws NonexistentEntityException, Exception {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            areaColaboracion = em.merge(areaColaboracion);
            em.getTransaction().commit();
        } catch (Exception ex) {
            String msg = ex.getLocalizedMessage();
            if (msg == null || msg.length() == 0) {
                Integer id = areaColaboracion.getId();
                if (findAreaColaboracion(id) == null) {
                    throw new NonexistentEntityException("The areaColaboracion with id " + id + " no longer exists.");
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
            AreaColaboracion areaColaboracion;
            try {
                areaColaboracion = em.getReference(AreaColaboracion.class, id);
                areaColaboracion.getId();
            } catch (EntityNotFoundException enfe) {
                throw new NonexistentEntityException("The areaColaboracion with id " + id + " no longer exists.", enfe);
            }
            em.remove(areaColaboracion);
            em.getTransaction().commit();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public List<AreaColaboracion> findAreaColaboracionEntities() {
        return findAreaColaboracionEntities(true, -1, -1);
    }

    public List<AreaColaboracion> findAreaColaboracionEntities(int maxResults, int firstResult) {
        return findAreaColaboracionEntities(false, maxResults, firstResult);
    }

    private List<AreaColaboracion> findAreaColaboracionEntities(boolean all, int maxResults, int firstResult) {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            cq.select(cq.from(AreaColaboracion.class));
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

    public AreaColaboracion findAreaColaboracion(Integer id) {
        EntityManager em = getEntityManager();
        try {
            return em.find(AreaColaboracion.class, id);
        } finally {
            em.close();
        }
    }

    public int getAreaColaboracionCount() {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            Root<AreaColaboracion> rt = cq.from(AreaColaboracion.class);
            cq.select(em.getCriteriaBuilder().count(rt));
            Query q = em.createQuery(cq);
            return ((Long) q.getSingleResult()).intValue();
        } finally {
            em.close();
        }
    }
    
}
