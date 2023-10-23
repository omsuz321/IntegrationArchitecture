package de.hbrs.ia.code;

import java.sql.DatabaseMetaData;
import java.util.ArrayList;
import java.util.List;
import static com.mongodb.client.model.Filters.eq;

import com.mongodb.client.*;
import de.hbrs.ia.model.SalesMan;
import org.bson.Document;

import javax.print.Doc;


public class SalesManager implements ManagePersonal {
    private MongoDatabase database;
    private MongoCollection<Document> generalSalesManData;
    private MongoCollection<Document> pefromanceRecord;
    public SalesManager(String password){
            MongoClient client = MongoClients.create("mongodb+srv://omsuz321:" + password + "@cluster0.bjlxtjb.mongodb.net/");
            database = client.getDatabase("integration_architecture");
            pefromanceRecord = database.getCollection("pefromanceRecord");
            generalSalesManData = database.getCollection("generalSalesManData");


    }




    @Override
    public void createSalesMan(SalesMan record) {
        generalSalesManData.insertOne(record.toDocument());
    }

    /**
     *  first nimmt das erte element aus dem ggf. mengenweriten return von find
     *
     *
     * @param sid
     * @return
     */
    @Override
    /**
     * beause i only want to get a list of id, i cann statically promt the attribute name of the list
     * the list returns one salsemen, because the attribute in the database is a primary key
     *
     * can not use qureySalesmen because the is a ineger but querySalesman gets a String as "key"
     */
    public SalesMan readSalesMan(int sid) {
        Document doc = generalSalesManData.find(eq("id",sid)).first();
        return new SalesMan(doc.getString("firstname"),doc.getString("lastname"), doc.getInteger("id"));
    }

    /**
     *
     * @param attribute name of the column in the collection in mongodb
     * @param key for the value for compersion the data wihin column with
     * @return a list of salsemen that wiht the same value as the key comperaed inside the considered column
     */
    @Override
    public List<SalesMan> querySalesMan(String attribute, String key) {
        FindIterable<Document> result = generalSalesManData.find(eq(attribute, key));
        List<SalesMan> salesMens = new ArrayList<>();
       for(Document doc: result){ // insert the created salesmen by usuing the fatched doc´s to the list
            salesMens.add(new SalesMan(doc.getString("firstname"), doc.getString("lastname"), doc.getInteger("id")));
       }
       return salesMens;
    }

    public static void main(String[] args){
        SalesMan s = new SalesMan("Moatez","chaouch", 21);
        SalesManager manager = new SalesManager("ACT1Ja6mAQfdqWjL");
        manager.createSalesMan(s);
        s = manager.readSalesMan(21);
        System.out.println(s.getFirstname());
        System.out.println(manager.querySalesMan("id","21")); // weil intern die id als int gespeichert wird, kanna m
                                                                            // mit query nicht den aufruf tätigen

    }



}

//wie kann man das mit try chat machen, so dass der client länger leben bleibt

