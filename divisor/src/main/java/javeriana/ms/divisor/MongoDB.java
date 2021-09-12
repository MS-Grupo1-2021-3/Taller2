package javeriana.ms.divisor;

import java.net.UnknownHostException;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import com.google.gson.Gson;
import com.mongodb.BasicDBObject;
import com.mongodb.DB;
import com.mongodb.DBCursor;
import com.mongodb.DBObject;
import com.mongodb.MongoClient;
import com.mongodb.util.JSON;

import org.springframework.stereotype.Repository;

@Repository
public class MongoDB {

    MongoClient mongoClient;
    DB operationsDatabase;

    public MongoDB() throws UnknownHostException {
        mongoClient = new MongoClient();
        operationsDatabase = mongoClient.getDB("operations");
    }
    
    public void save(String user, String operation) {
        Gson gson = new Gson();
        BasicDBObject person = (BasicDBObject)JSON.parse(gson.toJson(new Log(user, LocalDateTime.now().toString())));
        operationsDatabase.getCollection(operation).insert(person);
    }
    
    public ResponseLog getDocuments(String operation) {
        List<Log> logs = new ArrayList<>();
        DBCursor iterDoc = operationsDatabase.getCollection(operation).find();
        Iterator<DBObject> it = iterDoc.iterator();
        while (it.hasNext()) {
            DBObject dbobj = it.next();
            Log log = (new Gson()).fromJson(dbobj.toString(), Log.class);
            logs.add(log);
        }
        ResponseLog res = new ResponseLog();
        res.setList(logs);
        return res;
    }
    
}
