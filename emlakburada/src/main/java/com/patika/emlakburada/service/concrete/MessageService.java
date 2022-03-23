package com.patika.emlakburada.service.concrete;

import com.patika.emlakburada.exception.EmlakBuradaException;
import com.patika.emlakburada.model.entity.Message;
import com.patika.emlakburada.model.request.MessageRequest;
import com.patika.emlakburada.model.response.MessageResponse;
import com.patika.emlakburada.repository.MessageRepository;
import com.patika.emlakburada.service.abstracts.MessageServiceImpl;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Optional;

@Service
public class MessageService implements MessageServiceImpl {

    @Autowired
    ModelMapper modelMapper;

    @Autowired
    MessageRepository messageRepository;

    @Override
    public MessageResponse create(MessageRequest messageRequest) throws EmlakBuradaException {
        Message message = modelMapper.map(messageRequest,Message.class);
        message = messageRepository.saveAndFlush(message);
        return modelMapper.map(message,MessageResponse.class);
    }

    @Override
    public List<MessageResponse> findAll() throws EmlakBuradaException {
        List<MessageResponse> messageResponseList = new ArrayList<>();
        List<Message> messageList = messageRepository.findAll();
        for (Message message : messageList) {
            messageResponseList.add(modelMapper.map(message,MessageResponse.class));
        }
        return messageResponseList;
    }

    @Override
    public MessageResponse update(Long id, MessageRequest messageRequest) throws EmlakBuradaException {
        try {
            Optional<Message> messageOptional = messageRepository.findById(id);
            if(messageOptional.isPresent()){
                Message message = messageOptional.get();
                message.setTitle(messageRequest.getTitle());
                message.setCustomer(messageRequest.getCustomer());
                message.setDesription(messageRequest.getDesription());
                message.setStatus(true);
                return modelMapper.map(message,MessageResponse.class);
            }
        }catch (Exception e){
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public Boolean delete(Long id) throws EmlakBuradaException {
        try{
            Optional<Message> messageOptional = messageRepository.findById(id);
            if(messageOptional.isPresent()){
                Message message = messageOptional.get();
                message.setStatus(false);
                return true;
            }
        }catch (Exception e){
            e.printStackTrace();
        }
        return false;
    }
}
