package io.learning.jpaapp.service;

import io.learning.jpaapp.domain.Author;
import io.learning.jpaapp.exceptions.AuthorNotFoundExceptions;
import io.learning.jpaapp.repo.AuthRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class AuthService {

    @Autowired
    AuthRepo authRepo;

    public List<Author> getAllAuthor(){
        return authRepo.findAll();
    }

    public Author getAuthorById(long id){
        Optional<Author> byId = authRepo.findById(id);
        if(byId.isPresent()){
            return byId.get();
        }else{
            throw new AuthorNotFoundExceptions("Author not found of id " + id);
        }
    }

    public Author createAuthor(Author author){
        if(author.getName() == null){
            throw new AuthorNotFoundExceptions("Please enter the name");
        }
        return authRepo.save(author);
    }
}
