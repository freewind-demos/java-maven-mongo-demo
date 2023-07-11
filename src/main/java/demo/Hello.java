package demo;

import com.mongodb.client.*;
import org.bson.Document;


public class Hello {

    public static void main(String[] args) {
        String connectionString = "mongodb://demo:12345678@docdb-2023-07-11-13-15-59.cgg49lhoiw0o.us-east-1.docdb.amazonaws.com:27017/?ssl=true&ssl_ca_certs=global-bundle.gem&retryWrites=false";
        try (MongoClient client = MongoClients.create(connectionString)) {
            MongoDatabase db = client.getDatabase("testDb");

            MongoCollection<Document> users = db.getCollection("users");

            long id = System.currentTimeMillis();
            users.insertOne(createUser(id));
            users.insertOne(createUser(id + 1));
            users.insertOne(createUser(id + 2));

            Document query = new Document();
            query.put("id", id + 1);
            FindIterable<Document> result = users.find(query);
            result.forEach(System.out::println);
        }

    }

    private static Document createUser(long id) {
        Document doc = new Document();
        doc.put("id", id);
        doc.put("name", "aaa" + id);
        doc.put("email", "aaa" + id + "@test.com");
        doc.put("age", 111);
        return doc;
    }

}
