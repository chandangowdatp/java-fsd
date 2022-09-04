package com.onlineQuizPortal.user;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequestMapping("/user")
public class UserController {
    @Autowired
    UserServices userServices;

    // to handle signup api
    @PostMapping("/signUp")
    public ResponseEntity<Object> signUp(@RequestBody UserObject user){
        try {
            UserObject res = userServices.addUser(user);

            if(res != null) {
                return new ResponseEntity<Object>(res, HttpStatus.CREATED);
            }
            else {
                return new ResponseEntity<Object>("There is some issue, please try again later.", HttpStatus.NO_CONTENT);
            }
        }
        catch (Exception e) {
            return new ResponseEntity<Object>("Facing some issue while trying to create your account, please try with different username.", HttpStatus.BAD_REQUEST);
        }
    }


    // to handle signin api
    @GetMapping("/signIn")
    public ResponseEntity<Object> signIn(@RequestBody UserLoginObject auth) {
        try {
            List<UserObject> user =  userServices.findByUsername(auth.getUsername());
            if(user.size() != 0) {
                if(user.get(0).getPassword().equals(auth.getPassword())){
                    return new ResponseEntity<>(user, HttpStatus.OK);
                }
                else {
                    return new ResponseEntity<>("Incorrect password.",HttpStatus.UNAUTHORIZED);
                }
            }
            else {
                return new ResponseEntity<>("Incorrect username.",HttpStatus.BAD_REQUEST);
            }
        }
        catch (Exception e) {
            System.out.println("exception is : " + e);
            return new ResponseEntity<Object>("There is some issue, please try again later.", HttpStatus.NOT_ACCEPTABLE);
        }
    }
}
