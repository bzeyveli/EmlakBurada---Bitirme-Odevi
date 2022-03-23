package com.patika.emlakburada.service.concrete;

import com.patika.emlakburada.exception.EmlakBuradaException;
import com.patika.emlakburada.model.entity.Address;
import com.patika.emlakburada.model.request.AddressRequest;
import com.patika.emlakburada.model.response.AddressResponse;
import com.patika.emlakburada.repository.AddressRepository;
import com.patika.emlakburada.service.abstracts.AddresServiseImpl;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class AddressService implements AddresServiseImpl {

    @Autowired
    AddressRepository addressRepository;

    @Autowired
    ModelMapper modelMapper;

    @Autowired
    ErrorLogService errorLogService;

    @Override
    public AddressResponse create(AddressRequest addressRequest) throws EmlakBuradaException {
        Address address = modelMapper.map(addressRequest,Address.class);
        try {
            address = addressRepository.saveAndFlush(address);
        }catch (Exception e){
            errorLogService.add("","Address kaydedilirken bir hata meydana geldi","Error");
        }
        return modelMapper.map(address,AddressResponse.class);
    }

    @Override
    public List<AddressResponse> findAll() throws EmlakBuradaException {
        List<Address> addressList = addressRepository.findAll();
        List<AddressResponse> addressResponses =new ArrayList<>();
        for (Address address: addressList) {
            addressResponses.add(modelMapper.map(address,AddressResponse.class));
        }
        return addressResponses;
    }

    @Override
    public AddressResponse update(Long id, AddressRequest addressRequest) throws EmlakBuradaException {
        Optional<Address> addressOptional = addressRepository.findById(id);
        if(addressOptional.isPresent()){
            Address address = addressOptional.get();
            address.setDistrict(addressRequest.getDistrict());
            address.setDescription(addressRequest.getDescription());
            address.setCounty(addressRequest.getCounty());
            address.setStatus(true);
            address = addressRepository.saveAndFlush(address);
            return modelMapper.map(address,AddressResponse.class);
        }
        return null;
    }

    @Override
    public Boolean delete(Long id) throws EmlakBuradaException {
        Optional<Address> addressOptional = addressRepository.findById(id);
        if(addressOptional.isPresent()){
            Address address = addressOptional.get();
            address.setStatus(false);
            addressRepository.saveAndFlush(address);
            return true;
        }
        return false;
    }
}
