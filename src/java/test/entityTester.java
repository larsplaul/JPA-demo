package test;

import entity.Project;
import entity.ProjectUser;
import java.util.Date;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;


public class entityTester {
  
  
  public static void main(String[] args) {
    EntityManagerFactory emf = Persistence.createEntityManagerFactory("ExamEx1PU", null);
    EntityManager em = emf.createEntityManager();
    ProjectUser pu = em.find(ProjectUser.class, 1);
    
       
    System.out.println(pu.getUserName());
    System.out.println("Total project involved in: "+pu.getProjects().size());
    
    Project project = em.find(Project.class, 1);
    System.out.println("Participators in project: "+project.getName());
    System.out.println(project.getDescription());
    for(ProjectUser projectUser : project.getProjectUsers()){
      System.out.println(projectUser.getUserName());
    }
    
    ProjectUser christian = new ProjectUser("clns","clns@cphbusiness.dk",new Date());
    christian.addProject(project);
    project.addProjectUser(christian);
    em.getTransaction().begin();
    em.persist(christian);
    em.merge(project);
    em.getTransaction().commit();
    System.out.println("###########");
    System.out.println("Participators in project: "+project.getName());
    System.out.println(project.getDescription());
    for(ProjectUser projectUser : project.getProjectUsers()){
      System.out.println(projectUser.getUserName());
    }
    
    
   
    
    
  }
  
}
