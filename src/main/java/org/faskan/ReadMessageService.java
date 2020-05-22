package org.faskan;

import javax.enterprise.context.ApplicationScoped;
import java.util.List;

import static java.util.concurrent.CompletableFuture.runAsync;

@ApplicationScoped
public class ReadMessageService {

    public List<IndividualMessage> readMessagesFor(String receiver) {
        List<IndividualMessage> messages = IndividualMessage.findMessagesFor(receiver);
        runAsync(() -> IndividualMessage.updateStatus(receiver));
        return messages;
    }
}
