package com.nick.service;

import com.nick.domain.chapter5.Address;
import com.nick.domain.chapter5.User;
import com.nick.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class UserService {

    @Autowired
    private UserRepository userRepository;

    public void createUser() {
        User a = new User();
        a.setFirstName("Nick");
        a.setLastName("Liu");

        Address addr = new Address("st", "85034", "sh");
        a.setHomeAddress(addr);

        userRepository.save(a);
    }
}
