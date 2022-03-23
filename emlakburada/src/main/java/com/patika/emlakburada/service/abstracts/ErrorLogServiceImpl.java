package com.patika.emlakburada.service.abstracts;


public interface ErrorLogServiceImpl {

    void add(String email,String description, String message);

    void add(String description, String message);
}
