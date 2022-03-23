package com.patika.emlakburada.service.concrete;

import com.patika.emlakburada.model.entity.ErrorLog;
import com.patika.emlakburada.repository.ErrorLogRepository;
import com.patika.emlakburada.service.abstracts.ErrorLogServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;

@Service
public class ErrorLogService implements ErrorLogServiceImpl {

    @Autowired
    ErrorLogRepository errorLogRepository;

    @Override
    public void add(String email,String description, String message) {

        ErrorLog errorLog = new ErrorLog();
        errorLog.setEmail(email);
        errorLog.setDescription(description);
        errorLog.setMessage(message);
        errorLog.setErrorDate(new Date());
       errorLogRepository.saveAndFlush(errorLog);
    }

    @Override
    public void add(String description, String message) {
        ErrorLog errorLog = new ErrorLog();
        errorLog.setDescription(description);
        errorLog.setMessage(message);
        errorLogRepository.saveAndFlush(errorLog);
    }
}
