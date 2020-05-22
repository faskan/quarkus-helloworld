package org.faskan;

import javax.enterprise.context.ApplicationScoped;

@ApplicationScoped
public class MessageSaveService {

    public void saveMessage(Message message) {
        individualMessage(message).persist();
    }

    private IndividualMessage individualMessage(Message message) {
        IndividualMessage individualMessage = new IndividualMessage();
        individualMessage.sender = message.sender;
        individualMessage.receiver = message.receiver;
        individualMessage.message = message.message;
        individualMessage.status = Status.SENT;
        return individualMessage;
    }


}

