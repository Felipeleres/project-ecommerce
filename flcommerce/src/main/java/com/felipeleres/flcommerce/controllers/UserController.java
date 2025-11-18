package com.felipeleres.flcommerce.controllers;


import com.felipeleres.flcommerce.dto.ProductDTO;
import com.felipeleres.flcommerce.dto.UserDTO;
import com.felipeleres.flcommerce.services.ProductService;
import com.felipeleres.flcommerce.services.UserService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;

@RestController
@RequestMapping(value= "/users")
public class UserController {

    @Autowired
    private UserService userService;

    @PreAuthorize("hasAnyRole('ROLE_ADMIN','ROLE_CLIENT')")
    @GetMapping(value = "/me")
    public ResponseEntity<UserDTO> getMe () {
        UserDTO userDTO = userService.getMe();
        return ResponseEntity.ok(userDTO);
    }



}
