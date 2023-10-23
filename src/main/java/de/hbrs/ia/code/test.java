package de.hbrs.ia.code;

import static com.mongodb.client.model.Filters.eq;
import org.bson.Document;
import com.mongodb.client.MongoClient;
import com.mongodb.client.MongoClients;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;
import de.hbrs.ia.code.ManagePersonal; // warum muss ich von de anfngen zu impotieren?

public class test {
    public static void main(String [] args){
        String uri = "mongodb+srv://omsuz321:ACT1Ja6mAQfdqWjL@cluster0.bjlxtjb.mongodb.net/";
        try (MongoClient mongoClient = MongoClients.create(uri)) {
            MongoDatabase database = mongoClient.getDatabase("integration_architecture");
            MongoCollection<Document> collection = database.getCollection("test");
            Document doc = collection.find(eq("alter", "12")).first(); // eq für "equals" ist die abfrage bedingung. erste parameter collectionname
                                                                                      // zweit dient als vergleichswert. Mengenwertige ückgabe möglich
            if (doc != null) {
                System.out.println(doc.toJson());
            } else {
                System.out.println("No matching documents found.");
            }
        }

    }
    
    
}
