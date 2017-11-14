/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package es.cip.bussines.dao.control;

import es.cip.bussines.dao.control.exceptions.NonexistentEntityException;
import es.cip.bussines.dao.model.RecursosMateriales;
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
public class RecursosMaterialesJpaController implements Serializable {

    public RecursosMaterialesJpaController() {
        this.emf = javax.persistence.Persistence.createEntityManagerFactory(Cte.Persistence_Unit_Name);
    }

    public RecursosMaterialesJpaController(EntityManagerFactory emf) {
        this.emf = emf;
    }
    private EntityManagerFactory emf = null;

    public EntityManager getEntityManager() {
        return emf.createEntityManager();
    }

    public void create(RecursosMateriales recursosMateriales) {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            em.persist(recursosMateriales);
            em.getTransaction().commit();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public void edit(RecursosMateriales recursosMateriales) throws NonexistentEntityException, Exception {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            recursosMateriales = em.merge(recursosMateriales);
            em.getTransaction().commit();
        } catch (Exception ex) {
            String msg = ex.getLocalizedMessage();
            if (msg == null || msg.length() == 0) {
                Integer id = recursosMateriales.getId();
                if (findRecursosMateriales(id) == null) {
                    throw new NonexistentEntityException("The recursosMateriales with id " + id + " no longer exists.");
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
            RecursosMateriales recursosMateriales;
            try {
                recursosMateriales = em.getReference(RecursosMateriales.class, id);
                recursosMateriales.getId();
            } catch (EntityNotFoundException enfe) {
                throw new NonexistentEntityException("The recursosMateriales with id " + id + " no longer exists.", enfe);
            }
            em.remove(recursosMateriales);
            em.getTransaction().commit();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public List<RecursosMateriales> findRecursosMaterialesEntities() {
        return findRecursosMaterialesEntities(true, -1, -1);
    }

    public List<RecursosMateriales> findRecursosMaterialesEntities(int maxResults, int firstResult) {
        return findRecursosMaterialesEntities(false, maxResults, firstResult);
    }

    private List<RecursosMateriales> findRecursosMaterialesEntities(boolean all, int maxResults, int firstResult) {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            cq.select(cq.from(RecursosMateriales.class));
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

    public RecursosMateriales findRecursosMateriales(Integer id) {
        EntityManager em = getEntityManager();
        try {
            return em.find(RecursosMateriales.class, id);
        } finally {
            em.close();
        }
    }

    public int getRecursosMaterialesCount() {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            Root<RecursosMateriales> rt = cq.from(RecursosMateriales.class);
            cq.select(em.getCriteriaBuilder().count(rt));
            Query q = em.createQuery(cq);
            return ((Long) q.getSingleResult()).intValue();
        } finally {
            em.close();
        }
    }

}
