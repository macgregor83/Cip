/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package es.cip.bussines.dao.control;

import es.cip.bussines.dao.control.exceptions.NonexistentEntityException;
import es.cip.bussines.dao.model.Convocatoria;
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
public class ConvocatoriaJpaController implements Serializable {

    public ConvocatoriaJpaController(EntityManagerFactory emf) {
        this.emf = emf;
    }

    public ConvocatoriaJpaController() {
        this.emf = javax.persistence.Persistence.createEntityManagerFactory(Cte.Persistence_Unit_Name);
    }
    
    private EntityManagerFactory emf = null;

    public EntityManager getEntityManager() {
        return emf.createEntityManager();
    }

    public void create(Convocatoria convocatoria) {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            em.persist(convocatoria);
            em.getTransaction().commit();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public void edit(Convocatoria convocatoria) throws NonexistentEntityException, Exception {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            convocatoria = em.merge(convocatoria);
            em.getTransaction().commit();
        } catch (Exception ex) {
            String msg = ex.getLocalizedMessage();
            if (msg == null || msg.length() == 0) {
                Integer id = convocatoria.getId();
                if (findConvocatoria(id) == null) {
                    throw new NonexistentEntityException("The convocatoria with id " + id + " no longer exists.");
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
            Convocatoria convocatoria;
            try {
                convocatoria = em.getReference(Convocatoria.class, id);
                convocatoria.getId();
            } catch (EntityNotFoundException enfe) {
                throw new NonexistentEntityException("The convocatoria with id " + id + " no longer exists.", enfe);
            }
            em.remove(convocatoria);
            em.getTransaction().commit();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public List<Convocatoria> findConvocatoriaEntities() {
        return findConvocatoriaEntities(true, -1, -1);
    }

    public List<Convocatoria> findConvocatoriaEntities(int maxResults, int firstResult) {
        return findConvocatoriaEntities(false, maxResults, firstResult);
    }

    private List<Convocatoria> findConvocatoriaEntities(boolean all, int maxResults, int firstResult) {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            cq.select(cq.from(Convocatoria.class));
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

    public Convocatoria findConvocatoria(Integer id) {
        EntityManager em = getEntityManager();
        try {
            return em.find(Convocatoria.class, id);
        } finally {
            em.close();
        }
    }
    public List<Convocatoria> findConvocatoria(String nombreProyecto) {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery(Convocatoria.class);
            Root<Convocatoria> c = cq.from(Convocatoria.class);
            cq.select(c);
            cq.where(em.getCriteriaBuilder().or(
                            em.getCriteriaBuilder().like(c.get("id"), "%" + nombreProyecto.trim() + "%"),
                            em.getCriteriaBuilder().like(c.get("Convocatoria"), "%" + nombreProyecto.trim() + "%"))
                    );
            Query q = em.createQuery(cq);
            return q.getResultList();
        } finally {
            em.close();
        }
    }
    public int getConvocatoriaCount() {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            Root<Convocatoria> rt = cq.from(Convocatoria.class);
            cq.select(em.getCriteriaBuilder().count(rt));
            Query q = em.createQuery(cq);
            return ((Long) q.getSingleResult()).intValue();
        } finally {
            em.close();
        }
    }
    
}
