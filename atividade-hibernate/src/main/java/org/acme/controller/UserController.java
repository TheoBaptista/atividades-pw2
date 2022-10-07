package org.acme.controller;

import org.acme.model.User;

import javax.transaction.Transactional;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import java.util.List;

@Path("/user")
@Transactional
public class UserController {

    @GET
    @Path("/save/{name}")

    @Produces(MediaType.APPLICATION_JSON)
    public User save(@PathParam("name") String name) {
        User user = new User();
        user.setName(name);
        user.persist();
        return user;
    }

    @GET
    @Path("/list")
    @Produces(MediaType.APPLICATION_JSON)
    public List<User> list() {
        return User.listAll();
    }

    @GET
    @Path("/list/{id}")
    @Produces(MediaType.APPLICATION_JSON)
    public User list(@PathParam("id") Long id) {
        return User.findById(id);
    }

}
