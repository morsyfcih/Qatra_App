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
import models.Requests;

/**
 *
 * @author Morsy
 */
@Stateless
@Path("models.requests")
public class RequestsFacadeREST extends AbstractFacade<Requests> {
    @PersistenceContext(unitName = "Qatra_servicesPU")
    private EntityManager em;

    public RequestsFacadeREST() {
        super(Requests.class);
    }

    @POST
    @Override
    @Consumes({"application/xml", "application/json"})
    public void create(Requests entity) {
        super.create(entity);
    }

    @PUT
    @Path("{id}")
    @Consumes({"application/xml", "application/json"})
    public void edit(@PathParam("id") Integer id, Requests entity) {
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
    public Requests find(@PathParam("id") Integer id) {
        return super.find(id);
    }

    @GET
    @Override
    @Produces({"application/xml", "application/json"})
    public List<Requests> findAll() {
        return super.findAll();
    }
//search
@GET
@Path("SearchPost/{post}")
@Produces({"application/xml", "application/json"})
    public List<Requests> searchPost(@PathParam("post") String post){
    
    return super.findAllRequests(post);
    
    }

// UPDATE 
@GET
@Path("EditPost/{id}/{post}")
@Produces({"text/plain"})
public String update (@PathParam("id") Integer id , @PathParam("post") String post){
Requests request = super.find(id);
request.setPost(post);
    try {
        getEntityManager().merge(request);
        return "Post is Edited";
    } catch (Exception e) {
    return "Not Edited";
    }
}
    
    
    @GET
    @Path("{from}/{to}")
    @Produces({"application/xml", "application/json"})
    public List<Requests> findRange(@PathParam("from") Integer from, @PathParam("to") Integer to) {
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
