/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package es.cip.bussines.dao.control;

import es.cip.bussines.dao.control.exceptions.NonexistentEntityException;
import es.cip.bussines.dao.model.Campus;
import es.cip.util.cte.Cte;
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
public class CampusJpaController implements Serializable {

    public CampusJpaController(EntityManagerFactory emf) {
        this.emf = emf;
    }
    private EntityManagerFactory emf = null;

    public CampusJpaController() {
        this.emf = javax.persistence.Persistence.createEntityManagerFactory(Cte.Persistence_Unit_Name);
    }

    public EntityManager getEntityManager() {
        return emf.createEntityManager();
    }

    public void create(Campus campus) {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            em.persist(campus);
            em.getTransaction().commit();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public void edit(Campus campus) throws NonexistentEntityException, Exception {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            campus = em.merge(campus);
            em.getTransaction().commit();
        } catch (Exception ex) {
            String msg = ex.getLocalizedMessage();
            if (msg == null || msg.length() == 0) {
                Long id = campus.getId();
                if (findCampus(id) == null) {
                    throw new NonexistentEntityException("The campus with id " + id + " no longer exists.");
                }
            }
            throw ex;
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public void destroy(Long id) throws NonexistentEntityException {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            Campus campus;
            try {
                campus = em.getReference(Campus.class, id);
                campus.getId();
            } catch (EntityNotFoundException enfe) {
                throw new NonexistentEntityException("The campus with id " + id + " no longer exists.", enfe);
            }
            em.remove(campus);
            em.getTransaction().commit();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public List<Campus> findCampusEntities() {
        return findCampusEntities(true, -1, -1);
    }

    public List<Campus> findCampusEntities(int maxResults, int firstResult) {
        return findCampusEntities(false, maxResults, firstResult);
    }

    private List<Campus> findCampusEntities(boolean all, int maxResults, int firstResult) {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            cq.select(cq.from(Campus.class));
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

    public Campus findCampus(Long id) {
        EntityManager em = getEntityManager();
        try {
            return em.find(Campus.class, id);
        } finally {
            em.close();
        }
    }

    public int getCampusCount() {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            Root<Campus> rt = cq.from(Campus.class);
            cq.select(em.getCriteriaBuilder().count(rt));
            Query q = em.createQuery(cq);
            return ((Long) q.getSingleResult()).intValue();
        } finally {
            em.close();
        }
    }
    
}
