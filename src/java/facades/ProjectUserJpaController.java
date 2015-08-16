/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package facades;

import entity.ProjectUser;
import entity.exceptions.NonexistentEntityException;
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
 * @author plaul1
 */
public class ProjectUserJpaController implements Serializable {

  public ProjectUserJpaController(EntityManagerFactory emf) {
    this.emf = emf;
  }
  private EntityManagerFactory emf = null;

  public EntityManager getEntityManager() {
    return emf.createEntityManager();
  }

  public void create(ProjectUser projectUser) {
    EntityManager em = null;
    try {
      em = getEntityManager();
      em.getTransaction().begin();
      em.persist(projectUser);
      em.getTransaction().commit();
    } finally {
      if (em != null) {
        em.close();
      }
    }
  }

  public void edit(ProjectUser projectUser) throws NonexistentEntityException, Exception {
    EntityManager em = null;
    try {
      em = getEntityManager();
      em.getTransaction().begin();
      projectUser = em.merge(projectUser);
      em.getTransaction().commit();
    } catch (Exception ex) {
      String msg = ex.getLocalizedMessage();
      if (msg == null || msg.length() == 0) {
        Integer id = projectUser.getId();
        if (findProjectUser(id) == null) {
          throw new NonexistentEntityException("The projectUser with id " + id + " no longer exists.");
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
      ProjectUser projectUser;
      try {
        projectUser = em.getReference(ProjectUser.class, id);
        projectUser.getId();
      } catch (EntityNotFoundException enfe) {
        throw new NonexistentEntityException("The projectUser with id " + id + " no longer exists.", enfe);
      }
      em.remove(projectUser);
      em.getTransaction().commit();
    } finally {
      if (em != null) {
        em.close();
      }
    }
  }

  public List<ProjectUser> findProjectUserEntities() {
    return findProjectUserEntities(true, -1, -1);
  }

  public List<ProjectUser> findProjectUserEntities(int maxResults, int firstResult) {
    return findProjectUserEntities(false, maxResults, firstResult);
  }

  private List<ProjectUser> findProjectUserEntities(boolean all, int maxResults, int firstResult) {
    EntityManager em = getEntityManager();
    try {
      CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
      cq.select(cq.from(ProjectUser.class));
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

  public ProjectUser findProjectUser(Integer id) {
    EntityManager em = getEntityManager();
    try {
      return em.find(ProjectUser.class, id);
    } finally {
      em.close();
    }
  }

  public int getProjectUserCount() {
    EntityManager em = getEntityManager();
    try {
      CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
      Root<ProjectUser> rt = cq.from(ProjectUser.class);
      cq.select(em.getCriteriaBuilder().count(rt));
      Query q = em.createQuery(cq);
      return ((Long) q.getSingleResult()).intValue();
    } finally {
      em.close();
    }
  }
  
}
