package com.patika.emlakburada.model.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.util.Date;

@Entity
public class ErrorLog{

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String description;

    private String message;  // hatayı nerde aldığımızı belirtmek için kullanıyorum

    private String email;

    private Date errorDate;

    public ErrorLog(String description, String message, String email, Date errorDate) {
        this.description = description;
        this.message = message;
        this.email = email;
        this.errorDate = errorDate;
    }

    public ErrorLog() {
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Date getErrorDate() {
        return errorDate;
    }

    public void setErrorDate(Date errorDate) {
        this.errorDate = errorDate;
    }
}
