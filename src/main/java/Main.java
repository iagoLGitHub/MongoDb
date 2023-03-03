import com.mongodb.MongoClient;
import com.mongodb.client.MongoDatabase;

public class Main {


    public static void main(String[]args){

        MongoClient clienteMongo=new MongoClient("localhost");
        MongoDatabase db=clienteMongo.getDatabase()

    }
}
