package entity;

import entity.Semester;
import javax.annotation.Generated;
import javax.persistence.metamodel.CollectionAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2017-08-24T19:00:27")
@StaticMetamodel(Teacher.class)
public class Teacher_ { 

    public static volatile SingularAttribute<Teacher, String> firstname;
    public static volatile CollectionAttribute<Teacher, Semester> semesterCollection;
    public static volatile SingularAttribute<Teacher, Long> id;
    public static volatile SingularAttribute<Teacher, String> lastname;

}