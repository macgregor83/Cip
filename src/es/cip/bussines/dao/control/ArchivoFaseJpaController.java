/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package es.cip.bussines.dao.control;

import es.cip.bussines.dao.control.exceptions.NonexistentEntityException;
import es.cip.bussines.dao.model.ArchivoFase;
import es.cip.bussines.dao.model.Face;
import es.cip.bussines.dao.model.Metodologia;
import es.cip.bussines.dao.model.Proyecto;
import es.cip.bussines.dao.model.RecursoHumanoDatos;
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
public class ArchivoFaseJpaController implements Serializable {

    public ArchivoFaseJpaController(EntityManagerFactory emf) {
        this.emf = emf;
    }
    private EntityManagerFactory emf = null;

    public ArchivoFaseJpaController() {
        this.emf = javax.persistence.Persistence.createEntityManagerFactory(Cte.Persistence_Unit_Name);
    }

    public EntityManager getEntityManager() {
        return emf.createEntityManager();
    }

    public void create(ArchivoFase archivoFase) {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            em.persist(archivoFase);
            em.getTransaction().commit();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public void edit(ArchivoFase archivoFase) throws NonexistentEntityException, Exception {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            archivoFase = em.merge(archivoFase);
            em.getTransaction().commit();
        } catch (Exception ex) {
            String msg = ex.getLocalizedMessage();
            if (msg == null || msg.length() == 0) {
                Integer id = archivoFase.getId();
                if (findArchivoFase(id) == null) {
                    throw new NonexistentEntityException("The archivoFase with id " + id + " no longer exists.");
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
            ArchivoFase archivoFase;
            try {
                archivoFase = em.getReference(ArchivoFase.class, id);
                archivoFase.getId();
            } catch (EntityNotFoundException enfe) {
                throw new NonexistentEntityException("The archivoFase with id " + id + " no longer exists.", enfe);
            }
            em.remove(archivoFase);
            em.getTransaction().commit();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public List<ArchivoFase> findArchivoFaseEntities() {
        return findArchivoFaseEntities(true, -1, -1);
    }

    public List<ArchivoFase> findArchivoFaseEntities(int maxResults, int firstResult) {
        return findArchivoFaseEntities(false, maxResults, firstResult);
    }

    private List<ArchivoFase> findArchivoFaseEntities(boolean all, int maxResults, int firstResult) {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            cq.select(cq.from(ArchivoFase.class));
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

    public ArchivoFase findArchivoFase(Integer id) {
        EntityManager em = getEntityManager();
        try {
            return em.find(ArchivoFase.class, id);
        } finally {
            em.close();
        }
    }

    public List<ArchivoFase> findProyecto(String idProyecto, Integer idUsuario) {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery(ArchivoFase.class);
            Root<ArchivoFase> af = cq.from(ArchivoFase.class);
            Root<Face> f = cq.from(Face.class);
            Root<Metodologia> m = cq.from(Metodologia.class);
            Root<Proyecto> p = cq.from(Proyecto.class);
            Root<RecursoHumanoProyecto> rhp = cq.from(RecursoHumanoProyecto.class);
            Root<RecursoHumanoDatos> rhd = cq.from(RecursoHumanoDatos.class);
            cq.select(af);
            cq.where(
                    em.getCriteriaBuilder().and(
                            em.getCriteriaBuilder().like(p.get("id"), idProyecto),
                            em.getCriteriaBuilder().like(m.get("id"), f.get("idMetodologia")),
                            em.getCriteriaBuilder().like(f.get("id"), af.get("idFace")),
                            em.getCriteriaBuilder().like(p.get("id"), m.get("idProyecto")),
                            em.getCriteriaBuilder().like(p.get("id"), rhp.get("idProyecto")),
                            em.getCriteriaBuilder().like(rhd.get("id"), rhp.get("idRecursoHumanoDatos")),
                            em.getCriteriaBuilder().like(rhd.get("idUsuario"), idUsuario + "")
                    )
            );
            Query q = em.createQuery(cq);
            return q.getResultList();
        } finally {
            em.close();
        }
    }

    public List<ArchivoFase> findFase(Integer idFace, Integer idEstatus) {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery(ArchivoFase.class);
            Root<ArchivoFase> af = cq.from(ArchivoFase.class);
            //Root<Face> f = cq.from(Face.class);

            cq.select(af);
            cq.where(
                    em.getCriteriaBuilder().and(
                            em.getCriteriaBuilder().like(af.get("idFace"), idFace + "")//,
                            //em.getCriteriaBuilder().like(f.get("idEstatusFase"), idEstatus + ""),
                           // em.getCriteriaBuilder().like(f.get("id"), af.get("idFace"))
                    )
            );
            Query q = em.createQuery(cq);
            return q.getResultList();
        } finally {
            em.close();
        }
    }

    public List<ArchivoFase> findFase(Integer idFace) {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery(ArchivoFase.class);
            Root<ArchivoFase> af = cq.from(ArchivoFase.class);
            cq.select(af);
            cq.where(em.getCriteriaBuilder().like(af.get("idFace"), idFace + ""));
            Query q = em.createQuery(cq);
            return q.getResultList();
        } finally {
            em.close();
        }
    }

    public int getArchivoFaseCount() {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            Root<ArchivoFase> rt = cq.from(ArchivoFase.class);
            cq.select(em.getCriteriaBuilder().count(rt));
            Query q = em.createQuery(cq);
            return ((Long) q.getSingleResult()).intValue();
        } finally {
            em.close();
        }
    }

}
