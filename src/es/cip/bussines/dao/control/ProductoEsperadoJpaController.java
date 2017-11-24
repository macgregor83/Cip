/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package es.cip.bussines.dao.control;

import es.cip.bussines.dao.control.exceptions.NonexistentEntityException;
import es.cip.bussines.dao.model.ProductoEsperado;
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
public class ProductoEsperadoJpaController implements Serializable {

    public ProductoEsperadoJpaController(EntityManagerFactory emf) {
        this.emf = emf;
    }
    private EntityManagerFactory emf = null;

    public EntityManager getEntityManager() {
        return emf.createEntityManager();
    }

    public void create(ProductoEsperado productoEsperado) {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            em.persist(productoEsperado);
            em.getTransaction().commit();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public void edit(ProductoEsperado productoEsperado) throws NonexistentEntityException, Exception {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            productoEsperado = em.merge(productoEsperado);
            em.getTransaction().commit();
        } catch (Exception ex) {
            String msg = ex.getLocalizedMessage();
            if (msg == null || msg.length() == 0) {
                Integer id = productoEsperado.getId();
                if (findProductoEsperado(id) == null) {
                    throw new NonexistentEntityException("The productoEsperado with id " + id + " no longer exists.");
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
            ProductoEsperado productoEsperado;
            try {
                productoEsperado = em.getReference(ProductoEsperado.class, id);
                productoEsperado.getId();
            } catch (EntityNotFoundException enfe) {
                throw new NonexistentEntityException("The productoEsperado with id " + id + " no longer exists.", enfe);
            }
            em.remove(productoEsperado);
            em.getTransaction().commit();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public List<ProductoEsperado> findProductoEsperadoEntities() {
        return findProductoEsperadoEntities(true, -1, -1);
    }

    public List<ProductoEsperado> findProductoEsperadoEntities(int maxResults, int firstResult) {
        return findProductoEsperadoEntities(false, maxResults, firstResult);
    }

    private List<ProductoEsperado> findProductoEsperadoEntities(boolean all, int maxResults, int firstResult) {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            cq.select(cq.from(ProductoEsperado.class));
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

    public ProductoEsperado findProductoEsperado(Integer id) {
        EntityManager em = getEntityManager();
        try {
            return em.find(ProductoEsperado.class, id);
        } finally {
            em.close();
        }
    }

    public int getProductoEsperadoCount() {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            Root<ProductoEsperado> rt = cq.from(ProductoEsperado.class);
            cq.select(em.getCriteriaBuilder().count(rt));
            Query q = em.createQuery(cq);
            return ((Long) q.getSingleResult()).intValue();
        } finally {
            em.close();
        }
    }
    
}
