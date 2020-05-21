package org.faskan;

import io.quarkus.mongodb.panache.MongoEntity;
import io.quarkus.mongodb.panache.PanacheMongoEntity;
import org.bson.types.ObjectId;

import java.util.ArrayList;
import java.util.List;

@MongoEntity(collection = "PersonMessage")
public class PersonMessage extends PanacheMongoEntity {
    public String id;
    public List<MessageFromPerson> messageFromPeople = new ArrayList<>();
}
