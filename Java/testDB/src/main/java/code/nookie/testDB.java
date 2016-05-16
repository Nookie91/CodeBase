package code.nookie;

import static com.mongodb.client.model.Filters.*;

import java.util.ArrayList;
import java.util.StringTokenizer;

import com.mongodb.client.FindIterable;

import org.bson.Document;
import org.bson.conversions.Bson;

import com.mongodb.BasicDBObject;
import com.mongodb.MongoClient;
import com.mongodb.MongoCredential;
import com.mongodb.MongoException;
import com.mongodb.MongoWriteException;
import com.mongodb.ServerAddress;
import com.mongodb.client.MongoDatabase;
import com.mongodb.client.model.IndexOptions;

class testDB
{

    public static void main(String[] args)
    {
        try
        {
            MongoCredential mc = MongoCredential.createCredential("nookie","admin","MpKz8ekNYo".toCharArray());
            MongoClient mongoClient;// = new MongoClient();
            mongoClient = new MongoClient(new ServerAddress("localhost", 27017),java.util.Arrays.asList(mc));


            MongoDatabase db = mongoClient.getDatabase("sharonDB");
            System.out.println("Connected to database successfully");

            //boolean auth = db.authenticate("nookie","MpKz8ekNYo");
            //System.out.println("Authentication:" + auth);
        }
        catch(Exception e)
        {
            System.out.println("FAILURE");
        }


        System.out.println("EOF");
    }
}
