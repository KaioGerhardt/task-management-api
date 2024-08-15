package com.example.task_management.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import com.example.task_management.repository.UserRepository;
import com.example.task_management.model.User;
import java.util.List;
import java.util.Optional;

@Service
public class UserService {

    @Autowired
    public UserRepository userRepository;

    public ResponseEntity<List<User>> getAllUsers(){
        List<User> users = userRepository.findAll();
        return new ResponseEntity<>(users, HttpStatus.OK);
    }

    public ResponseEntity<User> createUser(User user){
        User userCreated = userRepository.save(user);
        return new ResponseEntity<>(userCreated, HttpStatus.CREATED);
    }

    public ResponseEntity<User> getUserById(Long id){
        return userRepository.findById(id)
            .map(user -> new ResponseEntity<>(user, HttpStatus.OK))
            .orElse(new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }

    public ResponseEntity<User> updateUser(Long id, User user){
        Optional<User> userFind = userRepository.findById(id);

        if(userFind.isPresent()){
            User userData = userFind.get();

            userData.setName(user.getName());
            userData.setEmail(user.getEmail());
            userData.setUserName(user.getUserName());
            userData.setBirthDate(user.getBirthDate());
            userData.setIsActive(user.getIsActive());
            
            return new ResponseEntity<>(userRepository.save(userData), HttpStatus.OK);
        }else{
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    public ResponseEntity  deleteUser(Long id){
        Optional<User> userFind = userRepository.findById(id);

        if(userFind.isPresent()){
            userRepository.deleteById(id);
            return new ResponseEntity<>(HttpStatus.OK);
        }else{
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }
}