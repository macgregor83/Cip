/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package es.cip.bussines.dao.control;

import es.cip.bussines.dao.control.exceptions.NonexistentEntityException;
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
public class FaceJpaController implements Serializable {

    public FaceJpaController(EntityManagerFactory emf) {
        this.emf = emf;
    }
    private EntityManagerFactory emf = null;

    public FaceJpaController() {
        this.emf = javax.persistence.Persistence.createEntityManagerFactory(Cte.Persistence_Unit_Name);
    }

    public EntityManager getEntityManager() {
        return emf.createEntityManager();
    }

    public void create(Face face) {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            em.persist(face);
            em.getTransaction().commit();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public void edit(Face face) throws NonexistentEntityException, Exception {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            face = em.merge(face);
            em.getTransaction().commit();
        } catch (Exception ex) {
            String msg = ex.getLocalizedMessage();
            if (msg == null || msg.length() == 0) {
                Integer id = face.getId();
                if (findFace(id) == null) {
                    throw new NonexistentEntityException("The face with id " + id + " no longer exists.");
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
            Face face;
            try {
                face = em.getReference(Face.class, id);
                face.getId();
            } catch (EntityNotFoundException enfe) {
                throw new NonexistentEntityException("The face with id " + id + " no longer exists.", enfe);
            }
            em.remove(face);
            em.getTransaction().commit();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public List<Face> findFaceEntities() {
        return findFaceEntities(true, -1, -1);
    }

    public List<Face> findFaceEntities(int maxResults, int firstResult) {
        return findFaceEntities(false, maxResults, firstResult);
    }

    private List<Face> findFaceEntities(boolean all, int maxResults, int firstResult) {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            cq.select(cq.from(Face.class));
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

    public Face findFace(Integer id) {
        EntityManager em = getEntityManager();
        try {
            return em.find(Face.class, id);
        } finally {
            em.close();
        }
    }

    public List<Face> findProyecto(String nombreProyecto, Integer idUsuario, Integer minima, Integer maxima, Integer idEstatusFase) {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery(Face.class);
            Root<Face> f = cq.from(Face.class);
            Root<Metodologia> m = cq.from(Metodologia.class);
            Root<Proyecto> p = cq.from(Proyecto.class);
            Root<RecursoHumanoProyecto> rhp = cq.from(RecursoHumanoProyecto.class);
            Root<RecursoHumanoDatos> rhd = cq.from(RecursoHumanoDatos.class);
            cq.select(f).distinct(true);
            cq.where(
                    em.getCriteriaBuilder().and(
                            em.getCriteriaBuilder().or(
                                    em.getCriteriaBuilder().like(p.get("id"), "%" + nombreProyecto.trim() + "%"),
                                    em.getCriteriaBuilder().like(p.get("NombreProyecto"), "%" + nombreProyecto.trim() + "%")),
                            em.getCriteriaBuilder().like(f.get("idEstatusFase"), idEstatusFase + ""),
                            em.getCriteriaBuilder().like(m.get("id"), f.get("idMetodologia")),
                            em.getCriteriaBuilder().like(p.get("id"), m.get("idProyecto")),
                            em.getCriteriaBuilder().like(p.get("id"), rhp.get("idProyecto")),
                            em.getCriteriaBuilder().like(rhd.get("id"), rhp.get("idRecursoHumanoDatos")),
                            em.getCriteriaBuilder().like(rhd.get("idUsuario"), idUsuario + ""),
                            //                    em.getCriteriaBuilder().between((p.get("idEstatusProyecto")), minima, maxima),
                            em.getCriteriaBuilder().or(
                                    em.getCriteriaBuilder().like(p.get("idEstatusProyecto"), minima + ""),
                                    em.getCriteriaBuilder().like(p.get("idEstatusProyecto"), maxima + "")
                            )
                    )
            );
            Query q = em.createQuery(cq);
            return q.getResultList();
        } finally {
            em.close();
        }
    }

    public List<Face> findProyecto(String idProyecto) {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery(Face.class);
            Root<Face> f = cq.from(Face.class);
            Root<Metodologia> m = cq.from(Metodologia.class);

            cq.select(f).distinct(true);
            cq.where(
                    em.getCriteriaBuilder().and(
                            em.getCriteriaBuilder().like(m.get("idProyecto"), "%" + idProyecto.trim() + "%"),
                            em.getCriteriaBuilder().like(m.get("id"), f.get("idMetodologia"))
                    )
            );
            Query q = em.createQuery(cq);
            return q.getResultList();
        } finally {
            em.close();
        }
    }

    public int getFaceCount() {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            Root<Face> rt = cq.from(Face.class);
            cq.select(em.getCriteriaBuilder().count(rt));
            Query q = em.createQuery(cq);
            return ((Long) q.getSingleResult()).intValue();
        } finally {
            em.close();
        }
    }

}
