package models;

import java.util.Date;
import javax.annotation.Generated;
import javax.persistence.metamodel.CollectionAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;
import models.Requests;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2015-05-31T23:25:08")
@StaticMetamodel(Users.class)
public class Users_ { 

    public static volatile SingularAttribute<Users, Integer> userID;
    public static volatile SingularAttribute<Users, String> paswword;
    public static volatile SingularAttribute<Users, String> bloodType;
    public static volatile SingularAttribute<Users, String> phone;
    public static volatile CollectionAttribute<Users, Requests> requestsCollection;
    public static volatile SingularAttribute<Users, String> email;
    public static volatile SingularAttribute<Users, Boolean> status;
    public static volatile SingularAttribute<Users, String> userName;
    public static volatile SingularAttribute<Users, Date> createdat;
    public static volatile SingularAttribute<Users, String> city;

}