package com.felipeleres.flcommerce.controllers;


import com.felipeleres.flcommerce.dto.CategoryDTO;
import com.felipeleres.flcommerce.services.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping(value= "/categories")
public class CategoryController {

    @Autowired
    private CategoryService categoryService;


    @GetMapping
    public ResponseEntity<List<CategoryDTO>> findAll () {
        List<CategoryDTO> dto =  categoryService.findAll();
        return ResponseEntity.ok(dto);
    }


}
