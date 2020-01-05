package com.chris.mongodb;

import com.chris.mongodb.model.User;
import com.google.gson.Gson;
import com.mongodb.MongoClient;
import com.mongodb.client.*;
import org.bson.Document;

import java.util.HashMap;
import java.util.Map;

/**
 * Create by Chris Chan
 * Create on 2020/1/5 10:58
 * Use for:
 */
public class MainTest {
    private static Gson gson = new Gson();

    public static void main(String[] args) {
        //创建客户端
        MongoClient mongoClient = new MongoClient("192.168.0.101", 27017);

        createDocument(mongoClient);
        findDocument(mongoClient);
    }

    /**
     * 查找文档
     *
     * @param mongoClient
     */
    private static void findDocument(MongoClient mongoClient) {
        MongoDatabase database = mongoClient.getDatabase("db_test");
        MongoCollection<Document> collection = database.getCollection("user");

        FindIterable<Document> documents = collection.find();
        MongoCursor<Document> iterator = documents.iterator();
        while (iterator.hasNext()) {
            System.out.println(iterator.next().toJson());
        }
    }

    /**
     * 创建文档
     *
     * @param mongoClient
     */
    private static void createDocument(MongoClient mongoClient) {
        MongoDatabase database = mongoClient.getDatabase("db_test");
        MongoCollection<Document> collection = database.getCollection("user");
        long count = collection.countDocuments();
        System.out.println(count);

        Map<String, Object> map = new HashMap<String, Object>();
        map.put("name", "chris chan");
        map.put("age", 40);
        collection.insertOne(new Document(map));
        collection.insertOne(Document.parse(new Gson().toJson(User.create("feifei", 38))));
        String value = gson.toJson(User.create("shihan", 38));
        System.out.println(value);
        collection.insertOne(Document.parse(value));

        System.out.println(collection.countDocuments());
    }

    /**
     * 创建集合
     *
     * @param mongoClient
     */
    private static void createCollection(MongoClient mongoClient) {
        MongoDatabase database = mongoClient.getDatabase("db_test");
        database.createCollection("user");
        MongoIterable<String> collectionNames = database.listCollectionNames();
        MongoCursor<String> iterator = collectionNames.iterator();
        while (iterator.hasNext()) {
            System.out.println(iterator.next());
        }
    }

    /**
     * 创建数据库
     * 在其下要创建集合才有用
     *
     * @param mongoClient
     */
    private static void createDatabase(MongoClient mongoClient) {
        mongoClient.getDatabase("db_test");
        showDatabaseNames(mongoClient);
    }

    /**
     * 查看所有数据库名
     *
     * @param mongoClient
     */
    private static void showDatabaseNames(MongoClient mongoClient) {
        MongoIterable<String> databaseNames = mongoClient.listDatabaseNames();
        MongoCursor<String> iterator = databaseNames.iterator();
        while (iterator.hasNext()) {
            System.out.println(iterator.next());
        }

    }
}
