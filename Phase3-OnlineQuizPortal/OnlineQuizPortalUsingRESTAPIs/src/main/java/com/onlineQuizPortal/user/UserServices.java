package com.onlineQuizPortal.user;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.List;


@Service
public class UserServices {
    @Autowired
    UserJPARepo userRepo;

    private RestTemplate userServiceRESTTemplate = new RestTemplate();

    //add person
    public UserObject addUser(UserObject person) {
        return userRepo.save(person);
    }

    public List<UserObject> findByUsername(String Username) {
        return  userRepo.findByUsername(Username);
    }
}
