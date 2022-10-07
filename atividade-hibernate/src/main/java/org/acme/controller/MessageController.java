package org.acme.controller;

import org.acme.model.Message;
import org.acme.model.User;

import javax.transaction.Transactional;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;

@Path("/message")
@Transactional
public class MessageController {

    @GET
    @Path("/save/{text}/{idUser}")
    @Produces(MediaType.APPLICATION_JSON)
    public Message save(@PathParam("text") String text, @PathParam("idUser") Long idUser) {

        Message message = new Message();
        message.setText(text);
        message.persistAndFlush();

        User user = User.findById(idUser);
        if (user == null)
            throw new BadRequestException("User not found");

        user.addMessage(message);
        user.persistAndFlush();

        return message;
    }
}
