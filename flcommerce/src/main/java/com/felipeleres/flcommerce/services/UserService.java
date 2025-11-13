package com.felipeleres.flcommerce.services;

import com.felipeleres.flcommerce.entities.Role;
import com.felipeleres.flcommerce.entities.User;
import com.felipeleres.flcommerce.projections.UserDetailsProjection;
import com.felipeleres.flcommerce.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

import java.util.List;

public class UserService implements UserDetailsService {

    @Autowired
    UserRepository userRepository;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {

        List<UserDetailsProjection> result = userRepository.searchUserByNameAndRoles(username);

        if (result.size()==0){
            throw new UsernameNotFoundException("User not found exception!");
        }

        User user = new User();
        user.setEmail(username);
        user.setPassword(result.get(0).getPassword());

        for (UserDetailsProjection x : result){
            user.addRole(new Role(x.getRoleId(),x.getAuthority()));
        }

        return user;
    }
}
