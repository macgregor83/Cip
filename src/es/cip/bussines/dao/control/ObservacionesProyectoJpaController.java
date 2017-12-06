/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package es.cip.bussines.dao.control;

import es.cip.bussines.dao.control.exceptions.NonexistentEntityException;
import es.cip.bussines.dao.model.ObservacionesProyecto;
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
public class ObservacionesProyectoJpaController implements Serializable {

    public ObservacionesProyectoJpaController(EntityManagerFactory emf) {
        this.emf = emf;
    }
    private EntityManagerFactory emf = null;

    public ObservacionesProyectoJpaController() {
        this.emf = javax.persistence.Persistence.createEntityManagerFactory(Cte.Persistence_Unit_Name);
    }

    public EntityManager getEntityManager() {
        return emf.createEntityManager();
    }

    public void create(ObservacionesProyecto observacionesProyecto) {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            em.persist(observacionesProyecto);
            em.getTransaction().commit();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public void edit(ObservacionesProyecto observacionesProyecto) throws NonexistentEntityException, Exception {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            observacionesProyecto = em.merge(observacionesProyecto);
            em.getTransaction().commit();
        } catch (Exception ex) {
            String msg = ex.getLocalizedMessage();
            if (msg == null || msg.length() == 0) {
                Integer id = observacionesProyecto.getId();
                if (findObservacionesProyecto(id) == null) {
                    throw new NonexistentEntityException("The observacionesProyecto with id " + id + " no longer exists.");
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
            ObservacionesProyecto observacionesProyecto;
            try {
                observacionesProyecto = em.getReference(ObservacionesProyecto.class, id);
                observacionesProyecto.getId();
            } catch (EntityNotFoundException enfe) {
                throw new NonexistentEntityException("The observacionesProyecto with id " + id + " no longer exists.", enfe);
            }
            em.remove(observacionesProyecto);
            em.getTransaction().commit();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public List<ObservacionesProyecto> findObservacionesProyectoEntities() {
        return findObservacionesProyectoEntities(true, -1, -1);
    }

    public List<ObservacionesProyecto> findObservacionesProyectoEntities(int maxResults, int firstResult) {
        return findObservacionesProyectoEntities(false, maxResults, firstResult);
    }

    private List<ObservacionesProyecto> findObservacionesProyectoEntities(boolean all, int maxResults, int firstResult) {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            cq.select(cq.from(ObservacionesProyecto.class));
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

    public ObservacionesProyecto findObservacionesProyecto(Integer id) {
        EntityManager em = getEntityManager();
        try {
            return em.find(ObservacionesProyecto.class, id);
        } finally {
            em.close();
        }
    }

    public List<ObservacionesProyecto> findProyecto(String idProyecto) {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery(ObservacionesProyecto.class);
            Root<ObservacionesProyecto> f = cq.from(ObservacionesProyecto.class);
            cq.select(f).distinct(true);
            cq.where(
                    em.getCriteriaBuilder().like(f.get("idProyecto"), idProyecto)
            );
            cq.orderBy(em.getCriteriaBuilder().desc(f.get("idProyecto")));
            Query q = em.createQuery(cq);
            return q.getResultList();
        } finally {
            em.close();
        }
    }

    public int getObservacionesProyectoCount() {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            Root<ObservacionesProyecto> rt = cq.from(ObservacionesProyecto.class);
            cq.select(em.getCriteriaBuilder().count(rt));
            Query q = em.createQuery(cq);
            return ((Long) q.getSingleResult()).intValue();
        } finally {
            em.close();
        }
    }

}
