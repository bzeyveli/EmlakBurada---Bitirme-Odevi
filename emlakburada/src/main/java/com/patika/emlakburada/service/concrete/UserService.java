package com.patika.emlakburada.service.concrete;

import com.patika.emlakburada.exception.EmlakBuradaException;
import com.patika.emlakburada.model.entity.User;
import com.patika.emlakburada.model.enums.Status;
import com.patika.emlakburada.model.request.UserRequest;
import com.patika.emlakburada.model.response.UserResponse;
import com.patika.emlakburada.repository.UserRepository;
import com.patika.emlakburada.service.abstracts.ErrorLogServiceImpl;
import com.patika.emlakburada.service.abstracts.UserServiseImpl;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class UserService implements UserServiseImpl {

    @Autowired
    UserRepository userRepository;

    @Autowired
    ModelMapper modelMapper;

    @Autowired
    ErrorLogServiceImpl errorLogService;

    @Override
    public UserResponse create(UserRequest userRequest)  throws EmlakBuradaException {
       Optional<User> userRequest1 = userRepository.findByEmail(userRequest.getEmail());
        if(!userRequest1.isPresent()){
            User user = modelMapper.map(userRequest,User.class);
            user = userRepository.saveAndFlush(user);
            return modelMapper.map(user,UserResponse.class);
        }else {
            errorLogService.add(userRequest.getEmail(),"Kullanıcı kayıt edilmedi","Email adresi ile daha önce kayıt yapılmış");
        }
        return null;
    }

    @Override
    public List<UserResponse> findAll()  throws EmlakBuradaException{
      List<User> users = userRepository.findAll();
      List<UserResponse> userResponseList = new ArrayList<>();
        for (User user:users) {
            userResponseList.add(modelMapper.map(user,UserResponse.class));
        }
        return userResponseList;
    }

    @Override
    public UserResponse update(Long id, UserRequest userRequest)  throws EmlakBuradaException{
       Optional<User> userOptional = userRepository.findById(id);
       if(userOptional.isPresent()){
           User user = userOptional.get();
           user.setEmail(userRequest.getEmail());
           user.setUserType(userRequest.getUserType());
           user.setName(userRequest.getName());
           user = userRepository.saveAndFlush(user);
           return modelMapper.map(user,UserResponse.class);
       }else{
           errorLogService.add(userRequest.getEmail(), "Güncelleme başarısız oldu...","ERROR");
       }
       return null;
    }

    @Override
    public boolean delete(Long id)  throws EmlakBuradaException{
        Optional<User> userOptional = userRepository.findById(id);
        if (userOptional.isPresent()){
            User user = userOptional.get();
            user.setIsDeleted(false);
            userRepository.saveAndFlush(user);
            return true;
        } else{
         errorLogService.add(userOptional.get().getEmail(),"Kullanıcı silinemedi","Delete");
        }
        return false;
    }
}
