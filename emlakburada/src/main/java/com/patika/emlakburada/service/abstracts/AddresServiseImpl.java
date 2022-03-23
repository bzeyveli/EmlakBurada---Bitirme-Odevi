package com.patika.emlakburada.service.abstracts;

import com.patika.emlakburada.exception.EmlakBuradaException;
import com.patika.emlakburada.model.request.AddressRequest;
import com.patika.emlakburada.model.response.AddressResponse;

import java.util.List;

public interface AddresServiseImpl {

    AddressResponse create(AddressRequest addressRequest) throws EmlakBuradaException;

    List<AddressResponse> findAll() throws EmlakBuradaException;

    AddressResponse update(Long id, AddressRequest addressRequest) throws EmlakBuradaException;

    Boolean delete(Long id) throws EmlakBuradaException;
}
