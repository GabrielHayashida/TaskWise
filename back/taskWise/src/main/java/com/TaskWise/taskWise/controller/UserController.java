package com.TaskWise.taskWise.controller;

import com.TaskWise.taskWise.repository.UserRepository;
import com.TaskWise.taskWise.user.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/users")
public class UserController {
    @Autowired
    private UserRepository userRepository;

    @PostMapping("/register")
    private ResponseEntity registerUser(@RequestBody User user){
         this.userRepository.save(user);
         return ResponseEntity.ok().build();
    }
    @PostMapping("/login")
    private String loginUser(@RequestBody User user){
        UserDetails user2 = userRepository.findByEmail(user.getEmail());
        if (user2.getPassword().equals(user.getPassword())){
            return "Usuário logado com sucesso";
        }
        else return "Credenciais inválidas";
    }
}
