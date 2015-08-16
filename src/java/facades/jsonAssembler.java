
package facades;

import com.google.gson.FieldNamingPolicy;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonArray;
import com.google.gson.JsonObject;
import entity.Project;
import entity.ProjectUser;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;

public class jsonAssembler {
 EntityManagerFactory emf = Persistence.createEntityManagerFactory("ExamEx1PU");
  private static final Gson gson = new GsonBuilder().setPrettyPrinting().serializeNulls().setFieldNamingPolicy(FieldNamingPolicy.UPPER_CAMEL_CASE).create();
  //private static final Gson gson = new GsonBuilder().serializeNulls().setFieldNamingPolicy(FieldNamingPolicy.UPPER_CAMEL_CASE).create();

  public EntityManager getEntityManager() {
    return emf.createEntityManager();
  }
  public String getUser(int id) {
    
    EntityManager em = getEntityManager();
    Query q = em.createQuery("select u from ProjectUser u where u.id = :id");
    q.setParameter("id",id);
    ProjectUser user = (ProjectUser) q.getSingleResult();
    
    JsonObject userAssJson = new JsonObject();
    userAssJson.addProperty("id", user.getId());
    userAssJson.addProperty("userName", user.getUserName());
        
    JsonArray jsonProjects = new JsonArray();
    for (Project project : user.getProjects()) {
      JsonObject jp = new JsonObject();
      jp.addProperty("name", project.getName());
      jp.addProperty("Description", project.getDescription());
      jsonProjects.add(jp);
    }
    userAssJson.add("Projects", jsonProjects);
    em.close();
    return gson.toJson(userAssJson);
   
  }
}
