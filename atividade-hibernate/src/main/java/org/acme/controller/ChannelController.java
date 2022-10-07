package org.acme.controller;

import org.acme.model.Channel;
import org.acme.model.User;

import javax.transaction.Transactional;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import java.util.List;

@Path("/channel")
@Transactional
public class ChannelController {

    @GET
    @Path("/save/{hash}")
    @Produces(MediaType.APPLICATION_JSON)
    public Channel save(@PathParam("hash") String hash) {
        Channel channel = new Channel();
        channel.setHash(hash);
        channel.persist();
        return channel;
    }

    @GET
    @Path("/add/{idChannel}/{idUser}")
    @Produces(MediaType.APPLICATION_JSON)
    public User add(@PathParam("idChannel") Long idChannel, @PathParam("idUser") Long idUser) {

        Channel channel = Channel.findById(idChannel);
        if (channel == null)
            throw new BadRequestException("Channel not found");

        User user = User.findById(idUser);
        if (user == null)
            throw new BadRequestException("User not found");

        channel.addUser(user);
        user.addChannel(channel);

        user.persist();

        return user;
    }

    @GET
    @Path("/list")
    @Produces(MediaType.APPLICATION_JSON)
    public List<Channel> list() {
        return Channel.listAll();
    }
}
