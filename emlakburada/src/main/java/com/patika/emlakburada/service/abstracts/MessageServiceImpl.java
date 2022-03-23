package com.patika.emlakburada.service.abstracts;

import com.patika.emlakburada.exception.EmlakBuradaException;
import com.patika.emlakburada.model.request.MessageRequest;
import com.patika.emlakburada.model.response.MessageResponse;

import java.util.List;

public interface MessageServiceImpl {

    MessageResponse create(MessageRequest messageRequest) throws EmlakBuradaException;

    List<MessageResponse> findAll() throws EmlakBuradaException;

    MessageResponse update(Long id, MessageRequest messageRequest) throws EmlakBuradaException;

    Boolean delete(Long id) throws EmlakBuradaException;
}
