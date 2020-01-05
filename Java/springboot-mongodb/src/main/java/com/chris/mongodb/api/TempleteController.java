package com.chris.mongodb.api;

import com.chris.mongodb.model.UserModel;
import com.google.gson.Gson;
import com.mongodb.client.FindIterable;
import com.mongodb.client.MongoCursor;
import org.bson.Document;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Create by Chris Chan
 * Create on 2020/1/5 12:31
 * Use for: MongoTemplate模式
 */
@RestController
@RequestMapping("/temp")
public class TempleteController {
    @Autowired
    MongoTemplate mongoTemplate;

    private static Gson gson = new Gson();

    @GetMapping("/add")
    public String addDocument() {
        Map<String, Object> map = new HashMap<String, Object>(16);
        map.put("name", "孙悟空");
        map.put("age", 400);
        mongoTemplate.getCollection("user").insertOne(new Document(map));
        return "add success.";
    }

    @GetMapping("/findAll")
    public List<UserModel> getDocuments() {
        FindIterable<Document> documents = mongoTemplate.getCollection("user").find();
        MongoCursor<Document> iterator = documents.iterator();
        List<UserModel> userModelList = new ArrayList<>(16);
        while (iterator.hasNext()) {
            Document document = iterator.next();
            document.remove("_id");
            String json = document.toJson();
            UserModel userModel = gson.fromJson(json, UserModel.class);
            userModelList.add(userModel);
        }
        return userModelList;
    }

}
