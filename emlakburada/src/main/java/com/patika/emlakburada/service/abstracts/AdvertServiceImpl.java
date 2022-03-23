package com.patika.emlakburada.service.abstracts;

import com.patika.emlakburada.exception.EmlakBuradaException;
import com.patika.emlakburada.model.request.AdvertRequest;
import com.patika.emlakburada.model.response.AdvertResponse;

import java.util.List;

public interface AdvertServiceImpl {

    AdvertResponse create(AdvertRequest advertRequest) throws EmlakBuradaException;

    List<AdvertResponse> findAll() throws EmlakBuradaException;

    AdvertResponse update(Long id, AdvertRequest advertRequest) throws EmlakBuradaException;

    Boolean delete(Long id) throws EmlakBuradaException;

    AdvertResponse advertStatusActive(Long id, AdvertRequest advertRequest) throws EmlakBuradaException;

    AdvertResponse advertStatusPassive(Long id, AdvertRequest advertRequest) throws EmlakBuradaException;
}
