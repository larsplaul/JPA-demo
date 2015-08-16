package entity;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;

@Entity
@Table(name = "PROJECT_USER")
public class ProjectUser implements Serializable {
  private static final long serialVersionUID = 1L;
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Integer id;
  
  
  @ManyToMany
  @JoinTable(name = "PROJECTUSER_PROJECT")
   List<Project> projects = new ArrayList();
  
  @Column(unique=true)
  private String userName;
  private String email;

  public ProjectUser() {
  }

  public String getUserName() {
    return userName;
  }

  public void setUserName(String userName) {
    this.userName = userName;
  }

  public String getEmail() {
    return email;
  }

  public void setEmail(String email) {
    this.email = email;
  }

  public Date getCreated() {
    return created;
  }

  public void setCreated(Date created) {
    this.created = created;
  }
  
  @Temporal(javax.persistence.TemporalType.DATE)
  private Date created;

  public ProjectUser(String userName, String email, Date created) {
    this.userName = userName;
    this.email = email;
    this.created = created;
  }
  
  public Integer getId() {
    return id;
  }

  public void setId(Integer id) {
    this.id = id;
  }

  public List<Project> getProjects() {
    return projects;
  }

  public void addProject(Project p) {
    projects.add(p);
  }
  
 

  
  
}
