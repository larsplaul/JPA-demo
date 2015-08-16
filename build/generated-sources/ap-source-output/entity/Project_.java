package entity;

import entity.ProjectUser;
import entity.Task;
import java.util.Date;
import javax.annotation.Generated;
import javax.persistence.metamodel.ListAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2015-08-16T22:57:16")
@StaticMetamodel(Project.class)
public class Project_ { 

    public static volatile SingularAttribute<Project, Integer> id;
    public static volatile ListAttribute<Project, ProjectUser> projectUsers;
    public static volatile SingularAttribute<Project, Date> lastModified;
    public static volatile SingularAttribute<Project, Date> created;
    public static volatile SingularAttribute<Project, String> description;
    public static volatile SingularAttribute<Project, String> name;
    public static volatile ListAttribute<Project, Task> tasks;

}