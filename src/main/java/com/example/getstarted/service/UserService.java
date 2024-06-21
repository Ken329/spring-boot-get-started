package com.example.getstarted.service;

import com.example.getstarted.data.User;
//import com.example.userManagementWithMongoDB.data.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;
import java.util.ArrayList;

@Service
public class UserService {

//    @Autowired
//    private UserRepository userRepository;

    final private List<User> dataUser = new ArrayList<>();


    public List<User> getAllUser(){
        return dataUser;
    }

    public User createUser(User user){
        dataUser.add(user);
        return user;
    }

//    public User updateUser(User user){
//
//        return userRepository.save(user);
//    }

    public String deleteUserById(@PathVariable String id){
        boolean found = false;
        for(int i=0; i<dataUser.size(); i++){
            System.out.println(dataUser.get(i).toString());
            if(dataUser.get(i).getId().equals(id)){
                dataUser.remove(i);
                found = true;
            }
        }
        if(found){
            return "User with id " + id + " was deleted";
        }
        return "User not found";
    }
}