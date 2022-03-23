package com.patika.emlakburada.service.abstracts;

import com.patika.emlakburada.exception.EmlakBuradaException;
import com.patika.emlakburada.model.request.UserRequest;
import com.patika.emlakburada.model.response.UserResponse;

import java.util.List;

public interface UserServiseImpl {

    UserResponse create(UserRequest userRequest) throws EmlakBuradaException;

    List<UserResponse> findAll() throws EmlakBuradaException;

    UserResponse update(Long id, UserRequest userRequest) throws EmlakBuradaException;

    boolean delete(Long id) throws EmlakBuradaException;
}
