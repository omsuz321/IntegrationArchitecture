package de.hbrs.ia.code;

import java.util.List;

import de.hbrs.ia.model.SalesMan;

import static com.mongodb.client.model.Filters.eq;
import org.bson.Document;
import com.mongodb.client.MongoClient;
import com.mongodb.client.MongoClients;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;

public class SalesManager implements ManagePersonal {

    @Override
    public void createSalesMan(SalesMan record) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'createSalesMan'");
    }

    @Override
    public SalesMan readSalesMan(int sid) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'readSalesMan'");
    }

    @Override
    public List<SalesMan> querySalesMan(String attribute, String key) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'querySalesMan'");
    }
    
}
