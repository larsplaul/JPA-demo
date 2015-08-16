package entity;

import entity.Project;
import java.util.Date;
import javax.annotation.Generated;
import javax.persistence.metamodel.ListAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2015-08-16T22:57:16")
@StaticMetamodel(ProjectUser.class)
public class ProjectUser_ { 

    public static volatile SingularAttribute<ProjectUser, Integer> id;
    public static volatile ListAttribute<ProjectUser, Project> projects;
    public static volatile SingularAttribute<ProjectUser, String> email;
    public static volatile SingularAttribute<ProjectUser, Date> created;
    public static volatile SingularAttribute<ProjectUser, String> userName;

}