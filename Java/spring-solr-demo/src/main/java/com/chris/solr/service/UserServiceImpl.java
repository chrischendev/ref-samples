package com.chris.solr.service;

import com.chris.solr.dao.UserDataSourceImpl;
import com.chris.solr.dao.UserRepository;
import com.chris.solr.model.User;
import com.chris.solr.model.UserModel;
import org.apache.solr.client.solrj.SolrClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author chrischan
 * create on 2019/6/25 15:34
 * use for:
 */
@Service
public class UserServiceImpl implements UserService {
    @Autowired
    SolrClient solrClient;
    @Autowired
    UserDataSourceImpl userDataSource;
    @Autowired
    UserRepository userRepository;

    @Override
    public boolean addUserList(List<User> userList) {
        //方案 1
        userRepository.saveAll(userList);//不成功
        return true;
        //方案 2
//        try {
//            UpdateResponse response = solrClient.addBeans(userModelList);
//            solrClient.commit();
//            return true;
//        } catch (SolrServerException e) {
//            e.printStackTrace();
//        } catch (IOException e) {
//            e.printStackTrace();
//        }
//        return false;
    }

    @Override
    public boolean addUsers() {
        List<User> userList = userDataSource.getUserList();
        return addUserList(userList);
    }
}
