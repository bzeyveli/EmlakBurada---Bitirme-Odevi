package com.patika.emlakburada.controller;

import com.patika.emlakburada.exception.EmlakBuradaException;
import com.patika.emlakburada.model.request.UserRequest;
import com.patika.emlakburada.model.response.UserResponse;
import com.patika.emlakburada.service.abstracts.UserServiseImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/users")
public class UserController {

    @Autowired
    UserServiseImpl userServise;

    @PostMapping
    @PreAuthorize("hasAnyRole('CORPORATE','INDIVIDUAL')") //Bütün Kullanıcılar sisteme kayıt olabilir.
    public ResponseEntity<UserResponse> create(@RequestBody UserRequest userRequest) throws EmlakBuradaException {
        UserResponse userResponse = userServise.create(userRequest);
        return ResponseEntity.ok(userResponse);
    }

    @GetMapping
    public ResponseEntity<List<UserResponse>> findAll() throws EmlakBuradaException {
        List<UserResponse> userResponses = userServise.findAll();
        return ResponseEntity.ok(userResponses);
    }

    @PutMapping("/{id}")
    @PreAuthorize("hasAnyRole('CORPORATE','INDIVIDUAL')")
    public ResponseEntity<UserResponse> update(@PathVariable("id") Long id, @RequestBody UserRequest userRequest) throws EmlakBuradaException{
        UserResponse userResponses = userServise.update(id, userRequest);
        return ResponseEntity.ok(userResponses);
    }

    @DeleteMapping("/{id}")
    @PreAuthorize("hasAnyRole('CORPORATE','INDIVIDUAL')")
    public Boolean delete(@PathVariable("id") Long id) throws EmlakBuradaException {
        Boolean result = userServise.delete(id);
        return result;
    }

}
