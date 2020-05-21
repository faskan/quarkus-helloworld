package org.faskan;

import javax.enterprise.context.ApplicationScoped;

@ApplicationScoped
public class MessageSaveService {

    public void saveMessage(Message message) {
        personMessage(message).persistOrUpdate();
    }

    private PersonMessage personMessage(Message message) {
        PersonMessage personMessage = new PersonMessage();
        personMessage.id = message.receiver;
        personMessage.messageFromPeople.add(messageFromPerson(message));
        return personMessage;
    }

    private MessageFromPerson messageFromPerson(Message message) {
        MessageFromPerson messageFromPerson = new MessageFromPerson();
        messageFromPerson.personId = message.sender;
        messageFromPerson.messageList.add(getIndividualMessage(message));
        return messageFromPerson;
    }

    private IndividualMessage getIndividualMessage(Message message) {
        IndividualMessage individualMessage = new IndividualMessage();
        individualMessage.message = message.message;
        return individualMessage;
    }
}

