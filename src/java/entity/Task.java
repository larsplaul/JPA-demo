
package entity;

import java.io.Serializable;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;


@Entity
@Table(name = "TASK")
public class Task implements Serializable {
  private static final long serialVersionUID = 1L;
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Integer id;
  
  private String name;
  private String description;
  private int hoursAssigned;
  private int hoursUsed;
  @ManyToOne
  private Project project;

  public Task(String name, String description) {
    this.name = name;
    this.description = description;
    this.hoursAssigned = 0;
    this.hoursUsed = 0;
  }

  public Task() {
  }
  

  
  public Integer getId() {
    return id;
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

  public int getHoursAssigned() {
    return hoursAssigned;
  }

  public void setHoursAssigned(int hoursAssigned) {
    this.hoursAssigned = hoursAssigned;
  }

  public int getHoursUsed() {
    return hoursUsed;
  }

  public void setHoursUsed(int hoursUsed) {
    this.hoursUsed = hoursUsed;
  }

  void addProject(Project aThis) {
    throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
  }


  
  
}
