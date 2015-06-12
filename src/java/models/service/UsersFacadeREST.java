/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package models.service;

import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import models.Users;

/**
 *
 * @author Morsy
 */
@Stateless
@Path("models.users")
public class UsersFacadeREST extends AbstractFacade<Users> {
    @PersistenceContext(unitName = "Qatra_servicesPU")
    private EntityManager em;

    public UsersFacadeREST() {
        super(Users.class);
    }

    @POST
    @Override
    @Consumes({"application/xml", "application/json"})
    public void create(Users entity) {
        super.create(entity);
    }

    @PUT
    @Path("{id}")
    @Consumes({"application/xml", "application/json"})
    public void edit(@PathParam("id") Integer id, Users entity) {
        super.edit(entity);
    }

    @DELETE
    @Path("{id}")
    public void remove(@PathParam("id") Integer id) {
        super.remove(super.find(id));
    }

    @GET
    @Path("{id}")
    @Produces({"application/xml", "application/json"})
    public Users find(@PathParam("id") Integer id) {
        return super.find(id);
    }

    @GET
    @Override
    @Produces({"application/xml", "application/json"})
    public List<Users> findAll() {
        return super.findAll();
    }

    //search
    
@GET
@Path("SearchUsers/{name}")
@Produces({"application/xml", "application/json"})
    public List<Users> searchUsers(@PathParam("name") String name){
    
    return super.findAllUsers(name);
    
    }
   @GET
   @Path("SearchEmail/{email}")
   @Produces({"application/xml", "application/json"})
    public List<Users> searchEmail(@PathParam("email") String email){
    
    return super.findAllEmails(email);
    
    }
    
    
    @GET
   @Path("SearchBlood/{blood}")
   @Produces({"application/xml", "application/json"})
    public List<Users> searchBloodType(@PathParam("blood") String blood){
    
    return super.findAllBlood(blood);
    
    }
    
    @GET
   @Path("SearchCities/{city}")
   @Produces({"application/xml", "application/json"})
    public List<Users> searchCities(@PathParam("city") String city){
    
    return super.findAllCities(city);
    
    }
    
    
 // UPDATE 
@GET
@Path("EditUserName/{id}/{name}")
@Produces({"text/plain"})
public String update (@PathParam("id") Integer id , @PathParam("name") String name){
Users user = super.find(id);
user.setUserName(name);
    try {
        getEntityManager().merge(user);
        return "username is Edited";
    } catch (Exception e) {
    return "Not Edited";
    }
}


// UPDATE 
@GET
@Path("EditEmail/{id}/{email}")
@Produces({"text/plain"})
public String updateEmail (@PathParam("id") Integer id , @PathParam("email") String email){
Users user = super.find(id);
user.setEmail(email);
    try {
        getEntityManager().merge(user);
        return "Email is Edited";
    } catch (Exception e) {
    return "Not Edited";
    }
}
// UPDATE 
@GET
@Path("ChangePassword/{id}/{pass}")
@Produces({"text/plain"})
public String updatePassword (@PathParam("id") Integer id , @PathParam("pass") String pass){
Users user = super.find(id);
user.setPaswword(pass);
    try {
        getEntityManager().merge(user);
        return "Password is Edited";
    } catch (Exception e) {
    return "Not Edited";
    }
}    
    @GET
    @Path("{from}/{to}")
    @Produces({"application/xml", "application/json"})
    public List<Users> findRange(@PathParam("from") Integer from, @PathParam("to") Integer to) {
        return super.findRange(new int[]{from, to});
    }

    @GET
    @Path("count")
    @Produces("text/plain")
    public String countREST() {
        return String.valueOf(super.count());
    }

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }
    
}
