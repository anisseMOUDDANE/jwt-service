package com.example.usersmicroservice.services.impl;

import com.example.usersmicroservice.entities.Role;
import com.example.usersmicroservice.entities.User;
import com.example.usersmicroservice.repository.RoleRepository;
import com.example.usersmicroservice.repository.UserRepository;
import com.example.usersmicroservice.services.UserService;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;

@Transactional
@Service
public class UserServiceImpl implements UserService {
    @Autowired
    UserRepository userRep;
    @Autowired
    RoleRepository roleRep;

    @Autowired
    BCryptPasswordEncoder bCryptPasswordEncoder;
    @Override
    public User saveUser(User user) { user.setPassword(bCryptPasswordEncoder.encode(user.getPassword()));
        return userRep.save(user);
    }
    @Override
    public User addRoleToUser(String username, String rolename) { User usr = userRep.findByUsername(username);
        Role r = roleRep.findByRole(rolename);
        usr.getRoles().add(r); return usr;
    }

    @Override
    public List<User> findAllUsers() {
        return userRep.findAll();
    }

    @Override
    public Role addRole(Role role) { return roleRep.save(role);
    }
    @Override
    public User findUserByUsername(String username) { return userRep.findByUsername(username);
    } }

