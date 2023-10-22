package de.hbrs.ia.code;

import static com.mongodb.client.model.Filters.eq;
import org.bson.Document;
import com.mongodb.client.MongoClient;
import com.mongodb.client.MongoClients;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;


public class test {
    public static void main(String[] args){
        String uri = "mongodb+srv://omsuz321:<keepass>@cluster0.bjlxtjb.mongodb.net/?retryWrites=true&w=majority";
        try (MongoClient mongoClient = MongoClients.create(uri)) {
            MongoDatabase database = mongoClient.getDatabase("integration_architectrue");
            MongoCollection<Document> collection = database.getCollection("test");
            Document doc = collection.find(eq("alter", "12")).first();
            if (doc != null) {
                System.out.println(doc.toJson());
            } else {
                System.out.println("No matching documents found.");
            }
        }

    }
    
    
}
