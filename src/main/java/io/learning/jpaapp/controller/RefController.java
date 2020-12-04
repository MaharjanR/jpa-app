package io.learning.jpaapp.controller;

import io.learning.jpaapp.domain.RefData;
import io.learning.jpaapp.exceptions.RefDataExceptions;
import io.learning.jpaapp.repo.RefRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/ref")
public class RefController {

    @Autowired
    private RefRepo refRepo;

    @GetMapping
    public List<RefData> findAll(){
        return refRepo.findAll();
    }

    @PostMapping
    public void create(){
        throw new RefDataExceptions("Method not implemented");
    }
}
