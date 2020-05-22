package org.faskan;

import io.quarkus.mongodb.panache.MongoEntity;
import io.quarkus.mongodb.panache.PanacheMongoEntity;

import java.util.List;

@MongoEntity(collection = "Messages")
public class IndividualMessage extends PanacheMongoEntity {
    public String receiver;
    public String sender;
    public String message;
    public Status status;

    public static List<IndividualMessage> findMessagesFor(String receiver) {
        return list("receiver = ?1 and status = ?2", receiver, Status.SENT);
    }

    public static void updateStatus(String receiver) {
        update("status = ?1", Status.RECEIVED).where("receiver = ?1", receiver);
    }

}

enum Status {
    SENT,
    RECEIVED
}