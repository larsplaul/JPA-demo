package entity;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;


@Entity
@Table(name = "PROJECT")
public class Project implements Serializable {
  private static final long serialVersionUID = 1L;
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Integer id;
  
  
  @ManyToMany(mappedBy = "projects")
  @JoinTable(name = "PROJECTUSER_PROJECT")
  private List<ProjectUser> projectUsers;

  public Integer getId() {
    return id;
  }
  
  private String name;
  private String description;
  @Temporal(javax.persistence.TemporalType.DATE)
  private Date created;
  @Temporal(javax.persistence.TemporalType.DATE)
  private Date lastModified;
    
  @OneToMany(mappedBy = "project")
  List<Task> tasks = new ArrayList();
  
  public Project(String name, String description, Date created) {
    this.name = name;
    this.description = description;
    this.created = created;
    this.lastModified = this.created;
  }

  public Project() {
  }
  

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public String getDescription() {
    return description;
  }

  public void setDescription(String description) {
    this.description = description;
  }

  public Date getCreated() {
    return created;
  }

  public void setCreated(Date created) {
    this.created = created;
  }

  public Date getLastModified() {
    return lastModified;
  }

  public void setLastModified(Date lastModified) {
    this.lastModified = lastModified;
  }

   public void addTask(Task t){
    tasks.add(t);
    t.addProject(this);
  }

  public List<ProjectUser> getProjectUsers() {
    return projectUsers;
  }

  public void addProjectUser(ProjectUser pu) {
    projectUsers.add(pu);
  }

  
  
}
