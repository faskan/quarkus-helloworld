package org.faskan;

import javax.inject.Inject;
import javax.ws.rs.Consumes;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;

import static javax.ws.rs.core.MediaType.APPLICATION_JSON;

@Path("/hello")
@Produces(APPLICATION_JSON)
@Consumes(APPLICATION_JSON)
public class ExampleResource {

    @Inject
    MessageSaveService messageSaveService;
    @POST
    public void newMessage(Message message) {
        messageSaveService.saveMessage(message);
    }
}