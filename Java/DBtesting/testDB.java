import con.mongodb.MongoClient;
import con.mongodb.client.MongoDatabase;
import org.bson.Document;

class testDB
{

    public static void main()
    {
        try
        {
            MongoClient mongoClient = new MongoClient();

            MongoDatabase db = mongoClient.getDatabase("sharonDB");
            System.out.println("Connected to database successfully");

            boolean auth = db.authenticate("nookie","MpKz8ekNYo");
            System.out.println("Authentication:" + auth);
        }
        catch(Exception e)
        {
            System.out.println("FAILURE");
        }



    }
}
