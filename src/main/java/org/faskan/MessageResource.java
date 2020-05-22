package org.faskan;

import javax.inject.Inject;
import javax.ws.rs.*;

import java.util.List;

import static javax.ws.rs.core.MediaType.APPLICATION_JSON;

@Path("/message")
@Produces(APPLICATION_JSON)
@Consumes(APPLICATION_JSON)
public class MessageResource {

    @Inject
    MessageSaveService messageSaveService;

    @Inject
    ReadMessageService readMessageService;

    @POST
    public void newMessage(Message message) {
        messageSaveService.saveMessage(message);
    }

    @GET
    @Path("/{receiver}")
    public List<IndividualMessage> getMessages(@PathParam("receiver") String receiver) {
        return readMessageService.readMessagesFor(receiver);
    }
}