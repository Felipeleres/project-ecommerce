package com.felipeleres.flcommerce.services;

import com.felipeleres.flcommerce.entities.Role;
import com.felipeleres.flcommerce.entities.User;
import com.felipeleres.flcommerce.services.exceptions.ForbiddenException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AuthService {

    @Autowired
    private UserService userService;

    public void validateSelfOrAdmin(long userID){
        User me = userService.authenticated();
            if(!me.hasRole("ROLE_ADMIN") && !me.getId().equals(userID)){
                throw new ForbiddenException("Access denied!");
            }
        }

}
