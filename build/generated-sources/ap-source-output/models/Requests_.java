package models;

import java.util.Date;
import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;
import models.Users;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2015-05-31T23:25:08")
@StaticMetamodel(Requests.class)
public class Requests_ { 

    public static volatile SingularAttribute<Requests, String> post;
    public static volatile SingularAttribute<Requests, Integer> requestID;
    public static volatile SingularAttribute<Requests, Boolean> status;
    public static volatile SingularAttribute<Requests, Date> createdAt;
    public static volatile SingularAttribute<Requests, Users> userId;

}