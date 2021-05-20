package com.example.usermanagement.repository;

import com.example.usermanagement.model.User;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import java.util.HashMap;
import java.util.Map;


@Component
public class UserRepository {

    private Map<String, User> userMap;

    @PostConstruct
    public void init(){
        userMap = new HashMap<>();
    }

    public void save(User user){
        userMap.put(user.getId(), user);
    }

    public User findUserById(String id){
        return userMap.get(id);
    }

    public Map<String, User> getUserMap() {
        return userMap;
    }

    public void setUserMap(Map<String, User> userMap) {
        this.userMap = userMap;
    }

}
