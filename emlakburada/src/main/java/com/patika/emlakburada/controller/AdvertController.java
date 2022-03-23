package com.patika.emlakburada.controller;

import com.patika.emlakburada.exception.EmlakBuradaException;
import com.patika.emlakburada.model.request.AdvertRequest;
import com.patika.emlakburada.model.request.UserRequest;
import com.patika.emlakburada.model.response.AdvertResponse;
import com.patika.emlakburada.model.response.UserResponse;
import com.patika.emlakburada.service.abstracts.AdvertServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/adverts")
public class AdvertController {

    @Autowired
    AdvertServiceImpl advertService;

    @PostMapping
    public ResponseEntity<AdvertResponse> create(@RequestBody AdvertRequest advertRequest) throws EmlakBuradaException {
        AdvertResponse advertResponse = advertService.create(advertRequest);
        return ResponseEntity.ok(advertResponse);
    }

    @GetMapping
    public ResponseEntity<List<AdvertResponse>> findAll() throws EmlakBuradaException {
        List<AdvertResponse> advertResponseList = advertService.findAll();
        return ResponseEntity.ok(advertResponseList);
    }

    @PutMapping("/{id}")
    public ResponseEntity<AdvertResponse> update(@PathVariable("id") Long id, @RequestBody AdvertRequest advertRequest) throws EmlakBuradaException{
        AdvertResponse advertResponse = advertService.update(id, advertRequest);
        return ResponseEntity.ok(advertResponse);
    }

    @DeleteMapping("/{id}")
    public Boolean delete(@PathVariable("id") Long id) throws EmlakBuradaException {
        Boolean result = advertService.delete(id);
        return result;
    }

    @PutMapping("/active/{id}")
    public AdvertResponse  advertStatusActive(@PathVariable("id") Long id, @RequestBody AdvertRequest advertRequest) throws EmlakBuradaException{
        return advertService.advertStatusActive(id,advertRequest);
    }

    @PutMapping("/passive/{id}")
    public AdvertResponse  advertStatusPassive(@PathVariable("id") Long id, @RequestBody AdvertRequest advertRequest) throws EmlakBuradaException{
        return advertService.advertStatusPassive(id,advertRequest);
    }
}
