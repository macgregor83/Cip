/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package es.cip.bussines.dao.control;

import es.cip.bussines.dao.control.exceptions.NonexistentEntityException;
import es.cip.bussines.dao.model.RecursoHumanoProyecto;
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
public class RecursoHumanoProyectoJpaController implements Serializable {

    public RecursoHumanoProyectoJpaController(EntityManagerFactory emf) {
        this.emf = emf;
    }
    private EntityManagerFactory emf = null;

    public RecursoHumanoProyectoJpaController() {
        this.emf = javax.persistence.Persistence.createEntityManagerFactory(Cte.Persistence_Unit_Name);
    }

    public EntityManager getEntityManager() {
        return emf.createEntityManager();
    }

    public void create(RecursoHumanoProyecto recursoHumanoProyecto) {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            em.persist(recursoHumanoProyecto);
            em.getTransaction().commit();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public void edit(RecursoHumanoProyecto recursoHumanoProyecto) throws NonexistentEntityException, Exception {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            recursoHumanoProyecto = em.merge(recursoHumanoProyecto);
            em.getTransaction().commit();
        } catch (Exception ex) {
            String msg = ex.getLocalizedMessage();
            if (msg == null || msg.length() == 0) {
                Integer id = recursoHumanoProyecto.getId();
                if (findRecursoHumanoProyecto(id) == null) {
                    throw new NonexistentEntityException("The recursoHumanoProyecto with id " + id + " no longer exists.");
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
            RecursoHumanoProyecto recursoHumanoProyecto;
            try {
                recursoHumanoProyecto = em.getReference(RecursoHumanoProyecto.class, id);
                recursoHumanoProyecto.getId();
            } catch (EntityNotFoundException enfe) {
                throw new NonexistentEntityException("The recursoHumanoProyecto with id " + id + " no longer exists.", enfe);
            }
            em.remove(recursoHumanoProyecto);
            em.getTransaction().commit();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public List<RecursoHumanoProyecto> findRecursoHumanoProyectoEntities() {
        return findRecursoHumanoProyectoEntities(true, -1, -1);
    }

    public List<RecursoHumanoProyecto> findRecursoHumanoProyectoEntities(int maxResults, int firstResult) {
        return findRecursoHumanoProyectoEntities(false, maxResults, firstResult);
    }

    private List<RecursoHumanoProyecto> findRecursoHumanoProyectoEntities(boolean all, int maxResults, int firstResult) {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            cq.select(cq.from(RecursoHumanoProyecto.class));
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

    public RecursoHumanoProyecto findRecursoHumanoProyecto(Integer id) {
        EntityManager em = getEntityManager();
        try {
            return em.find(RecursoHumanoProyecto.class, id);
        } finally {
            em.close();
        }
    }

    public int getRecursoHumanoProyectoCount() {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            Root<RecursoHumanoProyecto> rt = cq.from(RecursoHumanoProyecto.class);
            cq.select(em.getCriteriaBuilder().count(rt));
            Query q = em.createQuery(cq);
            return ((Long) q.getSingleResult()).intValue();
        } finally {
            em.close();
        }
    }
    
}
