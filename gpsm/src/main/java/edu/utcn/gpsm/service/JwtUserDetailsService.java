package edu.utcn.gpsm.service;

import edu.utcn.gpsm.user.UserDAO;
import edu.utcn.gpsm.user.UserDTO;
import edu.utcn.gpsm.user.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Random;

@Service
public class JwtUserDetailsService implements UserDetailsService {

    @Autowired
    private UserRepository userDao;

    @Autowired
    private PasswordEncoder bcryptEncoder;


    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        UserDAO userDAO = userDao.findByUsername(username);
        if (userDAO == null) {
            throw new UsernameNotFoundException("User not found with username: " + username);
        }
        return new  org.springframework.security.core.userdetails.User(userDAO.getUsername(), userDAO.getPassword(),
                new ArrayList<>());
    }

    public UserDAO save(UserDTO user) {
        UserDAO newUserDAO = new UserDAO();
        newUserDAO.setId(new Random().nextInt());
        newUserDAO.setUsername(user.getUsername());
        newUserDAO.setPassword(bcryptEncoder.encode(user.getPassword()));
        return userDao.save(newUserDAO);
    }
}