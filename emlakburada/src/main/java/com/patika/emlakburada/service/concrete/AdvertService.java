package com.patika.emlakburada.service.concrete;

import com.patika.emlakburada.exception.EmlakBuradaException;
import com.patika.emlakburada.model.entity.Advert;
import com.patika.emlakburada.model.enums.Status;
import com.patika.emlakburada.model.request.AdvertRequest;
import com.patika.emlakburada.model.response.AdvertResponse;
import com.patika.emlakburada.repository.AdvertRepository;
import com.patika.emlakburada.service.abstracts.AdvertServiceImpl;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class AdvertService implements AdvertServiceImpl {

    @Autowired
    ModelMapper modelMapper;

    @Autowired
    AdvertRepository advertRepository;

    @Autowired
    ErrorLogService errorLogService;

    @Override
    public AdvertResponse create(AdvertRequest advertRequest) throws EmlakBuradaException {
        Advert advert = modelMapper.map(advertRequest,Advert.class);
        try {
            advert = advertRepository.saveAndFlush(advert);
        }catch (Exception e){
            e.printStackTrace();
        }
        return modelMapper.map(advert,AdvertResponse.class);
    }

    @Override
    public List<AdvertResponse> findAll() throws EmlakBuradaException {
        List<AdvertResponse> advertResponseList = new ArrayList<>();
        try {
            List<Advert> advertList = advertRepository.findAll();
            for (Advert advert : advertList) {
                advertResponseList.add(modelMapper.map(advert, AdvertResponse.class));
            }
        }catch (Exception e){
            e.printStackTrace();
        }
        return advertResponseList;
    }

    @Override
    public AdvertResponse update(Long id, AdvertRequest advertRequest) throws EmlakBuradaException {
       try {
         Optional<Advert> advertOptional = advertRepository.findById(id);
         if(advertOptional.isPresent()){
             Advert advert = advertOptional.get();
             advert.setUser(advertRequest.getUser());
             advert.setAddress(advertRequest.getAddress());
             advert.setTitle(advertRequest.getTitle());
             advert.setPrice(advertRequest.getPrice());
             advert.setStatus(Status.INREVIEW);
             advert = advertRepository.saveAndFlush(advert);
             return modelMapper.map(advert,AdvertResponse.class);
         }
       } catch (Exception e){
           e.printStackTrace();
       }
        return null;
    }

    @Override
    public Boolean delete(Long id) throws EmlakBuradaException {
       Optional<Advert> advertOptional = advertRepository.findById(id);
       if (advertOptional.isPresent()){
           Advert advert = advertOptional.get();
           advert.setStatus(Status.PASSIVE);
           advertRepository.saveAndFlush(advert);
           return true;
       }
       return false;
    }

    // İlanı aktif yapma
    @Override
    public AdvertResponse advertStatusActive(Long id, AdvertRequest advertRequest) throws EmlakBuradaException {
        Optional<Advert> advertOptional = advertRepository.findById(id);
        if(advertOptional.isPresent()){
            Advert advert = advertOptional.get();
            advert.setStatus(Status.ACTIVE);
            advert = advertRepository.saveAndFlush(advert);
            return modelMapper.map(advert,AdvertResponse.class);
        }
        return null;
    }

    @Override
    public AdvertResponse advertStatusPassive(Long id, AdvertRequest advertRequest) throws EmlakBuradaException {
        Optional<Advert> advertOptional = advertRepository.findById(id);
        if(advertOptional.isPresent()){
            Advert advert = advertOptional.get();
            advert.setStatus(Status.PASSIVE);
            advert = advertRepository.saveAndFlush(advert);
            return modelMapper.map(advert,AdvertResponse.class);
        }
        return null;
    }
}
